package com.forbitbd.padmatracker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.padmatracker.R;
import com.forbitbd.padmatracker.model.Control;

import java.util.List;

public class ControlAdapter extends RecyclerView.Adapter<ControlAdapter.ControlHolder> {

    private Context context;
    private List<Control> controlList;

    public ControlAdapter(Context context, List<Control> controlList) {
        this.context = context;
        this.controlList = controlList;
    }

    @Override
    public ControlHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_control, parent, false);
        return new ControlHolder(view);
    }

    @Override
    public void onBindViewHolder( ControlAdapter.ControlHolder holder, int position) {
        Control control = controlList.get(position);
        holder.icon.setImageResource(control.getImage());
        holder.txt.setText(control.getTitle());
    }

    @Override
    public int getItemCount() {
        return controlList.size();
    }

    public class ControlHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView txt;

        public ControlHolder(View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.image);
            txt = itemView.findViewById(R.id.title);
        }

    }
}
