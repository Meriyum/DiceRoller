package com.example.diceroller3

import DiceRollerApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroller3.ui.theme.DiceRoller3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRoller3Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    DiceRollerApp()
                    //call for function via greeting
                    Greeting("Android") //step1
                }
            }
        }
    }
}

//this is function called above
@Composable //used to compose text given in function below
//step3 from line 49, android name is sent in the name string parameter below
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//whatever is given in this function is only displayed for preview not runtime
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiceRoller3Theme {
        DiceRollerApp() //step4 from here it goes into second file
        //step2
        Greeting("Android")//calling greeting function with parameter including its name 'android'
    }
}