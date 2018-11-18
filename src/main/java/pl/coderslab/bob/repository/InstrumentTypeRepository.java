package pl.coderslab.bob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.bob.entity.InstrumentType;

public interface InstrumentTypeRepository extends JpaRepository<InstrumentType, Long> {

}
