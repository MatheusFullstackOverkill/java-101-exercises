package garage_exercise;


class Engine {
    private Integer horsePower;
    private Integer oil;
    private Integer maximumOilCapacity;

    public Engine(
        Integer horsePower,
        Integer oil,
        Integer maximumOilCapacity
    ) {
        this.horsePower = horsePower;
        this.oil = oil;
        this.maximumOilCapacity = maximumOilCapacity;
    }

    public void setOil(Integer oil) {
        this.oil = oil;
    }

    public Integer getHorsePower() {
        return this.horsePower;
    }

    public Integer getOil() {
        return this.oil;
    }

    public Integer getMaximumOilCapacity() {
        return this.maximumOilCapacity;
    }
}
