package com.bom.materials.service;

import com.bom.materials.model.Bom;
import com.bom.materials.model.BomId;
import com.bom.materials.model.BomResponse;

import java.util.List;

public interface BomService {
    void saveBom(Bom bom);

    List<BomResponse> findAllBoms();

    List<BomResponse> findAllBomsByEnvironment(String environment);

    BomId findBomByServiceNameAndEnvironment(String service, String environment);

    void updateBom(Bom bom, long bomId);

    List<String> findAllEnvironments();
}
