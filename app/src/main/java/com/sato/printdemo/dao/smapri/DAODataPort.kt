package com.sato.printdemo.dao.smapri

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "response", strict = false)
data class DAODataPort(
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
    var message: String? = null
)
