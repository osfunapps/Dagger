package com.osapps.dagger2tryout.fragmentactivity.presentation

import com.osapps.dagger2tryout.fragmentactivity.view.DetailView
import com.osapps.dagger2tryout.main.presentation.ItzikInstance

import javax.inject.Inject


/**
 * Created by osApps on 30/05/2017.
 */

class DetailPresenterImpl @Inject
constructor(private var detailView: DetailView, internal var instance: ItzikInstance) : DetailPresenter {

    override fun loadDetail() {
        instance.talkItzik()
        detailView.onDetailLoaded()
    }
}
