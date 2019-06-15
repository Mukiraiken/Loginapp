package com.example.loginapp;

import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.widget.EditText;


public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Name
    public static final String DATABASE_NAME="cars";
    public static final String TABLE_NAME="users";
    public static final String COL_1="id";
    public static final String COL_2="name";
    public static final String COL_3="email";
    public static final int COL_4= Integer.parseInt("password");



    // Database Version
    private static final int DATABASE_VERSION = 1;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // create user table
        sqLiteDatabase .execSQL("CREATE TABLE users(ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,password TEXT )");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Car.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long addUser(String name, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("password",password);
        long res = db.insert("users",null,contentValues);
        db.close();
        return  res;
    }

    public boolean checkUser(String name, String password, String email){
        String[] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = { name, email, password };
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return  true;
        else
            return  false;
    }
}
