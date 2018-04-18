package com.osapps.dagger2tryout.main.presentation

import com.osapps.dagger2tryout.main.view.MainView

import javax.inject.Inject


class MainPresenterImpl @Inject
constructor(private var mainView: MainView, private var instance: ItzikInstance) : MainPresenter {

    override fun loadMain() {
        println("is itzik null? $instance" == null)
        mainView.onMainLoaded()
        instance.subItzikInstance.timeAfterTime()
    }
}