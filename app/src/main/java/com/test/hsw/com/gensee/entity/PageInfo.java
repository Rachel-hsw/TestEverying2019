package com.gensee.entity;

public class PageInfo
{
  private int timeStamp;
  private String title;

  public PageInfo()
  {
  }

  public PageInfo(int paramInt, String paramString)
  {
    this.timeStamp = paramInt;
    this.title = paramString;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    PageInfo localPageInfo;
    do
      while (true)
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localPageInfo = (PageInfo)paramObject;
        if (this.timeStamp != localPageInfo.timeStamp)
          return false;
        if (this.title != null)
          break;
        if (localPageInfo.title != null)
          return false;
      }
    while (this.title.equals(localPageInfo.title));
    return false;
  }

  public int getTimeStamp()
  {
    return this.timeStamp;
  }

  public String getTitle()
  {
    return this.title;
  }

  public int hashCode()
  {
    int i = 31 * (31 + this.timeStamp);
    if (this.title == null);
    for (int j = 0; ; j = this.title.hashCode())
      return j + i;
  }

  public void setTimeStamp(int paramInt)
  {
    this.timeStamp = paramInt;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }

  public String toString()
  {
    return "PageInfo [timeStamp=" + this.timeStamp + ", title=" + this.title + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.PageInfo
 * JD-Core Version:    0.6.0
 */