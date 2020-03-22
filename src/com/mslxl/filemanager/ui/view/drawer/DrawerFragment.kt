package com.mslxl.filemanager.ui.view.drawer


import com.mslxl.filemanager.ui.component.drawеr
import javafx.geometry.Side
import tornadofx.*

class DrawerFragment : Fragment() {
    val side: Side by param(Side.LEFT)

    override val root = drawеr(side = side) {

        resize(200.0,height)
        item("1") {
            scrollpane(fitToHeight = true,fitToWidth = true) {
                vbox {
                    label {
                        text = buildString {
                            val str = buildString {
                                append("wwwwwwwwwwwwww\n")
                            }
                            repeat(50){
                                append(str)
                            }
                        }
                    }
                    repeat(50){
                        label("wwwwwwwwwwwwwwwwwwwww")
                    }
                }
            }
        }
    }
}