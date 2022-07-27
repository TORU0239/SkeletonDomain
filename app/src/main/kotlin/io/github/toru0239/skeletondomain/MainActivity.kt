package io.github.toru0239.skeletondomain

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.toru0239.skeletoncore.repository.impl.ProductRepositoryImpl
import io.github.toru0239.skeletoncore.usecase.ProductUseCase
import io.github.toru0239.skeletoncore.usecase.impl.ProductUseCaseImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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