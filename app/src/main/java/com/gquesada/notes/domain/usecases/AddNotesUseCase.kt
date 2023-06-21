package com.gquesada.notes.domain.usecases

import com.gquesada.notes.data.models.LocalNote
import com.gquesada.notes.domain.repositories.NoteRepository

class AddNotesUseCase (private val noteRepository: NoteRepository) {

    fun execute(note: LocalNote){
        noteRepository.addNote(note)
    }
}