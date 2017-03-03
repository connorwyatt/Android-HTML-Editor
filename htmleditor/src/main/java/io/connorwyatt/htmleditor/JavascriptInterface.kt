package io.connorwyatt.htmleditor

import android.webkit.JavascriptInterface

class JavascriptInterface {
  private val contentChangeListeners = mutableListOf<(String) -> Unit>()

  //region Listeners

  public fun addContentChangeListener(contentChangeListener: (String) -> Unit): () -> Unit {
    contentChangeListeners.add(contentChangeListener)

    return { contentChangeListeners.removeAll { it === contentChangeListener } }
  }

  //endregion

  //region JavascriptMethods

  @JavascriptInterface
  public fun onContentChanged(content: String): Unit {
    contentChangeListeners.forEach { it(content) }
  }

  //endregion
}
