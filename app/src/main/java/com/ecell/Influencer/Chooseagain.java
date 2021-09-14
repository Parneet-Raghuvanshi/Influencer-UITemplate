package com.ecell.Influencer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Chooseagain extends AppCompatActivity {
    ImageView influencer_btn,buisness_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE);
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chooseagain);

        influencer_btn = findViewById(R.id.imageView6);
        buisness_btn = findViewById(R.id.imageView5);

        influencer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chooseagain.this,login_influencer.class);
                startActivity(intent);
            }
        });

        buisness_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chooseagain.this,login_influencer.class);
                startActivity(intent);
            }
        });
    }
}