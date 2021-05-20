package com.danielchoi.valorantapp.helpersA

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
import com.danielchoi.valorantapp.modelsA.Agent
import com.squareup.picasso.Picasso

class AgentsAdapter(private val agentList : List<Agent>) : RecyclerView.Adapter<AgentsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.agent_item,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {

        return agentList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${agentList.size} ")


        return holder.bind(agentList[position])

    }
    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {


        var imageView = itemView.findViewById<ImageView>(R.id.imageView_agent_pic)
        var textView = itemView.findViewById<TextView>(R.id.textView_agent_name)
        fun bind(agent: Agent) {

            textView.text = agent.displayName
            Picasso.get().load(agent.displayIcon).into(imageView)

            imageView.setOnClickListener{
                // the first argument in the intent is the context. usually, that's the current activity
                // but if you aren't in the activity class, you can access the context through the available view
                val specificAgentIntent = Intent(imageView.context, AgentDetailActivity::class.java)
                specificAgentIntent.putExtra(AgentDetailActivity.EXTRA_AGENT, agent)
                // starting the activity required no object to call it on in an Activity class
                // since we're not in an Activity class, we call it through the context
                imageView.context.startActivity(specificAgentIntent)
            }
        }

    }
}