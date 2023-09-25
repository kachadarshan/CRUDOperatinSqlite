package com.yourbrandname.demosqlite_recyc.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.yourbrandname.demosqlite_recyc.Model.Datamodel;

import java.util.ArrayList;

public class MyDbhelper extends SQLiteOpenHelper {

    Context context;
    public static final String DATABASE_NAME = "DRecyc.DB";
    public static final int DATABASE_VERSION = 1;

    public static final String TABALE_NAME = "DRLibarary";
    public static final String KEY_ID = "Id";
    public static final String CLIENT_NAME = "Name";
    public static final String CLIENT_PHONEN = "Phone_number";

    public MyDbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(" CREATE TABLE " + TABALE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + CLIENT_NAME + " TEXT," + CLIENT_PHONEN + " TEXT" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABALE_NAME);
        onCreate(db);
    }

    public void AddUser(String name, String phoneno) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CLIENT_NAME, name);
        values.put(CLIENT_PHONEN, phoneno);

        long result = database.insert(TABALE_NAME, null, values);
        if (result == -1) {
            Toast.makeText(context, "Its Failed", Toast.LENGTH_SHORT).show();
        }

    }

    public ArrayList<Datamodel> getDatas() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABALE_NAME, null);

        ArrayList<Datamodel> getuserData = new ArrayList<>();
        while (cursor.moveToNext()) {
            getuserData.add(new Datamodel(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
        }
        cursor.close();
        return getuserData;
    }


    public void UpdateData(String id, String name, String phoneno) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, id);
        values.put(CLIENT_NAME, name);
        values.put(CLIENT_PHONEN, phoneno);

        long result = db.update(TABALE_NAME, values, "Id =?", new String[]{id});
        if (result == -1) {
            Toast.makeText(context, "Update Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, " Its Update", Toast.LENGTH_SHORT).show();

        }
    }


    public void DeletUserdata(String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.delete(TABALE_NAME, "Id =?", new String[]{id});
        if (result == -1) {
            Toast.makeText(context, "Failed TO delet", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Succesfully Delet", Toast.LENGTH_SHORT).show();
        }
    }
}
