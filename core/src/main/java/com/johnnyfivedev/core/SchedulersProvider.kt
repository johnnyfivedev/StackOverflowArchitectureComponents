package com.johnnyfivedev.core

import io.reactivex.Scheduler

interface SchedulersProvider {
    fun disk(): Scheduler
    fun network(): Scheduler
    fun mainThread(): Scheduler
}
