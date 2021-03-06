package se.iths.autofix.service;

import org.springframework.stereotype.Service;
import se.iths.autofix.entity.SparePart;
import se.iths.autofix.exception.BadInputFormatException;
import se.iths.autofix.exception.SparepartNotFoundException;
import se.iths.autofix.repository.SparePartRepository;

import java.util.Optional;

@Service
public class SparePartService {

    private SparePartRepository sparePartRepository;

    public SparePartService(SparePartRepository sparePartRepository){
        this.sparePartRepository = sparePartRepository;
    }

    public SparePart createSparePart(SparePart sparePart){
        if(sparePart.getPrice()>=0 && sparePart.getQuantity()>0){
        return sparePartRepository.save(sparePart);
        }else{
            throw new BadInputFormatException("Price/quantity can not be of negative value.");
        }
    }

    public SparePart updateSparePart(SparePart newSparePart, Long id){
        if(newSparePart.getPrice()>=0 && newSparePart.getQuantity()>0){
            return sparePartRepository.findById(id)
                    .map(sparePart -> {
                        sparePart.setPart(newSparePart.getPart());
                        sparePart.setCategory(newSparePart.getCategory());
                        sparePart.setPrice(newSparePart.getPrice());
                        sparePart.setQuantity(newSparePart.getQuantity());
                        return sparePartRepository.save(sparePart);
                    })
                    .orElseThrow(()-> new SparepartNotFoundException("SparePart has not been found.")
                    );
        }else{
            throw new BadInputFormatException("Price/quantity can not be of negative value.");
        }
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

    public Iterable<SparePart> findAllSparePartsByClientUsername(String nameUser) {
        Iterable<SparePart> allSparePartsByClientUsername;
        allSparePartsByClientUsername = sparePartRepository.findAllSparePartsByClientUsername(nameUser);
        return allSparePartsByClientUsername;
    }


}
