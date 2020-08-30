package by.learn.datajpa.repository;

import by.learn.datajpa.entity.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelephoneRepository extends JpaRepository<Telephone, Long> {
}
