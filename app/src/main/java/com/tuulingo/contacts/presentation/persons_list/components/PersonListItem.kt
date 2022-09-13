package com.tuulingo.contacts.presentation.persons_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tuulingo.contacts.R
import com.tuulingo.contacts.domain.model.PersonModel

@Composable
fun PersonListItem(
    person: PersonModel,
    onItemClick: (PersonModel) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(person) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        if (person.pictureUrl == "") {
            Image(
                painterResource(R.drawable.person_placeholder),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxHeight()
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
                    .size(60.dp)
            )
        }
        
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "${person.firstName} ${person.lastName}",
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 16.dp)
            )
            person.phones.forEach { phone ->
                if (phone.label == "work") {
                    Text(
                        text = "${phone.label}: ${phone.value}",
                        style = MaterialTheme.typography.body2,
                        color = Color.Gray,
                        textAlign = TextAlign.End
                    )
                }
            }
        }
    }
}
