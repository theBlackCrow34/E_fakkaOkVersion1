package com.example.sherif.e_fakkaokversion1.Storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.sherif.e_fakkaokversion1.Models.Branch;
import com.example.sherif.e_fakkaokversion1.Models.User;
import com.example.sherif.e_fakkaokversion1.Models.Vendor;


public class SharedPreferancesManager {

    public static final String SHARED_PREFER_NAME = "Profile";
    private static  SharedPreferancesManager instance;
    private Context context;

    private SharedPreferancesManager(Context con)
    {
        this.context = con;
    }

    public  static synchronized SharedPreferancesManager getInstance(Context con)
    {
        if(instance == null)
        {
            instance = new SharedPreferancesManager(con);
        }

        return instance;
    }

    public void SaveUser(User user)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFER_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("id",user.getId());
        editor.putString("name",user.getId());
        editor.putString("phone",user.getId());
        editor.putString("mail",user.getId());
        editor.putString("username",user.getId());
        editor.putString("password",user.getId());
        editor.putString("created_by",user.getId());
        editor.putString("act_code",user.getId());
        editor.putString("date",user.getId());
        editor.putBoolean("activited",user.isActivited());
        editor.putBoolean("blocked",user.isBlocked());
        editor.putFloat("free", (float) user.getFree());
        editor.putFloat("points", (float) user.getPoints());

        editor.apply();
    }

    public void SaveBranch(Branch branch){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFER_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("isRegistered",true);
        editor.putString("type","Branch");
        editor.putString("id",branch.getId());
        editor.putString("name",branch.getName());
        editor.putString("phone",branch.getPhone());
        editor.putString("address",branch.getAddress());
        editor.putString("username",branch.getUsername());
        editor.putString("password",branch.getPassword());
        editor.putString("company_id",branch.getCompany_id());
        editor.putBoolean("blocked",branch.isBlocked());
        editor.putFloat("points", (float) branch.getPoints());

        editor.apply();
    }
    public void SaveVendor(Vendor vendor){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFER_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("isRegistered",true);
        editor.putString("type","Vendor");
        editor.putString("id",vendor.getId());
        editor.putString("name",vendor.getName());
        editor.putString("phone",vendor.getPhone());
        editor.putString("username",vendor.getUsername());
        editor.putString("passsword",vendor.getPassword());
        editor.putString("indastry",vendor.getIndastry());
        editor.putString("contacts",vendor.getContacts());
        editor.putBoolean("activited",vendor.isActivited());
        editor.putFloat("points", (float) vendor.getPoints());

        editor.apply();
    }

    public void logOut()
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFER_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putBoolean("isRegistered",false);
        editor.apply();
    }




}
