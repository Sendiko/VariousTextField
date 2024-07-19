package com.sendiko.varioustextfields

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

/**
 *
 * Sendiko's Custom Rounded TextField!
 *
 * @author Sendiko
 * @param modifier Modifier.
 * @param value value of the textfield.
 * @param onValueChange run when user typed.
 * @param hint hint text.
 * @param supportingText small text shown when error/as a guide.
 * @param leadingIcon optional leading icon.
 * @param isError error state for the textfield.
 * @param enabled optional enabled state.
 * @param colors added for versatility.
 *
 * */
@Composable
fun RoundedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String = "",
    supportingText: String = "",
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    isError: Boolean = false,
    enabled: Boolean = true,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors()
) {
    OutlinedTextField(
        modifier = modifier,
        shape = CircleShape,
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = hint) },
        supportingText = { Text(text = supportingText) },
        isError = isError,
        enabled = enabled,
        colors = colors,
        leadingIcon = {
            leadingIcon?.let {
                Icon(imageVector = it, contentDescription = null)
            }
        },
        trailingIcon = {
            trailingIcon?.let {
                Icon(imageVector = it, contentDescription = null)
            }
        }
    )
}