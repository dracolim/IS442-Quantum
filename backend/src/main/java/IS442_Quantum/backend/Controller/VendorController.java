package IS442_Quantum.backend.Controller;

import IS442_Quantum.backend.Model.Vendor;
import IS442_Quantum.backend.Service.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users/vendors")
public class VendorController {

    private VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Vendor>> findAllVendors() {
        List<Vendor> vendors = vendorService.findAllVendors();
        return new ResponseEntity<>(vendors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> findVendorById(@PathVariable Long id) {
        Optional<Vendor> vendor = vendorService.findVendorById(id);
        if (vendor.isPresent()) {
            return new ResponseEntity<>(vendor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
        Vendor savedVendor = vendorService.saveVendor(vendor);
        return new ResponseEntity<>(savedVendor, HttpStatus.CREATED);
    }
}
