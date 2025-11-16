package com.example.weaphones

data class QuizResult(
    val id: Long = 0,
    val correct: Int,
    val total: Int,
    val timeMillis: Long,
    val timestamp: Long
)



