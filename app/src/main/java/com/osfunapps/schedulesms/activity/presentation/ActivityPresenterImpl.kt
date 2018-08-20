package com.osfunapps.schedulesms.activity.presentation

import com.osfunapps.schedulesms.activity.view.ActivityView

import javax.inject.Inject


/**
 * Created by osApps on 30/05/2017.
 */

class ActivityPresenterImpl @Inject constructor(private var activityView: ActivityView) {

    fun loadDetail() {
        activityView.onDetailLoaded()
    }
}
