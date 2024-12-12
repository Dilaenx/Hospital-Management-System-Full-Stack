package icet.edu.controller;

import icet.edu.dto.MedicalReport;
import icet.edu.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/medical-report")
@RequiredArgsConstructor
public class MedicalReportController {

    final MedicalRecordService service;

    @PostMapping("/add-report")
    public void medicalReport(@RequestBody MedicalReport medicalReport){
        service.addMedicalReport(medicalReport);
    }
    @GetMapping("/get-all-report")
    public List<MedicalReport> viewMedicalReport(){
        return service.getAll();
    }
    @GetMapping("/get-report-by-id/{id}")
    public MedicalReport getReportById(@PathVariable Integer id){
        return service.getReportById(id);
    }
    @GetMapping("/get-report-by-patientId/{patientId}")
    public List<MedicalReport> getReportBypatientId(@PathVariable Integer patientId){
        return service.getReportBypatientId(patientId);
    }

}
