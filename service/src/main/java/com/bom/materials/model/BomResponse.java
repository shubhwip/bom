package com.bom.materials.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BomResponse {

    private String serviceName;

    private String serviceVersion;

    private String environment;

    private String versionControlCheckoutHash;

    private String commitAuthor;
}
