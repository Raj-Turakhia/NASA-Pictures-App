package com.nasa.pictureapp.di.core

import android.app.Application
import android.content.Context
import com.nasa.pictureapp.di.ResourceProvider
import com.nasa.pictureapp.repository.network.RetrofitClientInstance
import com.nasa.pictureapp.util.ResourceProviderImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

@Module
class CoreModule(val application: Application) {

    @Reusable
    @Provides
    fun provideApplication(): Application {
        return application
    }

    @Reusable
    @Provides
    fun provideApplicationContext(): Context {
        return application.applicationContext
    }

    @Reusable
    @Provides
    fun provideRetrofit(context: Context): Retrofit {
        return RetrofitClientInstance.getRetrofitInstance(context)
    }

    @Reusable
    @Provides
    fun provideResourceProvider(context: Context): ResourceProvider {
        return ResourceProviderImpl(context)
    }

}
