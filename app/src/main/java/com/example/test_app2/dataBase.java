package com.example.test_app2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class dataBase extends SQLiteOpenHelper {
    public dataBase(Context context) {
        super(context,"dbemp", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {//ONLY ONCE
       String query= "create table tbemp (id INTEGER ,name TEXT,address TEXT,salary INTEGER)";
       sqLiteDatabase.execSQL(query);
    }
    public void saveemp(int id,String name,String address,int salary){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("id",id);
        values.put("name",name);
        values.put("address",address);
        values.put("salary",salary);
        db.insert("tbemp",null,values);


    }
    public int getcount(){
        String query="SELECT count(*) as totalCount FROM tbemp";
        SQLiteDatabase db=getReadableDatabase();
        Cursor pointer =db.rawQuery(query,null);
        pointer.moveToFirst();
        int value=pointer.getInt(0);
        return value;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
