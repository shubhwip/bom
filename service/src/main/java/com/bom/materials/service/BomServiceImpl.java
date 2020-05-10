package com.bom.materials.service;

import com.bom.materials.model.Bom;
import com.bom.materials.model.BomId;
import com.bom.materials.model.BomResponse;
import com.bom.materials.repository.BomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BomServiceImpl implements BomService {

    @Autowired
    BomRepository bomRepository;

    @Override
    public void saveBom(Bom bom) {
        boolean isBomPresent = bomRepository
                .findByServiceNameAndEnvironment(bom.getServiceName(), bom.getEnvironment()).isPresent();
        if (isBomPresent) {
            log.info("Updating Existing Bill of Material {}", bom);
            bomRepository.findById(bomRepository
                    .findByServiceNameAndEnvironment(bom.getServiceName(), bom.getEnvironment()).get().getBomId())
                    .map(
                            b -> {
                                b.setVersionControlCheckoutHash(bom.getVersionControlCheckoutHash());
                                b.setServiceVersion(bom.getServiceVersion());
                                b.setCommitAuthor(bom.getCommitAuthor());
                                return bomRepository.save(b);
                            }
                    );
        } else {
            bomRepository.save(bom);
        }

    }

    @Override
    public List<BomResponse> findAllBoms() {
        return bomRepository.findAll().stream()
                .map(b -> new BomResponse(b.getServiceName(), b.getServiceVersion(), b.getEnvironment(), b.getVersionControlCheckoutHash(), b.getCommitAuthor()))
                .collect(Collectors.toList());
    }

    @Override
    public List<BomResponse> findAllBomsByEnvironment(String environment) {
        List<BomResponse> bomResponses = new ArrayList<>();
        bomRepository.findByEnvironment(environment).ifPresent(
                b -> {
                    b.stream()
                            .map(bom -> new BomResponse(bom.getServiceName(), bom.getServiceVersion(),
                                    bom.getEnvironment(), bom.getVersionControlCheckoutHash(), bom.getCommitAuthor()))
                            .forEachOrdered(bomResponses::add);
                }
        );
        return bomResponses;

    }

    @Override
    public BomId findBomByServiceNameAndEnvironment(String service, String environment) {
        return new BomId(bomRepository.findByServiceNameAndEnvironment(service, environment).get().getBomId());
    }

    @Override
    public void updateBom(Bom newBom, long bomId) {
        bomRepository.findById(bomId).map(
                bom -> {
                    bom.setCommitAuthor(newBom.getCommitAuthor());
                    bom.setServiceVersion(newBom.getServiceVersion());
                    bom.setVersionControlCheckoutHash(newBom.getVersionControlCheckoutHash());
                    return bomRepository.save(bom);
                })
                .orElseGet(() -> {
                    newBom.setBomId(bomId);
                    return bomRepository.save(newBom);
                });
    }
}
