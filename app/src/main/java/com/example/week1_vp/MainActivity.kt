package com.example.week1_vp

import Adapter.ListHewanAdapter
import Database.GlobalVar
import Model.Hewan
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week1_vp.databinding.ActivityMainBinding

private lateinit var viewBind:ActivityMainBinding

private val listHewan = GlobalVar.listHewan
private val adapter = ListHewanAdapter(listHewan)


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBind.root)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setTitle("Data Hewan")
        setupRecyclerView()
        Listener()
    }

    private fun Listener() {
        viewBind.AddButton.setOnClickListener {
            val myIntent = Intent(this, FormActivity::class.java)
            startActivity(myIntent)
        }
    }

    private fun setupRecyclerView(){
        val layoutManager = LinearLayoutManager(baseContext)
        viewBind.MainRecycler.layoutManager = layoutManager
        viewBind.MainRecycler.adapter = adapter
    }

}