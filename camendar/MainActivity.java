package com.wangyyt_1013.camendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    public void addEventClicked(View view) {
        Intent toSecondMenuPage = new Intent(this, secondMenuPage.class);
        startActivity(toSecondMenuPage);

    }

    public void searchEventClicked (View view) {
        Intent toSearchMainPage = new Intent(this, searchMainPage.class);
        startActivity(toSearchMainPage);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
