package com.nasa.pictureapp.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.nasa.pictureapp.R
import com.nasa.pictureapp.databinding.FragmentPictureDetailLayoutBinding
import com.nasa.pictureapp.di.AppComponentProvider
import com.nasa.pictureapp.di.base.BaseFragment
import com.nasa.pictureapp.di.base.toolbar.FragmentToolbar
import com.nasa.pictureapp.ui.detail.adapter.ViewPagerAdapter
import com.nasa.pictureapp.ui.home.HomeViewModel
import javax.inject.Inject

class PictureDetailFragment :
    BaseFragment<FragmentPictureDetailLayoutBinding>(R.layout.fragment_picture_detail_layout) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: HomeViewModel by activityViewModels()

    private var mViewPagerAdapter: ViewPagerAdapter? = null
    private val args by navArgs<PictureDetailFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as AppComponentProvider).getAppComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpWithViewModel(viewModel)
        registerObservers()
    }

    /**
     * This method used to initialize view
     */
    private fun initView() {
        mViewPagerAdapter = ViewPagerAdapter(childFragmentManager)
        binding.viewPager.adapter = mViewPagerAdapter
    }

    override fun builder(): FragmentToolbar {
        return FragmentToolbar.Builder()
            .withId(FragmentToolbar.NO_TOOLBAR)
            .build()
    }

    /**
     * This method is used to registered required observer to the fragment
     */
    private fun registerObservers() {
        viewModel.apply {
            pictureModel.observe(viewLifecycleOwner, {
                it?.map { pictureModel ->
                    addFragment(DetailFragment.newInstance(pictureModel), pictureModel.title ?: "")
                }
                binding.viewPager.currentItem = args.position
            })
        }

    }

    /**
     * This method is used to add Fragment into view pager adapter
     */
    private fun addFragment(fragment: Fragment, title: String) {
        mViewPagerAdapter?.let { it.addFrag(fragment, title); it.notifyDataSetChanged() }
    }
}