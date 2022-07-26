package sg.toru.skeletoncore.product

data class Product(
    val id: Int = -1,
    val title: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val discountPercentage: Double = 0.0,
    val rating: Double = 0.0,
    val stock: Double = 0.0,
    val brand: String = "",
    val category: String = "",
    val thumbnail: String = "",
    val images: List<String> = listOf(),
)

data class ProductList(
    val products: List<Product> = listOf(),
)