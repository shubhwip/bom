package com.bom.materials.controllers;

import com.bom.materials.model.Bom;
import com.bom.materials.model.BomId;
import com.bom.materials.model.BomResponse;
import com.bom.materials.service.BomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/boms")
@Validated
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class BomController {

    @Autowired
    private BomService bomServiceImpl;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBom(@RequestBody @Valid Bom bom) {
        log.info("Saving Bill of Materials {}", bom);
        bomServiceImpl.saveBom(bom);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BomResponse>> getAllBoms() {
        log.info("Getting All Bill of Materials");
        return ResponseEntity.ok().body(bomServiceImpl.findAllBoms());
    }

    @GetMapping("/bom/{environment}")
    public ResponseEntity<List<BomResponse>> getBomsPerPage() {
        log.info("Getting All Bill of Materials");
        return ResponseEntity.ok().body(bomServiceImpl.findAllBoms());
    }


    @GetMapping("/{environment}/all")
    public ResponseEntity<List<BomResponse>> getAllBoms(@PathVariable @Valid String environment) {
        log.info("Getting All Bill of Materials By Environment {}", environment);
        return ResponseEntity.ok().body(bomServiceImpl.findAllBomsByEnvironment(environment));
    }

    @GetMapping("{service}/{environment}/get")
    public ResponseEntity<BomId> getBomByServiceAndEnvironment(@PathVariable @Valid String service, @PathVariable @Valid String environment) {
        log.info("Getting All Bill of Materials By Service And Environment {}", service, environment);
        return ResponseEntity.ok().body(bomServiceImpl.findBomByServiceNameAndEnvironment(service, environment));
    }

    @PutMapping("/update/{bomId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateBom(@RequestBody @Valid Bom bom, @PathVariable @Valid long bomId) {
        log.info("Updating Bill of Materials {}", bom);
        bomServiceImpl.updateBom(bom, bomId);
    }

    @GetMapping("/health")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> health() {
        return ResponseEntity.ok().body("Health Ok");
    }

}
