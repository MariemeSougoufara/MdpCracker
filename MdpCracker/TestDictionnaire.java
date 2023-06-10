import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TestDictionnaire {
    public static void main(String[] args) {
        TestDictionnaire dic = new TestDictionnaire();
        System.out.println(dic.trouverMdpClaireMethodeDictionnaire("entrerjjjjjjj"));
      }

      
      public static String trouverMdpClaireMethodeDictionnaire(String MdpCorrect){
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
}
