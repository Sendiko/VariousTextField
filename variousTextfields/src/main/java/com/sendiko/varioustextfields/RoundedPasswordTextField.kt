package com.sendiko.varioustextfields

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

/**
 *
 * Sendiko's Custom Password TextField!
 *
 * @author Sendiko
 * @param modifier Modifier.
 * @param value value of the textfield.
 * @param onValueChange run when user typed.
 * @param isPasswordVisible state of password visibility.
 * @param onPasswordToggle returns visibility of the password.
 * @param hint hint text.
 * @param supportingText small text shown when error/as a guide.
 * @param leadingIcon optional leading icon.
 * @param isError error state for the textfield.
 * @param enabled optional enabled state.
 * @param colors added for versatility.
 *
 * */
@Composable
fun RoundedPasswordTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    isPasswordVisible: Boolean = false,
    onPasswordToggle: (Boolean) -> Unit,
    hint: String = "",
    supportingText: String = "",
    leadingIcon: ImageVector? = null,
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
            if (isPasswordVisible) {
                IconButton(onClick = { onPasswordToggle(false) }) {
                    Icon(imageVector = Icons.Rounded.Visibility, contentDescription = null)
                }
            } else {
                IconButton(onClick = { onPasswordToggle(true) }) {
                    Icon(imageVector = Icons.Rounded.VisibilityOff, contentDescription = null)
                }
            }
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}