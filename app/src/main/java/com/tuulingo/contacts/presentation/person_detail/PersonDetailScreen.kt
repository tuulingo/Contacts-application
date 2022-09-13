package com.tuulingo.contacts.presentation.person_detail

import androidx.compose.foundation.Image
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
                        if (person.pictureUrl == "") {
                            Image(
                                painterResource(R.drawable.person_placeholder),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(120.dp)
                            )
                        } else {
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
                                    .size(120.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "${person.firstName} ${person.lastName}",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.h4
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "Organization: ${person.orgName}",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.body2,
                            color = Color.Gray,
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Divider(Modifier.fillMaxWidth())
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.Start
                    ) {

                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Phone(s)",
                        style = MaterialTheme.typography.h5,
                    )

                    FlowColumn(
                        mainAxisSpacing = 5.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 8.dp, 0.dp, 4.dp),
                    ) {
                        person.phones.forEach { phone ->
                            Text(
                                text = "${phone.label.replaceFirstChar { it.uppercase() }} phone: ${phone.value}",
                                style = MaterialTheme.typography.body2,
                                color = Color.Gray,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Email(s)",
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 8.dp, 0.dp, 4.dp)
                    )

                    FlowColumn(
                        mainAxisSpacing = 5.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        person.emails.forEach { email ->
                            Text(
                                text = "${email.label.replaceFirstChar { it.uppercase() }} email: ${email.value}",
                                style = MaterialTheme.typography.body2,
                                color = Color.Gray,

                                )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Deals",
                        style = MaterialTheme.typography.h5
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        Text(
                            text = "Open deals: ${person.openDealsCount}",
                            style = MaterialTheme.typography.body2,
                            color = Color.Gray,

                            )
                        Text(
                            text = "Closed deals: ${person.closedDealsCount}",
                            style = MaterialTheme.typography.body2,
                            color = Color.Gray,
                            modifier = Modifier.padding(8.dp, 0.dp)
                        )

                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Owner",
                        style = MaterialTheme.typography.h5
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Name: ${person.ownerName}", style = MaterialTheme.typography.body2,
                        color = Color.Gray,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Email: ${person.ownerEmail}",
                        style = MaterialTheme.typography.body2,
                        color = Color.Gray,
                    )


                }
            }
        }
    }
}