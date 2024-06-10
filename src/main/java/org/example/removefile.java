//Classe de gestion du déplacement de fichiers traités

//Import des packages et des bibliothèques utiles aux traitements
package org.example;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class removefile
{
    //Méthode de déplacement du fichier traité
    public static void moveFile(File sourceFile, String destinationDirectory) throws IOException
    {
        //Définition du dossier d'archivage
        Path destinationPath = new File(destinationDirectory, sourceFile.getName()).toPath();

        //Déplacement du fichier dans le répertoire cible.
        Files.move(sourceFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

        //Affichage confirmant le déplacement.
        System.out.println("File moved to: " + destinationPath);
    }
}