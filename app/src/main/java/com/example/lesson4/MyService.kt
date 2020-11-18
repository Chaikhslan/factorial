package com.example.lesson4

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyService : IntentService("MyService") {

    companion object {
        const val MY_CUSTOM_ACTION = "MY_CUSTOM_ACTION"
    }

    override fun onHandleIntent(intent: Intent?) {
        val name = intent?.getStringExtra("name").orEmpty()
        Log.d("MyService", "intent: $name")
        Thread.sleep(3000)
        val intent = Intent(MY_CUSTOM_ACTION)
        // либо
        // intent.action = MY_CUSTOM_ACTION
        intent.putExtra("key", "value sent from service")
        sendBroadcast(intent)
        stopSelf()
    }
}