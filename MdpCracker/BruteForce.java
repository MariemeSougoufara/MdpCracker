import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class BruteForce {
    public static void main(String[] args) {
        String password = "myPassword"; // Mot de passe à deviner


        // Exemple d'utilisation de la méthode bruteForceHashed()
        String hashedPassword = Hasheur.hasheur(password,"SHA-256");
        bruteForceHashed(hashedPassword);


        // Exemple d'utilisation de la méthode bruteForceUnhashed()
        bruteForceUnhashed(password);
    }


    // Méthode pour le cas où le mot de passe est haché
    public static void bruteForceHashed(String hashedPassword) {
        boolean mdpTrouve = false;
        int longueurMdp = 10; // Longueur maximale du mot de passe à deviner


        // Génération des caractères possibles (lettres majuscules, lettres minuscules, chiffres)
        String characters = "abcdefghijklmnopqrstuvwxyz";


        for (int length = 1; length <= longueurMdp; length++) {
            mdpTrouve = generateHashedPasswords("", characters, length, hashedPassword);
            if (mdpTrouve) {
                break;
            }
        }


        if (!mdpTrouve) {
            System.out.println("Le mot de passe n'a pas été trouvé.");
        }
    }


    // Méthode récursive pour générer les mots de passe hachés
    private static boolean generateHashedPasswords(String prefix, String characters, int length, String hashedPassword) throws Exception {
        if (length == 0) {
            // Vérification si le mot de passe haché correspond au mot de passe fourni
            String generatedHash = Hasheur.hasheur(prefix,"SHA-256");
            System.out.println("Mot de passe généré : " + prefix);
            if (generatedHash.equals(hashedPassword)) {
                System.out.println("Le mot de passe haché a été trouvé : " + prefix);
                return true;
            }
            return false;
        }


        for (int i = 0; i < characters.length(); i++) {
            String newPrefix = prefix + characters.charAt(i);
            boolean mdpTrouve = generateHashedPasswords(newPrefix, characters, length - 1, hashedPassword);
            if (mdpTrouve) {
                return true;
            }
        }


        return false;
    }


    // Méthode pour le cas où le mot de passe n'est pas haché
    public static void bruteForceUnhashed(String password) {
        boolean mdpTrouve = false;
        int longueurMdp = 10; // Longueur maximale du mot de passe à deviner


        // Génération des caractères possibles (lettres majuscules, lettres minuscules, chiffres)
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";


        for (int length = 1; length <= longueurMdp; length++) {
            mdpTrouve = generateUnhashedPasswords("", characters, length, password);
            if (mdpTrouve) {
                break;
            }
        }


        if (!mdpTrouve) {
            System.out.println("Le mot de passe n'a pas été trouvé.");
        }
    }


    // Méthode récursive pour générer les mots de passe non hachés
    private static boolean generateUnhashedPasswords(String prefix, String characters, int length, String password) {
        if (length == 0) {
            // Vérification si le mot de passe généré correspond au mot de passe fourni
            System.out.println("Mot de passe généré : " + prefix);
            if (prefix.equals(password)) {
                System.out.println("Le mot de passe a été trouvé : " + prefix);
                return true;
            }
            return false;
        }


        for (int i = 0; i < characters.length(); i++) {
            String newPrefix = prefix + characters.charAt(i);
            boolean mdpTrouve = generateUnhashedPasswords(newPrefix, characters, length - 1, password);
            if (mdpTrouve) {
                return true;
            }
        }


        return false;
    }


    // Méthode pour hacher un mot de passe (utilisée pour l'exemple)
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}





