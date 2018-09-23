package za.co.pabimoloi.parmesan.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import za.co.pabimoloi.parmesan.data.InjectorUtil
import za.co.pabimoloi.parmesan.data.model.Category
import za.co.pabimoloi.parmesan.data.model.Meal
import za.co.pabimoloi.parmesan.data.repository.IMealsRepository
import javax.inject.Inject

class MealCategoriesViewModel(private val application: Application): ViewModel()  {

    @Inject
    lateinit var iMealsRepository: IMealsRepository
    var categoryResponse: MutableLiveData<List<Category>> = MutableLiveData()
    var apiError = MutableLiveData<Throwable>()

    fun getMealCategories(){
        iMealsRepository = InjectorUtil.getInstance(application)
        iMealsRepository.getMealCategories(
                {
                    categoryResponse.value = it
                },
                {
                    apiError.value = it
                }
        )
    }
    fun getCategorySize(): Int {
        categoryResponse.value?.let {
            return it.size
        }
        return 0
    }
    fun getMealCategoryAt(position: Int): Category? {
        if (position < getCategorySize()) {
            return categoryResponse.value?.get(position)
        } else {
            return null
        }
    }
}