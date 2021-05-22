package com.danielchoi.valorantapp.activitiesW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.danielchoi.valorantapp.R
import com.danielchoi.valorantapp.modelsA.Ability
import com.danielchoi.valorantapp.modelsA.Agent
import com.danielchoi.valorantapp.modelsW.Skin
import com.danielchoi.valorantapp.modelsW.Weapon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_agent_detail.*

val TAG = "AgentDetailActivity"

class WeaponDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weapon_detail)

        if (intent.getParcelableExtra<Weapon>(EXTRA_WEAPON) != null)
        {
            val weapon = intent.getParcelableExtra<Weapon>(EXTRA_WEAPON)
            val weaponList  = weapon?.skins ?: listOf<Skin>()
            Log.d(TAG, "onCreate: " + weapon)

            if(weapon != null) {

            }

        }


    }
    companion object{
        val EXTRA_WEAPON = "weapon"
    }
}