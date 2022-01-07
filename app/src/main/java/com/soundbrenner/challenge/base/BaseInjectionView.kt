package com.soundbrenner.challenge.base

import androidx.annotation.LayoutRes

interface BaseInjectionView<PresenterType : IPresenter<ViewType>, ViewType : IView> {


    val presenter: PresenterType

    fun attach(jsonData: String?) = presenter.attachView(getIView(), jsonData)

    fun detach() = presenter.detachView()

    fun getIView(): ViewType

    fun getViewBinding()

    fun prepareView() {
        presenter.viewPrepared()
    }
}