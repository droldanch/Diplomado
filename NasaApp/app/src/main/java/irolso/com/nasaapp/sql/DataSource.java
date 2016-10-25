package irolso.com.nasaapp.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import irolso.com.nasaapp.model.PhotoBD;

/**
 * Created by Roldan on 06/09/16.
 */
public class DataSource{

    private final SQLiteDatabase db;

    public DataSource(Context context) {
        DatosHelper helper = new DatosHelper(context);
        db=helper.getWritableDatabase();
    }

    public void saveFavoritos(PhotoBD modelItem)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatosHelper.ColumnItem.Imagen,modelItem.Imagen);
        contentValues.put(DatosHelper.ColumnItem.Contenido,modelItem.Contenido);
        contentValues.put(DatosHelper.ColumnItem.Titulo,modelItem.Titulo);
        contentValues.put(DatosHelper.ColumnItem.Fecha,modelItem.Fecha);

        db.insert(DatosHelper.TABLE_FAVORITOS,null,contentValues);
    }

    public List<PhotoBD> getFavoritos()
    {
        List<PhotoBD> modelItemList = new ArrayList<>();
        Cursor cursor =db.query(DatosHelper.TABLE_FAVORITOS,null,null,null,null,null,null);
        while (cursor.moveToNext())
        {

            String Imagen =cursor.getString(cursor.getColumnIndexOrThrow(DatosHelper.ColumnItem.Imagen));
            String Contenido =cursor.getString(cursor.getColumnIndexOrThrow(DatosHelper.ColumnItem.Contenido));
            String Titulo =cursor.getString(cursor.getColumnIndexOrThrow(DatosHelper.ColumnItem.Titulo));
            String Fecha =cursor.getString(cursor.getColumnIndexOrThrow(DatosHelper.ColumnItem.Fecha));

            PhotoBD modelItem = new PhotoBD();

            modelItem.Imagen=Imagen;
            modelItem.Contenido=Contenido;
            modelItem.Titulo=Titulo;
            modelItem.Fecha=Fecha;
            modelItemList.add(modelItem);
        }

        return modelItemList;
    }

    public void deleteFavoritos(){
        db.delete(DatosHelper.TABLE_FAVORITOS,null,null);
    }

}
