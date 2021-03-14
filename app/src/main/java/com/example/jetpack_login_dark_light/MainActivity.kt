package com.example.jetpack_login_dark_light

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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
            JetpacklogindarklightTheme {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(horizontal = 24.dp)
            .padding(bottom = 24.dp)
    ) {
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
    }
}

@Composable
fun LoginHeading(heading: String) {
    Row {
        Text(
            text = heading,
            fontSize = 32.sp,
            modifier = Modifier
                .padding(vertical = 32.dp)
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
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.background),
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
            color = MaterialTheme.colors.onBackground,
            fontSize = 14.sp,
        )
    }
}

@Composable
fun Or(modifier: Modifier = Modifier) {
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
            color = MaterialTheme.colors.onBackground,
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
    Column(modifier) {
        Text(
            text = label,
            color = MaterialTheme.colors.onBackground,
            fontSize = 14.sp
        )
        OutlinedTextField(
            textStyle = TextStyle(fontSize = 16.sp),
            value = value,
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = MaterialTheme.colors.onBackground),
            visualTransformation = if (isSecure) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                if (isSecure) Icon(
                    painter = painterResource(id = R.drawable.ic_eye),
                    contentDescription = "Toggle password visibility",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .clickable { }
                        .padding(10.dp),
                    tint = MaterialTheme.colors.onBackground
                )
            }
        )
    }
}

@Composable
fun Options(modifier: Modifier = Modifier) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Toggle(label = "Remember me")
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Forgot Password?", fontSize = 14.sp)
    }
}


@Composable
fun Toggle(modifier: Modifier = Modifier, label: String) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Switch(
            checked = false,
            onCheckedChange = {},
            colors = SwitchDefaults.colors(
                checkedTrackColor = MaterialTheme.colors.primary,
                uncheckedTrackColor = MaterialTheme.colors.secondary,
                checkedTrackAlpha = 1f,
                uncheckedTrackAlpha = 1f,
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
        MainContent()
    }
}