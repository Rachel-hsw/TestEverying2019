package com.gensee.entity;

import java.io.Serializable;

public class PingEntity
  implements Serializable
{
  private static final long serialVersionUID = 5775116571653939320L;
  private String code;
  private String description;
  private String id;
  private String name;
  private String pingUrl;
  private String supported;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    PingEntity localPingEntity;
    do
      while (true)
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localPingEntity = (PingEntity)paramObject;
        if (this.id != null)
          break;
        if (localPingEntity.id != null)
          return false;
      }
    while (this.id.equals(localPingEntity.id));
    return false;
  }

  public String getCode()
  {
    return this.code;
  }

  public String getDescription()
  {
    return this.description;
  }

  public String getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }

  public String getPingUrl()
  {
    return this.pingUrl;
  }

  public String getSupported()
  {
    return this.supported;
  }

  public int hashCode()
  {
    if (this.id == null);
    for (int i = 0; ; i = this.id.hashCode())
      return i + 31;
  }

  public void setCode(String paramString)
  {
    this.code = paramString;
  }

  public void setDescription(String paramString)
  {
    this.description = paramString;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
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
    return "PingEntity [code=" + this.code + ", supported=" + this.supported + ", pingUrl=" + this.pingUrl + ", description=" + this.description + ", id=" + this.id + ", name=" + this.name + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.PingEntity
 * JD-Core Version:    0.6.0
 */