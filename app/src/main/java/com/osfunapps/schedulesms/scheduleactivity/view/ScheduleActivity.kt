package com.osfunapps.schedulesms.scheduleactivity.view

import android.content.Intent
import android.os.Bundle

import com.osfunapps.schedulesms.R
import com.osfunapps.schedulesms.scheduleactivity.schedulefragment.view.ScheduleFragment
import com.osfunapps.schedulesms.scheduleactivity.presentation.ScheduleActivityPresenterImpl

import javax.inject.Inject

import dagger.android.support.DaggerAppCompatActivity
import android.content.pm.PackageManager
import android.widget.Toast
import com.osfunapps.schedulesms.scheduleactivity.schedulefragment.presentation.banks.Finals
import android.view.WindowManager
import android.os.Build
import android.os.Handler


/**
 * Created by osApps on 25/05/2017.
 */

class ScheduleActivity : DaggerAppCompatActivity(), ScheduleActivityView, SplashActivity {


    @Inject
    lateinit var scheduleActivityPresenter: ScheduleActivityPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeStatusBarTranslucent()
        setContentView(R.layout.activity_schedule)
        scheduleActivityPresenter.loadDetail()
        callbackActivityTheme()
    }

    override fun onDetailLoaded() {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, ScheduleFragment.newInstance())
                    .commitAllowingStateLoss()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            Finals.PERMISSION_REQUEST_CODE_SEND_SMS -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    val msgFragment = isFragmentOpen<ScheduleFragment>()
                    msgFragment?.scheduleMsg()
                } else
                    Toast.makeText(this, this.getString(R.string.permission_send_sms_missing),
                            Toast.LENGTH_LONG).show()
            }

            Finals.PERMISSION_REQUEST_PICK_CONTACT -> {
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    val msgFragment = isFragmentOpen<ScheduleFragment>()
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
                    val msgFragment = isFragmentOpen<ScheduleFragment>()
                    msgFragment?.undressContact(data.data)
                }
            }
        }
    }

    private fun makeStatusBarTranslucent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
    }

    //TODO: to move to extends fragment scheduleactivity
    private inline fun <reified T> isFragmentOpen(): T? {
        val f = supportFragmentManager.findFragmentById(R.id.fragment_container)
        return if (f is T)
            f
        else
            null
    }

    override fun callbackActivityTheme() {
        //setTheme(R.style.AppTheme)
    }
}