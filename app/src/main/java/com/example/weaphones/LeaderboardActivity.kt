package com.example.weaphones

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LeaderboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        LanguageManager.applyLanguage(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaderboard)

        val recycler = findViewById<RecyclerView>(R.id.leaderboardRecycler)
        recycler.layoutManager = LinearLayoutManager(this)

        val db = DatabaseHelper(this)
        val results = db.getAllResults()

        recycler.adapter = LeaderboardAdapter(results)
    }
}


