package sg.toru.skeletoncore.usecase

import sg.toru.skeletoncore.product.Product
import sg.toru.skeletoncore.product.ProductList

interface ProductUseCase {
    suspend fun getProduct(index: Int): Product
    suspend fun getProductList(): ProductList
}