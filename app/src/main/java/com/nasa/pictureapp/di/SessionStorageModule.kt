package com.nasa.pictureapp.di

import com.nasa.pictureapp.repository.local.PreferenceDataStore
import com.nasa.pictureapp.repository.local.Session
import dagger.Binds
import dagger.Module

@Module
abstract class SessionStorageModule {

    // Makes Dagger provide SharedPreferencesStorage when a Storage type is requested
    @Binds
    abstract fun provideSession(storage: PreferenceDataStore): Session
}
