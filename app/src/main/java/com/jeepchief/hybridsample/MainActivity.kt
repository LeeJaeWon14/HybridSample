package com.jeepchief.hybridsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import com.jeepchief.hybridsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
        var htmlSource = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            webview.apply {
                webViewClient = MyWebViewClient()
                webChromeClient = MyChromeClient()
                settings.apply {
                    javaScriptEnabled = true
                    loadWithOverviewMode = true
                    useWideViewPort = true
                    cacheMode = WebSettings.LOAD_DEFAULT
//                    textZoom = 95
                }
                addJavascriptInterface(JSInterface(this@MainActivity), "JeepChief")
                loadUrl("file:///android_asset/index.html")
            }

            btnAlert.apply {
                setOnClickListener {
                    webview.loadUrl("javascript:showAlert(\"Hello World!\")")
                }

                setOnLongClickListener {
                    webview.loadUrl("javascript:location.href = \"https://www.naver.com\"")
                    false
                }
            }
        }
    }
}