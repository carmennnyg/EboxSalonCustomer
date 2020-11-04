package com.example.eboxsalon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class RateReviewActivity extends AppCompatActivity {

    private Button mSubmitBtn;
    private ImageView mBack2IV;
    private TextView mNameTV, mCountRateTV, mShowRateTV;
    private RatingBar mRatingBar;
    private EditText mReviewET;

    float rateValue; String temp;

    Staffs staffs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_review);

        mSubmitBtn = findViewById(R.id.submitreview_button);
        mBack2IV = findViewById(R.id.back_image_view2);
        mNameTV = findViewById(R.id.name_text_view);
        mCountRateTV = findViewById(R.id.rateCount_text_view);
        mShowRateTV = findViewById(R.id.showrating_text_view);
        mRatingBar = findViewById(R.id.rating_bar);
        mReviewET = findViewById(R.id.review_edit_text);

        Intent intent = getIntent();

        if(intent.getExtras() != null){
            staffs = (Staffs) intent.getSerializableExtra("item");
            mNameTV.setText(staffs.getName());
        }

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rateValue = mRatingBar.getRating();

                if(rateValue <=1 && rateValue>0)
                    mCountRateTV.setText("Bad" + rateValue + "/5");
                else if(rateValue <=2 && rateValue >1)
                    mCountRateTV.setText("Not Bad" + rateValue + "/5");
                else if(rateValue <=3 && rateValue >2)
                    mCountRateTV.setText("Good" + rateValue + "/5");
                else if(rateValue <=4 && rateValue >3)
                    mCountRateTV.setText("Very Good" + rateValue + "/5");
                else if(rateValue <=5 && rateValue >4)
                    mCountRateTV.setText("Best" + rateValue + "/5");

            }
        });

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = mCountRateTV.getText().toString();
                mShowRateTV.setText("Your Rating: \n" + temp + " \n" + mReviewET.getText());
                mReviewET.setText(" ");
                mRatingBar.setRating(0);
                mCountRateTV.setText(" ");

            }
        });

        mBack2IV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(RateReviewActivity.this, ReviewActivity.class);
                startActivity(intent);
            }
        });
    }
}