package com.example.hw_spr_boot_1.profile;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
