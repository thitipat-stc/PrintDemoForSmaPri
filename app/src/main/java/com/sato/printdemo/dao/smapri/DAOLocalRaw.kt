package com.sato.printdemo.dao.smapri

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(name = "response", strict = false)
data class DAOLocalRaw(
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

    @field:ElementList(name = "receiveData", required = false, inline = true)
    var receiveData: ReceiveData? = null
)

@Root(name = "receiveData", strict = false)
data class ReceiveData(

    @field:Attribute(name = "encoding")
    var encoding: String? = null
)