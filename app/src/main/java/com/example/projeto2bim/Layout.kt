package com.example.projeto2bim

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import com.google.android.gms.common.wrappers.Wrappers.packageManager


class Layout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val minhaVariavel = intent.getStringExtra("comidafav")

        val btn1: Button = findViewById(R.id.btndesadi)
        val btn3: Button = findViewById(R.id.btnnotify)
        val comidafav = intent.getStringExtra("comi")

        if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                    101
                )

            }
        }

        btn1.setOnClickListener {
            val intent = Intent(this, Desafidiario::class.java)
            intent.putExtra("comi", minhaVariavel)
            startActivity(intent)
        }

        btn3.setOnClickListener {
            makeNotificacao()
        }

    }

    fun makeNotificacao() {
        val channelId = "CHANNEL_ID_NOTIFICATION"
        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_notifications)
            .setContentTitle("Faz logo!!!")
            .setContentText("Vai fazer logo o desafio")
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val intent = Intent(this, Notifi::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("data", "Vai fazer logo o desafio")

        val pendingIntent = PendingIntent.getActivity(
            applicationContext,
            0,
            intent,
            PendingIntent.FLAG_MUTABLE
        )
        builder.setContentIntent(pendingIntent)

        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val notificationChannel: NotificationChannel? =
                notificationManager.getNotificationChannel(channelId)
            if (notificationChannel == null) {
                val importance = NotificationManager.IMPORTANCE_HIGH
                val newNotificationChannel =
                    NotificationChannel(channelId, "alguma descrição", importance)
                newNotificationChannel.lightColor = Color.GREEN
                newNotificationChannel.enableVibration(true)
                notificationManager.createNotificationChannel(newNotificationChannel)
            }
        }
        notificationManager.notify(0, builder.build())
    }
}
