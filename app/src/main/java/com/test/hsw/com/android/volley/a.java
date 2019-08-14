package com.android.volley;

import android.content.Intent;

public class a extends x
{
  private Intent b;

  public a()
  {
  }

  public a(Intent paramIntent)
  {
    this.b = paramIntent;
  }

  public a(l paraml)
  {
    super(paraml);
  }

  public a(String paramString)
  {
    super(paramString);
  }

  public a(String paramString, Exception paramException)
  {
    super(paramString, paramException);
  }

  public Intent a()
  {
    return this.b;
  }

  public String getMessage()
  {
    if (this.b != null)
      return "User needs to (re)enter credentials.";
    return super.getMessage();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.a
 * JD-Core Version:    0.6.0
 */