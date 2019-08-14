package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.b.a.c;
import com.himamis.retex.renderer.a.g.c.b;
import java.util.Map;

public class bz
{
  private static final com.himamis.retex.renderer.a.g.d a = new com.himamis.retex.renderer.a.g.d();

  static
  {
    bn.a("array", "\\array@@env{#1}{", "}", 1);
    bn.a("tabular", "\\array@@env{#1}{", "}", 1);
    bn.a("matrix", "\\matrix@@env{", "}", 0);
    bn.a("smallmatrix", "\\smallmatrix@@env{", "}", 0);
    bn.a("pmatrix", "\\left(\\begin{matrix}", "\\end{matrix}\\right)", 0);
    bn.a("bmatrix", "\\left[\\begin{matrix}", "\\end{matrix}\\right]", 0);
    bn.a("Bmatrix", "\\left\\{\\begin{matrix}", "\\end{matrix}\\right\\}", 0);
    bn.a("vmatrix", "\\left|\\begin{matrix}", "\\end{matrix}\\right|", 0);
    bn.a("Vmatrix", "\\left\\|\\begin{matrix}", "\\end{matrix}\\right\\|", 0);
    bn.a("eqnarray", "\\begin{array}{rcl}", "\\end{array}", 0);
    bn.a("align", "\\align@@env{", "}", 0);
    bn.a("flalign", "\\flalign@@env{", "}", 0);
    bn.a("alignat", "\\alignat@@env{#1}{", "}", 1);
    bn.a("aligned", "\\aligned@@env{", "}", 0);
    bn.a("alignedat", "\\alignedat@@env{#1}{", "}", 1);
    bn.a("multline", "\\multline@@env{", "}", 0);
    bn.a("cases", "\\left\\{\\begin{array}{l@{\\!}l}", "\\end{array}\\right.", 0);
    bn.a("split", "\\begin{array}{rl}", "\\end{array}", 0);
    bn.a("gather", "\\gather@@env{", "}", 0);
    bn.a("gathered", "\\gathered@@env{", "}", 0);
    bn.a("math", "\\(", "\\)", 0);
    bn.a("displaymath", "\\[", "\\]", 0);
    bm.a("operatorname", "\\mathop{\\mathrm{#1}}\\nolimits ", 1);
    bm.a("DeclareMathOperator", "\\newcommand{#1}{\\mathop{\\mathrm{#2}}\\nolimits}", 2);
    bm.a("substack", "{\\scriptstyle\\begin{array}{c}#1\\end{array}}", 1);
    bm.a("dfrac", "\\genfrac{}{}{}{}{#1}{#2}", 2);
    bm.a("tfrac", "\\genfrac{}{}{}{1}{#1}{#2}", 2);
    bm.a("dbinom", "\\genfrac{(}{)}{0pt}{}{#1}{#2}", 2);
    bm.a("tbinom", "\\genfrac{(}{)}{0pt}{1}{#1}{#2}", 2);
    bm.a("pmod", "\\qquad\\mathbin{(\\mathrm{mod}\\ #1)}", 1);
    bm.a("mod", "\\qquad\\mathbin{\\mathrm{mod}\\ #1}", 1);
    bm.a("pod", "\\qquad\\mathbin{(#1)}", 1);
    bm.a("dddot", "\\mathop{#1}\\limits^{...}", 1);
    bm.a("ddddot", "\\mathop{#1}\\limits^{....}", 1);
    bm.a("spdddot", "^{\\mathrm{...}}", 0);
    bm.a("spbreve", "^{\\makeatletter\\sp@breve\\makeatother}", 0);
    bm.a("sphat", "^{\\makeatletter\\sp@hat\\makeatother}", 0);
    bm.a("spddot", "^{\\displaystyle..}", 0);
    bm.a("spcheck", "^{\\vee}", 0);
    bm.a("sptilde", "^{\\sim}", 0);
    bm.a("spdot", "^{\\displaystyle.}", 0);
    bm.a("d", "\\underaccent{\\dot}{#1}", 1);
    bm.a("b", "\\underaccent{\\bar}{#1}", 1);
    bm.a("Bra", "\\left\\langle{#1}\\right\\vert", 1);
    bm.a("Ket", "\\left\\vert{#1}\\right\\rangle", 1);
    bm.a("textsuperscript", "{}^{\\text{#1}}", 1);
    bm.a("textsubscript", "{}_{\\text{#1}}", 1);
    bm.a("textit", "\\mathit{\\text{#1}}", 1);
    bm.a("textbf", "\\mathbf{\\text{#1}}", 1);
    bm.a("textsf", "\\mathsf{\\text{#1}}", 1);
    bm.a("texttt", "\\mathtt{\\text{#1}}", 1);
    bm.a("textrm", "\\text{#1}", 1);
    bm.a("degree", "^\\circ", 0);
    bm.a("with", "\\mathbin{\\&}", 0);
    bm.a("parr", "\\mathbin{\\rotatebox[origin=c]{180}{\\&}}", 0);
    bm.a("copyright", "\\textcircled{\\raisebox{0.2ex}{c}}", 0);
    bm.a("L", "\\mathrm{\\polishlcross L}", 0);
    bm.a("l", "\\mathrm{\\polishlcross l}", 0);
    bm.a("Join", "\\mathop{\\rlap{\\ltimes}\\rtimes}", 0);
  }

  public static final d A(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ef();
  }

  public static final d B(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new a(new dr(paramdv, paramArrayOfString[1], false).u, paramArrayOfString[0]);
  }

  public static final d C(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new a(new dr(paramdv, paramArrayOfString[2], false).u, new dr(paramdv, paramArrayOfString[1], false).u, false);
  }

