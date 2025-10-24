package com.example.gamerzone.views

import android.Manifest
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

class VibracionScreen(private val navController: NavController? = null) {

    @Composable
    fun vibracion(){
        val context = LocalContext.current

        @RequiresPermission(Manifest.permission.VIBRATE)
            @RequiresApi(Build.VERSION_CODES.O)
            fun vibrar(){
                val vibrador = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

                if (vibrador.hasVibrator()){
                    vibrador.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
                }
            }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Button(onClick = {vibrar()}){
                Text(text= "Vibrar")
            }
        }
    }
}