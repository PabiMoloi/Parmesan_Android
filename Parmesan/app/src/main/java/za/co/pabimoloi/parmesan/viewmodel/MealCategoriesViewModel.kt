package za.co.pabimoloi.parmesan.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import za.co.pabimoloi.parmesan.data.InjectorUtil
import za.co.pabimoloi.parmesan.data.model.Category
import za.co.pabimoloi.parmesan.data.repository.IMealsRepository

class MealCategoriesViewModel(private val application: Application): ViewModel()  {

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
        return if (position < getCategorySize()) {
            categoryResponse.value?.get(position)
        } else {
            null
        }
    }
}