package za.co.pabimoloi.parmesan.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AreaList {
    @SerializedName("meals")
    @Expose
    private var areas: List<Area>? = null

    fun getAreas(): List<Area>? {
        return areas
    }

    fun setMeals(areas: List<Area>) {
        this.areas = areas
    }

}