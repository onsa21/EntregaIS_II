package com.startcompy.hacerpedidor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AgregarProducto extends Activity implements OnClickListener {
    EditText text_prnombre, text_prmarca;
    Button btnAgregarProducto, read_bt;
    SQLControlador dbconeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);

        text_prnombre = (EditText) findViewById(R.id.text_prnombre);
        text_prmarca = (EditText) findViewById(R.id.text_prmarca);
        btnAgregarProducto = (Button) findViewById(R.id.btnAgregarProducto);

        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregarProducto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarProducto:

                String prnombre = text_prnombre.getText().toString();
                String prmarca = text_prmarca.getText().toString();
                dbconeccion.insertarProductos(prnombre, prmarca);
                Toast.makeText(this, "El Producto fue creado", Toast.LENGTH_SHORT).show();
                Intent main = new Intent(AgregarProducto.this, MainPedidos.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                break;

            default:
                break;

        }
    }
}