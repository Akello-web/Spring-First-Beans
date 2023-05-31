package kz.akello.bitlab.FirstSpring.repository;


import kz.akello.bitlab.FirstSpring.model.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<GameModel, Long> {
//    List<GameModel> findAllByPriceGreaterThanEqualAndYearGreaterThan(int price, int year);

    @Query(value = "SELECT gm " +
            "FROM GameModel gm " +
            "WHERE LOWER(gm.name) LIKE LOWER( :searchName) " +
            "ORDER BY gm.price DESC ")
    List<GameModel> searchGames(@Param("searchName") String gameName);
}
