package com.danielchoi.valorantapp.helpersW

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danielchoi.valorantapp.R
import com.danielchoi.valorantapp.activitiesW.WeaponDetailActivity
import com.danielchoi.valorantapp.modelsW.Skin
import com.squareup.picasso.Picasso

class WeaponSkinsAdapter(private val weaponSkinList: List<Skin>) : RecyclerView.Adapter<WeaponSkinsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_weapondetail_weaponitem, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {

        return weaponSkinList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${weaponSkinList.size} ")


        return holder.bind(weaponSkinList[position])

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageView = itemView.findViewById<ImageView>(R.id.imageView_weaponDetail_skin_weaponPic)
        var textView = itemView.findViewById<TextView>(R.id.textView_weaponDetail_skin_skinName)
        fun bind(skin: Skin) {
            var standard =
                skin.displayName.length >= 8 && skin.displayName.substring(0, 8) != "Standard"
//            var luxe = skin.displayName.length >= 4 && skin.displayName.substring(0, 3) != "Luxe"
//            var melee = skin.displayName.length >= 4 && skin.displayName.substring(0, 4) != "Melee"
//            if (standard || luxe || melee) {
//
//            }
            if (skin.displayIcon != null) {
                if(standard) {
                    Picasso.get().load(skin.displayIcon).into(imageView)
                    textView.text = skin.displayName
                }
                else if(skin.displayName.length < 8)
                {
                    Picasso.get().load(skin.displayIcon).into(imageView)
                    textView.text = skin.displayName
                }
            }

        }
    }
}