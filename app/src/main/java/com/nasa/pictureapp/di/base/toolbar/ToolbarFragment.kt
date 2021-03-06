package com.nasa.pictureapp.di.base.toolbar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class ToolbarFragment : Fragment() {
    var toolbarManager: ToolbarManager? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarManager = ToolbarManager(builder(), view)
        toolbarManager!!.prepareToolbar()
    }

    protected abstract fun builder(): FragmentToolbar
}