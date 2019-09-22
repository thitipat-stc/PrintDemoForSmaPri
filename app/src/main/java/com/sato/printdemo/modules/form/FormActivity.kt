package com.sato.printdemo.modules.form

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
        ib_clear_id.setOnClickListener(this)
        ib_clear_name.setOnClickListener(this)
        ib_clear_price.setOnClickListener(this)
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
            R.id.ib_clear_id -> {
                edt_pro_id.setText("")
            }
            R.id.ib_clear_name -> {
                edt_pro_name.setText("")
            }
            R.id.ib_clear_price -> {
                edt_pro_price.setText("")
            }
        }
    }

    override fun onBackPressed() {
        confirm()
    }

    private fun confirm() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("CONFIRM")
        builder.setMessage("Confirm to exit?\n*Please input 1234 in field")
        val view = layoutInflater.inflate(R.layout.alert_confirm_dialog, null)
        val edtConfirm = view.findViewById(R.id.edt_description) as EditText
        builder.setPositiveButton("Ok") { dialogInterface, i ->
            if (edtConfirm.text.toString().contentEquals("1234")) {
                finish()
            } else {
                Toast.makeText(this, "Input incorrect!", Toast.LENGTH_SHORT).show()
            }
        }
        builder.setNegativeButton("Cancel") { dialogInterface, whichButton ->
            dialogInterface.dismiss()
        }
        builder.setView(view)
        builder.show()
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
