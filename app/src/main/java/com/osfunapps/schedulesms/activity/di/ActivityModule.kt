package com.osfunapps.schedulesms.activity.di

import com.osfunapps.schedulesms.activity.presentation.ActivityPresenterImpl
import com.osfunapps.schedulesms.activity.view.ActivityView
import com.osfunapps.schedulesms.activity.view.Activity

import dagger.Module
import dagger.Provides

/**
 * Created by osApps on 30/05/2017.
 */
@Module
class ActivityModule {

    @Provides
    fun provideDetailView(activity: Activity): ActivityView = activity

    @Provides
    fun provideDetailPresenter(activityView: ActivityView): ActivityPresenterImpl {
        return ActivityPresenterImpl(activityView)
    }


}
