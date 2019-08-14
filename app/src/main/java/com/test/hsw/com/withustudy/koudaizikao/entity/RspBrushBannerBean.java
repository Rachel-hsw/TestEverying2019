package com.withustudy.koudaizikao.entity;

import java.io.Serializable;
import java.util.List;

public class RspBrushBannerBean
  implements Serializable
{
  private List<Carousel_list> carousel_list;
  private String result;

  public List<Carousel_list> getCarousel_list()
  {
    return this.carousel_list;
  }

  public String getResult()
  {
    return this.result;
  }

  public void setCarousel_list(List<Carousel_list> paramList)
  {
    this.carousel_list = paramList;
  }

  public void setResult(String paramString)
  {
    this.result = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.RspBrushBannerBean
 * JD-Core Version:    0.6.0
 */