package za.co.pabimoloi.parmesan.data.repository

import android.arch.lifecycle.LiveData
import retrofit2.Call
import za.co.pabimoloi.parmesan.data.model.Category
import za.co.pabimoloi.parmesan.data.model.CategoryList
import za.co.pabimoloi.parmesan.data.model.Meal
import za.co.pabimoloi.parmesan.data.model.Meals

interface IMealsRepository {

    fun getLatestMeals(): Call<Meals>
    fun getMealById(id: String): LiveData<Meal>
    fun getMealsByCategory(id: String): LiveData<Meals>
    fun getMealsByMainIngredient(ingredient: String): LiveData<Meals>
    fun getMealsByArea(area: String): LiveData<Meals>
    fun getLatestMeals(successHandler: (List<Meal>?) -> Unit, failureHandler: (Throwable?) -> Unit)
    fun getMealCategories(successHandler: (List<Category>?) -> Unit, failureHandler: (Throwable?) -> Unit)
    fun getRandomMeals(successHandler: (List<Meal>?) -> Unit, failureHandler: (Throwable?) -> Unit)
}