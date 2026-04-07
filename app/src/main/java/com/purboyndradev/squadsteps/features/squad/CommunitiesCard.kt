package com.purboyndradev.squadsteps.features.squad

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.purboyndradev.squadsteps.features.components.AppTextField
import com.purboyndradev.squadsteps.features.components.PrimaryButton
import com.purboyndradev.squadsteps.ui.theme.BlackColor
import com.purboyndradev.squadsteps.ui.theme.DarkGreenColor
import com.purboyndradev.squadsteps.ui.theme.GreyColor
import com.purboyndradev.squadsteps.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunitiesCard(modifier: Modifier = Modifier) {

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {

            Column(
                modifier = Modifier.padding(
                    vertical = 12.dp,
                    horizontal = 18.dp
                )
            ) {
                Text(
                    "Create Squad", style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Enter a unique squad code to join your friends or start a fresh movement of your own.",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = GreyColor
                    )
                )

                Spacer(modifier = Modifier.height(18.dp))
                AppTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = "Enter your squad name"
                )
                Spacer(modifier = Modifier.height(24.dp))
                PrimaryButton(
                    onClick = {},
                    label = "Create New Squad"
                )
            }

        }
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .background(
                color = BlackColor
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                "Your Communities", style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
            )
            Text(
                "Active in 4 Squads this week",
                style = MaterialTheme.typography.titleSmall.copy(
                    color = GreyColor
                )
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                ElevatedButton(
                    onClick = {
                        showBottomSheet = true
                    },
                    shape = RoundedCornerShape(100),
                    colors = ButtonColors(
                        containerColor = PrimaryColor,
                        contentColor = DarkGreenColor,
                        disabledContainerColor = GreyColor,
                        disabledContentColor = DarkGreenColor,
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            Icons.Outlined.AddCircle, contentDescription = "Create Squad",
                            tint = BlackColor,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "Create Squad", style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Medium,
                                color = BlackColor
                            )
                        )
                    }
                }
            }
        }
    }
}