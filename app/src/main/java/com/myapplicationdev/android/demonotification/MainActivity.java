package com.myapplicationdev.android.demonotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int requestCode = 123;
    int notificationID = 888;
    Button btnNotify1, btnNotify2,btnNotify3,btnNotify4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNotify1 = findViewById(R.id.btnNotify1);
        btnNotify2 = findViewById(R.id.btnNotify2);
        btnNotify3 = findViewById(R.id.btnNotify3);
        btnNotify4 = findViewById(R.id.btnNotify4);
        btnNotify1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new
                            NotificationChannel("default", "Default Channel",
                            NotificationManager.IMPORTANCE_DEFAULT);

                    channel.setDescription("This is for default notification");
                    notificationManager.createNotificationChannel(channel);
                }
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity
                        ( MainActivity.this, requestCode, intent,
                                PendingIntent.FLAG_CANCEL_CURRENT);
                // Build notification
                NotificationCompat.Builder builder = new
                        NotificationCompat.Builder(MainActivity.this, "default");
                builder.setContentTitle("Amazing Offer!");
                builder.setContentText("Subject");
                builder.setSmallIcon(android.R.drawable.btn_star_big_off);
                builder.setContentIntent(pIntent);
                builder.setAutoCancel(true);
                Notification n = builder.build();

                // An integer good to have, for you to programmatically cancel it
                notificationManager.notify(notificationID, n);
                finish();
            }
        });

        btnNotify2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new
                            NotificationChannel("default", "Default Channel",
                            NotificationManager.IMPORTANCE_DEFAULT);

                    channel.setDescription("This is for default notification");
                    notificationManager.createNotificationChannel(channel);
                }

                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity
                        ( MainActivity.this, requestCode, intent,
                                PendingIntent.FLAG_CANCEL_CURRENT);
                NotificationCompat.BigTextStyle bigText = new
                        NotificationCompat.BigTextStyle();
                bigText.setBigContentTitle("Feeling Good Lyrics");
                bigText.bigText("Birds flying high, you know how I feel\\nSun in the sky, you know how I feel\\nReeds driftin' on by, you know how I feel\\nIt's a new dawn, it's a new day, it's a new life for me\\nYeah~\\nit's a new dawn, it's a new day, it's a new life for me\\nooooooooh...\\nAnd I'm feeling good\n");
                bigText.setSummaryText("I love Nina!");

                // Build notification
                NotificationCompat.Builder builder = new
                        NotificationCompat.Builder(MainActivity.this, "default");
                builder.setContentTitle("Feeling Good Lyrics");
                builder.setContentText("Birds flying high,you know how i feel...");
                builder.setSmallIcon(android.R.drawable.btn_star_big_off);
                builder.setContentIntent(pIntent);
                builder.setStyle(bigText);
                builder.setAutoCancel(true);
                Notification n = builder.build();

                // An integer good to have, for you to programmatically cancel it
                notificationManager.notify(notificationID, n);
                finish();
            }
        });
        btnNotify3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new
                            NotificationChannel("default", "Default Channel",
                            NotificationManager.IMPORTANCE_DEFAULT);
                    channel.setDescription("This is for default notification");
                    notificationManager.createNotificationChannel(channel);
                }
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity
                        ( MainActivity.this, requestCode, intent,
                                PendingIntent.FLAG_CANCEL_CURRENT);
                Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.sentosa);
                // Build notification
                NotificationCompat.Builder builder = new
                        NotificationCompat.Builder(MainActivity.this, "default");
                builder.setSmallIcon(android.R.drawable.btn_star_big_off);
                builder.setContentTitle("Welcome to Sentosa!");
                builder.setContentText("Singapore's premier island getaway");
                builder.setLargeIcon(picture);
                builder .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(picture)
                        .bigLargeIcon(null));
                builder.setContentIntent(pIntent);
                builder.setAutoCancel(true);
                Notification n = builder.build();

                // An integer good to have, for you to programmatically cancel it
                notificationManager.notify(notificationID, n);
                finish();

            }
        });
        btnNotify4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new
                            NotificationChannel("default", "Default Channel",
                            NotificationManager.IMPORTANCE_HIGH);
                    channel.setDescription("This is for default notification");
                    notificationManager.createNotificationChannel(channel);
                }
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity
                        ( MainActivity.this, requestCode, intent,
                                PendingIntent.FLAG_CANCEL_CURRENT);

                NotificationCompat.Builder builder = new
                        NotificationCompat.Builder(MainActivity.this, "default");
                builder.setSmallIcon(android.R.drawable.btn_star_big_off);
                NotificationCompat.BigTextStyle bigText = new
                        NotificationCompat.BigTextStyle();
                bigText.setBigContentTitle("Deals from top electronics retailers");
                bigText.setSummaryText("Excellent deals");
                builder.setContentTitle("Deals from top electronic retailers");
                builder .setStyle(new NotificationCompat.InboxStyle()
                       .addLine("Mobile 50% off").addLine("Laptop 20% off").addLine("Tablet 22% off").addLine("Printer 30% off").addLine("Other 10% off")).build();
                builder.setContentIntent(pIntent);
                builder.setAutoCancel(true);
                Notification n = builder.build();

                // An integer good to have, for you to programmatically cancel it
                notificationManager.notify(notificationID, n);
                finish();

            }
        });


    }
}
