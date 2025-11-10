package com.example.weaphones

sealed class QuizQuestion {
    data class Text(
        val question: String,
        val options: List<String>,
        val correctIndex: Int
    ) : QuizQuestion()

    data class Image(
        val imageResId: Int,
        val question: String,
        val options: List<String>,
        val correctIndex: Int
    ) : QuizQuestion()
}
