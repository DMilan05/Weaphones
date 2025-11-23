package com.example.weaphones

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class LeaderboardAdapter(private val results: List<QuizResult>) :
    RecyclerView.Adapter<LeaderboardAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.resultText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_leaderboard, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val r = results[position]
        val context = holder.itemView.context

        val seconds = r.timeMillis / 1000
        val dateString = SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.getDefault())
            .format(Date(r.timestamp))


        val hitLabel = context.getString(R.string.lb_hits)
        val timeLabel = context.getString(R.string.lb_time)
        val secLabel = context.getString(R.string.lb_sec)

        holder.text.text = """
            $dateString
            $hitLabel: ${r.correct}/${r.total}
            $timeLabel: ${seconds} $secLabel
        """.trimIndent()
    }

    override fun getItemCount(): Int = results.size
}