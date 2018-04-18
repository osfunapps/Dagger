package com.osapps.dagger2tryout.fragmentactivity.frags.detail.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.osapps.dagger2tryout.fragmentactivity.frags.detail.presentation.DetailFragmentPresenter
import com.osapps.dagger2tryout.infrastructure.LocalRepository

import javax.inject.Inject

import dagger.android.support.DaggerFragment

/**
 * Created by osApps on 02/06/2017.
 */

class DetailFragment : DaggerFragment(), DetailFragmentView {

    @Inject lateinit var detailFragmentPresenter: DetailFragmentPresenter

    @Inject lateinit var localRepository: LocalRepository

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        detailFragmentPresenter.viewLoaded()
    }

    override fun onDetailFragmentLoaded() {
        Log.v("TEST", "OnDetailFragmentLoaded.")
    }

    companion object {
        fun newInstance() = DetailFragment()
    }
}
