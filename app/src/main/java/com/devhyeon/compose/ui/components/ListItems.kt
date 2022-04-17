package com.devhyeon.compose.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devhyeon.compose.R
import com.devhyeon.compose.ui.theme.Shapes

@Preview(showBackground = true)
@Composable
fun ListItemFreeView() {
    Column {
        HomeListItemView(
            title = "Hello,",
            subTitle = "World.",
            message = "Compose Study My nickname is DevHyeon",
            defaultExpanded = false
        )
        HomeListItemView(
            title = "Hello,",
            subTitle = "World.",
            message = "Compose Study My nickname is DevHyeon",
            defaultExpanded = true
        )
    }
}

@Composable
fun HomeListItemView(
    title: String,
    subTitle: String,
    message: String,
    defaultExpanded: Boolean = false
) {
    var expanded by rememberSaveable { mutableStateOf(defaultExpanded) }
    Box(modifier = Modifier
        .padding(12.dp)
        .background(MaterialTheme.colors.primary, RoundedCornerShape(20.dp))
        .animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
    ) {
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                Text(text = title)
                Text(
                    text = subTitle,
                    style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                if (expanded) {
                    Text(
                        text = message.repeat(20),
                        lineHeight = 20.sp,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            IconButton(
                onClick = { expanded = !expanded }
            ) {
                Icon(
                    imageVector = if (expanded) Filled.ExpandLess else Filled.ExpandMore,
                    contentDescription = if (expanded) {
                        stringResource(R.string.show_less)
                    } else {
                        stringResource(R.string.show_more)
                    }

                )
            }
        }
    }
}