package com.mslxl.filemanager.ui.view.tab

import com.mslxl.filemanager.util.fontAwesome
import javafx.scene.Parent
import javafx.scene.control.Tab
import org.controlsfx.glyphfont.FontAwesome
import tornadofx.View
import tornadofx.tab
import tornadofx.tabpane

class TabView: View() {
    override val root = tabpane {
        tabs.add(TabViewPlus())
    }
    init {
        root.selectionModelProperty().addListener { observable, oldValue, newValue ->
            println("ww")
            if (newValue.selectedItem is TabViewPlus){
                newTab()
            }
        }
    }

    fun newTab(){

        root.tabs.add(root.tabs.size-1,Tab())
    }
}

class TabViewPlus:Tab(){
    init {
        fontAwesome(FontAwesome.Glyph.PLUS_SQUARE_ALT)
        isClosable = false
    }
}