package IS442_Quantum.backend.Service.services;

import IS442_Quantum.backend.Model.Vendor;

import java.util.List;
import java.util.Optional;

public interface VendorService {
    Vendor saveVendor(Vendor vendor);
    Optional<Vendor> findVendorById(Long id);
    List<Vendor> findAllVendors();
}
