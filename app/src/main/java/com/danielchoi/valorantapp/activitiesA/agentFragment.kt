package com.danielchoi.valorantapp.activitiesA

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import com.danielchoi.valorantapp.R
import com.danielchoi.valorantapp.helpersA.AgentsAdapter
import com.danielchoi.valorantapp.modelsA.Agent
import com.danielchoi.valorantapp.modelsA.AgentWrapper
import com.danielchoi.valorantapp.servicesA.AgentService
import com.danielchoi.valorantapp.servicesA.ServiceBuilder
import kotlinx.android.synthetic.main.fragment_agent.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class agentFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_agent, container, false)

        setHasOptionsMenu(true)

        loadAgents()


         return rootView
    }

    private fun loadAgents() {
        //initiate the service
        val destinationService  = ServiceBuilder.buildService(AgentService::class.java)
        val requestCall = destinationService.getAgentsList()
        //make network call asynchronously
        requestCall.enqueue(object : Callback<AgentWrapper> {
            override fun onResponse(call: Call<AgentWrapper>, response: Response<AgentWrapper>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val agentList  = response.body()?.data ?: listOf<Agent>()
                    recyclerView_main.apply {
                        setHasFixedSize(true)
                        // could use LinearLayoutManager (no span count)
                        layoutManager = GridLayoutManager(activity, 2)
                        adapter = AgentsAdapter(agentList)
                    }
                }else{
                    Toast.makeText(activity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<AgentWrapper>, t: Throwable) {
                Toast.makeText(activity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    companion object {

        fun newInstance() =
            agentFragment()
                }
            }
