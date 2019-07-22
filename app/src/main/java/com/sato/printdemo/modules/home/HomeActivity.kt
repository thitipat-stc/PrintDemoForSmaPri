package com.sato.printdemo.modules.home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import com.sato.printdemo.R
import com.sato.printdemo.dao.smapri.DAOLocalNull
import com.sato.printdemo.util.Utils
import kotlinx.android.synthetic.main.activity_home.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class HomeActivity : AppCompatActivity(), HomeConstructor.HomeSetView, View.OnClickListener {

    private lateinit var presenter: HomeConstructor.HomeSetPresenter
    private var whichInterface: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        presenter = HomePresenter(this, applicationContext)
        presenter.getInfo()

        btn_print.setOnClickListener(this)
        bth_set_port.setOnClickListener(this)
        spn_device_type.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (spn_device_type.selectedItem) {
                    "tcpip" -> {
                        whichInterface = "tcpip"
                        tv_head_address.text = "IP Address"
                    }
                    "bluetooth" -> {
                        whichInterface = "bluetooth"
                        tv_head_address.text = "BT Address"
                    }
                }
            }
        }
        setSpinner()

    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btn_print -> {
                sendItem()
            }
            R.id.bth_set_port -> {
                sendPort()
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
    }

    private fun sendItem() {
        val message: String = edt_msg.text.toString().trim()
        if (!message.contentEquals("")) {
            presenter.printItem(message)
        } else {
            Utils.showToast(this, "Please check input value!")
        }
    }

    private fun sendPort() {
        if (!edt_ip_address.text.isNullOrEmpty()) {
            val address = edt_ip_address.text.trim()
            when (whichInterface) {
                "tcpip" -> {
                    if (isValidIP(address)) {
                        val ipDeviceType = spn_device_type.selectedItem.toString().trim()
                        val ipAddress = edt_ip_address.text.toString().trim()
                        val ipProtocol = spn_protocol.selectedItem.toString().trim()
                        val idCrc = spn_crc.selectedItem.toString().trim()
                        presenter.setDataPort(ipDeviceType, ipAddress, ipProtocol, idCrc)
                    } else {
                        Snackbar.make(root_home, "IP Address is in a wrong format", Snackbar.LENGTH_LONG).show()
                    }
                }
                "bluetooth" -> {
                    if (isValidBT(address)) {
                        val ipDeviceType = spn_device_type.selectedItem.toString().trim()
                        val ipAddress = edt_ip_address.text.toString().trim()
                        val ipProtocol = spn_protocol.selectedItem.toString().trim()
                        val idCrc = spn_crc.selectedItem.toString().trim()
                        presenter.setDataPort(ipDeviceType, ipAddress, ipProtocol, idCrc)
                    } else {
                        Snackbar.make(root_home, "Bluetooth Address is in a wrong format", Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        } else {
            Snackbar.make(root_home, "The IP/BT Address Field Is Compulsory", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun isValidIP(address: CharSequence): Boolean {
        if (address.isNotEmpty()) {
            val regex =
                "^((25[0-5])|(2[0-4]\\d)|(1\\d\\d)|([1-9]\\d)|\\d)(\\.((25[0-5])|(2[0-4]\\d)|(1\\d\\d)|([1-9]\\d)|\\d)){3}\$"
            return address.matches(regex.toRegex())
        }
        return false
    }

    private fun isValidBT(address: CharSequence): Boolean {
        if (address.isNotEmpty()) {
            val pattern1 = Pattern.compile("^([a-fA-F0-9]{2}[:\\.-]?){5}[a-fA-F0-9]{2}$")
            val pattern2 = Pattern.compile("^([a-fA-F0-9]{3}[:\\.-]?){3}[a-fA-F0-9]{3}$")
            val pattern3 = Pattern.compile("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$")

            val match1: Matcher = pattern1.matcher(address)
            val match2: Matcher = pattern2.matcher(address)
            val match3: Matcher = pattern3.matcher(address)

            return (match1.find() || match2.find() || match3.find())
        }
        return false
    }

    @SuppressLint("SetTextI18n")
    override fun getInfoSuccess(body: DAOLocalNull?) {

        tv_info.text = "Response: " +
                "[.@productVersion] ${body?.productVersion}" +
                "[message] ${body?.message}" +
                "[result] ${body?.result}" +
                "[function] ${body?.function}" +
                "[.@creationTime] ${body?.creationTime}" +
                "[.@productName] ${body?.productName}"

        when (body?.deviceType) {
            "tcpip" -> {
                whichInterface = "tcpip"
                spn_device_type.setSelection(0)
                tv_head_address.text = "IP Address"
                edt_ip_address.setText(body.address!!.trim().substring(0, body.address!!.length - 5))
            }
            "bluetooth" -> {
                whichInterface = "bluetooth"
                spn_device_type.setSelection(1)
                tv_head_address.text = "BT Address"
                edt_ip_address.setText(body.address)
            }
        }

        when (body?.protocol) {
            "status3" -> spn_protocol.setSelection(0)
            "status3_lapin" -> spn_protocol.setSelection(1)
            "status4" -> spn_protocol.setSelection(2)
        }

        when (body?.crc) {
            "false" -> spn_crc.setSelection(0)
            "true" -> spn_crc.setSelection(1)
        }

    }


    override fun showSnackBar() {
        Snackbar.make(root_home, "Success", Snackbar.LENGTH_SHORT).show()
    }

}
