package com.withustudy.koudaizikao.entity;

import java.util.List;

public class RspNewCource
{
  private List<New_course_ids> new_course_ids;
  private int new_course_num;
  private String result;

  public List<New_course_ids> getNew_course_ids()
  {
    return this.new_course_ids;
  }

  public int getNew_course_num()
  {
    return this.new_course_num;
  }

  public String getResult()
  {
    return this.result;
  }

  public void setNew_course_ids(List<New_course_ids> paramList)
  {
    this.new_course_ids = paramList;
  }

  public void setNew_course_num(int paramInt)
  {
    this.new_course_num = paramInt;
  }

  public void setResult(String paramString)
  {
    this.result = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.RspNewCource
 * JD-Core Version:    0.6.0
 */