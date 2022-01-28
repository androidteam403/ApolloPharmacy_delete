package com.example.apollopharmacy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.apollopharmacy.databinding.ActivityFinalSummaryScreenBinding;

import java.util.ArrayList;
import java.util.List;

public class FinalSummaryScreen extends AppCompatActivity {
        ActivityFinalSummaryScreenBinding activityFinalSummaryScreenBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_final_summary_screen);

        activityFinalSummaryScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_final_summary_screen);

        List<FinalSummaryModelClass> newList = new ArrayList<>();

        FinalSummaryModelClass myDataList=new FinalSummaryModelClass(R.drawable.apolloash, "B.P MONITOR HEM", 10980, 1, 10980 );
        newList.add(myDataList);
        myDataList=new FinalSummaryModelClass(R.drawable.independent_living_aids, "PHYSIO BAND LATEX FREE", 775, 1, 775 );
        newList.add(myDataList);
        myDataList=new FinalSummaryModelClass(R.drawable.apolloash, "OMRON NERVE STIMULATOR", 990, 1, 990 );
        newList.add(myDataList);

        RecyclerView recyclerView6 = (RecyclerView) findViewById(R.id.finalrecyclerview);
        FinalSummaryAdapter adapter6 = new FinalSummaryAdapter(newList);
        recyclerView6.setLayoutManager(new LinearLayoutManager(FinalSummaryScreen.this, LinearLayoutManager.VERTICAL, false));
        recyclerView6.setAdapter(adapter6);

        activityFinalSummaryScreenBinding.backstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FinalSummaryScreen.this, ProductsView.class);
                startActivity(i);
            }
        });

    }
}