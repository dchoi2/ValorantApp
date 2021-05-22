package com.danielchoi.valorantapp.activitiesW

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.danielchoi.valorantapp.R
import com.danielchoi.valorantapp.activitiesA.TAG
import com.danielchoi.valorantapp.helpersA.AgentsAdapter
import com.danielchoi.valorantapp.helpersW.WeaponsAdapter
import com.danielchoi.valorantapp.modelsA.Agent
import com.danielchoi.valorantapp.modelsA.AgentWrapper
import com.danielchoi.valorantapp.modelsW.Weapon
import com.danielchoi.valorantapp.modelsW.WeaponWrapper
import com.danielchoi.valorantapp.servicesA.AgentService
import com.danielchoi.valorantapp.servicesA.ServiceBuilder
import com.danielchoi.valorantapp.servicesW.ServiceBuilderW
import com.danielchoi.valorantapp.servicesW.WeaponService
import kotlinx.android.synthetic.main.fragment_agent.*
import kotlinx.android.synthetic.main.fragment_weapon.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class weaponFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_weapon, container, false)

        setHasOptionsMenu(true)
        loadWeapons()

        return rootView
    }

    private fun loadWeapons() {
        //initiate the service
        val destinationService  = ServiceBuilderW.buildService(WeaponService::class.java)
        val requestCall = destinationService.getWeaponList()
        //make network call asynchronously
        requestCall.enqueue(object : Callback<WeaponWrapper> {
            override fun onResponse(call: Call<WeaponWrapper>, response: Response<WeaponWrapper>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val weaponList  = response.body()?.data ?: listOf<Weapon>()
                    recyclerView_weapon.apply {
                        setHasFixedSize(true)
                        // could use LinearLayoutManager (no span count)
                        layoutManager = LinearLayoutManager(activity)
                        adapter = WeaponsAdapter(weaponList)
                    }
                }else{
                    Toast.makeText(activity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<WeaponWrapper>, t: Throwable) {
                Toast.makeText(activity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "error: " + t?.message)
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
            weaponFragment()
    }
}