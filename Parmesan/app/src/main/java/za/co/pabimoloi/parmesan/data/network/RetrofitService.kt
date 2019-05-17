package za.co.pabimoloi.parmesan.data.network

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import za.co.pabimoloi.parmesan.data.model.*

interface RetrofitService {
    @GET("latest.php/")
    fun getLatestMeals(): Call<Meals>

    @GET("categories.php")
    fun getMealCategories(): Call<CategoryList>

    @GET("random.php")
    fun getRandomMeal(): Call<Meals>

    @GET("lookup.php?i=")
    fun getMealById(@Query("i")id:String): Call<Meals>

    @GET("list.php?a=list")
    fun getMealAreaCategories(): Call<AreaList>
}