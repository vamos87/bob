package pl.coderslab.bob.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.bob.entity.Bank;
import pl.coderslab.bob.entity.InstrumentType;
import pl.coderslab.bob.repository.BankRepository;



public class BankConverter implements Converter<String, Bank> {
    @Autowired
    private BankRepository bankRepository;

    @Override
    public Bank convert(String source) {
        Bank bank = bankRepository.getBankById(Integer.parseInt(source));
        return bank;
    }

}
