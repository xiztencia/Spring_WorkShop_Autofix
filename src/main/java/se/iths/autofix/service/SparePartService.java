package se.iths.autofix.service;

import org.springframework.stereotype.Service;
import se.iths.autofix.entity.SparePart;
import se.iths.autofix.repository.SparePartRepository;

import java.util.Optional;

@Service
public class SparePartService {

    private SparePartRepository sparePartRepository;

    public SparePartService(SparePartRepository sparePartRepository){
        this.sparePartRepository = sparePartRepository;
    }

    public SparePart createSparePart(SparePart sparePart){
        return sparePartRepository.save(sparePart);
    }

    public void deleteSparePart(Long id){
        Optional<SparePart> foundSparePart = sparePartRepository.findById(id);
        sparePartRepository.deleteById(foundSparePart.get().getId());
    }

    public Optional<SparePart> findSparePartById(Long id) {
        return sparePartRepository.findById(id);
    }

    public Iterable<SparePart> findAllSpareParts() {
        return sparePartRepository.findAll();
    }

    public Iterable<SparePart> findSparePartsByClientId(Long id) {
        return sparePartRepository.findSparePartsByClientId(id);
    }

    public Iterable<SparePart> findAllSparePartsByClientUsername() {
        Iterable<SparePart> allSparePartsByClientUsername = sparePartRepository.findAllSparePartsByClientUsername();
        return allSparePartsByClientUsername;
    }

    public Iterable<SparePart> findSparePartsByEmployeeId(Long id) {
        return sparePartRepository.findSparePartsByEmployeeId(id);
    }

    public Iterable<SparePart> findAllSparePartsByEmployeeUsername() {
        Iterable<SparePart> allSparePartsByEmployeeUsername = sparePartRepository.findAllSparePartsByEmployeeUsername();
        return allSparePartsByEmployeeUsername;
    }
}
