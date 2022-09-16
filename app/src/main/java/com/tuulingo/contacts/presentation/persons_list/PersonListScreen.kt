package com.tuulingo.contacts.presentation.persons_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tuulingo.contacts.presentation.Screen
import com.tuulingo.contacts.presentation.persons_list.components.PersonListItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PersonListScreen(
    navController: NavController,
    viewModel: PersonListViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Pipedrive Contacts",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp, 20.dp, 0.dp, 10.dp)
            )
            Divider()
        }
        LazyColumn(modifier = Modifier
            .fillMaxSize()) {
            val grouped = state.persons.groupBy { it.firstName[0] }

            grouped.forEach { (header, persons) ->
                stickyHeader {
                    Text(
                        text = header.toString(),
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Blue.copy(alpha = 0.6f, red = 0.6f,  green = 0.6f, blue = 0.6f),
                        modifier = Modifier
                            .background(
                                Color.LightGray.copy(red = 0.15f, green = 0.15f, blue = 0.15f)
                            )
                            .padding(15.dp, 7.dp, 0.dp, 7.dp)
                            .fillParentMaxWidth(1.5f)
                    )
                }
                items(persons) { person ->
                    PersonListItem(person = person, onItemClick = {
                        navController.navigate(Screen.PersonDetailScreen.route + "/${person.id}")
                    })
                }
            }

        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = CenterStart) {
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}