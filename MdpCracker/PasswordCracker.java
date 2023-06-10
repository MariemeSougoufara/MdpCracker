public interface PasswordCracker{
    //abstract methods
    public abstract String trouverMdpHash(String hashDonne, String algorithme) throws Exception;
    public abstract String trouverMdpClair(String mdpCorrectATrouver);
}
