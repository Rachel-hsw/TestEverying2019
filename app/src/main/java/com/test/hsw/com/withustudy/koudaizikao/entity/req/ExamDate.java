package com.withustudy.koudaizikao.entity.req;

import java.io.Serializable;

public class ExamDate
  implements Serializable
{
  private String date;
  private int id;

  public String getDate()
  {
    return this.date;
  }

  public int getId()
  {
    return this.id;
  }

  public void setDate(String paramString)
  {
    this.date = paramString;
  }

  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.req.ExamDate
 * JD-Core Version:    0.6.0
 */