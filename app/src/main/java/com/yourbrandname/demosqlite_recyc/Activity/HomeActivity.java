package com.yourbrandname.demosqlite_recyc.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.yourbrandname.demosqlite_recyc.Database.MyDbhelper;
import com.yourbrandname.demosqlite_recyc.R;

public class HomeActivity extends AppCompatActivity {

    EditText edtname, edtphoneno;
    AppCompatButton btnadddata, btnviewdata;

    String getname, getphoneno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        edtname = findViewById(R.id.edt_name);
        edtphoneno = findViewById(R.id.edt_phonenum);
        btnadddata = findViewById(R.id.btn_adddata);
        btnviewdata = findViewById(R.id.btn_viewdata);

        MyDbhelper dbhelper = new MyDbhelper(this);

        btnadddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getname = edtname.getText().toString();
                getphoneno = edtphoneno.getText().toString();

                if (getname.matches("") && getphoneno.equals("")) {
                    Toast.makeText(HomeActivity.this, "PLease Fill Data", Toast.LENGTH_SHORT).show();
                } else {
                    dbhelper.AddUser(getname, getphoneno);
                }
                edtname.setText("");
                edtphoneno.setText("");
            }
        });

        btnviewdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ViewActivity.class));
//                dbhelper.DeletUser();

            }
        });
    }
}