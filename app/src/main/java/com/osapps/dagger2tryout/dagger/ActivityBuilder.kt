package com.osapps.dagger2tryout.dagger

import com.osapps.dagger2tryout.dagger.scope.PerActivity
import com.osapps.dagger2tryout.fragmentactivity.di.DetailFragmentProvider
import com.osapps.dagger2tryout.fragmentactivity.di.FragmentActivityModule
import com.osapps.dagger2tryout.fragmentactivity.view.FragmentActivity
import com.osapps.dagger2tryout.main.di.MainActivityModule
import com.osapps.dagger2tryout.main.view.MainActivity

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


    //a simple one view activity which doesn't carry any fragments.
    @PerActivity
    @ContributesAndroidInjector(modules = [
        MainActivityModule::class //the activity module
    ])
    internal abstract fun bindMainActivity(): MainActivity


    /**
     * this is an example of activity which carries one fragment. Notice that in addition to the activity
     * module, we also included the specific fragment provider (which holds all of the fragment modules)
    */
    @PerActivity
    @ContributesAndroidInjector(modules = [
        FragmentActivityModule::class, //the activity module
        DetailFragmentProvider::class //a given fragment provider
    ])
    internal abstract fun bindFragmentActivity(): FragmentActivity

}
