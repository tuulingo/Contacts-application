package com.tuulingo.contacts.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tuulingo.contacts.presentation.person_detail.PersonDetailScreen
import com.tuulingo.contacts.presentation.persons_list.PersonListScreen
import com.tuulingo.contacts.presentation.ui.theme.ContactsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.PersonListScreen.route
                    )
                    {
                        composable(
                            route = Screen.PersonListScreen.route
                        ) {
                            PersonListScreen(navController)
                        }
                        composable(
                            route = Screen.PersonDetailScreen.route + "/{personId}"
                        ) {
                            PersonDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
