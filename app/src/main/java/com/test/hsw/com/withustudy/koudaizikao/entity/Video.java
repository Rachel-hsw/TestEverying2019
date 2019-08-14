package com.withustudy.koudaizikao.entity;

import java.io.Serializable;

public class Video
  implements Serializable
{
  private int duration;
  private int file_size;
  private String handout;
  private int is_trail;
  private String live_time;
  private String play_status;
  private String video_id;
  private String video_name;
  private String video_number;
  private String watch_passwd;
  private int watch_progress;

  public int getDuration()
  {
    return this.duration;
  }

  public int getFile_size()
  {
    return this.file_size;
  }

  public String getHandout()
  {
    return this.handout;
  }

  public int getIs_trail()
  {
    return this.is_trail;
  }

  public String getLive_time()
  {
    return this.live_time;
  }

  public String getPlay_status()
  {
    return this.play_status;
  }

  public String getVideo_id()
  {
    return this.video_id;
  }

  public String getVideo_name()
  {
    return this.video_name;
  }

  public String getVideo_number()
  {
    return this.video_number;
  }

  public String getWatch_passwd()
  {
    return this.watch_passwd;
  }

  public int getWatch_progress()
  {
    return this.watch_progress;
  }

  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }

  public void setFile_size(int paramInt)
  {
    this.file_size = paramInt;
  }

  public void setHandout(String paramString)
  {
    this.handout = paramString;
  }

  public void setIs_trail(int paramInt)
  {
    this.is_trail = paramInt;
  }

  public void setLive_time(String paramString)
  {
    this.live_time = paramString;
  }

  public void setPlay_status(String paramString)
  {
    this.play_status = paramString;
  }

  public void setVideo_id(String paramString)
  {
    this.video_id = paramString;
  }

  public void setVideo_name(String paramString)
  {
    this.video_name = paramString;
  }

  public void setVideo_number(String paramString)
  {
    this.video_number = paramString;
  }

  public void setWatch_passwd(String paramString)
  {
    this.watch_passwd = paramString;
  }

  public void setWatch_progress(int paramInt)
  {
    this.watch_progress = paramInt;
  }

  public String toString()
  {
    return "Video [video_id=" + this.video_id + ", video_number=" + this.video_number + ", watch_passwd=" + this.watch_passwd + ", video_name=" + this.video_name + ", handout=" + this.handout + ", duration=" + this.duration + ", watch_progress=" + this.watch_progress + ", file_size=" + this.file_size + ", is_trail=" + this.is_trail + ", live_time=" + this.live_time + ", play_status=" + this.play_status + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.Video
 * JD-Core Version:    0.6.0
 */