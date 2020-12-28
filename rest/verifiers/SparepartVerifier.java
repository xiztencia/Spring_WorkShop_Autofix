package se.iths.autofix.rest.verifiers;

import se.iths.autofix.entity.SparePart;
import se.iths.autofix.rest.exceptions.BadFormatInputException;
import se.iths.autofix.rest.exceptions.SparepartNotFoundException;
import se.iths.autofix.service.SparePartService;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class SparepartVerifier {
    public BadFormatInputException badformatInput() {
        throw new BadFormatInputException("JSON object with spare part's information must include fields:\n {\n \"part\":\"value\" \n \"category\":\"value\" \n  \"price\":\"value\"\n  \"quantity\":\"value\"\n}\n");
    }

    public void verifySparePart(SparePart sparePart) {
        if (sparePart.getPart() == null || sparePart.getCategory() == null || sparePart.getPrice() == 0)
            badformatInput();
    }

    public List<SparePart> list_sparePartsCheck(List<SparePart> sparepartlist, String message) {
        List<SparePart> sparePartList = sparepartlist;
        if (sparePartList.size() > 0)
            return sparePartList;
        else
            throw new SparepartNotFoundException(message);
    }

    public Response SparePartExist(SparePart foundsparepart, SparePartService sparePartService) {
        if (!(foundsparepart == null)) {
            long removed = foundsparepart.getId();
            sparePartService.deleteSparePart(foundsparepart.getId());
            return Response.ok().entity("Spare part with ID " + removed + " removed from registry").type(MediaType.TEXT_PLAIN_TYPE).build();
        } else {
            throw new SparepartNotFoundException("Spare part attempting to delete is not registered");
        }
    }

    public SparePart SparePartExist(SparePart foundsparepart, Long id) {
        if (foundsparepart != null) {
            return foundsparepart;
        } else {
            throw new SparepartNotFoundException("Not spare part found with id " + id);
        }
    }
}
