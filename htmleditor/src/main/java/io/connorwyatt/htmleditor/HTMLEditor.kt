package io.connorwyatt.htmleditor

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.webkit.WebView

class HTMLEditor : WebView {
  private val javascriptInterface = JavascriptInterface()

  constructor(context: Context?) : super(context)
  constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
    : super(context, attrs, defStyleAttr)

  init {
    initialise();
  }

  private fun initialise(): Unit {
    @SuppressLint("SetJavascriptEnabled")
    settings.javaScriptEnabled = true

    addInterfaceListeners()

    addJavascriptInterface(javascriptInterface, "androidInterface")

    isVerticalScrollBarEnabled = false
    isHorizontalScrollBarEnabled = false

    loadUrl("file:///android_asset/index.html")
  }

  private fun addInterfaceListeners(): Unit {
    javascriptInterface.addContentChangeListener { onContentChange(it) }
  }

  private fun onContentChange(content: String): Unit {
    Log.d("A", content)
  }
}
