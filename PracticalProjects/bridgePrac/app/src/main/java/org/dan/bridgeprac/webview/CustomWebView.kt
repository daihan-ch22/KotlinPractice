package org.dan.bridgeprac.webview

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView
import org.dan.bridgeprac.BridgeInterfaceImpl
import org.dan.bridgeprac.BridgeList

@SuppressLint("SetJavaScriptEnabled")
class CustomWebView(
    context: Context,
    attrs: AttributeSet?,
    defStyle: Int
) : WebView(
    context,
    attrs,
    defStyle
) {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    init{
        val bridgeInterfaceImpl = BridgeInterfaceImpl(context)
        addJavascriptInterface(BridgeList(bridgeInterfaceImpl, this), "native")

        with(settings){
            javaScriptEnabled = true
            domStorageEnabled = true
        }
    }

    fun loadTargetUrl(url: String){
        loadUrl(url)
    }
}