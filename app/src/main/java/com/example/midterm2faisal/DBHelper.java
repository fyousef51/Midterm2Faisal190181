package com.example.midterm2faisal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {



    public static final String COLUMN_ID="ID";
    public static  final String TABLE_NAME="Person";
    public static final String COLUMN_NAME="Name";
    public static final String COLUMN_EMAIL="Email";
    public static final String COLUMN_PHONE="Phone";
    public static final String COLUMN_PERSONAL_ID="Personal_id";
    private static final String DATABASE_NAME="People.database";


    SQLiteDatabase database;
    public DBHelper(@Nullable Context context ) {
        super(context, DATABASE_NAME, null, 1);
        database =getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                        + "("+ COLUMN_ID + " INTEGER PRIMARY KEY ,"
                        + COLUMN_NAME + " TEXT NOT NULL,"
                        + COLUMN_EMAIL +" TEXT NOT NULL,"
                        + COLUMN_PHONE + " TEXT NOT NULL, "
                        + COLUMN_PERSONAL_ID + " TEXT NOT NULL)");
    }

    public void insert(String id, String name,String surname,String phone,String personal_id){
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID, id);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EMAIL, surname);
        values.put(COLUMN_PHONE,phone);
        values.put(COLUMN_PERSONAL_ID,personal_id);
        database.insert(TABLE_NAME, null, values);

    }

    public void delete(String personal_id){
        String [] args={personal_id};
        database.delete(TABLE_NAME, COLUMN_PERSONAL_ID+"= ?", args);
    }



    public Cursor getResult(String name){
        Cursor data = database.rawQuery("SELECT * FROM " + TABLE_NAME+" Where Name="+name,null);
        if (data.moveToNext()){
            return data;
        }else{
            return null;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }

    public void deleteAllRow(){
        database.execSQL("Delete from "+TABLE_NAME+" where String(a) IN (Select ID from "+TABLE_NAME+" limit 1)");

    }
    public Cursor getAllRow(){
        Cursor c3= database.rawQuery("SELECT * FROM "+TABLE_NAME+" LIMIT 1",null);
        if (c3.moveToNext()){
            return c3;
        }else{
            return null;
        }
    }
}