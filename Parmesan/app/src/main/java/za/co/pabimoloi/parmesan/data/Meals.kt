package za.co.pabimoloi.parmesan.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Meals {

    @SerializedName("meals")
    @Expose
    var meals: List<Meal>? = null

    /*fun setMeals(meals: List<Meal>) {
        this.meals = meals
    }
    fun getMeals(): List<Meal>? {
        return meals
    }*/
}