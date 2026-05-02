package com.mrando.azucardj.service;

import com.mrando.azucardj.repository.ThemesRepository;
// import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.mrando.azucardj.model.Theme;
import com.mrando.azucardj.service.Interfaces.IThemesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemesService implements IThemesService {

    // private List<Theme> ThemesMocka = null;
    // ThemesService() {
    //     ThemesMocka = new LinkedList<Theme>();
    //     ThemesMocka.add( new Theme(
    //         301, 401, "Bohemian Rhapsody", 201, 501
    //     ));
    //     ThemesMocka.add(new Theme(
    //         302, 402, "Imagine", 202, 502)
    //     );
    //     ThemesMocka.add(new Theme(
    //         303, 403, "Hotel California", 203, 503)
    //     );
    //     ThemesMocka.add(new Theme(
    //         304, 404, "Stairway to Heaven", 204, 504)
    //     );
    //     ThemesMocka.add(new Theme(
    //         305, 405, "Smells Like Teen Spirit", 205, 505)
    //     );
    //     ThemesMocka.add(new Theme(
    //         306, 406, "Billie Jean", 206, 506)
    //     );
    //     ThemesMocka.add(new Theme(
    //         307, 407, "Like a Rolling Stone", 207, 507)
    //     );
    //     ThemesMocka.add(new Theme(
    //         308, 408, "Hey Jude", 208, 508)
    //     );
    //     ThemesMocka.add(new Theme(
    //         309, 409, "Purple Rain", 209, 509)
    //     );
    //     ThemesMocka.add(new Theme(
    //         310, 410, "Wonderwall", 210, 510)
    //     );
    // }

    @Autowired
    private ThemesRepository themesRepository;

    @Override
    public List<Theme> fetch() {
        return themesRepository.findAll();
    }

    @Override
    public Theme save(Theme theme) {
        return themesRepository.save(theme);
    }

    @Override
    public Theme update(Integer idTheme, Theme theme) {
        Optional<Theme> themeOptional = themesRepository.findById(idTheme);
        if (themeOptional.isPresent()) {
            Theme existingTheme = themeOptional.get();
            existingTheme.updateTheme(theme);
            return themesRepository.save(existingTheme);
        }
        return null;
    }

    @Override
    public Optional<Theme> findById(Integer idTheme) {
        return themesRepository.findById(idTheme);
    }

    @Override
    public List<Theme> findByGenre(Integer idGenre) {
        return themesRepository.findByGenre(idGenre);
    }

    @Override
    public List<Theme> findByArtist(Integer idArtist) {
        return themesRepository.findByArtist(idArtist);
    }

    @Override
    public List<Theme> findByName(String name) {
        return themesRepository.findByName(name);
    }


}