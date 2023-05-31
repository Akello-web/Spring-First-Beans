package kz.akello.bitlab.FirstSpring.controller;
import kz.akello.bitlab.FirstSpring.model.AuthorModel;
import kz.akello.bitlab.FirstSpring.model.GameModel;
import kz.akello.bitlab.FirstSpring.model.GenreModel;
import kz.akello.bitlab.FirstSpring.repository.AuthorModelRepository;
import kz.akello.bitlab.FirstSpring.repository.GameRepository;
import kz.akello.bitlab.FirstSpring.repository.GenreRepository;
import kz.akello.bitlab.FirstSpring.service.AuthorService;
import kz.akello.bitlab.FirstSpring.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class HomeController {

    private final GameRepository gameRepository;
    private final AuthorModelRepository authorRepository;
    private final GenreRepository genreRepository;

    private final GameService gameService;
    private final AuthorService authorService;

    @GetMapping(value = "/") //@WebServlet(value = "/") + doGet()
    public String indexPage(Model model,
                            @RequestParam(name = "key", required = false, defaultValue = "") String key){
        model.addAttribute("igry", gameService.searchGame(key));//request.setAttribute("muzikalar", musicArray)
        return "index";//request.getDispatcher(index.html).forward(request, response);
    }

    @PostMapping(value = "/add-game")
    public String addGame(GameModel game, @RequestParam(name = "price") double price){
        gameService.addGame(game);
        return "redirect:/";
    }

    @GetMapping(value = "/add-game")
    public String addGamePage(Model model){
        model.addAttribute("authors", authorService.getAuthors());
        return "addGame";
    }

    @PostMapping(value = "/add-author")
    public String addAuthor(AuthorModel author){
        authorService.addAuthor(author);
        return "redirect:/add-author";
    }

    @GetMapping (value = "/add-author")
    public String addAuthorPage(Model model){
        model.addAttribute("authors", authorService.getAuthors());
        return "addAuthor";
    }

    @GetMapping(value = "/details/{gameId}")
    public String gameDetails(@PathVariable(name = "gameId") Long id, Model model){
        GameModel game = gameService.getGame(id);
        model.addAttribute("theGame", game);

        List<AuthorModel> authorModelList = authorService.getAuthors();
        model.addAttribute("authors", authorModelList);

        List<GenreModel> genreModelList = gameService.getGenres();
        genreModelList.removeAll(game.getGenres());
        model.addAttribute("genres", genreModelList);
        return "details";
    }

    @PostMapping(value = "/save-game")
    public String saveGame(GameModel game){
        gameService.saveGame(game);
        return "redirect:/";
    }

    @PostMapping(value = "/delete-game")
    public String deleteGame(@RequestParam(name = "id") Long id){
        gameService.deleteGame(id);
        return "redirect:/";
    }

    @PostMapping(value = "/assign-genre")
    public String assignGenre(@RequestParam(name = "game_id") Long gameId,
                              @RequestParam(name = "genre_id") Long genreId){
        gameService.assignGenre(gameId, genreId);
        return "redirect:/details/" + gameId;

    }

    @PostMapping(value = "/unassign-genre")
    public String unassignGenre(@RequestParam(name = "game_id") Long gameId,
                                @RequestParam(name = "genre_id") Long genreId){
        gameService.unassignGenre(gameId, genreId);
        return "redirect:/details/" + gameId;

    }

//    @PostMapping(value = "/add-music-v2")
//    public String addMusicV2(
//            @RequestParam(name = "music-name") String name,//request.getParameter("name")
//            @RequestParam(name = "music-author") String author,
//            @RequestParam(name = "music-duration") int duration
//            ){
//        Music music = new Music();
//        music.setName(name);
//        music.setName(author);
//        music.setDuration(duration);
//        DBManager.addMusic(music);
//        return "redirect:/";//response.sendRedirect("/");
//    }
}
