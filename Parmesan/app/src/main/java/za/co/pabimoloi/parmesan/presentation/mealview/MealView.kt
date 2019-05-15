package za.co.pabimoloi.parmesan.presentation.mealview

import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import za.co.pabimoloi.parmesan.R
import za.co.pabimoloi.parmesan.data.model.Meal
import za.co.pabimoloi.parmesan.viewmodel.MealViewViewModel

class MealView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_view)
        val mealId = intent.getStringExtra("mealId")
        val viewModel = MealViewViewModel(application)
        val mealViewAdapter = MealViewAdapter(viewModel)
        viewModel.getMealById(mealId)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_latest_meals)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mealViewAdapter
        viewModel.mealsResponse.observe(this, Observer<List<Meal>> {
            it?.let { mealViewAdapter.notifyDataSetChanged() }
        })

    }
}
