package com.displayinfo

import android.os.Build
import androidx.annotation.RequiresApi
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.WritableArray

class DisplayinfoModule internal constructor(context: ReactApplicationContext) :
  ReactContextBaseJavaModule(context) {
  private val displayinfoModuleimpl = DisplayinfoModuleimpl(reactApplicationContext)

  @ReactMethod(isBlockingSynchronousMethod = true)
  fun getRefreshRate(): Double {
    return  displayinfoModuleimpl.getRefreshRate()
  }

  @ReactMethod(isBlockingSynchronousMethod = true)
  @RequiresApi(Build.VERSION_CODES.S)
  fun getAlternativeRefreshRates(): WritableArray {
    return  displayinfoModuleimpl.getAlternativeRefreshRates()
  }

  @ReactMethod(isBlockingSynchronousMethod = true)
  fun getAll(): String {
    return displayinfoModuleimpl.getAll();
  }

  override fun getConstants(): MutableMap<String, Any> {
    return displayinfoModuleimpl.getConstants()
  }

  @ReactMethod(isBlockingSynchronousMethod = true)
  @RequiresApi(Build.VERSION_CODES.O)
  fun isHdr(): Boolean {
    return displayinfoModuleimpl.isHdr()
  }

  override fun getName(): String {
    return DisplayinfoModuleimpl.NAME
  }
}
