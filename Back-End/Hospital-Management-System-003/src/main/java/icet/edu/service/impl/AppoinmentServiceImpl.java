package icet.edu.service.impl;

import icet.edu.dto.Appoinment;
import icet.edu.entity.AppoinmentEntity;
import icet.edu.repository.AppoimentRepository;
import icet.edu.service.AppoinmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppoinmentServiceImpl implements AppoinmentService {

    final AppoimentRepository repository;
    final ModelMapper mapper;
    @Override
    public void addAppoinment(Appoinment appoinment) {
        repository.save(mapper.map(appoinment, AppoinmentEntity.class));
    }

    @Override
    public boolean deleteById(Integer id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Appoinment> getAll() {
        List<Appoinment> appoinmentList= new ArrayList<>();
        repository.findAll().forEach(entity->{
            appoinmentList.add(mapper.map(entity,Appoinment.class));
        });
        return appoinmentList;
    }

    @Override
    public Appoinment getAppoinmentById(Integer id) {
        return mapper.map(repository.findAllById(id),Appoinment.class);
    }

    @Override
    public List<Appoinment> getAppoinmentByAdminId(Integer id) {
        List<Appoinment> AppoinmentList = new ArrayList<>();
        repository.findByAdminId(id).forEach(entity -> {
            AppoinmentList.add(mapper.map(entity, Appoinment.class));
        });
        return AppoinmentList;
    }
}
