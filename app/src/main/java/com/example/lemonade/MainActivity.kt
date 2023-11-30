package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Limonada()
            }
        }
    }
}

@Composable
fun Limonada() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        //Cabecera
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color(221, 223, 87))
            )
            {
                Text(
                    text = stringResource(R.string.lemonadeTitle),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                        .padding(top = 40.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }

        var result by remember { mutableStateOf(1) }
        var aleatorio by remember { mutableStateOf(2) }
        val imagen = when (result){
            1-> R.drawable.lemon_tree
            2-> R.drawable.lemon_squeeze
            3-> R.drawable.lemon_drink
            else -> R.drawable.lemon_restart
        }
        val descripcionImagen = when (result){
            1-> R.string.lemon_tree
            2-> R.string.lemon_squeeze
            3-> R.string.glass_of_lemonade
            else -> R.string.empty_glass
        }
        val texto = when (result){
            1-> R.string.TapLemon
            2-> R.string.keep_tapping
            3-> R.string.tap_the_empty
            else -> R.string.tap_the_empty
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = imagen),
                contentDescription = stringResource(descripcionImagen),
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(137, 191, 224 ))
                    .clickable{
                        if(result == 1){aleatorio= (2..4).random();result++}
                        else if(result == 2){ aleatorio--; if(aleatorio==0){result++} }
                        else if(result==4){ result=1 }
                        else{ result++ }
                        }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = stringResource(texto))
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        Limonada()
    }
}