package com.reizx.ccdemo

import android.annotation.SuppressLint
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder
import cn.hutool.json.JSONUtil
import com.billy.cc.core.component.CC
import com.billy.cc.core.component.CCResult
import com.billy.cc.core.component.IComponentCallback

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var activity: Activity
    }
    lateinit var unbinder: Unbinder//解绑对象

    @BindView(R.id.btn_exit)
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activity = this
        unbinder = ButterKnife.bind(this)
    }

    @OnClick(R.id.btn_exit)
    fun onExitClick() {
        Log.d("tt", "============================================================")
        CC.obtainBuilder("ac.ktComponent")
            .setActionName("showActivity")
            .build()
            .callAsyncCallbackOnMainThread(printResultCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        unbinder.unbind()
    }


    internal var printResultCallback: IComponentCallback =
        IComponentCallback { cc, result -> showResult(cc, result) }

    private fun showResult(cc: CC, result: CCResult) {
        var text = "result:\n" + JSONUtil.toJsonStr(result.toString())
        text += "\n\n---------------------\n\n"
        text += "cc:\n" + JSONUtil.toJsonStr(cc.toString())
        Log.d("xx", text)
    }

}
