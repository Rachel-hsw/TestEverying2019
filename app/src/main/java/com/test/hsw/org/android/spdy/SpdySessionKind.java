package org.android.spdy;

public enum SpdySessionKind
{
  private int code;

  static
  {
    THREE_G_SESSION = new SpdySessionKind("THREE_G_SESSION", 2, 2);
    TWO_G_SESSION = new SpdySessionKind("TWO_G_SESSION", 3, 3);
    SpdySessionKind[] arrayOfSpdySessionKind = new SpdySessionKind[4];
    arrayOfSpdySessionKind[0] = NONE_SESSION;
    arrayOfSpdySessionKind[1] = WIFI_SESSION;
    arrayOfSpdySessionKind[2] = THREE_G_SESSION;
    arrayOfSpdySessionKind[3] = TWO_G_SESSION;
    $VALUES = arrayOfSpdySessionKind;
  }

  private SpdySessionKind(int paramInt)
  {
    this.code = paramInt;
  }

  int getint()
  {
    return this.code;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.spdy.SpdySessionKind
 * JD-Core Version:    0.6.0
 */