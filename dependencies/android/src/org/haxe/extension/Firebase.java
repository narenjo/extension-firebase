package org.haxe.extension;

import android.app.Activity;
import android.app.Application;
import android.content.res.AssetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

import org.haxe.extension.Extension;


public class Firebase extends Extension {

    static final String TAG = "FIREBASE-EXTENSION";

    private static Map<String, String> getPayloadFromJson(String jsonString) {
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        Map<String, String> payload = new Gson().fromJson(jsonString, type);
        return payload;
    }


    private static Bundle getFirebaseAnalyticsBundleFromJson(String jsonString) {
        Map<String, String> payloadMap = getPayloadFromJson(jsonString);

        Bundle payloadBundle = new Bundle();
        for (Map.Entry<String, String> entry : payloadMap.entrySet()) {
            payloadBundle.putString(entry.getKey(), entry.getValue());
        }

        return payloadBundle;
    }


    public static void sendFirebaseAnalyticsEvent(String eventName, String jsonPayload) {
        Log.d(TAG, "Firebase.java: sendFirebaseAnalyticsEvent name= " + eventName + ", payload= " + jsonPayload);

        Application mainApp = Extension.mainActivity.getApplication();
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mainApp);

        Bundle payloadBundle = getFirebaseAnalyticsBundleFromJson(jsonPayload);
        firebaseAnalytics.logEvent(eventName, payloadBundle);
    }

    public static String getInstanceIDToken() {
        String idToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Firebase.java: getInstanceIDToken= " + idToken);

        return idToken;
    }



    /**
     * Called when the activity is starting.
     */
    public void onCreate (Bundle savedInstanceState) {

        Log.d(TAG, "Firebase.java: onCreate ");

    }


        /**
         * Perform any final cleanup before an activity is destroyed.
         */
    public void onDestroy () {



    }


    /**
     * Called as part of the activity lifecycle when an activity is going into
     * the background, but has not (yet) been killed.
     */
    public void onPause () {



    }


    /**
     * Called after {@link #onStop} when the current activity is being
     * re-displayed to the user (the user has navigated back to it).
     */
    public void onRestart () {



    }


    /**
     * Called after {@link #onRestart}, or {@link #onPause}, for your activity
     * to start interacting with the user.
     */
    public void onResume () {



    }


    /**
     * Called after {@link #onCreate} &mdash; or after {@link #onRestart} when
     * the activity had been stopped, but is now again being displayed to the
     * user.
     */
    public void onStart () {

        Log.d(TAG, "Firebase.java: onStart ");

    }


    /**
     * Called when the activity is no longer visible to the user, because
     * another activity has been resumed and is covering this one.
     */
    public void onStop () {



    }

}