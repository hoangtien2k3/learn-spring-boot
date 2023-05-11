package Demowebservice.accountservice.repository;

import Demowebservice.accountservice.entity.Acount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Acount, Long> {

}
