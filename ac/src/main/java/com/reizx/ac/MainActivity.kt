package com.reizx.ac

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import butterknife.OnClick

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var activity: Activity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activity = this
    }

    @OnClick(R2.id.btn_exit)
    fun exit() {
        finish()
    }
}
