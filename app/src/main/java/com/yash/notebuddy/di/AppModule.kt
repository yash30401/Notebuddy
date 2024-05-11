package com.yash.notebuddy.di

import android.app.Application
import androidx.room.Room
import com.yash.notebuddy.feature_note.data.data_source.NoteDao
import com.yash.notebuddy.feature_note.data.data_source.NoteDatabase
import com.yash.notebuddy.feature_note.data.repository.NoteRepositoryImpl
import com.yash.notebuddy.feature_note.domain.repository.NoteRepository
import com.yash.notebuddy.feature_note.domain.use_case.AddNote
import com.yash.notebuddy.feature_note.domain.use_case.DeleteNoteUseCase
import com.yash.notebuddy.feature_note.domain.use_case.GetNotesUseCase
import com.yash.notebuddy.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(noteRepository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository = noteRepository),
            deleteNoteUseCase = DeleteNoteUseCase(repository = noteRepository),
            addNote = AddNote(noteRepository)
        )
    }
}