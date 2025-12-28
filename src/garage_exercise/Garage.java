package garage_exercise;


class Garage {
    private Vehicle currentVehicle = null;
    private Integer totalVehiclesRepaired = 0;

    void acceptVehicle(Vehicle vehicle, String repairName) {
        if (this.currentVehicle != null) {
            System.out.println("There's already a vehicle in repair: " + this.currentVehicle.getModel() + ", the garage can only repair one vehicle at a time.");

            return;
        };

        this.currentVehicle = vehicle;

        double f = Math.random()/Math.nextDown(1.0);
        double price = 10*(1.0 - f) + 1000*f;
        Integer currentOilLevel = vehicle.engine.getOil();
        Integer maximumOilCapacity = vehicle.engine.getMaximumOilCapacity();
        Integer newCurrentOil = currentOilLevel + 10 > maximumOilCapacity ? maximumOilCapacity : currentOilLevel + 10;

        vehicle.setRequiredRepair("");
        vehicle.addRepairToHistory(repairName, price);
        vehicle.engine.setOil(newCurrentOil);

        this.totalVehiclesRepaired += 1;
    }

    public void returnVehicle() {
        if (this.currentVehicle == null) {
            System.out.println("The garage is already empty.");

            return;
        };

        this.currentVehicle = null;

        System.out.println("The vehicle has returned.");
    }
}
