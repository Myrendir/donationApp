package com.nfs.foodmyproject.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import com.nfs.foodmyproject.beans.Contrepartie;
import com.nfs.foodmyproject.beans.Projet;
import com.nfs.foodmyproject.mapping.MediaMapping;

public class DBHelper  extends SQLiteOpenHelper {

    private static final String DB_NAME = "projet.db";
    private static final int DB_VERSION = 2;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Projet.DML_CREATE);
        db.execSQL(Contrepartie.DML_CREATE);
        db.execSQL(MediaMapping.DML_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Projet.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Contrepartie.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + MediaMapping.TABLE);
    }
}
