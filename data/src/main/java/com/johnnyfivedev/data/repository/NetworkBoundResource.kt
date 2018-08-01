package com.johnnyfivedev.data.repository

import com.johnnyfivedev.data.Resource
import io.reactivex.Flowable

abstract class NetworkBoundResource<ResultType, ResponseType>(
    private val schedulers: SchedulersProvider,
    systemInfoProvider: SystemInfoProvider
) {

    val result: Flowable<Resource<ResultType>>

    init {
        val localObservable = Flowable.defer {
            getFromDb()
                .subscribeOn(schedulers.computation())
        }

        val remoteObservable = Flowable.defer {
            createCall()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.computation())
                .map(this::processResponse)
                .map(this::saveCallResult)
                .flatMap { getFromDb() }
        }
        val observable = if (systemInfoProvider.hasNetwork()) remoteObservable else localObservable
        result = observable.map<Resource<ResultType>> { Resource.Data(it) }
            .observeOn(schedulers.mainThread())
            .startWith(Resource.Loading())
    }

    protected abstract fun createCall(): Flowable<ResponseType>

    protected abstract fun processResponse(response: ResponseType): ResultType

    protected abstract fun saveCallResult(source: ResultType)

    protected abstract fun getFromDb(): Flowable<ResultType>
}