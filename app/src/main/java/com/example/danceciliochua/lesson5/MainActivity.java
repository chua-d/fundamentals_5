package com.example.danceciliochua.lesson5;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mScoreTeam1;
    TextView mScoreTeam2;
    int scoreTeam1 = 0;
    int scoreTeam2 = 0;
    final String STATE_SCORE_1 = "Team1";
    final String STATE_SCORE_2 = "Team2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScoreTeam1 = (TextView)findViewById(R.id.score_1);
        mScoreTeam2 = (TextView)findViewById(R.id.score_2);

        if(savedInstanceState != null) {
            scoreTeam1 = savedInstanceState.getInt(STATE_SCORE_1);
            scoreTeam2 = savedInstanceState.getInt(STATE_SCORE_2);

            mScoreTeam1.setText(String.valueOf(scoreTeam1));
            mScoreTeam2.setText(String.valueOf(scoreTeam2));

        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putInt(STATE_SCORE_1, scoreTeam1);
        outState.putInt(STATE_SCORE_2, scoreTeam2);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                recreate();
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                recreate();
            }
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);

        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);

        }
        return true;
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();

        switch (viewID) {

            case R.id.decreaseTeam1:
                scoreTeam1--;
                mScoreTeam1.setText(String.valueOf(scoreTeam1));
                break;

            case R.id.decreaseTeam2:
                scoreTeam2--;
                mScoreTeam2.setText(String.valueOf(scoreTeam2));
                break;

        }

    }

    public void increaseScore(View view) {
        int viewID = view.getId();

        switch (viewID) {

            case R.id.increaseTeam1:
                scoreTeam1++;
                mScoreTeam1.setText(String.valueOf(scoreTeam1));
                break;

            case R.id.increaseTeam2:
                scoreTeam2++;
                mScoreTeam2.setText(String.valueOf(scoreTeam2));
                break;

        }

    }

}
