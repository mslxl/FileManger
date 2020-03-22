package com.mslxl.filemanager.core.api

import javafx.scene.Parent

abstract class BaseRenderer<T> {
    abstract fun create():Parent
    abstract fun updateData(data:T)

}