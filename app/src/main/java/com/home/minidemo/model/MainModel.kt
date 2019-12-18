package com.home.minidemo.model

import com.home.minidemo.model.pojo.GetStoreListPojo

class MainModel {

    fun getStoreListPojo(): GetStoreListPojo {
        val storeList = mutableListOf<GetStoreListPojo.Store>()
        storeList.add(
            GetStoreListPojo.Store(
                "https://app.poya.com.tw/uploads/store/878c39be6f64a45aba68a272db759249.jpg",
                "台北古亭店",
                "臺北市中正區羅斯福路二段100號1樓",
                "02-23659977",
                "10:00am~10:30pm"
            )
        )
        storeList.add(
            GetStoreListPojo.Store(
                "https://app.poya.com.tw/uploads/store/ba9db5e9b8f56ecc3de98f728af1e99a.jpeg",
                "台北林森店",
                "臺北市中山區林森北路487號",
                "02-25620033",
                "10:00am~10:30pm"
            )
        )
        storeList.add(
            GetStoreListPojo.Store(
                "https://app.poya.com.tw/uploads/store/8212c85547fc02b3d5c74147b7b6ee1c.jpg",
                "台北民生店",
                "臺北市松山區民生東路5段163-1號",
                "02-87879900",
                "10:00am~10:00pm"
            )
        )
        storeList.add(
            GetStoreListPojo.Store(
                "https://app.poya.com.tw/uploads/store/5379499bd80a5c761d3c1949afa69d62.jpg",
                "台北東門店",
                "臺北市大安區信義路二段230號B1",
                "02-23956677",
                "10:00am~10:30pm"
            )
        )
        storeList.add(
            GetStoreListPojo.Store(
                "https://app.poya.com.tw/uploads/store/4d2e2b597e6d330517ce571fecb7c2be.jpg",
                "忠孝永春店",
                "臺北市信義區忠孝東路五段297-1號",
                "02-27652323",
                "10:00am~10:30pm"
            )
        )
        return GetStoreListPojo("", storeList)
    }
}