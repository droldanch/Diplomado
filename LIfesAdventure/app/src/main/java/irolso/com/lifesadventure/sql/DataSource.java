package irolso.com.lifesadventure.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import irolso.com.lifesadventure.model.ViajeGuardado;

/**
 * Created by Roldan on 06/02/17.
 */

public class DataSource {

    private final SQLiteDatabase db;

    public DataSource(Context context) {
        DatosHelper helper = new DatosHelper(context);
        db=helper.getWritableDatabase();
    }

    public void saveTravels(ViajeGuardado modelItem)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatosHelper.ColumnItem.name,modelItem.getName());
        contentValues.put(DatosHelper.ColumnItem.observations,modelItem.getObservations());
        contentValues.put(DatosHelper.ColumnItem.placeTimeDeparture,modelItem.getPlaceTime());
        contentValues.put(DatosHelper.ColumnItem.placeToVisit,modelItem.getplaceToVisit());
        contentValues.put(DatosHelper.ColumnItem.price,modelItem.getPrice());
        contentValues.put(DatosHelper.ColumnItem.starDate,modelItem.getStartDate());
        contentValues.put(DatosHelper.ColumnItem.endDate,modelItem.getEndDate());
        contentValues.put(DatosHelper.ColumnItem.pictures,modelItem.getPicture());
        contentValues.put(DatosHelper.ColumnItem.travelDetails,modelItem.getDetalles());

        db.insert(DatosHelper.TABLE_TRAVELS,null,contentValues);
    }

    public ViajeGuardado getFavoritos()
    {
        ViajeGuardado modelItem = new ViajeGuardado();
        Cursor cursor =db.query(DatosHelper.TABLE_TRAVELS,null,null,null,null,null,null);
        while (cursor.moveToNext())
        {

            String name =cursor.getString(cursor.getColumnIndexOrThrow(DatosHelper.ColumnItem.name));
            String observations =cursor.getString(cursor.getColumnIndexOrThrow(DatosHelper.ColumnItem.observations));
            String placeTimeDeparture =cursor.getString(cursor.getColumnIndexOrThrow(DatosHelper.ColumnItem.placeTimeDeparture));
            String placeToVisit =cursor.getString(cursor.getColumnIndexOrThrow(DatosHelper.ColumnItem.placeToVisit));
            String price =cursor.getString(cursor.getColumnIndexOrThrow(DatosHelper.ColumnItem.price));
            String starDate =cursor.getString(cursor.getColumnIndexOrThrow(DatosHelper.ColumnItem.starDate));
            String endDate =cursor.getString(cursor.getColumnIndexOrThrow(DatosHelper.ColumnItem.endDate));
            String pictures =cursor.getString(cursor.getColumnIndexOrThrow(DatosHelper.ColumnItem.pictures));
            String travelDetails =cursor.getString(cursor.getColumnIndexOrThrow(DatosHelper.ColumnItem.travelDetails));

            modelItem.setName(name);
            modelItem.setObservations(observations);
            modelItem.setPlaceTime(placeTimeDeparture);
            modelItem.setplaceToVisit(placeToVisit);
            modelItem.setPrice(price);
            modelItem.setStartDate(starDate);
            modelItem.setEndDate(endDate);
            modelItem.setPicture(pictures);
            modelItem.setDetalles(travelDetails);
        }

        return modelItem;
    }

    public void deleteFavoritos(){
        db.delete(DatosHelper.TABLE_TRAVELS,null,null);
    }

}
