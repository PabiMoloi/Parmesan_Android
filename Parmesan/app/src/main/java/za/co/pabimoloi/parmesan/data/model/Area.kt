package za.co.pabimoloi.parmesan.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Area {
    @SerializedName("strArea")
    @Expose
    private var strArea: String? = null

    fun getStrArea(): String? {
        return strArea
    }

    fun setStrArea(strArea: String) {
        this.strArea = strArea
    }
}