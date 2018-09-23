package za.co.pabimoloi.parmesan.data

import android.content.Context
import android.provider.ContactsContract
import za.co.pabimoloi.parmesan.data.network.RetrofitService
import za.co.pabimoloi.parmesan.data.network.RetrofitUtility
import za.co.pabimoloi.parmesan.data.repository.IMealsRepository
import za.co.pabimoloi.parmesan.data.repository.MealsRepositoryImpl

class InjectorUtil {
companion object {

    private var iMealsRepository: IMealsRepository? = null
    var retrofitService: RetrofitService = RetrofitUtility.getRetrofitService()

    fun getInstance(context: Context): IMealsRepository {
        if (iMealsRepository == null) {
            synchronized(IMealsRepository::class.java) {
                if (iMealsRepository == null) {
                    iMealsRepository = MealsRepositoryImpl(retrofitService)
                }
            }
        }
        return iMealsRepository!!
    }
}
}