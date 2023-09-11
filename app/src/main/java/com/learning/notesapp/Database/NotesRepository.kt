package com.learning.notesapp.Database

import androidx.lifecycle.LiveData
import com.learning.notesapp.Models.Note

class NotesRepository(private val noteDAO: NoteDAO) {

    val allNotes: LiveData<List<Note>> = noteDAO.getAllNotes()

    suspend fun insert(note: Note) {
        noteDAO.insert(note)
    }

    suspend fun delete(note: Note) {
        noteDAO.delete(note)
    }

    suspend fun update(note: Note) {
        note.note?.let { noteDAO.update(note.id, note.title, it) }
    }
}