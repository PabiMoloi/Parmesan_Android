package za.co.pabimoloi.parmesan.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import za.co.pabimoloi.parmesan.data.InjectorUtil
import za.co.pabimoloi.parmesan.data.model.Area
import za.co.pabimoloi.parmesan.data.model.Category
import za.co.pabimoloi.parmesan.data.repository.IMealsRepository

class AreaListViewModel(private val application: Application) : ViewModel() {

    lateinit var iMealsRepository: IMealsRepository
    var areaResponse: MutableLiveData<List<Area>> = MutableLiveData()
    var apiError = MutableLiveData<Throwable>()

    fun getAreaList() {
        iMealsRepository = InjectorUtil.getInstance(application)
        iMealsRepository.getAreaList({
            areaResponse.value = it
        },
                {
                    apiError.value = it
                }
        )
    }

    fun getAreaListSize(): Int {
        areaResponse.value?.let {
            return it.size
        }
        return 0
    }

    fun getAreaAtPosition(position: Int): Area? {
        return if (position < getAreaListSize()) {
            areaResponse.value?.get(position)
        } else {
            null
        }
    }
}

