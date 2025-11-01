package com.example.weaphones

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WeaponDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weapon_detail)

        val imageView: ImageView = findViewById(R.id.weaponImage)
        val nameTitle: TextView = findViewById(R.id.weaponNameTitle)
        val detailText: TextView = findViewById(R.id.weaponDetailText)

        val name = intent.getStringExtra("name")
        val category = intent.getStringExtra("category")
        val caliber = intent.getStringExtra("caliber")
        val origin = intent.getStringExtra("origin")
        val year = intent.getIntExtra("year", 0)
        val manufacturer = intent.getStringExtra("manufacturer")
        val weight = intent.getDoubleExtra("weight", 0.0)
        val barrel = intent.getIntExtra("barrel", 0)
        val rof = intent.getIntExtra("rof", 0)
        val imageResId = intent.getIntExtra("imageResId", 0)


        nameTitle.text = name
        if (imageResId != 0) {
            imageView.setImageResource(imageResId)
        }


        detailText.text = """
            Kategória: $category
            Kaliber: $caliber
            Származás: $origin
            Gyártó: $manufacturer
            Év: $year
            Tömeg: ${"%.2f".format(weight)} kg
            Csőhossz: $barrel mm
            Tűzgyorsaság: $rof lövés/perc
        """.trimIndent()
    }
}
