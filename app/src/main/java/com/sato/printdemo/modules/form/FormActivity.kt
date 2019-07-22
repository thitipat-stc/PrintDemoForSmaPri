package com.sato.printdemo.modules.form

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar
import com.sato.printdemo.R
import com.sato.printdemo.dao.smapri.DAOLocalNull
import com.sato.printdemo.modules.setting.SettingsActivity
import com.sato.printdemo.util.Utils
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.activity_home.btn_print
import kotlinx.android.synthetic.main.toolbar.*

class FormActivity : AppCompatActivity(), FormConstructor.FormSetView, View.OnClickListener {

    private lateinit var presenter: FormConstructor.FormSetPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        presenter = FormPresenter(this)
        presenter.getInfo()

        btn_print.setOnClickListener(this)
        ib_settings.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btn_print -> {
                sendItem()
                hideKeyboard(btn_print)
            }
            R.id.ib_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun sendItem() {
        val id: String = edt_pro_id.text.toString().trim()
        val name: String = edt_pro_name.text.toString().trim()
        val price: String = edt_pro_price.text.toString().trim()

        when {
            id.contentEquals("") -> edt_pro_id.error = "Please input id!"
            name.contentEquals("") -> edt_pro_name.error = "Please input name!"
            price.contentEquals("") -> edt_pro_price.error = "Please input price!"
            else -> presenter.printItem(id, name, price)
        }

    }

    override fun getInfoSuccess(body: DAOLocalNull?) {

    }

    override fun showSnackBar(msg: String) {
        Snackbar.make(root_form, msg, Snackbar.LENGTH_LONG).show()
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
