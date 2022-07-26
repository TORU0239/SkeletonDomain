package sg.toru.skeletoncore.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import sg.toru.skeletoncore.product.Product
import sg.toru.skeletoncore.product.ProductList

interface NetworkService {
    @GET("products/{index}")
    suspend fun getProduct(@Path("index") index: Int): Response<Product>

    @GET("products")
    suspend fun getProductList(): Response<ProductList>
}