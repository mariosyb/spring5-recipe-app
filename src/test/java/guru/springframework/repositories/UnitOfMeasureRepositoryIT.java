package guru.springframework.repositories;

import guru.springframework.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Integration Test
 */
@RunWith(SpringRunner.class) //  enable spring boot features like @Autowire, @MockBean etc
@DataJpaTest // brings a embed database an configures jpa
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() throws Exception {
        Optional<UnitOfMeasure> unitOfMeasureOptional =
                unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", unitOfMeasureOptional.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() throws Exception {
        Optional<UnitOfMeasure> unitOfMeasureOptional =
                unitOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", unitOfMeasureOptional.get().getDescription());
    }
}