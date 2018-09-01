package com.osfunapps.schedulesms.scheduleactivity.presentation

import com.osfunapps.schedulesms.scheduleactivity.view.ScheduleActivityView

import javax.inject.Inject


/**
 * Created by osApps on 30/05/2017.
 */

class ScheduleActivityPresenterImpl @Inject constructor(private var scheduleActivityView: ScheduleActivityView) {

    fun loadDetail() {
        scheduleActivityView.onDetailLoaded()
    }
}
