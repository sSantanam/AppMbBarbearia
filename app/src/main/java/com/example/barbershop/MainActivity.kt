package com.example.barbershop

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.barbershop.databinding.ActivityMainBinding
import com.example.barbershop.view.Home
import com.google.android.material.snackbar.Snackbar

class MainActivity<View> : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        binding. btLogin.setOnClickListener{

            val nome =binding.editNome.text.toString()
            val senha =binding.editSenha.text.toString()


            when{

                nome.isEmpty() ->   {
                mensagem( it,"Coloque seu Nome")
                }senha.isEmpty() -> {
                    mensagem(it,"Preencha a senha!")
                }senha. length <=5 ->{
                    mensagem(it,"A senha precisa ter pelos 6 caracteres")
                }else -> {
                    navegarPraHome(nome)
                }

            }
        }
    }

    private fun mensagem(view: android.view.View, mensagem:String ){
        val snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
        snackbar .setBackgroundTint(Color.parseColor("#FF000"))
        snackbar setTxtColor(Color.parseColor("#FFFFFF"))

        snackbar .show()

    }

    private fun navegarPraHome(nome: String){
        val intent =  Intent(this, Home::class.java)
        intent.putExtra("nome",nome)
        startActivity(intent)

    }
}

infix fun Snackbar.setTxtColor(parseColor: Int) {

}







