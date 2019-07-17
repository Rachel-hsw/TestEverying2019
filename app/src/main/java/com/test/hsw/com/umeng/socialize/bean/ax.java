package com.umeng.socialize.bean;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners.MulStatusListener;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.sso.v;
import com.umeng.socialize.utils.c;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ax extends CallbackConfig
{
  private static String[] B;
  private static List<p> C;
  private static final String f = ax.class.getName();
  private static SparseArray<v> j = new SparseArray();
  private static p k = p.b;
  private static ax l = new ax();
  private static b s;
  private static b t;
  private static Map<String, aw> x = new HashMap();
  private static List<aw> y = Collections.synchronizedList(new ArrayList());
  private List<b> A = new ArrayList();
  private boolean g = true;
  private boolean h = true;
  private boolean i = true;
  private Map<p, HashSet<String>> m;
  private boolean n = true;
  private boolean o = true;
  private boolean p = true;
  private String q = "Sharing Socialize";
  private String r = "";
  private boolean u = true;
  private SocializeListeners.MulStatusListener v;
  private j w = j.a;
  private List<p> z = new ArrayList();

  static
  {
    B = null;
    C = new ArrayList();
    v();
  }

  private aw a(List<aw> paramList, String paramString)
  {
    for (int i1 = 0; i1 < paramList.size(); i1++)
    {
      aw localaw = (aw)paramList.get(i1);
      if (!paramString.equals(localaw.a))
        continue;
      paramList.remove(localaw);
      return localaw;
    }
    return null;
  }

  private List<aw> a(List<p> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i1 = 0; i1 < paramList.size(); i1++)
    {
      aw localaw = a(y, ((p)paramList.get(i1)).toString());
      if (localaw == null)
        continue;
      localArrayList.add(localaw);
    }
    return localArrayList;
  }

  private static void a(aw paramaw)
  {
    if ((paramaw != null) && (!TextUtils.isEmpty(paramaw.a)))
    {
      String str = paramaw.a;
      if (x.containsKey(str))
        x.remove(str);
      x.put(str, paramaw);
    }
  }

  public static boolean a(Context paramContext)
  {
    boolean bool = c.a("com.sina.weibo", paramContext);
    if ((b().a(p.e.c()) == null) || (!bool));
    String str;
    do
    {
      return false;
      str = c.b("com.sina.weibo", paramContext);
    }
    while ((str == null) || (str.compareTo("3.0.0") <= 0));
    return true;
  }

  public static ax b()
  {
    return l;
  }

  public static boolean b(Context paramContext)
  {
    if (!c.a("com.tencent.mobileqq", paramContext));
    String str;
    do
    {
      return false;
      str = c.b("com.tencent.mobileqq", paramContext);
    }
    while ((str == null) || (str.compareTo("4.1") <= 0));
    return true;
  }

  public static boolean c(Context paramContext)
  {
    if (!c.a("com.tencent.WBlog", paramContext));
    String str;
    do
    {
      return false;
      str = c.b("com.tencent.WBlog", paramContext);
    }
    while ((str == null) || (str.compareTo("3.8.1") <= 0));
    return true;
  }

  public static void e(p paramp)
  {
    k = paramp;
    if (k == null)
      k = p.b;
  }

  public static p o()
  {
    return k;
  }

  private static void v()
  {
    a(new bg("sina"));
    a(new bg(p.l.toString()));
    a(new bg(p.h.toString()));
    a(new bg(p.k.toString()));
    String[] arrayOfString = new String[6];
    arrayOfString[0] = p.i.toString();
    arrayOfString[1] = p.j.toString();
    arrayOfString[2] = p.f.toString();
    arrayOfString[3] = p.e.toString();
    arrayOfString[4] = p.g.toString();
    arrayOfString[5] = p.k.toString();
    B = arrayOfString;
  }

  private void w()
  {
    if (this.z.size() == 0)
      a(C);
    HashMap localHashMap;
    while (true)
    {
      localHashMap = new HashMap();
      for (int i1 = 0; i1 < y.size(); i1++)
        localHashMap.put(((aw)y.get(i1)).a, y.get(i1));
      y = a(this.z);
    }
    y.clear();
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      y.add(localHashMap.get(str));
    }
  }

  private void x()
  {
    if ((B == null) || (B.length == 0));
    while (true)
    {
      return;
      y();
      int i1 = 0;
      int i2 = 0;
      while (i1 < B.length)
      {
        Iterator localIterator = y.iterator();
        while (localIterator.hasNext())
        {
          aw localaw = (aw)localIterator.next();
          String str = B[i1];
          if ((!m.a(str, y)) || (!localaw.a.equals(str.toString())))
            continue;
          localIterator.remove();
          y.add(i2, localaw);
          i2++;
        }
        i1++;
      }
    }
  }

  private void y()
  {
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    for (String str : B)
    {
      if ((!m.a(str, y)) || (!localHashSet.add(str)))
        continue;
      localArrayList.add(str);
    }
    B = (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }

  public v a(int paramInt)
  {
    i.c("", "## get sso Handler, requestCode = " + paramInt);
    v localv = (v)j.get(paramInt);
    if ((localv == null) && (paramInt == 64207))
      localv = (v)j.get(p.m.c());
    return localv;
  }

  public List<aw> a(Context paramContext, UMSocialService paramUMSocialService)
  {
    y.clear();
    com.umeng.socialize.common.p.a(paramContext, this);
    y.addAll(x.values());
    Iterator localIterator = y.iterator();
    while (localIterator.hasNext())
      ((aw)localIterator.next()).a(paramUMSocialService.f().c);
    w();
    x();
    return y;
  }

  public Set<String> a(p paramp)
  {
    if ((this.m != null) && (this.m.containsKey(paramp)))
      return new HashSet((Collection)this.m.get(paramp));
    return null;
  }

  public void a(Context paramContext, p paramp, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b localb2 = com.umeng.socialize.controller.b.a(paramContext, paramp, paramString);
      if (!this.A.contains(localb2))
        a(localb2);
    }
    b localb1;
    do
    {
      return;
      localb1 = com.umeng.socialize.controller.b.a(paramContext, paramp, paramString);
    }
    while ((localb1 == null) || (!x.containsKey(localb1.a)));
    x.remove(localb1.a);
  }

  public void a(b paramb)
  {
    a(paramb);
  }

  public void a(j paramj)
  {
    this.w = paramj;
  }

  public void a(p paramp, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramp == null))
      return;
    if (this.m == null)
      this.m = new HashMap();
    if (this.m.containsKey(paramp))
    {
      ((HashSet)this.m.get(paramp)).add(paramString);
      return;
    }
    HashSet localHashSet = new HashSet();
    localHashSet.add(paramString);
    this.m.put(paramp, localHashSet);
  }

  public void a(p paramp, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0));
    while (true)
    {
      return;
      int i1 = paramArrayOfString.length;
      for (int i2 = 0; i2 < i1; i2++)
        a(paramp, paramArrayOfString[i2]);
    }
  }

  public void a(SocializeListeners.MulStatusListener paramMulStatusListener)
  {
    this.v = paramMulStatusListener;
  }

  public void a(v paramv)
  {
    if (paramv == null)
      i.e(f, "ssoHander is null");
    b localb;
    do
    {
      return;
      int i1 = paramv.f_();
      i.c("", "#### set sso handler, code = " + i1);
      j.put(i1, paramv);
      localb = paramv.h();
    }
    while (localb == null);
    a(localb);
  }

  public void a(Class<SocializeListeners.SnsPostListener> paramClass, p paramp, int paramInt, ay paramay)
  {
    SocializeListeners.SnsPostListener[] arrayOfSnsPostListener = (SocializeListeners.SnsPostListener[])a(paramClass);
    if ((arrayOfSnsPostListener == null) || (arrayOfSnsPostListener.length == 0));
    while (true)
    {
      return;
      int i1 = arrayOfSnsPostListener.length;
      for (int i2 = 0; i2 < i1; i2++)
      {
        SocializeListeners.SnsPostListener localSnsPostListener = arrayOfSnsPostListener[i2];
        if (localSnsPostListener == null)
          continue;
        localSnsPostListener.a(paramp, paramInt, paramay);
      }
    }
  }

  public void a(String paramString)
  {
    this.q = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
    String str = p.c.toString();
    if ((paramBoolean) && (!x.containsKey(str)))
      a(s);
    do
      return;
    while ((paramBoolean) || (!x.containsKey(str)));
    x.remove(str);
  }

  public void a(p[] paramArrayOfp)
  {
    this.z.clear();
    if ((paramArrayOfp != null) && (paramArrayOfp.length > 0))
    {
      int i1 = paramArrayOfp.length;
      for (int i2 = 0; i2 < i1; i2++)
      {
        p localp = paramArrayOfp[i2];
        if (!m.a(localp))
          continue;
        this.z.add(localp);
      }
    }
  }

  public void a(String[] paramArrayOfString)
  {
    B = paramArrayOfString;
  }

  public void b(Class<SocializeListeners.SnsPostListener> paramClass)
  {
    SocializeListeners.SnsPostListener[] arrayOfSnsPostListener = (SocializeListeners.SnsPostListener[])a(paramClass);
    if ((arrayOfSnsPostListener == null) || (arrayOfSnsPostListener.length == 0));
    while (true)
    {
      return;
      int i1 = arrayOfSnsPostListener.length;
      for (int i2 = 0; i2 < i1; i2++)
      {
        SocializeListeners.SnsPostListener localSnsPostListener = arrayOfSnsPostListener[i2];
        if (localSnsPostListener == null)
          continue;
        localSnsPostListener.a();
      }
    }
  }

  public void b(String paramString)
  {
    this.r = paramString;
  }

  public void b(boolean paramBoolean)
  {
    this.o = paramBoolean;
    String str = p.d.toString();
    if ((paramBoolean) && (!x.containsKey(str)))
      a(t);
    do
      return;
    while ((paramBoolean) || (!x.containsKey(str)));
    x.remove(str);
  }

  public void b(p[] paramArrayOfp)
  {
    if ((paramArrayOfp == null) || (paramArrayOfp.length <= 0));
    while (true)
    {
      return;
      int i1 = paramArrayOfp.length;
      for (int i2 = 0; i2 < i1; i2++)
      {
        p localp = paramArrayOfp[i2];
        if (C.contains(localp))
          continue;
        C.add(localp);
      }
    }
  }

  public boolean b(p paramp)
  {
    return C.contains(paramp);
  }

  public Map<String, aw> c()
  {
    return x;
  }

  public void c(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  public void c(p[] paramArrayOfp)
  {
    int i1 = 0;
    if ((paramArrayOfp == null) || (paramArrayOfp.length == 0))
      B = new String[0];
    while (true)
    {
      return;
      B = new String[paramArrayOfp.length];
      int i2 = paramArrayOfp.length;
      int i4;
      for (int i3 = 0; i1 < i2; i3 = i4)
      {
        p localp = paramArrayOfp[i1];
        String[] arrayOfString = B;
        i4 = i3 + 1;
        arrayOfString[i3] = localp.toString();
        i1++;
      }
    }
  }

  public boolean c(p paramp)
  {
    if (paramp == null)
      return false;
    return x.containsKey(paramp.toString());
  }

  public void d(p paramp)
  {
    if (m.a(paramp))
      j.remove(paramp.c());
  }

  public void d(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public boolean d()
  {
    return this.g;
  }

  public j e()
  {
    return this.w;
  }

  public void e(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public void f(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public boolean f()
  {
    return this.h;
  }

  public String g()
  {
    return this.q;
  }

  public SocializeListeners.MulStatusListener h()
  {
    return this.v;
  }

  public boolean i()
  {
    return this.n;
  }

  public boolean j()
  {
    return this.o;
  }

  public boolean k()
  {
    return this.u;
  }

  public List<p> l()
  {
    Set localSet = x.keySet();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      p localp = p.a((String)localIterator.next());
      if ((localp == null) || (localp.a()))
        continue;
      localArrayList.add(localp);
    }
    return localArrayList;
  }

  public List<b> m()
  {
    Iterator localIterator = x.values().iterator();
    while (localIterator.hasNext())
    {
      aw localaw = (aw)localIterator.next();
      if (!(localaw instanceof b))
        continue;
      this.A.add((b)localaw);
    }
    return this.A;
  }

  public SparseArray<v> n()
  {
    return j;
  }

  public void p()
  {
    this.c = false;
  }

  public void q()
  {
    this.c = true;
  }

  public boolean r()
  {
    return this.c;
  }

  public boolean s()
  {
    return this.p;
  }

  public String t()
  {
    return this.r;
  }

  public boolean u()
  {
    return this.i;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.ax
 * JD-Core Version:    0.6.0
 */