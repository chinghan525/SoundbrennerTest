package com.soundbrenner.challenge.base

interface IPresenter<ViewType : IView> {

    fun attachView(
        view: ViewType,
        jsonData: String?
    )

    fun detachView()

    fun isAttached(): Boolean

    fun viewPrepared()

    fun onResume() {}

    fun onPause() {}

    fun getDataToSend(): String?

    fun checkDataFromIntent(jsonData: String?)
}