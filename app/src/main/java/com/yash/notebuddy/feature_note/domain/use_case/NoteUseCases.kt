package com.yash.notebuddy.feature_note.domain.use_case

data class NoteUseCases(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val addNote: AddNote,
    val getNoteUseCase: GetNoteUseCase
)