/**
 * Implémentation de l'interface PasswordCracker pour le craquage par force brute.
 */
public class BruteForceCracker implements PasswordCracker {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public String trouverMdpClair(String mdpCorrect) {
        // Indique si le mot de passe a été trouvé
        boolean mdpTrouve = false;
        // Longueur maximale du mot de passe à deviner
        int passwordLength = 10;

        // Génération des caractères possibles (lettres minuscules)
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
        // Indique si le mot de passe a été trouvé
        boolean mdpTrouve = false;
        // Longueur maximale du mot de passe à deviner
        int passwordLength = 10;

        // Génération des caractères possibles (lettres minuscules)
        String characters = "abcdefghijklmnopqrstuvwxyz";

        for (int length = 1; length <= passwordLength; length++) {
            String result = generateHashedPasswords("", characters, length, mdpCorrect);
            if (result != null) {
                return result;
            }
        }

        return "Mot de passe non trouvé.";
    }

    /**
     * Méthode récursive pour générer les mots de passe hachés.
     *
     * @param prefix     Le préfixe actuel du mot de passe en cours de génération.
     * @param characters Les caractères possibles pour le mot de passe.
     * @param length     La longueur restante du mot de passe.
     * @param hashedPassword Le mot de passe haché à comparer.
     * @return Le mot de passe trouvé ou null s'il n'a pas été trouvé.
     * @throws Exception Si une erreur survient lors de l'utilisation de l'algorithme de hachage.
     */
    private static String generateHashedPasswords(String prefix, String characters, int length, String hashedPassword) throws Exception {
        if (length == 0) {
            // Vérification si le mot de passe haché correspond au mot de passe fourni
            String generatedHash = Hasheur.hasheur(prefix, "SHA-256");
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

    /**
     * Méthode récursive pour générer les mots de passe non hachés.
     *
     * @param prefix     Le préfixe actuel du mot de passe en cours de génération.
     * @param characters Les caractères possibles pour le mot de passe.
     * @param length     La longueur restante du mot de passe.
     * @param password   Le mot de passe à comparer.
     * @return Le mot de passe trouvé ou null s'il n'a pas été trouvé.
     */
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
