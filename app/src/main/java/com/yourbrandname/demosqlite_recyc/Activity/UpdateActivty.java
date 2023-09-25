package com.yourbrandname.demosqlite_recyc.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.yourbrandname.demosqlite_recyc.Database.MyDbhelper;
import com.yourbrandname.demosqlite_recyc.R;

public class UpdateActivty extends AppCompatActivity {

    AppCompatButton updatebtn, deletbtn;
    EditText edtname, edtphoneno, edtid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_activty);
        MyDbhelper dbhelper = new MyDbhelper(this);
        updatebtn = findViewById(R.id.btn_adddata_upd);
        deletbtn = findViewById(R.id.btn_adddata_delet);

        edtname = findViewById(R.id.edt_name_upd);
        edtphoneno = findViewById(R.id.edt_phonenum_upd);
        edtid = findViewById(R.id.edt_id_upd);

        Intent intent = getIntent();
        String id = intent.getStringExtra("KEY_ID");
        String name = intent.getStringExtra("CLIENT_NAME");
        String phoneno = intent.getStringExtra("CLIENT_PHNO");

        edtid.setText(id);
        edtname.setText(name);
        edtphoneno.setText(phoneno);

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbhelper.UpdateData((edtid.getText().toString()), edtname.getText().toString(), edtphoneno.getText().toString());
                startActivity(new Intent(UpdateActivty.this, ViewActivity.class));
                finish();
            }
        });

        deletbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbhelper.DeletUserdata(edtid.getText().toString());
                startActivity(new Intent(UpdateActivty.this, ViewActivity.class));
                finish();
            }
        });

    }
}