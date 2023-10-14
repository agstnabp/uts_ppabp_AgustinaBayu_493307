package com.example.uts_bioskop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_bioskop.databinding.ActivityFilm1Binding

class Film1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityFilm1Binding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilm1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            getticket1.setOnClickListener {
                val intent_main = Intent(this@Film1Activity, PaymentActivity::class.java)
                startActivity(intent_main)
            }
        }

    }
}