package com.himamis.retex.renderer.a.b;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class a
{
  public static final byte A = 23;
  public static final byte B = 24;
  public static final byte C = 25;
  public static final byte D = 26;
  public static final byte E = 27;
  public static final byte F = 28;
  public static final byte G = 29;
  public static final byte H = 30;
  static final int I = -1;
  public static final byte J = -1;
  public static final byte K = 0;
  public static final byte L = 1;
  public static final byte M = 2;
  public static final byte N = 3;
  public static final byte O = 4;
  public static final byte P = 5;
  public static final byte Q = 6;
  public static final byte R = 7;
  public static final byte S = 8;
  public static final byte T = 9;
  public static final byte U = 10;
  public static final byte V = 11;
  public static final byte W = 12;
  public static final byte X = 13;
  public static final byte Y = 14;
  public static final byte Z = 15;
  public static final int a = 2;
  public static final byte aa = 16;
  public static final byte ab = 17;
  public static final byte ac = 18;
  public static final char ad = '���';
  public static final char ae = '���';
  public static final char af = '���';
  public static final char ag = '���';
  public static final char ah = '���';
  public static final char ai = '���';
  public static final int aj = 65536;
  public static final int ak = 0;
  public static final int al = 1114111;
  private static final long an = 3786198910865385080L;
  public static final int b = 36;
  public static final char c = '\000';
  public static final char d = '￿';
  public static final byte e = 0;
  public static final byte f = 1;
  public static final byte g = 2;
  public static final byte h = 3;
  public static final byte i = 4;
  public static final byte j = 5;
  public static final byte k = 6;
  public static final byte l = 7;
  public static final byte m = 8;
  public static final byte n = 9;
  public static final byte o = 10;
  public static final byte p = 11;
  public static final byte q = 12;
  public static final byte r = 13;
  public static final byte s = 14;
  public static final byte t = 15;
  public static final byte u = 16;
  public static final byte v = 18;
  public static final byte w = 19;
  public static final byte x = 20;
  public static final byte y = 21;
  public static final byte z = 22;
  private final char am;

  public a(char paramChar)
  {
    this.am = paramChar;
  }

  public static int a(int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    if (b(paramInt1))
    {
      paramArrayOfChar[paramInt2] = (char)paramInt1;
      return 1;
    }
    if (a(paramInt1))
    {
      b(paramInt1, paramArrayOfChar, paramInt2);
      return 2;
    }
    throw new IllegalArgumentException();
  }

  public static int a(CharSequence paramCharSequence, int paramInt)
  {
    int i1 = paramInt + 1;
    int i2 = paramCharSequence.charAt(paramInt);
    if ((c((char)i2)) && (i1 < paramCharSequence.length()))
    {
      char c1 = paramCharSequence.charAt(i1);
      if (d(c1))
        i2 = b((char)i2, c1);
    }
    return i2;
  }

  public static int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i1 = paramCharSequence.length();
    if ((paramInt1 < 0) || (paramInt2 > i1) || (paramInt1 > paramInt2))
      throw new IndexOutOfBoundsException();
    int i2 = paramInt2 - paramInt1;
    while (true)
    {
      if (paramInt1 >= paramInt2)
        return i2;
      int i3 = paramInt1 + 1;
      if ((c(paramCharSequence.charAt(paramInt1))) && (i3 < paramInt2) && (d(paramCharSequence.charAt(i3))))
      {
        i2--;
        paramInt1 = i3 + 1;
        continue;
      }
      paramInt1 = i3;
    }
  }

  public static int a(char[] paramArrayOfChar, int paramInt)
  {
    return b(paramArrayOfChar, paramInt, paramArrayOfChar.length);
  }

  public static int a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= paramInt2) || (paramInt2 < 0) || (paramInt2 > paramArrayOfChar.length))
      throw new IndexOutOfBoundsException();
    return b(paramArrayOfChar, paramInt1, paramInt2);
  }

  public static int a(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > paramArrayOfChar.length - paramInt1) || (paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < paramInt1) || (paramInt3 > paramInt1 + paramInt2))
      throw new IndexOutOfBoundsException();
    return b(paramArrayOfChar, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public static a a(char paramChar)
  {
    if (paramChar <= '')
      return a.a[paramChar];
    return new a(paramChar);
  }

  public static boolean a(char paramChar1, char paramChar2)
  {
    return (c(paramChar1)) && (d(paramChar2));
  }

  public static boolean a(int paramInt)
  {
    return paramInt >>> 16 < 17;
  }

  public static int b(char paramChar1, char paramChar2)
  {
    return -56613888 + (paramChar2 + (paramChar1 << '\n'));
  }

  public static int b(CharSequence paramCharSequence, int paramInt)
  {
    int i1 = paramInt - 1;
    int i2 = paramCharSequence.charAt(i1);
    if ((d((char)i2)) && (i1 > 0))
    {
      char c1 = paramCharSequence.charAt(i1 - 1);
      if (c(c1))
        i2 = b(c1, (char)i2);
    }
    return i2;
  }

  public static int b(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i1 = paramCharSequence.length();
    if ((paramInt1 < 0) || (paramInt1 > i1))
      throw new IndexOutOfBoundsException();
    int i4;
    if (paramInt2 >= 0)
    {
      int i3 = 0;
      int i5;
      for (i4 = paramInt1; ; i4 = i5)
      {
        if ((i4 >= i1) || (i3 >= paramInt2))
        {
          if (i3 >= paramInt2)
            break;
          throw new IndexOutOfBoundsException();
        }
        i5 = i4 + 1;
        if ((c(paramCharSequence.charAt(i4))) && (i5 < i1) && (d(paramCharSequence.charAt(i5))))
          i5++;
        i3++;
      }
    }
    int i2 = paramInt1;
    while (true)
    {
      if ((i2 <= 0) || (paramInt2 >= 0))
      {
        if (paramInt2 >= 0)
          break;
        throw new IndexOutOfBoundsException();
      }
      i2--;
      if ((d(paramCharSequence.charAt(i2))) && (i2 > 0) && (c(paramCharSequence.charAt(i2 - 1))))
        i2--;
      paramInt2++;
    }
    i2 = i4;
    return i2;
  }

  public static int b(char[] paramArrayOfChar, int paramInt)
  {
    return d(paramArrayOfChar, paramInt, 0);
  }

  static int b(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i1 = paramInt1 + 1;
    int i2 = paramArrayOfChar[paramInt1];
    if ((c((char)i2)) && (i1 < paramInt2))
    {
      char c1 = paramArrayOfChar[i1];
      if (d(c1))
        i2 = b((char)i2, c1);
    }
    return i2;
  }

  static int b(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i4;
    if (paramInt4 >= 0)
    {
      int i2 = paramInt1 + paramInt2;
      int i3 = 0;
      int i5;
      for (i4 = paramInt3; ; i4 = i5)
      {
        if ((i4 >= i2) || (i3 >= paramInt4))
        {
          if (i3 >= paramInt4)
            break;
          throw new IndexOutOfBoundsException();
        }
        i5 = i4 + 1;
        if ((c(paramArrayOfChar[i4])) && (i5 < i2) && (d(paramArrayOfChar[i5])))
          i5++;
        i3++;
      }
    }
    int i1 = paramInt3;
    while (true)
    {
      if ((i1 <= paramInt1) || (paramInt4 >= 0))
      {
        if (paramInt4 >= 0)
          break;
        throw new IndexOutOfBoundsException();
      }
      i1--;
      if ((d(paramArrayOfChar[i1])) && (i1 > paramInt1) && (c(paramArrayOfChar[(i1 - 1)])))
        i1--;
      paramInt4++;
    }
    i1 = i4;
    return i1;
  }

  public static String b(char paramChar)
  {
    return String.valueOf(paramChar);
  }

  static void b(int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    paramArrayOfChar[(paramInt2 + 1)] = f(paramInt1);
    paramArrayOfChar[paramInt2] = e(paramInt1);
  }

  public static boolean b(int paramInt)
  {
    return paramInt >>> 16 == 0;
  }

  public static int c(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= paramInt2) || (paramInt2 < 0) || (paramInt2 >= paramArrayOfChar.length))
      throw new IndexOutOfBoundsException();
    return d(paramArrayOfChar, paramInt1, paramInt2);
  }

  public static boolean c(char paramChar)
  {
    return (paramChar >= 55296) && (paramChar < 56320);
  }

  public static boolean c(int paramInt)
  {
    return (paramInt >= 65536) && (paramInt < 1114112);
  }

  public static int d(int paramInt)
  {
    if (paramInt >= 65536)
      return 2;
    return 1;
  }

  static int d(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i1 = paramInt1 - 1;
    int i2 = paramArrayOfChar[i1];
    if ((d((char)i2)) && (i1 > paramInt2))
    {
      char c1 = paramArrayOfChar[(i1 - 1)];
      if (c(c1))
        i2 = b(c1, (char)i2);
    }
    return i2;
  }

  public static boolean d(char paramChar)
  {
    return (paramChar >= 56320) && (paramChar < 57344);
  }

  public static char e(int paramInt)
  {
    return (char)(55232 + (paramInt >>> 10));
  }

  public static int e(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if ((paramInt2 > paramArrayOfChar.length - paramInt1) || (paramInt1 < 0) || (paramInt2 < 0))
      throw new IndexOutOfBoundsException();
    return f(paramArrayOfChar, paramInt1, paramInt2);
  }

  public static boolean e(char paramChar)
  {
    return (paramChar >= 55296) && (paramChar < 57344);
  }

  public static char f(int paramInt)
  {
    return (char)(56320 + (paramInt & 0x3FF));
  }

  static int f(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i1 = paramInt1 + paramInt2;
    while (true)
    {
      if (paramInt1 >= i1)
        return paramInt2;
      int i2 = paramInt1 + 1;
      if ((c(paramArrayOfChar[paramInt1])) && (i2 < i1) && (d(paramArrayOfChar[i2])))
      {
        paramInt2--;
        paramInt1 = i2 + 1;
        continue;
      }
      paramInt1 = i2;
    }
  }

  public static char[] g(int paramInt)
  {
    if (b(paramInt))
    {
      char[] arrayOfChar2 = new char[1];
      arrayOfChar2[0] = (char)paramInt;
      return arrayOfChar2;
    }
    if (a(paramInt))
    {
      char[] arrayOfChar1 = new char[2];
      b(paramInt, arrayOfChar1, 0);
      return arrayOfChar1;
    }
    throw new IllegalArgumentException();
  }

  public char a()
  {
    return this.am;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = paramObject instanceof a;
    int i1 = 0;
    if (bool)
    {
      int i2 = this.am;
      int i3 = ((a)paramObject).a();
      i1 = 0;
      if (i2 == i3)
        i1 = 1;
    }
    return i1;
  }

  public int hashCode()
  {
    return this.am;
  }

  public String toString()
  {
    char[] arrayOfChar = new char[1];
    arrayOfChar[0] = this.am;
    return String.valueOf(arrayOfChar);
  }

  private static class a
  {
    static final a[] a = new a[''];

    static
    {
      for (int i = 0; ; i++)
      {
        if (i >= a.length)
          return;
        a[i] = new a((char)i);
      }
    }
  }

  public static class b
  {
    private String a;

    protected b(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("name");
      this.a = paramString;
    }

    public final boolean equals(Object paramObject)
    {
      return this == paramObject;
    }

    public final int hashCode()
    {
      return super.hashCode();
    }

    public final String toString()
    {
      return this.a;
    }
  }

  public static final class c extends a.b
  {
    public static final c A;
    public static final c B;
    public static final c C;
    public static final c D;
    public static final c E;
    public static final c F;
    public static final c G;
    public static final c H;
    public static final c I;
    public static final c J;
    public static final c K;
    public static final c L;
    public static final c M;
    public static final c N;
    public static final c O;
    public static final c P;
    public static final c Q;
    public static final c R;
    public static final c S;
    public static final c T;
    public static final c U;
    public static final c V;
    public static final c W;
    public static final c X;
    public static final c Y;
    public static final c Z;
    public static final c a;
    public static final c aA;
    public static final c aB;
    public static final c aC;
    public static final c aD;
    public static final c aE;
    public static final c aF;
    public static final c aG;
    public static final c aH;
    public static final c aI;
    public static final c aJ;
    public static final c aK;
    public static final c aL;
    public static final c aM;
    public static final c aN;
    public static final c aO;
    public static final c aP;
    public static final c aQ;
    public static final c aR;
    public static final c aS;
    public static final c aT;
    public static final c aU;
    public static final c aV;
    public static final c aW;
    public static final c aX;
    public static final c aY;
    public static final c aZ;
    public static final c aa;
    public static final c ab;
    public static final c ac;
    public static final c ad;
    public static final c ae;
    public static final c af;
    public static final c ag;
    public static final c ah;
    public static final c ai;
    public static final c aj;
    public static final c ak;
    public static final c al;
    public static final c am;

    @Deprecated
    public static final c an;
    public static final c ao;
    public static final c ap;
    public static final c aq;
    public static final c ar;
    public static final c as;
    public static final c at;
    public static final c au;
    public static final c av;
    public static final c aw;
    public static final c ax;
    public static final c ay;
    public static final c az;
    public static final c b;
    public static final c bA;
    public static final c bB;
    public static final c bC;
    public static final c bD;
    public static final c bE;
    public static final c bF;
    public static final c bG;
    public static final c bH;
    public static final c bI;
    public static final c bJ;
    public static final c bK;
    public static final c bL;
    public static final c bM;
    public static final c bN;
    public static final c bO;
    public static final c bP;
    public static final c bQ;
    public static final c bR;
    public static final c bS;
    public static final c bT;
    public static final c bU;
    public static final c bV;
    public static final c bW;
    public static final c bX;
    public static final c bY;
    public static final c bZ;
    public static final c ba;
    public static final c bb;
    public static final c bc;
    public static final c bd;
    public static final c be;
    public static final c bf;
    public static final c bg;
    public static final c bh;
    public static final c bi;
    public static final c bj;
    public static final c bk;
    public static final c bl;
    public static final c bm;
    public static final c bn;
    public static final c bo;
    public static final c bp;
    public static final c bq;
    public static final c br;
    public static final c bs;
    public static final c bt;
    public static final c bu;
    public static final c bv;
    public static final c bw;
    public static final c bx;
    public static final c by;
    public static final c bz;
    public static final c c;
    public static final c cA;
    public static final c cB;
    public static final c cC;
    public static final c cD;
    public static final c cE;
    public static final c cF;
    public static final c cG;
    public static final c cH;
    public static final c cI;
    public static final c cJ;
    public static final c cK;
    public static final c cL;
    public static final c cM;
    public static final c cN;
    public static final c cO;
    public static final c cP;
    public static final c cQ;
    public static final c cR;
    public static final c cS;
    public static final c cT;
    public static final c cU;
    public static final c cV;
    public static final c cW;
    public static final c cX;
    public static final c cY;
    public static final c cZ;
    public static final c ca;
    public static final c cb;
    public static final c cc;
    public static final c cd;
    public static final c ce;
    public static final c cf;
    public static final c cg;
    public static final c ch;
    public static final c ci;
    public static final c cj;
    public static final c ck;
    public static final c cl;
    public static final c cm;
    public static final c cn;
    public static final c co;
    public static final c cp;
    public static final c cq;
    public static final c cr;
    public static final c cs;
    public static final c ct;
    public static final c cu;
    public static final c cv;
    public static final c cw;
    public static final c cx;
    public static final c cy;
    public static final c cz;
    public static final c d;
    public static final c da;
    public static final c db;
    private static Map<String, c> dc = new HashMap(256);
    private static final int[] dd;
    private static final c[] de;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final c h;
    public static final c i;
    public static final c j;
    public static final c k;
    public static final c l;
    public static final c m;
    public static final c n;
    public static final c o;
    public static final c p;
    public static final c q;
    public static final c r;
    public static final c s;
    public static final c t;
    public static final c u;
    public static final c v;
    public static final c w;
    public static final c x;
    public static final c y;
    public static final c z;

    static
    {
      a = new c("BASIC_LATIN", new String[] { "BASIC LATIN", "BASICLATIN" });
      b = new c("LATIN_1_SUPPLEMENT", new String[] { "LATIN-1 SUPPLEMENT", "LATIN-1SUPPLEMENT" });
      c = new c("LATIN_EXTENDED_A", new String[] { "LATIN EXTENDED-A", "LATINEXTENDED-A" });
      d = new c("LATIN_EXTENDED_B", new String[] { "LATIN EXTENDED-B", "LATINEXTENDED-B" });
      e = new c("IPA_EXTENSIONS", new String[] { "IPA EXTENSIONS", "IPAEXTENSIONS" });
      f = new c("SPACING_MODIFIER_LETTERS", new String[] { "SPACING MODIFIER LETTERS", "SPACINGMODIFIERLETTERS" });
      g = new c("COMBINING_DIACRITICAL_MARKS", new String[] { "COMBINING DIACRITICAL MARKS", "COMBININGDIACRITICALMARKS" });
      h = new c("GREEK", new String[] { "GREEK AND COPTIC", "GREEKANDCOPTIC" });
      i = new c("CYRILLIC");
      j = new c("ARMENIAN");
      k = new c("HEBREW");
      l = new c("ARABIC");
      m = new c("DEVANAGARI");
      n = new c("BENGALI");
      o = new c("GURMUKHI");
      p = new c("GUJARATI");
      q = new c("ORIYA");
      r = new c("TAMIL");
      s = new c("TELUGU");
      t = new c("KANNADA");
      u = new c("MALAYALAM");
      v = new c("THAI");
      w = new c("LAO");
      x = new c("TIBETAN");
      y = new c("GEORGIAN");
      z = new c("HANGUL_JAMO", new String[] { "HANGUL JAMO", "HANGULJAMO" });
      A = new c("LATIN_EXTENDED_ADDITIONAL", new String[] { "LATIN EXTENDED ADDITIONAL", "LATINEXTENDEDADDITIONAL" });
      B = new c("GREEK_EXTENDED", new String[] { "GREEK EXTENDED", "GREEKEXTENDED" });
      C = new c("GENERAL_PUNCTUATION", new String[] { "GENERAL PUNCTUATION", "GENERALPUNCTUATION" });
      D = new c("SUPERSCRIPTS_AND_SUBSCRIPTS", new String[] { "SUPERSCRIPTS AND SUBSCRIPTS", "SUPERSCRIPTSANDSUBSCRIPTS" });
      E = new c("CURRENCY_SYMBOLS", new String[] { "CURRENCY SYMBOLS", "CURRENCYSYMBOLS" });
      F = new c("COMBINING_MARKS_FOR_SYMBOLS", new String[] { "COMBINING DIACRITICAL MARKS FOR SYMBOLS", "COMBININGDIACRITICALMARKSFORSYMBOLS", "COMBINING MARKS FOR SYMBOLS", "COMBININGMARKSFORSYMBOLS" });
      G = new c("LETTERLIKE_SYMBOLS", new String[] { "LETTERLIKE SYMBOLS", "LETTERLIKESYMBOLS" });
      H = new c("NUMBER_FORMS", new String[] { "NUMBER FORMS", "NUMBERFORMS" });
      I = new c("ARROWS");
      J = new c("MATHEMATICAL_OPERATORS", new String[] { "MATHEMATICAL OPERATORS", "MATHEMATICALOPERATORS" });
      K = new c("MISCELLANEOUS_TECHNICAL", new String[] { "MISCELLANEOUS TECHNICAL", "MISCELLANEOUSTECHNICAL" });
      L = new c("CONTROL_PICTURES", new String[] { "CONTROL PICTURES", "CONTROLPICTURES" });
      M = new c("OPTICAL_CHARACTER_RECOGNITION", new String[] { "OPTICAL CHARACTER RECOGNITION", "OPTICALCHARACTERRECOGNITION" });
      N = new c("ENCLOSED_ALPHANUMERICS", new String[] { "ENCLOSED ALPHANUMERICS", "ENCLOSEDALPHANUMERICS" });
      O = new c("BOX_DRAWING", new String[] { "BOX DRAWING", "BOXDRAWING" });
      P = new c("BLOCK_ELEMENTS", new String[] { "BLOCK ELEMENTS", "BLOCKELEMENTS" });
      Q = new c("GEOMETRIC_SHAPES", new String[] { "GEOMETRIC SHAPES", "GEOMETRICSHAPES" });
      R = new c("MISCELLANEOUS_SYMBOLS", new String[] { "MISCELLANEOUS SYMBOLS", "MISCELLANEOUSSYMBOLS" });
      S = new c("DINGBATS");
      T = new c("CJK_SYMBOLS_AND_PUNCTUATION", new String[] { "CJK SYMBOLS AND PUNCTUATION", "CJKSYMBOLSANDPUNCTUATION" });
      U = new c("HIRAGANA");
      V = new c("KATAKANA");
      W = new c("BOPOMOFO");
      X = new c("HANGUL_COMPATIBILITY_JAMO", new String[] { "HANGUL COMPATIBILITY JAMO", "HANGULCOMPATIBILITYJAMO" });
      Y = new c("KANBUN");
      Z = new c("ENCLOSED_CJK_LETTERS_AND_MONTHS", new String[] { "ENCLOSED CJK LETTERS AND MONTHS", "ENCLOSEDCJKLETTERSANDMONTHS" });
      aa = new c("CJK_COMPATIBILITY", new String[] { "CJK COMPATIBILITY", "CJKCOMPATIBILITY" });
      ab = new c("CJK_UNIFIED_IDEOGRAPHS", new String[] { "CJK UNIFIED IDEOGRAPHS", "CJKUNIFIEDIDEOGRAPHS" });
      ac = new c("HANGUL_SYLLABLES", new String[] { "HANGUL SYLLABLES", "HANGULSYLLABLES" });
      ad = new c("PRIVATE_USE_AREA", new String[] { "PRIVATE USE AREA", "PRIVATEUSEAREA" });
      ae = new c("CJK_COMPATIBILITY_IDEOGRAPHS", new String[] { "CJK COMPATIBILITY IDEOGRAPHS", "CJKCOMPATIBILITYIDEOGRAPHS" });
      af = new c("ALPHABETIC_PRESENTATION_FORMS", new String[] { "ALPHABETIC PRESENTATION FORMS", "ALPHABETICPRESENTATIONFORMS" });
      ag = new c("ARABIC_PRESENTATION_FORMS_A", new String[] { "ARABIC PRESENTATION FORMS-A", "ARABICPRESENTATIONFORMS-A" });
      ah = new c("COMBINING_HALF_MARKS", new String[] { "COMBINING HALF MARKS", "COMBININGHALFMARKS" });
      ai = new c("CJK_COMPATIBILITY_FORMS", new String[] { "CJK COMPATIBILITY FORMS", "CJKCOMPATIBILITYFORMS" });
      aj = new c("SMALL_FORM_VARIANTS", new String[] { "SMALL FORM VARIANTS", "SMALLFORMVARIANTS" });
      ak = new c("ARABIC_PRESENTATION_FORMS_B", new String[] { "ARABIC PRESENTATION FORMS-B", "ARABICPRESENTATIONFORMS-B" });
      al = new c("HALFWIDTH_AND_FULLWIDTH_FORMS", new String[] { "HALFWIDTH AND FULLWIDTH FORMS", "HALFWIDTHANDFULLWIDTHFORMS" });
      am = new c("SPECIALS");
      an = new c("SURROGATES_AREA");
      ao = new c("SYRIAC");
      ap = new c("THAANA");
      aq = new c("SINHALA");
      ar = new c("MYANMAR");
      as = new c("ETHIOPIC");
      at = new c("CHEROKEE");
      au = new c("UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS", new String[] { "UNIFIED CANADIAN ABORIGINAL SYLLABICS", "UNIFIEDCANADIANABORIGINALSYLLABICS" });
      av = new c("OGHAM");
      aw = new c("RUNIC");
      ax = new c("KHMER");
      ay = new c("MONGOLIAN");
      az = new c("BRAILLE_PATTERNS", new String[] { "BRAILLE PATTERNS", "BRAILLEPATTERNS" });
      aA = new c("CJK_RADICALS_SUPPLEMENT", new String[] { "CJK RADICALS SUPPLEMENT", "CJKRADICALSSUPPLEMENT" });
      aB = new c("KANGXI_RADICALS", new String[] { "KANGXI RADICALS", "KANGXIRADICALS" });
      aC = new c("IDEOGRAPHIC_DESCRIPTION_CHARACTERS", new String[] { "IDEOGRAPHIC DESCRIPTION CHARACTERS", "IDEOGRAPHICDESCRIPTIONCHARACTERS" });
      aD = new c("BOPOMOFO_EXTENDED", new String[] { "BOPOMOFO EXTENDED", "BOPOMOFOEXTENDED" });
      aE = new c("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A", new String[] { "CJK UNIFIED IDEOGRAPHS EXTENSION A", "CJKUNIFIEDIDEOGRAPHSEXTENSIONA" });
      aF = new c("YI_SYLLABLES", new String[] { "YI SYLLABLES", "YISYLLABLES" });
      aG = new c("YI_RADICALS", new String[] { "YI RADICALS", "YIRADICALS" });
      aH = new c("CYRILLIC_SUPPLEMENTARY", new String[] { "CYRILLIC SUPPLEMENTARY", "CYRILLICSUPPLEMENTARY", "CYRILLIC SUPPLEMENT", "CYRILLICSUPPLEMENT" });
      aI = new c("TAGALOG");
      aJ = new c("HANUNOO");
      aK = new c("BUHID");
      aL = new c("TAGBANWA");
      aM = new c("LIMBU");
      aN = new c("TAI_LE", new String[] { "TAI LE", "TAILE" });
      aO = new c("KHMER_SYMBOLS", new String[] { "KHMER SYMBOLS", "KHMERSYMBOLS" });
      aP = new c("PHONETIC_EXTENSIONS", new String[] { "PHONETIC EXTENSIONS", "PHONETICEXTENSIONS" });
      aQ = new c("MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A", new String[] { "MISCELLANEOUS MATHEMATICAL SYMBOLS-A", "MISCELLANEOUSMATHEMATICALSYMBOLS-A" });
      aR = new c("SUPPLEMENTAL_ARROWS_A", new String[] { "SUPPLEMENTAL ARROWS-A", "SUPPLEMENTALARROWS-A" });
      aS = new c("SUPPLEMENTAL_ARROWS_B", new String[] { "SUPPLEMENTAL ARROWS-B", "SUPPLEMENTALARROWS-B" });
      aT = new c("MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B", new String[] { "MISCELLANEOUS MATHEMATICAL SYMBOLS-B", "MISCELLANEOUSMATHEMATICALSYMBOLS-B" });
      aU = new c("SUPPLEMENTAL_MATHEMATICAL_OPERATORS", new String[] { "SUPPLEMENTAL MATHEMATICAL OPERATORS", "SUPPLEMENTALMATHEMATICALOPERATORS" });
      aV = new c("MISCELLANEOUS_SYMBOLS_AND_ARROWS", new String[] { "MISCELLANEOUS SYMBOLS AND ARROWS", "MISCELLANEOUSSYMBOLSANDARROWS" });
      aW = new c("KATAKANA_PHONETIC_EXTENSIONS", new String[] { "KATAKANA PHONETIC EXTENSIONS", "KATAKANAPHONETICEXTENSIONS" });
      aX = new c("YIJING_HEXAGRAM_SYMBOLS", new String[] { "YIJING HEXAGRAM SYMBOLS", "YIJINGHEXAGRAMSYMBOLS" });
      aY = new c("VARIATION_SELECTORS", new String[] { "VARIATION SELECTORS", "VARIATIONSELECTORS" });
      aZ = new c("LINEAR_B_SYLLABARY", new String[] { "LINEAR B SYLLABARY", "LINEARBSYLLABARY" });
      ba = new c("LINEAR_B_IDEOGRAMS", new String[] { "LINEAR B IDEOGRAMS", "LINEARBIDEOGRAMS" });
      bb = new c("AEGEAN_NUMBERS", new String[] { "AEGEAN NUMBERS", "AEGEANNUMBERS" });
      bc = new c("OLD_ITALIC", new String[] { "OLD ITALIC", "OLDITALIC" });
      bd = new c("GOTHIC");
      be = new c("UGARITIC");
      bf = new c("DESERET");
      bg = new c("SHAVIAN");
      bh = new c("OSMANYA");
      bi = new c("CYPRIOT_SYLLABARY", new String[] { "CYPRIOT SYLLABARY", "CYPRIOTSYLLABARY" });
      bj = new c("BYZANTINE_MUSICAL_SYMBOLS", new String[] { "BYZANTINE MUSICAL SYMBOLS", "BYZANTINEMUSICALSYMBOLS" });
      bk = new c("MUSICAL_SYMBOLS", new String[] { "MUSICAL SYMBOLS", "MUSICALSYMBOLS" });
      bl = new c("TAI_XUAN_JING_SYMBOLS", new String[] { "TAI XUAN JING SYMBOLS", "TAIXUANJINGSYMBOLS" });
      bm = new c("MATHEMATICAL_ALPHANUMERIC_SYMBOLS", new String[] { "MATHEMATICAL ALPHANUMERIC SYMBOLS", "MATHEMATICALALPHANUMERICSYMBOLS" });
      bn = new c("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B", new String[] { "CJK UNIFIED IDEOGRAPHS EXTENSION B", "CJKUNIFIEDIDEOGRAPHSEXTENSIONB" });
      bo = new c("CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT", new String[] { "CJK COMPATIBILITY IDEOGRAPHS SUPPLEMENT", "CJKCOMPATIBILITYIDEOGRAPHSSUPPLEMENT" });
      bp = new c("TAGS");
      bq = new c("VARIATION_SELECTORS_SUPPLEMENT", new String[] { "VARIATION SELECTORS SUPPLEMENT", "VARIATIONSELECTORSSUPPLEMENT" });
      br = new c("SUPPLEMENTARY_PRIVATE_USE_AREA_A", new String[] { "SUPPLEMENTARY PRIVATE USE AREA-A", "SUPPLEMENTARYPRIVATEUSEAREA-A" });
      bs = new c("SUPPLEMENTARY_PRIVATE_USE_AREA_B", new String[] { "SUPPLEMENTARY PRIVATE USE AREA-B", "SUPPLEMENTARYPRIVATEUSEAREA-B" });
      bt = new c("HIGH_SURROGATES", new String[] { "HIGH SURROGATES", "HIGHSURROGATES" });
      bu = new c("HIGH_PRIVATE_USE_SURROGATES", new String[] { "HIGH PRIVATE USE SURROGATES", "HIGHPRIVATEUSESURROGATES" });
      bv = new c("LOW_SURROGATES", new String[] { "LOW SURROGATES", "LOWSURROGATES" });
      bw = new c("ARABIC_SUPPLEMENT", new String[] { "ARABIC SUPPLEMENT", "ARABICSUPPLEMENT" });
      bx = new c("NKO");
      by = new c("SAMARITAN");
      bz = new c("MANDAIC");
      bA = new c("ETHIOPIC_SUPPLEMENT", new String[] { "ETHIOPIC SUPPLEMENT", "ETHIOPICSUPPLEMENT" });
      bB = new c("UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED", new String[] { "UNIFIED CANADIAN ABORIGINAL SYLLABICS EXTENDED", "UNIFIEDCANADIANABORIGINALSYLLABICSEXTENDED" });
      bC = new c("NEW_TAI_LUE", new String[] { "NEW TAI LUE", "NEWTAILUE" });
      bD = new c("BUGINESE");
      bE = new c("TAI_THAM", new String[] { "TAI THAM", "TAITHAM" });
      bF = new c("BALINESE");
      bG = new c("SUNDANESE");
      bH = new c("BATAK");
      bI = new c("LEPCHA");
      bJ = new c("OL_CHIKI", new String[] { "OL CHIKI", "OLCHIKI" });
      bK = new c("VEDIC_EXTENSIONS", new String[] { "VEDIC EXTENSIONS", "VEDICEXTENSIONS" });
      bL = new c("PHONETIC_EXTENSIONS_SUPPLEMENT", new String[] { "PHONETIC EXTENSIONS SUPPLEMENT", "PHONETICEXTENSIONSSUPPLEMENT" });
      bM = new c("COMBINING_DIACRITICAL_MARKS_SUPPLEMENT", new String[] { "COMBINING DIACRITICAL MARKS SUPPLEMENT", "COMBININGDIACRITICALMARKSSUPPLEMENT" });
      bN = new c("GLAGOLITIC");
      bO = new c("LATIN_EXTENDED_C", new String[] { "LATIN EXTENDED-C", "LATINEXTENDED-C" });
      bP = new c("COPTIC");
      bQ = new c("GEORGIAN_SUPPLEMENT", new String[] { "GEORGIAN SUPPLEMENT", "GEORGIANSUPPLEMENT" });
      bR = new c("TIFINAGH");
      bS = new c("ETHIOPIC_EXTENDED", new String[] { "ETHIOPIC EXTENDED", "ETHIOPICEXTENDED" });
      bT = new c("CYRILLIC_EXTENDED_A", new String[] { "CYRILLIC EXTENDED-A", "CYRILLICEXTENDED-A" });
      bU = new c("SUPPLEMENTAL_PUNCTUATION", new String[] { "SUPPLEMENTAL PUNCTUATION", "SUPPLEMENTALPUNCTUATION" });
      bV = new c("CJK_STROKES", new String[] { "CJK STROKES", "CJKSTROKES" });
      bW = new c("LISU");
      bX = new c("VAI");
      bY = new c("CYRILLIC_EXTENDED_B", new String[] { "CYRILLIC EXTENDED-B", "CYRILLICEXTENDED-B" });
      bZ = new c("BAMUM");
      ca = new c("MODIFIER_TONE_LETTERS", new String[] { "MODIFIER TONE LETTERS", "MODIFIERTONELETTERS" });
      cb = new c("LATIN_EXTENDED_D", new String[] { "LATIN EXTENDED-D", "LATINEXTENDED-D" });
      cc = new c("SYLOTI_NAGRI", new String[] { "SYLOTI NAGRI", "SYLOTINAGRI" });
      cd = new c("COMMON_INDIC_NUMBER_FORMS", new String[] { "COMMON INDIC NUMBER FORMS", "COMMONINDICNUMBERFORMS" });
      ce = new c("PHAGS_PA", "PHAGS-PA");
      cf = new c("SAURASHTRA");
      cg = new c("DEVANAGARI_EXTENDED", new String[] { "DEVANAGARI EXTENDED", "DEVANAGARIEXTENDED" });
      ch = new c("KAYAH_LI", new String[] { "KAYAH LI", "KAYAHLI" });
      ci = new c("REJANG");
      cj = new c("HANGUL_JAMO_EXTENDED_A", new String[] { "HANGUL JAMO EXTENDED-A", "HANGULJAMOEXTENDED-A" });
      ck = new c("JAVANESE");
      cl = new c("CHAM");
      cm = new c("MYANMAR_EXTENDED_A", new String[] { "MYANMAR EXTENDED-A", "MYANMAREXTENDED-A" });
      cn = new c("TAI_VIET", new String[] { "TAI VIET", "TAIVIET" });
      co = new c("ETHIOPIC_EXTENDED_A", new String[] { "ETHIOPIC EXTENDED-A", "ETHIOPICEXTENDED-A" });
      cp = new c("MEETEI_MAYEK", new String[] { "MEETEI MAYEK", "MEETEIMAYEK" });
      cq = new c("HANGUL_JAMO_EXTENDED_B", new String[] { "HANGUL JAMO EXTENDED-B", "HANGULJAMOEXTENDED-B" });
      cr = new c("VERTICAL_FORMS", new String[] { "VERTICAL FORMS", "VERTICALFORMS" });
      cs = new c("ANCIENT_GREEK_NUMBERS", new String[] { "ANCIENT GREEK NUMBERS", "ANCIENTGREEKNUMBERS" });
      ct = new c("ANCIENT_SYMBOLS", new String[] { "ANCIENT SYMBOLS", "ANCIENTSYMBOLS" });
      cu = new c("PHAISTOS_DISC", new String[] { "PHAISTOS DISC", "PHAISTOSDISC" });
      cv = new c("LYCIAN");
      cw = new c("CARIAN");
      cx = new c("OLD_PERSIAN", new String[] { "OLD PERSIAN", "OLDPERSIAN" });
      cy = new c("IMPERIAL_ARAMAIC", new String[] { "IMPERIAL ARAMAIC", "IMPERIALARAMAIC" });
      cz = new c("PHOENICIAN");
      cA = new c("LYDIAN");
      cB = new c("KHAROSHTHI");
      cC = new c("OLD_SOUTH_ARABIAN", new String[] { "OLD SOUTH ARABIAN", "OLDSOUTHARABIAN" });
      cD = new c("AVESTAN");
      cE = new c("INSCRIPTIONAL_PARTHIAN", new String[] { "INSCRIPTIONAL PARTHIAN", "INSCRIPTIONALPARTHIAN" });
      cF = new c("INSCRIPTIONAL_PAHLAVI", new String[] { "INSCRIPTIONAL PAHLAVI", "INSCRIPTIONALPAHLAVI" });
      cG = new c("OLD_TURKIC", new String[] { "OLD TURKIC", "OLDTURKIC" });
      cH = new c("RUMI_NUMERAL_SYMBOLS", new String[] { "RUMI NUMERAL SYMBOLS", "RUMINUMERALSYMBOLS" });
      cI = new c("BRAHMI");
      cJ = new c("KAITHI");
      cK = new c("CUNEIFORM");
      cL = new c("CUNEIFORM_NUMBERS_AND_PUNCTUATION", new String[] { "CUNEIFORM NUMBERS AND PUNCTUATION", "CUNEIFORMNUMBERSANDPUNCTUATION" });
      cM = new c("EGYPTIAN_HIEROGLYPHS", new String[] { "EGYPTIAN HIEROGLYPHS", "EGYPTIANHIEROGLYPHS" });
      cN = new c("BAMUM_SUPPLEMENT", new String[] { "BAMUM SUPPLEMENT", "BAMUMSUPPLEMENT" });
      cO = new c("KANA_SUPPLEMENT", new String[] { "KANA SUPPLEMENT", "KANASUPPLEMENT" });
      cP = new c("ANCIENT_GREEK_MUSICAL_NOTATION", new String[] { "ANCIENT GREEK MUSICAL NOTATION", "ANCIENTGREEKMUSICALNOTATION" });
      cQ = new c("COUNTING_ROD_NUMERALS", new String[] { "COUNTING ROD NUMERALS", "COUNTINGRODNUMERALS" });
      cR = new c("MAHJONG_TILES", new String[] { "MAHJONG TILES", "MAHJONGTILES" });
      cS = new c("DOMINO_TILES", new String[] { "DOMINO TILES", "DOMINOTILES" });
      cT = new c("PLAYING_CARDS", new String[] { "PLAYING CARDS", "PLAYINGCARDS" });
      cU = new c("ENCLOSED_ALPHANUMERIC_SUPPLEMENT", new String[] { "ENCLOSED ALPHANUMERIC SUPPLEMENT", "ENCLOSEDALPHANUMERICSUPPLEMENT" });
      cV = new c("ENCLOSED_IDEOGRAPHIC_SUPPLEMENT", new String[] { "ENCLOSED IDEOGRAPHIC SUPPLEMENT", "ENCLOSEDIDEOGRAPHICSUPPLEMENT" });
      cW = new c("MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS", new String[] { "MISCELLANEOUS SYMBOLS AND PICTOGRAPHS", "MISCELLANEOUSSYMBOLSANDPICTOGRAPHS" });
      cX = new c("EMOTICONS");
      cY = new c("TRANSPORT_AND_MAP_SYMBOLS", new String[] { "TRANSPORT AND MAP SYMBOLS", "TRANSPORTANDMAPSYMBOLS" });
      cZ = new c("ALCHEMICAL_SYMBOLS", new String[] { "ALCHEMICAL SYMBOLS", "ALCHEMICALSYMBOLS" });
      da = new c("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C", new String[] { "CJK UNIFIED IDEOGRAPHS EXTENSION C", "CJKUNIFIEDIDEOGRAPHSEXTENSIONC" });
      db = new c("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D", new String[] { "CJK UNIFIED IDEOGRAPHS EXTENSION D", "CJKUNIFIEDIDEOGRAPHSEXTENSIOND" });
      int[] arrayOfInt = new int['ò'];
      arrayOfInt[1] = 128;
      arrayOfInt[2] = 256;
      arrayOfInt[3] = 384;
      arrayOfInt[4] = 592;
      arrayOfInt[5] = 688;
      arrayOfInt[6] = 768;
      arrayOfInt[7] = 880;
      arrayOfInt[8] = 1024;
      arrayOfInt[9] = 1280;
      arrayOfInt[10] = 1328;
      arrayOfInt[11] = 1424;
      arrayOfInt[12] = 1536;
      arrayOfInt[13] = 1792;
      arrayOfInt[14] = 1872;
      arrayOfInt[15] = 1920;
      arrayOfInt[16] = 1984;
      arrayOfInt[17] = 2048;
      arrayOfInt[18] = 2112;
      arrayOfInt[19] = 2144;
      arrayOfInt[20] = 2304;
      arrayOfInt[21] = 2432;
      arrayOfInt[22] = 2560;
      arrayOfInt[23] = 2688;
      arrayOfInt[24] = 2816;
      arrayOfInt[25] = 2944;
      arrayOfInt[26] = 3072;
      arrayOfInt[27] = 3200;
      arrayOfInt[28] = 3328;
      arrayOfInt[29] = 3456;
      arrayOfInt[30] = 3584;
      arrayOfInt[31] = 3712;
      arrayOfInt[32] = 3840;
      arrayOfInt[33] = 4096;
      arrayOfInt[34] = 4256;
      arrayOfInt[35] = 4352;
      arrayOfInt[36] = 4608;
      arrayOfInt[37] = 4992;
      arrayOfInt[38] = 5024;
      arrayOfInt[39] = 5120;
      arrayOfInt[40] = 5760;
      arrayOfInt[41] = 5792;
      arrayOfInt[42] = 5888;
      arrayOfInt[43] = 5920;
      arrayOfInt[44] = 5952;
      arrayOfInt[45] = 5984;
      arrayOfInt[46] = 6016;
      arrayOfInt[47] = 6144;
      arrayOfInt[48] = 6320;
      arrayOfInt[49] = 6400;
      arrayOfInt[50] = 6480;
      arrayOfInt[51] = 6528;
      arrayOfInt[52] = 6624;
      arrayOfInt[53] = 6656;
      arrayOfInt[54] = 6688;
      arrayOfInt[55] = 6832;
      arrayOfInt[56] = 6912;
      arrayOfInt[57] = 7040;
      arrayOfInt[58] = 7104;
      arrayOfInt[59] = 7168;
      arrayOfInt[60] = 7248;
      arrayOfInt[61] = 7296;
      arrayOfInt[62] = 7376;
      arrayOfInt[63] = 7424;
      arrayOfInt[64] = 7552;
      arrayOfInt[65] = 7616;
      arrayOfInt[66] = 7680;
      arrayOfInt[67] = 7936;
      arrayOfInt[68] = 8192;
      arrayOfInt[69] = 8304;
      arrayOfInt[70] = 8352;
      arrayOfInt[71] = 8400;
      arrayOfInt[72] = 8448;
      arrayOfInt[73] = 8528;
      arrayOfInt[74] = 8592;
      arrayOfInt[75] = 8704;
      arrayOfInt[76] = 8960;
      arrayOfInt[77] = 9216;
      arrayOfInt[78] = 9280;
      arrayOfInt[79] = 9312;
      arrayOfInt[80] = 9472;
      arrayOfInt[81] = 9600;
      arrayOfInt[82] = 9632;
      arrayOfInt[83] = 9728;
      arrayOfInt[84] = 9984;
      arrayOfInt[85] = 10176;
      arrayOfInt[86] = 10224;
      arrayOfInt[87] = 10240;
      arrayOfInt[88] = 10496;
      arrayOfInt[89] = 10624;
      arrayOfInt[90] = 10752;
      arrayOfInt[91] = 11008;
      arrayOfInt[92] = 11264;
      arrayOfInt[93] = 11360;
      arrayOfInt[94] = 11392;
      arrayOfInt[95] = 11520;
      arrayOfInt[96] = 11568;
      arrayOfInt[97] = 11648;
      arrayOfInt[98] = 11744;
      arrayOfInt[99] = 11776;
      arrayOfInt[100] = 11904;
      arrayOfInt[101] = 12032;
      arrayOfInt[102] = 12256;
      arrayOfInt[103] = 12272;
      arrayOfInt[104] = 12288;
      arrayOfInt[105] = 12352;
      arrayOfInt[106] = 12448;
      arrayOfInt[107] = 12544;
      arrayOfInt[108] = 12592;
      arrayOfInt[109] = 12688;
      arrayOfInt[110] = 12704;
      arrayOfInt[111] = 12736;
      arrayOfInt[112] = 12784;
      arrayOfInt[113] = 12800;
      arrayOfInt[114] = 13056;
      arrayOfInt[115] = 13312;
      arrayOfInt[116] = 19904;
      arrayOfInt[117] = 19968;
      arrayOfInt[118] = 40960;
      arrayOfInt[119] = 42128;
      arrayOfInt[120] = 42192;
      arrayOfInt[121] = 42240;
      arrayOfInt[122] = 42560;
      arrayOfInt[123] = 42656;
      arrayOfInt[124] = 42752;
      arrayOfInt[125] = 42784;
      arrayOfInt[126] = 43008;
      arrayOfInt[127] = 43056;
      arrayOfInt[''] = 43072;
      arrayOfInt[''] = 43136;
      arrayOfInt[''] = 43232;
      arrayOfInt[''] = 43264;
      arrayOfInt[''] = 43312;
      arrayOfInt[''] = 43360;
      arrayOfInt[''] = 43392;
      arrayOfInt[''] = 43488;
      arrayOfInt[''] = 43520;
      arrayOfInt[''] = 43616;
      arrayOfInt[''] = 43648;
      arrayOfInt[''] = 43744;
      arrayOfInt[''] = 43776;
      arrayOfInt[''] = 43824;
      arrayOfInt[''] = 43968;
      arrayOfInt[''] = 44032;
      arrayOfInt[''] = 55216;
      arrayOfInt[''] = 55296;
      arrayOfInt[''] = 56192;
      arrayOfInt[''] = 56320;
      arrayOfInt[''] = 57344;
      arrayOfInt[''] = 63744;
      arrayOfInt[''] = 64256;
      arrayOfInt[''] = 64336;
      arrayOfInt[''] = 65024;
      arrayOfInt[''] = 65040;
      arrayOfInt[''] = 65056;
      arrayOfInt[''] = 65072;
      arrayOfInt[''] = 65104;
      arrayOfInt[''] = 65136;
      arrayOfInt[''] = 65280;
      arrayOfInt[''] = 65520;
      arrayOfInt[' '] = 65536;
      arrayOfInt['¡'] = 65664;
      arrayOfInt['¢'] = 65792;
      arrayOfInt['£'] = 65856;
      arrayOfInt['¤'] = 65936;
      arrayOfInt['¥'] = 66000;
      arrayOfInt['¦'] = 66048;
      arrayOfInt['§'] = 66176;
      arrayOfInt['¨'] = 66208;
      arrayOfInt['©'] = 66272;
      arrayOfInt['ª'] = 66304;
      arrayOfInt['«'] = 66352;
      arrayOfInt['¬'] = 66384;
      arrayOfInt['­'] = 66432;
      arrayOfInt['®'] = 66464;
      arrayOfInt['¯'] = 66528;
      arrayOfInt['°'] = 66560;
      arrayOfInt['±'] = 66640;
      arrayOfInt['²'] = 66688;
      arrayOfInt['³'] = 66736;
      arrayOfInt['´'] = 67584;
      arrayOfInt['µ'] = 67648;
      arrayOfInt['¶'] = 67680;
      arrayOfInt['·'] = 67840;
      arrayOfInt['¸'] = 67872;
      arrayOfInt['¹'] = 67904;
      arrayOfInt['º'] = 68096;
      arrayOfInt['»'] = 68192;
      arrayOfInt['¼'] = 68224;
      arrayOfInt['½'] = 68352;
      arrayOfInt['¾'] = 68416;
      arrayOfInt['¿'] = 68448;
      arrayOfInt['À'] = 68480;
      arrayOfInt['Á'] = 68608;
      arrayOfInt['Â'] = 68688;
      arrayOfInt['Ã'] = 69216;
      arrayOfInt['Ä'] = 69248;
      arrayOfInt['Å'] = 69632;
      arrayOfInt['Æ'] = 69760;
      arrayOfInt['Ç'] = 69840;
      arrayOfInt['È'] = 73728;
      arrayOfInt['É'] = 74752;
      arrayOfInt['Ê'] = 74880;
      arrayOfInt['Ë'] = 77824;
      arrayOfInt['Ì'] = 78896;
      arrayOfInt['Í'] = 92160;
      arrayOfInt['Î'] = 92736;
      arrayOfInt['Ï'] = 110592;
      arrayOfInt['Ð'] = 110848;
      arrayOfInt['Ñ'] = 118784;
      arrayOfInt['Ò'] = 119040;
      arrayOfInt['Ó'] = 119296;
      arrayOfInt['Ô'] = 119376;
      arrayOfInt['Õ'] = 119552;
      arrayOfInt['Ö'] = 119648;
      arrayOfInt['×'] = 119680;
      arrayOfInt['Ø'] = 119808;
      arrayOfInt['Ù'] = 120832;
      arrayOfInt['Ú'] = 126976;
      arrayOfInt['Û'] = 127024;
      arrayOfInt['Ü'] = 127136;
      arrayOfInt['Ý'] = 127232;
      arrayOfInt['Þ'] = 127488;
      arrayOfInt['ß'] = 127744;
      arrayOfInt['à'] = 128512;
      arrayOfInt['á'] = 128592;
      arrayOfInt['â'] = 128640;
      arrayOfInt['ã'] = 128768;
      arrayOfInt['ä'] = 128896;
      arrayOfInt['å'] = 131072;
      arrayOfInt['æ'] = 173792;
      arrayOfInt['ç'] = 173824;
      arrayOfInt['è'] = 177984;
      arrayOfInt['é'] = 178208;
      arrayOfInt['ê'] = 194560;
      arrayOfInt['ë'] = 195104;
      arrayOfInt['ì'] = 917504;
      arrayOfInt['í'] = 917632;
      arrayOfInt['î'] = 917760;
      arrayOfInt['ï'] = 918000;
      arrayOfInt['ð'] = 983040;
      arrayOfInt['ñ'] = 1048576;
      dd = arrayOfInt;
      c[] arrayOfc = new c['ò'];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
      arrayOfc[2] = c;
      arrayOfc[3] = d;
      arrayOfc[4] = e;
      arrayOfc[5] = f;
      arrayOfc[6] = g;
      arrayOfc[7] = h;
      arrayOfc[8] = i;
      arrayOfc[9] = aH;
      arrayOfc[10] = j;
      arrayOfc[11] = k;
      arrayOfc[12] = l;
      arrayOfc[13] = ao;
      arrayOfc[14] = bw;
      arrayOfc[15] = ap;
      arrayOfc[16] = bx;
      arrayOfc[17] = by;
      arrayOfc[18] = bz;
      arrayOfc[20] = m;
      arrayOfc[21] = n;
      arrayOfc[22] = o;
      arrayOfc[23] = p;
      arrayOfc[24] = q;
      arrayOfc[25] = r;
      arrayOfc[26] = s;
      arrayOfc[27] = t;
      arrayOfc[28] = u;
      arrayOfc[29] = aq;
      arrayOfc[30] = v;
      arrayOfc[31] = w;
      arrayOfc[32] = x;
      arrayOfc[33] = ar;
      arrayOfc[34] = y;
      arrayOfc[35] = z;
      arrayOfc[36] = as;
      arrayOfc[37] = bA;
      arrayOfc[38] = at;
      arrayOfc[39] = au;
      arrayOfc[40] = av;
      arrayOfc[41] = aw;
      arrayOfc[42] = aI;
      arrayOfc[43] = aJ;
      arrayOfc[44] = aK;
      arrayOfc[45] = aL;
      arrayOfc[46] = ax;
      arrayOfc[47] = ay;
      arrayOfc[48] = bB;
      arrayOfc[49] = aM;
      arrayOfc[50] = aN;
      arrayOfc[51] = bC;
      arrayOfc[52] = aO;
      arrayOfc[53] = bD;
      arrayOfc[54] = bE;
      arrayOfc[56] = bF;
      arrayOfc[57] = bG;
      arrayOfc[58] = bH;
      arrayOfc[59] = bI;
      arrayOfc[60] = bJ;
      arrayOfc[62] = bK;
      arrayOfc[63] = aP;
      arrayOfc[64] = bL;
      arrayOfc[65] = bM;
      arrayOfc[66] = A;
      arrayOfc[67] = B;
      arrayOfc[68] = C;
      arrayOfc[69] = D;
      arrayOfc[70] = E;
      arrayOfc[71] = F;
      arrayOfc[72] = G;
      arrayOfc[73] = H;
      arrayOfc[74] = I;
      arrayOfc[75] = J;
      arrayOfc[76] = K;
      arrayOfc[77] = L;
      arrayOfc[78] = M;
      arrayOfc[79] = N;
      arrayOfc[80] = O;
      arrayOfc[81] = P;
      arrayOfc[82] = Q;
      arrayOfc[83] = R;
      arrayOfc[84] = S;
      arrayOfc[85] = aQ;
      arrayOfc[86] = aR;
      arrayOfc[87] = az;
      arrayOfc[88] = aS;
      arrayOfc[89] = aT;
      arrayOfc[90] = aU;
      arrayOfc[91] = aV;
      arrayOfc[92] = bN;
      arrayOfc[93] = bO;
      arrayOfc[94] = bP;
      arrayOfc[95] = bQ;
      arrayOfc[96] = bR;
      arrayOfc[97] = bS;
      arrayOfc[98] = bT;
      arrayOfc[99] = bU;
      arrayOfc[100] = aA;
      arrayOfc[101] = aB;
      arrayOfc[103] = aC;
      arrayOfc[104] = T;
      arrayOfc[105] = U;
      arrayOfc[106] = V;
      arrayOfc[107] = W;
      arrayOfc[108] = X;
      arrayOfc[109] = Y;
      arrayOfc[110] = aD;
      arrayOfc[111] = bV;
      arrayOfc[112] = aW;
      arrayOfc[113] = Z;
      arrayOfc[114] = aa;
      arrayOfc[115] = aE;
      arrayOfc[116] = aX;
      arrayOfc[117] = ab;
      arrayOfc[118] = aF;
      arrayOfc[119] = aG;
      arrayOfc[120] = bW;
      arrayOfc[121] = bX;
      arrayOfc[122] = bY;
      arrayOfc[123] = bZ;
      arrayOfc[124] = ca;
      arrayOfc[125] = cb;
      arrayOfc[126] = cc;
      arrayOfc[127] = cd;
      arrayOfc[''] = ce;
      arrayOfc[''] = cf;
      arrayOfc[''] = cg;
      arrayOfc[''] = ch;
      arrayOfc[''] = ci;
      arrayOfc[''] = cj;
      arrayOfc[''] = ck;
      arrayOfc[''] = cl;
      arrayOfc[''] = cm;
      arrayOfc[''] = cn;
      arrayOfc[''] = co;
      arrayOfc[''] = cp;
      arrayOfc[''] = ac;
      arrayOfc[''] = cq;
      arrayOfc[''] = bt;
      arrayOfc[''] = bu;
      arrayOfc[''] = bv;
      arrayOfc[''] = ad;
      arrayOfc[''] = ae;
      arrayOfc[''] = af;
      arrayOfc[''] = ag;
      arrayOfc[''] = aY;
      arrayOfc[''] = cr;
      arrayOfc[''] = ah;
      arrayOfc[''] = ai;
      arrayOfc[''] = aj;
      arrayOfc[''] = ak;
      arrayOfc[''] = al;
      arrayOfc[''] = am;
      arrayOfc[' '] = aZ;
      arrayOfc['¡'] = ba;
      arrayOfc['¢'] = bb;
      arrayOfc['£'] = cs;
      arrayOfc['¤'] = ct;
      arrayOfc['¥'] = cu;
      arrayOfc['§'] = cv;
      arrayOfc['¨'] = cw;
      arrayOfc['ª'] = bc;
      arrayOfc['«'] = bd;
      arrayOfc['­'] = be;
      arrayOfc['®'] = cx;
      arrayOfc['°'] = bf;
      arrayOfc['±'] = bg;
      arrayOfc['²'] = bh;
      arrayOfc['´'] = bi;
      arrayOfc['µ'] = cy;
      arrayOfc['·'] = cz;
      arrayOfc['¸'] = cA;
      arrayOfc['º'] = cB;
      arrayOfc['»'] = cC;
      arrayOfc['½'] = cD;
      arrayOfc['¾'] = cE;
      arrayOfc['¿'] = cF;
      arrayOfc['Á'] = cG;
      arrayOfc['Ã'] = cH;
      arrayOfc['Å'] = cI;
      arrayOfc['Æ'] = cJ;
      arrayOfc['È'] = cK;
      arrayOfc['É'] = cL;
      arrayOfc['Ë'] = cM;
      arrayOfc['Í'] = cN;
      arrayOfc['Ï'] = cO;
      arrayOfc['Ñ'] = bj;
      arrayOfc['Ò'] = bk;
      arrayOfc['Ó'] = cP;
      arrayOfc['Õ'] = bl;
      arrayOfc['Ö'] = cQ;
      arrayOfc['Ø'] = bm;
      arrayOfc['Ú'] = cR;
      arrayOfc['Û'] = cS;
      arrayOfc['Ü'] = cT;
      arrayOfc['Ý'] = cU;
      arrayOfc['Þ'] = cV;
      arrayOfc['ß'] = cW;
      arrayOfc['à'] = cX;
      arrayOfc['â'] = cY;
      arrayOfc['ã'] = cZ;
      arrayOfc['å'] = bn;
      arrayOfc['ç'] = da;
      arrayOfc['è'] = db;
      arrayOfc['ê'] = bo;
      arrayOfc['ì'] = bp;
      arrayOfc['î'] = bq;
      arrayOfc['ð'] = br;
      arrayOfc['ñ'] = bs;
      de = arrayOfc;
    }

    private c(String paramString)
    {
      super();
      dc.put(paramString, this);
    }

    private c(String paramString1, String paramString2)
    {
      this(paramString1);
      dc.put(paramString2, this);
    }

    private c(String paramString, String[] paramArrayOfString)
    {
      this(paramString);
      int i1 = paramArrayOfString.length;
      for (int i2 = 0; ; i2++)
      {
        if (i2 >= i1)
          return;
        String str = paramArrayOfString[i2];
        dc.put(str, this);
      }
    }

    public static c a(char paramChar)
    {
      return a(paramChar);
    }

    public static c a(int paramInt)
    {
      if (!a.a(paramInt))
        throw new IllegalArgumentException();
      int i1 = 0;
      int i2 = dd.length;
      int i3 = i2 / 2;
      if (i2 - i1 <= 1)
        return de[i3];
      int i5;
      if (paramInt >= dd[i3])
        i5 = i2;
      while (true)
      {
        int i6 = (i5 + i3) / 2;
        i2 = i5;
        i1 = i3;
        i3 = i6;
        break;
        int i4 = i1;
        i5 = i3;
        i3 = i4;
      }
    }

    public static final c a(String paramString)
    {
      c localc = (c)dc.get(paramString.toUpperCase(Locale.US));
      if (localc == null)
        throw new IllegalArgumentException();
      return localc;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.b.a
 * JD-Core Version:    0.6.0
 */