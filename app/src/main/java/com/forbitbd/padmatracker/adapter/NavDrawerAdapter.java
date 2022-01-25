package com.forbitbd.padmatracker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.padmatracker.R;

public class NavDrawerAdapter extends RecyclerView.Adapter<NavDrawerAdapter.NavHolder> {

    private Context context;
    private String[] icons;
    private String[] names;

    public NavDrawerAdapter(Context context, String[] icons, String[] names) {
        this.context = context;
        this.icons = icons;
        this.names = names;
    }

    @Override
    public NavHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.nav_item, parent, false);
        return new NavHolder(view);
    }

    @Override
    public void onBindViewHolder( NavDrawerAdapter.NavHolder holder, int position) {
//        String icon = icons[i];
//        String name = names[i];

//        holder.bind(icon,name);
    }

    @Override
    public int getItemCount() {
        return icons.length;
    }

    public class NavHolder extends RecyclerView.ViewHolder {


        public NavHolder(View itemView) {
            super(itemView);

        }

        public void bind(String icon, String name) {

        }
    }
}
