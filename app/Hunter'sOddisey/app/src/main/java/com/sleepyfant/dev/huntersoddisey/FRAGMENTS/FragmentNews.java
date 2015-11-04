package com.sleepyfant.dev.huntersoddisey.FRAGMENTS;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;
import com.sleepyfant.dev.huntersoddisey.ADAPTERS.RVadapter;
import com.sleepyfant.dev.huntersoddisey.EVENTS.NewsRecievedEvent;
import com.sleepyfant.dev.huntersoddisey.MANAGERS.APIManager;
import com.sleepyfant.dev.huntersoddisey.R;

import java.lang.annotation.AnnotationTypeMismatchException;

import butterknife.Bind;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * Created by usuari on 24/10/2015.
 */
public class FragmentNews extends Fragment {
    RecyclerView rv;
    AnimatedCircleLoadingView animatedCircleLoadingView;
    public FragmentNews() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        rv.setVisibility(View.GONE);
        animatedCircleLoadingView.setVisibility(View.VISIBLE);
        animatedCircleLoadingView.startIndeterminate();
        APIManager.getNews(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.news_fragment, container, false);
        rv = (RecyclerView) v.findViewById(R.id.rv);
        animatedCircleLoadingView = (AnimatedCircleLoadingView) v.findViewById(R.id.circle_loading_view);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        return v;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void onEvent(NewsRecievedEvent e)
    {
        animatedCircleLoadingView.stopOk();
        animatedCircleLoadingView.setVisibility(View.GONE);
        rv.setVisibility(View.VISIBLE);
        RVadapter adapter = new RVadapter(e.getItems());
        rv.setAdapter(adapter);
    }
}
