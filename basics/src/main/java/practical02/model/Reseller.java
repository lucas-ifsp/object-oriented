package practical02.model;

import java.time.LocalDate;

public final class Reseller extends Employee {

    public Reseller(String id, String name, LocalDate birthDate, double soldValue, Consultant inCharge) {
        super(id, name, birthDate, soldValue, inCharge);
    }

    @Override
    public double getCommission() {
        return soldValue * 0.15;
    }

    public Consultant promote(){
        return new Consultant(id, name, birthDate, soldValue, consultantInCharge);
    }
}
