package kz.akello.bitlab.FirstSpring.service;

import kz.akello.bitlab.FirstSpring.model.AuthorModel;
import kz.akello.bitlab.FirstSpring.model.GameModel;
import kz.akello.bitlab.FirstSpring.repository.AuthorModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorModelRepository authorRepository;

    public List<AuthorModel> getAuthors(){
        return authorRepository.findAll();
    }

    public AuthorModel addAuthor(AuthorModel author){
        return authorRepository.save(author);
    }

    public AuthorModel getAuthor(Long id){
        return authorRepository.findById(id).orElse(null);
    }
}
