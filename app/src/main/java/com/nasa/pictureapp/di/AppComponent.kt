package com.nasa.pictureapp.di

import com.nasa.pictureapp.di.core.AuthScopes
import com.nasa.pictureapp.di.core.CoreComponent
import com.nasa.pictureapp.ui.detail.DetailFragment
import com.nasa.pictureapp.ui.detail.PictureDetailFragment
import com.nasa.pictureapp.ui.home.HomeFragment
import dagger.Component

@AuthScopes
@Component(
    modules = [AppNetworkModule::class, AppViewModelModule::class],
    dependencies = [CoreComponent::class]

)
interface AppComponent {
    // Classes that can be injected by this Component
    fun inject(fragment: HomeFragment)
    fun inject(fragment: PictureDetailFragment)
    fun inject(fragment: DetailFragment)
}