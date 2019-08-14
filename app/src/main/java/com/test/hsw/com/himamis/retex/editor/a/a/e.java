package com.himamis.retex.editor.a.a;

import com.himamis.retex.editor.a.f.a;
import com.himamis.retex.editor.a.f.b;
import com.himamis.retex.editor.a.f.c;
import com.himamis.retex.editor.a.f.f;
import com.himamis.retex.editor.a.f.g;

public class e extends d
{
  private static final String[] d = { "sin", "cos", "tan", "sec", "csc", "cot", "sinh", "cosh", "tanh", "coth", "lim", "limsup", "liminf", "min", "max", "sup", "exp", "ln", "lg", "log", "ker", "deg", "gcd", "det", "hom", "arg", "dim", "sum", "prod", "int", "pmod" };
  private boolean e = true;

  private int a(com.himamis.retex.editor.a.f.h paramh, int paramInt)
  {
    if ((paramh.c(paramInt) instanceof c))
      return ((c)paramh.c(paramInt)).e().length();
    return 2;
  }

  private boolean a(String paramString)
  {
    for (int i = 0; ; i++)
    {
      if (i >= d.length)
        return false;
      if (d[i].equals(paramString))
        return true;
      if ((paramString.length() > 1 + d[i].length()) && (paramString.startsWith(d[i])) && ((paramString.charAt(d[i].length()) == ' ') || (paramString.charAt(d[i].length()) == '^') || (paramString.charAt(d[i].length()) == '_') || (paramString.charAt(d[i].length()) == '{')))
        return true;
    }
  }

  public void a(a parama, StringBuilder paramStringBuilder)
  {
    if ((this.e) && ("Matrix".equals(parama.c())))
    {
      paramStringBuilder.append(parama.d().c());
      int m;
      for (int k = 0; ; k++)
      {
        if (k >= parama.q())
        {
          paramStringBuilder.append(parama.f().c());
          return;
        }
        m = 0;
        if (m < parama.p())
          break;
      }
      a(parama.a(k, m), paramStringBuilder);
      if (m + 1 < parama.p())
        paramStringBuilder.append(parama.h().c());
      while (true)
      {
        m++;
        break;
        if (k + 1 >= parama.q())
          continue;
        paramStringBuilder.append(parama.j().c());
      }
    }
    paramStringBuilder.append(parama.d().d());
    int j;
    for (int i = 0; ; i++)
    {
      if (i >= parama.q())
      {
        paramStringBuilder.append(parama.f().d());
        return;
      }
      j = 0;
      if (j < parama.p())
        break;
    }
    a(parama.a(i, j), paramStringBuilder);
    if (j + 1 < parama.p())
      paramStringBuilder.append(parama.h().d());
    while (true)
    {
      j++;
      break;
      if (i + 1 >= parama.q())
        continue;
      paramStringBuilder.append(parama.j().d());
    }
  }

  public void a(b paramb, StringBuilder paramStringBuilder)
  {
    if (paramb.b() == 1)
    {
      paramStringBuilder.append("\\left(");
      a(paramb.a(0), paramStringBuilder);
      paramStringBuilder.append("\\right)");
      return;
    }
    if (paramb.b() == 2)
    {
      paramStringBuilder.append("\\left[");
      a(paramb.a(0), paramStringBuilder);
      paramStringBuilder.append("\\right]");
      return;
    }
    if (paramb.b() == 3)
    {
      paramStringBuilder.append("\\lbrace");
      a(paramb.a(0), paramStringBuilder);
      paramStringBuilder.append("\\rbrace");
      return;
    }
    if (paramb.b() == 4)
    {
      paramStringBuilder.append("\"");
      a(paramb.a(0), paramStringBuilder);
      paramStringBuilder.append("\"");
      return;
    }
    throw new ArrayIndexOutOfBoundsException("Unsupported function " + paramb.b());
  }

  public void a(c paramc, StringBuilder paramStringBuilder)
  {
    String str;
    if (" ".equals(paramc.b()))
      if (this.e)
      {
        str = "\\nbsp";
        paramStringBuilder.append(str + " ");
      }
    while (true)
    {
      if ((paramc.h()) || (paramc.i()))
        paramStringBuilder.append(' ');
      return;
      str = "\\ ";
      break;
      paramStringBuilder.append(paramc.e());
    }
  }

