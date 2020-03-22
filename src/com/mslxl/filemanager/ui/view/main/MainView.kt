package com.mslxl.filemanager.ui.view.main

import com.mslxl.filemanager.ui.view.center.CenterView
import com.mslxl.filemanager.util.fontAwesome
import javafx.scene.control.TextField
import javafx.scene.layout.Priority
import tornadofx.*
import java.util.*

class MainView:View() {
    private val viewMainView by inject<MainViewModel>()
    private val centerView by inject<CenterView>()


    private var textFieldAddress by singleAssign<TextField>()

    init {
        messages = ResourceBundle.getBundle("lang")
        primaryStage.minHeight = 600.0
        primaryStage.minWidth = 800.0
    }

    override val root = borderpane {
        top {
            vbox {
                menubar {
                    menu(messages["menu.file"]){

                    }
                }
                toolbar{
                    button{
                        tooltip(messages["address.back"])
                        fontAwesome('\uF104')
                    }
                    button{
                        tooltip(messages["address.forward"])
                        fontAwesome('\uF105')
                    }
                    button {
                        tooltip(messages["address.up"])
                        fontAwesome('\uF106')
                    }
                    button{
                        tooltip(messages["address.home"])
                        fontAwesome('\uF015')
                    }
                    textFieldAddress = textfield {
                        hgrow = Priority.ALWAYS
                    }
                    button{
                        tooltip(messages["address.refresh"])
                        fontAwesome('\uF021')
                    }
                }

            }

        }
        center = centerView.root

    }
}