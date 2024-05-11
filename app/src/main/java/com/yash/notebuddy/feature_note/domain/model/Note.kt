package com.yash.notebuddy.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yash.notebuddy.ui.theme.BabyBlue
import com.yash.notebuddy.ui.theme.LightGreen
import com.yash.notebuddy.ui.theme.RedOrange
import com.yash.notebuddy.ui.theme.RedPink
import com.yash.notebuddy.ui.theme.Violet
import java.sql.Timestamp

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
