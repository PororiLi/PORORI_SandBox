package com.soen.listtest;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageButton;

public class ListItem {
    private String item_ssid;
    private ImageButton moreinf;
    private ImageButton ap_connect;
    private Drawable ap_state;

    public void setAp_state(Drawable ap_icon){
        ap_state = ap_icon;
    }

    public void setItem_ssid(String ssid){
        item_ssid = ssid;
    }
    //public void setMoreinf()
    //public void setAp_connect()

    public String getItem_ssid(){
        return this.item_ssid;
    }
    public Drawable getAp_state(){
        return this.ap_state;
    }
//    public ImageButton getMoreinf(){
//        return this.moreinf;
//    }
//    public ImageButton getAp_connect(){
//        return this.ap_connect;
//    }

}
