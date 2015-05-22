package com.prelim.ite010_a2.sqlitesample;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    EditText fname =null;
    EditText lname =null;
    EditText phone =null;
    EditText email =null;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = (EditText) findViewById(R.id.txtFirstName);
        lname = (EditText) findViewById(R.id.txtlastLastName);
        phone = (EditText) findViewById(R.id.txtphone);
        email = (EditText) findViewById(R.id.txtEmail);
    }
    public void save(View v){
        db= (new DBHelper(this)).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("firstname",fname.getText().toString());
        values.put("lastname",lname.getText().toString());
        values.put("phone",phone.getText().toString());
        values.put("email", email.getText().toString());
        db.insert("info",null,values);
    }
    public void listData(View v){
        Intent intent = new Intent(this,InfoList.class);
        startActivity(intent);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
