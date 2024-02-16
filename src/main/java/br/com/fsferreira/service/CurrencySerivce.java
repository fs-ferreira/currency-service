package br.com.fsferreira.service;

import br.com.fsferreira.model.Currency;
import br.com.fsferreira.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CurrencySerivce {
    @Autowired
    private Environment environment;

    @Autowired
    CurrencyRepository repository;

    public Currency getCurrencyValue(BigDecimal amount, String from, String to) {
        var currency = repository.findByFromAndTo(from,to);
        if(currency == null) throw new RuntimeException("Unsupported currency!");

        var port = environment.getProperty("local.server.port");

        BigDecimal conversionFactor = currency.getConversionFactor();
        BigDecimal convertedValue = conversionFactor.multiply(amount);

        currency.setEnv(port);
        currency.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));

        return currency;
    }
}
