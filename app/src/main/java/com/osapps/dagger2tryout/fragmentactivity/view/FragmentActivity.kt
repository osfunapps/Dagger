package com.osapps.dagger2tryout.fragmentactivity.view

import android.os.Bundle
import android.util.Log

import com.osapps.dagger2tryout.R
import com.osapps.dagger2tryout.fragmentactivity.frags.detail.view.DetailFragment
import com.osapps.dagger2tryout.fragmentactivity.presentation.DetailPresenter

import javax.inject.Inject

import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by osApps on 25/05/2017.
 */

class FragmentActivity : DaggerAppCompatActivity(), DetailView {

    @Inject
    lateinit var detailPresenter: DetailPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        detailPresenter.loadDetail()

        if (savedInstanceState == null)
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, DetailFragment.newInstance())
                    .commitAllowingStateLoss()
    }

    override fun onDetailLoaded() {
        Log.v("TEST", "Detail is loaded")
    }

}
