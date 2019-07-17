package com.withustudy.koudaizikao.entity.content;

import com.withustudy.koudaizikao.entity.VideoCourse;
import java.util.List;

public class VideoAllContent
{
  private List<VideoCourse> course_list;
  private String result;

  public List<VideoCourse> getCourse_list()
  {
    return this.course_list;
  }

  public String getResult()
  {
    return this.result;
  }

  public void setCourse_list(List<VideoCourse> paramList)
  {
    this.course_list = paramList;
  }

  public void setResult(String paramString)
  {
    this.result = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.content.VideoAllContent
 * JD-Core Version:    0.6.0
 */