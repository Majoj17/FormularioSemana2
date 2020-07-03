package com.example.formulariosemana2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText tNombre,tTelefono, tEmail, tDescripcion, tFecha;
    private Button bFecha, bEdicion;
    private int dia, mes, año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tNombre=(EditText) findViewById(R.id.txtNombre);
        tTelefono=(EditText) findViewById(R.id.txtTelefono);
        tEmail=(EditText) findViewById(R.id.txtEmail);
        tDescripcion= (EditText) findViewById(R.id.txtDescripcion);
        tFecha= (EditText) findViewById(R.id.txtFecha);
        bFecha= (Button) findViewById(R.id.botonFecha);
        bFecha.setOnClickListener(this);
        bEdicion=(Button) findViewById(R.id.button2);

    }
    public void Siguiente( View view){


        String nombre=tNombre.getText().toString();
        String telefono=tTelefono.getText().toString();
        String fecha=tFecha.getText().toString();
        String email=tEmail.getText().toString();
        String descripcion= tDescripcion.getText().toString();

        if (nombre.length()==0 && telefono.length()==0 && email.length()==0 && descripcion.length()==0){
            Toast.makeText(this, "Debes ingresar los campos necesarios", Toast.LENGTH_LONG).show();
        }
        else if (nombre.isEmpty()){
            Toast.makeText(this, "Debes ingresar un nombre", Toast.LENGTH_LONG).show();
        }
        else if(telefono.isEmpty()){
            Toast.makeText(this, "Debes ingresar un telefono valido", Toast.LENGTH_LONG).show();
        }
        else if(fecha.isEmpty()){
            Toast.makeText(this, "Debes ingresar una fecha", Toast.LENGTH_LONG).show();
        }
        else if(email.isEmpty()){
            Toast.makeText(this, "Debes ingresar un email", Toast.LENGTH_LONG).show();
        }
        else if(descripcion.isEmpty()){
            Toast.makeText(this, "Debes ingresar una descripcion", Toast.LENGTH_LONG).show();
        }
        else if (nombre.length()!=0 && telefono.length()!=0 && email.length()!=0 && descripcion.length()!=0 ){
            Toast.makeText(this, "Registro en proceso...", Toast.LENGTH_LONG).show();
            Intent siguiente = new Intent(this, Datos.class);
            siguiente.putExtra("pnombre",tNombre.getText().toString());
            siguiente.putExtra("ptelefono",tTelefono.getText().toString());
            siguiente.putExtra("pfecha", tFecha.getText().toString());
            siguiente.putExtra("pemail",tEmail.getText().toString());
            siguiente.putExtra("pdescripcion",tDescripcion.getText().toString());
            startActivity(siguiente);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if(v==bFecha){
            final Calendar calendar = Calendar.getInstance();
            dia=calendar.get(Calendar.DAY_OF_MONTH);
            mes=calendar.get(Calendar.MONTH);
            año= calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
               tFecha.setText(dayOfMonth+ "/"+ month+1+"/"+ year);
                }
            }, dia, mes, año);
            datePickerDialog.show();
        }
    }
}