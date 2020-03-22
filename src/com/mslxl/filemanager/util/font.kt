package com.mslxl.filemanager.util

import javafx.scene.control.Labeled
import javafx.scene.control.Tab
import javafx.scene.text.Font
import org.controlsfx.glyphfont.FontAwesome

private val fontAwesome =  FontAwesome(Thread.currentThread().contextClassLoader.getResource("font/FontAwesome.otf")!!.toExternalForm())



fun Labeled.fontAwesome(c:FontAwesome.Glyph){
    graphic = fontAwesome.create(c)
    text = ""
}

fun Labeled.fontAwesome(c:Char){
    graphic = fontAwesome.create(c)
    text = ""
}

fun Tab.fontAwesome(c:FontAwesome.Glyph){
    graphic = fontAwesome.create(c)
    text = ""
}