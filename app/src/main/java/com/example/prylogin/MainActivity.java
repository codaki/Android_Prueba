package com.example.prylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declarar los objetos gráficos
    EditText txt_usuario,txt_clave;
    Button btn_login;

    private String user ="Admin",clave1 ="Admin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mapeo de objetos

        txt_usuario = findViewById(R.id.et_usuario);
        txt_clave = findViewById(R.id.et_clave);
        btn_login = findViewById(R.id.btn_login);
        
        //método onclick
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = txt_usuario.getText().toString();
                String clave = txt_clave.getText().toString();
                if (usuario.length()!=0) {
                    if (usuario.equals(user)) {
                        //verificacion contraseña
                        if(clave.equals(clave1)){
                            Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                            //conexion a otra actividad
//                            Intent conexion =  new Intent(MainActivity.this, Bienvenido.class );
//                            startActivity(conexion);
                            Intent conec= new Intent(MainActivity.this, Bienvenido1.class);

                            startActivity(conec);
                        }else{
                            Toast.makeText(MainActivity.this, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Datos Vaciós", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
    }

}