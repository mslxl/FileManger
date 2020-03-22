package com.mslxl.filemanager.core

import com.mslxl.filemanager.core.api.BaseProvider

object ProviderRegister {
    private val instances = HashMap<String,BaseProvider<*>>()
    fun <T:BaseProvider<*>> register(provider: Class<T>){
        val instance = provider.newInstance()
        instances[instance.scheme] = instance
    }
}