package com.bom.materials.service;

import com.bom.materials.model.Bom;
import com.bom.materials.model.BomResponse;
import com.bom.materials.repository.BomRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BomServiceTest {

    @Mock
    private BomRepository bomRepository;

    @InjectMocks
    private BomServiceImpl bomService;

    private final static String VALID_BOM = "{\"serviceName\":\"dummy-service1\",\"serviceVersion\":\"1.0.0\",\"environment\":\"production\",\"versionControlCheckoutHash\":\"khbackhbackbakcbkabc\",\"commitAuthor\":\"Shubham Jain\"}";
    private final static String INVALID_BOM = "{\"serviceName\":\"dummy-service1\",\"serviceVersion\":\"1.0.0\",\"environment\":\"production\"}";


    @Test
    public void whenValidBom_saveBom() throws Exception {
        // Arrange
        Bom bom = new Bom("dummy-service1", "1.0.0", "production", "cbskbckdbckbdkabckjbdckbdc", "Shubham Jain");
        given(bomRepository.save(bom)).willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        // Act
        bomService.saveBom(bom);

        // Assert
        verify(bomRepository).save(any(Bom.class));
    }

    @Test
    public void whenGetAllBomsCalled_returnsAllTheBoms() throws Exception {
        //Given
        List<BomResponse> expectedBomResponse = Arrays.asList(
                new BomResponse("dummy-service1", "1.0.0", "production", "cbskbckdbckbdkabckjbdckbdc", "Shubham Jain"),
                new BomResponse("dummy-service2", "1.0.1", "staging", "csdjkcnbjkdsnbcjkdncjkndjkccjnk", "Shubham Jain"),
                new BomResponse("dummy-service3", "1.0.2", "test", "cjdncjkdncjkndkjcnkjdnckjndc", "Shubham Jain"),
                new BomResponse("dummy-service4", "1.0.3", "production", "ckjdncjkndjcndjkcnkjdncjkdn", "Shubham Jain")
        );

        List<Bom> expectedBomsFromBomRepository = Arrays.asList(
                new Bom("dummy-service1", "1.0.0", "production", "cbskbckdbckbdkabckjbdckbdc", "Shubham Jain"),
                new Bom("dummy-service2", "1.0.1", "staging", "csdjkcnbjkdsnbcjkdncjkndjkccjnk", "Shubham Jain"),
                new Bom("dummy-service3", "1.0.2", "test", "cjdncjkdncjkndkjcnkjdnckjndc", "Shubham Jain"),
                new Bom("dummy-service4", "1.0.3", "production", "ckjdncjkndjcndjkcnkjdncjkdn", "Shubham Jain")
        );
        doReturn(expectedBomsFromBomRepository).when(bomRepository).findAll();

        //When
        List<BomResponse> actualBoms = bomService.findAllBoms();

        //Then
        Assertions.assertEquals(actualBoms, expectedBomResponse);

    }

    @Test
    public void whenGetAllBomsByEnvironmentCalled_returnsAllTheBomsByEnvironment() throws Exception {
        //Given
        List<BomResponse> expectedBomResponse = Arrays.asList(
                new BomResponse("dummy-service1", "1.0.0", "production", "cbskbckdbckbdkabckjbdckbdc", "Shubham Jain"),
                new BomResponse("dummy-service4", "1.0.3", "production", "ckjdncjkndjcndjkcnkjdncjkdn", "Shubham Jain")
        );

        Optional<List<Bom>> expectedBomsFromBomRepository = Optional.of(Arrays.asList(
                new Bom("dummy-service1", "1.0.0", "production", "cbskbckdbckbdkabckjbdckbdc", "Shubham Jain"),
                new Bom("dummy-service4", "1.0.3", "production", "ckjdncjkndjcndjkcnkjdncjkdn", "Shubham Jain")
        ));
        doReturn(expectedBomsFromBomRepository).when(bomRepository).findByEnvironment(anyString());

        //When
        List<BomResponse> actualBoms = bomService.findAllBomsByEnvironment("production");

        //Then
        Assertions.assertEquals(actualBoms, expectedBomResponse);

    }

}
