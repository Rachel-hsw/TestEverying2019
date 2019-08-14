package com.withustudy.koudaizikao.entity;

import java.io.Serializable;

public class Urls
  implements Serializable
{
  private String object_id;
  private String object_type;
  private String result;
  private String type;
  private String url_long;
  private String url_short;

  public String getObject_id()
  {
    return this.object_id;
  }

  public String getObject_type()
  {
    return this.object_type;
  }

  public String getResult()
  {
    return this.result;
  }

  public String getType()
  {
    return this.type;
  }

  public String getUrl_long()
  {
    return this.url_long;
  }

  public String getUrl_short()
  {
    return this.url_short;
  }

  public void setObject_id(String paramString)
  {
    this.object_id = paramString;
  }

  public void setObject_type(String paramString)
  {
    this.object_type = paramString;
  }

  public void setResult(String paramString)
  {
    this.result = paramString;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }

  public void setUrl_long(String paramString)
  {
    this.url_long = paramString;
  }

  public void setUrl_short(String paramString)
  {
    this.url_short = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.Urls
 * JD-Core Version:    0.6.0
 */