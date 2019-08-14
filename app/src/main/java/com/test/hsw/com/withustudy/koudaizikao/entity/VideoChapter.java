package com.withustudy.koudaizikao.entity;

import java.util.List;

public class VideoChapter
{
  private String chapter_name;
  private List<VideoSection> section_list;

  public String getChapter_name()
  {
    return this.chapter_name;
  }

  public List<VideoSection> getSection_list()
  {
    return this.section_list;
  }

  public void setChapter_name(String paramString)
  {
    this.chapter_name = paramString;
  }

  public void setSection_list(List<VideoSection> paramList)
  {
    this.section_list = paramList;
  }

  public String toString()
  {
    return "VideoChapter [chapter_name=" + this.chapter_name + ", section_list=" + this.section_list + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.VideoChapter
 * JD-Core Version:    0.6.0
 */