package garage_exercise;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

abstract class Vehicle {
    private Integer wheels;
    private Integer seats;
    private String brand;
    private String model;
    protected Engine engine;
    protected String requiredRepair;
    protected ArrayList<RepairItem> repairHistory = new ArrayList<>();

    public Vehicle(
        Integer wheels,
        Integer seats,
        String brand,
        String model,
        Integer horsePower,
        Integer oil,
        Integer maximumOilCapacity,
        String requiredRepair
    ) {
        this.engine = new Engine(
            horsePower,
            oil,
            maximumOilCapacity
        );
        this.requiredRepair = requiredRepair;
        this.wheels = wheels;
        this.seats = seats;
        this.brand = brand;
        this.model = model;
    }

    public Integer getWheels() {
        return this.wheels;
    }

    public Integer getSeats() {
        return this.seats;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public String getRequiredRepair() {
        return this.requiredRepair;
    }

    public void setRequiredRepair(String requiredRepair) {
        this.requiredRepair = requiredRepair;
    }

    public List<RepairItem> getRepairHistoryByMostExpensivePrice() {
        List<RepairItem> sortedRepairHistory =
        repairHistory.stream()
        .sorted((a, b) -> a.price().compareTo(b.price()))
        .collect(Collectors.toList())
        .reversed();

        return sortedRepairHistory;
    }

    public RepairItem getMostRecentRepair() throws IndexOutOfBoundsException {
        RepairItem mostRecentRepair =
        repairHistory.stream()
        .sorted((a, b) -> a.createdAt().compareTo(b.createdAt()))
        .collect(Collectors.toList())
        .reversed()
        .get(0);

        return mostRecentRepair;
    }

    public void addRepairToHistory(String name, double price) {
        this.repairHistory.add(new RepairItem(name, price, LocalDateTime.now()));
    }

    public void drive(Integer kms) {
        if(requiredRepair != "") {
            System.out.println("Vehicle cannot drive, it requires the repair: " + requiredRepair);

            return;
        };

        System.out.println("driving...");

        Integer currentOilLevel = this.engine.getOil();
        Integer newOilLevel = ((currentOilLevel * 1000) - kms) / 1000;
        newOilLevel = newOilLevel < 0 ? 0 : newOilLevel;

        this.engine.setOil(newOilLevel);
        this.requiredRepair = newOilLevel <= 0 ? "Oil change" : "";

        if (this.requiredRepair != "") {
          System.out.println("The car requires a repair: " + this.requiredRepair);  
        };
    }

}
