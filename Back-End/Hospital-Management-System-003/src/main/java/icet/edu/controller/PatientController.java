package icet.edu.controller;

import icet.edu.service.PatientService;
import icet.edu.dto.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class PatientController {


    final PatientService service;

    @GetMapping("/get-all")
    public List<Patient> getPatient(){
        return service.getPatient();
    }

    @PostMapping("/add-patient")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPatient(@RequestBody Patient patient){
        service.addPatient(patient );
    }

    @DeleteMapping("delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updatePatient(@RequestBody Patient patient){
        service.addPatient(patient );
    }

    @GetMapping("search-by-name/{name}")
    public List<Patient> searchByName(@PathVariable String name){
        return service.searchByName(name);
    }

    @GetMapping("search-by-address/{address}")
    public List<Patient> searchByAddress(@PathVariable String address){
        return service.searchByAddress(address);
    }

    @GetMapping("search-by-bloodGroup/{bloodGroup}")
    public List<Patient> bloodGroup(@PathVariable String bloodGroup){
        return service.searchByBloodGroup(bloodGroup);
    }

    @GetMapping("search-by-nic/{nic}")
    public List<Patient> nic(@PathVariable String nic){
        return service.searchBynic(nic);
    }

}
