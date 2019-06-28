package za.co.pabimoloi.parmesan.presentation.category

import android.app.Application
import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import za.co.pabimoloi.parmesan.R
import za.co.pabimoloi.parmesan.data.model.Area
import za.co.pabimoloi.parmesan.data.model.Category
import za.co.pabimoloi.parmesan.presentation.latestmeals.MealCategoryListAdapter
import za.co.pabimoloi.parmesan.viewmodel.AreaListViewModel
import za.co.pabimoloi.parmesan.viewmodel.MealCategoriesViewModel

class MealCategoryFragment: Fragment() {

    companion object {
        fun newInstance(): MealCategoryFragment {
            return MealCategoryFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewModel = AreaListViewModel(Application())
        val mealAreaListAdapter = MealAreaListAdapter(viewModel)
        viewModel.getAreaList()
        val view:View = inflater.inflate(R.layout.fragment_meal_category, container, false)
        val recyclerView =view.findViewById<RecyclerView>(R.id.recyclerView_area)
        recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        recyclerView.adapter = mealAreaListAdapter
        viewModel.areaResponse.observe(this, Observer<List<Area>> {
            it?.let { mealAreaListAdapter.notifyDataSetChanged() }
        })
        return view
    }
}