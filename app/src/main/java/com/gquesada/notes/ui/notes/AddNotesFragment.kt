package com.gquesada.notes.ui.notes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gquesada.notes.R
import com.gquesada.notes.data.datasources.LocalNoteDataSource
import com.gquesada.notes.data.models.LocalNote
import com.gquesada.notes.data.models.LocalTag
import com.gquesada.notes.domain.models.NoteModel
import com.gquesada.notes.domain.models.TagModel
import com.gquesada.notes.ui.notes.viewmodels.NoteListViewModel

class AddNotesFragment: Fragment() {
    private lateinit var viewModel: NoteListViewModel

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_notes, container, false)
        viewModel = ViewModelProvider(this)[NoteListViewModel::class.java]
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addNoteButton: Button = view.findViewById(R.id.addNoteButton)

        addNoteButton.setOnClickListener{
            var noteTitle: String = view.findViewById<EditText?>(R.id.noteTitle).text.toString()
            var description: String = view.findViewById<EditText?>(R.id.noteDescription).text.toString()
            var date: Int = view.findViewById<EditText?>(R.id.date).text.toString().toInt()
            var tagTitle: String = view.findViewById<EditText?>(R.id.tagTitle).text.toString()
            var id = LocalNoteDataSource.getAllNotes().size + 1

            var newNote = LocalNote(id, noteTitle, description, LocalTag(3, tagTitle), date)

            viewModel.addNote(newNote)

            requireFragmentManager().popBackStack()
        }
    }
}