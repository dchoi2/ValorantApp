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
import com.danielchoi.valorantapp.activitiesA.AgentDetailActivity
import com.danielchoi.valorantapp.activitiesW.WeaponDetailActivity
import com.danielchoi.valorantapp.modelsW.Weapon
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class WeaponsAdapter(private val weaponsList: List<Weapon>) : RecyclerView.Adapter<WeaponsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.weapon_item,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {

        return weaponsList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${weaponsList.size} ")


        return holder.bind(weaponsList[position])

    }
    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {

        var imageView = itemView.findViewById<ImageView>(R.id.imageView_weapon_pic)
        var textView = itemView.findViewById<TextView>(R.id.textView_weapon_name)
        fun bind(weapon : Weapon) {
            Picasso.get().load(weapon.displayIcon).into(imageView)
            textView.text = weapon.displayName

            imageView.setOnClickListener{
                // the first argument in the intent is the context. usually, that's the current activity
                // but if you aren't in the activity class, you can access the context through the available view
                val specificWeaponIntent = Intent(imageView.context, WeaponDetailActivity::class.java)
                specificWeaponIntent.putExtra(WeaponDetailActivity.EXTRA_WEAPON, weapon)
                // starting the activity required no object to call it on in an Activity class
                // since we're not in an Activity class, we call it through the context
                imageView.context.startActivity(specificWeaponIntent)
            }
        }

    }
}