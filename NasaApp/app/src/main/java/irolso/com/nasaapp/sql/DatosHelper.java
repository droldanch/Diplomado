package irolso.com.nasaapp.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Roldan on 06/09/16.
 */
public class DatosHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "dbNasa";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_FAVORITOS = "Favoritos";

    public static class ColumnItem {
        //Catgorias
        public static final String ID = "ID";
        public static final String Imagen = "Nombre";
        public static final String Contenido = "Contenido";
        public static final String Titulo = "Titulo";
        public static final String Fecha = "Fecha";
    }


    public static final String CREATE_TABLE_FAVORITOS =
            "CREATE TABLE "+TABLE_FAVORITOS+"("+ColumnItem.ID+   " integer primary key autoincrement,"+
                    ColumnItem.Imagen+" varchar(100),"+
                    ColumnItem.Contenido+ " varchar(50),"+
                    ColumnItem.Titulo+ " varchar(20),"+
                    ColumnItem.Fecha+ " varchar(20))";


    public DatosHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_FAVORITOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}