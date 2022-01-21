package mexa.example.takeiteasy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OpenReminder extends AppCompatActivity {
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String s1="";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_reminder);
        createNotificationChannel();
        Button button=findViewById(R.id.buttonreminder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Reminder Set",
                        Toast.LENGTH_LONG)
                        .show();
                Intent intent=new Intent(OpenReminder.this,ReminderBroadCast.class);
                PendingIntent pendingIntent=PendingIntent.getBroadcast(OpenReminder.this,0,intent,0);
                AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
                long timeAtButtonClick=System.currentTimeMillis();
                EditText daysEdittext= (EditText)findViewById(R.id.days);
                EditText hoursEdittext= (EditText)findViewById(R.id.hours);
                EditText minutesEdittext= (EditText)findViewById(R.id.minutes);
                EditText secondsEdittext= (EditText)findViewById(R.id.seconds);
                EditText task= (EditText)findViewById(R.id.task);
                String text1=daysEdittext.getText().toString();
                String text2=hoursEdittext.getText().toString();
                String text3=minutesEdittext.getText().toString();
                String text4=secondsEdittext.getText().toString();
                String text5=task.getText().toString();
                intent.putExtra("msg",text5);
                stringPathao(text5);
                long res1=Integer.parseInt(text1);
                res1=res1*86400*1000;
                long res2=Integer.parseInt(text2);
                res2=res2*3600*1000;
                long res3=Integer.parseInt(text3);
                res3=res3*60*1000;
                long res4=Integer.parseInt(text4);
                res4=res4*1000;
                long tenSecondsInMillis=res1+res2+res3+res4;
                alarmManager.set(AlarmManager.RTC_WAKEUP,timeAtButtonClick+tenSecondsInMillis,pendingIntent);
            }
        });
    }
    public String stringPathao(String s){
        s1 = String.valueOf(s);
        return s1;
    }
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name="LemubitReminderChannel";
            String description="Channel for Lemubit Reminder";
            int importance= NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel=new NotificationChannel("notifyLemubit",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}