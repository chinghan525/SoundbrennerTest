package com.soundbrenner.challenge.ui.activity.main

import android.os.Bundle
import com.example.soundbrennertest.R
import com.soundbrenner.challenge.base.BaseActivity
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity<IMainContract.P, IMainContract.V>(), IMainContract.V {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override val presenter: IMainContract.P by inject()

    override fun getLayout(): Int = R.layout.activity_main

    override fun getIView(): IMainContract.V = this
}