package com.nasa.pictureapp.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nasa.pictureapp.utils.MockUtils
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DetailViewModel

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setPictureData(MockUtils.nasaPictureModel)
    }

    @Test
    @Throws(Exception::class)
    fun testGetItems() {
        Assert.assertEquals(MockUtils.nasaPictureModel, viewModel.pictureModel.value)
        Assert.assertEquals(MockUtils.nasaPictureModel.title, viewModel.pictureModel.value?.title)
    }
}
