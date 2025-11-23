package com.example.weaphones

import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WeaponListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weapon_list)

        val categoryRes = intent.getIntExtra("categoryRes", 0)

        val categoryName = if (categoryRes != 0) getString(categoryRes) else ""

        val categoryText: TextView = findViewById(R.id.categoryTitle)
        categoryText.text = getString(R.string.category_title, categoryName)

        val filteredWeapons = WeaponData.allWeapons.filter { it.categoryRes == categoryRes }

        val listView: ListView = findViewById(R.id.weaponListView)
        val adapter = WeaponAdapter(this, filteredWeapons)
        listView.adapter = adapter
    }
}