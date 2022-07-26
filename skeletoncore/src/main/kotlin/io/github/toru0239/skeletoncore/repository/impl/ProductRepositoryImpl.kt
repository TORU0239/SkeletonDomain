package io.github.toru0239.skeletoncore.repository.impl

import io.github.toru0239.skeletoncore.module.NetworkModule
import io.github.toru0239.skeletoncore.network.ApiDataSource
import io.github.toru0239.skeletoncore.network.ApiResponse
import io.github.toru0239.skeletoncore.product.Product
import io.github.toru0239.skeletoncore.product.ProductList
import io.github.toru0239.skeletoncore.repository.ProductRepository

class ProductRepositoryImpl: ProductRepository {
    override suspend fun getProduct(index: Int): ApiResponse<Product> {
        return ApiDataSource.createResponse {
            NetworkModule.getNetworkService().getProduct(index = index)
        }
    }

    override suspend fun getProductList(): ApiResponse<ProductList> {
        return ApiDataSource.createResponse {
            NetworkModule.getNetworkService().getProductList()
        }
    }
}