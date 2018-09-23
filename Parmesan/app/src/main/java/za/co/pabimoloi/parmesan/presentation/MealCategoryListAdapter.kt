package za.co.pabimoloi.parmesan.presentation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import za.co.pabimoloi.parmesan.R
import za.co.pabimoloi.parmesan.data.model.Category
import za.co.pabimoloi.parmesan.data.model.Meal
import za.co.pabimoloi.parmesan.viewmodel.MealCategoriesViewModel

class MealCategoryListAdapter(val mealCategoryViewModel: MealCategoriesViewModel) : RecyclerView.Adapter<MealCategoryListAdapter.MealCategoryListViewHolder>(){
    private lateinit var mealList: List<Meal>

    class MealCategoryListViewHolder(var view: View): RecyclerView.ViewHolder(view) {

        var categoryName: TextView
        //var categoryDescription: TextView
        var mealThumb: ImageView

        init {
            categoryName = view.findViewById(R.id.textViewCategoryName)
            //categoryDescription = view.findViewById(R.id.textViewCategoryDesciption)
            mealThumb = view.findViewById(R.id.imageViewCategoryThumb)

        }
    }
    override fun onBindViewHolder(holderCategory: MealCategoryListViewHolder, position: Int) {
        val mealCategory: Category = mealCategoryViewModel.getMealCategoryAt(position)!!
        holderCategory.categoryName.text = mealCategory.getStrCategory()
        //holderCategory.categoryDescription.text = mealCategory.getStrCategoryDescription()
        Picasso.get().load(mealCategory.getStrCategoryThumb()).into(holderCategory.mealThumb)
        holderCategory.view.tag = position
    }

    override fun getItemCount(): Int {
        return mealCategoryViewModel.getCategorySize()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealCategoryListViewHolder {
        val listView: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_meal_categories,parent,false)
        return MealCategoryListViewHolder(listView)
    }
}