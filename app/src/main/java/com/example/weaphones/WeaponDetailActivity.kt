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

        // Adatok átvétele
        val name = intent.getStringExtra("name")
        val categoryRes = intent.getIntExtra("categoryRes", 0)
        val caliber = intent.getStringExtra("caliber")

        // FONTOS: getIntExtra-t használunk, mert resource ID-t várunk
        val originRes = intent.getIntExtra("originRes", 0)

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

        // Kategória és Ország nevének lefordítása ID-ból
        val categoryName = if (categoryRes != 0) getString(categoryRes) else ""
        val originName = if (originRes != 0) getString(originRes) else ""

        // Szöveg összeállítása
        detailText.text = """
            ${getString(R.string.detail_category, categoryName)}
            ${getString(R.string.detail_caliber, caliber)}
            ${getString(R.string.detail_origin, originName)}
            ${getString(R.string.detail_manufacturer, manufacturer)}
            ${getString(R.string.detail_year, year)}
            ${getString(R.string.detail_weight, weight)}
            ${getString(R.string.detail_barrel, barrel)}
            ${getString(R.string.detail_rof, rof)}
        """.trimIndent()
    }
}