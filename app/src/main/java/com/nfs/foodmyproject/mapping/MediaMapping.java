package com.nfs.foodmyproject.mapping;

public interface MediaMapping extends BaseMapping{

    public static final String URL = "url";
    public static final String COUVERTURE = "couverture";
    public static final String ID_PROJET = "id_projet";


    public static final String TABLE = "medias";

    public static final String DML_CREATE = "CREATE TABLE "+ TABLE +
            "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            URL + " TEXT NOT NULL, " +
            COUVERTURE + " NUMERIC NOT NULL, " +
            "FOREIGN KEY("+ID_PROJET+ ") REFERENCES" + ProjetMapping.TABLE+"(" + ProjetMapping.ID + "));";
}
