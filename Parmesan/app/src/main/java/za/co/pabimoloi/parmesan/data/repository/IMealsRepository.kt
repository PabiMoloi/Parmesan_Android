package za.co.pabimoloi.parmesan.data.repository

import android.arch.lifecycle.LiveData
import retrofit2.Call
import za.co.pabimoloi.parmesan.data.model.Meal
import za.co.pabimoloi.parmesan.data.model.Meals

interface IMealsRepository {

    fun getLatestMeals(): LiveData<Call<Meals>>
    fun getMealById(id: String): LiveData<Meal>
    fun getMealsByCategory(id: String): LiveData<Meals>
    fun getMealsByMainIngredient(ingredient: String): LiveData<Meals>
    fun getMealsByArea(area: String): LiveData<Meals>
}