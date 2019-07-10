package com.sato.printdemo.modules.home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.sato.printdemo.R
import com.sato.printdemo.dao.smapri.DAOLocalNull
import com.sato.printdemo.util.Utils
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeConstructor.HomeSetView, View.OnClickListener {

    private lateinit var presenter: HomeConstructor.HomeSetPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        presenter = HomePresenter(this)
        presenter.getInfo()

        btn_print.setOnClickListener(this)

        setSpinner()

    }


    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btn_print -> {
                sendItem()
            }
        }
    }

    private fun setSpinner() {
        val deviceTypeItems = arrayOf("tcpip", "bluetooth")
        val deviceTypeAdapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, deviceTypeItems)
        spn_device_type.adapter = deviceTypeAdapter

        val protocolItems = arrayOf("status3", "status3_lapin", "status4")
        val protocolAdapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, protocolItems)
        spn_protocol.adapter = protocolAdapter

        val crcItems = arrayOf("false", "true")
        val crcAdapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, crcItems)
        spn_crc.adapter = crcAdapter

        val edt_ip_address = edt_ip_address.text
    }

    private fun sendItem() {
        val message: String = edt_msg.text.toString().trim()
        if (!message.contentEquals("")) {
            presenter.printItem(message)
        } else {
            Utils.showToast(this, "Please input value!")
        }
    }

    @SuppressLint("SetTextI18n")
    override fun getInfoSuccess(body: DAOLocalNull?) {
        tv_info.text = "Response: " +
                "[.@productVersion] ${body?.productVersion}\n" +
                "[message] ${body?.message}\n" +
                "[result] ${body?.result}\n" +
                "[function] ${body?.function}\n" +
                "[.@creationTime] ${body?.creationTime}\n" +
                "[.@productName] ${body?.productName}"

        if (body!!.deviceType!!.contentEquals("tcpip")) {
            println("VVVVVVVVDDD: ${body!!.deviceType}")
        }
    }

}
