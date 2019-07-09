package com.sato.printdemo.dao

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import android.content.ClipData.Item
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList


data class DAOPort(
    @get:Element(name = "response")
    var response: String? = null

)

data class Response(
    @get:Element(name = "-version")
    var version: String? = null,

    @get:Element(name = "-productName")
    var productName: String? = null
)

/*data class DAOPort(
    @SerializedName("response")
    @Expose
    var response: Response? = null
)

data class Response(

    @SerializedName("result")
    @Expose
    var result: String? = null,
    @SerializedName("code")
    @Expose
    var code: String? = null,
    @SerializedName("function")
    @Expose
    var function: String? = null,
    @SerializedName("message")
    @Expose
    var message: String? = null,
    @SerializedName("deviceType")
    @Expose
    var deviceType: String? = null,
    @SerializedName("address")
    @Expose
    var address: String? = null,
    @SerializedName("protocol")
    @Expose
    var protocol: String? = null,
    @SerializedName("crc")
    @Expose
    var crc: String? = null,
    @SerializedName("connected")
    @Expose
    var connected: String? = null,
    @SerializedName("bondedBluetoothDevices")
    @Expose
    var bondedBluetoothDevices: BondedBluetoothDevices? = null,
    @SerializedName("_version")
    @Expose
    var version: String? = null,
    @SerializedName("_productName")
    @Expose
    var productName: String? = null,
    @SerializedName("_productVersion")
    @Expose
    var productVersion: String? = null,
    @SerializedName("_creationTime")
    @Expose
    var creationTime: String? = null

)

class BondedBluetoothDevices(
    @SerializedName("_count")
    @Expose
    var count: String? = null,
    @SerializedName("device")
    @Expose
    var device: Device? = null
)

class Device(
    @SerializedName("_name")
    @Expose
    var name: String? = null,
    @SerializedName("__text")
    @Expose
    var text: String? = null
)*/
