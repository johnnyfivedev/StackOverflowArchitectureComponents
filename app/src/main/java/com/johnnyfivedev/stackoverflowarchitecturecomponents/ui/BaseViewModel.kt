package com.johnnyfivedev.stackoverflowarchitecturecomponents.ui

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    protected fun safeSubscribe(block: () -> Disposable) {
        compositeDisposable.add(block.invoke())
    }
}