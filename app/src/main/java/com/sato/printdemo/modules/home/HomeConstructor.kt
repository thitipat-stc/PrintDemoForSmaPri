package com.sato.printdemo.modules.home

import com.sato.printdemo.dao.DAOData

class HomeConstructor {
    interface HomeSetPresenter {
        //fun getData()
        fun printItem(message: String)
    }

    interface HomeSetView {
        //fun getDataSuccess(body: DAOData?)
    }
}