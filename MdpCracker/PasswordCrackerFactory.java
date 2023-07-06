/**
 * Classe pour la création d'instances de craqueurs de mots de passe.
 */
public class PasswordCrackerFactory {
    /**
     * Renvoie une instance du craqueur de mots de passe correspondant à la méthode de craquage spécifiée.
     *
     * @param methodCrackage La méthode de craquage ("DICTIONNAIRE" ou "BRUTEFORCE").
     * @return Une instance du craqueur de mots de passe correspondant à la méthode spécifiée, ou null si la méthode n'est pas valide.
     */
    public static PasswordCracker getInstance(String methodCrackage) {
        PasswordCracker passwordCracker = null;
        if (methodCrackage.equals("DICTIONNAIRE")) {
            passwordCracker = new DictionnaryCracker();
        } else if (methodCrackage.equals("BRUTEFORCE")) {
            passwordCracker = new BruteForceCracker();
        }
        return passwordCracker;
    }
}
