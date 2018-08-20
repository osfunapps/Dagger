package com.osfunapps.schedulesms.activity.frags.detail.di

import android.content.Context
import com.osfunapps.schedulesms.activity.frags.detail.presentation.ContactObjectHandler
import com.osfunapps.schedulesms.activity.frags.detail.presentation.DetailFragmentPresenterImpl
import com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.broadcast.MsgAlarmManager
import com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.handlers.ContactRequestHandler
import com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.handlers.LocalRepoManager
import com.osfunapps.schedulesms.dagger.scope.PerFragment
import com.osfunapps.schedulesms.activity.frags.detail.view.DetailFragment
import com.osfunapps.schedulesms.activity.frags.detail.view.DetailFragmentView
import com.osfunapps.schedulesms.activity.presentation.ActivityPresenterImpl
import com.osfunapps.schedulesms.infrastructure.localrepository.LocalRepository
import com.osfunapps.schedulesms.infrastructure.localrepository.LocalRepositoryImpl
import com.osfunapps.schedulesms.infrastructure.more.timedate.TimeDateDialogHandler

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

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
    fun provideDetailFragmentView(detailFragment: DetailFragment): DetailFragmentView = detailFragment

    @Provides
    fun provideDetailPresenter(fragmentView: DetailFragmentView, context: Context, msgAlarmManager: MsgAlarmManager,
                               timeDateDialogHandler: TimeDateDialogHandler,
                               localRepoManager: LocalRepoManager, contactRequestHandler: ContactRequestHandler,
                               contactObjectHandler: ContactObjectHandler): DetailFragmentPresenterImpl {
        return DetailFragmentPresenterImpl(fragmentView, context, msgAlarmManager, timeDateDialogHandler, localRepoManager, contactRequestHandler, contactObjectHandler)
    }

    @Provides
    fun provideTimeDateDialogHandler(): TimeDateDialogHandler {
        return TimeDateDialogHandler()
    }

    @Provides
    fun provideLocalRepoManager(localRepository: LocalRepository): LocalRepoManager {
        return LocalRepoManager(localRepository)
    }

    @Provides
    fun provideContactRequestHandler(): ContactRequestHandler {
        return ContactRequestHandler()
    }
    @Provides
    fun provideContactObjectHandler(): ContactObjectHandler {
        return ContactObjectHandler()
    }





}
