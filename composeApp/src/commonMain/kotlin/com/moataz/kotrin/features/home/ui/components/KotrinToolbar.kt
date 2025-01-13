package com.moataz.kotrin.features.home.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moataz.kotrin.features.home.ui.components.Constants.GITHUB_URL
import kotrin.composeapp.generated.resources.Res
import kotrin.composeapp.generated.resources.ic_github
import org.jetbrains.compose.resources.painterResource

@Composable
fun KotrinToolbar(
    title: String,
    isIconShown: Boolean = false,
) {
    val uriHandler = LocalUriHandler.current

    TopAppBar(
        backgroundColor = WhiteLight,
        elevation = 0.dp,
        modifier = Modifier.height(60.dp),
        title = {
            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Black,
                ),
            )
        },
        actions = {
            if (isIconShown) {
            Box(modifier = Modifier.padding(end = 16.dp)) {
                IconButton(
                    onClick = { uriHandler.openUri(GITHUB_URL) },
                    modifier = Modifier
                        .background(GrayLight, CircleShape)
                        .size(34.dp)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.ic_github),
                        contentDescription = "Project on Github",
                    )
                }
            }
            }
        },
    )
}

object Constants {
    const val GITHUB_URL = "https://github.com/MoatazBadawy/Mawaqeet-Todo_and_Habits"
}