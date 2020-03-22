package com.mslxl.filemanager.core.api

import java.net.URI


abstract class  BaseProvider<T> {
    abstract val scheme:String
    open val hiddenScheme = false


    abstract fun access(uri: URI,updateData:(T)->Unit)

}