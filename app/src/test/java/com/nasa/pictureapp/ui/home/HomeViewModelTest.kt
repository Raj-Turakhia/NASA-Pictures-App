package com.nasa.pictureapp.ui.home

import android.content.Context
import com.nasa.pictureapp.utils.MockUtils
import com.nasa.pictureapp.utils.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import android.content.res.AssetManager
import com.nhaarman.mockitokotlin2.doReturn
import org.mockito.ArgumentMatchers.anyString
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.rules.TestRule
import java.io.InputStream

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var context: Context

    private lateinit var viewModel: HomeViewModel

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    var assetManager: AssetManager? = null


    @Before
    fun setUp() {
        doReturn(assetManager).`when`(context)?.assets
        val inputStream: InputStream? = javaClass.classLoader.getResourceAsStream("data.json")
        doReturn(inputStream).`when`(assetManager)?.open(anyString())
        viewModel = HomeViewModel(context)

    }

    @Test
    @Throws(Exception::class)
    fun testGetItems() {
        Assert.assertEquals(MockUtils.nasaPictureModelList, viewModel.pictureModel.value)
    }
}