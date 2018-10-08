package za.co.pabimoloi.parmesan.data.network

import android.arch.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
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
    fun getRandomMeal(): Call<Meals>

    @GET("https://www.themealdb.com/api/json/v1/1/lookup.php?i=")
    fun getMealById(@Query("i")id:String): Call<Meals>
}