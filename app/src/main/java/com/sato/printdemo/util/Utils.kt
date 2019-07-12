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
                "A3V+00000H+0000CS4#F5A1V00623H0440Z" +
                "APSWKSampleStandardLa" +
                "%2H0413V00580L0101P02CEUTF-8SSATO AUTO-ID (THAILAND) CO.,LTD." +
                "%2H0413V00551L0101P02CEUTF-8SSample Standard Label" +
                "%0H0020V00520FW03H0394" +
                "%2H0412V00432L0101P02CEUTF-8SProduct Price:" +
                "%2H0414V00456L0101P02CEUTF-8SProduct Name:" +
                "%2H0413V00478L0101P02CEUTF-8SProduct ID:" +
                "%2H0418V00370L0101P02CEUTF-8SLorem13 ipsum dolor sit amet," +
                "%2H0418V00355L0101P02CEUTF-8Sconsectetur adipiscing elit, sed do" +
                "%2H0418V00341L0101P02CEUTF-8Seiusmod tempor incididunt ut labore et" +
                "%2H0418V00326L0101P02CEUTF-8Sdolore magna aliqua. Ut enim ad minim" +
                "%2H0418V00311L0101P02CEUTF-8Sveniam, quis nostrud exercitation" +
                "%2H0418V00296L0101P02CEUTF-8Sullamco laboris nisi ut aliquip ex ea" +
                "%2H0418V00281L0101P02CEUTF-8Scommodo consequat. Duis aute irure" +
                "%2H0418V00266L0101P02CEUTF-8Sdolor in reprehenderit in voluptate" +
                "%2H0418V00251L0101P02CEUTF-8Svelit esse cillum dolore eu fugiat" +
                "%2H0418V00236L0101P02CEUTF-8Snulla pariatur. Excepteur sint" +
                "%2H0418V00221L0101P02CEUTF-8Soccaecat cupidatat non proident, sunt" +
                "%2H0418V00206L0101P02CEUTF-8Sin culpa qui officia deserunt mollit" +
                "%2H0418V00191L0101P02CEUTF-8Sanim id est laborum." +
                "%2H0418V00176L0101P02CEUTF-8SSed ut perspiciatis unde omnis iste" +
                "%2H0418V00161L0101P02CEUTF-8Snatus error sit voluptatem accusantium" +
                "%2H0418V00146L0101P02CEUTF-8Sdoloremque laudantium, totam rem" +
                "%2H0418V00131L0101P02CEUTF-8Saperiam, eaque ipsa quae ab illo" +
                "%2H0418V00116L0101P02CEUTF-8Sinventore veritatis et quasi" +
                "%2H0418V00101L0101P02CEUTF-8Sarchitecto beatae vitae dicta sunt" +
                "%2H0418V00086L0101P02CEUTF-8SLorem13" +
                "%2H0247V00480L0101P02CEUTF-8S^1$" +
                "%2H0247V00457L0101P02CEUTF-8S^2$" +
                "%2H0247V00434L0101P02CEUTF-8S^3$" +
                "%2H0115V004862D30,M,03,1,0DN^4$,^5$" +
                "Q1" +
                "Z"

        const val LABEL_PREMIUM = "A" +
                "A3V+00000H+0000CS4#F5A1V00623H0440Z" +
                "APSWKSamplePremiumLab" +
                "%0H0099V00573L0101P02CEUTF-8SSATO AUTO-ID (THAILAND) CO.,LTD." +
                "%0H0218V00544L0101P02CEUTF-8SSample Premium Label" +
                "%0H0026V00513FW03H0394%0H0022V00107L0101P02CEUTF-8SProduct Price:" +
                "%0H0024V00078L0101P02CEUTF-8SProduct Name:" +
                "%0H0023V00049L0101P02CEUTF-8SProduct ID:" +
                "%0H0023V00157L0101P02CEUTF-8SLorem13 ipsum dolor sit amet," +
                "%0H0023V00172L0101P02CEUTF-8Sconsectetur adipiscing elit, sed do" +
                "%0H0023V00187L0101P02CEUTF-8Seiusmod tempor incididunt ut labore et" +
                "%0H0023V00202L0101P02CEUTF-8Sdolore magna aliqua. Ut enim ad minim" +
                "%0H0023V00216L0101P02CEUTF-8Sveniam, quis nostrud exercitation" +
                "%0H0023V00231L0101P02CEUTF-8Sullamco laboris nisi ut aliquip ex ea" +
                "%0H0023V00246L0101P02CEUTF-8Scommodo consequat. Duis aute irure" +
                "%0H0023V00261L0101P02CEUTF-8Sdolor in reprehenderit in voluptate" +
                "%0H0023V00276L0101P02CEUTF-8Svelit esse cillum dolore eu fugiat" +
                "%0H0023V00291L0101P02CEUTF-8Snulla pariatur. Excepteur sint occaecat" +
                "%0H0023V00306L0101P02CEUTF-8Scupidatat non proident, sunt in culpa" +
                "%0H0023V00321L0101P02CEUTF-8Squi officia deserunt mollit anim id est" +
                "%0H0023V00336L0101P02CEUTF-8Slaborum." +
                "%0H0301V00053L0101P02CEUTF-8S@@@@@@@@@@@" +
                "%0H0301V00068L0101P02CEUTF-8S@@@@@@@@@@@" +
                "%0H0301V00083L0101P02CEUTF-8S@@@@@@@@@@@" +
                "%0H0301V00098L0101P02CEUTF-8S@@@@@@@@@@@" +
                "%0H0301V00113L0101P02CEUTF-8S@@@@@@@@@@@" +
                "%0H0178V00050L0101P02CEUTF-8S^1$" +
                "%0H0179V00079L0101P02CEUTF-8S^2$" +
                "%0H0179V00106L0101P02CEUTF-8S^3$" +
                "%0H0283V003772D30,M,05,1,0DN^4$,^5$" +
                "%0H0190V003782D30,M,03,1,0DN^4$,^5$" +
                "Q1" +
                "Z"

    }
}