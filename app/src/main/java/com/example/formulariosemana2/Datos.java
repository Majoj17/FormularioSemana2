package com.example.formulariosemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Datos extends AppCompatActivity {

    private TextView TVnombre, TVtelefono, TVemail, TVdescripcion, TVfecha;
    private EditText ETnombre, ETtelefono, ETemail, ETdescripcion, ETfecha;
    String nombre;
    String telefono;
    String email;
    String fecha;
    String descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        TVnombre= (TextView) findViewById(R.id.tvNombre);
        TVtelefono= (TextView) findViewById(R.id.tvTelefono);
        TVfecha=(TextView) findViewById(R.id.tvFecha);
        TVemail= (TextView) findViewById(R.id.tvEmail);
        TVdescripcion= (TextView) findViewById(R.id.tvDescripcion);

        ETnombre= (EditText) findViewById(R.id.txtNombre);
        ETtelefono= (EditText) findViewById(R.id.txtTelefono);
        ETfecha= (EditText) findViewById(R.id.txtFecha);
        ETemail= (EditText) findViewById(R.id.txtEmail);
        ETdescripcion= (EditText) findViewById(R.id.txtDescripcion);

         nombre= getIntent().getStringExtra("pnombre");
        TVnombre.setText("Nombre: " +nombre);
         telefono= getIntent().getStringExtra("ptelefono");
        TVtelefono.setText("Telefono: "+telefono);
         fecha= getIntent().getStringExtra("pfecha");
         TVfecha.setText("Fecha: "+fecha);
         email= getIntent().getStringExtra("pemail");
        TVemail.setText("Email: "+email);
         descripcion= getIntent().getStringExtra("pdescripcion");
         TVdescripcion.setText("Descripción: "+descripcion);
    }

    public void Anterior (View view){
        Intent anterior= new Intent(this, MainActivity.class);
        startActivity(anterior);
    }
}