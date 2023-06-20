import java.util.Scanner;

public class PasswordCrackerApp {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans notre belle application de craquage de mots de passe !");
        System.out.println("Veuillez choisir la méthode de craquage :");
        System.out.println("1. Brute force");
        System.out.println("2. Dictionnaire");
        int choixMethode = scanner.nextInt();
        scanner.nextLine(); // Consomme le saut de ligne après la saisie de l'entier

        System.out.println("Veuillez choisir ce que vous voulez cracker :");
        System.out.println("1. Mot de passe");
        System.out.println("2. Hash");
        int choixTypeCraquage = scanner.nextInt();
        scanner.nextLine(); // Consomme le saut de ligne après la saisie de l'entier

        if (choixMethode == 1) {
            if (choixTypeCraquage == 1) {
                // Méthode brute force - Casse par mot de passe
                BruteForceCracker bruteForceCracker = new BruteForceCracker();
                // Demande à l'utilisateur de saisir le mot de passe à casser
                System.out.println("Veuillez saisir le mot de passe à casser :");
                String motDePasse = scanner.nextLine();
                String motDePasseTrouve = bruteForceCracker.trouverMdpClair(motDePasse);
                if (!motDePasseTrouve.isEmpty()) {
                    System.out.println("Mot de passe trouvé : " + motDePasseTrouve);
                } else {
                    System.out.println("Mot de passe non trouvé.");
                }
            } else if (choixTypeCraquage == 2) {
                // Méthode brute force - Casse par hash
                BruteForceCracker bruteForceCracker = new BruteForceCracker();
                // Demande à l'utilisateur de saisir le hash à casser
                System.out.println("Veuillez saisir le hash à casser :");
                String hash = scanner.nextLine();
                String motDePasseTrouve = bruteForceCracker.trouverMdpHash(hash, "MD5");
                if (!motDePasseTrouve.isEmpty()) {
                    System.out.println("Mot de passe trouvé : " + motDePasseTrouve);
                } else {
                    System.out.println("Mot de passe non trouvé.");
                }
            } else {
                System.out.println("Choix invalide !");
            }
        } else if (choixMethode == 2) {
            if (choixTypeCraquage == 1) {
                // Méthode par dictionnaire - Casse par mot de passe
                DictionnaryCracker dictionnaryCracker = new DictionnaryCracker();
                // Demande à l'utilisateur de saisir le mot de passe à casser
                System.out.println("Veuillez saisir le mot de passe à casser :");
                String motDePasse = scanner.nextLine();
                String motDePasseTrouve = dictionnaryCracker.trouverMdpClair(motDePasse);
                if (!motDePasseTrouve.isEmpty()) {
                    System.out.println("Mot de passe trouvé : " + motDePasseTrouve);
                } else {
                    System.out.println("Mot de passe non trouvé.");
                }
            } else if (choixTypeCraquage == 2) {
                // Méthode par dictionnaire - Casse par hash
                DictionnaryCracker dictionnaryCracker = new DictionnaryCracker();
                // Demande à l'utilisateur de saisir le hash à casser
                System.out.println("Veuillez saisir le hash à casser :");
                String hash = scanner.nextLine();
                String motDePasseTrouve = dictionnaryCracker.trouverMdpHash(hash, "MD5");
                if (!motDePasseTrouve.isEmpty()) {
                    System.out.println("Mot de passe trouvé : " + motDePasseTrouve);
                } else {
                    System.out.println("Mot de passe non trouvé.");
                }
            } else {
                System.out.println("Choix invalide !");
            }
        } else {
            System.out.println("Choix invalide !");
        }

        scanner.close();
    }
}
