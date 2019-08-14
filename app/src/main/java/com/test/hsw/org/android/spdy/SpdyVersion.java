package org.android.spdy;

public enum SpdyVersion
{
  private int version;

  static
  {
    SpdyVersion[] arrayOfSpdyVersion = new SpdyVersion[3];
    arrayOfSpdyVersion[0] = SPDY2;
    arrayOfSpdyVersion[1] = SPDY3;
    arrayOfSpdyVersion[2] = SPDY3DOT1;
    $VALUES = arrayOfSpdyVersion;
  }

  private SpdyVersion(int paramInt)
  {
    this.version = paramInt;
  }

  int getInt()
  {
    return this.version;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.spdy.SpdyVersion
 * JD-Core Version:    0.6.0
 */