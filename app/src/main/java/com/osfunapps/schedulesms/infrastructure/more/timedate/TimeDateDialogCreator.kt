package com.osfunapps.schedulesms.infrastructure.more.timedate

import android.app.Activity
import android.app.FragmentManager
import android.widget.TimePicker
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import java.util.*

/**
 * Created by osapps on 19/08/2018.
 */
class TimeDateDialogCreator {

    fun createDateDialog(dialogListener: DatePickerDialog.OnDateSetListener,
                         dialogTheme: DatePickerDialog.Version): DatePickerDialog {
        val now = Calendar.getInstance()
        val dpd = DatePickerDialog.newInstance(
                dialogListener,
                now.get(Calendar.YEAR), // Initial year selection
                now.get(Calendar.MONTH), // Initial month selection
                now.get(Calendar.DAY_OF_MONTH) // Inital day selection
        )
        dpd.version = dialogTheme
        return dpd
    }

    fun createTimeDialog(dialogListener: TimePickerDialog.OnTimeSetListener,
                         dialogTheme: TimePickerDialog.Version): TimePickerDialog {

        val now = Calendar.getInstance()
        val dpd = TimePickerDialog.newInstance(
                dialogListener,
                now.get(Calendar.HOUR), // Initial hour selection
                now.get(Calendar.MINUTE), // Initial minute selection
                true // Initial month selection
        )
        dpd.version = dialogTheme
        return dpd
    }

}
