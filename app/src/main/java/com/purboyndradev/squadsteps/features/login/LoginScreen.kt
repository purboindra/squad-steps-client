package com.purboyndradev.squadsteps.features.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.purboyndradev.squadsteps.features.components.AppTextField
import com.purboyndradev.squadsteps.features.components.CircleAvatar
import com.purboyndradev.squadsteps.features.components.PrimaryButton
import com.purboyndradev.squadsteps.ui.theme.AppAssets
import com.purboyndradev.squadsteps.ui.theme.BlackColor
import com.purboyndradev.squadsteps.ui.theme.DarkGreenColor
import com.purboyndradev.squadsteps.ui.theme.GreyColor
import com.purboyndradev.squadsteps.ui.theme.GreyColor2
import com.purboyndradev.squadsteps.ui.theme.PrimaryColor

@Composable
fun LoginScreen(
    onNavigate: () -> Unit
) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(AppAssets.logo),
                            contentDescription = "Logo",
                            modifier = Modifier.size(48.dp)
                        )
                        Text(
                            "SquadSteps", style = MaterialTheme.typography.displaySmall.copy(
                                fontWeight = FontWeight.Black,
                                color = PrimaryColor,
                            )
                        )
                        Text(
                            "Precision Social Fitness".uppercase(),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = GreyColor,
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(64.dp))
                Text(
                    "Email", style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                )
                AppTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = "Enter your email"
                )

                Spacer(modifier = Modifier.height(32.dp))

                PrimaryButton(
                    onClick = {
                        onNavigate()
                    },
                    label = "Sign in with Passkey",
                    icon = {
                        Image(
                            painter = painterResource(AppAssets.fingerPrint),
                            contentDescription = "Passkeys"
                        )
                    }
                )

                Spacer(modifier = Modifier.height(56.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(BlackColor)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp, horizontal = 32.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Box(
                            modifier = Modifier
                                .height(32.dp)
                        ) {
                            CircleAvatar(
                                imageUrl = "https://randomuser.me/api/portraits/men/75.jpg",
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(32.dp)
                                    .offset(
                                        x = (-24).dp,
                                    )
                                    .clip(CircleShape)
                                    .background(GreyColor2)
                            )
                            CircleAvatar(
                                imageUrl = "https://randomuser.me/api/portraits/men/45.jpg",
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(32.dp)
                                    .clip(CircleShape)
                                    .background(GreyColor2)
                            )
                            CircleAvatar(
                                imageUrl = "https://randomuser.me/api/portraits/men/13.jpg",
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(32.dp)
                                    .offset(
                                        x = (18).dp,
                                    )
                                    .clip(CircleShape)
                                    .background(GreyColor2)
                            )
                        }

                        Spacer(modifier = Modifier.width(24.dp))

                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Medium, color = GreyColor2
                                    )
                                ) {
                                    append("Join ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Medium, color = PrimaryColor
                                    )
                                ) {
                                    append("12k+ ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Medium, color = GreyColor2
                                    )
                                ) {
                                    append("athletes stepping today")
                                }
                            }
                        )
                    }
                }

            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 40.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        "TERMS OF SERVICE", style = MaterialTheme.typography.labelLarge.copy(
                            color = Color.White.copy(
                                alpha = 0.7f
                            )
                        )
                    )
                    Text(
                        "PRIVACY POLICY", style = MaterialTheme.typography.labelLarge.copy(
                            color = Color.White.copy(
                                alpha = 0.7f
                            )
                        )
                    )
                }
            }
        }
    }
}