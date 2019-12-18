package com.home.minidemo.presenter

import com.home.minidemo.model.MainModel
import com.home.minidemo.model.pojo.GetStoreListPojo
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import mini.*

class GetStoreListPojoStore(private val dispatcher: Dispatcher) : Store<GetStoreListPojo>() {

    companion object {
        const val STARTED = "started"
        const val COMPLETE = "complete"
    }

    @Reducer
    suspend fun onGetStoreListPojo(action: GetStoreListPojoAction) {
        try {
            dispatcher.dispatch(GetStoreListPojoStartAction())
            delay(3000)
            dispatcher.dispatch(GetStoreListPojoCompleteAction())
        } catch (ex: Throwable) {
            // Job was cancelled, so we can't dispatch on the same context, start new one
            dispatcher.dispatch(GetStoreListPojoCompleteAction(), Job())
        }
    }

    @Reducer
    fun onGetStoreListPojoStarted(action: GetStoreListPojoStartAction) {
        newState = state.copy(state = STARTED)
    }

    @Reducer
    fun onGetStoreListPojoComplete(action: GetStoreListPojoCompleteAction) {
        val model = MainModel()
        val store = model.getStoreListPojo().store
        newState = state.copy(state = COMPLETE, store = store)
    }

    @Action
    class GetStoreListPojoAction : SagaAction

    @Action
    class GetStoreListPojoStartAction

    @Action
    class GetStoreListPojoCompleteAction
}