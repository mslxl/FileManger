package com.mslxl.filemanager

import com.mslxl.filemanager.core.PluginLoader
import com.mslxl.filemanager.ui.view.main.MainView
import tornadofx.App
import tornadofx.launch

class FileManagerApp:App(MainView::class){
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            // 随便调用一个方法执行构造器
            PluginLoader.hashCode()

            launch<FileManagerApp>(args)
        }
    }
}

