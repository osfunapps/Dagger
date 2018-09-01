package com.osfunapps.schedulesms.scheduleactivity.di

import com.osfunapps.schedulesms.scheduleactivity.schedulefragment.di.ScheduleFragmentModule
import com.osfunapps.schedulesms.scheduleactivity.schedulefragment.view.ScheduleFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by osApps on 02/06/2017.
 */
@Module
abstract class ScheduleFragmentProvider {
    @ContributesAndroidInjector(modules = [ScheduleFragmentModule::class]) //the specific module of the fragment
    internal abstract fun provideScheduleFragmentFactory(): ScheduleFragment
}
