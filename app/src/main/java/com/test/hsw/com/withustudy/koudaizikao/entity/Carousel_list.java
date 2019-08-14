package com.withustudy.koudaizikao.entity;

import java.io.Serializable;

public class Carousel_list
  implements Serializable
{
  private String category;
  private String image_url;
  private String item;
  private String type;

  public String getCategory()
  {
    return this.category;
  }

  public String getImage_url()
  {
    return this.image_url;
  }

  public String getItem()
  {
    return this.item;
  }

  public String getType()
  {
    return this.type;
  }

  public void setCategory(String paramString)
  {
    this.category = paramString;
  }

  public void setImage_url(String paramString)
  {
    this.image_url = paramString;
  }

  public void setItem(String paramString)
  {
    this.item = paramString;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.Carousel_list
 * JD-Core Version:    0.6.0
 */