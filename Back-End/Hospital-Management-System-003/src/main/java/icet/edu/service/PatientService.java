package icet.edu.service;

import icet.edu.dto.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getPatient();
    void addPatient(Patient patient);

    void deleteById(Integer id);

    List<Patient> searchByName(String name);

    List<Patient> searchByAddress(String address);

    List<Patient> searchByBloodGroup(String bloodGroup);

    List<Patient> searchBynic(String nic);
}
