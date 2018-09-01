package com.osfunapps.schedulesms.dagger

import com.osfunapps.schedulesms.dagger.scope.PerActivity
import com.osfunapps.schedulesms.scheduleactivity.di.ScheduleActivityModule
import com.osfunapps.schedulesms.scheduleactivity.di.ScheduleFragmentProvider
import com.osfunapps.schedulesms.scheduleactivity.view.ScheduleActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * A module meant to:
 * 1) connect the application module with it's corresponding activities
 * 2) state which modules each app should use
 *
 * Every scheduleactivity should be declared here, with at least one module.
 */
@Module
abstract class ActivityBuilder {

    /**
     * this is an example of scheduleactivity which carries one fragment. Notice that in addition to the scheduleactivity
     * module, we also included the specific fragment provider (which holds all of the fragment modules)
    */
    @PerActivity
    @ContributesAndroidInjector(modules = [
        ScheduleActivityModule::class, //the scheduleactivity module
        ScheduleFragmentProvider::class // the fragment module
    ])
    internal abstract fun bindFragmentActivity(): ScheduleActivity

}
