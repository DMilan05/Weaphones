package com.example.weaphones

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private var currentIndex = 0
    private var score = 0

    private val questions = listOf(
        QuizQuestion.Image(
            imageResId = R.drawable.ak47,
            question = "Melyik országban fejlesztették az AK-47-et?",
            options = listOf("USA", "Szovjetunió", "Kína", "Németország"),
            correctIndex = 1
        ),
        QuizQuestion.Image(
            imageResId = R.drawable.m16a1,
            question = "Melyik fegyver látható a képen?",
            options = listOf("M16A1", "FAMAS F1", "AK-47", "FN SCAR"),
            correctIndex = 0
        ),
        QuizQuestion.Text(
            question = "Milyen kalibert használ a Glock 17?",
            options = listOf("9x19mm", ".45 ACP", "7.62x39mm", "5.56x45mm"),
            correctIndex = 0
        ),
        QuizQuestion.Text(
            question = "Ki gyártotta a Beretta M9-et?",
            options = listOf("Beretta", "Colt", "Glock", "IMI"),
            correctIndex = 0
        ),
        QuizQuestion.Image(
            imageResId = R.drawable.deagle,
            question = "Mi a neve ennek a pisztolynak?",
            options = listOf("Colt M1911", "Desert Eagle", "Glock 17", "SIG P226"),
            correctIndex = 1
        ),
        QuizQuestion.Text(
            question = "Melyik országban készült az Uzi géppisztoly?",
            options = listOf("USA", "Németország", "Izrael", "Franciaország"),
            correctIndex = 2
        ),
        QuizQuestion.Text(
            question = "Melyik fegyver gyártója a Heckler & Koch?",
            options = listOf("MP5", "P90", "AK-47", "Benelli M4"),
            correctIndex = 0
        ),
        QuizQuestion.Image(
            imageResId = R.drawable.barret,
            question = "Mi a neve ennek a mesterlövész puskának?",
            options = listOf("M24 SWS", "Dragunov SVD", "Barrett M82", "PKM"),
            correctIndex = 2
        ),
        QuizQuestion.Text(
            question = "Milyen kalibert használ a PKM géppuska?",
            options = listOf("7.62x39mm", "7.62x54mmR", "5.56x45mm NATO", ".50 BMG"),
            correctIndex = 1
        ),
        QuizQuestion.Text(
            question = "Melyik fegyver származik Olaszországból?",
            options = listOf("Benelli M4", "AK-47", "MP5", "Barrett M82"),
            correctIndex = 0
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        showQuestion()
    }

    private fun showQuestion() {
        val question = questions[currentIndex]
        val questionText: TextView = findViewById(R.id.quizQuestionText)
        val imageView: ImageView = findViewById(R.id.quizImage)
        val radioGroup: RadioGroup = findViewById(R.id.quizOptions)

        radioGroup.removeAllViews()

        if (question is QuizQuestion.Image) {
            imageView.setImageResource(question.imageResId)
            imageView.visibility = ImageView.VISIBLE
            questionText.text = question.question
            for ((i, opt) in question.options.withIndex()) {
                val rb = RadioButton(this)
                rb.text = opt
                rb.id = i
                radioGroup.addView(rb)
            }
        } else if (question is QuizQuestion.Text) {
            imageView.visibility = ImageView.GONE
            questionText.text = question.question
            for ((i, opt) in question.options.withIndex()) {
                val rb = RadioButton(this)
                rb.text = opt
                rb.id = i
                radioGroup.addView(rb)
            }
        }

        findViewById<Button>(R.id.submitButton).setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId == -1) return@setOnClickListener

            val correctIndex = when (question) {
                is QuizQuestion.Text -> question.correctIndex
                is QuizQuestion.Image -> question.correctIndex
            }

            if (selectedId == correctIndex) score++

            if (currentIndex < questions.size - 1) {
                currentIndex++
                showQuestion()
            } else {
                showResult()
            }
        }
    }

    private fun showResult() {
        AlertDialog.Builder(this)
            .setTitle("Kvíz vége")
            .setMessage("Eredményed: $score / ${questions.size}")
            .setPositiveButton("OK") { _, _ -> finish() }
            .show()
    }
}

sealed class QuizQuestion {
    data class Text(val question: String, val options: List<String>, val correctIndex: Int) : QuizQuestion()
    data class Image(val imageResId: Int, val question: String, val options: List<String>, val correctIndex: Int) : QuizQuestion()
}
