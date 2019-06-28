package za.co.pabimoloi.parmesan.presentation.random

import android.app.Application
import androidx.lifecycle.Observer
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import za.co.pabimoloi.parmesan.R
import za.co.pabimoloi.parmesan.data.model.Meal
import za.co.pabimoloi.parmesan.viewmodel.RandomMealViewModel

class RandomMealsFragment: Fragment() {
    companion object {
        fun newInstance(): RandomMealsFragment {
            return RandomMealsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val viewModel = RandomMealViewModel(Application())
        val randomMealAdapter = RandomMealAdapter(viewModel)
        viewModel.getMeals()
        val view: View = inflater.inflate(R.layout.fragment_random_meal, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewRandom)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = randomMealAdapter
        viewModel.mealsResponse.observe(this, Observer<List<Meal>> {
            it?.let { randomMealAdapter.notifyDataSetChanged() }
        })
        return view
    }
}