package irolso.com.ejercicio.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Roldan on 26/06/16.
 */
public class MysqliteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DataBase";
    private static final int DATABASE_VERSION = 1;
    public static final String ITEM_TABLE_NAME = "usuarios";

    //Campos de la tabla
    public static class ColumnItem{
        public static final String ID_ITEM = BaseColumns._ID;
        public static final String ITEM_NAME = "name";
        public static final String ITEM_PASS = "pass";
        public static final String ITEM_TIME = "time";
        public static final String ITEM_DATE = "date";
    }


    //Script de Creación de la tabla Quotes
    public static final String CREATE_TABLE_ITEM =
            "create table "+ITEM_TABLE_NAME+"(" +
                    ColumnItem.ID_ITEM+" integer primary key autoincrement," +
                    ColumnItem.ITEM_NAME+" text not null," +
                    ColumnItem.ITEM_PASS+" text not null," +
                    ColumnItem.ITEM_TIME+" INTEGER not null," +
                    ColumnItem.ITEM_DATE+" text not null )";

    public MysqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override public void onCreate(SQLiteDatabase db) {
        //Se crea la Base de Datos
        db.execSQL(CREATE_TABLE_ITEM);

    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
