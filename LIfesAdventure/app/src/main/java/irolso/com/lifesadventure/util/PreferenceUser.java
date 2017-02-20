package irolso.com.lifesadventure.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import irolso.com.lifesadventure.body.Register;

/**
 * Created by Roldan on 04/07/16.
 */

public class PreferenceUser {
    private static final String FILE_NAME ="user_pref";
    private final SharedPreferences sp;
    Context context;

    public PreferenceUser(Context context)
    {
        sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public void saveUser(Register modelUser)
    {
        //TODO validar si modelUser==null
        sp.edit().putString("nombre",modelUser.getName()).apply();
        sp.edit().putString("apellidoP",modelUser.getPaternalSurname()).apply();
        sp.edit().putString("apellidoM",modelUser.getMaternalSurname()).apply();
        sp.edit().putString("email",modelUser.getUsername()).apply();
    }
    public Register getUser()
    {
        String mUser=sp.getString("nombre",null);
        String mApellidoP=sp.getString("apellidoP",null);
        String mApellidoM=sp.getString("apellidoM",null);
        String mEmail=sp.getString("email",null);
        if(TextUtils.isEmpty(mUser) || TextUtils.isEmpty(mApellidoP)|| TextUtils.isEmpty(mApellidoM) || TextUtils.isEmpty(mEmail))
            return null;
        return new Register(mUser,mApellidoP,mApellidoM,mEmail);
    }

    public void clearUser()
    {
    }


}