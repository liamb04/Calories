package com.example.calories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calories.ui.theme.CaloriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloriesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalorieScreen()

                }
            }
        }
    }
}



@Composable
fun Heading(title:String){
    Text(
        text=title,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 24.dp)
    )

}
@Composable
fun CalorieScreen(){
    var weightInput by remember { mutableStateOf( "") }
    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Heading(title = stringResource(R.string.calories))
        WeightField(weightInput = weightInput, onValueChange = {weightInput=it})
    }
}
@Composable
fun WeightField(weightInput: String, onValueChange:(String)-> Unit){
    OutlinedTextField(
        value = weightInput,
        onValueChange =onValueChange,
        label={Text(text="Enter Weight")},
        singleLine=true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier= Modifier.fillMaxWidth()

    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CaloriesTheme {
        CalorieScreen()
    }
}