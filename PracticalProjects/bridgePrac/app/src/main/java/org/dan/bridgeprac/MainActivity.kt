package org.dan.bridgeprac

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebView
import org.dan.bridgeprac.databinding.ActivityMainBinding
import org.dan.bridgeprac.webview.CustomWebChromeClient
import org.dan.bridgeprac.webview.CustomWebView
import org.dan.bridgeprac.webview.CustomWebViewClient

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val mWebView = activityMainBinding.customWebView

        mWebView.run {
            webViewClient = CustomWebViewClient()
            webChromeClient = CustomWebChromeClient()
        }

        activityMainBinding.customWebView.loadTargetUrl("file:///android_asset/bridgeTest.html")
    }
}

