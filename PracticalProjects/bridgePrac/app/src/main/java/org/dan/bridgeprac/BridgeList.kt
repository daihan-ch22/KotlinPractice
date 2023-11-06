package org.dan.bridgeprac

import android.app.Activity
import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebView

class BridgeList(private val bridgeInterfaceImpl: BridgeInterfaceImpl, val mWebView: CustomWebView) {

    @JavascriptInterface
    fun externalBrowserOpen(url: String){
        Log.e("@javascriptEnabled", "@jsEnabled = externalBrowserOpen")
        bridgeInterfaceImpl.onExternalBrowserOpen(url)
    }
}