package a.a.a.f;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import java.util.Random;

public abstract class f extends AndroidTestCase
{
  public static final String g = "greendao-unittest-db.temp";
  private Application a;
  protected final Random h;
  protected final boolean i;
  protected SQLiteDatabase j;

  public f()
  {
    this(true);
  }

  public f(boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.h = new Random();
  }

  public <T extends Application> T A()
  {
    assertNotNull("Application not yet created", this.a);
    return this.a;
  }

  protected SQLiteDatabase B()
  {
    if (this.i)
      return SQLiteDatabase.create(null);
    getContext().deleteDatabase("greendao-unittest-db.temp");
    return getContext().openOrCreateDatabase("greendao-unittest-db.temp", 0, null);
  }

  public <T extends Application> T a(Class<T> paramClass)
  {
    assertNull("Application already created", this.a);
    try
    {
      Application localApplication = Instrumentation.newApplication(paramClass, getContext());
      localApplication.onCreate();
      this.a = localApplication;
      return localApplication;
    }
    catch (Exception localException)
    {
    }
    throw new RuntimeException("Could not create application " + paramClass, localException);
  }

  protected void a(String paramString)
  {
    a.a.a.f.a(this.j, paramString);
  }

  protected void setUp()
    throws Exception
  {
    super.setUp();
    this.j = B();
  }

  protected void tearDown()
    throws Exception
  {
    if (this.a != null)
      z();
    this.j.close();
    if (!this.i)
      getContext().deleteDatabase("greendao-unittest-db.temp");
    super.tearDown();
  }

  public void z()
  {
    assertNotNull("Application not yet created", this.a);
    this.a.onTerminate();
    this.a = null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.f.f
 * JD-Core Version:    0.6.0
 */