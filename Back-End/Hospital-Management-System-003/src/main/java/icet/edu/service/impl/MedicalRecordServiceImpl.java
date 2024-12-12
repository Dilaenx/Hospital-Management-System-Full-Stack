package icet.edu.service.impl;

import icet.edu.dto.MedicalReport;
import icet.edu.entity.MedicalReportEntity;
import icet.edu.repository.MedicalReportRepository;
import icet.edu.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    final ModelMapper mapper;
    final MedicalReportRepository repository;
    @Override
    public void addMedicalReport(MedicalReport medicalReport) {
        repository.save(mapper.map(medicalReport, MedicalReportEntity.class));
    }

    @Override
    public List<MedicalReport> getAll() {
        List<MedicalReport> medicalReportsList = new ArrayList<>();
        repository.findAll().forEach(entity->{
           medicalReportsList.add(mapper.map(entity, MedicalReport.class));
        });
        return medicalReportsList;
    }

    @Override
    public MedicalReport getReportById(Integer id) {
        return mapper.map(repository.findAllById(id), MedicalReport.class);
    }

    @Override
    public List<MedicalReport> getReportBypatientId(Integer patientId) {
        List<MedicalReport> medicalReportsList = new ArrayList<>();
        repository.getReportBypatientId(patientId).forEach(entity->{
            medicalReportsList.add(mapper.map(entity,MedicalReport.class));
        });
       return medicalReportsList;
    }
}

