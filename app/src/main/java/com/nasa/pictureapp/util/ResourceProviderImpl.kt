package com.nasa.pictureapp.util

import android.content.Context
import com.nasa.pictureapp.di.ResourceProvider

class ResourceProviderImpl(private val context: Context) : ResourceProvider {

    override fun getString(resId: Int, vararg params: Any): String {
        return if (params.isEmpty()) {
            context.getString(resId)
        } else {
            context.getString(resId, *params)
        }
    }

}
