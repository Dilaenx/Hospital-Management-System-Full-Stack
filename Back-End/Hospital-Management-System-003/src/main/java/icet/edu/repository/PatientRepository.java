package icet.edu.repository;


import icet.edu.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<PatientEntity,Integer> {
    List<PatientEntity> findByName(String name);

    List<PatientEntity> findByAddress(String address);

    Iterable<Object> findByBloodGroup(String bloodGroup);

    Iterable<Object> findByNic(String nic);
}
