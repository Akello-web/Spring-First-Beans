package kz.akello.bitlab.FirstSpring.controller;
import kz.akello.bitlab.FirstSpring.model.AuthorModel;
import kz.akello.bitlab.FirstSpring.model.GameModel;
import kz.akello.bitlab.FirstSpring.repository.AuthorModelRepository;
import kz.akello.bitlab.FirstSpring.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private AuthorModelRepository authorRepository;

    @GetMapping(value = "/") //@WebServlet(value = "/") + doGet()
    public String indexPage(Model model,
                            @RequestParam(name = "key", required = false, defaultValue = "") String key){
//        List<GameModel> gameModelList = gameRepository.findAll();
        List<GameModel> gameModelList = gameRepository.searchGames("%"+key+"%");
        model.addAttribute("igry", gameModelList);//request.setAttribute("muzikalar", musicArray)
        return "index";//request.getDispatcher(index.html).forward(request, response);
    }

    @PostMapping(value = "/add-game")
    public String addGame(GameModel game, @RequestParam(name = "price") double price){
        gameRepository.save(game);
        return "redirect:/";
    }

    @GetMapping(value = "/add-game")
    public String addGamePage(Model model){
        List<AuthorModel> authorModelList = authorRepository.findAll();
        model.addAttribute("authors", authorModelList);
        return "addGame";
    }

    @PostMapping(value = "/add-author")
    public String addAuthor(AuthorModel author){
        authorRepository.save(author);
        return "redirect:/add-author";
    }

    @GetMapping (value = "/add-author")
    public String addAuthorPage(Model model){
        List<AuthorModel> authorModelList = authorRepository.findAll();
        model.addAttribute("authors", authorModelList);
        return "addAuthor";
    }

    @GetMapping(value = "/game-details")
    public String getGame(@RequestParam(name = "gameId") int id, Model model){
        GameModel game = gameRepository.findById((long) id).orElse(null);
        model.addAttribute("theGame", game);
        List<AuthorModel> authorModelList = authorRepository.findAll();
        model.addAttribute("authors", authorModelList);
        return "details";
    }

    @GetMapping(value = "/details/{gameId}")
    public String gameDetails(@PathVariable(name = "gameId") Long id, Model model){
        GameModel game = gameRepository.findById(id).orElse(null);
        model.addAttribute("theGame", game);
        List<AuthorModel> authorModelList = authorRepository.findAll();
        model.addAttribute("authors", authorModelList);
        return "details";
    }

    @PostMapping(value = "/save-game")
    public String saveGame(GameModel game){
        gameRepository.save(game);
        return "redirect:/";
    }

    @PostMapping(value = "/delete-game")
    public String deleteGame(@RequestParam(name = "id") Long id){
        gameRepository.deleteById(id);
        return "redirect:/";
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
