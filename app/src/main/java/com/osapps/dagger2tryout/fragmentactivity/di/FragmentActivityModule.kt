package com.osapps.dagger2tryout.fragmentactivity.di

import com.osapps.dagger2tryout.fragmentactivity.presentation.DetailPresenter
import com.osapps.dagger2tryout.fragmentactivity.presentation.DetailPresenterImpl
import com.osapps.dagger2tryout.fragmentactivity.view.DetailView
import com.osapps.dagger2tryout.fragmentactivity.view.FragmentActivity
import com.osapps.dagger2tryout.main.presentation.ItzikInstance

import dagger.Module
import dagger.Provides

/**
 * Created by osApps on 30/05/2017.
 */
@Module
class FragmentActivityModule {

    @Provides
    fun provideDetailView(fragmentActivity: FragmentActivity): DetailView = fragmentActivity

    @Provides
    fun provideDetailPresenter(detailView: DetailView, instance: ItzikInstance): DetailPresenter {
        return DetailPresenterImpl(detailView, instance)
    }


}
