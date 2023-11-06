package com.example.ketevan_mdzinarishvili_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private  var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        RestClient.reqResService.getResources(1).enqueue(object: Callback<Data<List<Resource>>> {
            override fun onResponse(
                call: Call<Data<List<Resource>>>,
                response: Response<Data<List<Resource>>>
            ) {
                if (response.isSuccessful && response.body()?.data != null) {
                    Log.d("MyData", response.body()?.data.toString())
                    val adapter = ResourceRecyclerAdapter(response.body()?.data!!)
                    recyclerView?.layoutManager = LinearLayoutManager(this@MainActivity);
                    recyclerView?.adapter = adapter
                }
            }

            override fun onFailure(call: Call<Data<List<Resource>>>, t: Throwable) {
                Log.d("MyData", "onFailure")
            }

        })
    }
}