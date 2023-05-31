package kz.akello.bitlab.FirstSpring.repository;

import kz.akello.bitlab.FirstSpring.model.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorModelRepository extends JpaRepository<AuthorModel, Long> {
}
