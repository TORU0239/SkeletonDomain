package sg.toru.skeletoncore.repository.impl

import sg.toru.skeletoncore.module.NetworkModule
import sg.toru.skeletoncore.network.ApiDataSource
import sg.toru.skeletoncore.network.ApiResponse
import sg.toru.skeletoncore.product.Product
import sg.toru.skeletoncore.product.ProductList
import sg.toru.skeletoncore.repository.ProductRepository

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