package com.sato.printdemo.modules.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.sato.printdemo.R
import com.sato.printdemo.dao.smapri.DAOLocalNull
import com.sato.printdemo.util.Utils
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.btn_print

class FormActivity : AppCompatActivity(), FormConstructor.FormSetView, View.OnClickListener {

    private lateinit var presenter: FormConstructor.FormSetPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        presenter = FormPresenter(this)
        presenter.getInfo()

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
        val id: String = edt_pro_id.text.toString().trim()
        val name: String = edt_pro_name.text.toString().trim()
        val price: String = edt_pro_price.text.toString().trim()
        if (id.isNotEmpty() && name.isNotEmpty() && price.isNotEmpty()) {
            presenter.printItem(id, name, price)
        } else {
            Utils.showToast(this, "Please input value!")
        }
    }

    override fun getInfoSuccess(body: DAOLocalNull?) {
        Snackbar.make(root_form, "Success", Snackbar.LENGTH_SHORT).show()
    }

    override fun showSnackBar(msg: String) {
        Snackbar.make(root_form, msg, Snackbar.LENGTH_SHORT).show()
    }

}
