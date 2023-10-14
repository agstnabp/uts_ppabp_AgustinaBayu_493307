package com.example.uts_bioskop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_bioskop.databinding.ActivityFilm4Binding

class Film4Activity : AppCompatActivity() {
    private lateinit var binding: ActivityFilm4Binding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilm4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            getticket4.setOnClickListener {
                val intent_main = Intent(this@Film4Activity, PaymentActivity::class.java)
                startActivity(intent_main)
            }
        }
    }
}