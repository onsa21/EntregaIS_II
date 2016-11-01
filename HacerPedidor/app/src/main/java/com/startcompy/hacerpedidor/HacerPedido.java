package com.startcompy.hacerpedidor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class HacerPedido extends Activity implements OnClickListener {
    EditText text_cantidad;
    Spinner text_cliente, text_producto;
    Button btnHacerPedido;
    SQLControlador dbconeccion;

    Spinner spinnerProducto;
    String[] productos = {"  ", "Leche E Sachet 1L", "Leche E Carton 1L ", "Leche D Sachet 1L", "Leche D Carton 1L", "Leche E Sachet 0,5L", "Leche E Carton 0,5L", "Leche D Sachet 0,5L", "Leche E Sachet 0,5L" };

    Spinner spinnerCliente;
    String[] clientes = {"  ", "Pedro Peralta", "Fidencio Oviedo", "Richar Baez", "Juan Avillagalde", "Tomas Muchauscha", "Rodrigo Pinoza", "Eresio Gimenez", "Florentin Gallardo" };

    private TextView etiquetas;
    private List<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hacer_pedido);

      spinnerCliente =(Spinner) findViewById(R.id.spinnerCliente);
        ArrayAdapter<String> clienteadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, clientes);
        spinnerCliente.setAdapter(clienteadapter);

        spinnerProducto = (Spinner) findViewById(R.id.spinnerProducto);
        ArrayAdapter<String> productoadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, productos);
        spinnerProducto.setAdapter(productoadapter);
        text_cliente = (Spinner) findViewById(R.id.spinnerCliente);
        text_producto = (Spinner) findViewById(R.id.spinnerProducto);

        text_cantidad = (EditText) findViewById(R.id.text_cantidad);
        //text_prmarca = (EditText) findViewById(R.id.text_prmarca);
        btnHacerPedido = (Button) findViewById(R.id.btnHacerPedido);
        //DBhelper db = new DBhelper(this);

        //ArrayList<String> listcliente = db.consultarclientes();


        //spinnerCliente.setAdapter(adapter);

        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();

        btnHacerPedido.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnHacerPedido:

                String cl_cantidad = text_cantidad.getText().toString();
                String cl_cliente = text_cliente.getSelectedItem().toString();
                String cl_product = text_producto.getSelectedItem().toString();
                dbconeccion.insertarcabecerapedido(cl_cliente, cl_product, cl_cantidad);
                Toast.makeText(this, "Se agrego el pedido", Toast.LENGTH_SHORT).show();
                Intent main = new Intent(HacerPedido.this, MainPedidos.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                break;

            default:
                break;

        }
    }
}