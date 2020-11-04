package com.example.eboxsalon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageView mMoreIV, mHomeIV, mAppointmentIV, mOrderIV, mAccountIV;
    private TextView mMoreTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMoreIV = findViewById(R.id.more_image_view);
        mHomeIV = findViewById(R.id.home_image_view);
        mAppointmentIV = findViewById(R.id.appointment_image_view);
        mOrderIV = findViewById(R.id.order_image_view);
        mAccountIV = findViewById(R.id.account_image_view);
        mMoreTV = findViewById(R.id.more_text_view);

        mMoreIV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, MoreActivity.class);
                startActivity(intent);
            }
        });

        mMoreTV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, MoreActivity.class);
                startActivity(intent);
            }
        });

        mOrderIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

    }
}