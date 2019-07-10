package com.sato.printdemo.dao.smapri

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(name = "response", strict = false)
data class DAOLocalNull(
    @field:Attribute(name = "version")
    var version: String? = null,

    @field:Attribute(name = "productName")
    var productName: String? = null,

    @field:Attribute(name = "productVersion")
    var productVersion: String? = null,

    @field:Attribute(name = "creationTime")
    var creationTime: String? = null,

    @field:Element(name = "result")
    var result: String? = null,

    @field:Element(name = "function")
    var function: String? = null,

    @field:Element(name = "message")
    var message: String? = null,

    @field:Element(name = "deviceType", required = false)
    //var deviceType: String? = null,
    var deviceType: String? = "tcpip",

    @field:Element(name = "address", required = false)
    var address: String? = "192.168.1.1:9100",

    @field:Element(name = "protocol", required = false)
    var protocol: String? = "status3_lapin",

    @field:Element(name = "crc", required = false)
    var crc: String? = null,

    @field:Element(name = "connected", required = false)
    var connected: String? = null,

    @field:ElementList(name = "bondedBluetoothDevices", required = false, inline = true)
    var bondedBluetoothDevices: List<BondedBluetoothDevicesList>? = null
)

@Root(name = "bondedBluetoothDevices", strict = false)
data class BondedBluetoothDevicesList(
    @field:Attribute(name = "count", required = false)
    var count: String? = null,

    @field:Attribute(name = "name", required = false)
    var name: String? = null,

    @field:Element(name = "device", required = false)
    var device: String? = null
)