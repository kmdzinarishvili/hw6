
package com.example.ketevan_mdzinarishvili_6

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    private var nameTextView: TextView? = null
    private var pantoneValueTextView: TextView? = null
    private var yearTextView: TextView? = null
    private var containerView: ConstraintLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        nameTextView = findViewById(R.id.name);
        pantoneValueTextView = findViewById(R.id.pantoneValue);
        yearTextView = findViewById(R.id.year);
        containerView = findViewById(R.id.container)
        val id = intent.extras?.getLong("id")
        if(id != null) {
            RestClient.reqResService.getResourceById(id).enqueue(object : Callback<Data<Resource>> {
                override fun onResponse(
                    call: Call<Data<Resource>>,
                    response: Response<Data<Resource>>
                ) {
                    if (response.isSuccessful && response.body()?.data != null) {
                        val data = response.body()?.data
                        nameTextView?.text = data?.name;
                        pantoneValueTextView?.text = data?.pantoneValue;
                        yearTextView?.text = data?.year.toString();
                        containerView?.setBackgroundColor(Color.parseColor(data?.color));

                    }
                }

                override fun onFailure(call: Call<Data<Resource>>, t: Throwable) {
                    Log.d("MyData", "onFailure")
                }
            })
        }
    }
}