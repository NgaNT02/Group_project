package vn.edu.usth.englishapp.notify;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.messaging.RemoteMessage;

import androidx.core.app.NotificationCompat;

import vn.edu.usth.englishapp.MainActivity;
import vn.edu.usth.englishapp.R;

import java.util.Calendar;

public class MyService extends Service {
    private static final long INTERVAL = 60 * 1000; // 1 phút
    private HandlerThread handlerThread;
    private Handler handler;
    private Runnable runnable;

    @Override
    public void onCreate() {
        super.onCreate();

        handlerThread = new HandlerThread("MyServiceThread");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
        runnable = new Runnable() {
            @Override
            public void run() {
//                handleSendMessage();
                handler.postDelayed(this, INTERVAL);
            }
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Bắt đầu tiến trình
        handler.post(runnable);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Dừng tiến trình khi service bị hủy
        handler.removeCallbacks(runnable);
        handlerThread.quit();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

//    private void handleSendMessage() {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        db.collection("users").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                for (DocumentSnapshot queryDocumentSnapshot : queryDocumentSnapshots.getDocuments()) {
//                    UserToken userToken = queryDocumentSnapshot.toObject(UserToken.class);
//                    Calendar calendar = Calendar.getInstance();
//                    System.out.println(userToken);
//                    int hour = calendar.get(Calendar.HOUR_OF_DAY);
//                    int minute = calendar.get(Calendar.MINUTE);
//                    if (userToken != null) {
//                        if (!userToken.isRegister()) {
//                            return;
//                        }
//                        int toMU = userToken.getHour() * 60 + userToken.getMinute();
//                        int toMN = hour * 60 + minute;
//                        if (toMN - toMU > 0.001 && toMN - toMU <= 1) {
//                            new SendMessageTask().execute(userToken.getFcmToken(), "Thông báo nhắc nhở", "Đã đến giờ học bài kính mời bạn vào học giúp tôi cái!!!");
//                        }
//                    }
//                }
//            }
//        });
//    }

    // Tạo một RemoteMessage giả lập
    private RemoteMessage createDummyRemoteMessage() {
        RemoteMessage.Builder builder = new RemoteMessage.Builder("dummy_from");
        builder.addData("title", "Thông báo nhắc nhở");
        builder.addData("message", "Đến giờ học bài rồi hãy vào đi bạn ơi!!!");
        return builder.build();
    }

    // Xử lý thông báo nhận được
    private void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("Notify", "From: " + remoteMessage.getFrom());

        if (remoteMessage.getData().size() > 0) {
            Log.d("Notify", "Message data payload: " + remoteMessage.getData());



            sendNotification("Thông báo nhắc nhở", "Đến giờ học bài rồi hãy vào đi bạn ơi!!!");
        }
    }

    // Gửi thông báo nhắc nhở
    private void sendNotification(String title, String messageBody) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_IMMUTABLE);

        String channelId = "fcm_default_channel";
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(title)
                        .setContentText(messageBody)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
}