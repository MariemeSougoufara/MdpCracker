import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        PasswordCrackerFactory fabricObject = new PasswordCrackerFactory();
        PasswordCracker dictionnaire = fabricObject.getInstance("DICTIONNAIRE");
        PasswordCracker bruteforce = fabricObject.getInstance("BRUTEFORCE");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans notre belle application de craquage de mots de passe !");
        System.out.println("Veuillez choisir la méthode de craquage :");
        System.out.println("1. Brute force");
        System.out.println("2. Dictionnaire");
        int choixMethode = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Veuillez choisir ce que vous voulez cracker :");
        System.out.println("1. Mot de passe");
        System.out.println("2. Hash");
        int choixTypeCraquage = scanner.nextInt();
        scanner.nextLine();

        if (choixMethode == 1) {
            if (choixTypeCraquage == 1) {
                System.out.println("Veuillez entrer le mot de passe svp :");
                String mdp = scanner.nextLine();
                scanner.nextLine();
                String resultat = bruteforce.trouverMdpClair(mdp);
                System.out.println("Le résultat est : " + resultat);
            }

            else if (choixTypeCraquage == 2) {
                System.out.println("Veuillez entrer le hash svp :");
                String mdp = scanner.nextLine();
                scanner.nextLine();
                String resultat = bruteforce.trouverMdpHash(mdp, "SHA-256");
                System.out.println("Le résultat est : " + resultat);
            }
 
            else {
                System.out.println("Veuillez chosir parmi les options !");
            }
        }

        else if (choixMethode == 2) {
            if (choixTypeCraquage == 1) {
                System.out.println("Veuillez entrer le mot de passe svp :");
                String mdp = scanner.nextLine();
                scanner.nextLine();
                String resultat = dictionnaire.trouverMdpClair(mdp);
                System.out.println("Le résultat est : " + resultat);
            }

            else if (choixTypeCraquage == 2) {
                System.out.println("Veuillez entrer le hash svp :");
                String mdp = scanner.nextLine();
                scanner.nextLine();
                String resultat = dictionnaire.trouverMdpHash(mdp, "SHA-256");
                System.out.println("Le résultat est : " + resultat);
            } else {
                System.out.println("Veuillez chosir parmi les options !");
            }

        }

        else {
            System.out.println("Veuillez chosir parmi les options !");
        }

    }

}
