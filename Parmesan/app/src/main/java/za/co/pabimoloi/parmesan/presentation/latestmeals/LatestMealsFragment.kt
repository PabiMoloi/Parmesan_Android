package za.co.pabimoloi.parmesan.presentation.latestmeals

import android.app.Application
import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_latest_meals.view.*
import za.co.pabimoloi.parmesan.R
import za.co.pabimoloi.parmesan.data.model.Category
import za.co.pabimoloi.parmesan.data.model.Meal
import za.co.pabimoloi.parmesan.presentation.category.MealCategoryListAdapter
import za.co.pabimoloi.parmesan.viewmodel.LatestMealsViewModel
import za.co.pabimoloi.parmesan.viewmodel.MealCategoriesViewModel

class LatestMealsFragment : Fragment() {
    companion object {
        fun newInstance(): LatestMealsFragment {
            return LatestMealsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_latest_meals, container, false)
        initLatestMeals(view)
        initMealCategories(view)
        setupToolbar(view)
        return view
    }

    private fun initLatestMeals(view: View){
        val latestMealViewModel = LatestMealsViewModel(Application())
        val latestMealsListAdapter = LatestMealsListAdapter(latestMealViewModel)
        latestMealViewModel.getMeals()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_latest_meals)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = latestMealsListAdapter
        recyclerView.isNestedScrollingEnabled = false
        latestMealViewModel.mealsResponse.observe(this, Observer<List<Meal>> {
            it?.let { latestMealsListAdapter.notifyDataSetChanged() }
        })
    }

    private fun initMealCategories(view: View) {
        val viewModel = MealCategoriesViewModel(Application())
        val mealCategoryListAdapter = MealCategoryListAdapter(viewModel)
        viewModel.getMealCategories()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_meal_category)
        recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = mealCategoryListAdapter
        recyclerView.isNestedScrollingEnabled = false
        viewModel.categoryResponse.observe(this, Observer<List<Category>> {
            it?.let { mealCategoryListAdapter.notifyDataSetChanged() }
        })
    }

    private fun setupToolbar(view: View) {
        //view.toolbar_discover.title = resources.getString(R.string.title_latest_meals)
    }
}