  public static final d D(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new a(new dr(paramdv, paramArrayOfString[2], false).u, new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d E(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    String str = "";
    switch (paramArrayOfString[0].charAt(0))
    {
    default:
    case '~':
    case '\'':
    case '^':
    case '"':
    case '`':
    case '=':
    case '.':
    case 'u':
    case 'v':
    case 'H':
    case 't':
    case 'r':
    case 'U':
    }
    while (true)
    {
      return new a(new dr(paramdv, paramArrayOfString[1], false).u, str);
      str = "tilde";
      continue;
      str = "acute";
      continue;
      str = "hat";
      continue;
      str = "ddot";
      continue;
      str = "grave";
      continue;
      str = "bar";
      continue;
      str = "dot";
      continue;
      str = "breve";
      continue;
      str = "check";
      continue;
      str = "doubleacute";
      continue;
      str = "tie";
      continue;
      str = "mathring";
      continue;
      str = "cyrbreve";
    }
  }

  public static final d F(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new l(new dr(paramdv, paramArrayOfString[1]).u);
  }

  public static final d G(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    int i = paramArrayOfString[0].charAt(0);
    boolean bool = false;
    if (i == 73)
      bool = true;
    return new av(bool);
  }

  public static final d H(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    int i = paramArrayOfString[0].charAt(0);
    boolean bool = false;
    if (i == 84)
      bool = true;
    return new dn(bool);
  }

  public static final d I(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    int i = paramArrayOfString[0].charAt(0);
    boolean bool = false;
    if (i == 76)
      bool = true;
    return new ba(bool);
  }

  public static final d J(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new eo();
  }

  public static final d K(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bp(new dr(paramdv, paramArrayOfString[1]).u);
  }

  public static final d L(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new cu();
  }

  public static final d M(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    if (paramArrayOfString[2] == null)
      return new bo(new dr(paramdv, paramArrayOfString[1], false).u, null);
    return new bo(new dr(paramdv, paramArrayOfString[1], false).u, new dr(paramdv, paramArrayOfString[2], false).u);
  }

  public static final d N(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ec(new dr(paramdv, paramArrayOfString[1], false).u, false, true);
  }

  public static final d O(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ec(new dr(paramdv, paramArrayOfString[1], false).u, true, true);
  }

  public static final d P(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ec(new dr(paramdv, paramArrayOfString[1], false).u, true);
  }

  public static final d Q(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ec(new dr(paramdv, paramArrayOfString[1], false).u, false, false);
  }

  public static final d R(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ec(new dr(paramdv, paramArrayOfString[1], false).u, true, false);
  }

  public static final d S(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ec(new dr(paramdv, paramArrayOfString[1], false).u, false);
  }

  public static final d T(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new em(new dr(paramdv, paramArrayOfString[1], false).u, new dr(paramdv, paramArrayOfString[2]).u, true);
  }

  public static final d U(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new em(new dr(paramdv, paramArrayOfString[1], false).u, new dr(paramdv, paramArrayOfString[2]).u, false);
  }

  public static final d V(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    dr localdr = new dr();
    localdr.a(new bx(new dr(paramdv, paramArrayOfString[3]).u, false, true, true));
    localdr.a(paramdv.a(), paramArrayOfString[1]);
    localdr.a(new cu(5, -0.3F, 0.0F, 0.0F));
    localdr.a(paramdv.a(), paramArrayOfString[3] + "\\nolimits" + paramArrayOfString[2]);
    return new ea(0, 0, localdr.u);
  }

  public static final d W(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[3]).u;
    paramdv.a(new cp(new bx(locald, false, true, true), new dr(paramdv, paramArrayOfString[2]).u, new dr(paramdv, paramArrayOfString[1]).u, false));
    paramdv.a(new cu(5, -0.3F, 0.0F, 0.0F));
    return new ea(0, 0, locald);
  }

  public static final d X(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bu(new dr(paramdv, paramArrayOfString[1], false).u, null, dm.b("rbrace"), 1, 0.0F, false);
  }

  public static final d Y(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bu(new dr(paramdv, paramArrayOfString[1], false).u, null, dm.b("lbrace"), 1, 0.0F, true);
  }

  public static final d Z(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bu(new dr(paramdv, paramArrayOfString[1], false).u, null, dm.b("rsqbrack"), 1, 0.0F, false);
  }

  public static final d a(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    int i = Integer.parseInt(paramArrayOfString[1]);
    if (i > 5)
    {
      int j = i / 5;
      int k = i % 5;
      cl localcl = new cl();
      for (int m = 0; ; m++)
      {
        if (m >= j)
        {
          localcl.a(new ad(k));
          return localcl;
        }
        localcl.a(new ad(5));
      }
    }
    return new ad(i);
  }

  public static final d aA(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return az(paramdv, paramArrayOfString);
  }

  public static final d aB(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    if (!paramdv.i())
      throw new com.himamis.retex.renderer.a.e.n("Bad environment for \\intertext command !");
    ch localch = new ch(new dr(paramdv, paramArrayOfString[1].replaceAll("\\^\\{\\\\prime\\}", "'").replaceAll("\\^\\{\\\\prime\\\\prime\\}", "''"), "mathnormal", false, false).u);
    localch.c = 11;
    paramdv.a(localch);
    paramdv.o();
    return null;
  }

  public static final d aC(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    c localc = new c();
    new dv(paramdv.a(), paramArrayOfString[1], localc, false).p();
    localc.f();
    return new bg(paramdv.a(), localc, 5);
  }

  public static final d aD(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    c localc = new c();
    new dv(paramdv.a(), paramArrayOfString[1], localc, false).p();
    localc.f();
    return new bg(paramdv.a(), localc, 1);
  }

  public static final d aE(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    int i = Integer.parseInt(paramArrayOfString[1]);
    paramdv.a(new bk(i, paramArrayOfString[2], new dr(paramdv, paramArrayOfString[3]).u));
    ((c)paramdv.a).a(i);
    return null;
  }

  public static final d aF(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    int i = Integer.parseInt(paramArrayOfString[1]);
    float f = 1.0F;
    if (paramArrayOfString[2] != null)
      f = Float.parseFloat(paramArrayOfString[2]);
    paramdv.a(new ar(i, f));
    ((c)paramdv.a).a(i);
    return null;
  }

  public static final d aG(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    c localc = new c();
    new dv(paramdv.a(), paramArrayOfString[2], localc, false).p();
    localc.f();
    return new bg(paramdv.a(), localc, paramArrayOfString[1], true);
  }

  public static final d aH(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    c localc = new c();
    new dv(paramdv.a(), paramArrayOfString[1], localc, false).p();
    localc.f();
    return new bg(paramdv.a(), localc, 2);
  }

  public static final d aI(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    c localc = new c();
    new dv(paramdv.a(), paramArrayOfString[1], localc, false).p();
    localc.f();
    return new bg(paramdv.a(), localc, 4);
  }

  public static final d aJ(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    c localc = new c();
    new dv(paramdv.a(), paramArrayOfString[2], localc, false).p();
    localc.f();
    int i = Integer.parseInt(paramArrayOfString[1]);
    if (localc.b != i * 2)
      throw new com.himamis.retex.renderer.a.e.n("Bad number of equations in alignat environment !");
    return new bg(paramdv.a(), localc, 3);
  }

  public static final d aK(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    c localc = new c();
    new dv(paramdv.a(), paramArrayOfString[1], localc, false).p();
    localc.f();
    return new bg(paramdv.a(), localc, 6);
  }

  public static final d aL(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    c localc = new c();
    new dv(paramdv.a(), paramArrayOfString[2], localc, false).p();
    localc.f();
    int i = Integer.parseInt(paramArrayOfString[1]);
    if (localc.b != i * 2)
      throw new com.himamis.retex.renderer.a.e.n("Bad number of equations in alignedat environment !");
    return new bg(paramdv.a(), localc, 7);
  }

  public static final d aM(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    c localc = new c();
    new dv(paramdv.a(), paramArrayOfString[1], localc, false).p();
    localc.f();
    if (localc.b > 1)
      throw new com.himamis.retex.renderer.a.e.n("Character '&' is only available in array mode !");
    if (localc.b == 0)
      return null;
    return new bl(paramdv.a(), localc, 0);
  }

  public static final d aN(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    c localc = new c();
    new dv(paramdv.a(), paramArrayOfString[1], localc, false).p();
    localc.f();
    if (localc.b > 1)
      throw new com.himamis.retex.renderer.a.e.n("Character '&' is only available in array mode !");
    if (localc.b == 0)
      return null;
    return new bl(paramdv.a(), localc, 1);
  }

  public static final d aO(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    c localc = new c();
    new dv(paramdv.a(), paramArrayOfString[1], localc, false).p();
    localc.f();
    if (localc.b > 1)
      throw new com.himamis.retex.renderer.a.e.n("Character '&' is only available in array mode !");
    if (localc.b == 0)
      return null;
    return new bl(paramdv.a(), localc, 2);
  }

  public static final d aP(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[1]).u;
    locald.e = 1;
    return locald;
  }

