package com.yash.notebuddy.feature_note.domain.use_case

import com.yash.notebuddy.feature_note.data.repository.FakeNoteRepository
import com.yash.notebuddy.feature_note.domain.model.InvalidNoteException
import com.yash.notebuddy.feature_note.domain.model.Note
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AddNoteTest{

    private lateinit var addNote: AddNote
    private lateinit var fakeNoteRepository: FakeNoteRepository

    @Before
    fun  setup(){
        fakeNoteRepository = FakeNoteRepository()
        addNote = AddNote(fakeNoteRepository)
    }

    @Test
    fun `Throw invalid note exception when title is empty, InvalidNoteException`() {
        assertThrows(InvalidNoteException::class.java){
            runBlocking {
                addNote.invoke(Note("","sd",23432L,2))
            }
        }
    }

    @Test
    fun `Throw Invalid note exception when content is empty, Invalid exception`(){
        assertThrows(InvalidNoteException::class.java){
            runBlocking {
                addNote.invoke(Note("dsf","",23432L,2))
            }
        }
    }

    @Test
    fun `insert note when valid note provides`(){
        runBlocking {
            addNote.invoke(Note("sad","fsa",23432L,2))
        }

    }
}