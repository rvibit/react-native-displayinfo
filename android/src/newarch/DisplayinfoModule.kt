package com.displayinfo

import android.os.Build
import androidx.annotation.RequiresApi
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.WritableArray

class DisplayinfoModule (context: ReactApplicationContext) :
  NativeDisplayinfoSpec(context) {
  private val displayinfoModuleimpl = DisplayinfoModuleimpl(reactApplicationContext)
   override fun getRefreshRate(): Double {
     return  displayinfoModuleimpl.getRefreshRate()
   }

  @RequiresApi(Build.VERSION_CODES.S)
  override fun getAlternativeRefreshRates(): WritableArray {
    return  displayinfoModuleimpl.getAlternativeRefreshRates()
  }

  override fun getAll(): String {
    return displayinfoModuleimpl.getAll();
  }

  override fun getTypedExportedConstants(): MutableMap<String, Any> {
    return displayinfoModuleimpl.getConstants()
  }

  @RequiresApi(Build.VERSION_CODES.O)
  override fun isHdr(): Boolean {
   return displayinfoModuleimpl.isHdr()
  }

}
