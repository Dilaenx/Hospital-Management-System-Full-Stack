package icet.edu.repository;

import icet.edu.entity.MedicalReportEntity;
import org.springframework.data.repository.CrudRepository;

public interface MedicalReportRepository extends CrudRepository<MedicalReportEntity,Integer>{
    Object findAllById(Integer id);

    Object findAllBypatientId(Integer patientId);



    Iterable<Object> getReportBypatientId(Integer patientId);
}
