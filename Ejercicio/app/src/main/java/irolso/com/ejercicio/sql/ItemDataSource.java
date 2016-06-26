package irolso.com.ejercicio.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import irolso.com.ejercicio.Model.Modelitem;

/**
 * Created by Roldan on 26/06/16.
 */
public class ItemDataSource {
    private MysqliteHelper openHelper;
    private SQLiteDatabase sqLiteDatabase;

    public ItemDataSource(Context context) {
        openHelper= new MysqliteHelper(context);
        sqLiteDatabase = openHelper.getWritableDatabase();
    }

    public void saveUser(String name,String pass,int time,String date)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MysqliteHelper.ColumnItem.ITEM_NAME,name);
        contentValues.put(MysqliteHelper.ColumnItem.ITEM_PASS,pass);
        contentValues.put(MysqliteHelper.ColumnItem.ITEM_TIME,time);
        contentValues.put(MysqliteHelper.ColumnItem.ITEM_DATE,date);

        sqLiteDatabase.insert(MysqliteHelper.ITEM_TABLE_NAME,null,contentValues);

    }

    public void saveTime(String time,String user)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MysqliteHelper.ColumnItem.ITEM_TIME,time);
        String[] args = new String[]{user};
        sqLiteDatabase.update(MysqliteHelper.ITEM_TABLE_NAME,contentValues,"name=?",args);
    }



    public boolean loginDB(String name,String pass) {

        boolean access;

        Cursor cursor = sqLiteDatabase.query(MysqliteHelper.ITEM_TABLE_NAME,
                null, "name='"+name+"' and pass='"+pass+"'", null, null, null, null);
        int cantidad = cursor.getCount();

        if (cantidad==1) {
            access = true;
        }else{
            access = false;
        }

        cursor.close();
        return access;
    }

    public int Time(String name) {

        int access = 0;
        Cursor cursor = sqLiteDatabase.query(MysqliteHelper.ITEM_TABLE_NAME, new String[] {"date"}, "name" + "='"+name+"'" , null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                access = cursor.getInt(0);
            } while (cursor.moveToNext());
        }



        return access;
    }

    public String Fecha(String name) {

        String access = "";
        Cursor cursor = sqLiteDatabase.query(MysqliteHelper.ITEM_TABLE_NAME, new String[] {"time"}, "name='"+name+"'" , null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                access = cursor.getString(0);

            } while (cursor.moveToNext());
        }



        return access;
    }


}
