package practical02.service;

import practical02.model.Consultant;
import practical02.model.Employee;
import practical02.model.Reseller;
import practical02.persistence.EmployeeRepository;
import practical02.persistence.InMemoryEmployeeRepository;

import java.time.LocalDate;

public class EmployeeRegistrationService {
    private final EmployeeRepository repo;

    public EmployeeRegistrationService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public void register(String id, String name, LocalDate birthDate, double soldValue, String inCharge){
        Employee maybeInCharge = repo.findById(inCharge).orElse(null);

        if(maybeInCharge == null){
            repo.save(new Reseller(id, name, birthDate, soldValue, null));
            return;
        }

        Consultant consultant = maybeInCharge instanceof Reseller
                ? ((Reseller) maybeInCharge).promote()
                : (Consultant) maybeInCharge;

        final Reseller newEmployee = new Reseller(id, name, birthDate, soldValue, consultant);
        consultant.addEmployee(newEmployee);

        repo.update(consultant);
        repo.save(newEmployee);
    }
}
