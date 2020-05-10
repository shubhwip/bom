package com.bom.materials.controllers;

import com.bom.materials.model.Bom;
import com.bom.materials.model.BomResponse;
import com.bom.materials.service.BomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BomService bomService;

    private final static String BOM_ROOT_PATH = "/boms";
    private final static String BOM_CREATE_PATH = BOM_ROOT_PATH + "/create";
    private final static String BOM_GET_ALL_PATH = BOM_ROOT_PATH + "/all";
    private final static String BOM_GET_ALL_BY_ENVIRONMENT_PATH = BOM_ROOT_PATH + "/production/all";

    private final static String VALID_BOM = "{\"serviceName\":\"dummy-service1\",\"serviceVersion\":\"1.0.0\",\"environment\":\"production\",\"versionControlCheckoutHash\":\"khbackhbackbakcbkabc\",\"commitAuthor\":\"Shubham Jain\"}";
    private final static String INVALID_BOM = "{\"serviceName\":\"dummy-service1\",\"serviceVersion\":\"1.0.0\",\"environment\":\"production\"}";


    @Test
    public void givenValidBom_createBom_returnsSuccess() throws Exception {
        doNothing().when(bomService).saveBom(isA(Bom.class));
        this.mockMvc.perform(post(BOM_CREATE_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(VALID_BOM))
                .andExpect(status().isCreated());
    }

    @Test
    public void givenInvalidBom_createBom_returnsBadRequest() throws Exception {
        doThrow(HttpClientErrorException.BadRequest.class).when(bomService).saveBom(isA(Bom.class));
        this.mockMvc.perform(post(BOM_CREATE_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(INVALID_BOM))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void givenInsertedAllBoms_getAllBoms_returnsAllBoms() throws Exception {
        when(bomService.findAllBoms()).thenReturn(Arrays.asList(
                new BomResponse("dummy-service1", "1.0.0", "production", "cbskbckdbckbdkabckjbdckbdc", "Shubham Jain"),
                new BomResponse("dummy-service2", "1.0.1", "staging", "csdjkcnbjkdsnbcjkdncjkndjkccjnk", "Shubham Jain"),
                new BomResponse("dummy-service3", "1.0.2", "test", "cjdncjkdncjkndkjcnkjdnckjndc", "Shubham Jain"),
                new BomResponse("dummy-service4", "1.0.3", "production", "ckjdncjkndjcndjkcnkjdncjkdn", "Shubham Jain")
        ));
        this.mockMvc.perform(get(BOM_GET_ALL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"serviceName\":\"dummy-service1\",\"serviceVersion\":\"1.0.0\",\"environment\":\"production\",\"versionControlCheckoutHash\":\"cbskbckdbckbdkabckjbdckbdc\",\"commitAuthor\":\"Shubham Jain\"},{\"serviceName\":\"dummy-service2\",\"serviceVersion\":\"1.0.1\",\"environment\":\"staging\",\"versionControlCheckoutHash\":\"csdjkcnbjkdsnbcjkdncjkndjkccjnk\",\"commitAuthor\":\"Shubham Jain\"},{\"serviceName\":\"dummy-service3\",\"serviceVersion\":\"1.0.2\",\"environment\":\"test\",\"versionControlCheckoutHash\":\"cjdncjkdncjkndkjcnkjdnckjndc\",\"commitAuthor\":\"Shubham Jain\"},{\"serviceName\":\"dummy-service4\",\"serviceVersion\":\"1.0.3\",\"environment\":\"production\",\"versionControlCheckoutHash\":\"ckjdncjkndjcndjkcnkjdncjkdn\",\"commitAuthor\":\"Shubham Jain\"}]"));
    }

    @Test
    public void givenInsertedAllBoms_getAllBomsOfProduction_returnsAllBomsOfProduction() throws Exception {
        when(bomService.findAllBomsByEnvironment(anyString())).thenReturn(Arrays.asList(
                new BomResponse("dummy-service1", "1.0.0", "production", "cbskbckdbckbdkabckjbdckbdc", "Shubham Jain"),
                new BomResponse("dummy-service4", "1.0.3", "production", "ckjdncjkndjcndjkcnkjdncjkdn", "Shubham Jain")
        ));
        this.mockMvc.perform(get(BOM_GET_ALL_BY_ENVIRONMENT_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"serviceName\":\"dummy-service1\",\"serviceVersion\":\"1.0.0\",\"environment\":\"production\",\"versionControlCheckoutHash\":\"cbskbckdbckbdkabckjbdckbdc\",\"commitAuthor\":\"Shubham Jain\"},{\"serviceName\":\"dummy-service4\",\"serviceVersion\":\"1.0.3\",\"environment\":\"production\",\"versionControlCheckoutHash\":\"ckjdncjkndjcndjkcnkjdncjkdn\",\"commitAuthor\":\"Shubham Jain\"}]"));

    }

}
