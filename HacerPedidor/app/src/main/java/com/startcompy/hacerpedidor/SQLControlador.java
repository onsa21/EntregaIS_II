package com.startcompy.hacerpedidor;

/**
 * Created by Carlitos on 30/10/2016.
 */

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

public class SQLControlador {

    private DBhelper dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControlador(Context c) {
        ourcontext = c;
    }

    public SQLControlador abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelper(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String nombre, String apellido, String ruc, String telefono) {
        ContentValues valores = new ContentValues();

        valores.put(DBhelper.CL_NAME, nombre);
        valores.put(DBhelper.CL_NAME2, apellido);
        valores.put(DBhelper.CL_RUC, ruc);
        valores.put(DBhelper.CL_TEL, telefono);


    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelper.CL_ID,
                DBhelper.CL_NAME
        };
        Cursor c = database.query(DBhelper.TABLE_CLIENT, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public List consultarCliente(){
        String resultado ="";
        List<String> lista= new ArrayList<String>();
        Cursor cur=database.rawQuery("select "+DBhelper.CL_ID+", "+DBhelper.CL_NAME+" from "+DBhelper.TABLE_CLIENT, null);
        while (cur.moveToNext()){
            lista.add(cur.getString(0)+"-"+cur.getString(1));
        }
        cur.close();
        return (lista);
    }


    public int actualizarDatos(long memberID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelper.CL_ID, memberName);
        cvActualizar.put(DBhelper.CL_NAME, memberName);
        cvActualizar.put(DBhelper.CL_NAME2, memberName);
        cvActualizar.put(DBhelper.CL_RUC, memberName);
        cvActualizar.put(DBhelper.CL_TEL, memberName);
        int i = database.update(DBhelper.TABLE_CLIENT, cvActualizar,
                DBhelper.CL_ID + " = " + memberID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelper.TABLE_CLIENT, DBhelper.CL_ID + "="
                + memberID, null);
    }

    // Insertar productos

    public void insertarProductos(String prnombre, String prmarca) {
        ContentValues valores = new ContentValues();

        valores.put(DBhelper.PR_NAME, prnombre);
        valores.put(DBhelper.PR_MARCA, prmarca);


    }

    // Insertar Cabecera Pedido

    public void insertarcabecerapedido(String cp_cl_id, String cp_product, String cp_cantidad) {
        ContentValues valores = new ContentValues();
        valores.put(DBhelper.CP_CL_ID, cp_cl_id);
        valores.put(DBhelper.CP_PRODUCT, cp_product);
        valores.put(DBhelper.CP_CANTIDAD, cp_cantidad);



    }



}