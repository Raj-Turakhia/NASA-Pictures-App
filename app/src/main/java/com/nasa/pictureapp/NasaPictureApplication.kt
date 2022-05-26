package com.nasa.pictureapp

import android.app.Application
import com.nasa.pictureapp.di.AppComponent
import com.nasa.pictureapp.di.AppComponentProvider
import com.nasa.pictureapp.di.core.CoreComponent
import com.nasa.pictureapp.di.DaggerAppComponent
import com.nasa.pictureapp.di.ResourceProvider
import com.nasa.pictureapp.di.core.CoreComponentProvider
import com.nasa.pictureapp.di.core.CoreModule
import com.nasa.pictureapp.di.core.DaggerCoreComponent

class NasaPictureApplication : Application(), AppComponentProvider, CoreComponentProvider, ResourceProvider {

    override fun onCreate() {
        super.onCreate()
    }

    override fun getAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
            .coreComponent(getCoreComponent()).build()
    }


    override fun getCoreComponent(): CoreComponent {
        return DaggerCoreComponent.builder().coreModule(CoreModule(this)).build()
    }
}
