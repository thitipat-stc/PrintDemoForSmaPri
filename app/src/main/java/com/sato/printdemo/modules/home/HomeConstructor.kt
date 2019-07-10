package com.sato.printdemo.modules.home

import com.sato.printdemo.dao.smapri.DAOLocalNull


class HomeConstructor {
    interface HomeSetPresenter {
        fun getInfo()
        fun printItem(message: String)
        fun setDataPort(__device_type: String, __address: String, __protocol: String, __crc: String)
    }

    interface HomeSetView {
        fun getInfoSuccess(body: DAOLocalNull?)
        fun showSnackBar()
    }
}