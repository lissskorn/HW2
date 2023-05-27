package com.mirea.kt.datastorageapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private EditText Name, Variety;
    private Button Add, Next;

    private SwitchCompat Sw;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.name);
        Variety = findViewById(R.id.variety);
        Add = findViewById(R.id.add);
        Next = findViewById(R.id.next);
        Add.setOnClickListener(this);
        Next.setOnClickListener(this);
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));
        Sw = findViewById(R.id.type);
        if (Sw != null) {
            Sw.setOnCheckedChangeListener(this);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        Toast.makeText(this, (isChecked ? "on" : "off"),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add) {
            if(this.dbManager != null) {
                String name = Name.getText().toString();
                String variety = Variety.getText().toString();
                Boolean type = Boolean.valueOf(Sw.getText().toString());
                if(!name.isEmpty()&& !variety.isEmpty()) {
                    boolean result = dbManager.savePlantsToDatabase(new Plants(name, variety, type));
                    if(result) {
                        Toast.makeText(this, R.string.insert_success, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, R.string.insert_error, Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(this, R.string.incorrect_value, Toast.LENGTH_LONG).show();
                }
            }
        } else if(v.getId() == R.id.next) {
            startActivity(new Intent(this, PlantsActivity.class));
        }
    }
}
