package com.example.exercicio02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnVoltarIMC, btnVoltarFahre, btnCalc, btnConverter, btnImscreen, btnConCF;
    EditText edtAlt, edtPeso, edtCelsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CarregarTelaPrincipal();
    }

    public void CarregarTelaPrincipal(){
        setContentView(R.layout.activity_main);
        btnImscreen = findViewById(R.id.btnImscreen);
        btnConCF = findViewById(R.id.btnConCF);

        btnImscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaIMC();
            }
        });

        btnConCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaF();
            }
        });
    }

    public void CarregarTelaF(){
        setContentView(R.layout.concf);
        btnConverter = findViewById(R.id.btnConverter);
        btnVoltarFahre = findViewById(R.id.btnVoltarFahre);
        edtCelsius = findViewById(R.id.edtCelsius);

        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numVerification = edtCelsius.getText().toString();
                boolean podeCalc = true;
                double celsius = 0, fahr = 0;
                if(TextUtils.isEmpty(numVerification))
                {
                    podeCalc = false;
                    edtCelsius.setError("Este campo é obrigatório");
                } else{
                    celsius = Double.parseDouble(edtCelsius.getText().toString());
                    fahr = (celsius*1.8) + 32;
                }

                if(podeCalc)
                {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Resultado");
                    dialog.setMessage("O Resultado é: " + fahr +" Fahrenheit");
                    dialog.setNeutralButton("Fechar", null);
                    dialog.show();
                }
            }
        });

        btnVoltarFahre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPrincipal();
            }
        });

    }

    public void CarregarTelaIMC(){
        setContentView(R.layout.imscreen);
        btnCalc = findViewById(R.id.btnCalc);
        btnVoltarIMC = findViewById(R.id.btnVoltarIMC);
        edtAlt = findViewById(R.id.edtAlt);
        edtPeso = findViewById(R.id.edtPeso);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1Verification = edtAlt.getText().toString();
                String num2Verification = edtPeso.getText().toString();
                double alt = 0, peso = 0;
                boolean calc = true;

                if(TextUtils.isEmpty(num1Verification))
                {
                    calc = false;
                    edtAlt.setError("Este campo é obrigatório");
                } else {
                    alt = Double.parseDouble(edtAlt.getText().toString());
                }
                if(TextUtils.isEmpty(num2Verification))
                {
                    calc = false;
                    edtPeso.setError("Este campo é obrigatório");
                } else {
                    peso = Double.parseDouble(edtPeso.getText().toString());
                }
                if(calc)
                {
                    double result = peso/(alt*alt);
                    String imcR = "";

                    if(result < 17){
                        imcR = "Muito Abaixo do Peso";
                    } else if(result < 18.5){
                        imcR = "Abaixo do Peso";
                    } else if(result < 25){
                        imcR = "Peso Normal";
                    } else if(result < 30){
                        imcR = "Acima do peso";
                    } else if(result < 35){
                        imcR = "Obesidade Grau I";
                    }else if(result < 40){
                        imcR = "Obesidade Grau II";
                    }else{
                        imcR = "Obesidade Grau III";
                    }

                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Resultado");
                    dialog.setMessage(imcR);
                    dialog.setNeutralButton("Fechar", null);
                    dialog.show();

                }

            }
        });

        btnVoltarIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPrincipal();
            }
        });
    }


}