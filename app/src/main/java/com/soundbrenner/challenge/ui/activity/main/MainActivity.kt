package com.soundbrenner.challenge.ui.activity.main

import android.annotation.SuppressLint
import android.graphics.drawable.GradientDrawable
import androidx.core.content.ContextCompat
import com.example.soundbrennertest.R
import com.example.soundbrennertest.databinding.ActivityMainBinding
import com.soundbrenner.challenge.base.BaseActivity
import com.soundbrenner.challenge.utils.setColorAlpha
import com.soundbrenner.uicomponents.colorwheel.gradientseekbar.currentColorAlpha
import com.soundbrenner.uicomponents.colorwheel.gradientseekbar.setTransparentToColor
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity<IMainContract.P, IMainContract.V>(), IMainContract.V {

    private lateinit var binding: ActivityMainBinding

    override val presenter: IMainContract.P by inject()

    override fun getIView(): IMainContract.V = this

    override fun getViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun prepareView() {
        super.prepareView()

        initColorWheel()
        initColorIndicator()
        initBrightnessIndicator()
        initSegmentedController()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initColorWheel() {
        binding.colorWheel.setOnTouchListener { _, _ ->
            resetSegmentedController()
            false
        }

        binding.colorWheel.colorChangeListener = {
            (binding.colorIndicator.background as? GradientDrawable)?.setColor(it)
            binding.valueSeekBar.setTransparentToColor(
                setColorAlpha(
                    it,
                    binding.valueSeekBar.currentColorAlpha
                )
            )
        }
    }

    private fun initColorIndicator() {
        binding.colorIndicator.setBackgroundResource(R.drawable.color_indicator)
    }

    private fun initBrightnessIndicator() {
        binding.valueSeekBar.apply {
            this.offset = 1F
            this.colorChangeListener = { _: Float, argb: Int ->
                (binding.colorIndicator.background as? GradientDrawable)?.setColor(
                    setColorAlpha(
                        argb,
                        binding.valueSeekBar.currentColorAlpha
                    )
                )
            }
        }
    }

    private fun initSegmentedController() {
        binding.firstElement.apply {
            this.rgb = ContextCompat.getColor(this@MainActivity, R.color.first_element_color)
            this.setOnClickListener {
                locatePositionOnColorWheel(R.color.first_element_color)
                resetSegmentedController()
                binding.rlFirstElement.setBackgroundColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.bg_segmented_controller_selected
                    )
                )
            }
        }

        binding.secondElement.apply {
            this.rgb = ContextCompat.getColor(this@MainActivity, R.color.second_element_color)
            this.setOnClickListener {
                locatePositionOnColorWheel(R.color.second_element_color)
                resetSegmentedController()
                binding.rlSecondElement.setBackgroundColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.bg_segmented_controller_selected
                    )
                )
            }
        }

        binding.thirdElement.apply {
            this.rgb = ContextCompat.getColor(this@MainActivity, R.color.third_element_color)
            this.setOnClickListener {
                locatePositionOnColorWheel(R.color.third_element_color)
                resetSegmentedController()
                binding.rlThirdElement.setBackgroundColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.bg_segmented_controller_selected
                    )
                )
            }
        }
    }

    private fun locatePositionOnColorWheel(elementColor: Int) {
        binding.colorWheel.rgb = ContextCompat.getColor(this@MainActivity, elementColor)
    }

    private fun resetSegmentedController() {
        binding.rlFirstElement.setBackgroundColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.bg_segmented_controller_normal
            )
        )
        binding.rlSecondElement.setBackgroundColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.bg_segmented_controller_normal
            )
        )
        binding.rlThirdElement.setBackgroundColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.bg_segmented_controller_normal
            )
        )
    }

}