package com.danielchoi.valorantapp.activitiesW

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.danielchoi.valorantapp.R
import com.danielchoi.valorantapp.helpersA.AgentsAdapter
import com.danielchoi.valorantapp.helpersW.WeaponSkinsAdapter
import com.danielchoi.valorantapp.modelsA.Ability
import com.danielchoi.valorantapp.modelsA.Agent
import com.danielchoi.valorantapp.modelsW.Skin
import com.danielchoi.valorantapp.modelsW.Weapon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_agent_detail.*
import kotlinx.android.synthetic.main.activity_weapon_detail.*
import kotlinx.android.synthetic.main.fragment_agent.*

val TAG = "AgentDetailActivity"

class WeaponDetailActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weapon_detail)

        if (intent.getParcelableExtra<Weapon>(EXTRA_WEAPON) != null)
        {
            val weapon = intent.getParcelableExtra<Weapon>(EXTRA_WEAPON)
            Log.d(TAG, "onCreate: " + weapon)

            if(weapon != null) {
                Picasso.get().load(weapon.displayIcon).into(imageView_weaponDetail_gun)
                textView_weaponDetail_name.text = weapon.displayName

                if(weapon.shopData != null){
                    textView_weaponDetail_staticShop.visibility = View.VISIBLE
                    space2.visibility = View.VISIBLE
                    textView_weaponDetail_weaponCategory.visibility = View.VISIBLE
                    textView_weaponDetail_cost.visibility = View.VISIBLE

                    var weaponCost = weapon.shopData.cost.toString()
                    textView_weaponDetail_staticShop.text = "Shop Data"
                    textView_weaponDetail_cost.text = "In Game Price: $weaponCost"
                    textView_weaponDetail_weaponCategory.text = "Weapon Category: ${weapon.shopData.categoryText}"
                }

                val weaponSkinList  = weapon.skins ?: listOf<Skin>()
                recyclerView_weaponDetail_skins.apply {
                    setHasFixedSize(true)
                    // could use LinearLayoutManager (no span count)
                    layoutManager = LinearLayoutManager(this@WeaponDetailActivity)
                    adapter = WeaponSkinsAdapter(weaponSkinList)
                }
            }

        }


    }
    companion object{
        val EXTRA_WEAPON = "weapon"
    }
}