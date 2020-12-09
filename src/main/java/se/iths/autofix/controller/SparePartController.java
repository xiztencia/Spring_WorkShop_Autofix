package se.iths.autofix.controller;

import org.springframework.web.bind.annotation.*;
import se.iths.autofix.entity.Item;
import se.iths.autofix.entity.SparePart;
import se.iths.autofix.service.SparePartService;

import java.util.Optional;

@RestController
@RequestMapping("/sparepart")
public class SparePartController {

    private SparePartService sparePartService;

    public SparePartController(SparePartService sparePartService){
        this.sparePartService = sparePartService;
    }

    @PostMapping("/create")
    public SparePart createSparePart(@RequestBody SparePart sparePart){
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

    @DeleteMapping("/delete/{id}")
    public void deleteSparePart(@PathVariable Long id) {
        sparePartService.deleteSparePart(id);
    }

//    @GetMapping("/findbyuser/{id}")
//    public Iterable<SparePart> getAllSparePartsByUser(@PathVariable Long id) {
//        return sparePartService.findSparePartsByUserId(id);
//    }
//
//    @GetMapping("/findallsparepartsbyuser")
//    Iterable<Item> findAllSparePartsByUser() {
//        return sparePartService.findAllByUser();
//    }

}
