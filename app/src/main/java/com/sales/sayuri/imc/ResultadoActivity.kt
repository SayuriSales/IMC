package com.sales.sayuri.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val peso = intent?.getStringExtra("PESO")?.toDouble()
        val altura = intent?.getStringExtra("ALTURA")?.toDouble()

        val imc =peso?.div(altura!!.times(altura))

        tvIMC.setText(imc.toString().substring(0,3))
    }
}
