package com.sato.printdemo.util

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("Registered")
class Utils : AppCompatActivity() {

    companion object {
        fun showToast(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }

        const val LOG_TAG = "PrintDemo: "

        const val LABEL_STANDARD = "A" +
                "A3V+00000H+0000CS4#F5" +
                "A1V00719H0440" +
                "Z" +
                "APSWKSampleStandardLabel" +
                "%0H0032V00128L0101P02CEUTF-8SSample Standard Label" +
                "%0H0025V00404FW02H0365%0H0027V00564FW02H0364" +
                "%0H0033V00195L0101P02CEUTF-8SProduct Price:" +
                "%0H0032V00173L0101P02CEUTF-8SProduct Name:" +
                "%0H0033V00154L0101P02CEUTF-8SProduct ID:" +
                "%0H0030V00419L0101P02CEUTF-8SSATO AUTO-ID (THAILAND) CO., LTD." +
                "%0H0030V00449L0101P02CEUTF-8S292/1 Moo 1 Theparak Road, Tumbol" +
                "%0H0030V00464L0101P02CEUTF-8STheparak, Amphur Muang," +
                "%0H0030V00479L0101P02CEUTF-8SSamutprakarn 10270, Thailand" +
                "%0H0030V00509L0101P02CEUTF-8STel:    +662 736 4460" +
                "%0H0030V00524L0101P02CEUTF-8SFax:     +662 736 4461" +
                "%0H0030V00539L0101P02CEUTF-8SE-mail : sales-stc@sato-global.com" +
                "%0H0027V00317L0101P02CEUTF-8SSATO PW208NX" +
                "%0H0027V00332L0101P02CEUTF-8SWIFI/Bluetooth" +
                "%0H0027V00347L0101P02CEUTF-8STest print" +
                "%0H0190V00154L0101P02CEUTF-8S^1$" +
                "%0H0191V00174L0101P02CEUTF-8S^2$" +
                "%0H0190V00195L0101P02CEUTF-8S^3$" +
                "%0H0033V00225BG02030>I12345678>D^1$" +
                "%0H0115V00257P02RDB@0,019,019,^1$" +
                "%0H0215V002982D30,M,03,1,0DN^4$,^5$" +
                "Q1" +
                "Z"

        const val LABEL_PREMIUM = "A" +
                "A3V+00000H+0000CS4#F5" +
                "A1V00719H0440" +
                "Z" +
                "APSWKSamplePremiumLabel" +
                "%0H0032V00128L0101P02CEUTF-8SSample Premium Label" +
                "%0H0025V00404FW02H0365%0H0027V00564FW02H0364" +
                "%0H0033V00195L0101P02CEUTF-8SProduct Price:" +
                "%0H0032V00173L0101P02CEUTF-8SProduct Name:" +
                "%0H0033V00154L0101P02CEUTF-8SProduct ID:" +
                "%0H0030V00419L0101P02CEUTF-8SSATO AUTO-ID (THAILAND) CO., LTD." +
                "%0H0030V00449L0101P02CEUTF-8S292/1 Moo 1 Theparak Road, Tumbol" +
                "%0H0030V00464L0101P02CEUTF-8STheparak, Amphur Muang," +
                "%0H0030V00479L0101P02CEUTF-8SSamutprakarn 10270, Thailand" +
                "%0H0030V00509L0101P02CEUTF-8STel:    +662 736 4460" +
                "%0H0030V00524L0101P02CEUTF-8SFax:     +662 736 4461" +
                "%0H0030V00539L0101P02CEUTF-8SE-mail : sales-stc@sato-global.com" +
                "%0H0027V00317L0101P02CEUTF-8SSATO PW208NX" +
                "%0H0027V00332L0101P02CEUTF-8SWIFI/Bluetooth" +
                "%0H0027V00347L0101P02CEUTF-8STest print" +
                "%0H0190V00154L0101P02CEUTF-8S^1$" +
                "%0H0191V00174L0101P02CEUTF-8S^2$" +
                "%0H0190V00195L0101P02CEUTF-8S^3$" +
                "%0H0033V00225BG02030>I12345678>D^1$" +
                "%0H0115V00257P02RDB@0,019,019,^1$" +
                "%0H0215V002982D30,M,03,1,0DN^4$,^5$" +
                "Q1" +
                "Z"

    }
}