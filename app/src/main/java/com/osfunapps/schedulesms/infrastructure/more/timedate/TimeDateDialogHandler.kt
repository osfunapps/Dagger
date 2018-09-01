package com.osfunapps.schedulesms.infrastructure.more.timedate

import android.app.FragmentManager
import com.osfunapps.schedulesms.scheduleactivity.schedulefragment.presentation.instances.objects.Contact
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by osapps on 19/08/2018.
 */
class TimeDateDialogHandler : DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    //dialogs
    private lateinit var timeDialog: TimePickerDialog
    private lateinit var dateDialog: DatePickerDialog

    //private var calendar: Calendar? = null
    private lateinit var callback: TimeDateDialogCallback


    fun setInstances(callback: TimeDateDialogCallback) {
        setDialogs()
        this.callback = callback
    }

    private fun setDialogs() {
        val dtd = TimeDateDialogCreator()
        dateDialog = dtd.createDateDialog(this, DatePickerDialog.Version.VERSION_1)
        timeDialog = dtd.createTimeDialog(this, TimePickerDialog.Version.VERSION_1)
    }


    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {

        val calendar = Calendar.getInstance()
        calendar?.set(year, monthOfYear, dayOfMonth)
        val day = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val date = dateFormat.format(calendar.time)
        callback.onDateFetched(date, day)
    }




    override fun onTimeSet(view: TimePickerDialog?, hourOfDay: Int, minute: Int, second: Int) {

        val calendar = Calendar.getInstance()
        calendar.apply {
            set(Calendar.HOUR_OF_DAY, hourOfDay)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, second)
        }

        val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val time = dateFormat.format(calendar.time)
        callback.onTimeFetched(time)
    }

    fun popDateDialog(fragmentManager: FragmentManager) = dateDialog.show(fragmentManager, "date")
    fun popTimeDialog(fragmentManager: FragmentManager) = timeDialog.show(fragmentManager, "time")


}

interface TimeDateDialogCallback {
    fun onDateFetched(date: String, day: String)
    fun onTimeFetched(time: String)
}
