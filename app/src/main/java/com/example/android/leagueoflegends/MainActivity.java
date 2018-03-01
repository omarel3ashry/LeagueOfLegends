package com.example.android.leagueoflegends;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    //Solo
    TextView gamesSolo;
    TextView pointsSolo;
    TextView placementSolo;
    TextView rankSolo;
    //Flex
    TextView gamesFlex;
    TextView pointsFlex;
    TextView placementFlex;
    TextView rankFlex;
        int rankedSoloPoint = 0,
            rankedFlexPoint = 0,
            flexGamePlayed = 0,
            soloGamePlayed = 0,
            soloTemp = 0,
            flexTemp = 0,
            soloPlacementWin = 0,
            soloPlacementDef = 0,
            flexPlacementWin = 0,
            flexPlacementDef = 0,
            soloRank = 0,
            flexRank = 0,
            promoWin = 0,
            promoDef = 0,
            soloDemotion = 0,
            flexDemotion = 0;
    String division[] = {"Bronze V", "Bronze IV", "Bronze III", "Bronze II", "Bronze I",
            "Silver V", "Silver IV", "Silver III", "Silver II", "Silver I",
            "Gold V", "Gold IV", "Gold III", "Gold II", "Gold I",
            "Platinum V", "Platinum IV", "Platinum III", "Platinum II", "Platinum I",
            "Diamond V", "Diamond IV", "Diamond III", "Diamond II", "Diamond I",
            "Master", "Challenger"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Solo
        gamesSolo = findViewById(R.id.gameS);
        pointsSolo = findViewById(R.id.point_solo);
        placementSolo = findViewById(R.id.plac_s);
        rankSolo = findViewById(R.id.rank_solo);
        //Flex
        gamesFlex = findViewById(R.id.gameF);
        pointsFlex = findViewById(R.id.point_flex);
        placementFlex = findViewById(R.id.plac_f);
        rankFlex = findViewById(R.id.rank_flex);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.about_st:
                Intent intent = new Intent(this, AboutAppActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showDialog() {
        promoWin = 0;
        promoDef = 0;
        final Dialog promoDialogSolo = new Dialog(this);
        promoDialogSolo.setContentView(R.layout.series_dialog);
        promoDialogSolo.setCancelable(false);
        final TextView progression = promoDialogSolo.findViewById(R.id.p_text);
        progression.setText("o            o            o");
        Button victoryBtnSolo = promoDialogSolo.findViewById(R.id.v_button);
        final Button defeatBtnSolo = promoDialogSolo.findViewById(R.id.d_button);
        promoDialogSolo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        promoDialogSolo.show();
        victoryBtnSolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (promoWin == 0 && promoDef == 0) {
                    progression.setText("✓            o            o");
                    promoWin++;
                } else if (promoWin == 1 && promoDef == 0) {
                    promoWin = 0;
                    promoDef = 0;
                    progression.setText("✓            ✓            o");
                    soloRank++;
                    rankedSoloPoint = 0;
                    rankSolo.setText(division[soloRank]);
                    pointsSolo.setText(String.valueOf(rankedSoloPoint));
                    promoDialogSolo.dismiss();
                } else if (promoWin == 0 && promoDef == 1) {
                    progression.setText("✗            ✓            o");
                    promoWin++;
                } else if (promoWin == 1 && promoDef == 1) {
                    promoWin = 0;
                    promoDef = 0;
                    rankedSoloPoint = 0;
                    soloRank++;
                    rankSolo.setText(division[soloRank]);
                    pointsSolo.setText(String.valueOf(rankedSoloPoint));
                    promoDialogSolo.dismiss();
                }
            }
        });
        defeatBtnSolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (promoDef == 0 && promoWin == 0) {
                    progression.setText("✗            o            o");
                    promoDef++;
                } else if (promoDef == 1 && promoWin == 0) {
                    promoWin = 0;
                    promoDef = 0;
                    progression.setText("✗            ✗            o");
                    rankedSoloPoint = 80;
                    rankSolo.setText(division[soloRank]);
                    pointsSolo.setText(String.valueOf(rankedSoloPoint));
                    promoDialogSolo.dismiss();
                } else if (promoWin == 1 && promoDef == 0) {
                    progression.setText("✓            ✗            o");
                    promoDef++;
                } else if (promoDef == 1 && promoWin == 1) {
                    promoWin = 0;
                    promoDef = 0;
                    rankedSoloPoint = 80;
                    rankSolo.setText(division[soloRank]);
                    pointsSolo.setText(String.valueOf(rankedSoloPoint));
                    promoDialogSolo.dismiss();
                }
            }
        });
    }

    public void showDialogFlex() {
        promoWin = 0;
        promoDef = 0;
        final Dialog promoDialogFlex = new Dialog(this);
        promoDialogFlex.setContentView(R.layout.series_dialog);
        promoDialogFlex.setCancelable(false);
        final TextView progressionFlex = promoDialogFlex.findViewById(R.id.p_text);
        progressionFlex.setText("o            o            o");
        Button victoryBtnFlex = promoDialogFlex.findViewById(R.id.v_button);
        final Button defeatBtnFlex = promoDialogFlex.findViewById(R.id.d_button);
        promoDialogFlex.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        promoDialogFlex.show();
        victoryBtnFlex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (promoWin == 0 && promoDef == 0) {
                    progressionFlex.setText("✓            o            o");
                    promoWin++;
                } else if (promoWin == 1 && promoDef == 0) {
                    promoWin = 0;
                    promoDef = 0;
                    progressionFlex.setText("✓            ✓            o");
                    flexRank++;
                    rankedFlexPoint = 0;
                    rankFlex.setText(division[flexRank]);
                    pointsFlex.setText(String.valueOf(rankedFlexPoint));
                    promoDialogFlex.dismiss();
                } else if (promoWin == 0 && promoDef == 1) {
                    progressionFlex.setText("✗            ✓            o");
                    promoWin++;
                } else if (promoWin == 1 && promoDef == 1) {
                    promoWin = 0;
                    promoDef = 0;
                    rankedFlexPoint = 0;
                    flexRank++;
                    rankFlex.setText(division[flexRank]);
                    pointsFlex.setText(String.valueOf(rankedFlexPoint));
                    promoDialogFlex.dismiss();
                }
            }
        });
        defeatBtnFlex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (promoDef == 0 && promoWin == 0) {
                    progressionFlex.setText("✗            o            o");
                    promoDef++;
                } else if (promoDef == 1 && promoWin == 0) {
                    promoWin = 0;
                    promoDef = 0;
                    progressionFlex.setText("✗            ✗            o");
                    rankedFlexPoint = 80;
                    rankFlex.setText(division[flexRank]);
                    pointsFlex.setText(String.valueOf(rankedFlexPoint));
                    promoDialogFlex.dismiss();
                } else if (promoWin == 1 && promoDef == 0) {
                    progressionFlex.setText("✓            ✗            o");
                    promoDef++;
                } else if (promoDef == 1 && promoWin == 1) {
                    promoWin = 0;
                    promoDef = 0;
                    rankedFlexPoint = 80;
                    rankFlex.setText(division[flexRank]);
                    pointsFlex.setText(String.valueOf(rankedFlexPoint));
                    promoDialogFlex.dismiss();
                }
            }
        });
    }

    public void showDialog5() {
        promoWin = 0;
        promoDef = 0;
        final Dialog promoDialogSolo = new Dialog(this);
        promoDialogSolo.setContentView(R.layout.series_dialog);
        promoDialogSolo.setCancelable(false);
        final TextView progression = promoDialogSolo.findViewById(R.id.p_text);
        progression.setText("o     o     o     o     o");
        Button victoryBtnSolo = promoDialogSolo.findViewById(R.id.v_button);
        final Button defeatBtnSolo = promoDialogSolo.findViewById(R.id.d_button);
        promoDialogSolo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        promoDialogSolo.show();
        victoryBtnSolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (promoWin == 0 && promoDef == 0) {
                    progression.setText("✓     o     o     o     o");
                    promoWin++;
                } else if (promoWin == 1 && promoDef == 0) {
                    progression.setText("✓     ✓     o     o     o");
                    promoWin++;
                } else if (promoWin == 0 && promoDef == 1) {
                    progression.setText("✗     ✓     o     o     o");
                    promoWin++;
                } else if (promoWin == 0 && promoDef == 2) {
                    progression.setText("✗     ✗     ✓     o     o");
                    promoWin++;
                } else if (promoWin == 1 && promoDef == 2 && progression.getText() == "✗     ✗     ✓     o     o") {
                    progression.setText("✗     ✗     ✓     ✓     o");
                    promoWin++;
                } else if (promoWin == 1 && promoDef == 2 && progression.getText() == "✗     ✓     ✗     o     o") {
                    progression.setText("✗     ✓     ✗     ✓     o");
                    promoWin++;
                } else if (promoWin == 1 && promoDef == 2 && progression.getText() == "✓     ✗     ✗     o     o") {
                    progression.setText("✓     ✗     ✗     ✓     o");
                    promoWin++;
                } else if (promoWin == 1 && promoDef == 1 && progression.getText() == "✗     ✓     o     o     o") {
                    progression.setText("✗     ✓     ✓     o     o");
                    promoWin++;
                } else if (promoWin == 1 && promoDef == 1 && progression.getText() == "✓     ✗     o     o     o") {
                    progression.setText("✓     ✗     ✓     o     o");
                    promoWin++;
                } else if (promoWin == 2 && promoDef == 0) {
                    progression.setText("✓     ✓     ✓     o     o");
                    promoWin = 0;
                    promoDef = 0;
                    rankedSoloPoint = 0;
                    soloRank++;
                    rankSolo.setText(division[soloRank]);
                    pointsSolo.setText(String.valueOf(rankedSoloPoint));
                    promoDialogSolo.dismiss();
                } else if (promoWin == 2 && promoDef == 2) {
                    promoWin = 0;
                    promoDef = 0;
                    rankedSoloPoint = 0;
                    soloRank++;
                    rankSolo.setText(division[soloRank]);
                    pointsSolo.setText(String.valueOf(rankedSoloPoint));
                    promoDialogSolo.dismiss();
                } else if (promoWin == 2 && promoDef == 1) {
                    promoWin = 0;
                    promoDef = 0;
                    rankedSoloPoint = 0;
                    soloRank++;
                    rankSolo.setText(division[soloRank]);
                    pointsSolo.setText(String.valueOf(rankedSoloPoint));
                    promoDialogSolo.dismiss();
                }
            }
        });
        defeatBtnSolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (promoWin == 0 && promoDef == 0) {
                    progression.setText("✗     o     o     o     o");
                    promoDef++;
                } else if (promoDef == 1 && promoWin == 0) {
                    progression.setText("✗     ✗     o     o     o");
                    promoDef++;
                } else if (promoDef == 0 && promoWin == 1) {
                    progression.setText("✓     ✗     o     o     o");
                    promoDef++;
                } else if (promoDef == 0 && promoWin == 2) {
                    progression.setText("✓     ✓     ✗     o     o");
                    promoDef++;
                } else if (promoDef == 1 && promoWin == 2 && progression.getText() == "✓     ✓     ✗     o     o") {
                    progression.setText("✓     ✓     ✗     ✗     o");
                    promoDef++;
                } else if (promoDef == 1 && promoWin == 2 && progression.getText() == "✓     ✗     ✓     o     o") {
                    progression.setText("✓     ✗     ✓     ✗     o");
                    promoDef++;
                } else if (promoDef == 1 && promoWin == 2 && progression.getText() == "✗     ✓     ✓     o     o") {
                    progression.setText("✗     ✓     ✓     ✗     o");
                    promoDef++;
                } else if (promoDef == 1 && promoWin == 1 && progression.getText() == "✓     ✗     o     o     o") {
                    progression.setText("✓     ✗     ✗     o     o");
                    promoDef++;
                } else if (promoDef == 1 && promoWin == 1 && progression.getText() == "✗     ✓     o     o     o") {
                    progression.setText("✗     ✓     ✗     o     o");
                    promoDef++;
                } else if (promoDef == 2 && promoWin == 0) {
                    progression.setText("✗     ✗     ✗     o     o");
                    promoWin = 0;
                    promoDef = 0;
                    rankedSoloPoint = 80;
                    pointsSolo.setText(String.valueOf(rankedSoloPoint));
                    promoDialogSolo.dismiss();
                } else if (promoWin == 2 && promoDef == 2) {
                    promoWin = 0;
                    promoDef = 0;
                    rankedSoloPoint = 0;
                    rankedSoloPoint = 80;
                    pointsSolo.setText(String.valueOf(rankedSoloPoint));
                    promoDialogSolo.dismiss();
                } else if (promoDef == 2 && promoWin == 1) {
                    promoWin = 0;
                    promoDef = 0;
                    rankedSoloPoint = 80;
                    pointsSolo.setText(String.valueOf(rankedSoloPoint));
                    promoDialogSolo.dismiss();
                }
            }
        });
    }

    public void showDialog5Flex() {
        promoWin = 0;
        promoDef = 0;
        final Dialog promoDialogFlex = new Dialog(this);
        promoDialogFlex.setContentView(R.layout.series_dialog);
        promoDialogFlex.setCancelable(false);
        final TextView progressionFlex = promoDialogFlex.findViewById(R.id.p_text);
        progressionFlex.setText("o     o     o     o     o");
        Button victoryBtnFlex = promoDialogFlex.findViewById(R.id.v_button);
        final Button defeatBtnFlex = promoDialogFlex.findViewById(R.id.d_button);
        promoDialogFlex.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        promoDialogFlex.show();
        victoryBtnFlex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (promoWin == 0 && promoDef == 0) {
                    progressionFlex.setText("✓     o     o     o     o");
                    promoWin++;
                } else if (promoWin == 1 && promoDef == 0) {
                    progressionFlex.setText("✓     ✓     o     o     o");
                    promoWin++;
                } else if (promoWin == 0 && promoDef == 1) {
                    progressionFlex.setText("✗     ✓     o     o     o");
                    promoWin++;
                } else if (promoWin == 0 && promoDef == 2) {
                    progressionFlex.setText("✗     ✗     ✓     o     o");
                    promoWin++;
                } else if (promoWin == 1 && promoDef == 2 && progressionFlex.getText() == "✗     ✗     ✓     o     o") {
                    progressionFlex.setText("✗     ✗     ✓     ✓     o");
                    promoWin++;
                } else if (promoWin == 1 && promoDef == 2 && progressionFlex.getText() == "✗     ✓     ✗     o     o") {
                    progressionFlex.setText("✗     ✓     ✗     ✓     o");
                    promoWin++;
                } else if (promoWin == 1 && promoDef == 2 && progressionFlex.getText() == "✓     ✗     ✗     o     o") {
                    progressionFlex.setText("✓     ✗     ✗     ✓     o");
                    promoWin++;
                } else if (promoWin == 1 && promoDef == 1 && progressionFlex.getText() == "✗     ✓     o     o     o") {
                    progressionFlex.setText("✗     ✓     ✓     o     o");
                    promoWin++;
                } else if (promoWin == 1 && promoDef == 1 && progressionFlex.getText() == "✓     ✗     o     o     o") {
                    progressionFlex.setText("✓     ✗     ✓     o     o");
                    promoWin++;
                } else if (promoWin == 2 && promoDef == 0) {
                    progressionFlex.setText("✓     ✓     ✓     o     o");
                    promoWin = 0;
                    promoDef = 0;
                    rankedFlexPoint = 0;
                    flexRank++;
                    rankFlex.setText(division[flexRank]);
                    pointsFlex.setText(String.valueOf(rankedFlexPoint));
                    promoDialogFlex.dismiss();
                } else if (promoWin == 2 && promoDef == 2) {
                    promoWin = 0;
                    promoDef = 0;
                    rankedFlexPoint = 0;
                    flexRank++;
                    rankFlex.setText(division[flexRank]);
                    pointsFlex.setText(String.valueOf(rankedFlexPoint));
                    promoDialogFlex.dismiss();
                } else if (promoWin == 2 && promoDef == 1) {
                    promoWin = 0;
                    promoDef = 0;
                    rankedFlexPoint = 0;
                    flexRank++;
                    rankFlex.setText(division[flexRank]);
                    pointsFlex.setText(String.valueOf(rankedFlexPoint));
                    promoDialogFlex.dismiss();
                }
            }
        });
        defeatBtnFlex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (promoWin == 0 && promoDef == 0) {
                    progressionFlex.setText("✗     o     o     o     o");
                    promoDef++;
                } else if (promoDef == 1 && promoWin == 0) {
                    progressionFlex.setText("✗     ✗     o     o     o");
                    promoDef++;
                } else if (promoDef == 0 && promoWin == 1) {
                    progressionFlex.setText("✓     ✗     o     o     o");
                    promoDef++;
                } else if (promoDef == 0 && promoWin == 2) {
                    progressionFlex.setText("✓     ✓     ✗     o     o");
                    promoDef++;
                } else if (promoDef == 1 && promoWin == 2 && progressionFlex.getText() == "✓     ✓     ✗     o     o") {
                    progressionFlex.setText("✓     ✓     ✗     ✗     o");
                    promoDef++;
                } else if (promoDef == 1 && promoWin == 2 && progressionFlex.getText() == "✓     ✗     ✓     o     o") {
                    progressionFlex.setText("✓     ✗     ✓     ✗     o");
                    promoDef++;
                } else if (promoDef == 1 && promoWin == 2 && progressionFlex.getText() == "✗     ✓     ✓     o     o") {
                    progressionFlex.setText("✗     ✓     ✓     ✗     o");
                    promoDef++;
                } else if (promoDef == 1 && promoWin == 1 && progressionFlex.getText() == "✓     ✗     o     o     o") {
                    progressionFlex.setText("✓     ✗     ✗     o     o");
                    promoDef++;
                } else if (promoDef == 1 && promoWin == 1 && progressionFlex.getText() == "✗     ✓     o     o     o") {
                    progressionFlex.setText("✗     ✓     ✗     o     o");
                    promoDef++;
                } else if (promoDef == 2 && promoWin == 0) {
                    progressionFlex.setText("✗     ✗     ✗     o     o");
                    promoWin = 0;
                    promoDef = 0;
                    rankedFlexPoint = 80;
                    pointsFlex.setText(String.valueOf(rankedFlexPoint));
                    promoDialogFlex.dismiss();
                } else if (promoWin == 2 && promoDef == 2) {
                    promoWin = 0;
                    promoDef = 0;
                    rankedFlexPoint = 0;
                    rankedFlexPoint = 80;
                    pointsFlex.setText(String.valueOf(rankedFlexPoint));
                    promoDialogFlex.dismiss();
                } else if (promoDef == 2 && promoWin == 1) {
                    promoWin = 0;
                    promoDef = 0;
                    rankedFlexPoint = 80;
                    pointsFlex.setText(String.valueOf(rankedFlexPoint));
                    promoDialogFlex.dismiss();
                }
            }
        });
    }

    public void victorySolo(View view) {
        if (soloGamePlayed < 10) {
            soloPlacementWin++;
            soloGamePlayed++;
            placement();
        } else {
            String a = rankSolo.getText().toString();
            for (int i = 0; i < division.length; i++) {
                if (Objects.equals(a, division[i])) {
                    soloRank = i;
                }
            }

            if (soloRank > 19 && soloRank < 25) {
                rankedSoloPoint += 20;
                soloDemotion = 0;
                soloGamePlayed++;
                if (rankedSoloPoint >= 100 && soloRank == 24) {
                    rankedSoloPoint = 100;
                    displaySolo(rankedSoloPoint);
                    showDialog5();
                } else if (rankedSoloPoint >= 100) {
                    rankedSoloPoint = 100;
                    displaySolo(rankedSoloPoint);
                    showDialog();
                }
                displaySolo(rankedSoloPoint);
            } else if (soloRank == 25) {
                rankedSoloPoint += 15;
                soloDemotion = 0;
                soloGamePlayed++;
                if (rankedSoloPoint >= 100) {
                    rankedSoloPoint = 100;
                    displaySolo(rankedSoloPoint);
                    showDialog5();
                }
                displaySolo(rankedSoloPoint);
            } else if (soloRank == 26) {
                rankedSoloPoint += 10;
                soloDemotion = 0;
                soloGamePlayed++;
                displaySolo(rankedSoloPoint);
            } else {
                rankedSoloPoint += 25;
                soloDemotion = 0;
                soloGamePlayed++;
                displaySolo(rankedSoloPoint);
                if (rankedSoloPoint >= 100 && (soloRank == 4 || soloRank == 9 || soloRank == 14 || soloRank == 19)) {
                    rankedSoloPoint = 100;
                    displaySolo(rankedSoloPoint);
                    showDialog5();
                } else if (rankedSoloPoint >= 100) {
                    rankedSoloPoint = 100;
                    displaySolo(rankedSoloPoint);
                    showDialog();
                }
            }
        }
    }

    public void defeatSolo(View view) {
        if (soloGamePlayed < 10) {
            soloPlacementDef++;
            soloGamePlayed++;
            placement();
        } else {
            String a = rankSolo.getText().toString();
            for (int i = 0; i < division.length; i++) {
                if (Objects.equals(a, division[i])) {
                    soloRank = i;
                }
            }

            if (soloRank > 19 && soloRank < 25) {
                rankedSoloPoint -= 13;
                soloGamePlayed++;
                if (rankedSoloPoint <= 0) {
                    soloDemotion++;
                    rankedSoloPoint = 0;
                    if (soloDemotion == 5) {
                        soloRank--;
                        rankedSoloPoint = 80;
                        rankSolo.setText(division[soloRank]);
                        soloDemotion = 0;
                    }
                }
                displaySolo(rankedSoloPoint);
            } else if (soloRank == 25) {
                rankedSoloPoint -= 8;
                soloGamePlayed++;
                if (rankedSoloPoint <= 0) {
                    rankedSoloPoint = 0;
                    soloDemotion++;
                    if (soloDemotion == 5) {
                        soloRank--;
                        rankedSoloPoint = 80;
                        rankSolo.setText(division[soloRank]);
                        soloDemotion = 0;
                    }
                }
                displaySolo(rankedSoloPoint);
            } else if (soloRank == 26) {
                rankedSoloPoint -= 4;
                soloGamePlayed++;
                if (rankedSoloPoint <= 0) {
                    soloDemotion++;
                    rankedSoloPoint = 0;
                    if (soloDemotion == 5) {
                        soloRank--;
                        rankedSoloPoint = 80;
                        rankSolo.setText(division[soloRank]);
                        soloDemotion = 0;
                    }
                }
                displaySolo(rankedSoloPoint);
            } else {
                rankedSoloPoint -= 15;
                soloGamePlayed++;
                if (rankedSoloPoint <= 0) {
                    soloDemotion++;
                    rankedSoloPoint = 0;
                    if (soloDemotion == 5 && soloRank != 0) {
                        soloRank--;
                        rankedSoloPoint = 80;
                        rankSolo.setText(division[soloRank]);
                        soloDemotion = 0;
                    }
                }
                displaySolo(rankedSoloPoint);
            }
        }
    }

    public void victoryFlex(View view) {
        if (flexGamePlayed < 10) {
            flexPlacementWin++;
            flexGamePlayed++;
            placmentFlex();
        } else {
            String a = rankFlex.getText().toString();
            for (int i = 0; i < division.length; i++) {
                if (Objects.equals(a, division[i])) {
                    flexRank = i;
                }
            }

            if (flexRank > 19 && flexRank < 25) {
                rankedFlexPoint += 20;
                flexDemotion = 0;
                flexGamePlayed++;
                if (rankedFlexPoint >= 100 && flexRank == 24) {
                    rankedFlexPoint = 100;
                    displayFlex(rankedFlexPoint);
                    showDialog5Flex();
                } else if (rankedFlexPoint >= 100) {
                    rankedFlexPoint = 100;
                    displayFlex(rankedFlexPoint);
                    showDialogFlex();
                }
                displayFlex(rankedFlexPoint);
            } else if (flexRank == 25) {
                rankedFlexPoint += 15;
                flexDemotion = 0;
                flexGamePlayed++;
                if (rankedFlexPoint >= 100) {
                    rankedFlexPoint = 100;
                    displayFlex(rankedFlexPoint);
                    showDialog5Flex();
                }
                displayFlex(rankedFlexPoint);
            } else if (flexRank == 26) {
                rankedFlexPoint += 10;
                flexDemotion = 0;
                flexGamePlayed++;
                displayFlex(rankedFlexPoint);
            } else {
                rankedFlexPoint += 25;
                flexDemotion = 0;
                flexGamePlayed++;
                displayFlex(rankedFlexPoint);
                if (rankedFlexPoint >= 100 && (flexRank == 4 || flexRank == 9 || flexRank == 14 || flexRank == 19)) {
                    rankedFlexPoint = 100;
                    displayFlex(rankedFlexPoint);
                    showDialog5Flex();
                } else if (rankedFlexPoint >= 100) {
                    rankedFlexPoint = 100;
                    displayFlex(rankedFlexPoint);
                    showDialogFlex();
                }
            }
        }
    }

    public void defeatFlex(View view) {
        if (flexGamePlayed < 10) {
            flexPlacementDef++;
            flexGamePlayed++;
            placmentFlex();
        } else {
            String a = rankFlex.getText().toString();
            for (int i = 0; i < division.length; i++) {
                if (Objects.equals(a, division[i])) {
                    flexRank = i;
                }
            }

            if (flexRank > 19 && flexRank < 25) {
                rankedFlexPoint -= 13;
                flexGamePlayed++;
                if (rankedFlexPoint <= 0) {
                    flexDemotion++;
                    rankedFlexPoint = 0;
                    if (flexDemotion == 5) {
                        flexRank--;
                        rankedFlexPoint = 80;
                        rankFlex.setText(division[flexRank]);
                        flexDemotion = 0;
                    }
                }
                displayFlex(rankedFlexPoint);
            } else if (flexRank == 25) {
                rankedFlexPoint -= 8;
                flexGamePlayed++;
                if (rankedFlexPoint <= 0) {
                    rankedFlexPoint = 0;
                    flexDemotion++;
                    if (flexDemotion == 5) {
                        flexRank--;
                        rankedFlexPoint = 80;
                        rankFlex.setText(division[flexRank]);
                        flexDemotion = 0;
                    }
                }
                displayFlex(rankedFlexPoint);
            } else if (flexRank == 26) {
                rankedFlexPoint -= 4;
                flexGamePlayed++;
                if (rankedFlexPoint <= 0) {
                    flexDemotion++;
                    rankedFlexPoint = 0;
                    if (flexDemotion == 5) {
                        flexRank--;
                        rankedFlexPoint = 80;
                        rankFlex.setText(division[flexRank]);
                        flexDemotion = 0;
                    }
                }
                displayFlex(rankedFlexPoint);
            } else {
                rankedFlexPoint -= 15;
                flexGamePlayed++;
                if (rankedFlexPoint <= 0) {
                    flexDemotion++;
                    rankedFlexPoint = 0;
                    if (flexDemotion == 5 && flexRank != 0) {
                        flexRank--;
                        rankedFlexPoint = 80;
                        rankFlex.setText(division[flexRank]);
                        flexDemotion = 0;
                    }
                }
                displayFlex(rankedFlexPoint);
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public void remakeSolo(View view) {
        soloTemp++;
        gamesSolo.setText("Game Played:" + String.valueOf(soloGamePlayed + soloTemp));
    }

    @SuppressLint("SetTextI18n")
    public void remakeFlex(View view) {
        flexTemp++;
        gamesFlex.setText("Game Played:" + String.valueOf(flexGamePlayed + flexTemp));
    }

    @SuppressLint("SetTextI18n")
    public void placement() {
        if (soloGamePlayed == 10 && soloPlacementWin == 10) {
            int arr[] = new int[]{10, 11};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            rankSolo.setText(division[arr[select]]);
        } else if (soloGamePlayed == 10 && soloPlacementWin == 9) {
            int arr[] = new int[]{10, 9};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            rankSolo.setText(division[arr[select]]);
        } else if (soloGamePlayed == 10 && soloPlacementWin == 8) {
            int arr[] = new int[]{9, 8};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            rankSolo.setText(division[arr[select]]);
        } else if (soloGamePlayed == 10 && soloPlacementWin == 7) {
            int arr[] = new int[]{7, 8};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            rankSolo.setText(division[arr[select]]);
        } else if (soloGamePlayed == 10 && soloPlacementWin == 6) {
            int arr[] = new int[]{7, 6};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            rankSolo.setText(division[arr[select]]);
        } else if (soloGamePlayed == 10 && soloPlacementWin == 5) {
            int arr[] = new int[]{5, 6};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            rankSolo.setText(division[arr[select]]);
        } else if (soloGamePlayed == 10 && soloPlacementWin == 4) {
            int arr[] = new int[]{5, 4};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            rankSolo.setText(division[arr[select]]);
        } else if (soloGamePlayed == 10 && soloPlacementWin == 3) {
            rankSolo.setText(division[3]);
        } else if (soloGamePlayed == 10 && soloPlacementWin == 2) {
            rankSolo.setText(division[2]);
        } else if (soloGamePlayed == 10 && soloPlacementWin == 1) {
            rankSolo.setText(division[1]);
        } else if (soloGamePlayed == 10 && soloPlacementWin == 0) {
            rankSolo.setText(division[0]);
        }
        placementSolo.setText("10 Placment Games " + String.valueOf(soloPlacementWin) + "W" + String.valueOf(soloPlacementDef) + "L");
        gamesSolo.setText("Game Played:" + String.valueOf(soloGamePlayed + soloTemp));
    }

    @SuppressLint("SetTextI18n")
    public void placmentFlex() {
        if (flexGamePlayed == 10 && flexPlacementWin == 10) {
            int arr[] = new int[]{10, 11};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            rankFlex.setText(division[arr[select]]);
        } else if (flexGamePlayed == 10 && flexPlacementWin == 9) {
            int arr[] = new int[]{10, 9};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            rankFlex.setText(division[arr[select]]);
        } else if (flexGamePlayed == 10 && flexPlacementWin == 8) {
            int arr[] = new int[]{9, 8};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            rankFlex.setText(division[arr[select]]);
        } else if (flexGamePlayed == 10 && flexPlacementWin == 7) {
            int arr[] = new int[]{7, 8};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            rankFlex.setText(division[arr[select]]);
        } else if (flexGamePlayed == 10 && flexPlacementWin == 6) {
            int arr[] = new int[]{7, 6};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            rankFlex.setText(division[arr[select]]);
        } else if (flexGamePlayed == 10 && flexPlacementWin == 5) {
            int arr[] = new int[]{5, 6};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            rankFlex.setText(division[arr[select]]);
        } else if (flexGamePlayed == 10 && flexPlacementWin == 4) {
            int arr[] = new int[]{5, 4};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            rankFlex.setText(division[arr[select]]);
        } else if (flexGamePlayed == 10 && flexPlacementWin == 3) {
            rankFlex.setText(division[3]);
        } else if (flexGamePlayed == 10 && flexPlacementWin == 2) {
            rankFlex.setText(division[2]);
        } else if (flexGamePlayed == 10 && flexPlacementWin == 1) {
            rankFlex.setText(division[1]);
        } else if (flexGamePlayed == 10 && flexPlacementWin == 0) {
            rankFlex.setText(division[0]);
        }
        placementFlex.setText("10 Placment Games " + String.valueOf(flexPlacementWin) + "W" + String.valueOf(flexPlacementDef) + "L");
        gamesFlex.setText("Game Played:" + String.valueOf(flexGamePlayed + flexTemp));
    }

    @SuppressLint("SetTextI18n")
    private void displaySolo(int s) {
        pointsSolo.setText(String.valueOf(s));
        gamesSolo.setText("Game Played:" + String.valueOf(soloGamePlayed + soloTemp));
    }

    @SuppressLint("SetTextI18n")
    private void displayFlex(int f) {
        pointsFlex.setText(String.valueOf(f));
        gamesFlex.setText("Game Played:" + String.valueOf(flexGamePlayed + flexTemp));
    }

    @SuppressLint("SetTextI18n")
    public void reset(View view) {
        rankedSoloPoint = 0;
        rankedFlexPoint = 0;
        flexGamePlayed = 0;
        soloGamePlayed = 0;
        soloTemp = 0;
        flexTemp = 0;
        soloPlacementWin = 0;
        soloPlacementDef = 0;
        flexPlacementWin = 0;
        flexPlacementDef = 0;
        soloRank = 0;
        flexRank = 0;
        promoWin = 0;
        promoDef = 0;
        soloDemotion = 0;
        flexDemotion = 0;
        gamesSolo.setText("Game Played:" + String.valueOf(soloGamePlayed + soloTemp));
        pointsSolo.setText(String.valueOf(rankedSoloPoint));
        placementSolo.setText("10 Placment Games " + String.valueOf(soloPlacementWin) + "W" + String.valueOf(soloPlacementDef) + "L");
        rankSolo.setText("Unranked");
        pointsFlex.setText(String.valueOf(rankedFlexPoint));
        gamesFlex.setText("Game Played:" + String.valueOf(flexGamePlayed + flexTemp));
        placementFlex.setText("10 Placment Games " + String.valueOf(flexPlacementWin) + "W" + String.valueOf(flexPlacementDef) + "L");
        rankFlex.setText("Unranked");
    }
}
