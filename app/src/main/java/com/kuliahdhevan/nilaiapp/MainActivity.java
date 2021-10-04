package com.kuliahdhevan.nilaiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nameEdt, nimEdt, nTugasEdt, nUtsEdt, nUasEdt;
    TextView nimText, nameText, nTugasText, nUtsText, nUasText, nAkhirText, nHurufText, predikatText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nimText = findViewById(R.id.nimText);
        nameText = findViewById(R.id.nameText);
        nTugasText = findViewById(R.id.nTugasText);
        nUtsText = findViewById(R.id.nUtsText);
        nUasText = findViewById(R.id.nUasText);
        nAkhirText = findViewById(R.id.nAkhirText);
        nHurufText = findViewById(R.id.nHurufText);
        predikatText = findViewById(R.id.predikatText);
        nameEdt = findViewById(R.id.nameEdt);
        nimEdt = findViewById(R.id.nimEdt);
        nTugasEdt = findViewById(R.id.nTugasEdt);
        nUtsEdt = findViewById(R.id.nUtsEdt);
        nUasEdt = findViewById(R.id.nUasEdt);
    }

    public void process(View view) {
        double nTugas, nUts, nUas, nilaiAkhir = 0;
        nTugas = Double.valueOf(nTugasEdt.getText().toString());
        nUts = Double.valueOf(nUtsEdt.getText().toString());
        nUas = Double.valueOf(nUasEdt.getText().toString());
        nilaiAkhir = (nTugas * 0.2) + (nUts * 0.35) + (nUas * 0.45);

        nimText.setText(nimEdt.getText().toString());
        nameText.setText(nameEdt.getText().toString());
        nTugasText.setText(String.valueOf(nTugas) + "\t" + "20%\t: " + String.valueOf(nTugas * 0.2) );
        nUtsText.setText(String.valueOf(nUts) + "\t" + "35%\t: " + String.valueOf(nUts * 0.35) );
        nUasText.setText(String.valueOf(nUas) + "\t" + "45%\t: " + String.valueOf(nUas * 0.45) );
        nAkhirText.setText(String.valueOf(nilaiAkhir));
        String nHuruf = nilaiHuruf(nilaiAkhir);
        nHurufText.setText(nHuruf);
        String predikat = getPredikat(nHuruf);
        predikatText.setText(predikat);

    }

    public String nilaiHuruf(double nilai) {
        if(nilai >= 85) {
            return "A";
        } else if(nilai >=70) {
            return "B";
        } else if (nilai >= 60) {
            return "C";
        } else if (nilai >= 40) {
            return "D";
        } else {
            return "E";
        }
    }

    public String getPredikat(String nilaiHuruf) {
        switch (nilaiHuruf) {
            case "A":
                return "Apik";
            case "B":
                return "Baik";
            case "C":
                return "Cukup";
            case "D":
                return "Dablek";
            case "E":
                return "Elek";
            default:
                return "-";
        }
    }
}