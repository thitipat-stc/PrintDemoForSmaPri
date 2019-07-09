package com.sato.printdemo.modules.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.sato.printdemo.R
import com.sato.printdemo.dao.DAOData
import com.sato.printdemo.util.Utils
import kotlinx.android.synthetic.main.activity_home.*
import java.lang.Exception

class HomeActivity : AppCompatActivity(), HomeConstructor.HomeSetView, View.OnClickListener {

    private lateinit var presenter: HomeConstructor.HomeSetPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        presenter = HomePresenter(this)
        //presenter.getData()

        btn_print.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btn_print -> {
                sendItem()
            }
        }
    }

    private fun sendItem() {
        val message: String = edt_msg.text.toString().trim()
        if (!message.contentEquals("")) {
            presenter.printItem(message)
        } else {
            Utils.showToast(this, "Please input value!")
        }
    }

    /*override fun getDataSuccess(body: DAOData?) {
        val size = body?.contacts?.size
        for (i in 0 until size!!) {
            //String s = daoData.getCategories().get(i).getName();
            val name = body.contacts!![i].name
            val gender = body.contacts!![i].phone!!.mobile
            Log.e("sdsdsdsdssdsdsssd", "$name - $gender//")
        }
    }*/

}
