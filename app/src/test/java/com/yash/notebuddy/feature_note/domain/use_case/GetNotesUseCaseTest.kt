package com.yash.notebuddy.feature_note.domain.use_case

import com.yash.notebuddy.feature_note.data.repository.FakeNoteRepository
import com.yash.notebuddy.feature_note.domain.model.Note
import com.yash.notebuddy.feature_note.domain.util.NoteOrder
import com.yash.notebuddy.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetNotesUseCaseTest {

    private lateinit var getNotesUseCase: GetNotesUseCase
    private lateinit var fakeNoteRepository: FakeNoteRepository

    @Before
    fun setUp() {
        fakeNoteRepository = FakeNoteRepository()
        getNotesUseCase = GetNotesUseCase(fakeNoteRepository)

        val notesToInsert = mutableListOf<Note>()
        ('a'..'z').forEachIndexed { index, c ->
            notesToInsert.add(
                Note(
                    title = c.toString(),
                    content = c.toString(),
                    timestamp = index.toLong(),
                    color = index
                )
            )
        }
        notesToInsert.shuffle()
        runBlocking {
            notesToInsert.forEach { fakeNoteRepository.insertNote(it) }
        }
    }

    @Test
    fun `Order notes by title ascending, correct order`() = runBlocking{
        val notes = getNotesUseCase(NoteOrder.Title(OrderType.Ascending)).first()

    }

}