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

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var activity: Activity
    }

    lateinit var unbinder: Unbinder
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
        Log.d("tt", "============================================================")
        Log.d("tt", "============================================================")
        this.finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        unbinder.unbind()
    }
}
