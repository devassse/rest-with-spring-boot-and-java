package mz.co.keomasoftware.repositories;

import mz.co.keomasoftware.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
}
