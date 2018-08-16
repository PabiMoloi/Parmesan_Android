package za.co.pabimoloi.parmesan.data.repository

import android.arch.lifecycle.LiveData
import retrofit2.Call
import za.co.pabimoloi.parmesan.data.model.Meal
import za.co.pabimoloi.parmesan.data.model.Meals
import za.co.pabimoloi.parmesan.network.RetrofitService
import za.co.pabimoloi.parmesan.network.RetrofitUtility

class MealsRepositoryImpl: IMealsRepository  {

    var retrofitService: RetrofitService = RetrofitUtility.getRetrofitService()

    override fun getLatestMeals(): LiveData<Call<Meals>> {
            return retrofitService.getLatestMeals()
    }

    override fun getMealById(id: String): LiveData<Meal> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMealsByCategory(id: String): LiveData<Meals> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMealsByMainIngredient(ingredient: String): LiveData<Meals> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMealsByArea(area: String): LiveData<Meals> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}