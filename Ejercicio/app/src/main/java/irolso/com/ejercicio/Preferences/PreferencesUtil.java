package irolso.com.ejercicio.Preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import irolso.com.ejercicio.Model.Modelitem;

/**
 * Created by Roldan on 26/06/16.
 */
public class PreferencesUtil {

    private static final String PREFERENCE_NAME ="preference_data";
    private final SharedPreferences sp;

    public PreferencesUtil(Context context) {
        sp = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
    }
    public void saveUser(Modelitem modelitem)
    {
        sp.edit().putString("user",modelitem.name).apply();
        sp.edit().putString("pass",modelitem.pass).apply();
        sp.edit().putInt("time",modelitem.time).apply();
        sp.edit().putString("date",modelitem.date).apply();
    }


    public Modelitem getUser()
    {
        String user = sp.getString("user",null);
        String pass = sp.getString("pass",null);
        int time = sp.getInt("time",0);
        String date = sp.getString("date",null);
        if(TextUtils.isEmpty(user) || TextUtils.isEmpty(user)  || TextUtils.isEmpty(date))
            return null;

        return new Modelitem(user,pass,time,date);
    }
}
