package com.example.apollopharmacy;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMessagingService";

    @Override
    public void onNewToken(String newToken) {
        Log.e("TAG", "Refreshed token : " + newToken);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "From: " + remoteMessage.getFrom());

        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload:" + remoteMessage.getData());

            if (remoteMessage.getNotification() != null) {
                Log.d(TAG, "Message Notification body :" + remoteMessage.getNotification().getBody());
            }


        }

    }
}