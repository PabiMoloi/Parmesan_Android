package za.co.pabimoloi.parmesan.data.network

class RetrofitUtility {
    companion object {
        val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
        fun getRetrofitService(): RetrofitService {
            return RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)

        }
    }
}