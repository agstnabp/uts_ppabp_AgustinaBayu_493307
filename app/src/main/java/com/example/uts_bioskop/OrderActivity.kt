package com.example.uts_bioskop

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.uts_bioskop.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {
    private lateinit var binding:ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityOrderBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Ambil data dari Intent
        val intent = intent
        val namaBioskop = intent.getStringExtra("namaBioskop")
        val jenisSeats = intent.getStringExtra("jenisSeats")
        val tanggal = intent.getStringExtra("tanggal")
        val jam = intent.getIntExtra("jam", 0) // Ambil jam
        val menit = intent.getIntExtra("menit", 0) // Ambil menit
        val bank = intent.getStringExtra("bank")
        val nomorRekening = intent.getStringExtra("nomorRekening")

        // Tampilkan data pada TextView atau elemen UI lainnya
        val textViewBioskop = findViewById<TextView>(R.id.textViewBioskop)
        val textViewJenisSeats = findViewById<TextView>(R.id.textViewJenisSeats)
        val textViewTanggal = findViewById<TextView>(R.id.textViewTanggal)
        val textViewBank = findViewById<TextView>(R.id.textViewBank)
        val textViewHarga = findViewById<TextView>(R.id.textViewHarga)
        val textViewWaktu = findViewById<TextView>(R.id.textViewWaktu)
        // Gabungkan jam dan menit menjadi waktu lengkap
        val waktu = String.format("%02d:%02d", jam, menit)

        textViewBioskop.text = "$namaBioskop"
        textViewJenisSeats.text = "$jenisSeats"
        textViewTanggal.text = "$tanggal"
        textViewWaktu.text = "$waktu"
        textViewBank.text = "$bank"


        val harga: Int = when (jenisSeats) {
            "Regular Seats" -> 35000
            "Premiere Seats" -> 60000
            else -> 0 // Tambahkan logika untuk jenis seats lainnya jika perlu
        }
        textViewHarga.text = "Rp $harga"


    }
}