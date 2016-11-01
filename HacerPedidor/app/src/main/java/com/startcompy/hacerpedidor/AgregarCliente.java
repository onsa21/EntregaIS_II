package com.startcompy.hacerpedidor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AgregarCliente extends Activity implements OnClickListener {
    EditText text_nombre, text_apellido, text_ruc, text_telefono;
    Button btnAgregar, read_bt;
    SQLControlador dbconeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_cliente);

        text_nombre = (EditText) findViewById(R.id.text_nombre);
        text_apellido = (EditText) findViewById(R.id.text_apellido);
        text_ruc = (EditText) findViewById(R.id.text_ruc);
        text_telefono = (EditText) findViewById(R.id.text_telefono);
        btnAgregar = (Button) findViewById(R.id.btnAgregarId);

        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarId:

                String nombre = text_nombre.getText().toString();
                String apellido = text_apellido.getText().toString();
                String ruc = text_ruc.getText().toString();
                String telefono = text_telefono.getText().toString();
                dbconeccion.insertarDatos(nombre, apellido, ruc, telefono);
                Toast.makeText(this, "El Cliente fue guardado", Toast.LENGTH_SHORT).show();
                Intent main = new Intent(AgregarCliente.this, MainPedidos.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                break;

            default:
                break;
        }
    }
}