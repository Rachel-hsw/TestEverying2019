package com.withustudy.koudaizikao.e;

import a.a.a.c;
import android.content.Context;
import android.util.Log;
import com.withustudy.koudaizikao.MyApplication;
import java.util.List;
import koudai.db.BrushExcerciseBatchDao;
import koudai.db.CourseJiangYiInforDao;
import koudai.db.MajorDBDao;
import koudai.db.ProvinceDBDao;
import koudai.db.UserAnsDao;
import koudai.db.VideoInfroDao;
import koudai.db.d;

public class a
{
  private static final String a = a.class.getSimpleName();
  private static a b;
  private static Context c;
  private d d;
  private UserAnsDao e;
  private BrushExcerciseBatchDao f;
  private MajorDBDao g;
  private ProvinceDBDao h;
  private VideoInfroDao i;
  private CourseJiangYiInforDao j;

  public static a a(Context paramContext)
  {
    if (b == null)
    {
      b = new a();
      if (c == null)
        c = paramContext.getApplicationContext();
      b.d = MyApplication.getDaoSession(paramContext);
      b.e = b.d.g();
      b.g = b.d.e();
      b.h = b.d.f();
      b.f = b.d.h();
      b.i = b.d.d();
      b.j = b.d.i();
    }
    return b;
  }

  public <T> long a(T paramT, a.a.a.a<T, Long> parama)
  {
    return parama.c(paramT);
  }

  public <T> Long a(a.a.a.a<T, Long> parama, T paramT)
  {
    return Long.valueOf(parama.e(paramT));
  }

  public <T> T a(a.a.a.a<T, Long> parama, long paramLong)
  {
    return parama.a(Long.valueOf(paramLong));
  }

  public <T> List<T> a(a.a.a.a<T, Long> parama)
  {
    return parama.i();
  }

  public <T> List<T> a(a.a.a.a<T, Long> parama, String paramString, String[] paramArrayOfString)
  {
    return parama.a(paramString, paramArrayOfString);
  }

  public UserAnsDao a()
  {
    return this.e;
  }

  public <T> void a(List<T> paramList, a.a.a.a<T, Long> parama)
  {
    if ((paramList == null) || (paramList.isEmpty()))
      return;
    parama.a().a(new b(this, paramList, parama));
  }

  public BrushExcerciseBatchDao b()
  {
    return this.f;
  }

  public <T> void b(a.a.a.a<T, Long> parama)
  {
    parama.j();
  }

  public <T> void b(a.a.a.a<T, Long> parama, long paramLong)
  {
    parama.g(Long.valueOf(paramLong));
    Log.i(a, "delete");
  }

  public <T> void b(a.a.a.a<T, Long> parama, T paramT)
  {
    parama.f(paramT);
  }

  public MajorDBDao c()
  {
    return this.g;
  }

  public ProvinceDBDao d()
  {
    return this.h;
  }

  public VideoInfroDao e()
  {
    return this.i;
  }

  public CourseJiangYiInforDao f()
  {
    return this.j;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.e.a
 * JD-Core Version:    0.6.0
 */