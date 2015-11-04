package com.sleepyfant.dev.huntersoddisey.MANAGERS;

import android.content.Context;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.body.JSONObjectBody;
import com.koushikdutta.ion.Ion;
import com.sleepyfant.dev.huntersoddisey.EVENTS.NewsRecievedEvent;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by usuari on 10/10/2015.
 */
public class APIManager {
    public static List<String> demodata = new  ArrayList();
    public static void getNews(Context context)
    {
        Ion.with(context)
                .load("http://jsonplaceholder.typicode.com/posts")
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        // do stuff with the result or error
                        if(result == null)
                        {
                            EventBus.getDefault().post(new NewsRecievedEvent(demodata));
                            return;
                        }
                        for(int i = 0; i < result.size(); i++)
                        {
                            Log.i("JSON",result.get(0).toString());
                            try {
                                JSONObject o = new JSONObject(result.get(0).toString());
                                demodata.add(o.getString("title"));
                            } catch (JSONException e1) {
                                e1.printStackTrace();
                            }
                        }
                        EventBus.getDefault().post(new NewsRecievedEvent(demodata));
                    }
                });

    }
}
