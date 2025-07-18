import java.util.*;

public class CarDealershipSystem {
    public static void main(String[] args) {
        CarDealership dealership = new CarDealership();
        Scanner scanner = new Scanner(System.in);

        dealership.addCar(new DealershipCar("VIN1", "Camry", "Toyota", 2018, 45000, 25000, CarType.SEDAN));
        dealership.addCar(new DealershipCar("VIN2", "X5", "BMW", 2020, 30000, 55000, CarType.SUV));
        dealership.addCar(new DealershipCar("VIN3", "Model S", "Tesla", 2021, 12000, 80000, CarType.ELECTRIC));

        while (true) {
            System.out.println("\nМеню автоцентра:");
            System.out.println("1. Добавить машину");
            System.out.println("2. Найти машины по производителю");
            System.out.println("3. Средняя цена по типу");
            System.out.println("4. Список машин по году выпуска");
            System.out.println("5. Статистика");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCarMenu(dealership, scanner);
                    break;
                case 2:
                    findManufacturerMenu(dealership, scanner);
                    break;
                case 3:
                    averagePriceMenu(dealership, scanner);
                    break;
                case 4:
                    showCarsByYear(dealership);
                    break;
                case 5:
                    showStatistics(dealership);
                    break;
                case 0:
                    System.out.println("Выход из программы");
                    return;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }

    private static void addCarMenu(CarDealership dealership, Scanner scanner) {
        System.out.println("\nДобавление новой машины:");

        System.out.print("VIN: ");
        String vin = scanner.nextLine();

        System.out.print("Модель: ");
        String model = scanner.nextLine();

        System.out.print("Производитель: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Год выпуска: ");
        int year = scanner.nextInt();

        System.out.print("Пробег: ");
        int mileage = scanner.nextInt();

        System.out.print("Цена: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.println("Тип (SEDAN, SUV, ELECTRIC, HATCHBACK, COUPE): ");
        CarType type = CarType.valueOf(scanner.nextLine().toUpperCase());

        DealershipCar car = new DealershipCar(vin, model, manufacturer, year, mileage, price, type);
        if (dealership.addCar(car)) {
            System.out.println("Машина успешно добавлена");
        } else {
            System.out.println("Ошибка: машина с таким VIN уже существует");
        }
    }

    private static void findManufacturerMenu(CarDealership dealership, Scanner scanner) {
        System.out.print("\nВведите производителя: ");
        String manufacturer = scanner.nextLine();

        List<DealershipCar> found = dealership.findByManufacturer(manufacturer);
        if (found.isEmpty()) {
            System.out.println("Машины не найдены");
        } else {
            System.out.println("Найдено " + found.size() + " машин:");
            found.forEach(System.out::println);
        }
    }

    private static void averagePriceMenu(CarDealership dealership, Scanner scanner) {
        System.out.println("\nТип (SEDAN, SUV, ELECTRIC, HATCHBACK, COUPE): ");
        CarType type = CarType.valueOf(scanner.nextLine().toUpperCase());

        dealership.getAveragePriceByType(type)
                .ifPresentOrElse(
                        avg -> System.out.printf("Средняя цена: %.2f\n", avg),
                        () -> System.out.println("Машины такого типа не найдены")
                );
    }

    private static void showCarsByYear(CarDealership dealership) {
        System.out.println("\nМашины по году выпуска (от новых к старым):");
        dealership.getCarsSortedByYear().forEach(System.out::println);
    }

    private static void showStatistics(CarDealership dealership) {
        System.out.println("\nСтатистика автоцентра:");

        System.out.println("\nКоличество машин по типам:");
        dealership.getTypeStatistics().forEach((type, count) ->
                System.out.println(type + ": " + count));

        System.out.println("\n" + dealership.getOldestNewestInfo());
    }
}