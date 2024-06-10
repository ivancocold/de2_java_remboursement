//Class de gestion des différentes connexions et manipulation de la base de données

//Import des différents bibliothèques et packages utiles aux manipulations
package org.example;
import java.sql.*;

public class connectiontodatabase
{
    // Variables de configuration

    //Serveur de base de données
    public static final String db_server="localhost";
    //Numéro de de port
    public static final String port="3308";
    //Nom de la base de données
    public static final String db_name="tpjava";
    //Nom de la table
    public static final String table="remboursement";
    //Nom d'utilisateur
    public static final String DB_USER = "root";
    //Mot de passe
    public static final String DB_PASSWORD = "tpuser";

    //Lien vers la base de données consolidées : à ne pas modifier!
    public static final String DB_URL = "jdbc:mysql://"+db_server+":"+port+"/"+db_name;

    //Méthode qui détermine s'il faut faire une insertion (insertion) ou un actualisation (update) d'une ligne.
    public static void upsertRow(Connection connection, String[] header, String[] row, Timestamp timestamp) throws SQLException
    {
        //Définition de la tables dans la base de données
        String tableName = table;
        //Définition de la clé primaire de la tables
        String idColumn = "ID_Remboursement"; // Change this to your ID column name

        //Variable stockant les différentes clés primaires de manière itérative.
        String idValue = null;
        //Parser l'en-tête du fichier à la recherche de la colonne correspondant au nom de la clé primaire de ma table.
        for (int i = 0; i < header.length; i++)
        {
            if (header[i].equals(idColumn))
            {
                idValue = row[i];
                break;
            }
        }

        //Cas ou aucune en-tête de colonne ne correspondrait à "ID_Remboursement"
        if (idValue == null)
        {
            //Gestion de l'erreur
            throw new IllegalArgumentException("ID column not found in CSV");
        }

        /*
        Si je retrouve la colonne qu'il nous faut, soit j'insère les différentes ligne, soit je les actualise dans ma base de données
        */

        //Utilisation de la méthode recordExists pour réaliser l'actualisation
        if (recordExists(connection, tableName, idColumn, idValue))
        {
            updateRow(connection, tableName, header, row, idColumn, idValue, timestamp);
        }
        //si non, j'insère la ligne.
        else
        {
            insertRow(connection, tableName, header, row, timestamp);
        }
    }

    //Méthode de vérification si une ligne existe.
    public static boolean recordExists(Connection connection, String tableName, String idColumn, String idValue) throws SQLException
    {
        //Requête de vérification dans la base de données.
        String query = "SELECT 1 FROM " + tableName + " WHERE " + idColumn + " = ?";
        //Tester la requête
        try (PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setString(1, idValue);
            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                //Retourne True si l'ID existe.
                return resultSet.next();
            }
        }
    }

    //Méthode d'insertion d'une ligne dans la base de données.
    public static void insertRow(Connection connection, String tableName, String[] header, String[] row, Timestamp timestamp) throws SQLException
    {
        //Construction de la requête insert par concaténation de caractères
        StringBuilder query = new StringBuilder("INSERT INTO ").append(tableName).append(" (");

        //Ajout des noms de colonnes
        for (String column : header)
        {
            query.append(column).append(",");
        }
        //Ajout de la colonne Timestamp_fichier qui n'est pas dans l'en-tête du fichier
        query.append("Timestamp_fichier");

        /*
        Ajout des valeurs à insérer.
        Il s'agit d'insérer itérativement les lignes trouvées dans le fichier traité.
         */
        query.append(") VALUES (");

        for (int i = 0; i < row.length; i++)
        {
            query.append("?,");
        }
        // Ajouter le placeholder (caractère jocker) pour Timestamp_fichier
        query.append("?");
        //Ajouter la parenthèse de fermeture de la requête. Elle met fin à la liste des values.
        query.append(")");

        //Création d'un objet preparedStatement à l'aide de la requête.
        try (PreparedStatement preparedStatement = connection.prepareStatement(query.toString()))
        {
            //Itèration sur chaque valeur de la ligne à insérer.
            // Définition de chaque valeur comme paramètre de la requête préparée.
            for (int i = 0; i < row.length; i++)
            {
                preparedStatement.setString(i + 1, row[i]);
            }
            //Définition du timestamp passé en paramètre comme paramètre de la requête pour la colonne "Timestamp_fichier".
            preparedStatement.setTimestamp(row.length + 1, timestamp);
            preparedStatement.executeUpdate();
        }
    }

    //Requête d'actualisation (update) fonctionnant avec le même principe que l'insert
    public static void updateRow(Connection connection, String tableName, String[] header, String[] row, String idColumn, String idValue, Timestamp timestamp) throws SQLException
    {
        StringBuilder query = new StringBuilder("UPDATE ").append(tableName).append(" SET ");

        for (String column : header)
        {
            if (!column.equals(idColumn))
            {
                query.append(column).append(" = ?,");
            }
        }
        query.append("Timestamp_fichier = ?"); // Ajouter Timestamp_fichier
        query.append(" WHERE ").append(idColumn).append(" = ?");

        try (PreparedStatement preparedStatement = connection.prepareStatement(query.toString()))
        {
            int index = 1;
            for (int i = 0; i < row.length; i++)
            {
                if (!header[i].equals(idColumn))
                {
                    preparedStatement.setString(index++, row[i]);
                }
            }
            preparedStatement.setTimestamp(index++, timestamp); // Ajouter le Timestamp_fichier
            preparedStatement.setString(index, idValue);
            preparedStatement.executeUpdate();
        }
    }
}