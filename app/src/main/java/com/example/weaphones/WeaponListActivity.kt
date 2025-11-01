package com.example.weaphones

import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WeaponListActivity : AppCompatActivity() {

    val allWeapons = WeaponData.allWeapons

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weapon_list)

        val category = intent.getStringExtra("category")
        val categoryText: TextView = findViewById(R.id.categoryTitle)
        val listView: ListView = findViewById(R.id.weaponListView)

        categoryText.text = "Kategória: $category"

        val filteredWeapons = allWeapons.filter { it.category == category }

        val adapter = WeaponAdapter(this, filteredWeapons)
        listView.adapter = adapter
    }
}
