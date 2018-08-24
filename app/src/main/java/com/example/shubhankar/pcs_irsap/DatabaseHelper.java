package com.example.shubhankar.pcs_irsap;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "chart.sqlite";
    private static String DB_PATH= "";
    private SQLiteDatabase sqLiteDatabase;
    private final Context context;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME,null,1);
        DB_PATH = context.getApplicationInfo().dataDir + "/databases";
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void checkAndCopyDatabse(){
        boolean dbExists=checkDatabse();
        if(dbExists){
            Log.d("dd","database already exists");
        }
        else {
            this.getReadableDatabase();
        }

        try {
            copyDatabase();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("dd","Error copy database");
        }
    }

    public boolean checkDatabse(){
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        }catch (SQLiteException e){

        }
        if (checkDB!=null){
            checkDB.close();
        }

        return checkDB != null ? true:false;
    }

    public void copyDatabase() throws IOException {
        InputStream inputStream = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream outputStream = new FileOutputStream(outFileName);
        byte [] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer))>0){
            outputStream.write(buffer,0,length);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

    public void openDatabse(){
        String my_path = DB_PATH+DB_NAME;
        sqLiteDatabase = SQLiteDatabase.openDatabase(my_path,null,SQLiteDatabase.OPEN_READWRITE);

    }

    public synchronized void close(){
        if(sqLiteDatabase != null){
            sqLiteDatabase.close();
        }
        super.close();
    }
    public Cursor QueryData(String query){
        return sqLiteDatabase.rawQuery(query,null);
    }
}