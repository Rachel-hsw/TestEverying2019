package com.withustudy.koudaizikao.entity;

import java.util.List;

public class VideoSection
{
  private String section_name;
  private List<Video> video_list;

  public String getSection_name()
  {
    return this.section_name;
  }

  public List<Video> getVideo_list()
  {
    return this.video_list;
  }

  public void setSection_name(String paramString)
  {
    this.section_name = paramString;
  }

  public void setVideo_list(List<Video> paramList)
  {
    this.video_list = paramList;
  }

  public String toString()
  {
    return "VideoSection [section_name=" + this.section_name + ", video_list=" + this.video_list + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.VideoSection
 * JD-Core Version:    0.6.0
 */