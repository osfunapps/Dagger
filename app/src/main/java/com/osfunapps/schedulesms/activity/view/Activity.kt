package com.osfunapps.schedulesms.activity.view

import android.content.Intent
import android.os.Bundle

import com.osfunapps.schedulesms.R
import com.osfunapps.schedulesms.activity.frags.detail.view.DetailFragment
import com.osfunapps.schedulesms.activity.presentation.ActivityPresenterImpl

import javax.inject.Inject

import dagger.android.support.DaggerAppCompatActivity
import android.content.pm.PackageManager
import android.support.v4.app.Fragment
import android.widget.Toast
import com.osfunapps.schedulesms.activity.frags.detail.presentation.banks.Finals


/**
 * Created by osApps on 25/05/2017.
 */

class Activity : DaggerAppCompatActivity(), ActivityView {

    @Inject
    lateinit var activityPresenter: ActivityPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        activityPresenter.loadDetail()
    }

    override fun onDetailLoaded() {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, DetailFragment.newInstance())
                    .commitAllowingStateLoss()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            Finals.PERMISSION_REQUEST_CODE_SEND_SMS -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    val msgFragment = isFragmentOpen<DetailFragment>()
                    msgFragment?.scheduleMsg()
                } else
                    Toast.makeText(this, this.getString(R.string.permission_send_sms_missing),
                            Toast.LENGTH_LONG).show()
            }

            Finals.PERMISSION_REQUEST_PICK_CONTACT -> {
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    val msgFragment = isFragmentOpen<DetailFragment>()
                    msgFragment?.requestContact()
                } else {
                    Toast.makeText(this, this.getString(R.string.permission_contact_missing),
                            Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            Finals.REQUEST_PICK_CONTACT -> {
                if(data!=null && data.data !=null) {
                    val msgFragment = isFragmentOpen<DetailFragment>()
                    msgFragment?.undressContact(data.data)
                }
            }
        }
    }

    //TODO: to move to extends fragment activity
    private inline fun <reified T> isFragmentOpen(): T? {
        val f = supportFragmentManager.findFragmentById(R.id.fragment_container)
        return if (f is T)
            f
        else
            null
    }
}