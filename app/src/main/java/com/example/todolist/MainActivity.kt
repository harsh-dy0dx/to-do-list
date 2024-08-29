package com.example.todolist

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todolist.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var item: EditText
    lateinit var add: Button
    lateinit var listView: ListView

    var itemlist = ArrayList<String>()
    var fileHelper = FileHelper()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

       // listView =findViewById(R.id.list)
        item =findViewById(R.id.edittext)
        add =findViewById(R.id.button)

        itemlist = fileHelper.readData(this)
        var arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,itemlist)
        binding.list.adapter = arrayAdapter



        add.setOnClickListener{
      var itemname : String = item.text.toString()
            itemlist.add(itemname)
            item.setText("")
            fileHelper.writeData(itemlist,applicationContext)
            arrayAdapter.notifyDataSetChanged()
        }
        binding.list.setOnItemClickListener { parent, view, position, id ->
            var alert = AlertDialog.Builder(this)
            alert.setTitle("Delete")
            alert.setIcon(R.drawable.baseline_delete_24)
            alert.setMessage("Do you want to delete the selected task ?")
            alert.setCancelable(false)
            alert.setNegativeButton("NO",DialogInterface.OnClickListener { dialog, which ->
                dialog.cancel()
            })
            alert.setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, which ->
                itemlist.removeAt(position)
                arrayAdapter.notifyDataSetChanged()
                fileHelper.writeData(itemlist,applicationContext)

            })
            alert.create().show()
        }




        }

    }
