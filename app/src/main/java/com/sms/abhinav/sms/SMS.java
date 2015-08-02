package com.sms.abhinav.sms;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Vibrator;
import android.provider.Telephony;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.net.ContentHandler;


public class SMS extends ActionBarActivity {
    Button send;
    EditText enter;
    LinearLayout container;
    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        send=(Button) findViewById(R.id.send);
        enter=(EditText) findViewById(R.id.sms);
        number=(EditText) findViewById(R.id.num);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // LayoutInflater layinf = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                SmsManager sms = SmsManager.getDefault();
                NotificationManager mgr= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                String sendto = number.getText().toString();
                String sms2 = enter.getText().toString();
                sms.sendTextMessage(sendto, null, sms2, null, null);
                Notification noti = new Notification.Builder(getApplicationContext())
                        .setContentTitle("New mail from ")
                        .setContentText("like")
                        .setSmallIcon(0)
                        .setLargeIcon(null)
                        .build();

                try{
                    Vibrator vib=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vib.vibrate(2500);

                }catch (Exception e){
                    Log.d("mytag", e.toString());
                }


            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
