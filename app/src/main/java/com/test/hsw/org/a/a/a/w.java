package org.a.a.a;

import java.io.File;
import java.io.PrintStream;

public class w
{
  public static final String A;
  public static final String B;
  public static final String C;
  public static final String D;
  public static final String E;
  public static final String F;
  public static final String G;
  public static final String H;
  public static final String I;
  public static final String J;
  public static final String K;
  public static final String L;
  public static final String M;
  public static final String N;
  public static final String O;
  public static final String P;
  public static final boolean Q = false;
  public static final boolean R = false;
  public static final boolean S = false;
  public static final boolean T = false;
  public static final boolean U = false;
  public static final boolean V = false;
  public static final boolean W = false;
  public static final boolean X = false;
  public static final boolean Y = false;
  public static final boolean Z = false;
  public static final String a = c("awt.toolkit");
  private static final n aA;
  public static final boolean aa = false;
  public static final boolean ab = false;
  public static final boolean ac = false;
  public static final boolean ad = false;
  public static final boolean ae = false;
  public static final boolean af = false;
  public static final boolean ag = false;
  public static final boolean ah = false;
  public static final boolean ai = false;
  public static final boolean aj = false;
  public static final boolean ak = false;
  public static final boolean al = false;
  public static final boolean am = false;
  public static final boolean an = false;
  public static final boolean ao = false;
  public static final boolean ap = false;
  public static final boolean aq = false;
  public static final boolean ar = false;
  public static final boolean as = false;
  public static final boolean at = false;
  public static final boolean au = false;
  private static final String av = "Windows";
  private static final String aw = "user.home";
  private static final String ax = "user.dir";
  private static final String ay = "java.io.tmpdir";
  private static final String az = "java.home";
  public static final String b = c("file.encoding");
  public static final String c = c("file.separator");
  public static final String d = c("java.awt.fonts");
  public static final String e = c("java.awt.graphicsenv");
  public static final String f = c("java.awt.headless");
  public static final String g = c("java.awt.printerjob");
  public static final String h = c("java.class.path");
  public static final String i = c("java.class.version");
  public static final String j = c("java.compiler");
  public static final String k = c("java.endorsed.dirs");
  public static final String l = c("java.ext.dirs");
  public static final String m = c("java.home");
  public static final String n = c("java.io.tmpdir");
  public static final String o = c("java.library.path");
  public static final String p = c("java.runtime.name");
  public static final String q = c("java.runtime.version");
  public static final String r = c("java.specification.name");
  public static final String s = c("java.specification.vendor");
  public static final String t = c("java.specification.version");
  public static final String u;
  public static final String v;
  public static final String w;
  public static final String x;
  public static final String y;
  public static final String z;

  static
  {
    aA = n.b(t);
    u = c("java.util.prefs.PreferencesFactory");
    v = c("java.vendor");
    w = c("java.vendor.url");
    x = c("java.version");
    y = c("java.vm.info");
    z = c("java.vm.name");
    A = c("java.vm.specification.name");
    B = c("java.vm.specification.vendor");
    C = c("java.vm.specification.version");
    D = c("java.vm.vendor");
    E = c("java.vm.version");
    F = c("line.separator");
    G = c("os.arch");
    H = c("os.name");
    I = c("os.version");
    J = c("path.separator");
    String str;
    if (c("user.country") == null)
    {
      str = c("user.region");
      K = str;
      L = c("user.dir");
      M = c("user.home");
      N = c("user.language");
      O = c("user.name");
      P = c("user.timezone");
      Q = a("1.1");
      R = a("1.2");
      S = a("1.3");
      T = a("1.4");
      U = a("1.5");
      V = a("1.6");
      W = a("1.7");
      X = b("AIX");
      Y = b("HP-UX");
      Z = b("Irix");
      if ((!b("Linux")) && (!b("LINUX")))
        break label743;
    }
    label743: for (boolean bool1 = true; ; bool1 = false)
    {
      aa = bool1;
      ab = b("Mac");
      ac = b("Mac OS X");
      ad = b("FreeBSD");
      ae = b("OpenBSD");
      af = b("NetBSD");
      ag = b("OS/2");
      ah = b("Solaris");
      ai = b("SunOS");
      boolean bool2;
      if ((!X) && (!Y) && (!Z) && (!aa) && (!ac) && (!ah) && (!ai) && (!ad) && (!ae))
      {
        boolean bool3 = af;
        bool2 = false;
        if (!bool3);
      }
      else
      {
        bool2 = true;
      }
      aj = bool2;
      ak = b("Windows");
      al = c("Windows", "5.0");
      am = c("Windows", "5.2");
      an = c("Windows Server 2008", "6.1");
      ao = c("Windows 9", "4.0");
      ap = c("Windows 9", "4.1");
      aq = c("Windows", "4.9");
      ar = b("Windows NT");
      as = c("Windows", "5.1");
      at = c("Windows", "6.0");
      au = c("Windows", "6.1");
      return;
      str = c("user.country");
      break;
    }
  }

  public static File a()
  {
    return new File(System.getProperty("java.home"));
  }

  private static boolean a(String paramString)
  {
    return a(t, paramString);
  }

  static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      return false;
    return paramString1.startsWith(paramString2);
  }

  static boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString2 == null));
    do
      return false;
    while ((!paramString1.startsWith(paramString3)) || (!paramString2.startsWith(paramString4)));
    return true;
  }

  public static boolean a(n paramn)
  {
    return aA.a(paramn);
  }

  public static File b()
  {
    return new File(System.getProperty("java.io.tmpdir"));
  }

  private static boolean b(String paramString)
  {
    return b(H, paramString);
  }

  static boolean b(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      return false;
    return paramString1.startsWith(paramString2);
  }

  public static File c()
  {
    return new File(System.getProperty("user.dir"));
  }

  private static String c(String paramString)
  {
    try
    {
      String str = System.getProperty(paramString);
      return str;
    }
    catch (SecurityException localSecurityException)
    {
      System.err.println("Caught a SecurityException reading the system property '" + paramString + "'; the SystemUtils property value will default to null.");
    }
    return null;
  }

  private static boolean c(String paramString1, String paramString2)
  {
    return a(H, I, paramString1, paramString2);
  }

  public static File d()
  {
    return new File(System.getProperty("user.home"));
  }

  public static boolean e()
  {
    if (f != null)
      return f.equals(Boolean.TRUE.toString());
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.w
 * JD-Core Version:    0.6.0
 */