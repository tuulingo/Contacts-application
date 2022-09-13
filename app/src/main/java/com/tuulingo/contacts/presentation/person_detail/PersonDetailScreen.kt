package com.tuulingo.contacts.presentation.person_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.flowlayout.FlowColumn
import com.tuulingo.contacts.R

@Composable
fun PersonDetailScreen(
    viewModel: PersonDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.person?.let { person ->
            Column(modifier = Modifier.fillMaxSize()) {
                Text(text = "A PERSON WITH ID ${person.personId} ARRIVED", color = Color.Red, modifier = Modifier.fillMaxSize())

            }

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.3f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(person.pictureUrl)
                                .crossfade(true)
                                .build(),
                            placeholder = painterResource(R.drawable.person_placeholder),
                            contentDescription = stringResource(R.string.contact_picture),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(CircleShape)
                                .fillMaxSize(0.2f),
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "A PERSON WITH ID ${person.personId} ARRIVED", color = Color.Red, modifier = Modifier.fillMaxSize())
                        Text(text = "${person.firstName} ${person.lastName}", color = Color.Blue, textAlign = TextAlign.Center, style = MaterialTheme.typography.h4)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "Organization: ${person.orgName}", textAlign = TextAlign.Center, style = MaterialTheme.typography.h5)
                    }
                    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.Start) {

                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = "Phone",
                        style = MaterialTheme.typography.h3
                    )
                    FlowColumn(mainAxisSpacing = 15.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        person.phones.forEach { phone ->
                            Text(text = "${phone.label}: ${phone.value}", style = MaterialTheme.typography.h4)
                            Divider()
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Email",
                        style = MaterialTheme.typography.h3
                    )
                    FlowColumn(mainAxisSpacing = 15.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        person.emails.forEach { email ->
                            Text(text = "${email.label}: ${email.value}", style = MaterialTheme.typography.h4)
                            Divider()
                        }
                    }
                    Text(
                        text = "Deals",
                        style = MaterialTheme.typography.h3
                    )
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "Open deals: ${person.openDealsCount}")
                        Text(text = "Closed deals: ${person.closedDealsCount}")

                    }
                    Text(
                        text = "Owner",
                        style = MaterialTheme.typography.h3
                    )
                    Text(text = person.ownerName)
                    Text(text = person.ownerEmail)


                }
            }
        }
    }
}