package com.example.eboxsalon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {
    private ImageView mBackIV1, mViewOrderIV, mOrderHistoryIV, mTrackOrderIV, mPaymentHistoryIV, mReviewIV, mEboxCoinsIV;
    private TextView mViewOrderTV, mOrderHistoryTV, mTrackOrderTV, mPaymentHistoryTV, mReviewTV, mEboxCoinsTV;
    private Button mBackToHomeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        mBackIV1 = findViewById(R.id.back_image_view1);
        mViewOrderIV = findViewById(R.id.vieworder_image_view);
        mTrackOrderIV = findViewById(R.id.trackorder_image_view);
        mReviewIV = findViewById(R.id.review_image_view);
        mEboxCoinsIV = findViewById(R.id.eboxcoins_image_view);

        mViewOrderTV = findViewById(R.id.viewyourorder_text_view);
        mTrackOrderTV = findViewById(R.id.trackorder_text_view);
        mReviewTV = findViewById(R.id.review_text_view);
        mEboxCoinsTV = findViewById(R.id.eboxcoins_text_view);

        mBackToHomeBtn = findViewById(R.id.backtohome_button);

        mBackIV1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(OrderActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mBackToHomeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(OrderActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mReviewIV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(OrderActivity.this, ReviewActivity.class);
                startActivity(intent);
            }
        });

    }
}