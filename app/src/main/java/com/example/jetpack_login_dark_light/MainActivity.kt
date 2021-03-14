package com.example.jetpack_login_dark_light

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_login_dark_light.ui.theme.JetpacklogindarklightTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember { mutableStateOf(AppCompatDelegate.getDefaultNightMode() != AppCompatDelegate.MODE_NIGHT_YES) }
            JetpacklogindarklightTheme(isDarkTheme) {
                MainContent(isDarkTheme) {
                    isDarkTheme = !isDarkTheme
                }
            }
        }
    }
}

@Composable
fun MainContent(isDarkTheme: Boolean, toggleTheme: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(horizontal = 24.dp)
            .padding(bottom = 8.dp)
    ) {
        Toggle(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .wrapContentWidth(Alignment.End),
            label = "Dark Mode",
            value = isDarkTheme,
            onToggle = {
                toggleTheme()
            }
        )
        LoginHeading("Login")
        SocialButton(
            modifier = Modifier
                .padding(bottom = 24.dp), labelResource = R.string.google_button_label,
            iconResource = R.drawable.ic_google
        )
        SocialButton(
            labelResource = R.string.facebook_button_label,
            iconResource = R.drawable.ic_facebook,
            iconTint = MaterialTheme.colors.secondary
        )
        Or()
        Form()
        Options()
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primaryVariant
            ),
            contentPadding = PaddingValues(vertical = 12.dp, horizontal = 0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(text = "Login", fontSize = 16.sp, color = MaterialTheme.colors.onPrimary)
        }
    }
}

@Composable
fun LoginHeading(heading: String) {
    Row {
        Text(
            text = heading,
            fontSize = 32.sp,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .weight(1f),
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun SocialButton(
    modifier: Modifier = Modifier,
    labelResource: Int,
    iconResource: Int,
    iconTint: Color = Color.Unspecified
) {
    val isDarkTheme = !MaterialTheme.colors.isLight
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isDarkTheme) MaterialTheme.colors.onSurface.copy(
                alpha = 0.2f
            ) else MaterialTheme.colors.background
        ),
        modifier = modifier
            .fillMaxWidth()
            .shadow(8.dp, shape = RoundedCornerShape(5.dp)),
        contentPadding = PaddingValues(15.dp),

        ) {
        Icon(
            painter = painterResource(id = iconResource),
            tint = iconTint,
            contentDescription = stringResource(
                id = labelResource
            ),
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(32.dp))
        Text(
            text = stringResource(id = labelResource),
            color = if (isDarkTheme) MaterialTheme.colors.onSurface else MaterialTheme.colors.onBackground,
            fontSize = 14.sp,
        )
    }
}

@Composable
fun Or(modifier: Modifier = Modifier) {
    val isDarkTheme = !MaterialTheme.colors.isLight
    Row(
        modifier
            .padding(vertical = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .weight(1f)
        )
        Text(
            "Or",
            color = if (isDarkTheme) MaterialTheme.colors.onSurface else MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
        Divider(
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Composable
fun Form() {
    Column(modifier = Modifier.padding(bottom = 24.dp)) {
        Input(
            Modifier.padding(bottom = 16.dp),
            label = "Username",
            value = "vijusawant81@gmail.com"
        )
        Input(
            label = "Password",
            value = "mysecurepassword",
            isSecure = true
        )
    }
}

@Composable
fun Input(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    isSecure: Boolean = false,
) {
    val isDarkTheme = !MaterialTheme.colors.isLight
    Column(modifier) {
        Text(
            text = label,
            color = if (isDarkTheme) MaterialTheme.colors.onSurface else MaterialTheme.colors.onBackground,
            fontSize = 14.sp
        )
        BasicTextField(
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = if (isDarkTheme) MaterialTheme.colors.onBackground else MaterialTheme.colors.onSurface
            ),
            value = value,
            onValueChange = { },
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .border(
                    if (isDarkTheme) 0.dp else 1.dp,
                    if (isDarkTheme) MaterialTheme.colors.onSurface.copy(
                        alpha = 0.2f
                    ) else MaterialTheme.colors.onBackground,
                    RoundedCornerShape(8.dp)
                )
                .background(
                    if (isDarkTheme) MaterialTheme.colors.onSurface.copy(
                        alpha = 0.2f
                    ) else MaterialTheme.colors.background,
                )
                .padding(horizontal = 24.dp, vertical = 16.dp),
            visualTransformation = if (isSecure) PasswordVisualTransformation() else VisualTransformation.None,
        )
    }
}
// trailingIcon = {
//    if (isSecure) Icon(
//        painter = painterResource(id = R.drawable.ic_eye),
//        contentDescription = "Toggle password visibility",
//        modifier = Modifier
//            .size(40.dp)
//            .clip(CircleShape)
//            .clickable { }
//            .padding(10.dp),
//        tint = if (isDarkTheme) MaterialTheme.colors.onSurface else MaterialTheme.colors.onBackground
//    )
//},
//shape = RoundedCornerShape(8.dp),
//colors = TextFieldDefaults.outlinedTextFieldColors(
//unfocusedBorderColor = MaterialTheme.colors.onBackground,
//backgroundColor = if (isDarkTheme) MaterialTheme.colors.onSurface.copy(
//alpha = 0.2f
//) else MaterialTheme.colors.background,
//),

@Composable
fun Options(modifier: Modifier = Modifier) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Toggle(label = "Remember me", onToggle = {})
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Forgot Password?", fontSize = 14.sp, color = MaterialTheme.colors.onSurface)
    }
}


@Composable
fun Toggle(
    modifier: Modifier = Modifier,
    label: String,
    value: Boolean = false,
    onToggle: (value: Boolean) -> Unit
) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Switch(
            checked = value,
            onCheckedChange = { onToggle(it) },
            colors = SwitchDefaults.colors(
                checkedTrackColor = MaterialTheme.colors.primary,
                uncheckedTrackColor = MaterialTheme.colors.secondary,
                checkedTrackAlpha = 1f,
                uncheckedTrackAlpha = 1f,
                checkedThumbColor = MaterialTheme.colors.onPrimary,
                uncheckedThumbColor = MaterialTheme.colors.onPrimary
            ),
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(text = label, fontSize = 14.sp, color = MaterialTheme.colors.onSurface)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpacklogindarklightTheme {
        MainContent(true) {}
    }
}