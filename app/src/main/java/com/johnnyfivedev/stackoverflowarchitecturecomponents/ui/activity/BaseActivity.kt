package com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.activity

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
}