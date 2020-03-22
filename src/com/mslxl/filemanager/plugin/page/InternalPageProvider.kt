package com.mslxl.filemanager.plugin.page

import com.mslxl.filemanager.core.api.BaseProvider
import javafx.scene.Parent
import java.net.URI

class InternalPageProvider:BaseProvider<Parent>() {
    override val scheme = "page"

    override fun access(uri: URI, updateData: (Parent) -> Unit) {
        val page = PageRegister.createPage(uri.path)
        updateData(page)
    }
}