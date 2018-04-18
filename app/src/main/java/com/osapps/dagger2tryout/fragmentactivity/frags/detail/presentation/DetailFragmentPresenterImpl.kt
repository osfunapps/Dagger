package com.osapps.dagger2tryout.fragmentactivity.frags.detail.presentation

import com.osapps.dagger2tryout.fragmentactivity.frags.detail.presentation.instances.ItzInstance
import com.osapps.dagger2tryout.fragmentactivity.frags.detail.view.DetailFragmentView

import javax.inject.Inject

/**
 * Created by osApps on 02/06/2017.
 */

class DetailFragmentPresenterImpl @Inject constructor(private var detailFragmentView: DetailFragmentView, private var itz : ItzInstance) : DetailFragmentPresenter {

    override fun viewLoaded() {
        detailFragmentView.onDetailFragmentLoaded()
        println(itz.alive())
    }
}
