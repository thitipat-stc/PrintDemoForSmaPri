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
                "A3V+00000H+0000CS4#F5A1V00719H0440" +
                "Z" +
                "APSWKSampleStandardLab" +
                "%0H0089V00585L0102P02CEUTF-8SSATO AUTO-ID (THAILAND) CO.,LTD." +
                "%0H0208V00560L0101P02CEUTF-8SSample Standard Label" +
                "%0H0038V00529FW03H0364%0H0042V00135L0101P02CEUTF-8SProduct Price:" +
                "%0H0045V00105L0101P02CEUTF-8SProduct Name:" +
                "%0H0044V00077L0101P02CEUTF-8SProduct ID:" +
                "%0H0043V00235L0101P02CEUTF-8SSATO AUTO-ID (THAILAND) CO., LTD." +
                "%0H0043V00265L0101P02CEUTF-8S292/1 Moo 1 Theparak Road, Tumbol" +
                "%0H0043V00280L0101P02CEUTF-8STheparak, Amphur Muang," +
                "%0H0043V00295L0101P02CEUTF-8SSamutprakarn 10270, Thailand" +
                "%0H0043V00325L0101P02CEUTF-8STel:    +662 736 4460" +
                "%0H0043V00340L0101P02CEUTF-8SFax:     +662 736 4461" +
                "%0H0043V00355L0101P02CEUTF-8SE-mail : sales-stc@sato-global.com" +
                "%0H0103V00393L0101P02CEUTF-8SSATO PW2NX" +
                "%0H0083V00408L0101P02CEUTF-8SWIFI/Bluetooth" +
                "%0H0103V00423L0101P02CEUTF-8STest print" +
                "%0H0060V00463D302036885899858142XS8858998581429" +
                "%0H0198V00078L0101P02CEUTF-8S^1$" +
                "%0H0199V00106L0101P02CEUTF-8S^2$" +
                "%0H0200V00134L0101P02CEUTF-8S^3$" +
                "%0H0059V00167BG03030>H^1$" +
                "%0H0159V00200P02RDB@0,029,029,^1$" +
                "%0H0277V003932D30,M,05,1,0DN^4$,^5$" +
                "Q1" +
                "Z"

        const val LABEL_PREMIUM = "A" +
                "A3V+00000H+0000CS4#F5A1V00719H0440" +
                "Z" +
                "APSWKSamplePremiumLab" +
                "%0H0089V00585L0102P02CEUTF-8SSATO AUTO-ID (THAILAND) CO.,LTD." +
                "%0H0208V00560L0101P02CEUTF-8SSample Premium Label" +
                "%0H0038V00529FW03H0364%0H0042V00135L0101P02CEUTF-8SProduct Price:" +
                "%0H0045V00105L0101P02CEUTF-8SProduct Name:" +
                "%0H0044V00077L0101P02CEUTF-8SProduct ID:" +
                "%0H0043V00235L0101P02CEUTF-8SSATO AUTO-ID (THAILAND) CO., LTD." +
                "%0H0043V00265L0101P02CEUTF-8S292/1 Moo 1 Theparak Road, Tumbol" +
                "%0H0043V00280L0101P02CEUTF-8STheparak, Amphur Muang," +
                "%0H0043V00295L0101P02CEUTF-8SSamutprakarn 10270, Thailand" +
                "%0H0043V00325L0101P02CEUTF-8STel:    +662 736 4460" +
                "%0H0043V00340L0101P02CEUTF-8SFax:     +662 736 4461" +
                "%0H0043V00355L0101P02CEUTF-8SE-mail : sales-stc@sato-global.com" +
                "%0H0103V00393L0101P02CEUTF-8SSATO PW2NX" +
                "%0H0083V00408L0101P02CEUTF-8SWIFI/Bluetooth" +
                "%0H0103V00423L0101P02CEUTF-8STest print" +
                "%0H0060V00463D302036885899858142XS8858998581429" +
                "%0H0198V00078L0101P02CEUTF-8S^1$" +
                "%0H0199V00106L0101P02CEUTF-8S^2$" +
                "%0H0200V00134L0101P02CEUTF-8S^3$" +
                "%0H0059V00167BG03030>H^1$" +
                "%0H0159V00200P02RDB@0,029,029,^1$" +
                "%0H0277V003932D30,M,05,1,0DN^4$,^5$" +
                "Q1" +
                "Z"

        /*"A" +
                "A3V+00000H+0000" +
                "CS4#F5A1V00879H0440" +
                "Z" +
                "APSWKLabel1" +
                "%2H0320V007932D30,M,04,1,0DN0137,PAC01378|Details eg. Paper 3 Set|8.0000|ROLL|PAC013781908170004|||1907-237|DEESIRI TRADING CO. LTD.|Count|1111|1234|2019-08-17|2019-08-17" +
                "%2H0323V005212D30,M,04,1,0DN0150,PAC00079|Details eg. TOOLS BOX|3.0000|BOX|PAC000791908190040|||1002-139|VAIDEE  YEAM LIMITED PARTNERSHIP|Uncount|1002-139|145689|2019-08-19|2019-08-19" +
                "%2H0320V002562D30,M,04,1,0DN0146,PAC00053|Details eg. POTATO|14.0000|KG.|PAC000531908180002|||1001-299|THEPBUNCHON  TRADING  CO. LTD.|Uncount|1001-299|123456|2019-08-18|2019-08-18" +
                "Q1" +
                "Z"*/

        /*const val LABEL_STANDARD = "A" +
                "A3V+00000H+0000CS4#F5A1V00244H0406" +
                "Z" +
                "APSWKSampleStandardLab" +
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
                "Z"*/

    }
}