package za.co.pabimoloi.parmesan.presentation.home

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import za.co.pabimoloi.parmesan.R
import za.co.pabimoloi.parmesan.presentation.MealCategoryFragment
import za.co.pabimoloi.parmesan.presentation.latestmeals.LatestMealsFragment


class Home : AppCompatActivity(){

    //private lateinit var latestMealsListAdapter: LatestMealsListAdapter

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_meal -> {
                val latestMealsFragment = LatestMealsFragment.newInstance()
                openFragment(latestMealsFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_meal_categories -> {
                val mealCategoryFragment = MealCategoryFragment.newInstance()
                openFragment(mealCategoryFragment)
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
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout_home_screen, fragment)
        transaction.commit()
    }

    //var retrofitService: RetrofitService = RetrofitUtility.getRetrofitService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.setSelectedItemId(R.id.navigation_meal)

        //recyclerView.adapter = latestMealsListAdapter
       // val viewModel = LatestMealsViewModel(application)
       // viewModel.getMeals()

//        viewModel.mealsResponse.observe(this, Observer<List<Meal>> { meals -> latestMealsListAdapter.setMeals(meals!!) })

        /*retrofitService.getLatestMeals().enqueue(object: Callback<Meals> {
            override fun onFailure(call: Call<Meals>?, t: Throwable?) {
               Log.d("Failure call","Call Failed")
            }

            override fun onResponse(call: Call<Meals>?, response: Response<Meals>?) {
                Log.d("Response", response!!.body()!!.meals!!.get(1).getStrIngredient1())
                var meals2: List<Meal>? = null
                meals2 = response!!.body()!!.meals!!.toList()
                Log.d("Successful call","Call Successful")
            }

        })*/

    }
}
