package com.nasa.pictureapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.nasa.pictureapp.R
import com.nasa.pictureapp.BR
import com.nasa.pictureapp.databinding.FragmentHomeBinding
import com.nasa.pictureapp.databinding.RowItemsBinding
import com.nasa.pictureapp.di.AppComponentProvider
import com.nasa.pictureapp.di.base.BaseFragment
import com.nasa.pictureapp.di.base.toolbar.FragmentToolbar
import com.nasa.pictureapp.repository.models.NasaPictureModel
import com.nasa.pictureapp.util.extension.e
import com.nasa.pictureapp.util.extension.toast
import com.nasa.pictureapp.util.liveadapter.LiveAdapter
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<HomeViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as AppComponentProvider).getAppComponent().inject(this)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gridLayout = GridLayoutManager(context, 2)
        binding.rvItems.layoutManager = gridLayout
        setUpWithViewModel(viewModel)
        registerObservers()
    }

    override fun builder(): FragmentToolbar {
        return FragmentToolbar.Builder()
            .withId(R.id.toolbar)
            .withToolbarColorId(ContextCompat.getColor(requireContext(), R.color.purple_500))
            .withTitle(getString(R.string.title_home))
            .withTitleColorId(ContextCompat.getColor(requireContext(), R.color.white))
            .build()
    }

    private fun registerObservers() {
        viewModel.apply {
            itemResponse.observe(viewLifecycleOwner, {
                it?.let {
                    LiveAdapter(it, BR.model)
                        .map<NasaPictureModel, RowItemsBinding>(R.layout.row_items)
                        .into(binding.rvItems)
                }

            })
        }
    }
}