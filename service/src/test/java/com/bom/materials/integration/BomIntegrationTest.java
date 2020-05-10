package com.bom.materials.integration;

import com.bom.materials.model.Bom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BomIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final static String BOM_PATH = "/boms";


    @Test
    public void givenValidBom_createBom_returnsSuccess() {
        final Bom bom = new Bom("dummy-service1", "1.0.0", "production", "khbackhbackbakcbkabc", "Shubham Jain");
        ResponseEntity<Void> rs = restTemplate.postForEntity(
                String.format("%s", BOM_PATH + "/create"),
                bom,
                Void.class
        );
        Assertions.assertEquals(HttpStatus.CREATED, rs.getStatusCode());
    }

// TODO Make below test work
//    @Test
//    public void givenNothing_getAllBoms_returnsListOfBoms() {
//
//
//        // Given
//        Bom bom1 = new Bom("dummy-service1", "1.0.0", "production", "cbskbckdbckbdkabckjbdckbdc", "Shubham Jain");
//        Bom bom2 = new Bom("dummy-service2", "1.0.1", "staging", "csdjkcnbjkdsnbcjkdncjkndjkccjnk", "Shubham Jain");
//        Bom bom3 = new Bom("dummy-service3", "1.0.2", "test", "cjdncjkdncjkndkjcnkjdnckjndc", "Shubham Jain");
//        Bom bom4 = new Bom("dummy-service4", "1.0.3", "production", "ckjdncjkndjcndjkcnkjdncjkdn", "Shubham Jain");
//
//        restTemplate.postForEntity(
//                String.format("%s", BOM_PATH + "/create"),
//                bom1,
//                Void.class
//        );
//
//        restTemplate.postForEntity(
//                String.format("%s", BOM_PATH + "/create"),
//                bom2,
//                Void.class
//        );
//
//        restTemplate.postForEntity(
//                String.format("%s", BOM_PATH + "/create"),
//                bom3,
//                Void.class
//        );
//
//        restTemplate.postForEntity(
//                String.format("%s", BOM_PATH + "/create"),
//                bom4,
//                Void.class
//        );
//
//        // When
//        ResponseEntity<Bom[]> rs = restTemplate.getForEntity(
//                String.format("%s", BOM_PATH + "/all"),
//                Bom[].class
//        );
//
//        // Then
//        Assertions.assertEquals(4, rs.getBody().length);
//    }
//
//    @Test
//    public void givenNothing_getAllBomsByEnvironment_returnsListOfBomsByEnvironment() {
//
//        // Given
//        Bom bom1 = new Bom("dummy-service1", "1.0.0", "production", "cbskbckdbckbdkabckjbdckbdc", "Shubham Jain");
//        Bom bom2 = new Bom("dummy-service2", "1.0.1", "staging", "csdjkcnbjkdsnbcjkdncjkndjkccjnk", "Shubham Jain");
//        Bom bom3 = new Bom("dummy-service3", "1.0.2", "test", "cjdncjkdncjkndkjcnkjdnckjndc", "Shubham Jain");
//        Bom bom4 = new Bom("dummy-service4", "1.0.3", "production", "ckjdncjkndjcndjkcnkjdncjkdn", "Shubham Jain");
//
//        restTemplate.postForEntity(
//                String.format("%s", BOM_PATH + "/create"),
//                bom1,
//                Void.class
//        );
//
//        restTemplate.postForEntity(
//                String.format("%s", BOM_PATH + "/create"),
//                bom2,
//                Void.class
//        );
//
//        restTemplate.postForEntity(
//                String.format("%s", BOM_PATH + "/create"),
//                bom3,
//                Void.class
//        );
//
//        restTemplate.postForEntity(
//                String.format("%s", BOM_PATH + "/create"),
//                bom4,
//                Void.class
//        );
//
//        // When
//        ResponseEntity<Bom[]> rs = restTemplate.getForEntity(
//                String.format("%s", BOM_PATH + "/production/all"),
//                Bom[].class
//        );
//
//        // Then
//        Assertions.assertEquals(2, rs.getBody().length);
//    }

    @Test
    public void givenValidServiceAndValidEnvironmentName_getVersionInfo_returnsSuccess() {
    }

    @Test
    public void givenInValidServiceAndValidEnvironmentName_getVersionInfo_returnsFailure() {
    }

    @Test
    public void givenValidServiceAndInValidEnvironmentName_getVersionInfo_returnsFailure() {
    }

    @Test
    public void givenInValidServiceAndInValidEnvironmentName_getVersionInfo_returnsFailure() {
    }

    @Test
    public void givenValidEnvironmentName_getAllServicesAndItsVersions_returnsSuccess() {
    }

    @Test
    public void givenInValidEnvironmentName_getAllServicesAndItsVersions_returnsFailures() {
    }

    @Test
    public void givenValidServiceName_getVersionsOnAllEnvironments_returnsSuccess() {
    }

    @Test
    public void givenInvalidServiceName_getVersionsOnAllEnvironments_returnsFailure() {
    }

}
