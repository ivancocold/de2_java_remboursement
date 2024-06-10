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
        File folder = new File(DIRECTORY_PATH);
        File[] files = folder.listFiles((dir, name) -> name.matches(".*\\d{14}\\.csv"));

        if (files != null) {
            for (File file : files)
            {
                System.out.println("Processing file: " + file.getName());
                try
                    {
                        processCsvFile(file);
                    }
                catch (IOException | CsvException | SQLException e)
                    {
                    //e.printStackTrace();
                    logger.error("Une erreur s'est produite lors du traitement du fichier", e);
                    }
            }
        }
    }
}