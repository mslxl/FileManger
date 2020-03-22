package com.mslxl.filemanager.ui.view.main

import com.mslxl.filemanager.data.model.PageData
import io.reactivex.rxkotlin3.toObservable
import tornadofx.ViewModel
import java.util.*

class MainViewModel:ViewModel() {
    private val pageData = LinkedList<PageData>().toObservable()
    init {

        p
    }

}