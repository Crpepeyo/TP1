package com.example.tp1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp1.AdapterItem
import com.example.tp1.AdapterList
import com.example.tp1.Item

class ShowListActivity : AppCompatActivity(){
    val CAT: String = "TODO_ITEM"
    val context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)
        var list_name: String? = intent.getStringExtra("list")

        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerViewChObject)
        val items: MutableList<Item> = mutableListOf()

        repeat(5){
            items.add(Item("new item ${it+1}"))
        }



        val adapter = AdapterItem(items)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)

        this.title = "Items of \"$list_name\" Todo-list"

        var b=findViewById<Button>(R.id.buttonOkChObject)
        var t=findViewById<EditText>(R.id.editTextObject)
        b.setOnClickListener {
            Log.i(CAT, "map: "+adapter.checkStatus.toString())
            var newItemName = t.text.toString()

                adapter.addData(newItemName) // add new item
                t.setText("") // clear the input area
            }
        }
    }

