package com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.handlers

import android.content.Context
import com.osfunapps.schedulesms.activity.frags.detail.presentation.banks.Finals
import com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.objects.MsgBundle
import com.osfunapps.schedulesms.infrastructure.localrepository.LocalRepository
import com.osfunapps.schedulesms.infrastructure.localrepository.LocalRepositoryImpl
import javax.inject.Inject

/**
 * Created by osapps on 19/08/2018.
 */

const val SP_NAME = "sp"

public class LocalRepoManager @Inject constructor(private var localRepository: LocalRepository?){

    //save the current message
    fun saveMsgBundle(context: Context, time: Long, contactNum: String, msgContent: String): MsgBundle {

        initLocalRepo(context)
        //todo: currently loading/saving messages in pairs: by id (int) and bundleId (object).
        //the bundle id is the number of messages sent (always be distinctive
        // the down side is that it will be problematic to load all of the msgs from the system, If
        // I would sometime want.

        val msgsCount = localRepository!!.getInt(Finals.KEY_MSGS_COUNT) + 1
        localRepository!!.saveInt(Finals.KEY_MSGS_COUNT, msgsCount)
        val msgBundle = MsgBundle(contactNum, msgContent, time, bundleId = msgsCount)
        localRepository!!.saveObject(msgsCount.toString(), msgBundle)
        return msgBundle
    }

    fun loadMsgBundle(context: Context, bundleId: Int): MsgBundle? {
        initLocalRepo(context)
        return localRepository!!.getObject(bundleId.toString(), MsgBundle::class.java)
    }

    private fun initLocalRepo(context: Context) {
        if(localRepository == null)
            localRepository = LocalRepositoryImpl(context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE))
    }
}