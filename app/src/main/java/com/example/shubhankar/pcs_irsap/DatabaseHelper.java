package com.example.shubhankar.pcs_irsap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Chart.db";
    private static final String TABLE_NAME = "confirmed_chart";
    private static final String COL1 = "ID";
    private static final String COL2 = "NAME";
    private static final String COL3 = "SEATNO";
    private  SQLiteDatabase database;
    private static DatabaseHelper _PassengerDatabase = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
       // database= this.getWritableDatabase();
    }

    public static DatabaseHelper getDatabaseHelperInstance() {
        if (_PassengerDatabase == null) {
            _PassengerDatabase = new DatabaseHelper(MainActivity.instance());
        }

        return _PassengerDatabase;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SEATNO INTEGER)";
        db.execSQL(createTable);

        insertPassengerData("1","Rohit Joshi","45");
        insertPassengerData("2","Shubhankar Patil","46");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean insertPassengerData(String id,String name, String seatNo) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2,name);
        contentValues.put(COL1,seatNo);
        long result = database.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }




















}