package com.mslxl.filemanager.plugin.fs

import com.mslxl.filemanager.core.api.BaseProvider
import java.io.File
import java.net.URI

class FileSystemProvider: BaseProvider<List<File>>() {
    override val scheme = "file"
    override val hiddenScheme = true
    override fun access(uri: URI, updateData: (List<File>) -> Unit) {

    }

}