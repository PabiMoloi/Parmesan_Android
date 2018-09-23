package za.co.pabimoloi.parmesan.data.network

import android.arch.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.GET
import za.co.pabimoloi.parmesan.data.model.Category
import za.co.pabimoloi.parmesan.data.model.CategoryList
import za.co.pabimoloi.parmesan.data.model.Meal
import za.co.pabimoloi.parmesan.data.model.Meals

interface RetrofitService {
    @GET("latest.php/")
    fun getLatestMeals(): Call<Meals>

    @GET("categories.php")
    fun getMealCategories(): Call<CategoryList>

    @GET("random.php")
    fun getRandomMeal(): Call<Meal>
}