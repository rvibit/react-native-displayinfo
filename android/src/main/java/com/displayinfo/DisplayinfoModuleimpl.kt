package com.displayinfo


import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.hardware.display.DisplayManager
import android.os.Build
import android.view.Display.DEFAULT_DISPLAY
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import com.facebook.common.internal.DoNotStrip
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.WritableArray
import com.facebook.react.bridge.WritableNativeArray



class DisplayinfoModuleimpl(context: ReactApplicationContext)  {
  val display = context.applicationContext.getSystemService(Context.DISPLAY_SERVICE) as DisplayManager;
  val defaultDisplay = display.getDisplay(DEFAULT_DISPLAY)
  var CONSTANTS: HashMap<String, Any> =
    hashMapOf("ONE" to "one", "TWO" to "two")


  fun getRefreshRate(): Double {
    return defaultDisplay.refreshRate.toDouble()
  }


  fun getAll():String{
    return  defaultDisplay.toString()
  }

  @RequiresApi(Build.VERSION_CODES.S)
  fun getAlternativeRefreshRates():WritableArray{
    val arr: WritableArray = WritableNativeArray()
    defaultDisplay.mode.alternativeRefreshRates.forEach { r -> arr.pushDouble(r.toDouble())  }
    return  arr
  }

  fun getConstants(): MutableMap<String, Any> {
    return CONSTANTS
  }

  @RequiresApi(Build.VERSION_CODES.O)
  fun isHdr():Boolean{
    return defaultDisplay.isHdr
  }
  companion object {
    const val NAME = "Displayinfo"
  }
}
