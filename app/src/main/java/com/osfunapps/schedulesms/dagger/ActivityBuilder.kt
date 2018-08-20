package com.osfunapps.schedulesms.dagger

import com.osfunapps.schedulesms.dagger.scope.PerActivity
import com.osfunapps.schedulesms.activity.di.ActivityModule
import com.osfunapps.schedulesms.activity.di.DetailFragmentProvider
import com.osfunapps.schedulesms.activity.frags.detail.di.DetailFragmentModule
import com.osfunapps.schedulesms.activity.view.Activity

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * A module meant to:
 * 1) connect the application module with it's corresponding activities
 * 2) state which modules each app should use
 *
 * Every activity should be declared here, with at least one module.
 */
@Module
abstract class ActivityBuilder {

    /**
     * this is an example of activity which carries one fragment. Notice that in addition to the activity
     * module, we also included the specific fragment provider (which holds all of the fragment modules)
    */
    @PerActivity
    @ContributesAndroidInjector(modules = [
        ActivityModule::class, //the activity module
        DetailFragmentProvider::class // the fragment module
    ])
    internal abstract fun bindFragmentActivity(): Activity

}
