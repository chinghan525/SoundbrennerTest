package com.soundbrenner.challenge.base

abstract class BasePresenter<ViewType : IView> : IPresenter<ViewType> {

    var androidView: ViewType? = null
        get() {
            return field ?: throw MvpViewNotAttachedException()
        }

    override fun attachView(
        view: ViewType,
        jsonData: String?
    ) {
        androidView = view
    }

    override fun detachView() {
        androidView = null
    }

    override fun getDataToSend(): String? = null

    override fun viewPrepared() {}

    override fun checkDataFromIntent(jsonData: String?) {}

    override fun isAttached(): Boolean = androidView != null

    class MvpViewNotAttachedException : RuntimeException(
        "Please call Presenter.attachView(IView) before requesting data to the Presenter"
    )
}