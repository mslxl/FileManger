package com.mslxl.filemanager.plugin.page

import com.mslxl.filemanager.core.api.BaseRenderer
import javafx.scene.Parent
import javafx.scene.layout.BorderPane

class PageRenderer: BaseRenderer<Parent>() {
    private val pane = BorderPane()


    override fun create() = pane
    override fun updateData(data: Parent) {
        pane.center = data
    }
}