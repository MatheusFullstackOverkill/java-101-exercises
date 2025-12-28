package garage_exercise;


class Car extends Vehicle {
    public Car(
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

    public void drift() {
        if(requiredRepair != "") {
            System.out.println("Vehicle cannot perform drift, it requires repair: " + requiredRepair);

            return;
        };

        Integer currentOilLevel = this.engine.getOil();
        if(currentOilLevel < 10) {
            System.out.println("Vehicle cannot perform drift, it requires at least 10 liter of oil.");

            return;
        };

        System.out.println("drifting...");

        Integer newOilLevel = currentOilLevel - 10 < 0 ? 0 : currentOilLevel - 10;
        this.engine.setOil(newOilLevel);
        this.requiredRepair = newOilLevel <= 0 ? "Oil change" : "";

        Double breakdownProbability = Math.random();
        if(breakdownProbability <= 0.75) {
            this.requiredRepair = "Breakdown";
        };

        if (this.requiredRepair != "") {
          System.out.println("The car requires a repair: " + this.requiredRepair + ".");  
        };
    }
}
