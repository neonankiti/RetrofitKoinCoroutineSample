package com.neonankiti.retrofitkoincoroutinesample

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

class MyApplication : Application() {
    val appModule = module {
        // define any other modules if any.
        single<AnimalRepository> { BisonRepositoryImpl() }

        // scope define which instance's lifecycle the scoped(BisonUseCase this time) should follow.
        scope(named<MainActivity>()) {
            // You don't have to specify the instance by yourself
            // because get() func get the instance from class type.
            scoped { BisonUseCase(get()) }
        }
    }

    override fun onCreate() {
        super.onCreate()

        // start dependency injection with Koin.
        startKoin {
            // This is logger DI for Koin while application process is alive.
            androidLogger()
            // This helps add context for Koin container.
            androidContext(this@MyApplication)

            modules(appModule)
        }
    }

}