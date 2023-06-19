public class PasswordCrackerFactory {
    public static PasswordCracker getInstance (String methodCrackage) {

        PasswordCracker passwordCracker = null;
        if (methodCrackage.equals("DICTIONNAIRE")) 
            {
                passwordCracker = new DictionnaryCracker();
            }
        else if (methodCrackage.equals("BRUTEFORCE"))
            {
                passwordCracker = new BruteForceCracker();
            }
        
        return passwordCracker;
    }
}
