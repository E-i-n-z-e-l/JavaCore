package checkPassword.exceptions;

public class Main {
    public static void main(String[] args) {
        /*
        В блоке "try" выполняется вызов метода "authorize", а в блоке "catch" мы перехватываем
        исключения типов "WrongLoginException" и "WrongPasswordException", которые могут быть
        возбуждены методом "authorize".
         */
        try {
            System.out.println(authorize("login", "password", "passwordf"));
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }


    }

    /**
     * Метод "authorize" используется для аутентификации пользователя и возбуждает исключение,
     * если возникли ошибки при аутентификации.
     *
     * @param login
     * @param password
     * @param confirmPassword
     * @return
     * @throws WrongLoginException
     * @throws WrongPasswordException
     */
    public static boolean authorize(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length() > 20) {
            throw new WrongLoginException();
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("password length is more than 20");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password does not match confirmPassword");
        }

        return false;
    }
}