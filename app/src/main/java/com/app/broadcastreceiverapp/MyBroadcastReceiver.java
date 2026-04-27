package com.app.broadcastreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (action == null) return;

        switch (action) {
            case "com.app.broadcastTraining.MY_BROADCAST":
                showLogAndToast(context, "Broadcast Diterima!");
                break;

            case Intent.ACTION_BATTERY_LOW:
                showLogAndToast(context, "Peringatan: Baterai Anda Lemah!");
                break;

            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
                if (isAirplaneModeOn) {
                    showLogAndToast(context, "Mode Pesawat Aktif");
                } else {
                    showLogAndToast(context, "Mode Pesawat Nonaktif");
                }
                break;
        }
    }

    private void showLogAndToast(Context context, String message) {
        Log.i("BroadcastReceiver", message);
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}