package fr.uha.serfa.lpdao25.PaintBoot.dao;

import fr.uha.serfa.lpdao25.PaintBoot.model.Forme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Forme, Long> {

}
