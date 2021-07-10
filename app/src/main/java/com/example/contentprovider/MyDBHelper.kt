package com.example.contentprovider

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class ProductsDBHelper(context: Context?, dbName: String, factory: SQLiteDatabase.CursorFactory?, version: Int)
    : SQLiteOpenHelper(context, dbName, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        Log.e("tag", "SQLiteOpenHelper: onCreate")
        db?.execSQL("create table products (id integer primary key, title text, price integer)")
        addProducts(db);
    }

    private fun addProducts(db : SQLiteDatabase?) {

        var values = ContentValues()
        values.put("id", 101)
        values.put("title", "Macbook")
        values.put("price", 190000)

        var rownum = db?.insert(
            "products",
            null,
            //"purchase_date, city",
            values
        )


        values.put("id", 50)
        values.put("title", "Dell XPS")
        values.put("price", 90000)
        rownum = db?.insert(
            "products",
            null,
            values
        )

        values.put("id", 230)
        values.put("title", "Gaming Machine")
        values.put("price", 900000)
        rownum = db?.insert(
            "products",
            null,
            values
        )

        values.put("id", 190)
        values.put("title", "System 76")
        values.put("price", 120000)
        rownum = db?.insert(
            "products",
            null,
            values
        )

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //code to update the db structure
        //db?.execSQL("alter table products add is_read tinyint")
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }
}