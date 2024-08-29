package com.example.gridview

import android.content.Context
import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.gridview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   lateinit var binding : ActivityMainBinding
   lateinit var gridView: GridView
  var imagelist = ArrayList<Int>()
  var imagename = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fillArrays()
 val adapter = natureadaptor(imagelist, this , imagename)
        binding.gridview.adapter = adapter
    }
    fun  fillArrays(){

        imagename.add("Nature1")
        imagename.add("Nature2")
        imagename.add("Nature3")
        imagename.add("Nature4")
        imagename.add("Nature5")
        imagename.add("Nature6")
        imagename.add("Nature7")
        imagename.add("Nature8")
        imagename.add("Nature9")
        imagename.add("Nature10")
        imagename.add("Nature11")
        imagename.add("Nature12")

        imagelist.add(R.drawable.images)
        imagelist.add(R.drawable.images)
        imagelist.add(R.drawable.images)
        imagelist.add(R.drawable.images)
        imagelist.add(R.drawable.images)
        imagelist.add(R.drawable.images)
        imagelist.add(R.drawable.images)
        imagelist.add(R.drawable.images)
        imagelist.add(R.drawable.images)
        imagelist.add(R.drawable.images)
        imagelist.add(R.drawable.images)
        imagelist.add(R.drawable.images)



    }
}