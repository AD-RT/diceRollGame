package org.example.dicerollgame


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dicerollgame.composeapp.generated.resources.Res
import dicerollgame.composeapp.generated.resources.compose_multiplatform
import dicerollgame.composeapp.generated.resources.dice
import dicerollgame.composeapp.generated.resources.dice_1
import dicerollgame.composeapp.generated.resources.dice_2
import dicerollgame.composeapp.generated.resources.dice_3
import dicerollgame.composeapp.generated.resources.dice_4
import dicerollgame.composeapp.generated.resources.dice_5
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        val diceList = listOf(
            Res.drawable.dice,
            Res.drawable.dice_1,
            Res.drawable.dice_2,
            Res.drawable.dice_3,
            Res.drawable.dice_4,
            Res.drawable.dice_5
        )
        val diceVisible = remember { mutableStateOf(-1) }
        val isplayer1  = remember { mutableStateOf(true) }
        val player1Score = remember { mutableStateOf(0) }
        val player2Score = remember { mutableStateOf(0) }


        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,

                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                if(player1Score.value >= 20 || player2Score.value >= 20){
                    Text("Game Over")
                    if (player1Score.value > player2Score.value) {
                        Text("Player 1 is the winner")
                            Button(onClick = {
                                player1Score.value = 0
                                player2Score.value = 0
                                diceVisible.value = -1
                                isplayer1.value = true
                            }){
                                Text("Restart")
                            }
                    } else {
                        Text("Player 2 is the winner")
                        Button(onClick = {
                            player1Score.value = 0
                            player2Score.value = 0
                            diceVisible.value = -1
                            isplayer1.value = true
                        }){
                            Text("Restart")
                        }
                    }

                }

                Text("Welcome to the Dice Roller Game!")
                if(diceVisible.value != -1){
                    Image(
                        painter = painterResource(diceList.get(diceVisible.value)),
                        contentDescription = null
                    )
                }else{
                    Image(
                        painter = painterResource(Res.drawable.compose_multiplatform),
                        contentDescription = null
                    )
                }
                Button(
                    onClick = {

                        diceVisible.value = (0..5).random()
                        if(isplayer1.value){
                            player1Score.value += diceVisible.value+1
                            isplayer1.value = !isplayer1.value
                        }else{
                            player2Score.value += diceVisible.value+1
                            isplayer1.value = !isplayer1.value
                        }
                    }
                ){
                    Text("Roll the dice! ${if(isplayer1.value) "Player 1" else "Player 2"}")
                }
                Row(
                ){
                    Text("Player 1 Score: ${player1Score.value}")
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text("Player 2 Score: ${player2Score.value}")

                }
            }
        }
    }
}