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
            301, 401, "Bohemian Rhapsody", 201, 501
        ));
        ThemesMocka.add(new Theme(
            302, 402, "Imagine", 202, 502)
        );
        ThemesMocka.add(new Theme(
            303, 403, "Hotel California", 203, 503)
        );
        ThemesMocka.add(new Theme(
            304, 404, "Stairway to Heaven", 204, 504)
        );
        ThemesMocka.add(new Theme(
            305, 405, "Smells Like Teen Spirit", 205, 505)
        );
        ThemesMocka.add(new Theme(
            306, 406, "Billie Jean", 206, 506)
        );
        ThemesMocka.add(new Theme(
            307, 407, "Like a Rolling Stone", 207, 507)
        );
        ThemesMocka.add(new Theme(
            308, 408, "Hey Jude", 208, 508)
        );
        ThemesMocka.add(new Theme(
            309, 409, "Purple Rain", 209, 509)
        );
        ThemesMocka.add(new Theme(
            310, 410, "Wonderwall", 210, 510)
        );
    }

    @Override
    public List<Theme> fetch() {
        return ThemesMocka;
    }

    @Override
    public void save(Theme theme) {
        ThemesMocka.add(theme);
    }

    @Override
    public Theme searchById(Integer idTheme) {
        for (Theme theme : ThemesMocka) {
            if (theme.getId().equals(idTheme)) {
                return theme;
            }
        }
        return null;
    }

    @Override
    public List<Theme> searchByGenre(Integer idGenre) {
        List<Theme> themesByGenre = new LinkedList<Theme>();
        for (Theme theme : ThemesMocka) {
            if (theme.getGenre() == idGenre) {
                themesByGenre.add(theme);
            }
            // System.out.println(theme);
        }
        return themesByGenre;
    }

    @Override
    public List<Theme> searchByArtist(Integer idArtist) {
        List<Theme> themesByArtist = new LinkedList<Theme>();
        for (Theme theme : ThemesMocka) {
            if (theme.getArtist() == idArtist) {
                themesByArtist.add(theme);
            }
        }
        return themesByArtist;
    }

    @Override
    public List<Theme> searchByName(String name) {
        List<Theme> themesByName = new LinkedList<Theme>();
        for (Theme theme : ThemesMocka) {
            if (theme.getName().toLowerCase().replace(" ", "-").equals(name.toLowerCase())) {
                themesByName.add(theme);
            }
        }
        return themesByName;
    }


}