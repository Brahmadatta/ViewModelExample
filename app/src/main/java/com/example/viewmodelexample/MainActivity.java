package com.example.viewmodelexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    TextView count;

private MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        floatingActionButton = findViewById(R.id.floatingActionButton);

        count = findViewById(R.id.count);


        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        LiveData<Integer> countLiveData = mMainActivityViewModel.getInitialCount();

        countLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                count.setText(""+integer);
            }
        });



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMainActivityViewModel.getCurrentCount();
            }
        });

    }


}
