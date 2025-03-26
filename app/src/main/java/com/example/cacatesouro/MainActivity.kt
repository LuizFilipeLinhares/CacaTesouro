package com.example.cacatesouro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cacatesouro.ui.theme.CacaTesouroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

                val navigationController = rememberNavController()
                NavHost(navController = navigationController,
                    startDestination = "/home",){
                    composable (route = "/home"){
                        //views
                        TelaHome(
                            nomeTela = "Home",
                            clickb1 = {navigationController.navigate(route = "/tela2")}
                        )
                    }
                    composable (route = "/tela2"){
                        //views
                        Tela2(
                            nomeTela = "tela2",
                            clickt = {navigationController.navigate("/tela3")} ,
                            clickt2 = {navigationController.navigate("/home")}
                        )
                    }
                    composable (route = "/tela3"){
                        //views
                        Tela3(
                            nomeTela = "tela3",
                            clickt3 = {navigationController.navigate("/tela2")},
                            clickt4 = {navigationController.navigate("/tela4")}
                        )
                    }
                    composable (route = "/tela4"){
                        //views
                        Tela4(
                            nomeTela = "tela4",
                            clickt5 = {navigationController.navigate("/telaend")},
                            clickt6 = {navigationController.navigate("/home")}
                        )

                    }
                    composable (route = "/telaend"){
                        //views
                        Telaend(
                            nomeTela = "telafim",
                            clickt7 = {navigationController.navigate("/home")}
                        )

                    }


                }

            }
        }

@Composable
fun TelaHome(
    nomeTela: String,
    clickb1: ()-> Unit
){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(nomeTela)
        Text("Seja bem vindo a caça ao tesouro!")
        Text("")

        Button(onClick = clickb1) { Text(text = "Iniciar caçada!") }
    }
}
@Composable
fun Tela2(
    nomeTela: String,
    clickt: ()-> Unit,
    clickt2: ()-> Unit,
){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(nomeTela)
        Text("Pergunta 1")
        Text("Eu sou pequeno e redondo, uso para jogar e sou chutado. Quem sou eu?")

        Button(onClick = clickt) { Text(text = "Uma bola") }
        Button(onClick = clickt2) { Text(text = "Uma bala") }
    }
}
@Composable
fun Tela3(
    nomeTela: String,
    clickt3: ()-> Unit,
    clickt4: ()-> Unit,
){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(nomeTela)
        Text("Pergunta 2")
        Text("Tenho asas, mas não sou avião. Pouso nas flores e trago polinização. Quem sou eu?")

        Button(onClick = clickt3) { Text(text = "Andorinha") }
        Button(onClick = clickt4) { Text(text = "Abelha") }
    }
}

@Composable
fun Tela4(
    nomeTela: String,
    clickt5: ()-> Unit,
    clickt6: ()-> Unit,
){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(nomeTela)
        Text("")
        Text("THE FINAL QUESTION")
        Text("")
        Text("Eu moro no céu e brilho à noite. Quem sou eu?")


        Button(onClick = clickt5) { Text(text = "Estrela") }
        Button(onClick = clickt6) { Text(text = "Satelite") }
    }
}
}
@Composable
fun Telaend(
    nomeTela: String,
    clickt7: ()-> Unit,
){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(nomeTela)
        Text("")
        Text("CONGRATS!")
        Text("")
        Text("VOCE VENCEU O QUIZ")


        Button(onClick = clickt7) { Text(text = "Voltar para a Home") }
    }
}
