package com.nasa.pictureapp.ui.detail

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nasa.pictureapp.R
import com.nasa.pictureapp.databinding.FragmentDetailBinding
import com.nasa.pictureapp.di.AppComponentProvider
import com.nasa.pictureapp.di.base.BaseFragment
import com.nasa.pictureapp.di.base.toolbar.FragmentToolbar
import com.nasa.pictureapp.repository.models.NasaPictureModel
import com.nasa.pictureapp.util.AppConstants
import javax.inject.Inject

class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<DetailViewModel> { viewModelFactory }

    companion object {
        /**
         * Create new instance for the detail fragment with required picture data.
         */
        fun newInstance(pictureModel: NasaPictureModel): DetailFragment {
            val bundle = Bundle()
            bundle.putSerializable(AppConstants.KEY_PICTURE_DATA, pictureModel)
            val detailFragment =
                DetailFragment()
            detailFragment.arguments = bundle
            return detailFragment

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as AppComponentProvider).getAppComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            viewModel = this@DetailFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pictureModel = arguments?.getSerializable(AppConstants.KEY_PICTURE_DATA) as NasaPictureModel
        binding.description.movementMethod = ScrollingMovementMethod()
        viewModel.setPictureData(pictureModel)
        setUpWithViewModel(viewModel)
        updateToolBar(pictureModel)
    }

    /**
     * This method is update title of toolbar
     */
    private fun updateToolBar(pictureModel: NasaPictureModel) {
        toolbarManager?.updateTitle(pictureModel.title ?: "")
    }

    /**
     * This method is used to set up toolbar
     */
    override fun builder(): FragmentToolbar {
        return FragmentToolbar.Builder()
            .withId(R.id.toolbar)
            .withToolbarColorId(ContextCompat.getColor(requireContext(), R.color.purple_500))
            .withTitle("")
            .withNavigationIcon(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_back_white
                )
            )
            .withNavigationListener { findNavController().popBackStack() }
            .withTitleColorId(ContextCompat.getColor(requireContext(), R.color.white))
            .build()
    }
}