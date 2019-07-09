package com.sato.printdemo.dao

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class DAOData(
    @SerializedName("data")
    @Expose
    var data: Data? = null,
    @SerializedName("alert")
    @Expose
    var alert: String? = null,
    @SerializedName("code")
    @Expose
    var code: Integer? = null
)

data class Data(
    @SerializedName("__send_data")
    @Expose
    var sendData: String? = null,
    @SerializedName("__encoding")
    @Expose
    var encoding: String? = null
)
/*
data class DAOData(
    @SerializedName("contacts")
    @Expose
    var contacts: List<Contact>? = null
)

data class Contact(
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("email")
    @Expose
    var email: String? = null,
    @SerializedName("address")
    @Expose
    var address: String? = null,
    @SerializedName("gender")
    @Expose
    var gender: String? = null,
    @SerializedName("phone")
    @Expose
    var phone: Phone? = null
)

class Phone(
    @SerializedName("mobile")
    @Expose
    var mobile: String? = null,
    @SerializedName("home")
    @Expose
    var home: String? = null,
    @SerializedName("office")
    @Expose
    var office: String? = null
)*/
