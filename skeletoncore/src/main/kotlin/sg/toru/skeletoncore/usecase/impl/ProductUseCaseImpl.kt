package sg.toru.skeletoncore.usecase.impl

import android.util.Log
import sg.toru.skeletoncore.network.ApiResponse
import sg.toru.skeletoncore.product.Product
import sg.toru.skeletoncore.product.ProductList
import sg.toru.skeletoncore.repository.ProductRepository
import sg.toru.skeletoncore.usecase.ProductUseCase

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