package com.yash.notebuddy.feature_note.presentation.notes

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.yash.notebuddy.feature_note.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel
@Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {

    private val _state = MutableState<>
}