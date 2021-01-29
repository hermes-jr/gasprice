package net.cyllene.gasprice;

import net.cyllene.gasprice.model.Car;
import net.cyllene.gasprice.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class GaspriceApplicationTests {
    @Inject
    private CarRepository carRepository;

    @Test
    void contextLoads() {
        assertThat(1).isEqualTo(1);
    }

    @Test
    void h2ShouldBeConfiguredProperlyForCrudTestToWork() {
        Car c1 = new Car();
        c1.setName("Aaaa");
        c1.setVin("Bbbb");
        c1.setEstimatedConsumption(BigDecimal.TEN);
        c1.setImage(new byte[]{});
        assertThat(c1.getId()).isNull();
        c1 = carRepository.save(c1);
        int id = c1.getId();
        Optional<Car> readCar = carRepository.findById(id);
        assertThat(readCar).get().hasNoNullFieldsOrProperties().isNotNull();
    }

}
