package com.osfunapps.schedulesms.activity.di

import com.osfunapps.schedulesms.activity.frags.detail.di.DetailFragmentModule
import com.osfunapps.schedulesms.activity.frags.detail.view.DetailFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by osApps on 02/06/2017.
 */
@Module
abstract class DetailFragmentProvider {
    @ContributesAndroidInjector(modules = [DetailFragmentModule::class]) //the specific module of the fragment
    internal abstract fun provideDetailFragmentFactory(): DetailFragment
}
