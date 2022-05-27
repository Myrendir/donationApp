package com.nfs.foodmyproject.mapping;

public interface ContrepartieMapping extends BaseMapping{


    public static final String MONTANT = "montant";
    public static final String TITRE = "titre";
    public static final String DESCRIPTION = "description";
    public static final String ID_PROJET = "id_projet";


    public static final String TABLE = "contreparties";

    public static final String DML_CREATE = "CREATE TABLE "+ TABLE +
            "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            MONTANT + " REAL NOT NULL, " +
            TITRE + " TEXT NOT NULL, " +
            DESCRIPTION + " REAL NOT NULL, " +
            "FOREIGN KEY("+ID_PROJET+ ") REFERENCES" + ProjetMapping.TABLE+"(" + ProjetMapping.ID + "));";
}
