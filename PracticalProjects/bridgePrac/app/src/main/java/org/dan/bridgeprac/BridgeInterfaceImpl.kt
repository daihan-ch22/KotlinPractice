package org.dan.bridgeprac

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

class BridgeInterfaceImpl(private val mContext: Context): BridgeInterface{

    override fun onExternalBrowserOpen(url: String) {
        Log.e("BRIDGE", "url = $url")
        val uri: Uri = (Uri.parse(url))
        val intent = Intent(Intent.ACTION_VIEW, uri)
        mContext.startActivity(intent)
    }

}