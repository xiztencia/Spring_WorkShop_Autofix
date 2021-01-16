package se.iths.autofix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.iths.autofix.entity.Maintenance;
import se.iths.autofix.entity.SparePart;
import se.iths.autofix.exception.BadInputFormatException;
import se.iths.autofix.exception.MaintenanceNotFoundException;
import se.iths.autofix.exception.SparepartNotFoundException;
import se.iths.autofix.service.SparePartService;

import java.util.Optional;

@RestController
@RequestMapping(path={"/api/sparepart"})
public class SparePartController {

    private SparePartService sparePartService;

    public SparePartController(SparePartService sparePartService) {
        this.sparePartService = sparePartService;
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasRole('ADMIN')")
    @PostMapping("/create")
    public SparePart createSparePart(@RequestBody SparePart sparePart) {
        if(sparePart.getPart().isEmpty()){
            throw new BadInputFormatException("Fill in spare part name.");
        }
        return sparePartService.createSparePart(sparePart);
    }

    @PutMapping("/update/{id}")
    public SparePart updateSparePart(@RequestBody SparePart newSparePart, @PathVariable Long id) {
        return sparePartService.updateSparePart(newSparePart, id);
    }

    @GetMapping("/findall")
    public Iterable<SparePart> findAllSpareParts() {
        return sparePartService.findAllSpareParts();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findSparePartById(@PathVariable Long id) {
        if(id<=0){
            throw new SparepartNotFoundException("The spare part id was not found.");
        }
        return ResponseEntity.ok(sparePartService.findSparePartById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteSparePart(@PathVariable Long id) {
        sparePartService.deleteSparePart(id);
    }

    @GetMapping("/findbyclient/{id}")
    public Iterable<SparePart> getAllSparePartsByClient(@PathVariable Long id) {
        return sparePartService.findSparePartsByClientId(id);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasRole('ADMIN')")
    @GetMapping("/findallsparepartsbyclientusername/{nameUser}")
    Iterable<SparePart> findAllSparePartsByClientUsername(@PathVariable String nameUser) {
        return sparePartService.findAllSparePartsByClientUsername(nameUser);
    }

//    @GetMapping("/findallsparepartsbyemployee/{id}")
//    public Iterable<SparePart> getAllSparePartsByEmployee(@PathVariable Long id) {
//        return sparePartService.findSparePartsByEmployeeId(id);
//    }
//
//    @GetMapping("/findallsparepartsbyemployeeusername")
//    Iterable<SparePart> findAllSparePartsByEmployeeUsername() {
//        return sparePartService.findAllSparePartsByEmployeeUsername();
//    }

}
