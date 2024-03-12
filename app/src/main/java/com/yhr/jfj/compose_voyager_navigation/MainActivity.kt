package com.yhr.jfj.compose_voyager_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.yhr.jfj.compose_voyager_navigation.ui.theme.ComposeVoyagerNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeVoyagerNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /**
                     * This is the main navigation structure of the application.
                     * It uses a TabNavigator with HomeTab as the initial tab.
                     * The Scaffold is used to provide a consistent visual structure to the app.
                     * The bottomBar of the Scaffold contains a NavigationBar with two tabs: HomeTab and AccountTab.
                     * The content of the current tab is displayed in a Box with padding calculated from the Scaffold's bottom padding.
                     */
                    TabNavigator(tab = HomeTab) {
                        Scaffold(
                            bottomBar = {
                                /**
                                 * The NavigationBar is a container for navigation items.
                                 * It contains two TabNavigationItems: HomeTab and AccountTab.
                                 */
                                NavigationBar {
                                    TabNavigationItem(tab = HomeTab)
                                    TabNavigationItem(tab = AccountTab)
                                }
                            }
                        ) {
                            /**
                             * The Box composable is used to display the content of the current tab.
                             * The padding is calculated from the Scaffold's bottom padding.
                             */
                            Box(
                                modifier = Modifier.padding(it.calculateBottomPadding())
                            ) {
                                /**
                                 * CurrentTab is a composable that displays the content of the current tab.
                                 */
                                CurrentTab()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigation = LocalTabNavigator.current
    NavigationBarItem(
        selected = tabNavigation.current == tab,
        onClick = {
            tabNavigation.current = tab
        },
        icon = {
            tab.options.icon?.let {
                Icon(
                    painter = it,
                    contentDescription = tab.options.title
                )
            }
        },
        label = {
            Text(text = tab.options.title)
        }
    )
}