package sg.toru.skeletondomain

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import sg.toru.skeletoncore.repository.impl.ProductRepositoryImpl
import sg.toru.skeletoncore.usecase.ProductUseCase
import sg.toru.skeletoncore.usecase.impl.ProductUseCaseImpl

class MainActivity : AppCompatActivity() {

    private val useCase: ProductUseCase by lazy {
        ProductUseCaseImpl(
            ProductRepositoryImpl()
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.IO).launch {
            useCase.getProduct(index = 1)
        }
    }
}