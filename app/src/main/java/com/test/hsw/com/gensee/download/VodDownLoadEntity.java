package com.gensee.download;

public class VodDownLoadEntity
  implements Cloneable
{
  private String UUID = "";
  private String connectSvr = "";
  private String downLoadId = "";
  private String downLoadUrl = "";
  private long nLength;
  private int nPercent;
  private int nReserved1;
  private int nReserved2;
  private int nStatus = VodDownLoadStatus.WAIT.getStatus();
  private int nStopStatus = 0;
  private String nickName = "";
  private String sAddTime = "";
  private String sReserved3 = "";
  private String sReserved4 = "";
  private long siteId;
  private long userId;
  private String vodSubject;

  protected Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }

  public String getConnectSvr()
  {
    return this.connectSvr;
  }

  public String getDownLoadId()
  {
    return this.downLoadId;
  }

  public String getDownLoadUrl()
  {
    if (this.downLoadUrl == null)
      this.downLoadUrl = "";
    return this.downLoadUrl;
  }

  public String getNickName()
  {
    return this.nickName;
  }

  public long getSiteId()
  {
    return this.siteId;
  }

  public String getUUID()
  {
    return this.UUID;
  }

  public long getUserId()
  {
    return this.userId;
  }

  public String getVodSubject()
  {
    return this.vodSubject;
  }

  public long getnLength()
  {
    monitorenter;
    try
    {
      long l = this.nLength;
      monitorexit;
      return l;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int getnPercent()
  {
    monitorenter;
    try
    {
      int i = this.nPercent;
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int getnReserved1()
  {
    return this.nReserved1;
  }

  public int getnReserved2()
  {
    return this.nReserved2;
  }

  public int getnStatus()
  {
    monitorenter;
    try
    {
      int i = this.nStatus;
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int getnStopStatus()
  {
    return this.nStopStatus;
  }

  public String getsAddTime()
  {
    return this.sAddTime;
  }

  public String getsReserved3()
  {
    return this.sReserved3;
  }

  public String getsReserved4()
  {
    return this.sReserved4;
  }

  public boolean isDownloading()
  {
    return (getnStatus() == VodDownLoadStatus.BEGIN.getStatus()) || (getnStatus() == VodDownLoadStatus.START.getStatus());
  }

  public void setConnectSvr(String paramString)
  {
    this.connectSvr = paramString;
  }

  public void setDownLoadId(String paramString)
  {
    this.downLoadId = paramString;
  }

  public void setDownLoadUrl(String paramString)
  {
    this.downLoadUrl = paramString;
  }

  public void setNickName(String paramString)
  {
    this.nickName = paramString;
  }

  public void setSiteId(long paramLong)
  {
    this.siteId = paramLong;
  }

  public void setUUID(String paramString)
  {
    this.UUID = paramString;
  }

  public void setUserId(long paramLong)
  {
    this.userId = paramLong;
  }

  public void setVodSubject(String paramString)
  {
    this.vodSubject = paramString;
  }

  public void setnLength(long paramLong)
  {
    monitorenter;
    try
    {
      this.nLength = paramLong;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void setnPercent(int paramInt)
  {
    monitorenter;
    try
    {
      this.nPercent = paramInt;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void setnReserved1(int paramInt)
  {
    this.nReserved1 = paramInt;
  }

  public void setnReserved2(int paramInt)
  {
    this.nReserved2 = paramInt;
  }

  public void setnStatus(int paramInt)
  {
    monitorenter;
    try
    {
      this.nStatus = paramInt;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void setnStopStatus(int paramInt)
  {
    this.nStopStatus = paramInt;
  }

  public void setsAddTime(String paramString)
  {
    this.sAddTime = paramString;
  }

  public void setsReserved3(String paramString)
  {
    this.sReserved3 = paramString;
  }

  public void setsReserved4(String paramString)
  {
    this.sReserved4 = paramString;
  }

  public String toString()
  {
    return "VodDownLoadEntity [downLoadId=" + this.downLoadId + ", downLoadUrl=" + this.downLoadUrl + ", UUID=" + this.UUID + ", nStatus=" + this.nStatus + ", nLength=" + this.nLength + ", nPercent=" + this.nPercent + ", nReserved1=" + this.nReserved1 + ", nReserved2=" + this.nReserved2 + ", sReserved3=" + this.sReserved3 + ", sReserved4=" + this.sReserved4 + ", sAddTime=" + this.sAddTime + ", vodSubject=" + this.vodSubject + ", nStopStatus=" + this.nStopStatus + "]";
  }

  public static class VodStopStatus
  {
    public static final int VOD_STOP_AUTO = 0;
    public static final int VOD_STOP_ERROR = 2;
    public static final int VOD_STOP_MANUAL = 1;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.download.VodDownLoadEntity
 * JD-Core Version:    0.6.0
 */