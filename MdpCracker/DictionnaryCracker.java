import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;


public class DictionnaryCracker implements PasswordCracker{
    // public static void main(String[] args) throws Exception {
    //   DictionnaryCracker dic = new DictionnaryCracker();
    //   System.out.println(dic.trouverMdpHash("67268008d8d89be0e94907d0a98143f3", "MD5"));
    // }

    @Override
    public String trouverMdpHash(String hashDonne, String algo) throws Exception {
      String resultat = "" ;
        boolean isPasswordFound = false;

        try {
            File dictionnaire = new File("dictionary.txt");
            Scanner myReader = new Scanner(dictionnaire);
            while (myReader.hasNextLine()) {
              String mot = myReader.nextLine();
              String motHashe = hasheur(mot, algo);
              System.out.println("comparaison avec " + motHashe);
              if(motHashe.equals(hashDonne)){
                    resultat = mot;
                    isPasswordFound = true;
              }
              
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          if (!isPasswordFound) {
            System.out.println("non trouve");
          } 

        return resultat;
       
    }

    @Override
    public String trouverMdpClair(String MdpCorrect) {
        String resultat = "" ;
        boolean isPasswordFound = false;

        try {
            File dictionnaire = new File("dictionary.txt");
            Scanner myReader = new Scanner(dictionnaire);
            while (myReader.hasNextLine()) {
              String mot = myReader.nextLine();
              System.out.println("comparaison avec " + mot);
              if(mot.equals(MdpCorrect)){
                    resultat = mot;
                    isPasswordFound = true;
              }
              
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          if (!isPasswordFound) {
            System.out.println("non trouve");
          } 

        return resultat;
       
    }
    public String hasheur(String motAhacher, String algo) throws Exception{
      String hashe = "";
        MessageDigest msg = MessageDigest.getInstance(algo);
        byte[] hash = msg.digest(motAhacher.getBytes(StandardCharsets.UTF_8));
        // convertir bytes en hexadécimal
        StringBuilder s = new StringBuilder();
        for (byte b : hash) {
            s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        hashe = s.toString();
      return hashe;
    }

    
    
}
