package com.example.gridview

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class natureadaptor(
    var imagelist: ArrayList<Int>,
    var context: Context,
    var imagename: ArrayList<String>
) : BaseAdapter() {


    override fun getCount(): Int {
        return imagename.size
    }

    override fun getItem(position: Int): Any ?{
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view :  View = LayoutInflater.from(parent!!.context).inflate(R.layout.custom_layout,parent,false)
        var natureName : TextView = view.findViewById(R.id.textView)
        var naturePic: ImageView = view.findViewById(R.id.imageView)
        natureName.text = imagename[position]
        naturePic.setImageResource(imagelist.get(position))
return view
    }
}