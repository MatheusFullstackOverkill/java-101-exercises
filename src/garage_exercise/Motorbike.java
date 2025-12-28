package garage_exercise;


class Motorbike extends Vehicle {

    public Motorbike(
        Integer wheels,
        Integer seats,
        String brand,
        String model,
        Integer horsePower,
        Integer oil,
        Integer maximumOilCapacity,
        String requiredRepair
    ) {
        super(wheels, seats, brand, model, horsePower, oil, maximumOilCapacity, requiredRepair);
    }

    public void wheelie() {
        Integer currentOilLevel = this.engine.getOil();
        if(currentOilLevel < 5) {
            System.out.println("Vehicle cannot perform wheelie, it requires at least 5 liter of oil.");

            return;
        };

        System.out.println("wheeling...");

        Integer newOilLevel = currentOilLevel - 5 < 0 ? 0 : currentOilLevel - 5;
        this.engine.setOil(newOilLevel);

        this.requiredRepair = "Breakdown";

        System.out.println("The motorbike had a breakdown.");
    }
}
