import java.security.AlgorithmConstraints;

public class Main {
    public static void main(String[] args) throws Exception {
         PasswordCrackerFactory fabricObject = new PasswordCrackerFactory();
         PasswordCracker dictionnaire = fabricObject.getInstance("DICTIONNAIRE");
         PasswordCracker bruteforce = fabricObject.getInstance("BRUTEFORCE");

  //    dictionnaire.trouverMdpClair("joie");
        String hashDonne = Hasheur.hasheur("joie", "SHA-256");
        bruteforce.trouverMdpClair("pol");
  //      dictionnaire.trouverMdpHash(hashDonne,"SHA-256");
        

        

}

}
