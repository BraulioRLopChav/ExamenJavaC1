package com.example.examenc1areaperimetro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RectanguloActivity extends AppCompatActivity {

    private TextView nombre_et;
    private EditText base_et;
    private EditText altura_et;
    private TextView area_tv;
    private TextView perimetro_tv;
    private Button calcular_btn;
    private Button regresar_btn;
    private Button limpiar_btn;
    Rectangulo rectangulo = new Rectangulo();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);
        nombre_et = findViewById(R.id.nombre_et);
        base_et = findViewById(R.id.base_et);
        altura_et = findViewById(R.id.altura_et);
        area_tv = findViewById(R.id.area_tv);
        perimetro_tv = findViewById(R.id.perimetro_tv);
        calcular_btn = findViewById(R.id.calcular_btn);
        regresar_btn = findViewById(R.id.regresar_btn);
        limpiar_btn = findViewById(R.id.limpiar_btn);

        Intent intent = getIntent();
        String name = intent.getStringExtra("claveNombre");

        nombre_et.setText("Mi nombre es "+ name);
        calcular_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (base_et.getText().toString().isEmpty() || altura_et.getText().toString().isEmpty()){

                    Toast.makeText(RectanguloActivity.this,"Llene los campos para continuar",Toast.LENGTH_SHORT).show();
                }else {
                    calcular();
                }
            }
        });

        regresar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresar();
            }
        });

        limpiar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });

    }

    private void calcular(){

        rectangulo.setBase(Integer.parseInt(base_et.getText().toString()));
        rectangulo.setAltura(Integer.parseInt(altura_et.getText().toString()));
        area_tv.setText(String.valueOf(rectangulo.calcularArea()));
        perimetro_tv.setText(String.valueOf(rectangulo.calcularPerimetro()));

    }
    private void regresar(){
        finish();
    }

    private void limpiar(){
        base_et.setText("");
        altura_et.setText("");
        area_tv.setText("0");
        perimetro_tv.setText("0");
    }
}

