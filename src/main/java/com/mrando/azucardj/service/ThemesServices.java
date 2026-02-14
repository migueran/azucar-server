package com.mrando.azucardj.service;

import java.util.LinkedList;
import java.util.List;

import com.mrando.azucardj.model.Theme;
import org.springframework.stereotype.Service;

@Service
public class ThemesServices implements IThemesServices {

    private List<Theme> ThemesMocka = null;
    ThemesServices() {
        ThemesMocka = new LinkedList<Theme>();
        ThemesMocka.add( new Theme(
            301, 401, "Bohemian Rhapsody", "Queen", 501
        ));
        ThemesMocka.add(new Theme(
            302, 402, "Imagine", "John Lennon", 502)
        );
        ThemesMocka.add(new Theme(
            303, 403, "Hotel California", "Eagles", 503)
        );
        ThemesMocka.add(new Theme(
            304, 404, "Stairway to Heaven", "Led Zeppelin", 504)
        );
        ThemesMocka.add(new Theme(
            305, 405, "Smells Like Teen Spirit", "Nirvana", 505)
        );
        ThemesMocka.add(new Theme(
            306, 406, "Billie Jean", "Michael Jackson", 506)
        );
        ThemesMocka.add(new Theme(
            307, 407, "Like a Rolling Stone", "Bob Dylan", 507)
        );
        ThemesMocka.add(new Theme(
            308, 408, "Hey Jude", "The Beatles", 508)
        );
        ThemesMocka.add(new Theme(
            309, 409, "Purple Rain", "Prince", 509)
        );
        ThemesMocka.add(new Theme(
            310, 410, "Wonderwall", "Oasis", 510)
        );
    }

    @Override
    public List<Theme> fetch() {
        return ThemesMocka;
    }

    @Override
    public void save(Theme theme) {
    }

    @Override
    public Theme searchById(Integer idTheme) {
        return null;
    }

    @Override
    public List<Theme> searchByGenre(Integer idGenre) {
        return null;
    }

    @Override
    public List<Theme> searchByArtist(Integer artist) {
        return null;
    }
}