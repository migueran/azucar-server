package com.mrando.azucardj.service;

import com.mrando.azucardj.repository.DjListRepository;
import java.util.List;
import com.mrando.azucardj.model.DjList;
import com.mrando.azucardj.service.Interfaces.IDjListServices;

import org.springframework.stereotype.Service;

@Service
public class DjListServices implements IDjListServices {

    // public List<DjList> djListMocka = null;
    // public DjListServices() {
    //     djListMocka = new java.util.LinkedList<DjList>();
    //     ArrayList<Integer> items1 = new ArrayList<>(
    //         Arrays.asList(3110,3120,3130,3140,3150,3160,3170,3180,3190,3200)
    //     );
    //     ArrayList<Integer> items2 = new ArrayList<>(
    //         Arrays.asList(3010,3020,3030,3040,3050,3060,3070,3080,3090,3100)
    //     );
    //     djListMocka.add( new DjList(1, "my List", 1, items1));
    //     djListMocka.add( new DjList(2, "other list", 1, items2));
    // }

    private final DjListRepository djListRepository;

  DjListServices(DjListRepository djListRepository) {
    this.djListRepository = djListRepository;
  }

    @Override
    public List<DjList> fetch() {
        return djListRepository.findAll();
    }

    @Override
    public void save(DjList djList) {
        djListRepository.save(djList);
    }

    @Override
    public DjList findById(Integer id) {
        return djListRepository.findById(id).orElse(null);
    }

    @Override
    public DjList findByName(String name) {
        return djListRepository.findByName(name);
    }

    @Override
    public List<DjList> findByOwner(Integer idOwner) {
        return djListRepository.findByOwner(idOwner);
    }

}
