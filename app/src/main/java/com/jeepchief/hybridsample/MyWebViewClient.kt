package com.jeepchief.hybridsample

import android.graphics.Bitmap
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class MyWebViewClient : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        Log.e("shouldOverrideUrlLoading()\n${view?.url}")
        return super.shouldOverrideUrlLoading(view, request)
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        Log.e("onPageStarted()\n$url")
        super.onPageStarted(view, url, favicon)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        Log.e("onPageFinished()\n$url")
        super.onPageFinished(view, url)
        view?.loadUrl("javascript:JeepChief.getHtml(document.getElementsByTagName('body')[0].innerHTML);")
    }
}