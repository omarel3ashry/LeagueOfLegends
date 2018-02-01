package com.example.android.practiceset2;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //Solo
    TextView GS;
    TextView SP;
    TextView PS;
    TextView RS;
    //Flex
    TextView GF;
    TextView FP;
    TextView PF;
    TextView RF;
    int solo = 0, flex = 0, gamef = 0, games = 0, temps = 0,
            tempf = 0, vs = 0, ds = 0, vf = 0, df = 0, rank = 0, rankf = 0, veee = 0, deee = 0, dems = 0, demf = 0;
    String div[] = {"Bronze V", "Bronze IV", "Bronze III", "Bronze II", "Bronze I",
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
        GS = (TextView) findViewById(R.id.gameS);
        SP = (TextView) findViewById(R.id.point_solo);
        PS = (TextView) findViewById(R.id.plac_s);
        RS = (TextView) findViewById(R.id.rank_solo);
        //Flex
        GF = (TextView) findViewById(R.id.gameF);
        FP = (TextView) findViewById(R.id.point_flex);
        PF = (TextView) findViewById(R.id.plac_f);
        RF = (TextView) findViewById(R.id.rank_flex);
    }

    public void show_dialog() {
        veee = 0;
        deee = 0;
        final Dialog sdialog = new Dialog(this);
        sdialog.setContentView(R.layout.series_dialog);
        sdialog.setCancelable(false);
        final TextView progr = (TextView) sdialog.findViewById(R.id.p_text);
        progr.setText("o            o            o");
        Button vicb = (Button) sdialog.findViewById(R.id.v_button);
        final Button defb = (Button) sdialog.findViewById(R.id.d_button);
        sdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        sdialog.show();
        vicb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (veee == 0 && deee == 0) {
                    progr.setText("✓            o            o");
                    veee++;
                } else if (veee == 1 && deee == 0) {
                    veee = 0;
                    deee = 0;
                    progr.setText("✓            ✓            o");
                    rank++;
                    solo = 0;
                    RS.setText(div[rank]);
                    SP.setText(String.valueOf(solo));
                    sdialog.dismiss();
                } else if (veee == 0 && deee == 1) {
                    progr.setText("✗            ✓            o");
                    veee++;
                } else if (veee == 1 && deee == 1) {
                    veee = 0;
                    deee = 0;
                    solo = 0;
                    rank++;
                    RS.setText(div[rank]);
                    SP.setText(String.valueOf(solo));
                    sdialog.dismiss();
                }
            }
        });
        defb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deee == 0 && veee == 0) {
                    progr.setText("✗            o            o");
                    deee++;
                } else if (deee == 1 && veee == 0) {
                    veee = 0;
                    deee = 0;
                    progr.setText("✗            ✗            o");
                    solo = 80;
                    RS.setText(div[rank]);
                    SP.setText(String.valueOf(solo));
                    sdialog.dismiss();
                } else if (veee == 1 && deee == 0) {
                    progr.setText("✓            ✗            o");
                    deee++;
                } else if (deee == 1 && veee == 1) {
                    veee = 0;
                    deee = 0;
                    solo = 80;
                    RS.setText(div[rank]);
                    SP.setText(String.valueOf(solo));
                    sdialog.dismiss();
                }
            }
        });

    }

    public void show_dialog_f() {
        veee = 0;
        deee = 0;
        final Dialog fdialog = new Dialog(this);
        fdialog.setContentView(R.layout.series_dialog);
        fdialog.setCancelable(false);
        final TextView progr = (TextView) fdialog.findViewById(R.id.p_text);
        progr.setText("o            o            o");
        Button vicb = (Button) fdialog.findViewById(R.id.v_button);
        final Button defb = (Button) fdialog.findViewById(R.id.d_button);
        fdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fdialog.show();
        vicb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (veee == 0 && deee == 0) {
                    progr.setText("✓            o            o");
                    veee++;
                } else if (veee == 1 && deee == 0) {
                    veee = 0;
                    deee = 0;
                    progr.setText("✓            ✓            o");
                    rankf++;
                    flex = 0;
                    RF.setText(div[rankf]);
                    FP.setText(String.valueOf(flex));
                    fdialog.dismiss();
                } else if (veee == 0 && deee == 1) {
                    progr.setText("✗            ✓            o");
                    veee++;
                } else if (veee == 1 && deee == 1) {
                    veee = 0;
                    deee = 0;
                    flex = 0;
                    rankf++;
                    RF.setText(div[rankf]);
                    FP.setText(String.valueOf(flex));
                    fdialog.dismiss();
                }
            }
        });
        defb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deee == 0 && veee == 0) {
                    progr.setText("✗            o            o");
                    deee++;
                } else if (deee == 1 && veee == 0) {
                    veee = 0;
                    deee = 0;
                    progr.setText("✗            ✗            o");
                    flex = 80;
                    RF.setText(div[rankf]);
                    FP.setText(String.valueOf(flex));
                    fdialog.dismiss();
                } else if (veee == 1 && deee == 0) {
                    progr.setText("✓            ✗            o");
                    deee++;
                } else if (deee == 1 && veee == 1) {
                    veee = 0;
                    deee = 0;
                    flex = 80;
                    RF.setText(div[rankf]);
                    FP.setText(String.valueOf(flex));
                    fdialog.dismiss();
                }
            }
        });

    }

    public void show_dialog_5() {
        veee = 0;
        deee = 0;
        final Dialog sdialog = new Dialog(this);
        sdialog.setContentView(R.layout.series_dialog);
        sdialog.setCancelable(false);
        final TextView progr = (TextView) sdialog.findViewById(R.id.p_text);
        progr.setText("o     o     o     o     o");
        Button vicb = (Button) sdialog.findViewById(R.id.v_button);
        final Button defb = (Button) sdialog.findViewById(R.id.d_button);
        sdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        sdialog.show();
        vicb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (veee == 0 && deee == 0) {
                    progr.setText("✓     o     o     o     o");
                    veee++;
                } else if (veee == 1 && deee == 0) {
                    progr.setText("✓     ✓     o     o     o");
                    veee++;
                } else if (veee == 0 && deee == 1) {
                    progr.setText("✗     ✓     o     o     o");
                    veee++;
                } else if (veee == 0 && deee == 2) {
                    progr.setText("✗     ✗     ✓     o     o");
                    veee++;
                } else if (veee == 1 && deee == 2 && progr.getText() == "✗     ✗     ✓     o     o") {
                    progr.setText("✗     ✗     ✓     ✓     o");
                    veee++;
                } else if (veee == 1 && deee == 2 && progr.getText() == "✗     ✓     ✗     o     o") {
                    progr.setText("✗     ✓     ✗     ✓     o");
                    veee++;
                } else if (veee == 1 && deee == 2 && progr.getText() == "✓     ✗     ✗     o     o") {
                    progr.setText("✓     ✗     ✗     ✓     o");
                    veee++;
                } else if (veee == 1 && deee == 1 && progr.getText() == "✗     ✓     o     o     o") {
                    progr.setText("✗     ✓     ✓     o     o");
                    veee++;
                } else if (veee == 1 && deee == 1 && progr.getText() == "✓     ✗     o     o     o") {
                    progr.setText("✓     ✗     ✓     o     o");
                    veee++;
                } else if (veee == 2 && deee == 0) {
                    progr.setText("✓     ✓     ✓     o     o");
                    veee = 0;
                    deee = 0;
                    solo = 0;
                    rank++;
                    RS.setText(div[rank]);
                    SP.setText(String.valueOf(solo));
                    sdialog.dismiss();
                } else if (veee == 2 && deee == 2) {
                    veee = 0;
                    deee = 0;
                    solo = 0;
                    rank++;
                    RS.setText(div[rank]);
                    SP.setText(String.valueOf(solo));
                    sdialog.dismiss();
                } else if (veee == 2 && deee == 1) {
                    veee = 0;
                    deee = 0;
                    solo = 0;
                    rank++;
                    RS.setText(div[rank]);
                    SP.setText(String.valueOf(solo));
                    sdialog.dismiss();
                }
            }
        });
        defb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (veee == 0 && deee == 0) {
                    progr.setText("✗     o     o     o     o");
                    deee++;
                } else if (deee == 1 && veee == 0) {
                    progr.setText("✗     ✗     o     o     o");
                    deee++;
                } else if (deee == 0 && veee == 1) {
                    progr.setText("✓     ✗     o     o     o");
                    deee++;
                } else if (deee == 0 && veee == 2) {
                    progr.setText("✓     ✓     ✗     o     o");
                    deee++;
                } else if (deee == 1 && veee == 2 && progr.getText() == "✓     ✓     ✗     o     o") {
                    progr.setText("✓     ✓     ✗     ✗     o");
                    deee++;
                } else if (deee == 1 && veee == 2 && progr.getText() == "✓     ✗     ✓     o     o") {
                    progr.setText("✓     ✗     ✓     ✗     o");
                    deee++;
                } else if (deee == 1 && veee == 2 && progr.getText() == "✗     ✓     ✓     o     o") {
                    progr.setText("✗     ✓     ✓     ✗     o");
                    deee++;
                } else if (deee == 1 && veee == 1 && progr.getText() == "✓     ✗     o     o     o") {
                    progr.setText("✓     ✗     ✗     o     o");
                    deee++;
                } else if (deee == 1 && veee == 1 && progr.getText() == "✗     ✓     o     o     o") {
                    progr.setText("✗     ✓     ✗     o     o");
                    deee++;
                } else if (deee == 2 && veee == 0) {
                    progr.setText("✗     ✗     ✗     o     o");
                    veee = 0;
                    deee = 0;
                    solo = 80;
                    SP.setText(String.valueOf(solo));
                    sdialog.dismiss();
                } else if (veee == 2 && deee == 2) {
                    veee = 0;
                    deee = 0;
                    solo = 0;
                    solo = 80;
                    SP.setText(String.valueOf(solo));
                    sdialog.dismiss();
                } else if (deee == 2 && veee == 1) {
                    veee = 0;
                    deee = 0;
                    solo = 80;
                    SP.setText(String.valueOf(solo));
                    sdialog.dismiss();
                }
            }
        });


    }

    public void show_dialog_5_f() {
        veee = 0;
        deee = 0;
        final Dialog fdialog = new Dialog(this);
        fdialog.setContentView(R.layout.series_dialog);
        fdialog.setCancelable(false);
        final TextView progr = (TextView) fdialog.findViewById(R.id.p_text);
        progr.setText("o     o     o     o     o");
        Button vicb = (Button) fdialog.findViewById(R.id.v_button);
        final Button defb = (Button) fdialog.findViewById(R.id.d_button);
        fdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fdialog.show();
        vicb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (veee == 0 && deee == 0) {
                    progr.setText("✓     o     o     o     o");
                    veee++;
                } else if (veee == 1 && deee == 0) {
                    progr.setText("✓     ✓     o     o     o");
                    veee++;
                } else if (veee == 0 && deee == 1) {
                    progr.setText("✗     ✓     o     o     o");
                    veee++;
                } else if (veee == 0 && deee == 2) {
                    progr.setText("✗     ✗     ✓     o     o");
                    veee++;
                } else if (veee == 1 && deee == 2 && progr.getText() == "✗     ✗     ✓     o     o") {
                    progr.setText("✗     ✗     ✓     ✓     o");
                    veee++;
                } else if (veee == 1 && deee == 2 && progr.getText() == "✗     ✓     ✗     o     o") {
                    progr.setText("✗     ✓     ✗     ✓     o");
                    veee++;
                } else if (veee == 1 && deee == 2 && progr.getText() == "✓     ✗     ✗     o     o") {
                    progr.setText("✓     ✗     ✗     ✓     o");
                    veee++;
                } else if (veee == 1 && deee == 1 && progr.getText() == "✗     ✓     o     o     o") {
                    progr.setText("✗     ✓     ✓     o     o");
                    veee++;
                } else if (veee == 1 && deee == 1 && progr.getText() == "✓     ✗     o     o     o") {
                    progr.setText("✓     ✗     ✓     o     o");
                    veee++;
                } else if (veee == 2 && deee == 0) {
                    progr.setText("✓     ✓     ✓     o     o");
                    veee = 0;
                    deee = 0;
                    flex = 0;
                    rankf++;
                    RF.setText(div[rankf]);
                    FP.setText(String.valueOf(flex));
                    fdialog.dismiss();
                } else if (veee == 2 && deee == 2) {
                    veee = 0;
                    deee = 0;
                    flex = 0;
                    rankf++;
                    RF.setText(div[rankf]);
                    FP.setText(String.valueOf(flex));
                    fdialog.dismiss();
                } else if (veee == 2 && deee == 1) {
                    veee = 0;
                    deee = 0;
                    flex = 0;
                    rankf++;
                    RF.setText(div[rankf]);
                    FP.setText(String.valueOf(flex));
                    fdialog.dismiss();
                }
            }
        });
        defb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (veee == 0 && deee == 0) {
                    progr.setText("✗     o     o     o     o");
                    deee++;
                } else if (deee == 1 && veee == 0) {
                    progr.setText("✗     ✗     o     o     o");
                    deee++;
                } else if (deee == 0 && veee == 1) {
                    progr.setText("✓     ✗     o     o     o");
                    deee++;
                } else if (deee == 0 && veee == 2) {
                    progr.setText("✓     ✓     ✗     o     o");
                    deee++;
                } else if (deee == 1 && veee == 2 && progr.getText() == "✓     ✓     ✗     o     o") {
                    progr.setText("✓     ✓     ✗     ✗     o");
                    deee++;
                } else if (deee == 1 && veee == 2 && progr.getText() == "✓     ✗     ✓     o     o") {
                    progr.setText("✓     ✗     ✓     ✗     o");
                    deee++;
                } else if (deee == 1 && veee == 2 && progr.getText() == "✗     ✓     ✓     o     o") {
                    progr.setText("✗     ✓     ✓     ✗     o");
                    deee++;
                } else if (deee == 1 && veee == 1 && progr.getText() == "✓     ✗     o     o     o") {
                    progr.setText("✓     ✗     ✗     o     o");
                    deee++;
                } else if (deee == 1 && veee == 1 && progr.getText() == "✗     ✓     o     o     o") {
                    progr.setText("✗     ✓     ✗     o     o");
                    deee++;
                } else if (deee == 2 && veee == 0) {
                    progr.setText("✗     ✗     ✗     o     o");
                    veee = 0;
                    deee = 0;
                    flex = 80;
                    FP.setText(String.valueOf(flex));
                    fdialog.dismiss();
                } else if (veee == 2 && deee == 2) {
                    veee = 0;
                    deee = 0;
                    flex = 0;
                    flex = 80;
                    FP.setText(String.valueOf(flex));
                    fdialog.dismiss();
                } else if (deee == 2 && veee == 1) {
                    veee = 0;
                    deee = 0;
                    flex = 80;
                    FP.setText(String.valueOf(flex));
                    fdialog.dismiss();
                }
            }
        });
    }

    public void victory_solo(View view) {
        if (games < 10) {
            vs++;
            games++;
            placment();

        } else {
            String a = RS.getText().toString();
            for (int i = 0; i < div.length; i++) {
                if (a == div[i]) {
                    rank = i;
                }
            }

            if (rank > 19 && rank < 25) {
                solo += 20;
                dems = 0;
                games++;
                if (solo >= 100 && rank == 24) {
                    solo = 100;
                    display_solo(solo);
                    show_dialog_5();
                } else if (solo >= 100) {
                    solo = 100;
                    display_solo(solo);
                    show_dialog();
                }
                display_solo(solo);
            } else if (rank == 25) {
                solo += 15;
                dems = 0;
                games++;
                if (solo >= 100) {
                    solo = 100;
                    display_solo(solo);
                    show_dialog_5();
                }
                display_solo(solo);
            } else if (rank == 26) {
                solo += 10;
                dems = 0;
                games++;
                display_solo(solo);
            } else {
                solo += 25;
                dems = 0;
                games++;
                display_solo(solo);
                if (solo >= 100 && (rank == 4 || rank == 9 || rank == 14 || rank == 19)) {
                    solo = 100;
                    display_solo(solo);
                    show_dialog_5();
                } else if (solo >= 100) {
                    solo = 100;
                    display_solo(solo);
                    show_dialog();
                }
            }
        }
    }

    public void defeat_solo(View view) {
        if (games < 10) {
            ds++;
            games++;
            placment();
        } else {

            String a = RS.getText().toString();
            for (int i = 0; i < div.length; i++) {
                if (a == div[i]) {
                    rank = i;
                }
            }
            if (rank > 19 && rank < 25) {
                solo -= 13;
                games++;
                if (solo <= 0) {
                    dems++;
                    solo = 0;
                    if (dems == 5) {
                        rank--;
                        solo = 80;
                        RS.setText(div[rank]);
                        dems = 0;
                    }
                }
                display_solo(solo);
            } else if (rank == 25) {
                solo -= 8;
                games++;
                if (solo <= 0) {
                    solo = 0;
                    dems++;
                    if (dems == 5) {
                        rank--;
                        solo = 80;
                        RS.setText(div[rank]);
                        dems = 0;
                    }
                }
                display_solo(solo);
            } else if (rank == 26) {
                solo -= 4;
                games++;
                if (solo <= 0) {
                    dems++;
                    solo = 0;
                    if (dems == 5) {
                        rank--;
                        solo = 80;
                        RS.setText(div[rank]);
                        dems = 0;
                    }
                }
                display_solo(solo);
            } else {
                solo -= 15;
                games++;
                if (solo <= 0) {
                    dems++;
                    solo = 0;
                    if (dems == 5 && rank != 0) {
                        rank--;
                        solo = 80;
                        RS.setText(div[rank]);
                        dems = 0;
                    }
                }
                display_solo(solo);
            }
        }
    }

    public void victory_flex(View view) {
        if (gamef < 10) {
            vf++;
            gamef++;
            placment_f();

        } else {
            String a = RF.getText().toString();
            for (int i = 0; i < div.length; i++) {
                if (a == div[i]) {
                    rankf = i;
                }
            }
            if (rankf > 19 && rankf < 25) {
                flex += 20;
                demf = 0;
                gamef++;
                if (flex >= 100 && rankf == 24) {
                    flex = 100;
                    display_flex(flex);
                    show_dialog_5_f();
                } else if (flex >= 100) {
                    flex = 100;
                    display_flex(flex);
                    show_dialog_f();
                }
                display_flex(flex);
            } else if (rankf == 25) {
                flex += 15;
                demf = 0;
                gamef++;
                if (flex >= 100) {
                    flex = 100;
                    display_flex(flex);
                    show_dialog_5_f();
                }
                display_flex(flex);
            } else if (rankf == 26) {
                flex += 10;
                demf = 0;
                gamef++;
                display_flex(flex);
            } else {
                flex += 25;
                demf = 0;
                gamef++;
                display_flex(flex);
                if (flex >= 100 && (rankf == 4 || rankf == 9 || rankf == 14 || rankf == 19)) {
                    flex = 100;
                    display_flex(flex);
                    show_dialog_5_f();
                } else if (flex >= 100) {
                    flex = 100;
                    display_flex(flex);
                    show_dialog_f();
                }
            }
        }
    }

    public void defeat_flex(View view) {
        if (gamef < 10) {
            df++;
            gamef++;
            placment_f();
        } else {

            String a = RF.getText().toString();
            for (int i = 0; i < div.length; i++) {
                if (a == div[i]) {
                    rankf = i;
                }
            }
            if (rankf > 19 && rankf < 25) {
                flex -= 13;
                gamef++;
                if (flex <= 0) {
                    demf++;
                    flex = 0;
                    if (demf == 5) {
                        rankf--;
                        flex = 80;
                        RF.setText(div[rankf]);
                        demf = 0;
                    }
                }
                display_flex(flex);
            } else if (rankf == 25) {
                flex -= 8;
                gamef++;
                if (flex <= 0) {
                    flex = 0;
                    demf++;
                    if (demf == 5) {
                        rankf--;
                        flex = 80;
                        RF.setText(div[rankf]);
                        demf = 0;
                    }
                }
                display_flex(flex);
            } else if (rankf == 26) {
                flex -= 4;
                gamef++;
                if (flex <= 0) {
                    demf++;
                    flex = 0;
                    if (demf == 5) {
                        rankf--;
                        flex = 80;
                        RF.setText(div[rankf]);
                        demf = 0;
                    }
                }
                display_flex(flex);
            } else {
                flex -= 15;
                gamef++;
                if (flex <= 0) {
                    demf++;
                    flex = 0;
                    if (demf == 5 && rankf != 0) {
                        rankf--;
                        flex = 80;
                        RF.setText(div[rankf]);
                        demf = 0;
                    }
                }
                display_flex(flex);
            }
        }
    }

    public void remake_solo(View view) {
        temps++;
        GS.setText("Game Played:" + String.valueOf(games + temps));
    }

    public void remake_flex(View view) {
        tempf++;
        GF.setText("Game Played:" + String.valueOf(gamef + tempf));
    }

    public void placment() {
        if (games == 10 && vs == 10) {
            int arr[] = new int[]{10, 11};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            RS.setText(div[arr[select]]);
        } else if (games == 10 && vs == 9) {
            int arr[] = new int[]{10, 9};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            RS.setText(div[arr[select]]);
        } else if (games == 10 && vs == 8) {
            int arr[] = new int[]{9, 8};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            RS.setText(div[arr[select]]);
        } else if (games == 10 && vs == 7) {
            int arr[] = new int[]{7, 8};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            RS.setText(div[arr[select]]);
        } else if (games == 10 && vs == 6) {
            int arr[] = new int[]{7, 6};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            RS.setText(div[arr[select]]);
        } else if (games == 10 && vs == 5) {
            int arr[] = new int[]{5, 6};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            RS.setText(div[arr[select]]);
        } else if (games == 10 && vs == 4) {
            int arr[] = new int[]{5, 4};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            RS.setText(div[arr[select]]);
        } else if (games == 10 && vs == 3) {
            RS.setText(div[3]);
        } else if (games == 10 && vs == 2) {
            RS.setText(div[2]);
        } else if (games == 10 && vs == 1) {
            RS.setText(div[1]);
        } else if (games == 10 && vs == 0) {
            RS.setText(div[0]);
        }
        PS.setText("10 Placment Games " + String.valueOf(vs) + "W" + String.valueOf(ds) + "L");
        GS.setText("Game Played:" + String.valueOf(games + temps));
    }

    public void placment_f() {
        if (gamef == 10 && vf == 10) {
            int arr[] = new int[]{10, 11};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            RF.setText(div[arr[select]]);
        } else if (gamef == 10 && vf == 9) {
            int arr[] = new int[]{10, 9};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            RF.setText(div[arr[select]]);
        } else if (gamef == 10 && vf == 8) {
            int arr[] = new int[]{9, 8};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            RF.setText(div[arr[select]]);
        } else if (gamef == 10 && vf == 7) {
            int arr[] = new int[]{7, 8};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            RF.setText(div[arr[select]]);
        } else if (gamef == 10 && vf == 6) {
            int arr[] = new int[]{7, 6};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            RF.setText(div[arr[select]]);
        } else if (gamef == 10 && vf == 5) {
            int arr[] = new int[]{5, 6};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            RF.setText(div[arr[select]]);
        } else if (gamef == 10 && vf == 4) {
            int arr[] = new int[]{5, 4};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            RF.setText(div[arr[select]]);
        } else if (gamef == 10 && vf == 3) {
            RF.setText(div[3]);
        } else if (gamef == 10 && vf == 2) {
            RF.setText(div[2]);
        } else if (gamef == 10 && vf == 1) {
            RF.setText(div[1]);
        } else if (gamef == 10 && vf == 0) {
            RF.setText(div[0]);
        }
        PF.setText("10 Placment gamef " + String.valueOf(vf) + "W" + String.valueOf(df) + "L");
        GF.setText("Game Played:" + String.valueOf(gamef + tempf));
    }

    private void display_solo(int s) {
        SP.setText(String.valueOf(s));
        GS.setText("Game Played:" + String.valueOf(games + temps));
    }

    private void display_flex(int f) {
        FP.setText(String.valueOf(f));
        GF.setText("Game Played:" + String.valueOf(gamef + tempf));
    }

    public void reset(View view) {
        solo = 0;
        flex = 0;
        gamef = 0;
        games = 0;
        temps = 0;
        tempf = 0;
        vs = 0;
        ds = 0;
        vf = 0;
        df = 0;
        rank = 0;
        rankf = 0;
        veee = 0;
        deee = 0;
        dems = 0;
        demf = 0;
        GS.setText("Game Played:" + String.valueOf(games + temps));
        SP.setText(String.valueOf(solo));
        PS.setText("10 Placment Games " + String.valueOf(vs) + "W" + String.valueOf(ds) + "L");
        RS.setText("Unranked");
        FP.setText(String.valueOf(flex));
        GF.setText("Game Played:" + String.valueOf(gamef + tempf));
        PF.setText("10 Placment Games " + String.valueOf(vf) + "W" + String.valueOf(df) + "L");
        RF.setText("Unranked");
    }
}
