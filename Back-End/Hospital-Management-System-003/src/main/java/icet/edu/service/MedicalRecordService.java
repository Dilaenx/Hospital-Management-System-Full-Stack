package icet.edu.service;

import icet.edu.dto.MedicalReport;

import java.util.List;

public interface MedicalRecordService {
    void addMedicalReport(MedicalReport medicalReport);

    List<MedicalReport> getAll();

    MedicalReport getReportById(Integer id);

    List<MedicalReport> getReportBypatientId(Integer patientId);
}
