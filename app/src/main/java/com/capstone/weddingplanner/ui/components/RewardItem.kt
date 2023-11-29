package com.capstone.weddingplanner.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.capstone.weddingplanner.R
import com.capstone.weddingplanner.ui.theme.Merah
import com.capstone.weddingplanner.ui.theme.Shapes
import com.capstone.weddingplanner.ui.theme.WeddingPlannerTheme

@Composable
fun RewardItem(
    image: Int,
    title: String,
    detail: String,
    requiredPoint: Int,
    modifier: Modifier = Modifier,
) {

        Column(
            modifier = modifier.padding(8.dp)
                .fillMaxWidth()
        ) {
            val provider = GoogleFont.Provider(
                "com.google.android.gms.fonts",
                "com.google.android.gms",
                certificates = R.array.com_google_android_gms_fonts_certs
            )
            val fontName = GoogleFont("Roboto")
            val robotoFont = FontFamily(
                Font(fontName, provider)
            )

            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(335.dp, 165.dp)
                    .clip(Shapes.medium)
            )
            Text(
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontFamily = robotoFont,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = detail,
                fontFamily = robotoFont,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.size(width = 226.dp, height = 34.dp)

            )
            Divider(color = Merah, modifier = Modifier.padding(vertical = 16.dp))
//            Text(
//                text = stringResource(R.string.required_money, requiredPoint),
//                fontFamily = robotoFont,
//                style = MaterialTheme.typography.titleMedium.copy(
//                    fontWeight = FontWeight.Bold
//                )
//            )
        }

}

@Composable
@Preview(showBackground = true)
fun RewardItemPreview() {
    WeddingPlannerTheme {
        RewardItem(R.mipmap.vendor_4, "Jaket Hoodie Dicoding", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",4000)
    }
}