package com.example.feemangement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class mydata extends SQLiteOpenHelper {

    // private static final String CREATE_TABLE_Fee = "create table myfee(ID INTEGER PRIMARY KEY AUTOINCREMENT,name Text,installtion Text,date DATETIME DEFAULT CURRENT_TIMESTAMP)";
    public mydata(Context context) {
        super(context, "studentdatabase", null, 2);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // db.execSQL(CREATE_TABLE_Fee);
        db.execSQL("create table MydbTable (ID INTEGER PRIMARY KEY AUTOINCREMENT,name Text,gender Text,college text,study text,email text,mob text,address text,course text,total text,adm text,study1 text,date DATETIME DEFAULT CURRENT_TIMESTAMP)");
        db.execSQL("create table myfee(ID INTEGER PRIMARY KEY AUTOINCREMENT,STUDENT_ID INTERGET REFERENCES MydbTable(ID),name Text,mob Text REFERENCES MydbTable(mob),installtion Text,date DATETIME DEFAULT CURRENT_TIMESTAMP)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS MydbTable");
        // db.execSQL("create table MydbTable (ID INTEGER PRIMARY KEY AUTOINCREMENT,name Text,gender Text,college text,study text,email text,mob text,address text,course text,total text,adm text,study1 text,date DATETIME DEFAULT CURRENT_TIMESTAMP)");
        // db.execSQL("DROP TABLE IF EXISTS myfee");
        db.execSQL("create table myfee(ID INTEGER PRIMARY KEY AUTOINCREMENT,STUDENT_ID INTERGET REFERENCES MydbTable(ID),name Text,mob Text REFERENCES MydbTable(mob),installtion Text,date DATETIME DEFAULT CURRENT_TIMESTAMP)");
        onCreate(db);
    }

    void insert(String name, String gender, String college, String study, String email, String mob, String address, String course, String total, String adm, String study1, String date) {
        ContentValues contentValues = new ContentValues();
        //contentValues.put("id",id);
        contentValues.put("name", name);
        contentValues.put("gender", gender);
        contentValues.put("college", college);
        contentValues.put("study", study);
        contentValues.put("email", email);
        contentValues.put("mob", mob);
        contentValues.put("address", address);
        contentValues.put("course", course);
        contentValues.put("total", total);
        contentValues.put("adm", adm);
        contentValues.put("study1", study1);
        contentValues.put("date", date);

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert("MydbTable", null, contentValues);
    }

    void insertfee(String name, String studentid, String mob, String installtion, String date) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", name);
        contentValues.put("STUDENT_ID", studentid);
        contentValues.put("mob", mob);
        contentValues.put("installtion", installtion);
        contentValues.put("date", date);

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.insert("myfee", null, contentValues);
    }

    String[] serach(String abc) {
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5 = null;
        String s6 = null;
        String s7 = null;
        String s8 = null;
        String s9 = null;
        String s10 = null;
//        String s11 = null;
//        String s12 = null;


        String[] ms = null;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM MydbTable WHERE name='" + abc + "'", null);

        cursor.moveToNext();
        try {

            s1 = cursor.getString(1);
            s2 = cursor.getString(2);
            s3 = cursor.getString(3);
            s4 = cursor.getString(4);
            s5 = cursor.getString(5);
            s6 = cursor.getString(6);
            s7 = cursor.getString(7);
            s8 = cursor.getString(8);
            s9 = cursor.getString(9);
            s10 = cursor.getString(10);
//            s11 = cursor.getString(11);
//            s12 = cursor.getString(12);
            //s4 = cursor.getString(3);
            //s4 = cursor.getString(3);


            ms = new String[]{s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};

            return ms;
        } catch (CursorIndexOutOfBoundsException e) {
            ms = new String[]{"null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null"};
            return null;
        }
    }

    Object[] alldata() {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM MydbTable", null);

        String[] s1 = new String[cursor.getCount()];
        String[] s2 = new String[cursor.getCount()];
        String[] s3 = new String[cursor.getCount()];
        String[] s4 = new String[cursor.getCount()];
        String[] s5 = new String[cursor.getCount()];
        String[] s6 = new String[cursor.getCount()];
        String[] s7 = new String[cursor.getCount()];
        String[] s8 = new String[cursor.getCount()];
        String[] s9 = new String[cursor.getCount()];
        String[] s10 = new String[cursor.getCount()];
        String[] s11 = new String[cursor.getCount()];
        String[] s12 = new String[cursor.getCount()];
        int count = 0;

        while (cursor.moveToNext()) {

            s1[count] = cursor.getString(1);
            s2[count] = cursor.getString(2);
            s3[count] = cursor.getString(3);
            s4[count] = cursor.getString(11);
            s5[count] = cursor.getString(5);
            s6[count] = cursor.getString(6);
            s7[count] = cursor.getString(7);
            s8[count] = cursor.getString(8);
            s9[count] = cursor.getString(9);
            s10[count] = cursor.getString(10);
            s11[count] = cursor.getString(12);
            count++;
        }
        Object[] objects = new Object[13];
        objects[0] = s1;
        objects[1] = s2;
        objects[2] = s3;
        objects[3] = s4;
        objects[4] = s5;
        objects[5] = s6;
        objects[6] = s7;
        objects[7] = s8;
        objects[8] = s9;
        objects[9] = s10;
        objects[10] = s11;
        objects[11] = s12;


        return objects;

    }


    Cursor getidfromstudent(String name) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT ID , mob FROM MydbTable where name='" + name + "'", null);

        cursor.moveToNext();
        return cursor;

    }

    void update(String name, String gender, String college, String study, String email, String mob, String address, String course, String total, String adm, String study1) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put("id",id);
        contentValues.put("name", name);
        contentValues.put("gender", gender);
        contentValues.put("college", college);
        contentValues.put("study", study);
        contentValues.put("email", email);
        contentValues.put("mob", mob);
        contentValues.put("address", address);
        contentValues.put("course", course);
        contentValues.put("total", total);
        contentValues.put("adm", adm);
        contentValues.put("study1", study1);


        sqLiteDatabase.update("MydbTable", contentValues, "name='" + name + "'", null);

    }

    void delete(String a) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//DELETE t1,t2 FROM t1 INNER JOIN t2 ON t2.ref = t1.id WHERE t1.id = 1;
        sqLiteDatabase.delete("MydbTable", "name='" + a + "'", null);
        sqLiteDatabase.delete("myfee", "name='" + a + "'", null);
    }

    void deleteall() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.delete("MydbTable", null, null);
        sqLiteDatabase.delete("myfee", null, null);
    }

    Cursor getFeedata() {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM myfee", null);

        cursor.moveToNext();
        return cursor;
    }


    Cursor getdataall() {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM MydbTable ", null);

        cursor.moveToNext();
        return cursor;
    }

    Cursor getdata(String abc) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM MydbTable where name='" + abc + "'OR mob='" + abc + "' ", null);

        cursor.moveToNext();
        return cursor;
    }

    Cursor getFeealldata(String abc) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        //SELECT * FROM myfee where name='" + abc + "'", null
        Cursor cursor1 = sqLiteDatabase.rawQuery("SELECT * FROM MydbTable A INNER JOIN myfee B ON A.ID=B.STUDENT_ID where A.name='" + abc + "'OR A.mob='" + abc + "'", null);
        //Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM myfee", null);
        cursor1.moveToNext();
        return cursor1;
    }

    Cursor jointable(String name) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        //  MY_QUERY = "SELECT * FROM table_a a INNER JOIN table_b b ON a.id=b.other_id WHERE b.property_id=?";
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM MydbTable A INNER JOIN myfee B ON A.ID=B.STUDENT_ID where A.name='" + name + "'OR A.mob='" + name + "'", null);
        //Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM myfee", null);
        cursor.moveToNext();
        return cursor;
    }

    //    Cursor total(String name) {
//        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery("SELECT Sum(installtion) FROM MydbTable A INNER JOIN myfee B ON A.ID=B.STUDENT_ID where A.name='" + name + "'OR A.mob='" + name + "'", null);
//        return null;
//        if (cursor.moveToFirst()) {
//            return cursor.getInt(4);
//        }
//    }
    public int getSumValue(String name) {
        int sum = 0;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT SUM(installtion) as installtion  FROM MydbTable A INNER JOIN myfee B ON A.ID=B.STUDENT_ID where A.name='" + name + "'OR A.mob='" + name + "'", null);
        if (cursor.moveToNext())
            sum = cursor.getInt(cursor.getColumnIndex("installtion"));
        return sum;
    }


}

