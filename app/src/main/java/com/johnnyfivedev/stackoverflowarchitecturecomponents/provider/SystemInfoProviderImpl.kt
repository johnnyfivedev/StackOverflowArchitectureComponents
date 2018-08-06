package com.johnnyfivedev.stackoverflowarchitecturecomponents.provider

import android.content.Context
import android.net.ConnectivityManager
import com.johnnyfivedev.core.provider.SystemInfoProvider
import javax.inject.Inject

class SystemInfoProviderImpl @Inject constructor(private val context: Context) : SystemInfoProvider {
    override fun hasNetwork(): Boolean {
        val appContext = context.applicationContext
        val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
        connectivityManager?.let {
            it.activeNetworkInfo?.let {
                if (it.isConnected) return true
            }
        }
        return false
    }
}