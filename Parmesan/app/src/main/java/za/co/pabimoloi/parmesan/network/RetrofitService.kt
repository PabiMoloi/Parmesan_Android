package za.co.pabimoloi.parmesan.network

import android.arch.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.GET
import za.co.pabimoloi.parmesan.data.model.Meals

interface RetrofitService {
    @GET("latest.php/")
    fun getLatestMeals(): LiveData<Call<Meals>>
}