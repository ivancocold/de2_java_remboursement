package org.example;
import org.junit.Before;
import org.junit.Test;
import com.opencsv.exceptions.CsvException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class test
{

    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    /*

    Méthode setUp() qui doit être exécutée avant chaque méthode de test.
    Dans cette méthode, les objets de connexion et de PreparedStatement sont initialisés avec des mocks.
     */
    @Before
    public void setUp() throws SQLException
    {
        //Mock objet de connexion.
        mockConnection = mock(Connection.class);

        //Mock objet de PreparedStatement.
        mockPreparedStatement = mock(PreparedStatement.class);

        /*
        Définit le comportement de executeUpdate() pour l'insertion
        Lorsque la méthode executeUpdate() est appelée pour la première fois sur le mock, elle renvoie 1 pour simuler une insertion.
        Les appels suivants renverront 2 pour simuler la mise à jour.
         */
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);
        when(mockPreparedStatement.executeUpdate()).thenReturn(2);

        /*
        Définit le comportement du mock de connexion.
        Lorsque la méthode prepareStatement() est appelée sur le mock de connexion avec n'importe quelle chaîne en paramètre, elle renvoie le mock de PreparedStatement.
         */
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
    }

    //Tests

    //Tester le traitement d'un fichier CSV
    @Test
    public void testProcessCsvFile() throws IOException, CsvException, SQLException, ParseException
    {
        //Création d'un fichier temporaire avec un nom au format attendu
        File tempFile = Files.createTempFile("testfile_20240610034426", ".csv").toFile();

        //Ecrire une ligne comportant surtout un ID de remboursement afin de simuler une actualisation
        Files.write(tempFile.toPath(),("ID_Remboursement,Nom, Prenom\n1"+"ID658, Doe, John").getBytes());

        //Applicationn de la méthode processCsvFile de la classe processcsv
        processcsv.processCsvFile(tempFile);

        //Suppression du fichier temporaire
        Files.deleteIfExists(tempFile.toPath());
    }

    //Tester l'exctration d'une date à partir d'un nom de fichier
    @Test
    public void testExtractDateFromFileName() throws ParseException
    {
        //Nom de fichier
        String fileName = "datafile_20240610034426.csv";
        //Extraire la plage qui m'intéresse
        String fileDateStr = fileName.substring(fileName.length() - 18, fileName.length() - 4);
        //Création d'une variable de format de date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        //Convertion en date de la chaîne de caractère en format date
        Date parsedDate = dateFormat.parse(fileDateStr);
        //Convertion en date de la chaîne de caractère en format timestamp
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        //Tester si la date formée est valide
        assertNotNull(timestamp);
    }

    //Tester le déplacement de fichier avec la classe removefile
    @Test
    public void testMoveFile() throws IOException
    {
        //Nom du fichier
        File sourceFile = Files.createTempFile("testfile_", ".csv").toFile();
        //Répertoire d'archivage
        String destinationDirectory = Files.createTempDirectory("archive").toString();
        //Application de la méthode movefile de la classe removefile
        removefile.moveFile(sourceFile, destinationDirectory);
        //Tester si le dossier de désitanation est valide
        Path destinationPath = new File(destinationDirectory, sourceFile.getName()).toPath();
        assertTrue(Files.exists(destinationPath));
        //Suppréssion des variables créées.
        Files.deleteIfExists(destinationPath);
        Files.deleteIfExists(Path.of(destinationDirectory));
    }
}
