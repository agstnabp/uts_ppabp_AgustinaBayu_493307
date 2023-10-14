package com.example.uts_bioskop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_bioskop.databinding.ActivityFilm3Binding

class Film3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityFilm3Binding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilm3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            getticket3.setOnClickListener {
                val intent_main = Intent(this@Film3Activity, PaymentActivity::class.java)
                startActivity(intent_main)
            }
        }
    }
}