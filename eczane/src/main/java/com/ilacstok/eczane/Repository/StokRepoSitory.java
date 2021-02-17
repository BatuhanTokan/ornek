package com.ilacstok.eczane.Repository;
import java.util.Optional;
import com.ilacstok.eczane.Domain.StokDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StokRepoSitory extends JpaRepository<StokDO, Long> {
    Optional<StokDO> findByName(String name);

}
