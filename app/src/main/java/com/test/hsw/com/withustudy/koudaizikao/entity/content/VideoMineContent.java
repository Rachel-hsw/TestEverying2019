package com.withustudy.koudaizikao.entity.content;

import com.withustudy.koudaizikao.entity.VideoCourse;
import java.util.List;

public class VideoMineContent
{
  private List<VideoCourse> courses;
  private String result;

  public List<VideoCourse> getCourses()
  {
    return this.courses;
  }

  public String getResult()
  {
    return this.result;
  }

  public void setCourses(List<VideoCourse> paramList)
  {
    this.courses = paramList;
  }

  public void setResult(String paramString)
  {
    this.result = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.content.VideoMineContent
 * JD-Core Version:    0.6.0
 */