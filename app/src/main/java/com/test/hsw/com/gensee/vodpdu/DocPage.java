package com.gensee.vodpdu;

import java.io.Serializable;

public class DocPage
  implements Serializable
{
  private static final long serialVersionUID = -8640919964181368250L;
  private long timeStamp;
  private String title;

  public DocPage(PduPage paramPduPage)
  {
    String str = paramPduPage.getPageName();
    if ((str == null) || ("".equals(str)))
      str = paramPduPage.getTitleText();
    this.title = str;
    this.timeStamp = paramPduPage.getStartTs();
  }

  public long getTimeStamp()
  {
    return this.timeStamp;
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setTimeStamp(long paramLong)
  {
    this.timeStamp = paramLong;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vodpdu.DocPage
 * JD-Core Version:    0.6.0
 */