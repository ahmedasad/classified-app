package com.example.classifiedapp.base

import android.app.Application
import com.example.classifiedapp.data.network.Client
import com.example.classifiedapp.data.network.services.ClassifiedServices
import com.example.classifiedapp.data.repositories.classifiedRepository
import com.example.classifiedapp.ui.homefragment.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        initKOIN()
    }

    private fun initKOIN() {
        //app
        val appModule: Module = module {
            single { Application() }
        }

        //network
        val appNetworkClientModule: Module = module {
            single { Client() }
        }

        //API Interface classes
        val appAPIInterfacesModule: Module = module {
            single { (get() as Client).createApiEndPoint(ClassifiedServices::class.java) }
        }

        //repositories
        val appRepositoryModule: Module = module {
            single { classifiedRepository(get()) }
        }
        val viewModelModule = module{
            viewModel { HomeViewModel(get(),get()) }
        }
        startKoin { modules(
            appModule,
                    appNetworkClientModule,
                    appAPIInterfacesModule,
                    appRepositoryModule,
                    viewModelModule
        ) }
    }
}