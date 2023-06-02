package com.example.examenc1areaperimetro;

import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    private EditText nombre_et;
    private Button entrar_btn;
    private Button salir_btn;
    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre_et = findViewById(R.id.nombre_et);
        entrar_btn = findViewById(R.id.entrar_btn);
        salir_btn = findViewById(R.id.salir_btn);

        entrar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre_et.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Llene el campo para continuar",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(MainActivity.this,RectanguloActivity.class);
                    intent.putExtra("claveNombre",nombre_et.getText().toString());
                    startActivity(intent);

                }

            }
        });
        salir_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Cerrar aplicación");
                builder.setMessage("¿ Estás seguro de que quieres cerrar la aplicación ?");
                builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); // Cerrar la actividad actual y salir de la aplicación
                    }
                });
                builder.setNegativeButton("No", null); // No hacer nada si se selecciona "No"
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

}
