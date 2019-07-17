package com.gensee.entity;

import com.gensee.vodpdu.Docment;
import java.io.Serializable;
import java.util.List;

public class VodPlayParam
  implements Serializable
{
  private static final long serialVersionUID = 8247900716917055943L;
  private List<Docment> docments;
  private long duration;
  private long endTime;
  private boolean isHaveVideo;
  private String nickName;
  private String number;
  private long startTime;
  private long storage;
  private String userId;
  private int videoHeight;
  private int videoWidth;
  private String vodSubject;
  private List<VoteMsg> voteMsgs;
  private String xmlUrl;

  public List<Docment> getDocments()
  {
    return this.docments;
  }

  public long getDuration()
  {
    return this.duration;
  }

  public long getEndTime()
  {
    return this.endTime;
  }

  public String getNickName()
  {
    return this.nickName;
  }

  public String getNumber()
  {
    return this.number;
  }

  public long getStartTime()
  {
    return this.startTime;
  }

  public long getStorage()
  {
    return this.storage;
  }

  public String getUserId()
  {
    return this.userId;
  }

  public int getVideoHeight()
  {
    return this.videoHeight;
  }

  public int getVideoWidth()
  {
    return this.videoWidth;
  }

  public String getVodSubject()
  {
    return this.vodSubject;
  }

  public List<VoteMsg> getVoteMsgs()
  {
    return this.voteMsgs;
  }

  public String getXmlUrl()
  {
    return this.xmlUrl;
  }

  public boolean isHaveVideo()
  {
    return this.isHaveVideo;
  }

  public void setDocments(List<Docment> paramList)
  {
    this.docments = paramList;
  }

  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }

  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }

  public void setHaveVideo(boolean paramBoolean)
  {
    this.isHaveVideo = paramBoolean;
  }

  public void setNickName(String paramString)
  {
    this.nickName = paramString;
  }

  public void setNumber(String paramString)
  {
    this.number = paramString;
  }

  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }

  public void setStorage(long paramLong)
  {
    this.storage = paramLong;
  }

  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }

  public void setVideoHeight(int paramInt)
  {
    this.videoHeight = paramInt;
  }

  public void setVideoWidth(int paramInt)
  {
    this.videoWidth = paramInt;
  }

  public void setVodSubject(String paramString)
  {
    this.vodSubject = paramString;
  }

  public void setVoteMsgs(List<VoteMsg> paramList)
  {
    this.voteMsgs = paramList;
  }

  public void setXmlUrl(String paramString)
  {
    this.xmlUrl = paramString;
  }

  public String toString()
  {
    return "VodPlayParam [userId=" + this.userId + ", vodSubject=" + this.vodSubject + ", nickName=" + this.nickName + ", docments=" + this.docments + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.VodPlayParam
 * JD-Core Version:    0.6.0
 */