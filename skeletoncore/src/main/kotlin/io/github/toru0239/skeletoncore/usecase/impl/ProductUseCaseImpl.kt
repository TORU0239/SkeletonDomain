package io.github.toru0239.skeletoncore.usecase.impl

import android.util.Log
import io.github.toru0239.skeletoncore.network.ApiResponse
import io.github.toru0239.skeletoncore.product.Product
import io.github.toru0239.skeletoncore.product.ProductList
import io.github.toru0239.skeletoncore.repository.ProductRepository
import io.github.toru0239.skeletoncore.usecase.ProductUseCase

class ProductUseCaseImpl(
    private val repository: ProductRepository
): ProductUseCase {
    override suspend fun getProduct(index: Int): Product {
        return when (val response = repository.getProduct(index = index)) {
            is ApiResponse.ApiSuccess -> {
               response.response
            }
            is ApiResponse.ApiFailure -> {
                Product()
            }
            is ApiResponse.ApiEmpty -> {
                Product()
            }
            is ApiResponse.ApiException -> {
                Log.e("Toru", response.message)
                Product()
            }
        }

    }

    override suspend fun getProductList(): ProductList {
        return when (val response = repository.getProductList()) {
            is ApiResponse.ApiSuccess -> {
                response.response
            }
            is ApiResponse.ApiException -> {
                Log.e("Toru", response.message)
                ProductList()

            }
            is ApiResponse.ApiFailure -> {
                ProductList()
            }
            is ApiResponse.ApiEmpty -> {
                ProductList()
            }
        }
    }
}