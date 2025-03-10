package com.example.myapplication

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class MyNotificationListenerService : NotificationListenerService() {

    companion object {
        private const val TAG = "MyNotifListener"
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        // 외부 앱에서 알림이 게시되었을 때 호출됩니다.
        val packageName = sbn.packageName
        val extras = sbn.notification.extras
        val notificationTitle = extras.getCharSequence("android.title")?.toString() ?: "제목 없음"
        val notificationText = extras.getCharSequence("android.text")?.toString() ?: "내용 없음"

        Log.i(TAG, extras.toString())
        Log.i(TAG, "알림 수신됨: $packageName")
        Log.i(TAG, "제목: $notificationTitle")
        Log.i(TAG, "내용: $notificationText")
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) {
        // 알림이 제거되었을 때 호출됩니다.
        Log.i(TAG, "알림 제거됨: ${sbn.packageName}")
    }


}
