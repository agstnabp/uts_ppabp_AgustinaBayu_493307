package com.example.uts_bioskop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_bioskop.databinding.ActivityFilm2Binding

class Film2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityFilm2Binding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilm2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            getticket2.setOnClickListener {
                val intent_main = Intent(this@Film2Activity, PaymentActivity::class.java)
                startActivity(intent_main)
            }
        }
    }
}