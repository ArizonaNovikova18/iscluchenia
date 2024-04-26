public class LoopChecker implements Checker{
    private final String validCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_"
    @Override
    public void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        checkLength(login, true);
        checkLength(password, false);
        checkCharacters(login, true);
        checkCharacters(password, false);
        checkPassword(password, confirmPassword);
    }

    private void checkLength(String s, boolean login) throws WrongLoginException, WrongPasswordException {
       if (s != null && s.length()<=20) {
           return;
       }
       throwException(login, "Некорректная длина");
    }
    private void checkCharacters(String s, boolean login) throws WrongLoginException, WrongPasswordException{
        if (s == null){
            throwException(login, "nulll");
        }
        char[] chars = s.toCharArray();
        for (char ch : chars){
            if (validCharacters.contains(Character.toString(ch))){
                continue;
            }
           throwException(login, "Некорректный символ");
        }
    }
    private void throwException(boolean login, String message) throws WrongLoginException, WrongPasswordException{
        if (login){
            throw new WrongLoginException(message);
        }else {
            throw new WrongPasswordException(message);
        }
    }
}
