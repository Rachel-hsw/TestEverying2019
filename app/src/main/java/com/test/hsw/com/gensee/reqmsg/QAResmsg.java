package com.gensee.reqmsg;

public class QAResmsg extends AbsReqmsg
{
  private String content;
  private String id;
  private String userId;
  private String userName;

  public QAResmsg()
  {
  }

  public QAResmsg(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.id = paramString1;
    this.userName = paramString2;
    this.content = paramString3;
    this.userId = paramString4;
  }

  protected String createModuleBody()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.id;
    arrayOfObject[1] = this.userName;
    arrayOfObject[2] = this.content;
    return String.format("<qamsg id=\"%s\" username=\"%s\">%s</qamsg>", arrayOfObject);
  }

  public String getContent()
  {
    return this.content;
  }

  public String getData()
  {
    return getData("qa", this.userId);
  }

  public String getId()
  {
    return this.id;
  }

  public String getUserId()
  {
    return this.userId;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public void setContent(String paramString)
  {
    this.content = paramString;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }

  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }

  public String toString()
  {
    return "QAResmsg [id=" + this.id + ", username=" + this.userName + ", content=" + this.content + ", userId=" + this.userId + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.reqmsg.QAResmsg
 * JD-Core Version:    0.6.0
 */