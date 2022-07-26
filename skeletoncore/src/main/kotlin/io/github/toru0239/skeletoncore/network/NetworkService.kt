package io.github.toru0239.skeletoncore.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import io.github.toru0239.skeletoncore.product.Product
import io.github.toru0239.skeletoncore.product.ProductList

interface NetworkService {
    @GET("products/{index}")
    suspend fun getProduct(@Path("index") index: Int): Response<Product>

    @GET("products")
    suspend fun getProductList(): Response<ProductList>
}