package com.withustudy.koudaizikao.entity.local;

public class VideoDownLoadStatus
{
  private int definition;
  private int progress;
  private int status;
  private String videoId;

  public VideoDownLoadStatus()
  {
  }

  public VideoDownLoadStatus(String paramString, int paramInt1, int paramInt2)
  {
    this.videoId = paramString;
    this.progress = paramInt1;
    this.status = paramInt2;
  }

  public VideoDownLoadStatus(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramString, paramInt1, paramInt2);
    this.definition = paramInt3;
  }

  public int getDefinition()
  {
    return this.definition;
  }

  public int getProgress()
  {
    return this.progress;
  }

  public int getStatus()
  {
    return this.status;
  }

  public String getStatusInfo()
  {
    switch (this.status)
    {
    default:
      return "下载失败";
    case 100:
      return "等待中";
    case 200:
      return "下载中";
    case 300:
      return "暂停中";
    case 400:
    }
    return "已下载";
  }

  public String getVideoId()
  {
    return this.videoId;
  }

  public void setDefinition(int paramInt)
  {
    this.definition = paramInt;
  }

  public void setProgress(int paramInt)
  {
    this.progress = paramInt;
  }

  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }

  public void setVideoId(String paramString)
  {
    this.videoId = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.local.VideoDownLoadStatus
 * JD-Core Version:    0.6.0
 */