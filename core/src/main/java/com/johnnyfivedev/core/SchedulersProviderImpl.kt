package com.johnnyfivedev.core

import com.rmr.arch.sample.core.providers.rx.SchedulersProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SchedulersProviderImpl @Inject constructor() : SchedulersProvider {
    override fun disk(): Scheduler = Schedulers.io()
    override fun network(): Scheduler = Schedulers.computation()
    override fun mainThread(): Scheduler = AndroidSchedulers.mainThread()
}