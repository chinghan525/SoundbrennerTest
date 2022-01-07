package com.soundbrenner.challenge.base

import com.soundbrenner.challenge.ui.activity.main.IMainContract
import com.soundbrenner.challenge.ui.activity.main.MainPresenterImpl
import org.koin.dsl.module

fun getPresenterModule() = module {
    factory<IMainContract.P> { MainPresenterImpl() }
}
