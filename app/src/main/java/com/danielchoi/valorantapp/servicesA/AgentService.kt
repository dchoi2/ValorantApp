package com.danielchoi.valorantapp.servicesA

import com.danielchoi.valorantapp.modelsA.AgentWrapper
import retrofit2.Call
import retrofit2.http.GET

interface AgentService {
   // @GET("v3/3b27a6b1-5530-4334-a622-7aff8d3486bf")
   @GET("agents")
    fun getAgentsList () : Call<AgentWrapper>
}