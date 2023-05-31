package kz.akello.bitlab.FirstSpring.service;

import kz.akello.bitlab.FirstSpring.model.AuthorModel;
import kz.akello.bitlab.FirstSpring.model.GameModel;
import kz.akello.bitlab.FirstSpring.model.GenreModel;
import kz.akello.bitlab.FirstSpring.repository.AuthorModelRepository;
import kz.akello.bitlab.FirstSpring.repository.GameRepository;
import kz.akello.bitlab.FirstSpring.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final GenreRepository genreRepository;


    public List<GameModel> searchGame(String key){
        List<GameModel> gameModelList = gameRepository.searchGames("%"+key+"%");
        return gameModelList;
    }

    public GameModel addGame(GameModel game){
        return gameRepository.save(game);
    }

    public void deleteGame(Long id){
        gameRepository.deleteById(id);
    }

    public GameModel getGame(Long id){
        return gameRepository.findById(id).orElse(null);
    }

    public GenreModel getGenre(Long id){
        return genreRepository.findById(id).orElse(null);
    }

    public List<GenreModel> getGenres(){
        return genreRepository.findAll();
    }

    public GameModel saveGame(GameModel game){
        return gameRepository.save(game);
    }

    public void assignGenre(Long gameId, Long genreId){
        GameModel gameModel = getGame(gameId);
        GenreModel genreModel = getGenre(genreId);

        if(gameModel.getGenres() != null && gameModel.getGenres().size()>0){
            if(!gameModel.getGenres().contains(genreModel)) {
                gameModel.getGenres().add(genreModel);
            }
        }else {
            List<GenreModel> genreModelList = new ArrayList<>();
            genreModelList.add(genreModel);
            gameModel.setGenres(genreModelList);
        }

        gameRepository.save(gameModel);

    }

    public void unassignGenre(Long gameId, Long genreId){
        GameModel gameModel = getGame(gameId);
        GenreModel genreModel = getGenre(genreId);

        if(gameModel.getGenres() != null && gameModel.getGenres().size()>0){

                gameModel.getGenres().remove(genreModel);

        }

        gameRepository.save(gameModel);

    }

}
