import java.util.*;
import java.util.stream.Collectors;

public class CarDealership {
    private Set<DealershipCar> cars = new HashSet<>();

    public boolean addCar(DealershipCar car) {
        return cars.add(car);
    }

    public List<DealershipCar> findByManufacturer(String manufacturer) {
        return cars.stream()
                .filter(car -> car.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }

    public OptionalDouble getAveragePriceByType(CarType type) {
        return cars.stream()
                .filter(car -> car.getType() == type)
                .mapToDouble(DealershipCar::getPrice)
                .average();
    }

    public List<DealershipCar> getCarsSortedByYear() {
        return cars.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Map<CarType, Long> getTypeStatistics() {
        return cars.stream()
                .collect(Collectors.groupingBy(DealershipCar::getType, Collectors.counting()));
    }

    public String getOldestNewestInfo() {
        Optional<DealershipCar> oldest = cars.stream().min(Comparator.comparingInt(DealershipCar::getYear));
        Optional<DealershipCar> newest = cars.stream().max(Comparator.comparingInt(DealershipCar::getYear));

        return String.format("Самая старая: %s\nСамая новая: %s",
                oldest.map(DealershipCar::toString).orElse("нет данных"),
                newest.map(DealershipCar::toString).orElse("нет данных"));
    }
}