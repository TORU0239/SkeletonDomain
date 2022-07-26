package sg.toru.skeletoncore.network

sealed class ApiResponse<out T> {
    class ApiSuccess<T>(val response: T): ApiResponse<T>()
    object ApiEmpty: ApiResponse<Nothing>()
    object ApiFailure: ApiResponse<Nothing>()
    class ApiException(val message:String): ApiResponse<Nothing>()
}