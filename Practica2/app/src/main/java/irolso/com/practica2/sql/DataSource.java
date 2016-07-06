package irolso.com.practica2.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import irolso.com.practica2.model.ModelListApp;

/**
 * Created by Roldan on 06/07/16.
 */
public class DataSource {
    private final SQLiteDatabase db;

    public DataSource(Context context) {
        MySqliteHelper helper = new MySqliteHelper(context);
        db=helper.getWritableDatabase();
    }
    public void saveItem(ModelListApp modelItem)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySqliteHelper.ColumnItem.NOMBRE,modelItem.Nombre);
        contentValues.put(MySqliteHelper.ColumnItem.DESARROLLADOR,modelItem.Desarrollador);
        contentValues.put(MySqliteHelper.ColumnItem.INSTALADA,modelItem.Instalada);
        contentValues.put(MySqliteHelper.ColumnItem.UPDATE,modelItem.Update);
        contentValues.put(MySqliteHelper.ColumnItem.DETALLE,modelItem.Detalle);
        contentValues.put(MySqliteHelper.ColumnItem.IMAGEN,modelItem.Imagen);
        db.insert(MySqliteHelper.TABLE_APP,null,contentValues);
    }

    public void deleteItem(ModelListApp modelItem)
    {
        db.delete(MySqliteHelper.TABLE_APP,MySqliteHelper.ColumnItem.ID+"=?",
                new String[]{String.valueOf(modelItem.ID)});
    }

    public List<ModelListApp> getAllItems()
    {
        List<ModelListApp> modelItemList = new ArrayList<>();
        Cursor cursor =db.query(MySqliteHelper.TABLE_APP,null,null,null,null,null,null);
        while (cursor.moveToNext())
        {
            int ID = cursor.getInt(cursor.getColumnIndexOrThrow(MySqliteHelper.ColumnItem.ID));
            String Nombre =cursor.getString(cursor.getColumnIndexOrThrow(MySqliteHelper.ColumnItem.NOMBRE));
            String Desarrollador = cursor.getString(cursor.getColumnIndexOrThrow(MySqliteHelper.ColumnItem.DESARROLLADOR));
            int Instalada = cursor.getInt(cursor.getColumnIndexOrThrow(MySqliteHelper.ColumnItem.INSTALADA));
            int Update = cursor.getInt(cursor.getColumnIndexOrThrow(MySqliteHelper.ColumnItem.UPDATE));
            String Detalle =cursor.getString(cursor.getColumnIndexOrThrow(MySqliteHelper.ColumnItem.DETALLE));
            int Imagen = cursor.getInt(cursor.getColumnIndexOrThrow(MySqliteHelper.ColumnItem.IMAGEN));
            ModelListApp modelItem = new ModelListApp();

            modelItem.ID=ID;
            modelItem.Nombre=Nombre;
            modelItem.Desarrollador=Desarrollador;
            modelItem.Instalada=Instalada;
            modelItem.Update=Update;
            modelItem.Detalle=Detalle;
            modelItem.Imagen= Imagen;
            modelItemList.add(modelItem);
        }

        return modelItemList;
    }

    public ModelListApp llenarDetalles(int id)
    {
        ModelListApp modelItem = new ModelListApp();
        Cursor cursor =db.query(MySqliteHelper.TABLE_APP,null,MySqliteHelper.ColumnItem.ID+"='"+id+"'",null,null,null,null);

        while (cursor.moveToNext())
        {

            int ID = cursor.getInt(cursor.getColumnIndexOrThrow(MySqliteHelper.ColumnItem.ID));
            String Nombre =cursor.getString(cursor.getColumnIndexOrThrow(MySqliteHelper.ColumnItem.NOMBRE));
            String Desarrollador = cursor.getString(cursor.getColumnIndexOrThrow(MySqliteHelper.ColumnItem.DESARROLLADOR));
            int Instalada = cursor.getInt(cursor.getColumnIndexOrThrow(MySqliteHelper.ColumnItem.INSTALADA));
            int Update = cursor.getInt(cursor.getColumnIndexOrThrow(MySqliteHelper.ColumnItem.UPDATE));
            String Detalle =cursor.getString(cursor.getColumnIndexOrThrow(MySqliteHelper.ColumnItem.DETALLE));

            modelItem.ID=ID;
            modelItem.Nombre=Nombre;
            modelItem.Desarrollador=Desarrollador;
            modelItem.Instalada=Instalada;
            modelItem.Update=Update;
            modelItem.Detalle=Detalle;;

        }

        return modelItem;
    }

    public int editarApp(ModelListApp modelItem)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySqliteHelper.ColumnItem.NOMBRE,modelItem.Nombre);
        contentValues.put(MySqliteHelper.ColumnItem.DESARROLLADOR,modelItem.Desarrollador);
        contentValues.put(MySqliteHelper.ColumnItem.INSTALADA,modelItem.Instalada);
        contentValues.put(MySqliteHelper.ColumnItem.UPDATE,modelItem.Update);
        contentValues.put(MySqliteHelper.ColumnItem.DETALLE,modelItem.Detalle);
        return db.update( MySqliteHelper.TABLE_APP, contentValues, MySqliteHelper.ColumnItem.ID + " = " + modelItem.ID,null);
    }
}