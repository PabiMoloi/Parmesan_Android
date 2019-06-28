package za.co.pabimoloi.parmesan.presentation.latestmeals

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import za.co.pabimoloi.parmesan.R
import za.co.pabimoloi.parmesan.data.model.Category
import za.co.pabimoloi.parmesan.viewmodel.MealCategoriesViewModel

class MealCategoryListAdapter(private val mealCategoryViewModel: MealCategoriesViewModel) : RecyclerView.Adapter<MealCategoryListAdapter.MealCategoryListViewHolder>(){

    class MealCategoryListViewHolder(var view: View): RecyclerView.ViewHolder(view) {

        var categoryName: TextView = view.findViewById(R.id.textViewCategoryName)
        var mealThumb: ImageView = view.findViewById(R.id.imageViewCategoryThumb)
    }
    override fun onBindViewHolder(holderCategory: MealCategoryListViewHolder, position: Int) {
        val mealCategory: Category = mealCategoryViewModel.getMealCategoryAt(position)!!
        holderCategory.categoryName.text = mealCategory.getStrCategory()
        Picasso.get().load(mealCategory.getStrCategoryThumb()).into(holderCategory.mealThumb)
        holderCategory.view.tag = position
    }

    override fun getItemCount(): Int {
        return mealCategoryViewModel.getCategorySize()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealCategoryListViewHolder {
        val listView: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_meal_categories,parent,false)
        return MealCategoryListViewHolder(listView)
    }
}