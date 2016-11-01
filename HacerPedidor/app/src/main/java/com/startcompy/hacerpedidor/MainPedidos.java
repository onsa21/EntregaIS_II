package com.startcompy.hacerpedidor;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class MainPedidos extends Activity {

    Button btnAgregarMiembro, btnHacerPedido;
    ListView listaproducto, listapedido;
    Button btnAgregarProducto;
    ListView lista;
    SQLControlador dbconeccion;
    TextView tv_miemID, tv_miemNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pedidos);

        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();
        dbconeccion.insertarDatos("Carlos", "Ibarra", "test", "Test2");

        btnAgregarMiembro = (Button) findViewById(R.id.btnAgregarMiembro);
        //lista = (ListView) findViewById(R.id.listViewMiembros);

        //acción del boton agregar miembro
        btnAgregarMiembro.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iagregar = new Intent(MainPedidos.this, AgregarCliente.class);
                startActivity(iagregar);
            }
        });

// button para agregar producto
        btnAgregarProducto= (Button) findViewById(R.id.btnAgregarProducto);
        //listaproducto = (ListView) findViewById(R.id.listViewMiembros);

        //acción del boton agregar miembro
        btnAgregarProducto.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iagregarproducto = new Intent(MainPedidos.this, AgregarProducto.class);
                startActivity(iagregarproducto);
            }
        });

        // button para hacer pedido
        btnHacerPedido= (Button) findViewById(R.id.btnHacerPedido);
        //listapedido = (ListView) findViewById(R.id.listViewMiembros);

        //acción del boton agregar miembro
        btnHacerPedido.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iagregarpedido = new Intent(MainPedidos.this, HacerPedido.class);
                startActivity(iagregarpedido);
            }
        });

        //DBhelper db = new DBhelper(this);
        //ArrayList<String> listcliente = db.consultarclientes();
        //Spinner spinnerCliente =(Spinner) findViewById(R.id.spinnerCliente);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_main_pedidos, R.id.text, listcliente);
        //spinnerCliente.setAdapter(adapter);


    }  //termina el onCreate
} //termina clase