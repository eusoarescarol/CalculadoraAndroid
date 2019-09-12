package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private double num1, num2;
    private String operacao;
    private EditText edtValor;
    private Button btnum, btndois, btntres, btnquatro, btncinco, btnseis, btnsete, btnoito, btnnove, btnzero;
    private Button btnsomar, btnsubtrair, btndividir, btnmutiplicar;
    private Button btnvirgula, btnlimpar, btncalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValor = findViewById(R.id.edtValor);


        btnum = findViewById(R.id.btnum);
        btndois = findViewById(R.id.btndois);
        btntres = findViewById(R.id.btntres);
        btnquatro = findViewById(R.id.btnquatro);
        btncinco = findViewById(R.id.btncinco);
        btnseis = findViewById(R.id.btnseis);
        btnsete = findViewById(R.id.btnsete);
        btnoito = findViewById(R.id.btnoito);
        btnnove = findViewById(R.id.btnnove);
        btnzero = findViewById(R.id.btnzero);

        btnvirgula = findViewById(R.id.btnvirgula);

        btnsomar = findViewById(R.id.btnsomar);
        btnsubtrair = findViewById(R.id.btnsubtrair);
        btndividir = findViewById(R.id.btndividir);
        btnmutiplicar = findViewById(R.id.btnmultiplicar);

        btncalcular = findViewById(R.id.btncalcular);

        btnlimpar = findViewById(R.id.btnlimpar);

        btnum.setOnClickListener(this);
        btndois.setOnClickListener(this);
        btntres.setOnClickListener(this);
        btnquatro.setOnClickListener(this);
        btncinco.setOnClickListener(this);
        btnseis.setOnClickListener(this);
        btnsete.setOnClickListener(this);
        btnoito.setOnClickListener(this);
        btnnove.setOnClickListener(this);
        btnzero.setOnClickListener(this);

        btnvirgula.setOnClickListener(this);

        btnsomar.setOnClickListener(this);
        btnsubtrair.setOnClickListener(this);
        btnmutiplicar.setOnClickListener(this);
        btndividir.setOnClickListener(this);

        btncalcular.setOnClickListener(this);

        btnlimpar.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    private void tecladoNumerico(int i) {

        if (edtValor.getText().toString().equals("0.0")) {

            limpar();
            edtValor.setText(edtValor.getText().toString() + String.valueOf(i));
        } else {
            edtValor.setText(edtValor.getText().toString() + String.valueOf(i));
        }

    }

    @SuppressLint("SetTextI18n")
    private void virgula(String ponto) {
        edtValor.setText(edtValor.getText().toString() + ponto);
    }

    private void operacao(String operacao) {
        this.operacao = operacao;
        if (operacao == "+") {
            num1 = Double.parseDouble(edtValor.getText().toString());
            limpar();
        } else if (operacao == "-") {
            num1 = Double.parseDouble(edtValor.getText().toString());
            limpar();
        } else if (operacao == "*") {
            num1 = Double.parseDouble(edtValor.getText().toString());
            limpar();
        } else if (operacao == "/") {
            num1 = Double.parseDouble(edtValor.getText().toString());
            limpar();
        }
    }

    private void calcular() {

        if (edtValor.getText().toString().trim().equals("")) {
            edtValor.setText(String.valueOf(num2));
        } else {
            if (operacao == "+") {
                num2 = num1 + Double.parseDouble(edtValor.getText().toString());
            } else if (operacao == "-") {
                num2 = num1 - Double.parseDouble(edtValor.getText().toString());
            } else if (operacao == "*") {
                num2 = num1 * Double.parseDouble(edtValor.getText().toString());
            } else if (operacao == "/") {
                if (num1 == 0) {
                    num2 = 0;
                } else if (Double.parseDouble(edtValor.getText().toString()) == 0) {
                    Toast.makeText(getApplicationContext(),"Não é possivel dividir por zero", Toast.LENGTH_SHORT).show();
                } else {
                    num2 = num1 / Double.parseDouble(edtValor.getText().toString());
                }
            }

        }
            edtValor.setText(String.valueOf(num2));


    }

        private void limpar ()
        {
            edtValor.setText("");
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnum:
                    tecladoNumerico(1);
                    break;
                case R.id.btndois:
                    tecladoNumerico(2);
                    break;
                case R.id.btntres:
                    tecladoNumerico(3);
                    break;
                case R.id.btnquatro:
                    tecladoNumerico(4);
                    break;
                case R.id.btncinco:
                    tecladoNumerico(5);
                    break;
                case R.id.btnseis:
                    tecladoNumerico(6);
                    break;
                case R.id.btnsete:
                    tecladoNumerico(7);
                    break;
                case R.id.btnoito:
                    tecladoNumerico(8);
                    break;
                case R.id.btnnove:
                    tecladoNumerico(9);
                    break;
                case R.id.btnzero:
                    tecladoNumerico(0);
                    break;
                case R.id.btnvirgula:
                    virgula(".");
                    break;
                case R.id.btnsomar:
                    operacao("+");
                    break;
                case  R.id.btnsubtrair:
                    operacao("-");
                    break;
                case R.id.btnmultiplicar:
                    operacao("*");
                    break;
                case R.id.btndividir:
                    operacao("/");
                    break;
                case R.id.btncalcular:
                    calcular();
                    break;
                case R.id.btnlimpar:
                    limpar();
                    break;
            }
        }


    }