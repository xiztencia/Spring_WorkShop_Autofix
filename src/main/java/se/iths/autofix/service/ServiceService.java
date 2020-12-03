package se.iths.autofix.service;

import org.springframework.stereotype.Service;
import se.iths.autofix.entity.Item;
import se.iths.autofix.repository.ItemRepository;
import se.iths.autofix.repository.ServiceRepository;

import java.util.Optional;

@Service
public class ServiceService {

    private ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
        //this.userService = userService;
    }

    public Service createService(Service service) {
        //item.setUser(userService.getAuthenticatedUser());
        return serviceRepository.save(service);
    }

    public void deleteService(Long id) {
        Optional<Service> foundService = serviceRepository.findById(id);
        serviceRepository.deleteById(foundService.get().getId());
    }

    public Optional<Service> findServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    public Iterable<Service> findAllServices() {
        return serviceRepository.findAll();
    }

    public Iterable<Service> findServicesByUserId(Long id) {
        return serviceRepository.findServicesByUserId(id);
    }

    public Iterable<Service> findAllByUser() {
        Iterable<Item> allServicesByUser = serviceRepository.findAllByUser();
        return allServicesByUser;
    }
}

