package com.example.apollopharmacy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.apollopharmacy.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.tVContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityMainBinding.loginlayout.setVisibility(View.GONE);
                activityMainBinding.otplayout.setVisibility(View.VISIBLE);
                activityMainBinding.tVnumber.setText(activityMainBinding.enterName.getText().toString());
            }
        });
        activityMainBinding.tVverify.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ProductsView.class);
            startActivity(i);
        });




    }

}