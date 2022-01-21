package mexa.example.takeiteasy;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBroadCast extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        OpenReminder ob=new OpenReminder();

        Resources res = context.getResources();
        String msg=intent.getStringExtra("msg");

        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"notifyLemubit")
                .setSmallIcon(R.drawable.alarm).setContentTitle("Take It Easy")
                .setContentText("learn bfs")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager=NotificationManagerCompat.from(context);
        notificationManager.notify(200,builder.build());
    }

}
