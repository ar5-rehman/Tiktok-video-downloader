package codestudioapps.tiktokvideo.testtiktokvideodownloader.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import codestudioapps.tiktokvideo.testtiktokvideodownloader.utils.Constants;

public class Restarter extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Broadcast Listened", "Service tried to stop");
        Toast.makeText(context, "Service restarted", Toast.LENGTH_SHORT).show();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(new Intent(context, ClipboardMonitor.class).setAction(Constants.STARTFOREGROUND_ACTION));
        } else {
            context.startService(new Intent(context, ClipboardMonitor.class));
        }
    }
}