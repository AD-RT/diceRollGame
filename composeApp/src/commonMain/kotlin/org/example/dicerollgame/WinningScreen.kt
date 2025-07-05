package org.example.dicerollgame

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Winner(
    player1Score: Int,
    player2Score: Int
){
    var player1Score = player1Score
    var player2Score = player2Score
    var diceVisible = -1
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Button(onClick = {
            player1Score = 0
            player2Score = 0
        }) {
            Text("Restart")

        }

    }
}