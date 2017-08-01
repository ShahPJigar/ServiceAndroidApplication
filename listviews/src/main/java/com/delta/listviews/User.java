package com.delta.listviews;

public class User {

    public String mNameOfUser;
    public String mEmail;
    public String mPhone;
    public String mAddress;
    public String mNameOfImage;
    public String mPopup;

    public User (String startNameOfUser, String StartEmail, String startPhone, String startAddress,String startNameOfImage, String startPopup ){

        this.mNameOfUser = startNameOfUser;
        this.mEmail = StartEmail;
        this.mPhone = startPhone;
        this.mAddress = startAddress;
        this.mNameOfImage = startNameOfImage;
        this.mPopup = startPopup;

    }

}