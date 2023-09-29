package com.example.kockadobas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewKocka1;
    private ImageView imageViewKocka2;
    private Button buttonKocka1;
    private Button buttonKocka2;
    private Button buttonDobas;
    private Button buttonReset;
    private TextView textViewEredmeny;
    private Random random = new Random();
    private String dobasText;
    private AlertDialog.Builder resetDialog;
    private Button buttonPoker;
    private LinearLayout linearLayoutOriginal;
    private LinearLayout linearLayoutPoker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonPoker.setOnClickListener(view -> {
            if (buttonPoker.getText() == "Póker") {
                linearLayoutOriginal.setVisibility(View.GONE);
                String felirat = "Back";
                buttonPoker.setText(felirat);
            }
            else {
                linearLayoutOriginal.setVisibility(View.VISIBLE);
                linearLayoutPoker.setVisibility(View.GONE);
                String felirat = "Póker";
                buttonPoker.setText(felirat);
            }
        });

        buttonKocka1.setOnClickListener(view -> {
                imageViewKocka2.setVisibility(View.GONE);
                imageViewKocka1.setImageResource(R.drawable.kocka1);
        });

        buttonKocka2.setOnClickListener(view -> {
            imageViewKocka2.setVisibility(View.VISIBLE);
            imageViewKocka1.setImageResource(R.drawable.kocka1);
            imageViewKocka2.setImageResource(R.drawable.kocka1);
        });

        buttonDobas.setOnClickListener(view -> {

            int dobas1 = random.nextInt(6);
            int dobas2 = random.nextInt(6);

            if (imageViewKocka2.getVisibility() == View.VISIBLE) {
                dobas(imageViewKocka1, dobas1);
                dobas(imageViewKocka2, dobas2);
                dobasText += "| " + (dobas1 + 1) + (dobas2 + 1) + " (" + (dobas1 + 1) + "+" + (dobas2 + 1) + ")\n";
                textViewEredmeny.setText(dobasText);

            } else {
                dobas(imageViewKocka1, dobas1);
                dobasText += "| " + (dobas1 + 1) + "\n";
                textViewEredmeny.setText(dobasText);
            }
        });

        buttonReset.setOnClickListener(view -> {
            resetDialog.show();
        });
    }

    public void init() {
        imageViewKocka1 = findViewById(R.id.imageViewKocka1);
        imageViewKocka2 = findViewById(R.id.imageViewKocka2);
        buttonKocka1 = findViewById(R.id.buttonKocka1);
        buttonKocka2 = findViewById(R.id.buttonKocka2);
        buttonDobas = findViewById(R.id.buttonDobas);
        buttonReset = findViewById(R.id.buttonReset);
        textViewEredmeny = findViewById(R.id.textViewEredmeny);
        buttonPoker = findViewById(R.id.buttonPoker);
        linearLayoutOriginal = findViewById(R.id.linearLayoutOriginal);
        linearLayoutPoker = findViewById(R.id.linearLayoutPoker);
        dobasText = "";

        resetDialog = new AlertDialog.Builder(this);

        resetDialog.setTitle("Reset")
                .setMessage("Biztos, hogy törölni szeretné az eddigi dobásokat?")
                .setNegativeButton("Nem", (dialogInterface, i) -> {

                })
                .setPositiveButton("Igen", (dialogInterface, i) -> {
                    dobasText = "";
                    textViewEredmeny.setText(dobasText);
                    imageViewKocka1.setImageResource(R.drawable.kocka1);
                    imageViewKocka2.setImageResource(R.drawable.kocka1);
                })
                .create();
    }

    public void dobas(ImageView imageview, int dobas) {
        switch (dobas) {
            case 0:
                imageview.setImageResource(R.drawable.kocka1);
                break;
            case 1:
                imageview.setImageResource(R.drawable.kocka2);
                break;
            case 2:
                imageview.setImageResource(R.drawable.kocka3);
                break;
            case 3:
                imageview.setImageResource(R.drawable.kocka4);
                break;
            case 4:
                imageview.setImageResource(R.drawable.kocka5);
                break;
            case 5:
                imageview.setImageResource(R.drawable.kocka6);
                break;
        }
    }
}