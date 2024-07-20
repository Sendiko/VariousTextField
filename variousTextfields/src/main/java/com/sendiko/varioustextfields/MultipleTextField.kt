package com.sendiko.varioustextfields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 *
 * Sendiko's Custom Numeric Textfield!
 * designed to used with short amount of number
 *
 * @author Sendiko
 *
 * @param modifier Modifier.
 * @param value value of the text.
 * @param numberOfTextField the amount of number can be hold.
 * @param message text shown when textfield full/error.
 *
 * */
@Composable
fun MultipleTextField(
    modifier: Modifier = Modifier,
    value: String,
    numberOfTextField: Int,
    message: String = "",
    unfocusedBorderColor: Color? = null,
    focusedBorderColor: Color? = null,
) {
    Column {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            (1..numberOfTextField).forEach {
                IndividualTextField(
                    value = value,
                    index = it - 1,
                    unfocusedBorderColor = unfocusedBorderColor,
                    focusedBorderColor = focusedBorderColor
                )
            }
        }
        message.isNotBlank().let {
            Text(
                modifier = Modifier,
                text = message,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
