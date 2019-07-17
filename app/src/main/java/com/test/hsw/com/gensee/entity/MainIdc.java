package com.gensee.entity;

import java.io.Serializable;

public class MainIdc
  implements Serializable
{
  private static final long serialVersionUID = 8114828637109278648L;
  private String albPort = "";
  private String albProxyPort = "";
  private String choosePriorNetwork;
  private String code = "";
  private String diagnoseUploadUrl = "";
  private String id;
  private String pingRequired = "";
  private String pingThreshold = "";
  private String pingUrl = "";
  private String supported = "";

  public String getAlbPort()
  {
    return this.albPort;
  }

  public String getAlbProxyPort()
  {
    return this.albProxyPort;
  }

  public String getChoosePriorNetwork()
  {
    return this.choosePriorNetwork;
  }

  public String getCode()
  {
    return this.code;
  }

  public String getDiagnoseUploadUrl()
  {
    return this.diagnoseUploadUrl;
  }

  public String getId()
  {
    return this.id;
  }

  public String getPingRequired()
  {
    return this.pingRequired;
  }

  public String getPingThreshold()
  {
    return this.pingThreshold;
  }

  public String getPingUrl()
  {
    return this.pingUrl;
  }

  public String getSupported()
  {
    return this.supported;
  }

  public void setAlbPort(String paramString)
  {
    this.albPort = paramString;
  }

  public void setAlbProxyPort(String paramString)
  {
    this.albProxyPort = paramString;
  }

  public void setChoosePriorNetwork(String paramString)
  {
    this.choosePriorNetwork = paramString;
  }

  public void setCode(String paramString)
  {
    this.code = paramString;
  }

  public void setDiagnoseUploadUrl(String paramString)
  {
    this.diagnoseUploadUrl = paramString;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setPingRequired(String paramString)
  {
    this.pingRequired = paramString;
  }

  public void setPingThreshold(String paramString)
  {
    this.pingThreshold = paramString;
  }

  public void setPingUrl(String paramString)
  {
    this.pingUrl = paramString;
  }

  public void setSupported(String paramString)
  {
    this.supported = paramString;
  }

  public String toString()
  {
    return "MainIdc [albPort=" + this.albPort + ", albProxyPort=" + this.albProxyPort + ", choosePriorNetwork=" + this.choosePriorNetwork + ", code=" + this.code + ", diagnoseUploadUrl=" + this.diagnoseUploadUrl + ", pingRequired=" + this.pingRequired + ", pingThreshold=" + this.pingThreshold + ", pingUrl=" + this.pingUrl + ", supported=" + this.supported + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.MainIdc
 * JD-Core Version:    0.6.0
 */