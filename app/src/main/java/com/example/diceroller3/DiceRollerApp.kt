import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import com.example.diceroller3.R

@Composable //step5
fun DiceRollerApp() {
    var diceResult by remember { mutableStateOf(1) } //default value of 1 for random number generated
    val context = LocalContext.current //LocalContext is used to load image

    Column(
        modifier = Modifier //context for styling
            .fillMaxSize() //for both height and width included
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(getImageResource(diceResult, context)), //from button result of number generated comes in the dice result
            contentDescription = "Dice",
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { diceResult = rollDice() }, //onclick will call roll dice function when button is clicked and the result is saved on dice result.
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Roll the Dice")
        }
    }
}

private fun rollDice() = (1..6).random()//random number generated and went back into button

private fun getImageResource(result: Int, context: Context): Int {
    return when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}
