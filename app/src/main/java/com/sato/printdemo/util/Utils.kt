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

        /*const val LABEL_STANDARD = "A" +
                "A3V+00000H+0000CS4#F5A1V00244H0406" +
                "Z" +
                "APSWKSampleStandardLa" +
                "%0H0081V00026L0101P02CEUTF-8SSATO DEMO" +
                "%0H0082V00054L0101P02CEUTF-8SMobile Printing" +
                "%0H0090V00204L0101P02CEUTF-8SSample Standard Label" +
                "%0H0086V00081FW02H0227" +
                "%0H0093V00111L0101P02CEUTF-8S^1$" +
                "%0H0092V00139L0101P02CEUTF-8S^2$" +
                "%0H0093V00166L0101P02CEUTF-8S^3$" +
                "%0H0221V000912D30,M,04,1,0DN^4$,^5$" +
                "Q1" +
                "Z"*/

        const val LABEL_STANDARD = "A" +
                "A3V+00000H+0000CS4#F5A1V00244H0406" +
                "Z" +
                "APSWKSamplePremiumLab" +
                "%0H0089V00031L0101P02CEUTF-8SSATO DEMO" +
                "%0H0090V00059L0101P02CEUTF-8SMobile Printing" +
                "%0H0089V00096L0101P02CEUTF-8SSample Premium Label" +
                "%0H0090V00083FW03H0227" +
                "%0H0214V00131L0101P02CEUTF-8S^1$" +
                "%0H0213V00159L0101P02CEUTF-8S^2$" +
                "%0H0214V00186L0101P02CEUTF-8S^3$" +
                "%0H0088V001182D30,M,04,1,0DN^4$,^5$" +
                "Q1" +
                "Z"

        const val LABEL_PREMIUM = "A" +
                "A3V+00000H+0000CS4#F5A1V00244H0406" +
                "Z" +
                "APSWKSamplePremiumLab" +
                "%0H0089V00031L0101P02CEUTF-8SSATO DEMO" +
                "%0H0090V00059L0101P02CEUTF-8SMobile Printing" +
                "%0H0089V00096L0101P02CEUTF-8SSample Premium Label" +
                "%0H0090V00083FW03H0227" +
                "%0H0214V00131L0101P02CEUTF-8S^1$" +
                "%0H0213V00159L0101P02CEUTF-8S^2$" +
                "%0H0214V00186L0101P02CEUTF-8S^3$" +
                "%0H0088V001182D30,M,04,1,0DN^4$,^5$" +
                "Q1" +
                "Z"

    }
}