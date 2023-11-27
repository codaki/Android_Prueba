package com.example.prylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Bienvenido1 extends AppCompatActivity {

    EditText txt_nombreUsuario, txt_fechaNacYear, txt_fechaNacMonth, txt_fechaNacDay;
    Button btn_ingresoInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido1);

        txt_nombreUsuario = findViewById(R.id.et_nombre);
        txt_fechaNacYear = findViewById(R.id.et_year);
        txt_fechaNacMonth = findViewById(R.id.et_mes);
        txt_fechaNacDay = findViewById(R.id.et_dia);
        btn_ingresoInfo = findViewById(R.id.btn_siguiente);

        btn_ingresoInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntent2 = new Intent(Bienvenido1.this, Datos.class);
                objIntent2.putExtra("nombreUsuario", txt_nombreUsuario.getText().toString());
                objIntent2.putExtra("fechaNacYear", txt_fechaNacYear.getText().toString());
                objIntent2.putExtra("fechaNacMonth", txt_fechaNacMonth.getText().toString());
                objIntent2.putExtra("fechaNacDay", txt_fechaNacDay.getText().toString());

                startActivity(objIntent2);
            }
        });

    }
}