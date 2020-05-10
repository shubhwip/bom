package com.bom.materials.smoke;

import com.bom.materials.controllers.BomController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BomSmokeTest {

    @Autowired
    private BomController bomController;

    @Test
    public void contextLoads() {
        assertThat(bomController).isNotNull();
    }

}
