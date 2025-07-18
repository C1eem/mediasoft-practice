import java.util.*;
import java.util.stream.Collectors;

public class CarTasks {
    public static void main(String[] args) {
        // task1();
        // task2();
        // task3();
        task4();
    }

    public static void task1() {
        int[] years = new int[50];
        Random random = new Random();

        for (int i = 0; i < years.length; i++) {
            years[i] = 2000 + random.nextInt(26); // 2000-2025
        }

        System.out.println("Машины после 2015 года:");
        Arrays.stream(years)
                .filter(year -> year > 2015)
                .forEach(System.out::println);

        int currentYear = java.time.Year.now().getValue();
        double averageAge = Arrays.stream(years)
                .mapToDouble(year -> currentYear - year)
                .average()
                .orElse(0);
        System.out.printf("Средний возраст авто: %.1f лет\n", averageAge);
    }

    public static void task2() {
        List<String> models = Arrays.asList(
                "Toyota Camry", "BMW X5", "Tesla Model S",
                "Toyota Camry", "Audi A4", "Tesla Model 3",
                "Honda Accord", "BMW X5"
        );

        List<String> uniqueSorted = models.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Уникальные модели (обратный порядок):");
        uniqueSorted.forEach(System.out::println);

        uniqueSorted.replaceAll(model ->
                model.contains("Tesla") ? "ELECTRO_CAR" : model);

        System.out.println("\nПосле замены Tesla:");
        uniqueSorted.forEach(System.out::println);

        Set<String> modelSet = new TreeSet<>(uniqueSorted);
        System.out.println("\nSet моделей:");
        System.out.println(modelSet);
    }

    public static void task3() {
        Set<Car> carSet = new HashSet<>();

        Car car1 = new Car("VIN1", "Camry", "Toyota", 2018, 45000, 25000);
        Car car2 = new Car("VIN2", "X5", "BMW", 2020, 30000, 55000);
        Car car3 = new Car("VIN1", "Corolla", "Toyota", 2015, 60000, 18000); // Дубликат VIN

        System.out.println("Добавление car1: " + carSet.add(car1));
        System.out.println("Добавление car2: " + carSet.add(car2));
        System.out.println("Добавление car3 (дубликат VIN): " + carSet.add(car3));

        System.out.println("\nМашины в Set:");
        carSet.forEach(System.out::println);

        List<Car> sortedCars = new ArrayList<>(carSet);
        Collections.sort(sortedCars);

        System.out.println("\nОтсортировано по году выпуска:");
        sortedCars.forEach(System.out::println);
    }

    public static void task4() {
        List<Car> cars = Arrays.asList(
                new Car("VIN1", "Camry", "Toyota", 2018, 45000, 25000),
                new Car("VIN2", "X5", "BMW", 2020, 30000, 55000),
                new Car("VIN3", "Model S", "Tesla", 2021, 12000, 80000),
                new Car("VIN4", "A4", "Audi", 2019, 49000, 35000),
                new Car("VIN5", "Corolla", "Toyota", 2017, 52000, 18000)
        );

        System.out.println("Машины с пробегом < 50_000 км:");
        cars.stream()
                .filter(car -> car.getMileage() < 50000)
                .forEach(System.out::println);

        System.out.println("\nТоп-3 самые дорогие:");
        cars.stream()
                .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
                .limit(3)
                .forEach(System.out::println);

        double avgMileage = cars.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0);
        System.out.printf("\nСредний пробег: %.2f км\n", avgMileage);

        Map<String, List<Car>> byManufacturer = cars.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));

        System.out.println("\nГруппировка по производителю:");
        byManufacturer.forEach((maker, carList) -> {
            System.out.println(maker + ":");
            carList.forEach(car -> System.out.println("  " + car));
        });
    }
}