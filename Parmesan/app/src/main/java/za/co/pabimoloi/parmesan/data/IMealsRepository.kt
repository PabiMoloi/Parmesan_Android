package za.co.pabimoloi.parmesan.data

import android.arch.lifecycle.LiveData

interface IMealsRepository {
    fun getLatestMeals(): LiveData<List<Meals>>
    fun getMealById(id: String): LiveData<Meal>
    fun getMealsByCategory(id: String): LiveData<Meals>
    fun getMealsByMainIngredient(ingredient: String): LiveData<Meals>
    fun getMealsByArea(area: String): LiveData<Meals>
}