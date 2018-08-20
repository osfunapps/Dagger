package com.osfunapps.schedulesms.dagger

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.osfunapps.schedulesms.infrastructure.localrepository.LocalRepository
import com.osfunapps.schedulesms.infrastructure.localrepository.LocalRepositoryImpl

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * To add instances into your Classes, Activities or Fragments, just provide the instance initialization
 * here, with all of it's sub instances, and add the inject line into your desired class/fragment/activity:
 * @Inject lateinit var localRepository: LocalRepository
 *
 * Those instances will live as long as the app live so keep an eye on your memory monitoring.
 * plus, REMEMBER TO SET @Singlton ANNOTATION TO ALL OF THE PROVIDED INSTANCES
 **/

@Module
class AppModule {


    //generic app context fetcher
    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application


    //shared preferences
    @Provides
    @Singleton
    fun provideSharedPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences("sp", Context.MODE_PRIVATE)
    }


    @Provides
    @Singleton
    fun provideLocalRepository(prefs: SharedPreferences): LocalRepository {
        return LocalRepositoryImpl(prefs)
    }


}
