package com.sato.printdemo.modules.form

import com.sato.printdemo.dao.smapri.DAOLocalNull

class FormConstructor {
    interface FormSetPresenter {
        fun getInfo()
        fun printItem(_id: String, _name: String, _price: String)
    }

    interface FormSetView {
        fun getInfoSuccess(body: DAOLocalNull?)
        fun showSnackBar(msg: String)
    }
}