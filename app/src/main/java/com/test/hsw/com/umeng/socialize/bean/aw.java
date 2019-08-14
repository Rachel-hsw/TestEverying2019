package com.umeng.socialize.bean;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.controller.listener.SocializeListeners.OnSnsPlatformClickListener;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;

public abstract class aw
{
  public String a;
  public String b;
  public int c;
  public int d;
  public boolean e;
  public boolean f;
  public String g;
  public av h;
  public int i;
  public p j;
  public SocializeListeners.OnSnsPlatformClickListener k;
  public boolean l = false;
  private String m = "Default Analytic Descriptor";

  public aw(String paramString)
  {
    this.a = paramString;
    this.j = p.a(paramString);
  }

  public String a()
  {
    return this.m;
  }

  public void a(Context paramContext, ay paramay, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    if (this.k != null)
      this.k.a(paramContext, paramay, paramSnsPostListener);
  }

  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      this.m = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.aw
 * JD-Core Version:    0.6.0
 */