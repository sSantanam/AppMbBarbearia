package com.example.barbershop.view

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.barbershop.databinding.ActivityAgendmentoBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar


class Agendmento : AppCompatActivity() {

    private lateinit var binding: ActivityAgendmentoBinding
    private val calendar: Calendar = Calendar.getInstance()
    private var data: String = ""
    private var hora: String = ""

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendmentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome").toString()

        val dataPicker = binding.datePicker
        dataPicker.setOnDateChangedListener { _, year, month0fYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month0fYear)
            calendar.set(Calendar.DAY_OF_YEAR, dayOfMonth)

            var dia = dayOfMonth.toString()
            val mes: String

            if (dayOfMonth < 10) {
                dia = "0$dayOfMonth"
            }
            if (month0fYear < 10) {
                mes = "" + (month0fYear + 1)
            } else {
                mes = (month0fYear + 1).toString()
            }
            data = "$dia / $mes / $year"

        }

        binding.timerPicker.setOnTimeChangedListener { _, hourOfDay, minute ->
            val minuto: String
            if (minute < 10) {
                minuto = "0$minute"
            } else {
                minuto = minute.toString()
            }
            hora = "$hourOfDay:$minuto"
        }
        binding.timerPicker.setIs24HourView(true)

        binding.btAgendar.setOnClickListener {

            val barbeiro1 = binding.barbeiro1
            val barbeiro2 = binding.barbeiro2
            val barbeiro3 = binding.barbeiro3

            when {
                hora.isEmpty() -> {
                    mensagem(it, "Preencha o horario", "#FF0000")

                }
                hora <"8:00" && hora > "19:00" -> {
                    mensagem(it, "Barber Shop esta fechado - horario de atendimento 8:00 as 19:00!",  "#FF0000")
                }
                data.isEmpty()-> {
                    mensagem(it, "Coloque uma data", "#FF0000")

                }
                barbeiro1.isChecked && data.isNotEmpty() && hora.isNotEmpty()->{
                    mensagem(it, "Agendamento realizado com sucesso", "#FF03DAC5")
                }
                barbeiro2.isChecked && data.isNotEmpty() && hora.isNotEmpty()->{
                    mensagem(it, "Agendamento realizado com sucesso", "#FF03DAC5")
                }
                barbeiro3.isChecked && data.isNotEmpty() && hora.isNotEmpty()->{
                    mensagem(it, "Agendamento realizado com sucesso", "#FF03DAC5")
                }
                else -> {
                    mensagem(it, "Escolhe um barbeiro!", "#FF0000")

                }



            }
        }
    }
    private fun mensagem (view: View, mensagem: String, cor : String){
        val snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
        snackbar .setBackgroundTint(Color.parseColor(cor))
        snackbar .setTextColor(Color.parseColor("#FFFFFF"))
        snackbar .show()
    }



    }



