package com.bom.materials.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bomId;

    @NotNull(message = "serviceName - should be provided in the request")
    private String serviceName;

    @NotNull(message = "serviceVersion - should be provided in the request")
    private String serviceVersion;

    @NotNull(message = "environment - should be provided in the request")
    private String environment;

    @NotNull(message = "versionControlCheckoutHash - should be provided in the request")
    private String versionControlCheckoutHash;

    @NotNull(message = "commitAuthor - should be provided in the request")
    private String commitAuthor;

    public Bom(String serviceName, String serviceVersion, String environment, String versionControlCheckoutHash, String commitAuthor) {
        this.serviceName = serviceName;
        this.serviceVersion = serviceVersion;
        this.environment = environment;
        this.versionControlCheckoutHash = versionControlCheckoutHash;
        this.commitAuthor = commitAuthor;
    }
}
