package com.soundbrenner.challenge.ui.activity.main

import androidx.core.content.ContextCompat
import com.example.soundbrennertest.R
import com.example.soundbrennertest.databinding.ActivityMainBinding
import com.soundbrenner.challenge.base.BaseActivity
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
        binding.firstElement.rgb = ContextCompat.getColor(this, R.color.first_element_color)
        binding.secondElement.rgb = ContextCompat.getColor(this, R.color.second_element_color)
        binding.thirdElement.rgb = ContextCompat.getColor(this, R.color.third_element_color)
    }

}