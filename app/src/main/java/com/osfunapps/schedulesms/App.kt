package com.osfunapps.schedulesms

import com.crashlytics.android.Crashlytics
import com.osfunapps.schedulesms.dagger.DaggerAppComponent

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.fabric.sdk.android.Fabric



/**
 * todo:
 * [2] notes on project
 * [3] notes in general
 */
/**
 * Created by osApps on 25/05/2017.
 */

class App : DaggerApplication() {


    override fun onCreate() {
        Fabric.with(this, Crashlytics())
        super.onCreate()
    }
    //this method meant to create the app component and return it to the dagger
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        //build the app component
        val appComponent = DaggerAppComponent.builder().application(this).build()

        //inject the app into it
        appComponent.inject(this)

        //return the app component
        return appComponent
    }
}
