package com.mrando.azucardj.service;

import java.util.List;

import com.mrando.azucardj.model.Red;

public class RedServices implements IRedServices {

  private List<Red> listRed = null;
  public RedServices() {
    listRed.add( new Red(1, "facebook"));
    listRed.add( new Red(2, "instagram"));
    listRed.add( new Red(3, "twitter"));
    listRed.add( new Red(4, "tiktok"));
  }

  @Override
  public List<Red> fetch() {
    return listRed;
  }

}
