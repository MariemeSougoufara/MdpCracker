/**
 * Interface pour les classes de craquage de mots de passe.
 */
public interface PasswordCracker {
    /**
     * abstract methods
     * Recherche du mot de passe correspondant au hash donné
     *
     * @param hashDonne    Le hash du mot de passe à trouver.
     * @param algorithme   L'algorithme de hachage utilisé pour le hash.
     * @return Le mot de passe correspondant ou une chaîne vide si le mot de passe n'est pas trouvé.
     * @throws Exception Si une erreur se produit lors de l'utilisation de l'algorithme de hachage.
     */
    public abstract String trouverMdpHash(String hashDonne, String algorithme) throws Exception;

    /**
     * Recherche du mot de passe correspondant au mot de passe fourni.
     *
     * @param mdpCorrectATrouver Le mot de passe à trouver.
     * @return Le mot de passe correspondant ou une chaîne vide si le mot de passe n'est pas trouvé.
     */
    public abstract String trouverMdpClair(String mdpCorrectATrouver);
}
