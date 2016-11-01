package com.startcompy.hacerpedidor;

/**
 * Created by Carlitos on 30/10/2016.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {




    // NOMBRE DE LAS TABLA cliente
    public static final String TABLE_CLIENT ="cliente";



    // NOMBRE DE LOS CAMPOS DE LA TABLA CLIENTE
    public static final String CL_ID = "cl_id";
    public static final String CL_NAME = "cl_name";
    public static final String CL_NAME2 = "apellido";
    public static final String CL_RUC = "ruc";
    public static final String CL_TEL = "telefono";


    // información del a base de datos
    static final String DB_NAME = "DBPEDIDOS";
    static final int DB_VERSION = 2;

    // SENTENCIA PARA CREAR LA TABLA CLIENTE
    public static final String CREATE_TABLE_CLIENT = " create table "+TABLE_CLIENT+" ("
            + CL_ID + " integer primary key autoincrement,"
            + CL_NAME + " text not null,"
            + CL_NAME2 + " text not null,"
            + CL_RUC + " text not null,"
            + CL_TEL + " text);";

    public DBhelper(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CLIENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENT);
        onCreate(db);
    }

    public ArrayList<String> consultarclientes(){
        ArrayList<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        db.beginTransaction();
        String selectquery="select "+DBhelper.CL_ID+", "+DBhelper.CL_NAME+" from "+DBhelper.TABLE_CLIENT;
        Cursor cur=db.rawQuery(selectquery, null);
        try {
            if (cur.getCount() > 0) {
                while (cur.moveToNext()) {
                    String nombre = cur.getString(cur.getColumnIndex("nombre"));
                    list.add(nombre);
                }
            }
            db.setTransactionSuccessful();
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            db.endTransaction();
            db.close();
        }
        return list;
    }


    // NOMBRE DE LAS TABLA producto
    public static final String TABLE_PRODUCT ="producto";


    // NOMBRE DE LOS CAMPOS DE LA TABLA PRODUCTO
    public static final String PR_ID = "id";
    public static final String PR_NAME = "nombre";
    public static final String PR_MARCA = "marca";


    // SENTENCIA PARA CREAR LA TABLA PRODUCTO
    public static final String CREATE_TABLE_PRODUCT = " create table "+TABLE_PRODUCT+" ("
            + PR_ID + " integer primary key autoincrement,"
            + PR_NAME + " text not null,"
            + PR_MARCA + " text not null);";



    // NOMBRE DE LAS TABLA CABECERA PEDIDO
    public static final String TABLE_CA_PEDIDO ="cabecera_pedido";



    // NOMBRE DE LOS CAMPOS DE LA TABLA CABECERA PEDIDO
    public static final String CP_ID = "id";
    public static final String CP_CL_ID = "cliente_id";
    public static final String CP_PRODUCT = "fecha";
    public static final String CP_CANTIDAD = "fecha";


    // SENTENCIA PARA CREAR LA TABLA CABECERA PEDIDO
    public static final String CREATE_TABLE_CA_PEDIDO = " create table "+TABLE_CA_PEDIDO+" ("
            + CP_ID + " integer primary key autoincrement,"
            + CP_CL_ID + " text,"
            + CP_PRODUCT + " text,"
            + CP_CANTIDAD + " text);";




}