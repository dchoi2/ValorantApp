package com.danielchoi.valorantapp.activitiesA

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.danielchoi.valorantapp.R
import com.danielchoi.valorantapp.modelsA.Ability
import com.danielchoi.valorantapp.modelsA.Agent
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_agent_detail.*

val TAG = "AgentDetailActivity"

class AgentDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agent_detail)

        if (intent.getParcelableExtra<Agent>(EXTRA_AGENT) != null)
        {
            val agent = intent.getParcelableExtra<Agent>(EXTRA_AGENT)
            val agentList  = agent?.abilities ?: listOf<Ability>()
            Log.d(TAG, "onCreate: " + agent)

            if(agent != null) {
                Picasso.get().load(agent.displayIconSmall).into(imageView_agentDetail_pic)
                textView_agentDetail_name.text = agent.displayName
                textView_agentDetail_desc.text = agent.description

                textView_agentDetail_ability1.text = agentList[0].displayName
                textView_agentDetail_ability2.text = agentList[1].displayName
                textView_agentDetail_ability3.text = agentList[2].displayName
                textView_agentDetail_ability4.text = agentList[3].displayName

                Picasso.get().load(agentList[0].displayIcon).into(imageView_agentDetail_ability1pic)
                Picasso.get().load(agentList[1].displayIcon).into(imageView_agentDetail_ability2pic)
                Picasso.get().load(agentList[2].displayIcon).into(imageView_agentDetail_ability3pic)
                Picasso.get().load(agentList[3].displayIcon).into(imageView_agentDetail_ability4pic)

                textView_agentDetail_ability1desc.text = agentList[0].description
                textView_agentDetail_ability2desc.text = agentList[1].description
                textView_agentDetail_ability3desc.text = agentList[2].description
                textView_agentDetail_ability4desc.text = agentList[3].description
            }

        }


    }
    companion object{
        val EXTRA_AGENT = "agent"
    }
}