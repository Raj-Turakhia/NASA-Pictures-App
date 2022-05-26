package com.nasa.pictureapp.di.core

import android.app.Application
import android.content.Context
import com.nasa.pictureapp.di.ResourceProvider
import com.nasa.pictureapp.di.SessionStorageModule
import com.nasa.pictureapp.repository.local.Session
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class, SessionStorageModule::class])
interface CoreComponent {

    fun provideApplication(): Application

    fun provideApplicationContext(): Context

    fun provideRetrofit(): Retrofit

    fun provideResourceProvider(): ResourceProvider

    fun provideSession(): Session
}