  public void a(g paramg, StringBuilder paramStringBuilder)
  {
    int i = 1;
    if (paramg.r().a().g(paramg.b()))
    {
      if (("^".equals(paramg.b())) || ("_".equals(paramg.b())))
      {
        com.himamis.retex.editor.a.f.h localh = paramg.a();
        int k = paramg.s();
        if ((k == 0) || ((k > 0) && ((localh.c(k - 1) instanceof c)) && (((c)localh.c(k - 1)).h())))
          paramStringBuilder.append("{\\triangleleft}");
        paramStringBuilder.append(paramg.b() + '{');
        a(paramg.a(0), paramStringBuilder);
        paramStringBuilder.append('}');
      }
      label972: 
      do
      {
        return;
        if ("frac".equals(paramg.b()))
        {
          paramStringBuilder.append("{" + paramg.e());
          paramStringBuilder.append("{");
          a(paramg.a(0), paramStringBuilder);
          paramStringBuilder.append("}{");
          a(paramg.a(i), paramStringBuilder);
          paramStringBuilder.append("}}");
          return;
        }
        if ("sqrt".equals(paramg.b()))
        {
          paramStringBuilder.append(paramg.e());
          paramStringBuilder.append("{");
          a(paramg.a(0), paramStringBuilder);
          paramStringBuilder.append("}");
          return;
        }
        if ("nthroot".equals(paramg.b()))
        {
          paramStringBuilder.append(paramg.e());
          paramStringBuilder.append('[');
          a(paramg.a(0), paramStringBuilder);
          paramStringBuilder.append("]{");
          a(paramg.a(i), paramStringBuilder);
          paramStringBuilder.append('}');
          return;
        }
        if (("sum".equals(paramg.b())) || ("prod".equals(paramg.b())))
        {
          paramStringBuilder.append(paramg.e());
          paramStringBuilder.append("_{");
          a(paramg.a(0), paramStringBuilder);
          paramStringBuilder.append('=');
          a(paramg.a(i), paramStringBuilder);
          paramStringBuilder.append("}^");
          a(paramg.a(2), paramStringBuilder);
          int m;
          if (!this.c)
          {
            boolean bool1 = paramg.a(3).a();
            m = 0;
            if (bool1);
          }
          while (true)
          {
            if (m != 0)
              paramStringBuilder.append('(');
            a(paramg.a(3), paramStringBuilder);
            if (m == 0)
              break;
            paramStringBuilder.append(')');
            return;
            m = i;
          }
        }
        if (("nsum".equals(paramg.b())) || ("nprod".equals(paramg.b())))
        {
          paramStringBuilder.append(paramg.e());
          paramStringBuilder.append("_{");
          a(paramg.a(0), paramStringBuilder);
          paramStringBuilder.append('=');
          a(paramg.a(i), paramStringBuilder);
          paramStringBuilder.append('}');
          int n;
          if (!this.c)
          {
            boolean bool2 = paramg.a(2).a();
            n = 0;
            if (bool2);
          }
          while (true)
          {
            if (n != 0)
              paramStringBuilder.append('(');
            a(paramg.a(2), paramStringBuilder);
            if (n == 0)
              break;
            paramStringBuilder.append(')');
            return;
            n = i;
          }
        }
        if ("int".equals(paramg.b()))
        {
          paramStringBuilder.append(paramg.e());
          paramStringBuilder.append('_');
          a(paramg.a(0), paramStringBuilder);
          paramStringBuilder.append('^');
          a(paramg.a(i), paramStringBuilder);
          paramStringBuilder.append('{');
          boolean bool8 = this.c;
          if (bool8)
            paramStringBuilder.append('(');
          a(paramg.a(2), paramStringBuilder);
          StringBuilder localStringBuilder3 = new StringBuilder(" ");
          if (this.e);
          for (String str5 = "\\nbsp"; ; str5 = "\\ ")
          {
            paramStringBuilder.append(str5 + " d");
            a(paramg.a(3), paramStringBuilder);
            if (bool8)
              paramStringBuilder.append(')');
            paramStringBuilder.append('}');
            return;
          }
        }
        if ("nint".equals(paramg.b()))
        {
          paramStringBuilder.append(paramg.e());
          String str3;
          boolean bool7;
          StringBuilder localStringBuilder2;
          if (this.e)
          {
            str3 = "_{\\nbsp}";
            paramStringBuilder.append(str3 + "{");
            bool7 = this.c;
            if (bool7)
              paramStringBuilder.append('(');
            a(paramg.a(0), paramStringBuilder);
            localStringBuilder2 = new StringBuilder(" ");
            if (!this.e)
              break label972;
          }
          for (String str4 = "\\nbsp"; ; str4 = "\\ ")
          {
            paramStringBuilder.append(str4 + " d");
            a(paramg.a(i), paramStringBuilder);
            if (bool7)
              paramStringBuilder.append(')');
            paramStringBuilder.append('}');
            return;
            str3 = "";
            break;
          }
        }
        if ("lim".equals(paramg.b()))
        {
          if (!this.e)
            paramStringBuilder.append("\\");
          paramStringBuilder.append(paramg.e());
          paramStringBuilder.append("_{");
          a(paramg.a(0), paramStringBuilder);
          paramStringBuilder.append(" \\rightarrow ");
          a(paramg.a(i), paramStringBuilder);
          StringBuilder localStringBuilder1 = new StringBuilder("} ");
          String str2;
          int i2;
          if (this.e)
          {
            str2 = "\\nbsp";
            paramStringBuilder.append(str2 + " {");
            if (this.c)
              break label1186;
            boolean bool5 = paramg.a(2).a();
            i2 = 0;
            if (bool5)
            {
              boolean bool6 = paramg.a().a();
              i2 = 0;
              if (bool6)
                break label1186;
            }
          }
          while (true)
          {
            if (i2 != 0)
              paramStringBuilder.append('(');
            a(paramg.a(2), paramStringBuilder);
            if (i2 != 0)
              paramStringBuilder.append(')');
            paramStringBuilder.append('}');
            return;
            str2 = "\\ ";
            break;
            i2 = i;
          }
        }
        if (!"factorial".equals(paramg.b()))
          continue;
        if ((!this.c) && (!paramg.a(0).a()))
          i = 0;
        if (i != 0)
          paramStringBuilder.append('(');
        a(paramg.a(0), paramStringBuilder);
        if (i != 0)
          paramStringBuilder.append(')');
        paramStringBuilder.append(paramg.e());
        return;
      }
      while (!"function".equals(paramg.b()));
      label1186: paramStringBuilder.append("\\mathrm{" + paramg.e() + "} ");
      String str1;
      label1322: int i1;
      if (this.e)
      {
        str1 = "\\nbsp";
        paramStringBuilder.append(str1 + " ");
        a(paramg.a(0), paramStringBuilder);
        paramStringBuilder.append('(');
        a(paramg.a(i), paramStringBuilder);
        paramStringBuilder.append(")=");
        if (this.c)
          break label1466;
        boolean bool3 = paramg.a(2).a();
        i1 = 0;
        if (bool3)
        {
          boolean bool4 = paramg.a().a();
          i1 = 0;
          if (bool4)
            break label1466;
        }
      }
      while (true)
      {
        if (i1 != 0)
          paramStringBuilder.append('(');
        a(paramg.a(2), paramStringBuilder);
        if (i1 == 0)
          break;
        paramStringBuilder.append(')');
        return;
        str1 = "\\ ";
        break label1322;
        label1466: i1 = i;
      }
    }
    if ((!this.e) && (a(paramg.e())))
      paramStringBuilder.append("{\\" + paramg.e() + "(");
    for (int j = 0; ; j++)
    {
      if (j >= paramg.t())
      {
        paramStringBuilder.append(")}");
        return;
        paramStringBuilder.append("{\\mathrm{" + paramg.e() + "}(");
        break;
      }
      a(paramg.a(j), paramStringBuilder);
      if (j + 1 >= paramg.t())
        continue;
      paramStringBuilder.append(",");
    }
  }

