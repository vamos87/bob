package pl.coderslab.bob.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.bob.entity.InstrumentType;
import pl.coderslab.bob.repository.InstrumentTypeRepository;


public class InstrumentTypeConverter implements Converter<String, InstrumentType> {
    @Autowired
    private InstrumentTypeRepository instrumentTypeRepository;

    @Override
    public InstrumentType convert(String source) {
        InstrumentType instrumentType = instrumentTypeRepository.getInstrumentTypeById(Integer.parseInt(source));
        return instrumentType;
    }

}
