import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Implémentation de l'interface PasswordCracker pour le craquage par dictionnaire.
 */
public class DictionnaryCracker implements PasswordCracker {

    /**
     * Recherche du mot de passe correspondant au hash donné.
     *
     * @param hashDonne Le hash du mot de passe à trouver.
     * @param algo      L'algorithme de hachage utilisé pour le hash.
     * @return Le mot de passe correspondant ou une chaîne vide si le mot de passe n'est pas trouvé.
     * @throws Exception Si une erreur se produit lors de l'utilisation de l'algorithme de hachage.
     */
    @Override
    public String trouverMdpHash(String hashDonne, String algo) throws Exception {
        String resultat = "";
        boolean isPasswordFound = false;

        try {
            File dictionnaire = new File("dictionary.txt");
            Scanner myReader = new Scanner(dictionnaire);
            while (myReader.hasNextLine()) {
                String mot = myReader.nextLine();
                String motHashe = Hasheur.hasheur(mot, algo);
                System.out.println("On compare avec " + motHashe);
                if (motHashe.equals(hashDonne)) {
                    resultat = mot;
                    isPasswordFound = true;
                    break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        if (!isPasswordFound) {
            System.out.println("Mot de passe non trouvé.");
        }

        return resultat;
    }

    /**
     * Recherche du mot de passe correspondant au mot de passe fourni.
     *
     * @param MdpCorrect Le mot de passe à trouver.
     * @return Le mot de passe correspondant ou une chaîne vide si le mot de passe n'est pas trouvé.
     */
    @Override
    public String trouverMdpClair(String MdpCorrect) {
        String resultat = "";
        boolean isPasswordFound = false;

        try {
            File dictionnaire = new File("dictionary.txt");
            Scanner myReader = new Scanner(dictionnaire);
            while (myReader.hasNextLine()) {
                String mot = myReader.nextLine();
                System.out.println("Comparaison avec " + mot);
                if (mot.equals(MdpCorrect)) {
                    resultat = mot;
                    isPasswordFound = true;
                    break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        if (!isPasswordFound) {
            System.out.println("Mot de passe non trouvé.");
        }

        return resultat;
    }
}
