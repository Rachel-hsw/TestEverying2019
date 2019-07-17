package com.himamis.retex.renderer.a.e;

public class g extends m
{
  protected g(char paramChar, String paramString)
  {
    super("The character '" + paramChar + "' is mapped to a symbol with the name '" + paramString + "', but that symbol is not defined as a delimiter (" + "del" + "='true') in '" + "TeXSymbols.xml" + "'!");
  }

  public g(String paramString)
  {
    super("The symbol with the name '" + paramString + "' is not defined as a delimiter (" + "del" + "='true') in '" + "TeXSymbols.xml" + "'!");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.e.g
 * JD-Core Version:    0.6.0
 */