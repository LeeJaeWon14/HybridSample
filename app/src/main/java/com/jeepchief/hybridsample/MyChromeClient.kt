package com.jeepchief.hybridsample

import android.content.DialogInterface
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import android.webkit.ConsoleMessage
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.drawable.toDrawable

class MyChromeClient : WebChromeClient() {
    companion object val TAG = "Hybrid"
    private var webTitle = ""
    private lateinit var webIcon: Bitmap
    override fun onReceivedTitle(view: WebView?, title: String?) {
        Log.e(TAG, "onReceivedTitle()")
        super.onReceivedTitle(view, title)
        title?.let { webTitle = it }
    }

    override fun onReceivedIcon(view: WebView?, icon: Bitmap?) {
        Log.e(TAG, "onReceivedIcon()")
        super.onReceivedIcon(view, icon)
        icon?.let { webIcon = it }
    }

    override fun onJsAlert(
        view: WebView?,
        url: String?,
        message: String?,
        result: JsResult?
    ): Boolean {
        Log.e(TAG, "onJsAlert()")
        view?.context?.let {
            AlertDialog.Builder(it)
                .setTitle(webTitle)
                .setMessage(message)
//                .setIcon(BitmapDrawable(view.context.resources, webIcon))
                .setPositiveButton("확인") { _, _ -> result?.confirm() }
                .setNegativeButton("취소") { _, _ -> result?.cancel() }
                .show()
        }
        return true
    }

    override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
        return super.onConsoleMessage(consoleMessage)
    }
}