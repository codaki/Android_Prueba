package com.example.prylogin;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Datos extends AppCompatActivity {

    EditText txt_nombreIngresado, txt_fechaIngresada, txt_Edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        txt_nombreIngresado = findViewById(R.id.et_NombreIngresado);
        txt_fechaIngresada = findViewById(R.id.et_FechaIngresada);

        Intent objIntent3 = getIntent();
        String year = objIntent3.getStringExtra("fechaNacYear"), month = objIntent3.getStringExtra("fechaNacMonth"), day = objIntent3.getStringExtra("fechaNacDay");
        String fecha = day + "/" + month  + "/" + year;
        calcularEdad(year, month, day);
        txt_nombreIngresado.setText(objIntent3.getStringExtra("nombreUsuario"));
        txt_fechaIngresada.setText(fecha);
    }
    public void calcularEdad(String yearParameter, String monthParameter, String dayParameter){
        txt_Edad = findViewById(R.id.et_Edad);

        int birthYear = Integer.parseInt(yearParameter), birthMonth = Integer.parseInt(monthParameter), birthDay = Integer.parseInt(dayParameter);

        Calendar birthDate = Calendar.getInstance();
        birthDate.set(birthYear, birthMonth - 1, birthDay); // month is zero-based

        Calendar currentDate = Calendar.getInstance();

        int years = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        int months = currentDate.get(Calendar.MONTH) - birthDate.get(Calendar.MONTH);
        int days = currentDate.get(Calendar.DAY_OF_MONTH) - birthDate.get(Calendar.DAY_OF_MONTH);

        if (days < 0) {
            months--;
            days += currentDate.getActualMaximum(Calendar.DAY_OF_MONTH);
        }

        if (months < 0) {
            years--;
            months += 12;
        }
        txt_Edad.setText(years + " años, con " + months + " meses y " + days + "días");
}}