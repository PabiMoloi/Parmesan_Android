package za.co.pabimoloi.parmesan.presentation.home

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import za.co.pabimoloi.parmesan.R
import za.co.pabimoloi.parmesan.data.model.Meal
import za.co.pabimoloi.parmesan.data.model.Meals
import za.co.pabimoloi.parmesan.network.RetrofitService
import za.co.pabimoloi.parmesan.network.RetrofitUtility


class Home : AppCompatActivity(){

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_meal -> {
               // message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_meal_categories -> {
                //message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_meal_ingredient -> {
                //message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_meal_location -> {
                //message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    //var retrofitService: RetrofitService = RetrofitUtility.getRetrofitService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

       /* retrofitService.getLatestMeals().enqueue(object: Callback<Meals> {
            override fun onFailure(call: Call<Meals>?, t: Throwable?) {
               Log.d("Failure call","Call Failed")
            }

            override fun onResponse(call: Call<Meals>?, response: Response<Meals>?) {
                Log.d("Response", response!!.body()!!.meals!!.get(1).getStrIngredient1())
                var meals2: List<Meal>? = null
                meals2 = response!!.body()!!.meals!!.toList()
                //Log.d("Successful call","Call Successful")
            }

        })*/


    }
}
