package com.example.tasco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tasco.databinding.ActivityAddListBinding

class AddList : AppCompatActivity() {

    private lateinit var binding: ActivityAddListBinding
    private lateinit var db:ListDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddListBinding.inflate(layoutInflater)

        setContentView(binding.root)

        db = ListDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val list = List(0,title,content)
            db.insertNote(list)
            finish()
            Toast.makeText(this,"List Saved",Toast.LENGTH_SHORT).show()
        }
    }
}