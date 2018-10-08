package za.co.pabimoloi.parmesan.data.repository

import android.arch.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import za.co.pabimoloi.parmesan.data.model.Category
import za.co.pabimoloi.parmesan.data.model.CategoryList
import za.co.pabimoloi.parmesan.data.model.Meal
import za.co.pabimoloi.parmesan.data.model.Meals
import za.co.pabimoloi.parmesan.data.network.RetrofitService
import za.co.pabimoloi.parmesan.data.network.RetrofitUtility

class MealsRepositoryImpl(private var retrofitService: RetrofitService): IMealsRepository  {

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
        }    }

    override fun getMealCategories(successHandler: (List<Category>?) -> Unit, failureHandler: (Throwable?) -> Unit) {
      run {
       retrofitService.getMealCategories().enqueue(object : Callback<CategoryList>{
           override fun onFailure(call: Call<CategoryList>, t: Throwable) {
               failureHandler(t)
           }

           override fun onResponse(call: Call<CategoryList>, response: Response<CategoryList>) {
               response.body()?.let { successHandler(it.getCategories()) }
           }
       })
       }
    }

    override fun getLatestMeals(successHandler: (List<Meal>?)-> Unit, failureHandler: (Throwable?) ->Unit) {
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

    override fun getMealById(id: String,successHandler: (List<Meal>?) -> Unit, failureHandler: (Throwable?) -> Unit) {
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