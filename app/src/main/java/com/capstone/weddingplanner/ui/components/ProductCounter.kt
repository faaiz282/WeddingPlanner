package com.capstone.weddingplanner.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.capstone.weddingplanner.R
import com.capstone.weddingplanner.ui.theme.Shapes
import com.capstone.weddingplanner.ui.theme.WeddingPlannerTheme

@Composable
fun ProductCounter(
    orderId: Long,
    orderCount: Int,
    onProductIncreased: (Long) -> Unit,
    onProductDecreased: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()

    ) {

        ButtonWithText(
            "100 pax",
            Modifier.weight(1f)
        )
        ButtonWithText(
            "200 pax",
            Modifier.weight(1f)

        )
        ButtonWithText(
            "400 pax",
            Modifier.weight(1f)

        )



//        Text(
//            text = orderCount.toString(),
//            modifier = Modifier
//                .weight(1f)
//                .testTag("count"),
//            fontSize = 20.sp,
//            textAlign = TextAlign.Center,
//            fontWeight = FontWeight.Bold
//        )
//        Surface(
//            shape = RoundedCornerShape(size = 5.dp),
//            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
//            color = Color.Transparent,
//            contentColor = MaterialTheme.colorScheme.primary,
//            modifier = Modifier.size(30.dp)
//        ) {
//            Text(
//                text = "＋",
//                fontSize = 22.sp,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .weight(1f)
//                    .clickable {
//                        onProductIncreased(orderId)
//                    }
//            )
//        }
    }
}
@Composable
fun ButtonWithText(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_500)),
        modifier = modifier
            .padding(8.dp),
        shape = Shapes.extraSmall,
        contentPadding = PaddingValues(2.dp),
    ) {
        Text(text, fontSize = 22.sp, )
    }
}
@Preview
@Composable
fun ProductCounterPreview() {
    WeddingPlannerTheme {
        ProductCounter(
            orderId = 1,
            orderCount = 0,
            onProductIncreased = { },
            onProductDecreased = { }
        )
    }
}
