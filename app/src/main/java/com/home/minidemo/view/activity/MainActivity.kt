package com.home.minidemo.view.activity

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.home.minidemo.presenter.GetStoreListPojoStore
import com.home.minidemo.view.adapter.MainAdapter
import com.mini.android.FluxActivity
import kotlinx.android.synthetic.main.activity_main.*
import mini.Dispatcher
import mini.MiniGen


class MainActivity : FluxActivity() {

    override val dispatcher = Dispatcher(MiniGen.actionTypes)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.home.minidemo.R.layout.activity_main)
        modifyStatusBarColor()
        initializeStores()
        startGetStoreListPojoAction()
    }

    @SuppressLint("ObsoleteSdkInt")
    private fun modifyStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = 0x20000000
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initializeStores() {
        val store = GetStoreListPojoStore(dispatcher)
        val stores = listOf(store)
        MiniGen.subscribe(dispatcher, stores).track()
        store.subscribe {
            if (it.state == GetStoreListPojoStore.STARTED) {
                progress_bar.visibility = View.VISIBLE
            } else if (it.state == GetStoreListPojoStore.COMPLETE) {
                progress_bar.visibility = View.GONE
                val adapter = MainAdapter()
                recycler_view.adapter = adapter
                adapter.setPostList(it.store)
            }
        }.track()
    }

    private fun startGetStoreListPojoAction() {
        dispatch(GetStoreListPojoStore.GetStoreListPojoAction())
    }
}

