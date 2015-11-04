package com.sleepyfant.dev.huntersoddisey.ADAPTERS;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sleepyfant.dev.huntersoddisey.R;

import java.util.List;

/**
 * Created by usuari on 10/10/2015.
 */
public class RVadapter extends RecyclerView.Adapter<RVadapter.PersonViewHolder>{
    List<String> items;
    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext()).inflate(R.layout.card, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }
    public RVadapter(List<String> persons){
        this.items = persons;
    }
    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.title.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView title;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            title = (TextView)itemView.findViewById(R.id.tvName);
        }
    }

}
