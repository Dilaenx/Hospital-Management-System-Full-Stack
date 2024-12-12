package icet.edu.controller;

import icet.edu.dto.Appoinment;
import icet.edu.service.AppoinmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Appoinment")
@RequiredArgsConstructor
public class AppoinmentController {

    final AppoinmentService appoinmentService;

    @PostMapping("/add-appoinment")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAppoinment(@RequestBody Appoinment appoinment){
        appoinmentService.addAppoinment(appoinment);
    }

    @PutMapping("/update-appoinment")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateAppoinment(@RequestBody Appoinment appoinment){
        appoinmentService.addAppoinment(appoinment);
    }

    @DeleteMapping("/delete-appoinment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteAppoinment(@PathVariable Integer id){
        return appoinmentService.deleteById(id);
    }
    @GetMapping("/view-all-appoinment")
    public List<Appoinment> getAll(){
        return appoinmentService.getAll();
    }
    @GetMapping("/get-appoinment-by-id/{id}")
    public Appoinment getAppoinmentById(@PathVariable Integer id){
        return appoinmentService.getAppoinmentById(id);
    }
    @GetMapping("/get-appoinment-by-admin-id/{id}")
    public List<Appoinment> getAppoinmentByAdminId(@PathVariable Integer id){
        return appoinmentService.getAppoinmentByAdminId(id);
    }
}
