package kz.akello.bitlab.FirstSpring.repository;

import kz.akello.bitlab.FirstSpring.model.GenreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreModel, Long> {
}
