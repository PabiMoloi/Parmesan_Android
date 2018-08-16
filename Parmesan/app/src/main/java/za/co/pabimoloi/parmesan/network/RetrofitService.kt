package za.co.pabimoloi.parmesan.network

import retrofit2.Call
import retrofit2.http.GET
import za.co.pabimoloi.parmesan.data.Meals

interface RetrofitService {
    @GET("latest.php/")
    fun getLatestMeals(): Call<Meals>
}