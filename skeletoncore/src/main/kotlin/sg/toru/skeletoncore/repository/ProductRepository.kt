package sg.toru.skeletoncore.repository

import sg.toru.skeletoncore.network.ApiResponse
import sg.toru.skeletoncore.product.Product
import sg.toru.skeletoncore.product.ProductList

interface ProductRepository {
    suspend fun getProduct(index: Int): ApiResponse<Product>
    suspend fun getProductList(): ApiResponse<ProductList>
}