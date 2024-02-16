package br.com.fsferreira.controller;

import br.com.fsferreira.model.Currency;
import br.com.fsferreira.service.CurrencySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-service")
public class CurrencyController {
    @Autowired
    CurrencySerivce serivce;

    @GetMapping(value = "/{amount}/{from}/{to}")
    public Currency getCurrency(
            @PathVariable("amount") BigDecimal amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to
    ) throws RuntimeException {


        return serivce.getCurrencyValue(amount,from,to);
    }
}
