package com.osfunapps.schedulesms.infrastructure.more.timedate

import android.app.FragmentManager
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import java.util.*

/**
 * Created by osapps on 19/08/2018.
 */
class TimeDateDialogHandler : DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    private lateinit var fragmentManager: FragmentManager

    //dialogs
    private lateinit var timeDialog: TimePickerDialog
    private lateinit var dateDialog: DatePickerDialog

    private var calendar: Calendar? = null
    private lateinit var callback: TimeDateDialogCallback


    fun setInstances(fragmentManager: FragmentManager, callback: TimeDateDialogCallback) {
        setDialogs()
        this.callback = callback
        this.fragmentManager = fragmentManager
    }

    private fun setDialogs() {
        val dtd = TimeDateDialogCreator()
        dateDialog = dtd.createDateDialog(this, DatePickerDialog.Version.VERSION_1)
        timeDialog = dtd.createTimeDialog(this, TimePickerDialog.Version.VERSION_1)
    }


    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        storeDateParams(year, monthOfYear, dayOfMonth)
        popTimeDialog()
    }


    private fun storeDateParams(year: Int, monthOfYear: Int, dayOfMonth: Int) {
        calendar = Calendar.getInstance()
        calendar?.set(year, monthOfYear, dayOfMonth)

    }

    private fun storeTimeParams(hourOfDay: Int, minutes: Int, second: Int) {
        calendar?.apply {
            set(Calendar.HOUR_OF_DAY, hourOfDay)
            set(Calendar.MINUTE, minutes)
            set(Calendar.SECOND, second)
        }

    }

    override fun onTimeSet(view: TimePickerDialog?, hourOfDay: Int, minute: Int, second: Int) {
        storeTimeParams(hourOfDay, minute, second)
        if (calendar != null)
            callback.onDateTimeSet(calendar!!)
    }

    fun popDateDialog(fragmentManager: FragmentManager) = dateDialog.show(fragmentManager, "date")
    private fun popTimeDialog() = timeDialog.show(fragmentManager, "time")


}

interface TimeDateDialogCallback {
    fun onDateTimeSet(calendar: Calendar)
}
