package com.withustudy.koudaizikao.entity.content;

import com.withustudy.koudaizikao.entity.Video;
import java.util.List;

public class VideoListLive
{
  private String aspect_ratio;
  private int gensee_uid;
  private List<Video> living_list;
  private List<Video> playback_list;
  private String result;

  public String getAspect_ratio()
  {
    return this.aspect_ratio;
  }

  public int getGensee_uid()
  {
    return this.gensee_uid;
  }

  public List<Video> getLiving_list()
  {
    return this.living_list;
  }

  public List<Video> getPlayback_list()
  {
    return this.playback_list;
  }

  public String getResult()
  {
    return this.result;
  }

  public void setAspect_ratio(String paramString)
  {
    this.aspect_ratio = paramString;
  }

  public void setGensee_uid(int paramInt)
  {
    this.gensee_uid = paramInt;
  }

  public void setLiving_list(List<Video> paramList)
  {
    this.living_list = paramList;
  }

  public void setPlayback_list(List<Video> paramList)
  {
    this.playback_list = paramList;
  }

  public void setResult(String paramString)
  {
    this.result = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.content.VideoListLive
 * JD-Core Version:    0.6.0
 */