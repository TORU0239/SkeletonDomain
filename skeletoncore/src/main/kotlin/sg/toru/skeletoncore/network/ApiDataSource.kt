package sg.toru.skeletoncore.network

import retrofit2.Response

class ApiDataSource {
    companion object {
        inline fun<reified T:Any> createResponse(call: ()-> Response<T>):ApiResponse<T> {
            return try {
                val result = call.invoke()
                if (result.isSuccessful) {
                    result.body()?.let {
                        ApiResponse.ApiSuccess(it)
                    } ?: ApiResponse.ApiEmpty
                } else {
                    ApiResponse.ApiFailure
                }

            } catch (e: Exception) {
                ApiResponse.ApiException(e.message ?: "Exception")
            }
        }
    }
}