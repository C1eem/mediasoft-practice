public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Иван Иванов");
        BankAccount account2 = new BankAccount("Петр Петров");

        // Пополнение
        System.out.println("Пополнение 1000 на account1: " + account1.deposit(1000));
        System.out.println("Баланс account1: " + account1.getBalance());

        // Снятие
        System.out.println("Снятие 500 с account1: " + account1.withdraw(500));
        System.out.println("Баланс account1: " + account1.getBalance());

        // Перевод
        System.out.println("Перевод 200 с account1 на account2: " + account1.transfer(account2, 200));
        System.out.println("Баланс account1: " + account1.getBalance());
        System.out.println("Баланс account2: " + account2.getBalance());

        // Некорректные операции
        System.out.println("Попытка снять больше чем есть: " + account1.withdraw(1000));
        System.out.println("Попытка перевести на заблокированный счет: ");
        account2.setBlocked(true); // для теста делаем счет заблокированным
        System.out.println(account1.transfer(account2, 100));
    }
}