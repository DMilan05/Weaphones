package com.example.weaphones

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "quiz.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE results (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                correct INTEGER,
                total INTEGER,
                timeMillis INTEGER,
                timestamp INTEGER
            )
        """.trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase, old: Int, newV: Int) {
        db.execSQL("DROP TABLE IF EXISTS results")
        onCreate(db)
    }

    fun addResult(result: QuizResult) {
        val values = ContentValues().apply {
            put("correct", result.correct)
            put("total", result.total)
            put("timeMillis", result.timeMillis)
            put("timestamp", result.timestamp)
        }
        writableDatabase.insert("results", null, values)
    }

    fun getAllResults(): List<QuizResult> {
        val list = mutableListOf<QuizResult>()
        val cursor = readableDatabase.rawQuery(
            "SELECT * FROM results ORDER BY id DESC",
            null
        )

        while (cursor.moveToNext()) {
            list.add(
                QuizResult(
                    id = cursor.getLong(0),
                    correct = cursor.getInt(1),
                    total = cursor.getInt(2),
                    timeMillis = cursor.getLong(3),
                    timestamp = cursor.getLong(4)
                )
            )
        }

        cursor.close()
        return list
    }
}
