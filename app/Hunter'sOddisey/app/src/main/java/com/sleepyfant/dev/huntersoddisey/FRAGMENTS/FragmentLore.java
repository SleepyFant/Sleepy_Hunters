package com.sleepyfant.dev.huntersoddisey.FRAGMENTS;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.sleepyfant.dev.huntersoddisey.R;
import com.victor.loading.book.BookLoading;

public class FragmentLore extends Fragment {

    public FragmentLore() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        getActivity().getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        Typeface myTypeface = Typeface.createFromAsset(getActivity().getAssets(), "marathon.ttf");
        final View v = inflater.inflate(R.layout.fragment_fragment_lore, container, false);
        TextView tv = (TextView) v.findViewById(R.id.hunterTitle);
        tv.setTypeface(myTypeface);

        Dialog dialog = new Dialog(getActivity()); //context fragment
        dialog.setContentView(R.layout.dialoglore);
        dialog.setTitle("Loading");
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        BookLoading load = (BookLoading) dialog.findViewById(R.id.bookloading);
        TextView text = (TextView) dialog.findViewById(R.id.scrolls);
        text.setTypeface(myTypeface);
        load.start();
        dialog.show();

        return v;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }

}
