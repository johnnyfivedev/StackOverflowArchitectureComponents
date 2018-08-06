package com.johnnyfivedev.data.repository

import com.johnnyfivedev.core.provider.SchedulersProvider
import com.johnnyfivedev.core.provider.SystemInfoProvider
import com.johnnyfivedev.data.Resource
import io.reactivex.Flowable

abstract class NetworkBoundResource<ResultType, ResponseType>(
    private val schedulers: SchedulersProvider,
    systemInfoProvider: SystemInfoProvider
) {

    val result: Flowable<Resource<ResultType>>

    init {
        val diskObservable = Flowable.defer {
            loadFromDb()
                .subscribeOn(schedulers.disk())
        }

        val networkObservable = Flowable.defer {
            createCall()
                .subscribeOn(schedulers.network())
                .observeOn(schedulers.disk())
                .map(this::processResponse)
                .map(this::saveCallResult)
                .flatMap { loadFromDb() }
        }
        val observable = if (systemInfoProvider.hasNetwork()) networkObservable else diskObservable
        result = observable.map<Resource<ResultType>> { Resource.Data(it) }
            .observeOn(schedulers.mainThread())
            .startWith(Resource.Loading())
    }

    protected abstract fun createCall(): Flowable<ResponseType>

    protected abstract fun processResponse(response: ResponseType): ResultType

    protected abstract fun saveCallResult(source: ResultType)

    protected abstract fun loadFromDb(): Flowable<ResultType>
}