package za.co.pabimoloi.parmesan.presentation.category

import android.app.Application
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import za.co.pabimoloi.parmesan.R
import za.co.pabimoloi.parmesan.data.model.Category
import za.co.pabimoloi.parmesan.viewmodel.MealCategoriesViewModel

class MealCategoryFragment: Fragment() {

    companion object {
        fun newInstance(): MealCategoryFragment {
            return MealCategoryFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val viewModel = MealCategoriesViewModel(Application())
        val mealCategoryListAdapter = MealCategoryListAdapter(viewModel)
        viewModel.getMealCategories()
        val view:View = inflater.inflate(R.layout.fragment_meal_category, container, false)
        val recyclerView =view.findViewById<RecyclerView>(R.id.categoryRecycler)
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
                //LinearLayoutManager(activity)
        recyclerView.adapter = mealCategoryListAdapter
        viewModel.categoryResponse.observe(this, Observer<List<Category>> {
            it?.let { mealCategoryListAdapter.notifyDataSetChanged() }
        })

        return view
    }
}