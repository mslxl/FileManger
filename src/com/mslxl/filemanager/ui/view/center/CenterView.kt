package com.mslxl.filemanager.ui.view.center

import com.mslxl.filemanager.ui.component.DrawеrItem
import com.mslxl.filemanager.ui.view.drawer.DrawerFragment
import com.mslxl.filemanager.ui.view.tab.TabView
import javafx.collections.ListChangeListener
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Orientation
import javafx.geometry.Side
import javafx.scene.Group
import javafx.scene.control.SplitPane
import javafx.scene.control.ToggleButton
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import tornadofx.*

class CenterView : View() {
    private val leftDrawer =
        find<DrawerFragment>(mapOf(DrawerFragment::side to Side.LEFT))
    private val rightDrawer =
        find<DrawerFragment>(mapOf(DrawerFragment::side to Side.RIGHT))
    private val bottomDrawer =
        find<DrawerFragment>(mapOf(DrawerFragment::side to Side.BOTTOM))
    private val tabPane by inject<TabView>()

    private var verticalSplit: SplitPane by singleAssign()
    private var horizontalSplit: SplitPane by singleAssign()
    override val root = splitpane(Orientation.VERTICAL) {
        verticalSplit = this
        horizontalSplit = splitpane(Orientation.HORIZONTAL) {
            add(leftDrawer)
            add(tabPane)
            add(rightDrawer)
        }
        add(bottomDrawer)




        fun DrawerFragment.initSplitPaneUpdate(orientation: Orientation) {
            this.root.items.forEach {
                it.button.action {
                    updateDividerPos(orientation)
                }
            }
            this.root.items.addListener { c: ListChangeListener.Change<out DrawеrItem>? ->
                c?.let { e ->
                    e.addedSubList.forEach {
                        it.button.action {
                            updateDividerPos(orientation)
                        }
                    }
                }
            }
        }
        leftDrawer.initSplitPaneUpdate(Orientation.HORIZONTAL)
        rightDrawer.initSplitPaneUpdate(Orientation.HORIZONTAL)
        bottomDrawer.initSplitPaneUpdate(Orientation.VERTICAL)

        primaryStage.setOnShown {
            updateDividerPos(Orientation.HORIZONTAL)
            updateDividerPos(Orientation.VERTICAL)
        }
    }


    private fun updateDividerPos(orientation: Orientation = Orientation.HORIZONTAL) {
        fun DrawerFragment.hasChildSelected(): Boolean {
            return root.buttonArea.childrenUnmodifiable.find { box ->
                (box is VBox || box is HBox) &&
                        (box as Pane).childrenUnmodifiable.find { group ->
                            group is Group &&
                                    group.childrenUnmodifiable.find { button ->
                                        button is ToggleButton && button.isSelected
                                    } != null
                        } != null

            } != null
        }


        if (orientation == Orientation.HORIZONTAL) {

            if (leftDrawer.hasChildSelected()) {
                leftDrawer.root.maxWidthProperty().unbind()
                leftDrawer.root.maxWidthProperty().bind(horizontalSplit.widthProperty().multiply(0.25))
                leftDrawer.root.prefWidth = horizontalSplit.width * 0.25
            } else {
                leftDrawer.root.maxWidthProperty().unbind()
                leftDrawer.root.maxWidthProperty().bind(horizontalSplit.widthProperty().multiply(0))
            }

            if (rightDrawer.hasChildSelected()) {
                rightDrawer.root.maxWidthProperty().unbind()
                rightDrawer.root.maxWidthProperty().bind(horizontalSplit.widthProperty().multiply(0.25))
                rightDrawer.root.prefWidth = horizontalSplit.width * 0.25

            } else {
                rightDrawer.root.maxWidthProperty().unbind()
                rightDrawer.root.maxWidthProperty().bind(horizontalSplit.widthProperty().multiply(0))
            }

        } else {
            if (bottomDrawer.hasChildSelected()) {
                bottomDrawer.root.maxHeightProperty().unbind()
                bottomDrawer.root.maxHeightProperty().bind(horizontalSplit.heightProperty().multiply(0.6))
                bottomDrawer.root.prefHeight = horizontalSplit.height * 0.4

            } else {
                bottomDrawer.root.maxHeightProperty().unbind()
                bottomDrawer.root.maxHeightProperty().bind(horizontalSplit.heightProperty().multiply(0))
            }
        }
    }
}