package com.example.tp1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChoixListActivity : AppCompatActivity(){
    val context = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choix_list)
        var pseudo: String? = intent.getStringExtra("pseudo")

        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerViewChListe)
        val lists: MutableList<List> = mutableListOf()

        repeat(5){
            lists.add(List("new list ${it + 1}"))
        }

        val adapter = AdapterList(lists)


        val intent = Intent(this,ShowListActivity::class.java)
        intent.putExtra("pseudo", pseudo)

        adapter.setOnItemClickListener(object : AdapterList.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val listName = lists[position].listTextStr
                intent.putExtra("list", listName)
                startActivity(intent)
            }
        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        this.title="$pseudo lists"


        var b=findViewById<Button>(R.id.buttonOkChListe)
        var t=findViewById<EditText>(R.id.editTextListe)
        b.setOnClickListener {
            var newListName = b.text.toString()
                adapter.addData(newListName)
                t.setText("")
            }

        }
    }
