package com.example.tp1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var sp: SharedPreferences? = null
    private var Pseudo: EditText? = null
    private var BtnOK: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp = PreferenceManager.getDefaultSharedPreferences(this)
        Pseudo = findViewById(R.id.Pseudo)
        BtnOK = findViewById(R.id.ButtonOk)

        BtnOK!!.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onClick(v: View?) {
        when (v?.id)
        {
            R.id.ButtonOk ->
            {
                Log.i("PMR","clickok")
                sp?.edit()?.putString("login", Pseudo?.text.toString())
                sp?.edit()?.commit()

                val versSecondAct: Intent
                versSecondAct = Intent(this@MainActivity, ChoixListActivity::class.java)
                versSecondAct.putExtra("pseudo",Pseudo?.text.toString())
                startActivity(versSecondAct)

            }
        }
    }

}