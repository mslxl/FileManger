package com.mslxl.filemanager.plugin.page

import javafx.scene.Parent
import java.net.URI

object PageRegister {
    private val pages = HashMap<String,Class<*>>()
    fun <T:Parent> register(path: String,page:Class<T>){
        pages[path] = page
    }
    internal fun createPage(path: String):Parent{
        return pages[path]!!.newInstance()!!as Parent
    }
}