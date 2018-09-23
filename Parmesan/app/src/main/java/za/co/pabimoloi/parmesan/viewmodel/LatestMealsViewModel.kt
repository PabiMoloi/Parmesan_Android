package za.co.pabimoloi.parmesan.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import za.co.pabimoloi.parmesan.data.InjectorUtil
import za.co.pabimoloi.parmesan.data.model.Meal
import za.co.pabimoloi.parmesan.data.repository.IMealsRepository
import javax.inject.Inject

class LatestMealsViewModel(private val application: Application): ViewModel() {

    @Inject
    lateinit var iMealsRepository: IMealsRepository
     var mealsResponse: MutableLiveData<List<Meal>> = MutableLiveData()
    var apiError = MutableLiveData<Throwable>()

    fun getMeals() {
        iMealsRepository = InjectorUtil.getInstance(application)
        iMealsRepository.getLatestMeals(
                {
                    mealsResponse.value = it
                },
                {
                    apiError.value = it

                })
    }
    fun getMealSize(): Int {
        mealsResponse.value?.let {
            return it.size
        }
        return 0
    }
    fun getMealAt(position: Int): Meal? {
        if (position < getMealSize()) {
            return mealsResponse.value?.get(position)
        } else {
            return null
        }
    }
}
