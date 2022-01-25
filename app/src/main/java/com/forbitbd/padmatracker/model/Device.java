package com.forbitbd.padmatracker.model;

import java.io.Serializable;

/**
 * Created by sohel on 5/20/2018.
 */

public class Device implements Serializable {

    private String driver_name;
    private String driver_phone;
    private int driver_photo;
    private String registration_number;
    private String vehicle_type;
    private String device_sim_number;
    private String mileage;


    public Device(String driver_name, String driver_phone, int driver_photo, String registration_number, String vehicle_type, String device_sim_number, String mileage) {
        this.driver_name = driver_name;
        this.driver_phone = driver_phone;
        this.driver_photo = driver_photo;
        this.registration_number = registration_number;
        this.vehicle_type = vehicle_type;
        this.device_sim_number = device_sim_number;
        this.mileage = mileage;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getDriver_phone() {
        return driver_phone;
    }

    public void setDriver_phone(String driver_phone) {
        this.driver_phone = driver_phone;
    }

    public int getDriver_photo() {
        return driver_photo;
    }

    public void setDriver_photo(int driver_photo) {
        this.driver_photo = driver_photo;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getDevice_sim_number() {
        return device_sim_number;
    }

    public void setDevice_sim_number(String device_sim_number) {
        this.device_sim_number = device_sim_number;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }
}
