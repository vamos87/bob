package pl.coderslab.bob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.bob.entity.InstrumentType;

import java.util.List;

public interface InstrumentTypeRepository extends JpaRepository<InstrumentType, Long> {
    InstrumentType getInstrumentTypeById(long id);

//    List<InstrumentType> findAllOrderById();
}
