package a.a.a.d;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class e
{
  private final SQLiteDatabase a;
  private final String b;
  private final String[] c;
  private final String[] d;
  private SQLiteStatement e;
  private SQLiteStatement f;
  private SQLiteStatement g;
  private SQLiteStatement h;
  private volatile String i;
  private volatile String j;
  private volatile String k;
  private volatile String l;

  public e(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.a = paramSQLiteDatabase;
    this.b = paramString;
    this.c = paramArrayOfString1;
    this.d = paramArrayOfString2;
  }

  public SQLiteStatement a()
  {
    if (this.e == null)
    {
      String str = d.a("INSERT INTO ", this.b, this.c);
      this.e = this.a.compileStatement(str);
    }
    return this.e;
  }

  public SQLiteStatement b()
  {
    if (this.f == null)
    {
      String str = d.a("INSERT OR REPLACE INTO ", this.b, this.c);
      this.f = this.a.compileStatement(str);
    }
    return this.f;
  }

  public SQLiteStatement c()
  {
    if (this.h == null)
    {
      String str = d.a(this.b, this.d);
      this.h = this.a.compileStatement(str);
    }
    return this.h;
  }

  public SQLiteStatement d()
  {
    if (this.g == null)
    {
      String str = d.a(this.b, this.c, this.d);
      this.g = this.a.compileStatement(str);
    }
    return this.g;
  }

  public String e()
  {
    if (this.i == null)
      this.i = d.b(this.b, "T", this.c);
    return this.i;
  }

  public String f()
  {
    if (this.l == null)
      this.l = d.b(this.b, "T", this.d);
    return this.l;
  }

  public String g()
  {
    if (this.j == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(e());
      localStringBuilder.append("WHERE ");
      d.b(localStringBuilder, "T", this.d);
      this.j = localStringBuilder.toString();
    }
    return this.j;
  }

  public String h()
  {
    if (this.k == null)
      this.k = (e() + "WHERE ROWID=?");
    return this.k;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.d.e
 * JD-Core Version:    0.6.0
 */