package com.example.picturesapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.picturesapp.model.Image
import com.example.picturesapp.repository.ImgRepository
import com.example.picturesapp.viewModel.ImageViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class ImageViewModelTest {
    @get:Rule
    var instantExecutingRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    var mainCoroutineRule = TestCoroutineDispatcher()

    lateinit var viewModel: ImageViewModel

    @Mock
    lateinit var repository: ImgRepository

    @Mock
    lateinit var imageList: List<Image>

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(mainCoroutineRule)
        viewModel = ImageViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `return the list of image from api`() =
        mainCoroutineRule.runBlockingTest {
            Mockito.`when`(repository.getImages()).thenReturn(imageList)
            viewModel.getImages()
            Assert.assertEquals(viewModel.imageList.value, imageList)
        }

}
