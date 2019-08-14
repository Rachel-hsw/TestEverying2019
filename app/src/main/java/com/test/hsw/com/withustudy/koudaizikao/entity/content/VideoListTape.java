package com.withustudy.koudaizikao.entity.content;

import com.withustudy.koudaizikao.entity.VideoChapter;
import java.util.List;

public class VideoListTape
{
  private String aspect_ratio;
  private List<VideoChapter> course_dir;
  private String last_watch_vid;
  private String result;

  public String getAspect_ratio()
  {
    return this.aspect_ratio;
  }

  public List<VideoChapter> getCourse_dir()
  {
    return this.course_dir;
  }

  public String getLast_watch_vid()
  {
    return this.last_watch_vid;
  }

  public String getResult()
  {
    return this.result;
  }

  public void setAspect_ratio(String paramString)
  {
    this.aspect_ratio = paramString;
  }

  public void setCourse_dir(List<VideoChapter> paramList)
  {
    this.course_dir = paramList;
  }

  public void setLast_watch_vid(String paramString)
  {
    this.last_watch_vid = paramString;
  }

  public void setResult(String paramString)
  {
    this.result = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.content.VideoListTape
 * JD-Core Version:    0.6.0
 */