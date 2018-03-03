package com.sales.sayuri.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.sales.sayuri.imc.extension.format
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val peso = intent?.getStringExtra("PESO")!!.toDouble()
        val altura = intent?.getStringExtra("ALTURA")!!.toDouble()

        //val imc =peso?.div(altura!!.times(altura))
        val imc = peso / (altura*altura)

       // tvIMC.setText(imc.toString().substring(0,3))

            tvIMC.text = imc?.format(2)


        if (imc < 17){
            alterarTextoStatusIMC("Muito abaixo do peso")
            alterarImagemStatusIMC(R.drawable.magreza)
        }else if(imc <= 18.5) {
            alterarTextoStatusIMC("Abaixo do peso")
            alterarImagemStatusIMC(R.drawable.abaixo)
        }else if(imc <= 24.9) {
            alterarTextoStatusIMC("Peso ideal")
            alterarImagemStatusIMC(R.drawable.ideal)
        }else if(imc <= 29.9) {
            alterarTextoStatusIMC("Acima do peso")
            alterarImagemStatusIMC(R.drawable.sobre)
        }else if(imc <= 34.9) {
            alterarTextoStatusIMC("Obesidade")
            alterarImagemStatusIMC(R.drawable.obesidade)
        } else {
            alterarTextoStatusIMC("Obesidade")
            alterarImagemStatusIMC(R.drawable.obesidade)
        }
    }

    fun alterarImagemStatusIMC(idImagem: Int) {
        ivStatusIMC.setImageDrawable(ContextCompat.getDrawable(this, idImagem))
    }
    fun alterarTextoStatusIMC(texto:String) {
        tvStatusIMC.text = texto
    }

}
