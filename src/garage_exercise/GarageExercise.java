package garage_exercise;


public class GarageExercise {
    public static void main() {
        Garage garage = new Garage();
        Car car = new Car(
            4,
            4,
            "Chevrolet",
            "Prisma 2018",
            80,
            15,
            15,
            ""
        );
        Motorbike motorbike = new Motorbike(
            2,
            1,
            "Harley Dadiidson",
            "Fat Boy 2026",
            80,
            8,
            8,
            ""
        );

        motorbike.wheelie();

        garage.acceptVehicle(motorbike, motorbike.getRequiredRepair());

        car.drive(15000);

        garage.acceptVehicle(car, car.getRequiredRepair());

        garage.returnVehicle();

        garage.acceptVehicle(car, car.getRequiredRepair());

        System.out.println(motorbike.getMostRecentRepair());
        System.out.println(motorbike.getRepairHistoryByMostExpensivePrice());

        System.out.println(car.getMostRecentRepair());
        System.out.println(car.getRepairHistoryByMostExpensivePrice());
    }
}