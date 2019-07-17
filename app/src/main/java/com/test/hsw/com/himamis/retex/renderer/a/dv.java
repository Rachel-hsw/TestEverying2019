package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.b.a;
import com.himamis.retex.renderer.a.b.a.c;
import com.himamis.retex.renderer.a.e.e;
import com.himamis.retex.renderer.a.e.q;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class dv
{
  private static final char A = '^';
  private static final char B = '\'';
  private static final char C = '‵';
  private static final char D = '°';
  private static final char E = '⁰';
  private static final char F = '¹';
  private static final char G = '²';
  private static final char H = '³';
  private static final char I = '⁴';
  private static final char J = '⁵';
  private static final char K = '⁶';
  private static final char L = '⁷';
  private static final char M = '⁸';
  private static final char N = '⁹';
  private static final char O = '⁺';
  private static final char P = '⁻';
  private static final char Q = '⁼';
  private static final char R = '⁽';
  private static final char S = '⁾';
  private static final char T = 'ⁿ';
  private static final char U = '₀';
  private static final char V = '₁';
  private static final char W = '₂';
  private static final char X = '₃';
  private static final char Y = '₄';
  private static final char Z = '₅';
  private static final char aa = '₆';
  private static final char ab = '₇';
  private static final char ac = '₈';
  private static final char ad = '₉';
  private static final char ae = '₊';
  private static final char af = '₋';
  private static final char ag = '₌';
  private static final char ah = '₍';
  private static final char ai = '₎';
  private static final Set<String> aj;
  protected static boolean b = false;
  private static final char p = '\\';
  private static final char q = '{';
  private static final char r = '}';
  private static final char s = '[';
  private static final char t = ']';
  private static final char u = '$';
  private static final char v = '"';
  private static final char w = '%';
  private static final int x = 0;
  private static final int y = 1;
  private static final char z = '_';
  dr a;
  private StringBuffer c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private boolean j;
  private int k;
  private boolean l;
  private boolean m = true;
  private boolean n;
  private boolean o;

  static
  {
    aj = new HashSet(6);
    aj.add("jlmDynamic");
    aj.add("jlmText");
    aj.add("jlmTextit");
    aj.add("jlmTextbf");
    aj.add("jlmTextitbf");
    aj.add("jlmExternalFont");
  }

  public dv(String paramString, c paramc, boolean paramBoolean)
  {
    this(false, paramString, paramc, paramBoolean);
  }

  public dv(String paramString, dr paramdr)
  {
    this(paramString, paramdr, true);
  }

  public dv(String paramString, dr paramdr, boolean paramBoolean)
  {
    this(false, paramString, paramdr, paramBoolean);
  }

  public dv(String paramString, dr paramdr, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(false, paramString, paramdr, paramBoolean1);
    this.m = paramBoolean2;
  }

  public dv(boolean paramBoolean1, String paramString, c paramc, boolean paramBoolean2)
  {
    this(paramBoolean1, paramString, paramc, paramBoolean2);
    this.l = true;
  }

  public dv(boolean paramBoolean1, String paramString, c paramc, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(paramBoolean1, paramString, paramc, paramBoolean2, paramBoolean3);
    this.l = true;
  }

  public dv(boolean paramBoolean, String paramString, dr paramdr)
  {
    this(paramString, paramdr, false);
    this.n = paramBoolean;
    t();
  }

  public dv(boolean paramBoolean1, String paramString, dr paramdr, boolean paramBoolean2)
  {
    this.a = paramdr;
    this.n = paramBoolean1;
    if (paramString != null)
    {
      this.c = new StringBuffer(paramString);
      this.h = paramString.length();
      this.d = 0;
      if (paramBoolean2)
        t();
      return;
    }
    this.c = null;
    this.d = 0;
    this.h = 0;
  }

  public dv(boolean paramBoolean1, String paramString, dr paramdr, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(paramBoolean1, paramString, paramdr, paramBoolean2);
    this.m = paramBoolean3;
  }

  private void a(int paramInt1, int paramInt2, String paramString)
  {
    this.c.replace(paramInt1, paramInt2, paramString);
    this.h = this.c.length();
    this.d = paramInt1;
    this.j = true;
  }

  private d c(char paramChar)
    throws com.himamis.retex.renderer.a.e.n
  {
    this.d = (1 + this.d);
    d locald1 = q();
    if (this.d < this.h);
    for (int i1 = this.c.charAt(this.d); ; i1 = 0)
    {
      d locald2;
      Object localObject1;
      if ((paramChar == '^') && (i1 == 94))
      {
        locald2 = locald1;
        localObject1 = null;
      }
      while (true)
      {
        Object localObject2;
        if ((this.a.u instanceof cl))
          localObject2 = ((cl)this.a.u).d();
        while (true)
        {
          if (((d)localObject2).b() != 1)
            break label256;
          return new f((d)localObject2, (d)localObject1, locald2);
          if ((paramChar == '_') && (i1 == 94))
          {
            this.d = (1 + this.d);
            locald2 = q();
            localObject1 = locald1;
            break;
          }
          if ((paramChar == '^') && (i1 == 95))
          {
            this.d = (1 + this.d);
            d locald3 = q();
            locald2 = locald1;
            localObject1 = locald3;
            break;
          }
          if ((paramChar != '^') || (i1 == 95))
            break label345;
          locald2 = locald1;
          localObject1 = null;
          break;
          if (this.a.u == null)
          {
            localObject2 = new bx(new n('M', "mathnormal"), false, true, true);
            continue;
          }
          localObject2 = this.a.u;
          this.a.u = null;
        }
        label256: if ((localObject2 instanceof bu))
          if (((bu)localObject2).d())
          {
            if (locald2 != null)
            {
              ((bu)localObject2).a(locald2);
              return new cp((d)localObject2, (d)localObject1, null);
            }
          }
          else if (localObject1 != null)
          {
            ((bu)localObject2).a((d)localObject1);
            return new cp((d)localObject2, null, locald2);
          }
        return new cp((d)localObject2, (d)localObject1, locald2);
        label345: localObject1 = locald1;
        locald2 = null;
      }
    }
  }

  private String c(String paramString)
  {
    if (paramString.equals("left"))
      return a("\\left", "\\right");
    be localbe = (be)be.a.get(paramString);
    if (localbe != null)
      if (!localbe.d)
        break label214;
    label214: for (int i1 = localbe.e; ; i1 = 0)
    {
      String[] arrayOfString = a(localbe.c, i1);
      StringBuffer localStringBuffer = new StringBuffer("\\");
      localStringBuffer.append(paramString);
      int i2 = 0;
      int i3 = localbe.e;
      int i4 = 0;
      if (i2 >= i3);
      while (true)
      {
        if (i4 >= localbe.c)
        {
          return localStringBuffer.toString();
          String str1 = arrayOfString[(1 + (i2 + localbe.c))];
          if (str1 != null)
            localStringBuffer.append("[").append(str1).append("]");
          i2++;
          break;
        }
        String str2 = arrayOfString[(i4 + 1)];
        if (str2 != null)
          localStringBuffer.append("{").append(str2).append("}");
        i4++;
      }
      return "\\" + paramString;
    }
  }

  private static char d(char paramChar)
  {
    if (paramChar == '٫')
      paramChar = '.';
    do
    {
      return paramChar;
      if (('٠' <= paramChar) && (paramChar <= '٩'))
        return (char)(paramChar - 'ذ');
      if (('۰' <= paramChar) && (paramChar <= '۹'))
        return (char)(paramChar - 'ۀ');
      if (('०' <= paramChar) && (paramChar <= '९'))
        return (char)(paramChar - 'श');
      if (('০' <= paramChar) && (paramChar <= '৯'))
        return (char)(paramChar - 'শ');
      if (('੦' <= paramChar) && (paramChar <= '੯'))
        return (char)(paramChar - 'ਸ਼');
      if (('૦' <= paramChar) && (paramChar <= '૯'))
        return (char)(paramChar - 'શ');
      if (('୦' <= paramChar) && (paramChar <= '୯'))
        return (char)(paramChar - 'ଶ');
      if (('౦' <= paramChar) && (paramChar <= '౯'))
        return (char)(paramChar - 'శ');
      if (('൦' <= paramChar) && (paramChar <= '൯'))
        return (char)(paramChar - 'ശ');
      if (('๐' <= paramChar) && (paramChar <= '๙'))
        return (char)(paramChar - 'ภ');
      if (('໐' <= paramChar) && (paramChar <= '໙'))
        return (char)(paramChar - 'ຠ');
      if (('༠' <= paramChar) && (paramChar <= '༩'))
        return (char)(paramChar - 'ຐ');
      if (('၀' <= paramChar) && (paramChar <= '၉'))
        return (char)(paramChar - 'တ');
      if (('០' <= paramChar) && (paramChar <= '៩'))
        return (char)(paramChar - 'ឰ');
      if (('᠐' <= paramChar) && (paramChar <= '᠙'))
        return (char)(paramChar - '០');
      if (('᭐' <= paramChar) && (paramChar <= '᭙'))
        return (char)(paramChar - 'ᬠ');
      if (('᮰' <= paramChar) && (paramChar <= '᮹'))
        return (char)(paramChar - 'ᮀ');
      if (('᱀' <= paramChar) && (paramChar <= '᱉'))
        return (char)(paramChar - 'ᰐ');
      if (('᱐' <= paramChar) && (paramChar <= '᱙'))
        return (char)(paramChar - 'ᰠ');
    }
    while ((43216 > paramChar) || (paramChar > 43225));
    return (char)(paramChar - 43168);
  }

  private d d(String paramString)
    throws com.himamis.retex.renderer.a.e.n
  {
    be localbe = (be)be.a.get(paramString);
    if (localbe.d);
    for (int i1 = localbe.e; ; i1 = 0)
    {
      String[] arrayOfString = a(localbe.c, i1);
      arrayOfString[0] = paramString;
      if (bm.a(paramString))
      {
        String str = (String)localbe.a(this, arrayOfString);
        a(this.e, this.d, str);
        return null;
      }
      return (d)localbe.a(this, arrayOfString);
    }
  }

  private void t()
    throws com.himamis.retex.renderer.a.e.n
  {
    if (this.h != 0);
    while (true)
    {
      if (this.d >= this.h)
      {
        this.d = 0;
        this.h = this.c.length();
        return;
      }
      switch (this.c.charAt(this.d))
      {
      default:
        this.d = (1 + this.d);
        break;
      case '\\':
        int i4 = this.d;
        String str1 = u();
        if (("newcommand".equals(str1)) || ("renewcommand".equals(str1)))
        {
          String[] arrayOfString1 = a(2, 2);
          be localbe1 = (be)be.a.get(str1);
          try
          {
            localbe1.a(this, arrayOfString1);
            this.c.delete(i4, this.d);
            this.h = this.c.length();
            this.d = i4;
          }
          catch (com.himamis.retex.renderer.a.e.n localn1)
          {
            while (this.n);
            throw localn1;
          }
        }
        if (bm.a(str1))
        {
          be localbe3 = (be)be.a.get(str1);
          int i6 = localbe3.c;
          int i7;
          String[] arrayOfString4;
          if (localbe3.d)
          {
            i7 = 1;
            arrayOfString4 = a(i6, i7);
            arrayOfString4[0] = str1;
          }
          try
          {
            this.c.replace(i4, this.d, (String)localbe3.a(this, arrayOfString4));
            i8 = i4;
            this.h = this.c.length();
            this.d = i8;
            continue;
            i7 = 0;
          }
          catch (com.himamis.retex.renderer.a.e.n localn3)
          {
            while (true)
            {
              if (!this.n)
                throw localn3;
              int i8 = i4 + (1 + str1.length());
            }
          }
        }
        if ("begin".equals(str1))
        {
          String[] arrayOfString2 = a(1, 0);
          be localbe2 = (be)be.a.get(arrayOfString2[1] + "@env");
          if (localbe2 == null)
          {
            if (this.n)
              continue;
            throw new com.himamis.retex.renderer.a.e.n("Unknown environment: " + arrayOfString2[1] + " at position " + b() + ":" + c());
          }
          while (true)
          {
            String[] arrayOfString3;
            int i5;
            try
            {
              arrayOfString3 = a(-1 + localbe2.c, 0);
              String str2 = a("\\begin{" + arrayOfString2[1] + "}", "\\end{" + arrayOfString2[1] + "}");
              localObject = "{\\makeatletter \\" + arrayOfString2[1] + "@env";
              i5 = 1;
              if (i5 <= -1 + localbe2.c)
                break label904;
              String str4 = localObject + "{" + str2 + "}\\makeatother}";
              this.c.replace(i4, this.d, str4);
              this.h = this.c.length();
              this.d = i4;
            }
            catch (com.himamis.retex.renderer.a.e.n localn2)
            {
            }
            if (this.n)
              break;
            throw localn2;
            String str3 = localObject + "{" + arrayOfString3[i5] + "}";
            Object localObject = str3;
            i5++;
          }
        }
        if ("makeatletter".equals(str1))
        {
          this.k = (1 + this.k);
          continue;
        }
        if ("makeatother".equals(str1))
        {
          this.k = (-1 + this.k);
          continue;
        }
        if (!aj.contains(str1))
          continue;
        a(1, 0);
        break;
      case '%':
        int i1 = this.d;
        this.d = (i1 + 1);
        if (this.d >= this.h);
        while (true)
        {
          if (this.d < this.h)
            this.d = (-1 + this.d);
          this.c.replace(i1, this.d, "");
          this.h = this.c.length();
          this.d = i1;
          break;
          StringBuffer localStringBuffer = this.c;
          int i2 = this.d;
          this.d = (i2 + 1);
          int i3 = localStringBuffer.charAt(i2);
          if (i3 == 13)
            continue;
          if (i3 != 10)
            break label1036;
        }
      case '°':
        this.c.replace(this.d, 1 + this.d, "^\\circ");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '²':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsup{2}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '³':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsup{3}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '¹':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsup{1}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '⁰':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsup{0}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '⁴':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsup{4}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '⁵':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsup{5}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '⁶':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsup{6}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '⁷':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsup{7}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '⁸':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsup{8}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '⁹':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsup{9}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '⁺':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsup{+}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '⁻':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsup{-}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '⁼':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsup{=}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '⁽':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsup{(}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '⁾':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsup{)}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case 'ⁿ':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsup{n}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '₂':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsub{2}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '₃':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsub{3}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '₁':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsub{1}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '₀':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsub{0}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '₄':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsub{4}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '₅':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsub{5}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '₆':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsub{6}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '₇':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsub{7}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '₈':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsub{8}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '₉':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsub{9}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '₊':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsub{+}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '₋':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsub{-}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '₌':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsub{=}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '₍':
        this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsub{(}");
        this.h = this.c.length();
        this.d = (1 + this.d);
        break;
      case '₎':
        label904: label1036: this.c.replace(this.d, 1 + this.d, "\\jlatexmathcumsub{)}");
        this.h = this.c.length();
        this.d = (1 + this.d);
      }
    }
  }

  private String u()
  {
    int i1 = 1 + this.d;
    this.d = i1;
    int i2 = 0;
    label25: String str;
    if (this.d >= this.h)
    {
      if (i2 != 0)
        break label97;
      str = "";
    }
    label97: 
    do
    {
      return str;
      i2 = this.c.charAt(this.d);
      if (((i2 < 97) || (i2 > 122)) && ((i2 < 65) || (i2 > 90)) && ((this.k == 0) || (i2 != 64)))
        break label25;
      this.d = (1 + this.d);
      break;
      if (this.d == i1)
        this.d = (1 + this.d);
      str = this.c.substring(i1, this.d);
    }
    while ((!"cr".equals(str)) || (this.d >= this.h) || (this.c.charAt(this.d) != ' '));
    this.d = (1 + this.d);
    return str;
  }

  private d v()
    throws com.himamis.retex.renderer.a.e.n
  {
    this.e = this.d;
    String str = u();
    if (str.length() == 0)
      return new aa();
    if (be.a.get(str) != null)
      return d(str);
    try
    {
      d locald = dr.f(str).u;
      return locald;
    }
    catch (e locale)
    {
      try
      {
        dm localdm = dm.b(str);
        return localdm;
      }
      catch (q localq)
      {
        if (!this.n)
          throw new com.himamis.retex.renderer.a.e.n("Unknown symbol or command or predefined TeXFormula: '" + str + "'");
      }
    }
    return new r(new ch(new dr("\\backslash " + str).u), null, s.a);
  }

  private final void w()
  {
    while (true)
    {
      if (this.d >= this.h);
      int i1;
      do
      {
        return;
        i1 = this.c.charAt(this.d);
      }
      while ((i1 != 32) && (i1 != 9) && (i1 != 10) && (i1 != 13));
      if (i1 == 10)
      {
        this.f = (1 + this.f);
        this.g = this.d;
      }
      this.d = (1 + this.d);
    }
  }

  public int a(int paramInt)
  {
    this.d -= paramInt;
    return this.d;
  }

  public d a(char paramChar, boolean paramBoolean)
    throws com.himamis.retex.renderer.a.e.n
  {
    if (this.m)
    {
      if ((paramChar >= 'α') && (paramChar <= 'ω'))
        return dm.b(dr.o[paramChar]);
      if ((paramChar >= 'Α') && (paramChar <= 'Ω'))
        return new dr(dr.q[paramChar]).u;
    }
    char c1 = d(paramChar);
    a.c localc;
    String str;
    if (((c1 < '0') || (c1 > '9')) && ((c1 < 'a') || (c1 > 'z')) && ((c1 < 'A') || (c1 > 'Z')))
    {
      localc = a.c.a(c1);
      if ((!b) && (!v.n.contains(localc)))
        v.a((b)v.o.get(localc));
      str = dr.o[c1];
      if ((str == null) && ((dr.q == null) || (dr.q[c1] == null)))
      {
        boolean bool = a.c.a.equals(localc);
        if (((!bool) || (!dr.a(a.c.a))) && (bool))
          break label751;
      }
    }
    label751: for (dr.a locala1 = dr.b(localc); ; locala1 = null)
    {
      if (locala1 != null)
      {
        if (paramBoolean)
          return new ay(a.b(c1), locala1);
        int i1 = this.d;
        this.d = (i1 + 1);
        int i2 = -1 + this.h;
        while (true)
        {
          if (this.d >= this.h);
          while (true)
          {
            return new ay(this.c.substring(i1, i2 + 1), locala1);
            if (a.c.a(this.c.charAt(this.d)).equals(localc))
              break;
            i2 = -1 + this.d;
            this.d = i2;
          }
          this.d = (1 + this.d);
        }
      }
      if (!this.n)
        throw new com.himamis.retex.renderer.a.e.n("Unknown character : '" + a.b(c1) + "' (or " + c1 + ")");
      return new r(new ch(new dr("\\text{(Unknown char " + c1 + ")}").u), null, s.a);
      if ((!this.m) && (dr.p[c1] != null))
        return dm.b(dr.p[c1]).a(c1);
      if ((dr.q != null) && (dr.q[c1] != null))
        return new dr(dr.q[c1]).u;
      try
      {
        dm localdm = dm.b(str);
        return localdm;
      }
      catch (q localq)
      {
        throw new com.himamis.retex.renderer.a.e.n("The character '" + a.b(c1) + "' was mapped to an unknown symbol with the name '" + str + "'!", localq);
      }
      dr.a locala2 = (dr.a)dr.r.get(a.c.a);
      if (locala2 != null)
      {
        if (paramBoolean)
          return new ay(a.b(c1), locala2);
        int i3 = this.d;
        this.d = (i3 + 1);
        int i4 = -1 + this.h;
        while (true)
        {
          if (this.d >= this.h);
          while (true)
          {
            return new ay(this.c.substring(i3, i4 + 1), locala2);
            int i5 = this.c.charAt(this.d);
            if (((i5 >= 48) && (i5 <= 57)) || ((i5 >= 97) && (i5 <= 122)) || ((i5 >= 65) && (i5 <= 90)))
              break;
            i4 = -1 + this.d;
            this.d = i4;
          }
          this.d = (1 + this.d);
        }
      }
      return new n(c1, this.a.v);
    }
  }

  public String a(char paramChar)
    throws com.himamis.retex.renderer.a.e.n
  {
    int i1 = this.d;
    char c1;
    do
    {
      StringBuffer localStringBuffer = this.c;
      int i2 = this.d;
      this.d = (i2 + 1);
      c1 = localStringBuffer.charAt(i2);
      if (c1 != '\\')
        continue;
      this.d = (1 + this.d);
    }
    while ((this.d < this.h) && (c1 != paramChar));
    if (c1 == paramChar)
      return this.c.substring(i1, -1 + this.d);
    return this.c.substring(i1, this.d);
  }

  public String a(char paramChar1, char paramChar2)
    throws com.himamis.retex.renderer.a.e.n
  {
    if (this.d == this.h)
      return null;
    char c1 = this.c.charAt(this.d);
    if ((this.d < this.h) && (c1 == paramChar1))
    {
      int i1 = 1;
      int i2 = this.d;
      while (true)
      {
        if ((this.d >= -1 + this.h) || (i1 == 0))
        {
          this.d = (1 + this.d);
          if (i1 == 0)
            break;
          return this.c.substring(i2 + 1, this.d);
        }
        this.d = (1 + this.d);
        char c2 = this.c.charAt(this.d);
        if (c2 == paramChar1)
        {
          i1++;
          continue;
        }
        if (c2 == paramChar2)
        {
          i1--;
          continue;
        }
        if ((c2 != '\\') || (this.d == -1 + this.h))
          continue;
        this.d = (1 + this.d);
      }
      return this.c.substring(i2 + 1, -1 + this.d);
    }
    throw new com.himamis.retex.renderer.a.e.n("missing '" + paramChar1 + "'!");
  }

  public String a(String paramString1, String paramString2)
    throws com.himamis.retex.renderer.a.e.n
  {
    int i1 = 1;
    int i2 = paramString1.length();
    int i3 = paramString2.length();
    boolean bool1 = b(paramString1.charAt(i2 - 1));
    boolean bool2 = b(paramString2.charAt(i3 - 1));
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    char c1 = '\000';
    StringBuffer localStringBuffer1 = new StringBuffer();
    char c2;
    if ((this.d >= this.h) || (i1 == 0))
    {
      if (i1 == 0)
        break label464;
      if (this.n)
        return localStringBuffer1.toString();
    }
    else
    {
      c2 = this.c.charAt(this.d);
      if ((c1 == '\\') || (c2 != ' '))
        break label519;
      label122: if (this.d < this.h)
      {
        StringBuffer localStringBuffer3 = this.c;
        int i13 = this.d;
        this.d = (i13 + 1);
        if (localStringBuffer3.charAt(i13) == ' ');
      }
      else
      {
        StringBuffer localStringBuffer2 = this.c;
        int i12 = -1 + this.d;
        this.d = i12;
        c2 = localStringBuffer2.charAt(i12);
        if ((!b(c1)) || (!b(c2)))
          break label519;
        i5 = 0;
        c1 = c2;
        i4 = 0;
      }
    }
    while (true)
    {
      label236: char c3;
      label261: int i8;
      if (c1 == paramString1.charAt(i4))
      {
        i4++;
        if (c1 != paramString2.charAt(i5))
          break label394;
        if (i5 == 0)
          i6 = this.d;
        i5++;
        if (1 + this.d >= this.h)
          break label400;
        c3 = this.c.charAt(1 + this.d);
        if (i4 != i2)
          break label505;
        if ((!bool1) || (!b(c3)))
          i1++;
        i8 = i1;
      }
      label346: label505: int i7;
      for (int i9 = 0; ; i9 = i7)
      {
        int i11;
        if (i5 == i3)
          if ((!bool2) || (!b(c3)))
          {
            i11 = i8 - 1;
            i4 = i9;
            i1 = i11;
            i5 = 0;
          }
        while (true)
        {
          localStringBuffer1.append(c1);
          this.d = (1 + this.d);
          break;
          localStringBuffer1.append(' ');
          break label122;
          i4 = 0;
          break label236;
          label394: i5 = 0;
          break label261;
          label400: if (i4 == i2)
          {
            i1++;
            i4 = 0;
          }
          if (i5 != i3)
            continue;
          i1--;
          i5 = 0;
          continue;
          throw new com.himamis.retex.renderer.a.e.n("The token " + paramString1 + " must be closed by " + paramString2);
          label464: return localStringBuffer1.substring(0, i6 + (localStringBuffer1.length() - this.d));
          i11 = i8;
          break label346;
          int i10 = i9;
          i1 = i8;
          i4 = i10;
        }
        i7 = i4;
        i8 = i1;
      }
      label519: c1 = c2;
    }
  }

  public void a(d paramd)
  {
    this.a.a(paramd);
  }

  public void a(String paramString)
  {
    this.c = new StringBuffer(paramString);
    this.h = this.c.length();
    this.a.u = null;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.i = 0;
    this.j = false;
    this.k = 0;
    this.l = false;
    this.m = true;
    t();
  }

  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public boolean a()
  {
    return this.n;
  }

  public String[] a(int paramInt1, int paramInt2)
  {
    int i1 = 2;
    String[] arrayOfString = new String[1 + (paramInt1 + 10)];
    int i3;
    if (paramInt1 != 0)
    {
      if (paramInt2 == 1)
      {
        i3 = paramInt1 + 1;
        if (i3 < paramInt1 + 11)
          break label90;
      }
      w();
    }
    while (true)
    {
      try
      {
        while (true)
        {
          arrayOfString[1] = a('{', '}');
          if (paramInt2 == i1)
          {
            i2 = paramInt1 + 1;
            if (i2 < paramInt1 + 11);
          }
          else
          {
            if (i1 <= paramInt1)
              break label232;
            if (this.m)
              w();
            return arrayOfString;
            try
            {
              label90: w();
              arrayOfString[i3] = a('[', ']');
              i3++;
            }
            catch (com.himamis.retex.renderer.a.e.n localn4)
            {
              arrayOfString[i3] = null;
            }
          }
        }
      }
      catch (com.himamis.retex.renderer.a.e.n localn1)
      {
        int i2;
        if (this.c.charAt(this.d) == '\\')
          continue;
        arrayOfString[1] = this.c.charAt(this.d);
        this.d = (1 + this.d);
        continue;
        arrayOfString[1] = c(u());
        continue;
        try
        {
          w();
          arrayOfString[i2] = a('[', ']');
          i2++;
        }
        catch (com.himamis.retex.renderer.a.e.n localn3)
        {
          arrayOfString[i2] = null;
        }
        continue;
        label232: w();
      }
      try
      {
        arrayOfString[i1] = a('{', '}');
        i1++;
      }
      catch (com.himamis.retex.renderer.a.e.n localn2)
      {
        while (true)
        {
          if (this.c.charAt(this.d) != '\\')
          {
            arrayOfString[i1] = this.c.charAt(this.d);
            this.d = (1 + this.d);
            continue;
          }
          arrayOfString[i1] = c(u());
        }
      }
    }
  }

  public int b()
  {
    return this.f;
  }

  public final boolean b(char paramChar)
  {
    return (Character.isLetter(paramChar)) || ((this.k != 0) && (paramChar == '@'));
  }

  public final boolean b(String paramString)
  {
    char c1 = '\000';
    if ((paramString == null) || ("".equals(paramString)));
    do
      return false;
    while (paramString.charAt(0) != '\\');
    int i1 = 1;
    int i2 = paramString.length();
    while (true)
    {
      if (i1 >= i2);
      do
      {
        return Character.isLetter(c1);
        c1 = paramString.charAt(i1);
      }
      while ((!Character.isLetter(c1)) && ((this.k == 0) || (c1 != '@')));
      i1++;
    }
  }

  public int c()
  {
    return -1 + (this.d - this.g);
  }

  public d d()
  {
    d locald = this.a.u;
    if ((locald instanceof cl))
      return ((cl)locald).d();
    this.a.u = null;
    return locald;
  }

  public d e()
  {
    d locald = this.a.u;
    this.a.u = null;
    return locald;
  }

  public void f()
  {
    this.k = (1 + this.k);
  }

  public void g()
  {
    this.k = (-1 + this.k);
  }

  public boolean h()
  {
    return this.k != 0;
  }

  public boolean i()
  {
    return this.l;
  }

  public boolean j()
  {
    return this.m;
  }

  public boolean k()
  {
    return this.m;
  }

  public int l()
  {
    return this.d;
  }

  public String m()
  {
    return this.c.substring(this.d);
  }

  public void n()
  {
    this.d = this.c.length();
  }

  public void o()
    throws com.himamis.retex.renderer.a.e.n
  {
    if (!this.l)
      throw new com.himamis.retex.renderer.a.e.n("You can add a row only in array mode !");
    ((c)this.a).b();
  }

  public void p()
    throws com.himamis.retex.renderer.a.e.n
  {
    if (this.h != 0);
    label50: char c1;
    do
    {
      do
      {
        while (true)
        {
          if (this.d >= this.h)
          {
            if ((this.a.u == null) && (!this.l))
              this.a.a(new aa());
            return;
          }
          c1 = this.c.charAt(this.d);
          switch (c1)
          {
          default:
            this.a.a(a(c1, false));
            this.d = (1 + this.d);
            break;
          case '\n':
            this.f = (1 + this.f);
            this.g = this.d;
          case '\t':
          case '\r':
            this.d = (1 + this.d);
          case ' ':
          case '$':
          case '\\':
          case '{':
          case '}':
          case '^':
          case '_':
          case '&':
          case '\'':
          case '‵':
          case '"':
          }
        }
        this.d = (1 + this.d);
      }
      while (this.m);
      this.a.a(new cu());
      this.a.a(new k());
      while (this.d < this.h)
      {
        int i3 = this.c.charAt(this.d);
        if ((i3 != 32) || (i3 != 9) || (i3 != 13))
          break;
        this.d = (1 + this.d);
      }
      this.d = (1 + this.d);
    }
    while (this.m);
    int i2;
    int i1;
    if (this.c.charAt(this.d) == '$')
    {
      this.d = (1 + this.d);
      i2 = 1;
      i1 = 0;
    }
    while (true)
    {
      this.a.a(new bf(new dr(this, a('$'), false).u, i1));
      if ((i2 == 0) || (this.c.charAt(this.d) != '$'))
        break;
      this.d = (1 + this.d);
      break;
      d locald2 = v();
      this.a.a(locald2);
      if ((this.l) && ((locald2 instanceof as)))
        ((c)this.a).b();
      if (!this.j)
        break;
      this.j = false;
      break;
      d locald1 = q();
      if (locald1 != null)
        locald1.c = 0;
      this.a.a(locald1);
      break;
      this.i = (-1 + this.i);
      this.d = (1 + this.d);
      if (this.i != -1)
        break label50;
      throw new com.himamis.retex.renderer.a.e.n("Found a closing '}' without an opening '{'!");
      this.a.a(c(c1));
      break;
      if (this.m)
      {
        this.a.a(c(c1));
        break;
      }
      this.a.a(new ef());
      this.d = (1 + this.d);
      break;
      if (!this.l)
        throw new com.himamis.retex.renderer.a.e.n("Character '&' is only available in array mode !");
      ((c)this.a).a();
      this.d = (1 + this.d);
      break;
      if (this.m)
        this.a.a(new t(d(), null, dm.b("prime")));
      while (true)
      {
        this.d = (1 + this.d);
        break;
        this.a.a(a('\'', true));
      }
      if (this.m)
        this.a.a(new t(d(), null, dm.b("backprime")));
      while (true)
      {
        this.d = (1 + this.d);
        break;
        this.a.a(a('‵', true));
      }
      if (this.m)
      {
        this.a.a(new t(d(), null, dm.b("prime")));
        this.a.a(new t(d(), null, dm.b("prime")));
      }
      while (true)
      {
        this.d = (1 + this.d);
        break;
        this.a.a(a('\'', true));
        this.a.a(a('\'', true));
      }
      i1 = 2;
      i2 = 0;
    }
  }

  public d q()
    throws com.himamis.retex.renderer.a.e.n
  {
    w();
    char c1;
    dr localdr1;
    Object localObject;
    if (this.d < this.h)
    {
      c1 = this.c.charAt(this.d);
      if (c1 != '{')
        break label124;
      localdr1 = new dr();
      dr localdr2 = this.a;
      this.a = localdr1;
      this.d = (1 + this.d);
      this.i = (1 + this.i);
      p();
      this.a = localdr2;
      if (this.a.u != null)
        break label119;
      localObject = new cl();
      ((cl)localObject).a(localdr1.u);
    }
    while (true)
    {
      return localObject;
      return new aa();
      label119: return localdr1.u;
      label124: if (c1 != '\\')
        break;
      localObject = v();
      if (!this.j)
        continue;
      this.j = false;
      return q();
    }
    d locald = a(c1, true);
    this.d = (1 + this.d);
    return (d)locald;
  }

  public String r()
    throws com.himamis.retex.renderer.a.e.n
  {
    Object localObject;
    if (this.d == this.h)
      localObject = null;
    while (true)
    {
      return localObject;
      int i1 = this.d;
      int i2 = 0;
      int i3 = 1;
      if ((this.d >= this.h) || (i3 == 0))
      {
        if (i3 >= 2)
          throw new com.himamis.retex.renderer.a.e.n("Illegal end,  missing '}' !");
      }
      else
      {
        i2 = this.c.charAt(this.d);
        switch (i2)
        {
        default:
        case 123:
        case 38:
        case 125:
        case 92:
        }
        while (true)
        {
          this.d = (1 + this.d);
          break;
          i3++;
          continue;
          if (i3 != 1)
            continue;
          i3--;
          continue;
          i3--;
          continue;
          this.d = (1 + this.d);
          if ((this.d < this.h) && (this.c.charAt(this.d) == '\\') && (i3 == 1))
          {
            i3--;
            this.d = (-1 + this.d);
            continue;
          }
          if ((this.d >= -1 + this.h) || (this.c.charAt(this.d) != 'c') || (this.c.charAt(1 + this.d) != 'r') || (i3 != 1))
            continue;
          i3--;
          this.d = (-1 + this.d);
        }
      }
      int i4;
      if (i3 == 0)
      {
        String str = this.c.substring(i1, -1 + this.d);
        i4 = i2;
        localObject = str;
      }
      while ((i4 == 38) || (i4 == 92) || (i4 == 125))
      {
        this.d = (-1 + this.d);
        return localObject;
        localObject = this.c.substring(i1, this.d);
        i4 = 0;
      }
    }
  }

  public float[] s()
    throws com.himamis.retex.renderer.a.e.n
  {
    if (this.d == this.h)
      return null;
    int i1 = 0;
    w();
    int i2 = this.d;
    while (true)
    {
      if ((this.d >= this.h) || (i1 == 32))
      {
        w();
        return cu.b(this.c.substring(i2, -1 + this.d));
      }
      StringBuffer localStringBuffer = this.c;
      int i3 = this.d;
      this.d = (i3 + 1);
      i1 = localStringBuffer.charAt(i3);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.dv
 * JD-Core Version:    0.6.0
 */