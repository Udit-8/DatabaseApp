package com.example.databaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
            myDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Anshul',19)");
            myDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Harshit',20)");
            Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);
            int nameIndex = c.getColumnIndex("name");
            int yearIndex = c.getColumnIndex("age");
            c.moveToFirst();
            while (c != null) {
                Log.i("name", c.getString(nameIndex));
                Log.i("year", Integer.toString(c.getInt(yearIndex)));
                c.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
