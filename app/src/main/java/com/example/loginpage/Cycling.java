package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Cycling extends AppCompatActivity {

    int teamAscore = 0;
    int teamBscore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycling);
    }

    public void increasescore(View view) {
        int buttonId = view.getId();

        if (buttonId == R.id.three_points_teamA){
            teamAscore = teamAscore + 3;
            displayForTeamA(teamAscore);
        }
        if (buttonId == R.id.two_points_teamA){
            teamAscore = teamAscore + 2;
            displayForTeamA(teamAscore);
        }
        if (buttonId == R.id.free_throw_teamA){
            teamAscore = teamAscore + 1;
            displayForTeamA(teamAscore);
        }
        if (buttonId == R.id.three_points_teamB){
            teamBscore = teamBscore + 3;
            displayForTeamB(teamBscore);
        }
        if (buttonId == R.id.two_points_teamB){
            teamBscore = teamAscore + 2;
            displayForTeamB(teamBscore);
        }
        if (buttonId == R.id.free_throw_teamB){
            teamBscore = teamBscore + 1;
            displayForTeamB(teamBscore);
        }


    }

    private void displayForTeamB(int teamBscore) {
        TextView scoreview = (TextView) findViewById(R.id.team_b_score);
        scoreview.setText(String.valueOf(teamBscore));
    }

    private void displayForTeamA(int teamAscore) {
        TextView scoreview = (TextView) findViewById(R.id.team_a_score);
        scoreview.setText(String.valueOf(teamAscore));
    }

    public void reset(View view) {
        teamAscore = 0;
        teamBscore = 0;
        displayForTeamA(teamAscore);
        displayForTeamB(teamBscore);
    }
}