package com.example.week1_vp

import Database.GlobalVar
import Model.Hewan
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import com.example.week1_vp.databinding.ActivityFormBinding

private lateinit var viewBind:ActivityFormBinding
private lateinit var hewans:Hewan
private var position = -1
private var array = GlobalVar


class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityFormBinding.inflate(layoutInflater)
        setContentView(viewBind.root)
        val actionBar = supportActionBar
        actionBar?.setTitle("Tambah Hewan")
        actionBar?.setDisplayHomeAsUpEnabled(true)
        GetIntent()
        Listener()
    }
    private fun GetIntent() {
        position = intent.getIntExtra("position", -1)
        if (position != -1){
            val hewan = GlobalVar.listHewan[position]
            hewans = hewan
            actionBar?.setTitle("Edit Hewan")
            Display(hewan)
        }
    }

    private fun Listener() {
        viewBind.SimpanButton.setOnClickListener {
            var namaHewan = viewBind.NamaHewanTextInputLayout.editText?.text.toString().trim()
            var jenisHewan = viewBind.JenisHewanTextInputLayout.editText?.text.toString().trim()
            var usiaHewan = viewBind.UsiaHewanTextInputLayout.editText?.text.toString().trim()

            if(position != -1){
                hewans.namaHewan = namaHewan
                hewans.jenisHewan = jenisHewan
                hewans.usiaHewan = usiaHewan

            }else {
                hewans = Hewan(-1, namaHewan, jenisHewan, usiaHewan, "")
                array.listHewan.add(hewans)
            }
            checker()

            if(checker()){
                val myIntent = Intent(this, MainActivity::class.java)
                startActivity(myIntent)
                finish()
            }
            }
        }


    private fun Display(hewan: Hewan) {
        viewBind.NamaHewanTextInputLayout.editText?.setText(hewans.namaHewan)
        viewBind.JenisHewanTextInputLayout.editText?.setText(hewans.jenisHewan)
        viewBind.UsiaHewanTextInputLayout.editText?.setText(hewans.usiaHewan)
    }

    private fun checker(): Boolean {
        var isCompleted:Boolean = true

        //Nama Hewan
        if(hewans.namaHewan!!.isEmpty()){
            viewBind.NamaHewanTextInputLayout.error = "Kolom Nama Hewan Belum Terisi"
            isCompleted = false
        }else{
            viewBind.NamaHewanTextInputLayout.error = ""
        }

        //Jenis Hewan
        if(hewans.jenisHewan!!.isEmpty()){
            viewBind.JenisHewanTextInputLayout.error = "Kolom Jenis Hewan Belum Terisi"
            isCompleted = false
        }else{
            viewBind.JenisHewanTextInputLayout.error = ""
        }

        //Usia Hewan
        if(hewans.usiaHewan!!.isEmpty()){
            viewBind.UsiaHewanTextInputLayout.error = "Kolom Usia Hewan Belum Terisi"
            isCompleted = false
        }else{
            viewBind.UsiaHewanTextInputLayout.error = ""
        }
        return isCompleted
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
