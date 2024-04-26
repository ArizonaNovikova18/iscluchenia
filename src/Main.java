
public class Main {
    public static void main(String[] args) {
String login = "arina";
String password = "13252006";
String confirmPassword = "13252006";
boolean success = AuthService.validate(login, password, confirmPassword);
if (success){
    System.out.println("Проверка пройдена успешно");
}else {
    System.out.println("Проверка не пройдена");
}
    }
}