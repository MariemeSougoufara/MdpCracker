public class BruteForceCracker implements PasswordCracker {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public String trouverMdpClair(String mdpCorrect) {
       boolean mdpTrouve = false;
        int passwordLength = 10; // Longueur maximale du mot de passe à deviner

        // Génération des caractères possibles (lettres majuscules, lettres minuscules, chiffres)
        String characters = "abcdefghijklmnopqrstuvwxyz";

        for (int length = 1; length <= passwordLength; length++) {
            String result = generateUnhashedPasswords("", characters, length, mdpCorrect);
            if (result != null) {
                return result;
            }
        }

        return "Mot de passe non trouvé.";
    }

    @Override
    public String trouverMdpHash(String mdpCorrect, String algo) throws Exception {
        
         boolean mdpTrouve = false;
        int passwordLength = 10; // Longueur maximale du mot de passe à deviner

        // Génération des caractères possibles (lettres majuscules, lettres minuscules, chiffres)
        String characters = "abcdefghijklmnopqrstuvwxyz";

        for (int length = 1; length <= passwordLength; length++) {
            String result = generateHashedPasswords("", characters, length, mdpCorrect);
            if (result != null) {
                return result;
            }
        }

        return "Mot de passe non trouvé.";
    }

    // Méthode récursive pour générer les mots de passe hachés
    private static String generateHashedPasswords(String prefix, String characters, int length, String hashedPassword) throws Exception {
        if (length == 0) {
            // Vérification si le mot de passe haché correspond au mot de passe fourni
            String generatedHash = Hasheur.hasheur(prefix,"SHA-256");
            if (generatedHash.equals(hashedPassword)) {
                return prefix;
            }
            return null;
        }

        for (int i = 0; i < characters.length(); i++) {
            String newPrefix = prefix + characters.charAt(i);
            String result = generateHashedPasswords(newPrefix, characters, length - 1, hashedPassword);
            if (result != null) {
                return result;
            }
        }

        return null;
    }
 
     // Méthode récursive pour générer les mots de passe non hachés
    private static String generateUnhashedPasswords(String prefix, String characters, int length, String password) {
        if (length == 0) {
            System.out.println("Mot de passe généré : " + prefix);
            // Vérification si le mot de passe généré correspond au mot de passe fourni
            if (prefix.equals(password)) {
                return prefix;
            }
            return null;
        }

        for (int i = 0; i < characters.length(); i++) {
            String newPrefix = prefix + characters.charAt(i);
            String result = generateUnhashedPasswords(newPrefix, characters, length - 1, password);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

}

