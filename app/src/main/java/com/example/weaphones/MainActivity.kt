package com.example.weaphones

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val allWeapons = WeaponData.allWeapons

    override fun onCreate(savedInstanceState: Bundle?) {
        LanguageManager.applyLanguage(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<TextView>(R.id.titleText).text = getString(R.string.title_categories)
        findViewById<Button>(R.id.quizButton).text = getString(R.string.btn_start_quiz)
        findViewById<Button>(R.id.btnLeaderboard).text = getString(R.string.btn_leaderboard)


        findViewById<ImageView>(R.id.flagHU).setOnClickListener {
            LanguageManager.setLanguage(this, "hu")
            recreate()
        }

        findViewById<ImageView>(R.id.flagEN).setOnClickListener {
            LanguageManager.setLanguage(this, "en")
            recreate()
        }

        val listView: ListView = findViewById(R.id.categoryListView)


        val categoryIds = allWeapons.map { it.categoryRes }.distinct()


        val categoryNames = categoryIds.map { getString(it) }

        val adapter = ArrayAdapter(
            this,
            R.layout.item_category,
            R.id.categoryName,
            categoryNames
        )
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedCategoryId = categoryIds[position]
            val intent = Intent(this, WeaponListActivity::class.java)

            intent.putExtra("categoryRes", selectedCategoryId)
            startActivity(intent)
        }

        findViewById<Button>(R.id.quizButton).setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnLeaderboard).setOnClickListener {
            startActivity(Intent(this, LeaderboardActivity::class.java))
        }
    }
}