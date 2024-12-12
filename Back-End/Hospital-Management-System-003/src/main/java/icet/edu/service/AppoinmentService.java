package icet.edu.service;

import icet.edu.dto.Appoinment;

import java.util.List;

public interface AppoinmentService {
    void addAppoinment(Appoinment appoinment);

    boolean deleteById(Integer id);


    List<Appoinment> getAll();

    Appoinment getAppoinmentById(Integer id);

    List<Appoinment> getAppoinmentByAdminId(Integer id);
}
