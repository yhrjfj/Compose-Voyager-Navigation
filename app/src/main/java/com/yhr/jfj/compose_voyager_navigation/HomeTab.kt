package com.yhr.jfj.compose_voyager_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

/**
 * Represents the HomeTab object which implements the Tab interface.
 * This object is used to create a tab with specific options and content.
 */
object HomeTab : Tab {

    /**
     * Provides the options for the HomeTab.
     * These options include the index, title, and icon of the tab.
     * @return TabOptions object with the specified index, title, and icon.
     */
    override val options: TabOptions
        @Composable
        get() {
            val title = "Account"
            val icon = rememberVectorPainter(Icons.Default.Home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    /**
     * Provides the content for the HomeTab.
     * In this case, the content is a Navigator with Screen1 as the initial screen.
     */
    @Composable
    override fun Content() {
        Navigator(screen = Screen1())
    }
}