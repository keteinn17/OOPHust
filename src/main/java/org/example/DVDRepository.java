package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DVDRepository extends JpaRepository<DigitalVideoDisc, Integer> {
    @Override
    <S extends DigitalVideoDisc> S save(S s);
}
