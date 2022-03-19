package com.example.broadcastrecieverapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyRegisteredByCodeBroadcastReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val data = intent?.extras?.getString("data");
        Toast.makeText(context, "Broadcast from code Received with data " + data, Toast.LENGTH_LONG).show();
    }


}