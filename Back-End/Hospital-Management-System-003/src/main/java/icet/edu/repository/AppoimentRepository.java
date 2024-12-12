package icet.edu.repository;

import icet.edu.entity.AppoinmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppoimentRepository extends JpaRepository<AppoinmentEntity,Integer> {
    Object findAllById(Integer id);

    List<AppoinmentEntity> findByAdminId(Integer id);
}
