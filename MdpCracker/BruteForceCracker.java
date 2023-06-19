public class BruteForceCracker implements PasswordCracker {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public String trouverMdpClair(String MdpCorrect) {
        String resultat = "";
        boolean isPasswordFound = false;

        for (int len = 1; len <= 4; len++) {
            isPasswordFound = bruteForceHelper("", MdpCorrect, len);
            if (isPasswordFound) {
                break;
            }
        }

        if (!isPasswordFound) {
            System.out.println("Mot de passe non trouvé.");
        }

        return resultat;
    }

    @Override
    public String trouverMdpHash(String MdpCorrect, String algo) throws Exception {
        // À implémenter selon les besoins
        return "";
    }

    private boolean bruteForceHelper(String prefix, String targetPassword, int length) {
        if (length == 0) {
            if (prefix.equals(targetPassword)) {
                System.out.println("Mot de passe trouvé : " + prefix);
                return true;
            }
            return false;
        }

        for (int i = 0; i < CHARACTERS.length(); i++) {
            char c = CHARACTERS.charAt(i);
            if (bruteForceHelper(prefix + c, targetPassword, length - 1)) {
                return true;
            }
        }

        return false;
    }
}

