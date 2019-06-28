package za.co.pabimoloi.parmesan.data.repository

import androidx.lifecycle.LiveData
import retrofit2.Call
import za.co.pabimoloi.parmesan.data.model.*

interface IMealsRepository {

    fun getMealById(id: String,successHandler: (List<Meal>?) -> Unit, failureHandler: (Throwable?) -> Unit)
    fun getLatestMeals(successHandler: (List<Meal>?) -> Unit, failureHandler: (Throwable?) -> Unit)
    fun getMealCategories(successHandler: (List<Category>?) -> Unit, failureHandler: (Throwable?) -> Unit)
    fun getRandomMeals(successHandler: (List<Meal>?) -> Unit, failureHandler: (Throwable?) -> Unit)
    fun getAreaList(successHandler: (List<Area>?) -> Unit, failureHandler: (Throwable?) -> Unit)
}