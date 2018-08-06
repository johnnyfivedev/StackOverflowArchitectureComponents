package com.johnnyfivedev.stackoverflowarchitecturecomponents

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

fun <T> MutableLiveData<T>.onNext(next: T) {
    this.value = next
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(viewModelFactory: ViewModelProvider.Factory? = null): T {
    return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(viewModelFactory: ViewModelProvider.Factory, body: T.() -> Unit): T {
    val vm = ViewModelProviders.of(this, viewModelFactory)[T::class.java]
    vm.body()
    return vm
}

inline fun <reified T : ViewModel> Fragment.getViewModel(viewModelFactory: ViewModelProvider.Factory? = null): T {
    return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
}

inline fun <reified T : ViewModel> Fragment.getViewModel(viewModelFactory: ViewModelProvider.Factory, body: T.() -> Unit): T {
    val vm = ViewModelProviders.of(this, viewModelFactory)[T::class.java]
    vm.body()
    return vm
}

inline fun <reified T : Any, reified L : LiveData<T>> LifecycleOwner.observe(liveData: L, noinline block: (T) -> Unit) {
    liveData.observe(this, Observer<T> { it?.let { block.invoke(it) } })
}

/*inline fun <reified T : Any, reified L : CommandsLiveData<T>> LifecycleOwner.observe(liveData: L, noinline block: (T) -> Unit) {
    liveData.observe(this, Observer<ConcurrentLinkedQueue<T>> { commands ->
        if (commands == null) {
            return@Observer
        }
        var command: T?
        do {
            command = commands.poll()
            if (command != null) {
                block.invoke(command)
            }
        } while (command != null)
    })
}*/

