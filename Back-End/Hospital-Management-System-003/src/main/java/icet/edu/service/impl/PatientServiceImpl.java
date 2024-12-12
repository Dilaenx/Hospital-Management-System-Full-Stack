package icet.edu.service.impl;

import icet.edu.dto.Patient;
import icet.edu.entity.PatientEntity;
import icet.edu.repository.PatientRepository;
import icet.edu.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    final PatientRepository repository;
    final ModelMapper mapper;



    @Override
    public List<Patient> getPatient() {
        List<Patient> patients = new ArrayList<>();
        repository.findAll().forEach(patient-> patients.add(mapper.map(patient, Patient.class)));

        return patients;
    }

    @Override
    public void addPatient(Patient patient) {

        repository.save(mapper.map(patient, PatientEntity.class));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Patient> searchByName(String name) {
        List<Patient> patient = new ArrayList<>();
        repository.findByName(name).forEach(entity->
            patient.add(mapper.map(entity,Patient.class))
        );
        return patient;
    }

    @Override
    public List<Patient> searchByAddress(String address) {
        List<Patient> patient = new ArrayList<>();
        repository.findByAddress(address).forEach(entity->
                patient.add(mapper.map(entity,Patient.class))
        );
        return patient;
    }

    @Override
    public List<Patient> searchByBloodGroup(String bloodGroup) {
        List<Patient> patient = new ArrayList<>();
        repository.findByBloodGroup(bloodGroup).forEach(entity->
                patient.add(mapper.map(entity,Patient.class)));
        return patient;
    }

    @Override
    public List<Patient> searchBynic(String nic) {
        List<Patient> patient = new ArrayList<>();
        repository.findByNic(nic).forEach(entity->
                patient.add(mapper.map(entity,Patient.class)));
        return patient;
    }
}
