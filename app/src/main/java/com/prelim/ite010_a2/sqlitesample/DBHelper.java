package com.prelim.ite010_a2.sqlitesample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by RM 207 on 5/13/2015.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="my_contact.db";
    public DBHelper(Context context){
        super(context,DB_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlStmt= "CREATE TABLE IF NOT EXISTS info(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "firstname TEXT, " +
                "lastname  TEXT," +
                "phone     TEXT, " +
                "email     TEXT)";
        db.execSQL(sqlStmt);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(" DROP TABLE IF EXISTS info");
    onCreate(db);
    }
}
