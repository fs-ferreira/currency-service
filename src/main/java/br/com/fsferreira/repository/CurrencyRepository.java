package br.com.fsferreira.repository;

import br.com.fsferreira.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Currency findByFromAndTo(String from, String to);
}
