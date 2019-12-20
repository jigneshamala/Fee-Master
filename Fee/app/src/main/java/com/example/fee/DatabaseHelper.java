package com.example.fee;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "STUDENT";
    private static final String TABLE_STUDENT = "STUDENT";
    private static final String TABLE_FEE = "STUDENTFEE";
    private static final String STUDENT_ID = "id";
    private static final String FEE_ID = "id";
    private static final String NAME = "name";
    private static final String GENDER = "gender";
    private static final String COLLEGE = "college";
    private static final String EMAIL = "EMAIL";
    private static final String STUDY = "study";
    private static final String STUDY_ID = "studyid";
    private static final String MOBLIE_NUMBER = "mobile";
    private static final String ADDRESS = "address";
    private static final String COURSES = "courses";
    private static final String TOTAL_FEE = "totalfee";
    private static final String ADMISSION_FEE = "admissionfee";
    private static final String DATE_STUDENT = "date";
    private static final String DATE_FEE = "date";
    private static final String INSTALLATION_FEE = "installation";
    private static final String STUDENT_FEE_NAME = "name";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_STUDENT = "CREATE TABLE " + TABLE_STUDENT + "(" + STUDENT_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + "TEXT," + GENDER + "TEXT," + COLLEGE + "TEXT," + EMAIL + "TEXT," + STUDY + "TEXT," + MOBLIE_NUMBER + "TEXT," + ADDRESS + "TEXT," + COURSES + "TEXT," + TOTAL_FEE + "TEXT," + ADMISSION_FEE + "TEXT," + DATE_STUDENT + "TEXT," + STUDY_ID + "TEXT)";
        String CREATE_TABLE_FEE = "CREATE TABLE " + TOTAL_FEE + "(" + FEE_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + STUDENT_ID + "INTEGER REFERENCES" + TABLE_STUDENT +STUDENT_ID+","+ INSTALLATION_FEE + " TEXT," + NAME + "TEXT," + DATE_FEE + "TEXT)";
        db.execSQL(CREATE_TABLE_STUDENT);
        db.execSQL(CREATE_TABLE_FEE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_STUDENT);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_FEE);
        onCreate(db);

    }

    void insert(String NAME,String GENDER,String COLLEGE,String EMAIL,String STUDY,String MOBLIE_NUMBER,String ADDRESS,String COURSES,String TOTAL_FEE,String ADMISSION_FEE) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", NAME);
        contentValues.put("gender", GENDER);
        contentValues.put("college", COLLEGE);
        contentValues.put("email", EMAIL);
        contentValues.put("study", STUDY);
        contentValues.put("mobile",MOBLIE_NUMBER);
        contentValues.put("address", ADDRESS);
        contentValues.put("courses", COURSES);
        contentValues.put("totalfee", TOTAL_FEE);
        contentValues.put("admissionfee", ADMISSION_FEE);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.insert(TABLE_STUDENT, null, contentValues);
    }
}
