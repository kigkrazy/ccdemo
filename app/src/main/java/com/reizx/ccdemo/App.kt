package com.reizx.ccdemo

import android.app.Application
import com.billy.cc.core.component.CC

class App : Application() {
    companion object {
        var app: App? = null
    }

    override fun onCreate() {
        super.onCreate()
        CC.enableVerboseLog(true)
        CC.enableDebug(true)
        CC.enableRemoteCC(true)
    }
}