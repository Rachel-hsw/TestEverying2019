package com.gensee.entity;

import java.util.ArrayList;
import java.util.List;

public class PrivilegeRole
{
  private long globlePri;
  private List<PrivilegeItem> items = new ArrayList(0);
  private int role;

  public void addPriByBit(int paramInt)
  {
    this.globlePri |= 1 << paramInt;
  }

  public void clear()
  {
    this.items.clear();
    this.items = null;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    PrivilegeRole localPrivilegeRole;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localPrivilegeRole = (PrivilegeRole)paramObject;
    }
    while (this.role == localPrivilegeRole.role);
    return false;
  }

  public List<PrivilegeItem> getItems()
  {
    return this.items;
  }

  public int getRole()
  {
    return this.role;
  }

  public long getStaticPri()
  {
    return this.globlePri;
  }

  public int hashCode()
  {
    return 31 + this.role;
  }

  public void setGloblePri(long paramLong)
  {
    this.globlePri = paramLong;
  }

  public void setItems(List<PrivilegeItem> paramList)
  {
    this.items = paramList;
  }

  public void setRole(int paramInt)
  {
    this.role = paramInt;
  }

  public String toString()
  {
    return "PrivilegeRole [role=" + this.role + ", items=" + this.items + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.PrivilegeRole
 * JD-Core Version:    0.6.0
 */