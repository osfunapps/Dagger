package com.osfunapps.schedulesms.infrastructure.localrepository

interface LocalRepository{

    /**
     * a shared prefs handler module.
     * to use, just inject the LocalRepository to any class which needs the shared prefs
     */

    //getters
    fun getString(key: String): String?
    fun getBool(key: String): Boolean
    fun getInt(key: String): Int

    //setters
    fun saveBool(key: String, value: Boolean)
    fun saveString(key: String, value: String?)
    fun saveInt(key: String, int: Int)

    //generics
    fun <T> getObject(key: String, value: Class<T>) : T?
    fun <T> saveObject(key: String, value: T?)
    fun <T> getArrayListObject(key: String, clazz: Class<T>) : ArrayList<T>?
    fun <T, E> getPair(key: String, firstObj: Class<T>, secondObj: Class<E>): Pair<T, E>?

    //cleaner
    fun removeKey(key: String)
}