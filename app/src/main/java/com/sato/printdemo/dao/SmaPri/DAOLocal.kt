package com.sato.printdemo.dao.smapri

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(name = "response", strict = false)
data class DAOLocal(
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
    var deviceType: String = "sato",

    @field:Element(name = "address", required = false)
    var address: String = "sato",

    @field:Element(name = "protocol", required = false)
    var protocol: String = "sato",

    @field:Element(name = "crc", required = false)
    var crc: String = "sato",

    @field:Element(name = "connected", required = false)
    var connected: String = "sato",

    @field:ElementList(name = "bondedBluetoothDevices", required = false, inline = true)
    var bondedBluetoothDevices: List<BondedBluetoothDevicesList>? = null
)

@Root(name = "bondedBluetoothDevices", strict = false)
data class BondedBluetoothDevicesList(
    @field:Attribute(name = "count", required = false)
    var count: String = "sato",

    @field:Attribute(name = "name", required = false)
    var name: String = "sato",

    @field:Element(name = "device", required = false)
    var device: String = "sato"
)


/*
@Suppress("ANNOTATION_TARGETS_NON_EXISTENT_ACCESSOR")
@Root(name = "response", strict = false)
class DAOLocal {

    @get:Attribute(name = "version")
    private val version: String? = null

    */
/*@get:Attribute(name = "productName")
    private val productName: String? = null

    @get:Attribute(name = "productVersion")
    private val productVersion: String? = null

    @get:Attribute(name = "creationTime")
    private val creationTime: String? = null

    @get:Element(name = "result")
    private val result: String? = null

    @get:Element(name = "function")
    private val function: String? = null

    @get:Element(name = "message")
    private val message: String? = null

    @get:Element(name = "deviceType", required = false)
    private val deviceType = "sato"

    @get:Element(name = "address", required = false)
    private val address = "sato"

    @get:Element(name = "protocol", required = false)
    private val protocol = "sato"

    @get:Element(name = "crc", required = false)
    private val crc = "sato"

    @get:Element(name = "connected", required = false)
    private val connected = "sato"

    @get:ElementList(name = "bondedBluetoothDevices", required = false, inline = true)
    private val bondedBluetoothDevices: List<BondedBluetoothDevicesList>? = null

    val response: String
        get() = "$version: $productName: $productVersion: $creationTime: $result: $function: $message: $deviceType: $address: $protocol: $crc: $connected: $bondedBluetoothDevices"*//*


    val response: String
        get() = "$version: $productName: $productVersion: $creationTime: $result: $function: $message: $deviceType: $address: $protocol: $crc: $connected: $bondedBluetoothDevices"

}*/
