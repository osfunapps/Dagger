package com.osfunapps.schedulesms.activity.frags.detail.view

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.osfunapps.schedulesms.R
import com.osfunapps.schedulesms.activity.frags.detail.presentation.DetailFragmentPresenterImpl

import javax.inject.Inject

import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_set_msg.*

/**
 * Created by osApps on 02/06/2017.
 */

class DetailFragment : DaggerFragment(), DetailFragmentView {

    @Inject
    lateinit var detailFragmentPresenter: DetailFragmentPresenterImpl

    //views
    private lateinit var contactTV: TextView
    private lateinit var msgET: EditText


    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailFragmentPresenter.onViewLoaded(activity!!.fragmentManager)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_set_msg, container, false)
        setViews(view)
        return view
    }

    private fun setViews(view: View) {
        view.findViewById<Button>(R.id.contact_btn).setOnClickListener { requestContact() }
        view.findViewById<Button>(R.id.send_btn).setOnClickListener { onClickScheduleMsg() }
        contactTV = view.findViewById(R.id.contact_tv)
        msgET = view.findViewById(R.id.msg_tv)
    }

    //todo: is that legal?
    fun requestContact() {
        activity != null ?: detailFragmentPresenter.requestContact(activity!!)
    }

    override fun setContactPhone(contactPhone: String) {
        contactTV.text = contactPhone
    }

    fun onClickScheduleMsg() = scheduleMsg()

    fun scheduleMsg() = detailFragmentPresenter.onClickScheduleMsg(activity)

    override fun contactNumber(): String = contactTV.text.toString()
    override fun msgContent(): String = msgET.text.toString()

    companion object {
        fun newInstance() = DetailFragment()
    }


    //when user picked a contact and came back
    fun undressContact(data: Uri) {
        activity != null ?: detailFragmentPresenter.undressContact(activity!!, data)
    }
}
