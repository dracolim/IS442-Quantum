package IS442_Quantum.backend.Service.Implementation;

import IS442_Quantum.backend.Model.Vendor;
import IS442_Quantum.backend.Repository.VendorRepository;
import IS442_Quantum.backend.Service.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {
    private VendorRepository vendorRepository;

    @Autowired
    public VendorServiceImpl(VendorRepository vendorRepository){
        this.vendorRepository = vendorRepository;
    }

    @Override
    public Vendor saveVendor(Vendor vendor){
        return vendorRepository.save(vendor);
    }

    @Override
    public Optional<Vendor> findVendorById(Long id) {
        return vendorRepository.findById(id);
    }

    @Override
    public List<Vendor> findAllVendors() {
        return vendorRepository.findAll();
    }
}
