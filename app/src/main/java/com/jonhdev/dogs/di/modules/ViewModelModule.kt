package com.jonhdev.dogs.di.modules

import androidx.lifecycle.ViewModelProvider
import com.jonhdev.dogs.di.utils.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}