package com.example.weaphones

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class QuizActivity : AppCompatActivity() {

    private var currentIndex = 0
    private var score = 0
    private var startTime = 0L


    private lateinit var questions: List<QuizQuestion>
    private val idToIndexMap = mutableMapOf<Int, Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        LanguageManager.applyLanguage(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        findViewById<Button>(R.id.submitButton).text = getString(R.string.btn_next)

        val currentLang = LanguageManager.getLanguage(this)


        val allQuestionsPool = if (currentLang == "en") {
            getEnglishQuestions()
        } else {
            getHungarianQuestions()
        }

        questions = allQuestionsPool.shuffled().take(10)

        startTime = System.currentTimeMillis()
        showQuestion()
    }

    private fun showQuestion() {
        if (currentIndex >= questions.size) return

        val question = questions[currentIndex]
        val questionText: TextView = findViewById(R.id.quizQuestionText)
        val imageView: ImageView = findViewById(R.id.quizImage)
        val radioGroup: RadioGroup = findViewById(R.id.quizOptions)
        val submitButton: Button = findViewById(R.id.submitButton)

        radioGroup.removeAllViews()
        idToIndexMap.clear()

        // Kép kezelése
        if (question is QuizQuestion.Image) {
            imageView.setImageResource(question.imageResId)
            imageView.visibility = View.VISIBLE
        } else {
            imageView.visibility = View.GONE
        }

        // Kérdés szövege
        questionText.text = when (question) {
            is QuizQuestion.Text -> question.question
            is QuizQuestion.Image -> question.question
        }

        // Válaszlehetőségek
        val options = when (question) {
            is QuizQuestion.Text -> question.options
            is QuizQuestion.Image -> question.options
        }

        for (i in options.indices) {
            val rb = RadioButton(this)
            rb.text = options[i]
            val id = View.generateViewId()
            rb.id = id
            idToIndexMap[id] = i
            rb.setTextColor(resources.getColor(android.R.color.white, theme))
            radioGroup.addView(rb)
        }

        submitButton.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId == -1) return@setOnClickListener

            val selectedIndex = idToIndexMap[selectedId] ?: return@setOnClickListener
            val correctIndex = when (question) {
                is QuizQuestion.Text -> question.correctIndex
                is QuizQuestion.Image -> question.correctIndex
            }

            if (selectedIndex == correctIndex) score++

            // Következő kérdés vagy vége
            if (currentIndex < questions.size - 1) {
                currentIndex++
                showQuestion()
            } else {
                showResult()
            }
        }
    }

    private fun showResult() {
        val elapsedTime = System.currentTimeMillis() - startTime
        DatabaseHelper(this).addResult(
            QuizResult(
                correct = score,
                total = questions.size,
                timeMillis = elapsedTime,
                timestamp = System.currentTimeMillis()
            )
        )


        AlertDialog.Builder(this)
            .setTitle(getString(R.string.quiz_over_title))
            .setMessage(getString(R.string.quiz_score_format, score, questions.size))
            .setPositiveButton(getString(R.string.btn_ok)) { _, _ -> finish() }
            .setCancelable(false)
            .show()
    }

    // --- MAGYAR KÉRDÉSEK ---
    private fun getHungarianQuestions(): List<QuizQuestion> {
        return listOf(
            QuizQuestion.Image(R.drawable.ak47, "Melyik országban fejlesztették az AK-47-et?", listOf("USA", "Szovjetunió", "Kína", "Németország"), 1),
            QuizQuestion.Text("Milyen kaliberű lőszert használ az AK-47?", listOf("5.45x39mm", "7.62x39mm", "7.62x54mmR", "5.56x45mm"), 1),
            QuizQuestion.Image(R.drawable.ak74, "Melyik fegyver látható a képen?", listOf("AK-47", "AK-74", "AK-103", "AKM"), 1),
            QuizQuestion.Text("Melyik évben vezették be az AK-74-et?", listOf("1959", "1963", "1974", "1985"), 2),
            QuizQuestion.Text("Melyik ország gyártotta az AK-63D változatot?", listOf("Románia", "Lengyelország", "Magyarország", "Oroszország"), 2),
            QuizQuestion.Text("Miben különbözik az AK-63F az AK-63D-től?", listOf("Kaliber", "Csőhossz", "Fix vagy behajtható válltámasz", "Sorozatlövési mód"), 2),
            QuizQuestion.Image(R.drawable.ak12, "Melyik a legmodernebb változat az AK sorozatból a képen?", listOf("AKM", "AK-47", "AK-12", "AK-103"), 2),
            QuizQuestion.Image(R.drawable.m16a1, "Melyik fegyver látható a képen?", listOf("M16A1", "FAMAS F1", "AK-47", "FN SCAR"), 0),
            QuizQuestion.Text("Milyen kalibert használ az M4A1 gépkarabély?", listOf("7.62x51mm", "9x19mm", "5.56x45mm NATO", ".300 BLK"), 2),
            QuizQuestion.Image(R.drawable.hk416, "Melyik fegyver látható a képen?", listOf("HK416", "FN SCAR", "M4A1", "SIG MCX"), 0),
            QuizQuestion.Text("Melyik gyártó készítette a HK416-ot?", listOf("SIG Sauer", "Colt", "Heckler & Koch", "FN Herstal"), 2),
            QuizQuestion.Image(R.drawable.sigmcx, "Mi a neve ennek az amerikai moduláris karabélynak?", listOf("HK416", "SIG MCX", "FN SCAR", "CZ Bren 2"), 1),
            QuizQuestion.Text("Melyik országban készült a CZ 805 Bren?", listOf("Lengyelország", "Csehország", "Szlovákia", "Németország"), 1),
            QuizQuestion.Image(R.drawable.czbren2, "Melyik fegyver látható a képen?", listOf("CZ Bren 2", "CZ 805 Bren", "FN SCAR", "SIG MCX"), 0),
            QuizQuestion.Image(R.drawable.czscorpion, "Mi a neve ennek a géppisztolynak?", listOf("CZ Scorpion EVO 3 A1", "Uzi", "MP5", "Vector SMG"), 0),
            QuizQuestion.Text("Milyen kalibert használ a CZ Scorpion EVO 3 A1?", listOf("9x19mm", "5.56x45mm", ".45 ACP", "7.62x39mm"), 0),
            QuizQuestion.Text("Milyen kalibert használ a Glock 17?", listOf("9x19mm", ".45 ACP", "7.62x39mm", "5.56x45mm"), 0),
            QuizQuestion.Text("Ki gyártotta a Beretta M9-et?", listOf("Beretta", "Colt", "Glock", "IMI"), 0),
            QuizQuestion.Image(R.drawable.deagle, "Mi a neve ennek a pisztolynak?", listOf("Colt M1911", "Desert Eagle", "Glock 17", "SIG P226"), 1),
            QuizQuestion.Text("Melyik országban készült a Stechkin APS automata pisztoly?", listOf("Oroszország", "Lengyelország", "Szovjetunió", "Ukrajna"), 2),
            QuizQuestion.Text("Melyik országban fejlesztették az Uzi géppisztolyt?", listOf("USA", "Németország", "Izrael", "Franciaország"), 2),
            QuizQuestion.Text("Melyik gyártó készítette az MP5-öt?", listOf("FN Herstal", "IMI", "Heckler & Koch", "Beretta"), 2),
            QuizQuestion.Image(R.drawable.vector, "Melyik modern géppisztoly látható a képen?", listOf("MP5", "Vector SMG", "CZ Scorpion EVO 3", "Uzi"), 1),
            QuizQuestion.Text("Milyen kalibert használ a PKM géppuska?", listOf("7.62x39mm", "7.62x54mmR", "5.56x45mm NATO", ".50 BMG"), 1),
            QuizQuestion.Image(R.drawable.pkm, "Mi a neve ennek a géppuskának?", listOf("M240B", "PKM", "RPK", "M60"), 1),
            QuizQuestion.Image(R.drawable.barret, "Mi a neve ennek a mesterlövész puskának?", listOf("M24 SWS", "Dragunov SVD", "Barrett M82", "PKM"), 2),
            QuizQuestion.Image(R.drawable.rpg7, "Milyen típusú fegyver látható a képen?", listOf("Géppuska", "Páncéltörő vető", "Gránátvető", "Sörétes puska"), 1),
            QuizQuestion.Text("Melyik ország gyártotta az RPG-7-et?", listOf("USA", "Szovjetunió", "Kína", "Lengyelország"), 1),
            QuizQuestion.Image(R.drawable.thompson, "Mi a neve ennek a II. világháborús géppisztolynak?", listOf("MP40", "Thompson M1A1", "Uzi", "Sten"), 1),
            QuizQuestion.Text("Melyik évben vezették be az M1 Garand puskát?", listOf("1936", "1945", "1950", "1918"), 0)
        )
    }

    // --- ANGOL KÉRDÉSEK ---
    private fun getEnglishQuestions(): List<QuizQuestion> {
        return listOf(
            QuizQuestion.Image(R.drawable.ak47, "In which country was the AK-47 developed?", listOf("USA", "Soviet Union", "China", "Germany"), 1),
            QuizQuestion.Text("What caliber ammo does the AK-47 use?", listOf("5.45x39mm", "7.62x39mm", "7.62x54mmR", "5.56x45mm"), 1),
            QuizQuestion.Image(R.drawable.ak74, "Which weapon is shown in the image?", listOf("AK-47", "AK-74", "AK-103", "AKM"), 1),
            QuizQuestion.Text("In which year was the AK-74 introduced?", listOf("1959", "1963", "1974", "1985"), 2),
            QuizQuestion.Text("Which country manufactured the AK-63D variant?", listOf("Romania", "Poland", "Hungary", "Russia"), 2),
            QuizQuestion.Text("What is the difference between AK-63F and AK-63D?", listOf("Caliber", "Barrel length", "Fixed vs folding stock", "Burst mode"), 2),
            QuizQuestion.Image(R.drawable.ak12, "Which is the most modern AK variant in the picture?", listOf("AKM", "AK-47", "AK-12", "AK-103"), 2),
            QuizQuestion.Image(R.drawable.m16a1, "Which weapon is shown in the image?", listOf("M16A1", "FAMAS F1", "AK-47", "FN SCAR"), 0),
            QuizQuestion.Text("What caliber does the M4A1 carbine use?", listOf("7.62x51mm", "9x19mm", "5.56x45mm NATO", ".300 BLK"), 2),
            QuizQuestion.Image(R.drawable.hk416, "Which weapon is shown in the image?", listOf("HK416", "FN SCAR", "M4A1", "SIG MCX"), 0),
            QuizQuestion.Text("Which manufacturer made the HK416?", listOf("SIG Sauer", "Colt", "Heckler & Koch", "FN Herstal"), 2),
            QuizQuestion.Image(R.drawable.sigmcx, "What is the name of this American modular carbine?", listOf("HK416", "SIG MCX", "FN SCAR", "CZ Bren 2"), 1),
            QuizQuestion.Text("In which country was the CZ 805 Bren made?", listOf("Poland", "Czech Republic", "Slovakia", "Germany"), 1),
            QuizQuestion.Image(R.drawable.czbren2, "Which weapon is shown in the image?", listOf("CZ Bren 2", "CZ 805 Bren", "FN SCAR", "SIG MCX"), 0),
            QuizQuestion.Image(R.drawable.czscorpion, "What is the name of this SMG?", listOf("CZ Scorpion EVO 3 A1", "Uzi", "MP5", "Vector SMG"), 0),
            QuizQuestion.Text("What caliber does the CZ Scorpion EVO 3 A1 use?", listOf("9x19mm", "5.56x45mm", ".45 ACP", "7.62x39mm"), 0),
            QuizQuestion.Text("What caliber does the Glock 17 use?", listOf("9x19mm", ".45 ACP", "7.62x39mm", "5.56x45mm"), 0),
            QuizQuestion.Text("Who manufactured the Beretta M9?", listOf("Beretta", "Colt", "Glock", "IMI"), 0),
            QuizQuestion.Image(R.drawable.deagle, "What is the name of this pistol?", listOf("Colt M1911", "Desert Eagle", "Glock 17", "SIG P226"), 1),
            QuizQuestion.Text("In which country was the Stechkin APS machine pistol made?", listOf("Russia", "Poland", "Soviet Union", "Ukraine"), 2),
            QuizQuestion.Text("In which country was the Uzi SMG developed?", listOf("USA", "Germany", "Israel", "France"), 2),
            QuizQuestion.Text("Which manufacturer made the MP5?", listOf("FN Herstal", "IMI", "Heckler & Koch", "Beretta"), 2),
            QuizQuestion.Image(R.drawable.vector, "Which modern SMG is shown in the image?", listOf("MP5", "Vector SMG", "CZ Scorpion EVO 3", "Uzi"), 1),
            QuizQuestion.Text("What caliber does the PKM machine gun use?", listOf("7.62x39mm", "7.62x54mmR", "5.56x45mm NATO", ".50 BMG"), 1),
            QuizQuestion.Image(R.drawable.pkm, "What is the name of this machine gun?", listOf("M240B", "PKM", "RPK", "M60"), 1),
            QuizQuestion.Image(R.drawable.barret, "What is the name of this sniper rifle?", listOf("M24 SWS", "Dragunov SVD", "Barrett M82", "PKM"), 2),
            QuizQuestion.Image(R.drawable.rpg7, "What type of weapon is shown in the image?", listOf("Machine Gun", "Anti-tank Launcher", "Grenade Launcher", "Shotgun"), 1),
            QuizQuestion.Text("Which country manufactured the RPG-7?", listOf("USA", "Soviet Union", "China", "Poland"), 1),
            QuizQuestion.Image(R.drawable.thompson, "What is the name of this WWII SMG?", listOf("MP40", "Thompson M1A1", "Uzi", "Sten"), 1),
            QuizQuestion.Text("In which year was the M1 Garand rifle introduced?", listOf("1936", "1945", "1950", "1918"), 0)
        )
    }
}