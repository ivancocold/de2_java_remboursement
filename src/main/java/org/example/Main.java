//Import des packages et bibliothèques utiles au projet
package org.example;
import com.opencsv.exceptions.CsvException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.example.processcsv.DIRECTORY_PATH;
import static org.example.processcsv.processCsvFile;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    //Gestion des erreurs avec un logger robuste
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args)
    {
        //Définition du répertoire de recherche
        File folder = new File(DIRECTORY_PATH);
        /*
        Tous les fichiers dont le nom répond aux critères de recherche spécifiés dans le regex sont stockés dans une liste.
         */
        File[] files = folder.listFiles((dir, name) -> name.matches(".*\\d{14}\\.csv"));

        //Cas où un fichier répond aux attentes
        if (files != null)
        {
            //Pour chaque fichier
            for (File file : files)
            {
                //Annonce de son traitement pas affichage
                System.out.println("Processing file: " + file.getName());
                //Début du traitement
                try
                    {
                        //Application de la méthode processCSVFile de la classe processcsv
                        processCsvFile(file);
                    }
                //Gestion des erreurs
                catch (IOException | CsvException | SQLException e)
                    {
                    /*
                    La gestion des erreurs aurait pu se faire avec la ligne de code suivante.
                    e.printStackTrace();
                    Néanmoins, j'ai opté pour une gestion des erreurs robustes avec slf4j
                     */
                    logger.error("Une erreur s'est produite lors du traitement du fichier", e);
                    }
            }
        }
    }
}