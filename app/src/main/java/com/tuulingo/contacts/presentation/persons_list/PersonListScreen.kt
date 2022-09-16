package com.tuulingo.contacts.presentation.persons_list

import android.graphics.fonts.FontStyle
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tuulingo.contacts.presentation.Screen
import com.tuulingo.contacts.presentation.persons_list.components.PersonListItem

@Composable
fun PersonListScreen(
    navController: NavController,
    viewModel: PersonListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Pipedrive Contacts", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.subtitle1,  textAlign = TextAlign.Start, modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp,20.dp,0.dp,10.dp))
            Divider()
        }
        LazyColumn(modifier = Modifier.fillMaxSize().padding(10.dp)) {

            items(state.persons) { person ->
                PersonListItem(person = person, onItemClick = {
                    navController.navigate(Screen.PersonDetailScreen.route + "/${person.id}")
                })
            }
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = CenterStart) {
            if(state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center))
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}