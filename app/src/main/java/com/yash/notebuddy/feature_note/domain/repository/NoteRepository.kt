package com.yash.notebuddy.feature_note.domain.repository

import com.yash.notebuddy.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {


    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNot(note: Note)

    suspend fun deleteNote(note: Note)
}