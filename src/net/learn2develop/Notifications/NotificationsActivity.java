package net.learn2develop.Notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NotificationsActivity extends Activity {
    int notificationID = 1;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void onClick(View view) {
        displayNotification();
    }
    
    public void onClickTest(View view){
    	displayTest();
    }
    
    private void displayTest() {
    	Intent i = new Intent(this, NotiTest.class);
        i.putExtra("notificationID", notificationID);
		
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, i, 0);

            NotificationManager nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE); 

            Notification notif = new Notification(
                R.drawable.ic_launcher, 
                "Reminder: Meeting starts in 5 minutes",
                System.currentTimeMillis());

            CharSequence from = "System Alarm";
            CharSequence message = "Meeting with customer at 3pm...";
            
            notif.setLatestEventInfo(this, from, message, pendingIntent);

            //---100ms delay, vibrate for 250ms, pause for 100 ms and
            // then vibrate for 500ms---
            notif.vibrate = new long[] { 100, 250, 100, 500};
            nm.notify(notificationID, notif);   
	}

	protected void displayNotification()
    {
        //---PendingIntent to launch activity if the user selects
        // this notification---
//        Intent i = new Intent(this, NotificationView.class);
//        i.putExtra("notificationID", notificationID);
//
//        PendingIntent pendingIntent =
//            PendingIntent.getActivity(this, 0, i, 0);
//
//        NotificationManager nm = (NotificationManager)
//            getSystemService(NOTIFICATION_SERVICE); 
//
//        Notification notif = new Notification(
//            R.drawable.ic_launcher, 
//            "Reminder: Meeting starts in 5 minutes",
//            System.currentTimeMillis());
//
//        CharSequence from = "System Alarm";
//        CharSequence message = "Meeting with customer at 3pm...";
//        
//        notif.setLatestEventInfo(this, from, message, pendingIntent);
//
//        //---100ms delay, vibrate for 250ms, pause for 100 ms and
//        // then vibrate for 500ms---
//        notif.vibrate = new long[] { 100, 250, 100, 500};
//        nm.notify(notificationID, notif);        
    }

}