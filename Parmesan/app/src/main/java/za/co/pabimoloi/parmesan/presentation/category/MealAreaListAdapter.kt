package za.co.pabimoloi.parmesan.presentation.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import za.co.pabimoloi.parmesan.R
import za.co.pabimoloi.parmesan.data.model.Area
import za.co.pabimoloi.parmesan.viewmodel.AreaListViewModel

class MealAreaListAdapter(private val areaListViewModel: AreaListViewModel) : RecyclerView.Adapter<MealAreaListAdapter.MealAreaListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealAreaListHolder {
        val listView: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_meal_categories,parent,false)
        return MealAreaListHolder(listView)
    }

    override fun getItemCount(): Int {
       return areaListViewModel.getAreaListSize()
    }

    override fun onBindViewHolder(holder: MealAreaListHolder, position: Int) {
        val mealArea: Area = areaListViewModel.getAreaAtPosition(position)!!
        holder.areaName.text = mealArea.getStrArea()
        holder.view.tag = position
    }

    class MealAreaListHolder(var view: View): RecyclerView.ViewHolder(view) {
        var areaName: TextView = view.findViewById(R.id.textViewAreaName)
    }
}