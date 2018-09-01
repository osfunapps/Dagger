package com.osfunapps.schedulesms.scheduleactivity.di

import com.osfunapps.schedulesms.scheduleactivity.presentation.ScheduleActivityPresenterImpl
import com.osfunapps.schedulesms.scheduleactivity.view.ScheduleActivityView
import com.osfunapps.schedulesms.scheduleactivity.view.ScheduleActivity

import dagger.Module
import dagger.Provides

/**
 * Created by osApps on 30/05/2017.
 */
@Module
class ScheduleActivityModule {

    @Provides
    fun provideDetailView(scheduleActivity: ScheduleActivity): ScheduleActivityView = scheduleActivity

    @Provides
    fun provideDetailPresenter(scheduleActivityView: ScheduleActivityView): ScheduleActivityPresenterImpl {
        return ScheduleActivityPresenterImpl(scheduleActivityView)
    }


}
