package com.tuulingo.contacts.presentation

sealed class Screen(val route: String) {
    object PersonListScreen: Screen("person_list_screen")
    object PersonDetailScreen: Screen("person_detail_screen")
}
