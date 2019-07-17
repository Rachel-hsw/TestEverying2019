package com.alipay.android.phone.mrpc.core;

import android.content.Context;

public final class h extends w
{
  private Context a;

  public h(Context paramContext)
  {
    this.a = paramContext;
  }

  public final <T> T a(Class<T> paramClass, aa paramaa)
  {
    return new x(new i(this, paramaa)).a(paramClass);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.android.phone.mrpc.core.h
 * JD-Core Version:    0.6.0
 */