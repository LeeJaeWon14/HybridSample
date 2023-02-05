package com.jeepchief.hybridsample

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

class JSInterface(private val context: Context) {
    @JavascriptInterface
    fun showToast(text: String) = Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}