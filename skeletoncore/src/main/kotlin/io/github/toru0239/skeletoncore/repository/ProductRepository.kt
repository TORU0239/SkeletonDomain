package io.github.toru0239.skeletoncore.repository

import io.github.toru0239.skeletoncore.network.ApiResponse
import io.github.toru0239.skeletoncore.product.Product
import io.github.toru0239.skeletoncore.product.ProductList

interface ProductRepository {
    suspend fun getProduct(index: Int): ApiResponse<Product>
    suspend fun getProductList(): ApiResponse<ProductList>
}