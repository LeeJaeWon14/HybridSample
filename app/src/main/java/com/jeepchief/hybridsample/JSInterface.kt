package com.jeepchief.hybridsample

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

class JSInterface(private val context: Context) {
    @JavascriptInterface
    fun showToast(text: String) = Toast.makeText(context, text, Toast.LENGTH_SHORT).show()

    @JavascriptInterface
    fun getHtml(html: String) {
        Log.e("""
            html source is >>
            $html
        """.trimIndent())
        MainActivity.htmlSource = html
    }
}