  public void a(com.himamis.retex.editor.a.f.h paramh, StringBuilder paramStringBuilder)
  {
    int i = 1;
    if (((paramh.w()) || (paramh.t() > i) || ((paramh.t() == i) && (a(paramh, 0) > i)) || ((paramh.t() == 0) && (paramh != this.a)) || ((paramh.t() == i) && (paramh == this.a))) && (paramStringBuilder.length() > 0) && (paramStringBuilder.charAt(-1 + paramStringBuilder.length()) != '{'))
    {
      if (i != 0)
        paramStringBuilder.append('{');
      if (paramh.t() != 0)
        break label191;
      if (paramh != this.a)
        break label138;
      paramStringBuilder.append('|');
    }
    while (true)
    {
      if (i != 0)
        paramStringBuilder.append('}');
      return;
      i = 0;
      break;
      label138: if ((paramh.a_() == null) || (((paramh.a_() instanceof g)) && (paramh.s() == paramh.a_().x())))
      {
        paramStringBuilder.append("\\triangleleft");
        continue;
      }
      paramStringBuilder.append("\\triangleright");
      continue;
      label191: if (paramh == this.a)
      {
        if (this.b > 0)
          a(paramh, paramStringBuilder, 0, this.b);
        paramStringBuilder.append('|');
        if (this.b >= paramh.t())
          continue;
        a(paramh, paramStringBuilder, this.b, paramh.t());
        continue;
      }
      a(paramh, paramStringBuilder, 0, paramh.t());
    }
  }

  public void a(com.himamis.retex.editor.a.f.h paramh, StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    while (true)
    {
      if (paramInt1 >= paramInt2)
        return;
      a(paramh.c(paramInt1), paramStringBuilder);
      paramInt1++;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.a.a.e
 * JD-Core Version:    0.6.0
 */