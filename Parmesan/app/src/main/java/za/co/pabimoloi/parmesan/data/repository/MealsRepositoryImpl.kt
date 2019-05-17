package za.co.pabimoloi.parmesan.data.repository

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import za.co.pabimoloi.parmesan.data.model.*
import za.co.pabimoloi.parmesan.data.network.RetrofitService
import za.co.pabimoloi.parmesan.data.network.RetrofitUtility

class MealsRepositoryImpl(private var retrofitService: RetrofitService) : IMealsRepository {

    override fun getAreaList(successHandler: (List<Area>?) -> Unit, failureHandler: (Throwable?) -> Unit) {
        run {
            retrofitService.getMealAreaCategories().enqueue(object : Callback<AreaList> {
                override fun onFailure(call: Call<AreaList>?, t: Throwable) {
                    failureHandler(t)
                }

                override fun onResponse(call: Call<AreaList>?, response: Response<AreaList>) {
                    response.body()?.let { successHandler(it.getAreas()) }
                }

            })
        }

    }

    override fun getRandomMeals(successHandler: (List<Meal>?) -> Unit, failureHandler: (Throwable?) -> Unit) {
        run {
            retrofitService.getRandomMeal().enqueue(object : Callback<Meals> {
                override fun onResponse(call: Call<Meals>?, response: Response<Meals>?) {
                    response?.body()?.let {
                        successHandler(it.meals)
                    }
                }

                override fun onFailure(call: Call<Meals>?, t: Throwable?) {
                    failureHandler(t)
                }
            })
        }
    }

    override fun getMealCategories(successHandler: (List<Category>?) -> Unit, failureHandler: (Throwable?) -> Unit) {
        run {
            retrofitService.getMealCategories().enqueue(object : Callback<CategoryList> {
                override fun onFailure(call: Call<CategoryList>, t: Throwable) {
                    failureHandler(t)
                }

                override fun onResponse(call: Call<CategoryList>, response: Response<CategoryList>) {
                    response.body()?.let { successHandler(it.getCategories()) }
                }
            })
        }
    }

    override fun getLatestMeals(successHandler: (List<Meal>?) -> Unit, failureHandler: (Throwable?) -> Unit) {
        run {
            retrofitService.getLatestMeals().enqueue(object : Callback<Meals> {
                override fun onResponse(call: Call<Meals>?, response: Response<Meals>?) {
                    response?.body()?.let {
                        successHandler(it.meals)
                    }
                }

                override fun onFailure(call: Call<Meals>?, t: Throwable?) {
                    failureHandler(t)
                }
            })
        }
    }

    override fun getMealById(id: String, successHandler: (List<Meal>?) -> Unit, failureHandler: (Throwable?) -> Unit) {
        run {
            retrofitService.getMealById(id).enqueue(object : Callback<Meals> {
                override fun onResponse(call: Call<Meals>?, response: Response<Meals>?) {
                    response?.body()?.let {
                        successHandler(it.meals)
                    }
                }

                override fun onFailure(call: Call<Meals>?, t: Throwable?) {
                    failureHandler(t)
                }
            })
        }
    }
}