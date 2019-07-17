package com.gensee.entity;

import java.io.Serializable;

public class AccVodResEntity
  implements Serializable
{
  private static final long serialVersionUID = 3664560384841107613L;
  private boolean isSurportMobile;
  private String loginRequired;
  private String pwdRequired;
  private String subject;
  private String vodId;

  public String getLoginRequired()
  {
    return this.loginRequired;
  }

  public String getPwdRequired()
  {
    return this.pwdRequired;
  }

  public String getSubject()
  {
    return this.subject;
  }

  public String getVodId()
  {
    return this.vodId;
  }

  public boolean isSurportMobile()
  {
    return this.isSurportMobile;
  }

  public void setLoginRequired(String paramString)
  {
    this.loginRequired = paramString;
  }

  public void setPwdRequired(String paramString)
  {
    this.pwdRequired = paramString;
  }

  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }

  public void setSurportMobile(boolean paramBoolean)
  {
    this.isSurportMobile = paramBoolean;
  }

  public void setVodId(String paramString)
  {
    this.vodId = paramString;
  }

  public String toString()
  {
    return "AccVodResEntity [loginRequired=" + this.loginRequired + ",isSurportMobile=" + this.isSurportMobile + ", pwdRequired=" + this.pwdRequired + ", subject=" + this.subject + ", vodId=" + this.vodId + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.AccVodResEntity
 * JD-Core Version:    0.6.0
 */