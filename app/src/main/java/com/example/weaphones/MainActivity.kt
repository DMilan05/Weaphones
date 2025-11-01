package com.example.weaphones

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val allWeapons = WeaponData.allWeapons

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.categoryListView)
        val categories = allWeapons.map { it.category }.distinct()

        val adapter = ArrayAdapter(
            this,
            R.layout.item_category,
            R.id.categoryName,
            categories
        )
        listView.adapter = adapter


        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedCategory = categories[position]
            val intent = Intent(this, WeaponListActivity::class.java)
            intent.putExtra("category", selectedCategory)
            startActivity(intent)
        }




    }
}
