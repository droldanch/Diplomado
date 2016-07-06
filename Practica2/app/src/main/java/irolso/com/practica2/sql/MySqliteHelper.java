package irolso.com.practica2.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Roldan on 06/07/16.
 */
public class MySqliteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ejercicio";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_APP = "App";
;
    //Campos de la tabla
    public static class ColumnItem{
        //Gastos
        public static final String ID = "ID";
        public static final String NOMBRE = "nombre";
        public static final String DESARROLLADOR = "desarrollador";
        public static final String INSTALADA = "instalada";
        public static final String UPDATE = "subir";
        public static final String DETALLE = "detalle";

    }


    //Script de Creación de la tabla Quotes
    public static final String CREATE_TABLE_APP =
            "create table "+TABLE_APP+"(" +
                    ColumnItem.ID+" integer primary key autoincrement,              "+
                    ColumnItem.NOMBRE +" varchar(50),         "+
                    ColumnItem.DESARROLLADOR  +" varchar(50), "+
                    ColumnItem.INSTALADA  +" integer,         "+
                    ColumnItem.UPDATE +" integer,             "+
                    ColumnItem.DETALLE +" varchar(50))        ";

    public MySqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override public void onCreate(SQLiteDatabase db) {
        //Se crea la Base de Datos
        db.execSQL(CREATE_TABLE_APP);
    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
