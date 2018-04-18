package com.osapps.dagger2tryout.infrastructure

interface LocalRepository {

    companion object {
        const val KEY_PUSH_TOKEN = "KEY_PUSH_TOKEN"
        const val TOKEN_KEY = "token_"
        const val SETTINGS_KEY = "settings_"
        const val USERNAME_KEY = "my_username"
        const val IS_OAUTH_USER_KEY = "oauth_user"
        const val ANON_USER_NAME_KEY = "anon_user_name"
        const val ANON_PASS_KEY = "anon_pass"
        const val LAST_OPENED_CHAT_NAME_KEY = "last_opened_chat_name"
        const val LAST_OPENED_CHAT_ID_KEY = "last_opened_chat_id"
    }

    fun save(key: String, value: String?)

    fun get(key: String): String?

    fun getBool(key: String): Boolean

    fun saveBool(key: String, value: Boolean)

    fun clear(key: String)

    fun clearAllFromServer(server: String)
}