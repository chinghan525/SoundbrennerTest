package com.soundbrenner.challenge.ui.activity.main

import com.soundbrenner.challenge.base.IPresenter
import com.soundbrenner.challenge.base.IView


interface IMainContract {
    interface V : IView

    interface P : IPresenter<V>
}