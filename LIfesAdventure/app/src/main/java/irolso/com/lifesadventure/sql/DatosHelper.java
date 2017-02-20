package irolso.com.lifesadventure.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Roldan on 06/02/17.
 */

public class DatosHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dbNasa";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_TRAVELS = "travels";

    public static class ColumnItem {
        //Catgorias
        public static final String ID = "ID";
        public static final String name = "name";
        public static final String observations = "observations";
        public static final String placeTimeDeparture = "placeTimeDeparture";
        public static final String placeToVisit = "placeToVisit";
        public static final String price = "price";
        public static final String starDate = "starDate";
        public static final String endDate = "endDate";
        public static final String pictures = "picture";
        public static final String travelDetails = "travelDetails";

    }


    public static final String CREATE_TABLE_TRAVELS =
            "CREATE TABLE "+TABLE_TRAVELS+"("+ColumnItem.ID+   " integer primary key autoincrement,"+
                    ColumnItem.name+" varchar(100),"+
                    ColumnItem.observations+ " varchar(100),"+
                    ColumnItem.placeTimeDeparture+ " varchar(50),"+
                    ColumnItem.placeToVisit+ " varchar(50),"+
                    ColumnItem.price+ " varchar(10),"+
                    ColumnItem.starDate+ " varchar(15),"+
                    ColumnItem.endDate+ " varchar(15),"+
                    ColumnItem.pictures+ " varchar(50),"+
                    ColumnItem.travelDetails+ " varchar(30))";


    public DatosHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TRAVELS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