  public static final d aQ(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[1]).u;
    locald.e = 0;
    return locald;
  }

  public static final d aR(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    String str = paramArrayOfString[1];
    if (!paramdv.b(str))
      throw new com.himamis.retex.renderer.a.e.n("Invalid name for the command :" + str);
    if (paramArrayOfString[3] == null);
    for (Integer localInteger = new Integer(0); localInteger == null; localInteger = Integer.valueOf(Integer.parseInt(paramArrayOfString[3])))
      throw new com.himamis.retex.renderer.a.e.n("The optional argument should be an integer !");
    if (paramArrayOfString[4] == null)
      bm.a(str.substring(1), paramArrayOfString[2], localInteger.intValue());
    while (true)
    {
      return null;
      bm.a(str.substring(1), paramArrayOfString[2], localInteger.intValue(), paramArrayOfString[4]);
    }
  }

  public static final d aS(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    String str = paramArrayOfString[1];
    if (!paramdv.b(str))
      throw new com.himamis.retex.renderer.a.e.n("Invalid name for the command :" + str);
    if (paramArrayOfString[3] == null);
    for (Integer localInteger = new Integer(0); localInteger == null; localInteger = Integer.valueOf(Integer.parseInt(paramArrayOfString[3])))
      throw new com.himamis.retex.renderer.a.e.n("The optional argument should be an integer !");
    bm.b(str.substring(1), paramArrayOfString[2], localInteger.intValue());
    return null;
  }

  public static final d aT(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    paramdv.f();
    return null;
  }

  public static final d aU(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    paramdv.g();
    return null;
  }

  public static final d aV(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    if (paramArrayOfString[4] == null);
    Integer localInteger;
    for (int i = 0; ; i = Integer.parseInt(paramArrayOfString[4]))
    {
      localInteger = Integer.valueOf(i);
      if (localInteger != null)
        break;
      throw new com.himamis.retex.renderer.a.e.n("The optional argument should be an integer !");
    }
    bn.a(paramArrayOfString[1], paramArrayOfString[2], paramArrayOfString[3], localInteger.intValue());
    return null;
  }

  public static final d aW(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    if (paramArrayOfString[4] == null);
    Integer localInteger;
    for (int i = 0; ; i = Integer.parseInt(paramArrayOfString[4]))
    {
      localInteger = Integer.valueOf(i);
      if (localInteger != null)
        break;
      throw new com.himamis.retex.renderer.a.e.n("The optional argument should be an integer !");
    }
    bn.b(paramArrayOfString[1], paramArrayOfString[2], paramArrayOfString[3], localInteger.intValue());
    return null;
  }

  public static final d aX(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ac(new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d aY(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(3, 3, new ed(new dr(paramdv, paramArrayOfString[2], false).u, new dr(paramdv, paramArrayOfString[3], false).u, 5, 0.5F, true, new dr(paramdv, paramArrayOfString[1], false).u, 5, 2.5F, true));
  }

  public static final d aZ(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(2, 2, new ed(new dr(paramdv, paramArrayOfString[2], false).u, new dr(paramdv, paramArrayOfString[3], false).u, 5, 0.5F, true, new dr(paramdv, paramArrayOfString[1], false).u, 5, 2.5F, true));
  }

  public static final d aa(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bu(new dr(paramdv, paramArrayOfString[1], false).u, null, dm.b("lsqbrack"), 1, 0.0F, true);
  }

  public static final d ab(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bu(new dr(paramdv, paramArrayOfString[1], false).u, null, dm.b("rbrack"), 1, 0.0F, false);
  }

  public static final d ac(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bu(new dr(paramdv, paramArrayOfString[1], false).u, null, dm.b("lbrack"), 1, 0.0F, true);
  }

  public static final d ad(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bv(new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d ae(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ee(new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d af(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    ea localea = new ea(1, 1, new dr(paramdv, paramArrayOfString[1], false).u);
    localea.d = 0;
    return localea;
  }

  public static final d ag(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(6, 6, new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d ah(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(0, 0, new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d ai(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(3, 3, new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d aj(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(7, 7, new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d ak(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(2, 2, new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d al(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(4, 4, new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d am(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(5, 5, new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d an(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(3, 3, new cu(5, -2.6F, 0.0F, 0.0F));
  }

  public static final d ao(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ct(new dr(paramdv, paramArrayOfString[1], false).u, paramArrayOfString[2]);
  }

  public static final d ap(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ei();
  }

  public static final d aq(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(7, 7, new u());
  }

  public static final d ar(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(7, 7, new aw());
  }

  public static final d as(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = paramdv.d();
    locald.d = 1;
    return locald.c();
  }

  public static final d at(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = paramdv.d();
    locald.d = 2;
    return locald.c();
  }

  public static final d au(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = paramdv.d();
    locald.d = 0;
    return locald.c();
  }

  public static final d av(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    String str = paramdv.a("\\left", "\\right");
    d locald1 = new dr(paramdv, paramArrayOfString[1], false).u;
    if ((locald1 instanceof e));
    for (Object localObject1 = ((e)locald1).a; ; localObject1 = locald1)
    {
      d locald2 = paramdv.q();
      if ((locald2 instanceof e));
      for (Object localObject2 = ((e)locald2).a; ; localObject2 = locald2)
      {
        if (((localObject1 instanceof dm)) && ((localObject2 instanceof dm)))
        {
          dr localdr = new dr(paramdv, str, false);
          return new af(localdr.u, (dm)localObject1, localdr.s, (dm)localObject2);
        }
        cl localcl = new cl();
        localcl.a((d)localObject1);
        localcl.a(new dr(paramdv, str, false).u);
        localcl.a((d)localObject2);
        return localcl;
      }
    }
  }

  public static final d aw(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bf(new dr(paramdv, paramdv.a("\\(", "\\)"), false).u, 2);
  }

  public static final d ax(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bf(new dr(paramdv, paramdv.a("\\[", "\\]"), false).u, 0);
  }

  public static final d ay(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bi(new dr(paramdv, paramArrayOfString[1]).u);
  }

  public static final d az(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    if (paramdv.i())
      paramdv.o();
    while (true)
    {
      return null;
      c localc = new c();
      localc.a(paramdv.a.u);
      localc.b();
      new dv(paramdv.a(), paramdv.m(), localc, false, paramdv.j()).p();
      localc.f();
      paramdv.n();
      paramdv.a.u = localc.e();
    }
  }

  public static final d b(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new dj(new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d bA(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[1], false).u;
    if (!(locald instanceof dm))
      return locald;
    e locale = new e((dm)locald, 2);
    locale.c = 4;
    return locale;
  }

  public static final d bB(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[1], false).u;
    if (!(locald instanceof dm))
      return locald;
    e locale = new e((dm)locald, 3);
    locale.c = 4;
    return locale;
  }

  public static final d bC(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[1], false).u;
    if (!(locald instanceof dm))
      return locald;
    e locale = new e((dm)locald, 4);
    locale.c = 4;
    return locale;
  }

  public static final d bD(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[1], false).u;
    if (!(locald instanceof dm))
      return locald;
    e locale = new e((dm)locald, 1);
    locale.c = 5;
    return locale;
  }

  public static final d bE(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[1], false).u;
    if (!(locald instanceof dm))
      return locald;
    e locale = new e((dm)locald, 2);
    locale.c = 5;
    return locale;
  }

  public static final d bF(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[1], false).u;
    if (!(locald instanceof dm))
      return locald;
    e locale = new e((dm)locald, 3);
    locale.c = 5;
    return locale;
  }

  public static final d bG(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[1], false).u;
    if (!(locald instanceof dm))
      return locald;
    e locale = new e((dm)locald, 4);
    locale.c = 5;
    return locale;
  }

  public static final d bH(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new dl(0, new dr(paramdv, paramdv.r(), false).u);
  }

  public static final d bI(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new dl(4, new dr(paramdv, paramdv.r(), false).u);
  }

  public static final d bJ(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new dl(2, new dr(paramdv, paramdv.r(), false).u);
  }

  public static final d bK(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new dl(6, new dr(paramdv, paramdv.r(), false).u);
  }

  public static final d bL(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[2]).u;
    double d;
    if (paramArrayOfString[1] == null)
      d = 0.0D;
    while (true)
    {
      return new ci(locald, d, paramArrayOfString[3]);
      d = Double.parseDouble(paramArrayOfString[1]);
    }
  }

  public static final d bM(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ce(new dr(paramdv, paramArrayOfString[1]).u);
  }

  public static final d bN(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[2]).u;
    double d1 = Double.parseDouble(paramArrayOfString[1]);
    double d2;
    if (paramArrayOfString[3] == null)
      d2 = Double.parseDouble(paramArrayOfString[1]);
    while (true)
    {
      return new cn(locald, d1, d2);
      d2 = Double.parseDouble(paramArrayOfString[3]);
    }
  }

  public static final d bO(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    boolean bool = true;
    d locald = new dr(paramdv, paramArrayOfString[3]).u;
    String str1 = paramArrayOfString[bool];
    String str2 = paramArrayOfString[2];
    if ((!paramArrayOfString[bool].equals("!")) && (!paramArrayOfString[2].equals("!")))
      bool = false;
    return new cg(locald, str1, str2, bool);
  }

  public static final d bP(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    float[] arrayOfFloat1 = cu.b(paramArrayOfString[1]);
    if (arrayOfFloat1.length == 1)
      throw new com.himamis.retex.renderer.a.e.n("Error in getting raise in \\raisebox command !");
    float[] arrayOfFloat2 = cu.b(paramArrayOfString[3]);
    float[] arrayOfFloat3 = cu.b(paramArrayOfString[4]);
    if ((arrayOfFloat2.length == 1) || (arrayOfFloat2[1] == 0.0F));
    for (float[] arrayOfFloat4 = { -1.0F, 0.0F }; ; arrayOfFloat4 = arrayOfFloat2)
    {
      if ((arrayOfFloat3.length == 1) || (arrayOfFloat3[1] == 0.0F));
      for (float[] arrayOfFloat5 = { -1.0F, 0.0F }; ; arrayOfFloat5 = arrayOfFloat3)
        return new cd(new dr(paramdv, paramArrayOfString[2]).u, (int)arrayOfFloat1[0], arrayOfFloat1[1], (int)arrayOfFloat4[0], arrayOfFloat4[1], (int)arrayOfFloat5[0], arrayOfFloat5[1]);
    }
  }

  public static final d bQ(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new cq(new dr(paramdv, paramArrayOfString[1]).u);
  }

  public static final d bR(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bq(new dr(paramdv, paramArrayOfString[1]).u);
  }

  public static final d bS(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new y(new dr(paramdv, paramArrayOfString[1]).u);
  }

  public static final d bT(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    float f5;
    if ("gray".equals(paramArrayOfString[2]))
      f5 = Float.parseFloat(paramArrayOfString[3]);
    float f2;
    float f3;
    float f4;
    for (b localb = a.a(f5, f5, f5); ; localb = a.a(f2, f3, f4))
    {
      r.a.put(paramArrayOfString[1], localb);
      return null;
      if (!"rgb".equals(paramArrayOfString[2]))
        break;
      String[] arrayOfString2 = paramArrayOfString[3].split(",|;");
      if (arrayOfString2.length != 3)
        throw new com.himamis.retex.renderer.a.e.n("The color definition must have three components !");
      f2 = Float.parseFloat(arrayOfString2[0].trim());
      f3 = Float.parseFloat(arrayOfString2[1].trim());
      f4 = Float.parseFloat(arrayOfString2[2].trim());
    }
    if ("cmyk".equals(paramArrayOfString[2]))
    {
      String[] arrayOfString1 = paramArrayOfString[3].split(",|;");
      if (arrayOfString1.length != 4)
        throw new com.himamis.retex.renderer.a.e.n("The color definition must have four components !");
      float[] arrayOfFloat = new float[4];
      for (int i = 0; ; i++)
      {
        if (i >= 4)
        {
          float f1 = 1.0F - arrayOfFloat[3];
          localb = a.a(f1 * (1.0F - arrayOfFloat[0]), f1 * (1.0F - arrayOfFloat[1]), f1 * (1.0F - arrayOfFloat[2]));
          break;
        }
        arrayOfFloat[i] = Float.parseFloat(arrayOfString1[i].trim());
      }
    }
    throw new com.himamis.retex.renderer.a.e.n("The color model is incorrect !");
  }

  public static final d bU(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    try
    {
      r localr = new r(new dr(paramdv, paramArrayOfString[2]).u, null, r.a(paramArrayOfString[1]));
      return localr;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    throw new com.himamis.retex.renderer.a.e.n(localNumberFormatException.toString());
  }

  public static final d bV(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    try
    {
      r localr = new r(new dr(paramdv, paramArrayOfString[2]).u, r.a(paramArrayOfString[1]), null);
      return localr;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    throw new com.himamis.retex.renderer.a.e.n(localNumberFormatException.toString());
  }

  public static final d bW(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new r(new dr(paramdv, paramArrayOfString[2]).u, null, r.a(paramArrayOfString[1]));
  }

  public static final d bX(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    b localb = r.a(paramArrayOfString[1]);
    return new ac(new dr(paramdv, paramArrayOfString[2]).u, localb, localb);
  }

  public static final d bY(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ac(new dr(paramdv, paramArrayOfString[3]).u, r.a(paramArrayOfString[2]), r.a(paramArrayOfString[1]));
  }

  public static final d bZ(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    eh localeh = new eh(dm.b("equals"));
    localeh.a(new cu(5, 0.0F, 1.5F, 0.0F));
    localeh.a(dm.b("sim"));
    localeh.a(5, -1.0F);
    return new ea(3, 3, localeh);
  }

  public static final d ba(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(3, 3, new ed(new dr(paramdv, paramArrayOfString[2], false).u, new dr(paramdv, paramArrayOfString[1], false).u, 5, 2.5F, true, true));
  }

  public static final d bb(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(3, 3, new ed(new dr(paramdv, paramArrayOfString[2], false).u, new dr(paramdv, paramArrayOfString[1], false).u, 5, 0.5F, true, false));
  }

  public static final d bc(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new a(new dr(paramdv, paramArrayOfString[2], false).u, new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d bd(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ed(new dr(paramdv, paramArrayOfString[2], false).u, new dr(paramdv, paramArrayOfString[1], false).u, 5, 0.3F, true, false);
  }

  public static final d be(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[1], false).u;
    return new ed(locald, new a(new bx(locald, true, false, false), "widetilde"), 5, 0.3F, true, false);
  }

  public static final d bf(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new h(new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d bg(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ch(new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d bh(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ch(new dr(paramdv, paramdv.r(), null, false, paramdv.j()).u);
  }

  public static final d bi(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new h(new ch(new dr(paramdv, paramArrayOfString[1], false).u));
  }

  public static final d bj(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new h(new ch(new dr(paramdv, paramdv.r(), null, false, paramdv.j()).u));
  }

  public static final d bk(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new dz(new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d bl(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new dz(new dr(paramdv, paramdv.r(), null, false, paramdv.j()).u);
  }

  public static final d bm(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ax(new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d bn(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ax(new dr(paramdv, paramdv.r(), null, false, paramdv.j()).u);
  }

  public static final d bo(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new di(new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d bp(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new di(new dr(paramdv, paramdv.r(), null, false, paramdv.j()).u);
  }

  public static final d bq(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bb();
  }

  public static final d br(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    dr localdr = new dr("\\mathbb{G}\\mathsf{e}");
    localdr.a(new ak());
    localdr.d("\\mathsf{Gebra}");
    return new r(localdr.u, null, a.a(102, 102, 102));
  }

  public static final d bs(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bx(new dr(paramdv, paramArrayOfString[1], false).u, true, false, false);
  }

  public static final d bt(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bx(new dr(paramdv, paramArrayOfString[1], false).u, false, true, true);
  }

  public static final d bu(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bx(new dr(paramdv, paramArrayOfString[1], false).u, true, true, true);
  }

  public static final d bv(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[1], false).u;
    if (!(locald instanceof dm))
      return locald;
    return new e((dm)locald, 1);
  }

  public static final d bw(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[1], false).u;
    if (!(locald instanceof dm))
      return locald;
    return new e((dm)locald, 2);
  }

  public static final d bx(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[1], false).u;
    if (!(locald instanceof dm))
      return locald;
    return new e((dm)locald, 3);
  }

  public static final d by(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[1], false).u;
    if (!(locald instanceof dm))
      return locald;
    return new e((dm)locald, 4);
  }

  public static final d bz(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = new dr(paramdv, paramArrayOfString[1], false).u;
    if (!(locald instanceof dm))
      return locald;
    e locale = new e((dm)locald, 1);
    locale.c = 4;
    return locale;
  }

  public static final d c(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    String str = paramArrayOfString[1].replaceAll("\\|", "\\\\middle\\\\vert ");
    return new dr(paramdv, "\\left\\langle " + str + "\\right\\rangle").u;
  }

  public static final d cA(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl = new cl(new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true));
    localcl.a(new cu(0, -0.32F, 0.0F, 0.0F));
    localcl.a(dm.b("equals"));
    return new ea(3, 3, localcl);
  }

  public static final d cB(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    ed localed = new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true);
    cl localcl = new cl(localed);
    localcl.a(localed);
    localcl.a(new cu(0, -0.32F, 0.0F, 0.0F));
    localcl.a(dm.b("equals"));
    return new ea(3, 3, localcl);
  }

  public static final d cC(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    ed localed = new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true);
    cl localcl = new cl(localed);
    localcl.a(localed);
    return new ea(3, 3, localcl);
  }

  public static final d cD(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl = new cl(new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true));
    localcl.a(new cu(0, -0.32F, 0.0F, 0.0F));
    localcl.a(dm.b("sim"));
    return new ea(3, 3, localcl);
  }

  public static final d cE(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    ed localed = new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true);
    cl localcl = new cl(localed);
    localcl.a(localed);
    localcl.a(new cu(0, -0.32F, 0.0F, 0.0F));
    localcl.a(dm.b("sim"));
    return new ea(3, 3, localcl);
  }

  public static final d cF(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl = new cl(new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true));
    localcl.a(new cu(0, -0.32F, 0.0F, 0.0F));
    localcl.a(dm.b("approx"));
    return new ea(3, 3, localcl);
  }

  public static final d cG(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    ed localed = new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true);
    cl localcl = new cl(localed);
    localcl.a(localed);
    localcl.a(new cu(0, -0.32F, 0.0F, 0.0F));
    localcl.a(dm.b("approx"));
    return new ea(3, 3, localcl);
  }

  public static final d cH(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(3, 3, new ed(dm.b("equals"), dm.b("smallfrown"), 5, -2.0F, true, true));
  }

  public static final d cI(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl1 = new cl(new cu(1, -0.1F, 0.0F, 0.0F));
    localcl1.a(dm.b("bar"));
    eh localeh = new eh(new bc(localcl1, 'r'));
    localeh.a(1, -0.1F);
    cl localcl2 = new cl(localeh);
    localcl2.a(new ch(new n('h', paramdv.a.v)));
    return localcl2;
  }

  public static final d cJ(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl1 = new cl(new cu(1, 0.28F, 0.0F, 0.0F));
    localcl1.a(dm.b("textendash"));
    eh localeh = new eh(new bc(localcl1, 'r'));
    localeh.a(1, 0.55F);
    cl localcl2 = new cl(localeh);
    localcl2.a(new ch(new n('H', paramdv.a.v)));
    return localcl2;
  }

  public static final d cK(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl1 = new cl(new cu(1, 0.25F, 0.0F, 0.0F));
    localcl1.a(dm.b("bar"));
    eh localeh = new eh(new bc(localcl1, 'r'));
    localeh.a(1, -0.1F);
    cl localcl2 = new cl(localeh);
    localcl2.a(new ch(new n('d', paramdv.a.v)));
    return localcl2;
  }

  public static final d cL(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl1 = new cl(new cu(1, -0.1F, 0.0F, 0.0F));
    localcl1.a(dm.b("bar"));
    eh localeh = new eh(new bc(localcl1, 'r'));
    localeh.a(1, -0.55F);
    cl localcl2 = new cl(localeh);
    localcl2.a(new ch(new n('D', paramdv.a.v)));
    return localcl2;
  }

  public static final d cM(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    float[] arrayOfFloat = cu.b(paramArrayOfString[1]);
    if (arrayOfFloat.length == 1)
      throw new com.himamis.retex.renderer.a.e.n("Error in getting kern in \\kern command !");
    return new cu((int)arrayOfFloat[0], arrayOfFloat[1], 0.0F, 0.0F);
  }

  public static final d cN(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    String str1 = paramArrayOfString[1];
    int i = 10;
    String str2;
    if ((str1.startsWith("0x")) || (str1.startsWith("0X")))
    {
      str2 = str1.substring(2);
      i = 16;
    }
    while (true)
    {
      return paramdv.a((char)Integer.parseInt(str2, i), true);
      if ((str1.startsWith("x")) || (str1.startsWith("X")))
      {
        str2 = str1.substring(1);
        i = 16;
        continue;
      }
      if (str1.startsWith("0"))
      {
        str2 = str1.substring(1);
        i = 8;
        continue;
      }
      str2 = str1;
    }
  }

  public static final d cO(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ci(new dr(paramdv, paramArrayOfString[1]).u, 180.0D, "origin=cc");
  }

  public static final d cP(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    int[] arrayOfInt = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] arrayOfString = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    String str = "";
    int i = Integer.parseInt(paramArrayOfString[1].trim());
    for (int j = 0; ; j++)
    {
      if (j >= arrayOfInt.length)
      {
        if (paramArrayOfString[0].charAt(0) == 'r')
          str = str.toLowerCase();
        return new dr(str, false).u;
      }
      do
      {
        str = str + arrayOfString[j];
        i -= arrayOfInt[j];
      }
      while (i >= arrayOfInt[j]);
    }
  }

  public static final d cQ(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new dx(new ch(new dr(paramdv, paramArrayOfString[1]).u));
  }

  public static final d cR(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new cs(new dr(paramdv, paramArrayOfString[1], false).u);
  }

  public static final d cS(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new cs(new dr(paramdv, paramdv.r(), null, false, paramdv.j()).u);
  }

  public static final d cT(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new cu(0, 1.0F, 0.0F, 0.0F);
  }

  public static final d cU(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    int i = 1;
    if (paramArrayOfString[0].equals(","));
    while (true)
    {
      return new cu(i);
      if (paramArrayOfString[0].equals(":"))
      {
        i = 2;
        continue;
      }
      if (paramArrayOfString[0].equals(";"))
      {
        i = 3;
        continue;
      }
      if (paramArrayOfString[0].equals("thinspace"))
        continue;
      if (paramArrayOfString[0].equals("medspace"))
      {
        i = 2;
        continue;
      }
      if (paramArrayOfString[0].equals("thickspace"))
      {
        i = 3;
        continue;
      }
      if (paramArrayOfString[0].equals("!"))
      {
        i = -1;
        continue;
      }
      if (paramArrayOfString[0].equals("negthinspace"))
      {
        i = -1;
        continue;
      }
      if (paramArrayOfString[0].equals("negmedspace"))
      {
        i = -2;
        continue;
      }
      if (paramArrayOfString[0].equals("negthickspace"))
      {
        i = -3;
        continue;
      }
      i = 0;
    }
  }

  public static final d cV(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new eg(dm.b("surdsign"));
  }

  public static final d cW(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = dm.b("int").c();
    locald.d = 1;
    return locald;
  }

  public static final d cX(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = dm.b("oint").c();
    locald.d = 1;
    return locald;
  }

  public static final d cY(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = dm.b("int").c();
    locald.d = 1;
    cl localcl = new cl(locald);
    localcl.a(new cu(5, -6.0F, 0.0F, 0.0F));
    localcl.a(locald);
    localcl.b = true;
    return new ea(1, 1, localcl);
  }

  public static final d cZ(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = dm.b("int").c();
    locald.d = 1;
    cl localcl = new cl(locald);
    localcl.a(new cu(5, -6.0F, 0.0F, 0.0F));
    localcl.a(locald);
    localcl.a(new cu(5, -6.0F, 0.0F, 0.0F));
    localcl.a(locald);
    localcl.b = true;
    return new ea(1, 1, localcl);
  }

  public static final d ca(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(3, 3, new ed(dm.b("equals"), dm.b("ldotp"), 5, 3.7F, false, true));
  }

  public static final d cb(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    if (com.himamis.retex.renderer.a.d.a.d())
      return new com.himamis.retex.renderer.a.d.a(paramArrayOfString[1], paramArrayOfString[2]);
    throw new com.himamis.retex.renderer.a.e.n("No ExternalConverterFactory set !");
  }

  public static final d cc(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    az.a(paramArrayOfString[1]);
    return null;
  }

  public static final d cd(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ay(paramArrayOfString[1], 0);
  }

  public static final d ce(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ay(paramArrayOfString[1], 2);
  }

  public static final d cf(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ay(paramArrayOfString[1], 1);
  }

  public static final d cg(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ay(paramArrayOfString[1], 3);
  }

  public static final d ch(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    v.a(Float.parseFloat(paramArrayOfString[1]), Float.parseFloat(paramArrayOfString[2]), Float.parseFloat(paramArrayOfString[3]), Float.parseFloat(paramArrayOfString[4]));
    return null;
  }

  public static final d ci(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    v.c(Float.parseFloat(paramArrayOfString[1]));
    return null;
  }

  public static final d cj(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    if (!paramdv.i())
      throw new com.himamis.retex.renderer.a.e.n("The macro \\hline is only available in array mode !");
    return new as();
  }

  public static final d ck(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    float f;
    if ("tiny".equals(paramArrayOfString[0]))
      f = 0.5F;
    while (true)
    {
      return new bj(new dr(paramdv, paramdv.r(), null, false, paramdv.j()).u, f);
      if ("scriptsize".equals(paramArrayOfString[0]))
      {
        f = 0.7F;
        continue;
      }
      if ("footnotesize".equals(paramArrayOfString[0]))
      {
        f = 0.8F;
        continue;
      }
      if ("small".equals(paramArrayOfString[0]))
      {
        f = 0.9F;
        continue;
      }
      if ("normalsize".equals(paramArrayOfString[0]))
      {
        f = 1.0F;
        continue;
      }
      if ("large".equals(paramArrayOfString[0]))
      {
        f = 1.2F;
        continue;
      }
      if ("Large".equals(paramArrayOfString[0]))
      {
        f = 1.4F;
        continue;
      }
      if ("LARGE".equals(paramArrayOfString[0]))
      {
        f = 1.8F;
        continue;
      }
      if ("huge".equals(paramArrayOfString[0]))
      {
        f = 2.0F;
        continue;
      }
      if ("Huge".equals(paramArrayOfString[0]))
      {
        f = 2.5F;
        continue;
      }
      f = 1.0F;
    }
  }

  public static final d cl(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new t(paramdv.d(), null, new dr(paramdv, paramArrayOfString[1]).u);
  }

  public static final d cm(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new t(paramdv.d(), new dr(paramdv, paramArrayOfString[1]).u, null);
  }

  public static final d cn(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(2, 2, new ed(dm.b("minus"), dm.b("normaldot"), 5, -3.3F, false, true));
  }

  public static final d co(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ea(3, 3, new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true));
  }

  public static final d cp(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl = new cl(dm.b("normaldot"));
    localcl.a(new cu(5, 4.0F, 0.0F, 0.0F));
    localcl.a(dm.b("normaldot"));
    return new ea(3, 3, new ed(dm.b("minus"), localcl, 5, -3.4F, false, localcl, 5, -3.4F, false));
  }

  public static final d cq(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl = new cl(dm.b("minus"));
    localcl.a(new cu(0, -0.095F, 0.0F, 0.0F));
    localcl.a(new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true));
    return new ea(3, 3, localcl);
  }

  public static final d cr(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl = new cl(dm.b("minus"));
    localcl.a(new cu(0, -0.095F, 0.0F, 0.0F));
    ed localed = new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true);
    localcl.a(localed);
    localcl.a(localed);
    return new ea(3, 3, localcl);
  }

  public static final d cs(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl = new cl(dm.b("sim"));
    localcl.a(new cu(0, -0.095F, 0.0F, 0.0F));
    localcl.a(new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true));
    return new ea(3, 3, localcl);
  }

  public static final d ct(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl = new cl(dm.b("sim"));
    localcl.a(new cu(0, -0.095F, 0.0F, 0.0F));
    ed localed = new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true);
    localcl.a(localed);
    localcl.a(localed);
    return new ea(3, 3, localcl);
  }

  public static final d cu(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl = new cl(dm.b("approx"));
    localcl.a(new cu(0, -0.095F, 0.0F, 0.0F));
    localcl.a(new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true));
    return new ea(3, 3, localcl);
  }

  public static final d cv(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl = new cl(dm.b("approx"));
    localcl.a(new cu(0, -0.095F, 0.0F, 0.0F));
    ed localed = new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true);
    localcl.a(localed);
    localcl.a(localed);
    return new ea(3, 3, localcl);
  }

  public static final d cw(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl = new cl(dm.b("equals"));
    localcl.a(new cu(0, -0.095F, 0.0F, 0.0F));
    localcl.a(new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true));
    return new ea(3, 3, localcl);
  }

  public static final d cx(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl = new cl(dm.b("equals"));
    localcl.a(new cu(0, -0.095F, 0.0F, 0.0F));
    ed localed = new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true);
    localcl.a(localed);
    localcl.a(localed);
    return new ea(3, 3, localcl);
  }

  public static final d cy(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    cl localcl = new cl(new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true));
    localcl.a(new cu(0, -0.32F, 0.0F, 0.0F));
    localcl.a(dm.b("minus"));
    return new ea(3, 3, localcl);
  }

  public static final d cz(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    ed localed = new ed(dm.b("normaldot"), dm.b("normaldot"), 5, 5.2F, false, true);
    cl localcl = new cl(localed);
    localcl.a(localed);
    localcl.a(new cu(0, -0.32F, 0.0F, 0.0F));
    localcl.a(dm.b("minus"));
    return new ea(3, 3, localcl);
  }

  public static final d d(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    String str = paramArrayOfString[1].replaceFirst("\\|", "\\\\middle\\\\vert ");
    return new dr(paramdv, "\\left\\{" + str + "\\right\\}").u;
  }

  public static final d da(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = dm.b("int").c();
    locald.d = 1;
    cl localcl = new cl(locald);
    localcl.a(new cu(5, -6.0F, 0.0F, 0.0F));
    localcl.a(locald);
    localcl.a(new cu(5, -6.0F, 0.0F, 0.0F));
    localcl.a(locald);
    localcl.a(new cu(5, -6.0F, 0.0F, 0.0F));
    localcl.a(locald);
    localcl.b = true;
    return new ea(1, 1, localcl);
  }

  public static final d db(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald = dm.b("int").c();
    locald.d = 1;
    cl localcl1 = new cl(locald);
    localcl1.a(new cu(5, -1.0F, 0.0F, 0.0F));
    dm localdm = dm.b("cdotp");
    cl localcl2 = new cl(localdm);
    localcl2.a(localdm);
    localcl2.a(localdm);
    localcl1.a(new ea(7, 7, localcl2));
    localcl1.a(new cu(5, -1.0F, 0.0F, 0.0F));
    localcl1.a(locald);
    localcl1.b = true;
    return new ea(1, 1, localcl1);
  }

  public static final d dc(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    e locale = new e((dm)dm.b("lmoustache").c(), 1);
    locale.c = 4;
    return locale;
  }

  public static final d dd(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    e locale = new e((dm)dm.b("rmoustache").c(), 1);
    locale.c = 5;
    return locale;
  }

  public static final d de(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new k();
  }

  public static final d df(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    Map localMap = paramdv.a.t;
    String str1 = paramArrayOfString[1];
    StringBuffer localStringBuffer = new StringBuffer();
    String str2 = str1;
    int i = str2.indexOf("$");
    if (i == -1)
    {
      localStringBuffer.append(str2);
      return new dr(paramdv, localStringBuffer.toString()).u;
    }
    if (i < -1 + str2.length());
    int k;
    for (int j = i; ; j = k)
    {
      k = j + 1;
      if ((k < str2.length()) && (Character.isLetter(str2.charAt(k))))
        continue;
      String str3 = (String)localMap.get(str2.substring(i + 1, k));
      if (str3 != null)
      {
        localStringBuffer.append(str2.substring(0, i));
        localStringBuffer.append(str3);
      }
      while (true)
      {
        str2 = str2.substring(k);
        break;
        localStringBuffer.append(str2.substring(0, k));
      }
      localStringBuffer.append(str2);
      str2 = "";
      break;
    }
  }

  public static final d e(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    eh localeh = new eh(new dr("\\displaystyle\\!\\breve{}").u);
    localeh.a(1, 0.6F);
    return new ct(localeh, null);
  }

  public static final d f(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    eh localeh = new eh(new dr("\\displaystyle\\widehat{}").u);
    localeh.a(1, 0.6F);
    return new ct(localeh, null);
  }

  public static final d g(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    int i = 0;
    if ((i >= paramArrayOfString[1].length()) || (Character.isLetter(paramArrayOfString[1].charAt(i))));
    float f;
    int j;
    while (true)
    {
      try
      {
        f = Float.parseFloat(paramArrayOfString[1].substring(0, i));
        if (i != paramArrayOfString[1].length())
        {
          j = cu.a(paramArrayOfString[1].substring(i).toLowerCase());
          if (j != -1)
            break label131;
          throw new com.himamis.retex.renderer.a.e.n("Unknown unit \"" + paramArrayOfString[1].substring(i) + "\" !");
          i++;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new com.himamis.retex.renderer.a.e.n(localNumberFormatException.toString());
      }
      j = 3;
    }
    label131: if (paramArrayOfString[0].charAt(0) == 'h')
      return new cu(j, f, 0.0F, 0.0F);
    return new cu(j, 0.0F, f, 0.0F);
  }

  public static final d h(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bc(new dr(paramdv, paramArrayOfString[1]).u, paramArrayOfString[0].charAt(0));
  }

  public static final d i(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new bc(new dr(paramdv, paramArrayOfString[1]).u, paramArrayOfString[0].charAt(4));
  }

  public static final d j(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ap(paramArrayOfString[1], paramArrayOfString[2]);
  }

  public static final d k(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    float[] arrayOfFloat1 = cu.b(paramArrayOfString[1]);
    if (arrayOfFloat1.length == 1)
      throw new com.himamis.retex.renderer.a.e.n("Error in getting width in \\rule command !");
    float[] arrayOfFloat2 = cu.b(paramArrayOfString[2]);
    if (arrayOfFloat2.length == 1)
      throw new com.himamis.retex.renderer.a.e.n("Error in getting height in \\rule command !");
    float[] arrayOfFloat3 = cu.b(paramArrayOfString[3]);
    if (arrayOfFloat3.length == 1)
      throw new com.himamis.retex.renderer.a.e.n("Error in getting raise in \\rule command !");
    return new cm((int)arrayOfFloat1[0], arrayOfFloat1[1], (int)arrayOfFloat2[0], arrayOfFloat2[1], (int)arrayOfFloat3[0], -arrayOfFloat3[1]);
  }

  public static final d l(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    int i;
    if ("r".equals(paramArrayOfString[3]))
      i = 1;
    while (true)
    {
      dr localdr1 = new dr(paramdv, paramArrayOfString[1], false);
      dr localdr2 = new dr(paramdv, paramArrayOfString[2], false);
      if ((localdr1.u == null) || (localdr2.u == null))
      {
        throw new com.himamis.retex.renderer.a.e.n("Both numerator and denominator of a fraction can't be empty!");
        if ("l".equals(paramArrayOfString[3]))
        {
          i = 0;
          continue;
        }
      }
      else
      {
        ai localai = new ai(localdr1.u, localdr2.u, true, i, 2);
        cl localcl = new cl();
        localcl.a(new dl(0, localai));
        return localcl;
      }
      i = 2;
    }
  }

  public static final d m(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    dr localdr1 = new dr(paramdv, paramArrayOfString[1], false);
    dr localdr2 = new dr(paramdv, paramArrayOfString[2], false);
    if ((localdr1.u == null) || (localdr2.u == null))
      throw new com.himamis.retex.renderer.a.e.n("Both numerator and denominator of a fraction can't be empty!");
    return new ai(localdr1.u, localdr2.u, true);
  }

  public static final d n(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    dr localdr1 = new dr(paramdv, paramArrayOfString[1], false);
    dr localdr2 = new dr(paramdv, paramArrayOfString[2], false);
    if ((localdr1.u == null) || (localdr2.u == null))
      throw new com.himamis.retex.renderer.a.e.n("Both numerator and denominator of a fraction can't be empty!");
    double d1 = 0.75D;
    Object localObject = dm.b("slash");
    float f3;
    float f2;
    float f1;
    double d2;
    if (!paramdv.k())
    {
      f3 = 0.75F;
      f2 = -0.24F;
      f1 = -0.24F;
      localObject = new eh(new cn(dm.b("textfractionsolidus"), 1.25D, 0.65D));
      ((eh)localObject).a(1, 0.4F);
      d1 = 0.5D;
      d2 = 0.6D;
    }
    while (true)
    {
      eh localeh = new eh(new cn(localdr1.u, d2, d1));
      localeh.a(1, f3);
      cl localcl = new cl(localeh);
      localcl.a(new cu(0, f2, 0.0F, 0.0F));
      localcl.a((d)localObject);
      localcl.a(new cu(0, f1, 0.0F, 0.0F));
      localcl.a(new cn(localdr2.u, d2, d1));
      return localcl;
      f1 = -0.065F;
      d2 = 0.75D;
      f2 = -0.13F;
      f3 = 0.45F;
    }
  }

  public static final d o(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    dr localdr1 = new dr(paramdv, paramArrayOfString[1], false);
    if ((localdr1 != null) && ((localdr1.u instanceof dm)));
    for (dm localdm1 = (dm)localdr1.u; ; localdm1 = null)
    {
      dr localdr2 = new dr(paramdv, paramArrayOfString[2], false);
      if ((localdr2 != null) && ((localdr2.u instanceof dm)));
      for (dm localdm2 = (dm)localdr2.u; ; localdm2 = null)
      {
        float[] arrayOfFloat1 = cu.b(paramArrayOfString[3]);
        float[] arrayOfFloat2;
        if ((paramArrayOfString[3] == null) || (paramArrayOfString[3].length() == 0) || (arrayOfFloat1.length == 1))
          arrayOfFloat2 = new float[] { 0.0F, 0.0F };
        for (boolean bool = false; ; bool = true)
        {
          if (paramArrayOfString[4].length() != 0);
          for (int i = Integer.parseInt(paramArrayOfString[4]); ; i = 0)
          {
            dr localdr3 = new dr(paramdv, paramArrayOfString[5], false);
            dr localdr4 = new dr(paramdv, paramArrayOfString[6], false);
            if ((localdr3.u == null) || (localdr4.u == null))
              throw new com.himamis.retex.renderer.a.e.n("Both numerator and denominator of a fraction can't be empty!");
            ai localai = new ai(localdr3.u, localdr4.u, bool, (int)arrayOfFloat2[0], arrayOfFloat2[1]);
            cl localcl = new cl();
            localcl.a(new dl(i * 2, new af(localai, localdm1, localdm2)));
            return localcl;
          }
          arrayOfFloat2 = arrayOfFloat1;
        }
      }
    }
  }

  public static final d p(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald1 = paramdv.e();
    d locald2 = new dr(paramdv, paramdv.r(), false).u;
    if ((locald1 == null) || (locald2 == null))
      throw new com.himamis.retex.renderer.a.e.n("Both numerator and denominator of a fraction can't be empty!");
    return new ai(locald1, locald2, true);
  }

  public static final d q(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald1 = paramdv.e();
    d locald2 = new dr(paramdv, paramdv.r(), false).u;
    if ((locald1 == null) || (locald2 == null))
      throw new com.himamis.retex.renderer.a.e.n("Both numerator and denominator of a fraction can't be empty!");
    d locald3 = new dr(paramdv, paramArrayOfString[1], false).u;
    if ((locald3 instanceof e));
    for (Object localObject1 = ((e)locald3).a; ; localObject1 = locald3)
    {
      d locald4 = new dr(paramdv, paramArrayOfString[2], false).u;
      if ((locald4 instanceof e));
      for (Object localObject2 = ((e)locald4).a; ; localObject2 = locald4)
      {
        if (((localObject1 instanceof dm)) && ((localObject2 instanceof dm)))
          return new af(new ai(locald1, locald2, true), (dm)localObject1, (dm)localObject2);
        cl localcl = new cl();
        localcl.a((d)localObject1);
        localcl.a(new ai(locald1, locald2, true));
        localcl.a((d)localObject2);
        return localcl;
      }
    }
  }

  public static final d r(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald1 = paramdv.e();
    d locald2 = new dr(paramdv, paramdv.r(), false).u;
    if ((locald1 == null) || (locald2 == null))
      throw new com.himamis.retex.renderer.a.e.n("Both numerator and denominator of a fraction can't be empty!");
    return new ai(locald1, locald2, false);
  }

  public static final d s(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald1 = paramdv.e();
    d locald2 = new dr(paramdv, paramdv.r(), false).u;
    if ((locald1 == null) || (locald2 == null))
      throw new com.himamis.retex.renderer.a.e.n("Both numerator and denominator of a fraction can't be empty!");
    d locald3 = new dr(paramdv, paramArrayOfString[1], false).u;
    if ((locald3 instanceof e));
    for (Object localObject1 = ((e)locald3).a; ; localObject1 = locald3)
    {
      d locald4 = new dr(paramdv, paramArrayOfString[2], false).u;
      if ((locald4 instanceof e));
      for (Object localObject2 = ((e)locald4).a; ; localObject2 = locald4)
      {
        if (((localObject1 instanceof dm)) && ((localObject2 instanceof dm)))
          return new af(new ai(locald1, locald2, false), (dm)localObject1, (dm)localObject2);
        cl localcl = new cl();
        localcl.a((d)localObject1);
        localcl.a(new ai(locald1, locald2, false));
        localcl.a((d)localObject2);
        return localcl;
      }
    }
  }

  public static final d t(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald1 = paramdv.e();
    d locald2 = new dr(paramdv, paramdv.r(), false).u;
    if ((locald1 == null) || (locald2 == null))
      throw new com.himamis.retex.renderer.a.e.n("Both numerator and denominator of choose can't be empty!");
    return new af(new ai(locald1, locald2, false), new dm("lbrack", 4, true), new dm("rbrack", 5, true));
  }

  public static final d u(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    dr localdr1 = new dr(paramdv, paramArrayOfString[1], false);
    dr localdr2 = new dr(paramdv, paramArrayOfString[2], false);
    if ((localdr1.u == null) || (localdr2.u == null))
      throw new com.himamis.retex.renderer.a.e.n("Both binomial coefficients must be not empty !!");
    return new af(new ai(localdr1.u, localdr2.u, false), new dm("lbrack", 4, true), new dm("rbrack", 5, true));
  }

  public static final d v(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald1 = paramdv.e();
    float[] arrayOfFloat = paramdv.s();
    d locald2 = new dr(paramdv, paramdv.r(), false).u;
    if ((arrayOfFloat == null) || (arrayOfFloat.length != 2))
      throw new com.himamis.retex.renderer.a.e.n("Invalid length in above macro");
    if ((locald1 == null) || (locald2 == null))
      throw new com.himamis.retex.renderer.a.e.n("Both numerator and denominator of a fraction can't be empty!");
    return new ai(locald1, locald2, (int)arrayOfFloat[0], arrayOfFloat[1]);
  }

  public static final d w(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    d locald1 = paramdv.e();
    float[] arrayOfFloat = paramdv.s();
    d locald2 = new dr(paramdv, paramdv.r(), false).u;
    if ((arrayOfFloat == null) || (arrayOfFloat.length != 2))
      throw new com.himamis.retex.renderer.a.e.n("Invalid length in above macro");
    if ((locald1 == null) || (locald2 == null))
      throw new com.himamis.retex.renderer.a.e.n("Both numerator and denominator of a fraction can't be empty!");
    d locald3 = new dr(paramdv, paramArrayOfString[1], false).u;
    if ((locald3 instanceof e));
    for (Object localObject1 = ((e)locald3).a; ; localObject1 = locald3)
    {
      d locald4 = new dr(paramdv, paramArrayOfString[2], false).u;
      if ((locald4 instanceof e));
      for (Object localObject2 = ((e)locald4).a; ; localObject2 = locald4)
      {
        if (((localObject1 instanceof dm)) && ((localObject2 instanceof dm)))
          return new af(new ai(locald1, locald2, (int)arrayOfFloat[0], arrayOfFloat[1]), (dm)localObject1, (dm)localObject2);
        cl localcl = new cl();
        localcl.a((d)localObject1);
        localcl.a(new ai(locald1, locald2, true));
        localcl.a((d)localObject2);
        return localcl;
      }
    }
  }

  public static final d x(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    String str1 = paramArrayOfString[0];
    String str2;
    if ("frak".equals(paramArrayOfString[0]))
      str2 = "mathfrak";
    while (true)
    {
      dr.a locala = (dr.a)dr.r.get(a.c.a);
      if (locala != null)
        dr.r.put(a.c.a, null);
      d locald = new dr(paramdv, paramArrayOfString[1], false).u;
      if (locala != null)
        dr.r.put(a.c.a, locala);
      return new dy(locald, str2);
      if ("Bbb".equals(paramArrayOfString[0]))
      {
        str2 = "mathbb";
        continue;
      }
      if ("bold".equals(paramArrayOfString[0]))
        return new h(new dr(paramdv, paramArrayOfString[1], false).u);
      if ("cal".equals(paramArrayOfString[0]))
      {
        str2 = "mathcal";
        continue;
      }
      str2 = str1;
    }
  }

  public static final d y(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new dl(2, new ch(new dr(paramdv, paramArrayOfString[1], "mathnormal", false, false).u));
  }

  public static final d z(dv paramdv, String[] paramArrayOfString)
    throws com.himamis.retex.renderer.a.e.n
  {
    return new ch(new dr(paramdv, paramArrayOfString[1], "mathnormal", false, false).u);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.bz
 * JD-Core Version:    0.6.0
 */