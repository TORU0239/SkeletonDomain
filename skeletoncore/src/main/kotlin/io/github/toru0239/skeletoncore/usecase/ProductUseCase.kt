package io.github.toru0239.skeletoncore.usecase

import io.github.toru0239.skeletoncore.product.Product
import io.github.toru0239.skeletoncore.product.ProductList

interface ProductUseCase {
    suspend fun getProduct(index: Int): Product
    suspend fun getProductList(): ProductList
}