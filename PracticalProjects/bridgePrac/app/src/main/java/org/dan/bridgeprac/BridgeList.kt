package org.dan.bridgeprac

import android.util.Log
import android.webkit.JavascriptInterface
import org.dan.bridgeprac.webview.CustomWebView

class BridgeList(private val bridgeInterfaceImpl: BridgeInterfaceImpl, val mWebView: CustomWebView) {

    @JavascriptInterface
    fun externalBrowserOpen(url: String){
        Log.e("@javascriptEnabled", "@jsEnabled = externalBrowserOpen")
        bridgeInterfaceImpl.onExternalBrowserOpen(url)
    }
}