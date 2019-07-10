package com.sato.printdemo.modules.home

import com.sato.printdemo.dao.smapri.DAOLocalNull


class HomeConstructor {
    interface HomeSetPresenter {
        fun getInfo()
        fun printItem(message: String)
    }

    interface HomeSetView {
        fun getInfoSuccess(body: DAOLocalNull?)
        //fun getDataSuccess(body: DAOData?)
    }
}