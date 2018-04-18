package com.osapps.dagger2tryout.fragmentactivity.frags.detail.di

import com.osapps.dagger2tryout.dagger.scope.PerFragment
import com.osapps.dagger2tryout.fragmentactivity.frags.detail.presentation.DetailFragmentPresenter
import com.osapps.dagger2tryout.fragmentactivity.frags.detail.presentation.DetailFragmentPresenterImpl
import com.osapps.dagger2tryout.fragmentactivity.frags.detail.view.DetailFragment
import com.osapps.dagger2tryout.fragmentactivity.frags.detail.view.DetailFragmentView

import dagger.Module
import dagger.Provides

/**
 * Created by osApps on 02/06/2017.
 */

/**
 * This module holds all of the instances related to DetailFragment.
 * In order to inject specific instance into the fragment, we need to:
 * [1] make sure that we provide all of the dependencies of the instance in this module (you can check
 * out AppModule's sharedPreferences initialization for a good example)
 * [2] the constructor of the implemented instance should annotate itself with @inject
 * [3] add the instance to the constructor of the instance
 */
@Module
@PerFragment
class DetailFragmentModule {

    //the fragment implements DetailFragmentView which the presenter use to draw ui onscreen
    @Provides
    internal fun provideDetailFragmentView(detailFragment: DetailFragment): DetailFragmentView = detailFragment

    //the presenterImpl implements DetailFragmentPresenter which tells the presenterImpl which methods to use
    @Provides
    internal fun provideDetailPresenterView(detailFragmentPresenterImpl: DetailFragmentPresenterImpl): DetailFragmentPresenter = detailFragmentPresenterImpl

}
