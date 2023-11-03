package org.dan.bridgeprac

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.webkit.WebView

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
        }
    }

    fun loadTargetUrl(url: String){
        loadUrl(url)
    }
}