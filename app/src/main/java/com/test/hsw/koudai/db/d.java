package koudai.db;

import a.a.a.c;
import android.database.sqlite.SQLiteDatabase;
import java.util.Map;

public class d extends c
{
  private final a.a.a.d.a a;
  private final a.a.a.d.a b;
  private final a.a.a.d.a c;
  private final a.a.a.d.a d;
  private final a.a.a.d.a e;
  private final a.a.a.d.a f;
  private final VideoInfroDao g;
  private final MajorDBDao h;
  private final ProvinceDBDao i;
  private final UserAnsDao j;
  private final BrushExcerciseBatchDao k;
  private final CourseJiangYiInforDao l;

  public d(SQLiteDatabase paramSQLiteDatabase, a.a.a.c.d paramd, Map<Class<? extends a.a.a.a<?, ?>>, a.a.a.d.a> paramMap)
  {
    super(paramSQLiteDatabase);
    this.a = ((a.a.a.d.a)paramMap.get(VideoInfroDao.class)).a();
    this.a.a(paramd);
    this.b = ((a.a.a.d.a)paramMap.get(MajorDBDao.class)).a();
    this.b.a(paramd);
    this.c = ((a.a.a.d.a)paramMap.get(ProvinceDBDao.class)).a();
    this.c.a(paramd);
    this.d = ((a.a.a.d.a)paramMap.get(UserAnsDao.class)).a();
    this.d.a(paramd);
    this.e = ((a.a.a.d.a)paramMap.get(BrushExcerciseBatchDao.class)).a();
    this.e.a(paramd);
    this.f = ((a.a.a.d.a)paramMap.get(CourseJiangYiInforDao.class)).a();
    this.f.a(paramd);
    this.g = new VideoInfroDao(this.a, this);
    this.h = new MajorDBDao(this.b, this);
    this.i = new ProvinceDBDao(this.c, this);
    this.j = new UserAnsDao(this.d, this);
    this.k = new BrushExcerciseBatchDao(this.e, this);
    this.l = new CourseJiangYiInforDao(this.f, this);
    a(i.class, this.g);
    a(e.class, this.h);
    a(g.class, this.i);
    a(h.class, this.j);
    a(a.class, this.k);
    a(b.class, this.l);
  }

  public void c()
  {
    this.a.b().a();
    this.b.b().a();
    this.c.b().a();
    this.d.b().a();
    this.e.b().a();
    this.f.b().a();
  }

  public VideoInfroDao d()
  {
    return this.g;
  }

  public MajorDBDao e()
  {
    return this.h;
  }

  public ProvinceDBDao f()
  {
    return this.i;
  }

  public UserAnsDao g()
  {
    return this.j;
  }

  public BrushExcerciseBatchDao h()
  {
    return this.k;
  }

  public CourseJiangYiInforDao i()
  {
    return this.l;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     koudai.db.d
 * JD-Core Version:    0.6.0
 */