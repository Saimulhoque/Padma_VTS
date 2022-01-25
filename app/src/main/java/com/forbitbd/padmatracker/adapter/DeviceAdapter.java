package com.forbitbd.padmatracker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.padmatracker.R;
import com.forbitbd.padmatracker.model.Device;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ramotion.foldingcell.FoldingCell;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.DeviceHolder> {

    private Context context;
    private List<Device> deviceList;

    public DeviceAdapter(Context context, List<Device> deviceList) {
        this.context = context;
        this.deviceList = deviceList;
    }

    @Override
    public DeviceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_device, parent, false);
        return new DeviceHolder(view);
    }

    @Override
    public void onBindViewHolder(DeviceAdapter.DeviceHolder holder, int position) {
        Device device = deviceList.get(position);
        holder.bind(device);
    }

    @Override
    public int getItemCount() {
        return deviceList.size();
    }

    public class DeviceHolder extends RecyclerView.ViewHolder {

        private FoldingCell mFoldingCell;
        private ImageView ivIndicator;
        private TextView tvDriverName,tvDriverPhone,tvModel
                ,tvVehicleType,getTvVehicleTypeTwo,tvLocation,tvRegistrationNumber,tvMilage;
        private CircleImageView driverImage;


        public DeviceHolder(View itemView) {
            super(itemView);

            mFoldingCell = itemView.findViewById(R.id.folding_cell);

            driverImage = itemView.findViewById(R.id.driver_image);

            tvDriverName = itemView.findViewById(R.id.driver_name);
            tvDriverPhone = itemView.findViewById(R.id.driver_phone_txt);
            tvModel = itemView.findViewById(R.id.reg_number);
            tvRegistrationNumber = itemView.findViewById(R.id.registration_number);
            tvVehicleType = itemView.findViewById(R.id.vehicle_type);
            getTvVehicleTypeTwo = itemView.findViewById(R.id.vehicle_type_two);
            tvLocation = itemView.findViewById(R.id.current_location);
            tvMilage = itemView.findViewById(R.id.mileage);

            ivIndicator =  itemView.findViewById(R.id.indicator);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mFoldingCell.toggle(false);

                }
            });
        }

        public void bind(Device device) {

            driverImage.setImageResource(device.getDriver_photo());
            tvDriverName.setText(device.getDriver_name());
            tvDriverPhone.setText(device.getDriver_phone());
            tvModel.setText(device.getRegistration_number());
            tvRegistrationNumber.setText(device.getRegistration_number());
            tvVehicleType.setText(device.getVehicle_type());
            getTvVehicleTypeTwo.setText(device.getVehicle_type());
            tvMilage.setText(device.getMileage());

        }
    }
}
