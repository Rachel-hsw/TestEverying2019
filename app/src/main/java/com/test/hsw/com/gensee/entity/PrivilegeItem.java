package com.gensee.entity;

public class PrivilegeItem
{
  private int bit;
  private String desc;
  private String id;
  private boolean isFixed;
  private boolean isGranted;
  private boolean isReadOnly;

  public PrivilegeItem()
  {
  }

  public PrivilegeItem(String paramString1, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    this.id = paramString1;
    this.bit = paramInt;
    this.isGranted = paramBoolean1;
    this.isFixed = paramBoolean2;
    this.isReadOnly = paramBoolean3;
    this.desc = paramString2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    PrivilegeItem localPrivilegeItem;
    do
      while (true)
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localPrivilegeItem = (PrivilegeItem)paramObject;
        if (this.id != null)
          break;
        if (localPrivilegeItem.id != null)
          return false;
      }
    while (this.id.equals(localPrivilegeItem.id));
    return false;
  }

  public int getBit()
  {
    return this.bit;
  }

  public String getDesc()
  {
    return this.desc;
  }

  public String getId()
  {
    return this.id;
  }

  public int hashCode()
  {
    if (this.id == null);
    for (int i = 0; ; i = this.id.hashCode())
      return i + 31;
  }

  public boolean isFixed()
  {
    return this.isFixed;
  }

  public boolean isGranted()
  {
    return this.isGranted;
  }

  public boolean isReadOnly()
  {
    return this.isReadOnly;
  }

  public void setBit(int paramInt)
  {
    this.bit = paramInt;
  }

  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }

  public void setFixed(boolean paramBoolean)
  {
    this.isFixed = paramBoolean;
  }

  public void setGranted(boolean paramBoolean)
  {
    this.isGranted = paramBoolean;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setReadOnly(boolean paramBoolean)
  {
    this.isReadOnly = paramBoolean;
  }

  public String toString()
  {
    return "PrivilegeItem [id=" + this.id + ", bit=" + this.bit + ", isGranted=" + this.isGranted + ", isFixed=" + this.isFixed + ", isReadOnly=" + this.isReadOnly + ", desc=" + this.desc + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.PrivilegeItem
 * JD-Core Version:    0.6.0
 */