package com.withustudy.koudaizikao.entity;

import java.io.Serializable;

public class New_course_ids
  implements Serializable
{
  private String course_id;
  private int is_chuanjiang;

  public String getCourse_id()
  {
    return this.course_id;
  }

  public int getIs_chuanjiang()
  {
    return this.is_chuanjiang;
  }

  public void setCourse_id(String paramString)
  {
    this.course_id = paramString;
  }

  public void setIs_chuanjiang(int paramInt)
  {
    this.is_chuanjiang = paramInt;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.New_course_ids
 * JD-Core Version:    0.6.0
 */