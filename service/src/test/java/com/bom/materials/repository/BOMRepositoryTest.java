package com.bom.materials.repository;

import com.bom.materials.model.Bom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class BOMRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BomRepository systemUnderTest;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(entityManager).isNotNull();
        assertThat(systemUnderTest).isNotNull();
    }

    @Test
    void shouldSaveBom_whenSaveCalled() {
        Bom bom = new Bom("dummy-service1", "1.0.0", "production", "khbackhbackbakcbkabc", "Shubham Jain");
        entityManager.persist(bom);
        assertThat(systemUnderTest.findById(bom.getBomId()).get()).isEqualTo(bom);
    }


    @Test
    void shouldGetAllTheBoms_whenGetAllBomsCalled() {
        Bom bom1 = new Bom("dummy-service1", "1.0.0", "production", "cbskbckdbckbdkabckjbdckbdc", "Shubham Jain");
        Bom bom2 = new Bom("dummy-service2", "1.0.1", "staging", "csdjkcnbjkdsnbcjkdncjkndjkccjnk", "Shubham Jain");
        Bom bom3 = new Bom("dummy-service3", "1.0.2", "test", "cjdncjkdncjkndkjcnkjdnckjndc", "Shubham Jain");
        Bom bom4 = new Bom("dummy-service4", "1.0.3", "production", "ckjdncjkndjcndjkcnkjdncjkdn", "Shubham Jain");
        entityManager.persist(bom1);
        entityManager.persist(bom2);
        entityManager.persist(bom3);
        entityManager.persist(bom4);
        assertThat(systemUnderTest.findAll().size()).isEqualTo(4);
    }

    @Test
    void shouldGetAllTheBomsByEnvironment_whenGetAllBomsByEnvironmentCalled() {
        Bom bom1 = new Bom("dummy-service1", "1.0.0", "production", "cbskbckdbckbdkabckjbdckbdc", "Shubham Jain");
        Bom bom2 = new Bom("dummy-service2", "1.0.1", "staging", "csdjkcnbjkdsnbcjkdncjkndjkccjnk", "Shubham Jain");
        Bom bom3 = new Bom("dummy-service3", "1.0.2", "test", "cjdncjkdncjkndkjcnkjdnckjndc", "Shubham Jain");
        Bom bom4 = new Bom("dummy-service4", "1.0.3", "production", "ckjdncjkndjcndjkcnkjdncjkdn", "Shubham Jain");
        entityManager.persist(bom1);
        entityManager.persist(bom2);
        entityManager.persist(bom3);
        entityManager.persist(bom4);
        assertThat(systemUnderTest.findByEnvironment("production").get().size()).isEqualTo(2);
    }
}
