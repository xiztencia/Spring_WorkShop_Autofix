package se.iths.autofix.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.iths.autofix.entity.SparePart;
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
        return sparePartService.createSparePart(sparePart);
    }

    @GetMapping("/findall")
    public Iterable<SparePart> findAllSpareParts() {
        return sparePartService.findAllSpareParts();
    }

    @GetMapping("/id/{id}")
    public Optional<SparePart> findSparePartById(@PathVariable Long id) {
        return sparePartService.findSparePartById(id);
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

    //TODO Lägga en Employee endpoint för att söka på clienter

    @GetMapping("/findallsparepartsbyclientusername/{nameUser}")
    Iterable<SparePart> findAllSparePartsByClientUsername(@PathVariable String nameUser) {
        return sparePartService.findAllSparePartsByClientUsername(nameUser);
    }

    @GetMapping("/findallsparepartsbyemployee/{id}")
    public Iterable<SparePart> getAllSparePartsByEmployee(@PathVariable Long id) {
        return sparePartService.findSparePartsByEmployeeId(id);
    }

    @GetMapping("/findallsparepartsbyemployeeusername")
    Iterable<SparePart> findAllSparePartsByEmployeeUsername() {
        return sparePartService.findAllSparePartsByEmployeeUsername();
    }

}
