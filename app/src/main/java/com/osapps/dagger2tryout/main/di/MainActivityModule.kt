package com.osapps.dagger2tryout.main.di

import com.osapps.dagger2tryout.dagger.scope.PerActivity
import com.osapps.dagger2tryout.main.presentation.ItzikInstance
import com.osapps.dagger2tryout.main.presentation.MainPresenter
import com.osapps.dagger2tryout.main.presentation.MainPresenterImpl
import com.osapps.dagger2tryout.main.view.MainActivity
import com.osapps.dagger2tryout.main.view.MainView

import dagger.Module
import dagger.Provides

/**
 * This module holds all of the instances related to MainActivity.
 * In order to inject specific instance into the fragment, we need to:
 * check out DetailFragmentModule to read more about how to use this kind of module (it's basically the same)
 */

@Module
class MainActivityModule {

    //the main activity view
    @Provides
    fun provideMainView(mainActivity: MainActivity) : MainView = mainActivity

    /**
     * notice that the presenter of this activity needs a the MainView and an ItztikInstace to initialize itself.
     * the method above provides the MainView and ItztikInstance isn't provided by no one (cause the only argument
     * it takes has a blank builder i.e doesn't require any special arguments to be initialized).
     *
     * This rule of thumb is true for all of the provided instances, in all of the modules: if an instance
     * doesn't take any argument or takes instances with a blank constructor, we don't need to provide it.
     * Dagger will provide it in runtime. This is true for ItzikInstance.
     */

    @Provides
    @PerActivity
    fun provideMainPresenter(mainView: MainView, instance: ItzikInstance): MainPresenter {
        return MainPresenterImpl(mainView, instance)
    }


}
