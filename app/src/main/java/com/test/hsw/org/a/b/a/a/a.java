package org.a.b.a.a;

import org.a.b.a.a.a.c;

public class a
{
  private final String a;
  private final b b;
  private final c c;

  public a(String paramString, c paramc)
  {
    if (paramString == null)
      throw new IllegalArgumentException("Name may not be null");
    if (paramc == null)
      throw new IllegalArgumentException("Body may not be null");
    this.a = paramString;
    this.c = paramc;
    this.b = new b();
    a(paramc);
    b(paramc);
    c(paramc);
  }

  public String a()
  {
    return this.a;
  }

  public void a(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      throw new IllegalArgumentException("Field name may not be null");
    this.b.a(new f(paramString1, paramString2));
  }

  protected void a(c paramc)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("form-data; name=\"");
    localStringBuilder.append(a());
    localStringBuilder.append("\"");
    if (paramc.d() != null)
    {
      localStringBuilder.append("; filename=\"");
      localStringBuilder.append(paramc.d());
      localStringBuilder.append("\"");
    }
    a("Content-Disposition", localStringBuilder.toString());
  }

  public c b()
  {
    return this.c;
  }

  protected void b(c paramc)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramc.a());
    if (paramc.e() != null)
    {
      localStringBuilder.append("; charset=");
      localStringBuilder.append(paramc.e());
    }
    a("Content-Type", localStringBuilder.toString());
  }

  public b c()
  {
    return this.b;
  }

  protected void c(c paramc)
  {
    a("Content-Transfer-Encoding", paramc.f());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.b.a.a.a
 * JD-Core Version:    0.6.0
 */