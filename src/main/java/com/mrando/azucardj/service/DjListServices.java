package com.mrando.azucardj.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.mrando.azucardj.model.DjList;
import org.springframework.stereotype.Service;

@Service
public class DjListServices implements IDjListServices {

    public List<DjList> djListMocka = null;
    public DjListServices() {
        djListMocka = new java.util.LinkedList<DjList>();
        ArrayList<Integer> items1 = new ArrayList<>(
            Arrays.asList(3110,3120,3130,3140,3150,3160,3170,3180,3190,3200)
        );
        ArrayList<Integer> items2 = new ArrayList<>(
            Arrays.asList(3010,3020,3030,3040,3050,3060,3070,3080,3090,3100)
        );
        djListMocka.add( new DjList(1, 000, items1));
        djListMocka.add( new DjList(2, 000, items2));
    }

    @Override
    public List<DjList> fetch() {
        return djListMocka;
    }

    @Override
    public void save(DjList djList) {
        djListMocka.add(djList);
    }

    @Override
    public DjList searchById(Integer id) {
        for (DjList djList : djListMocka) {
            if (djList.getId().equals(id)) {
                return djList;
            }
        }
        return null;
    }

    @Override
    public List<DjList> searchByOwner(Integer idOwner) {
        List<DjList> djListByOwner = new java.util.LinkedList<DjList>();
        for (DjList djList : djListMocka) {
            if (djList.getidOwner().equals(idOwner)) {
                djListByOwner.add(djList);
            }
        }
        return null;
    }

}
