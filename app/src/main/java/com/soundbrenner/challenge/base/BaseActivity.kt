package com.soundbrenner.challenge.base

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<PresenterType : IPresenter<ViewType>, ViewType : IView>
    : AppCompatActivity(),
    BaseInjectionView<PresenterType, ViewType> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()
        setContentView(getLayout())
        prepareView()
    }

    protected open fun initData() {}

    protected open fun onBackBtnPressed() {
        finish()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        detach()
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            onBackBtnPressed()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

}