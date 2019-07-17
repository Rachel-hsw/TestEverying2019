package com.gensee.pdu;

public class PduBase
{
  protected static final float TOUCH_WIDTH = 32.0F;
  protected int type;
  private short version = 1;

  public int getType()
  {
    return this.type;
  }

  public short getVersion()
  {
    return this.version;
  }

  public void setType(int paramInt)
  {
    this.type = paramInt;
  }

  public void setVersion(short paramShort)
  {
    this.version = paramShort;
  }

  public String toString()
  {
    return "PduBase [type=" + this.type + "]";
  }

  public static abstract interface AnnoType
  {
    public static final int ANNO_CIRCLE = 5;
    public static final int ANNO_CLEANER = 3;
    public static final int ANNO_FREEPEN = 2;
    public static final int ANNO_FREEPEN_EX = 16;
    public static final int ANNO_LINE = 7;
    public static final int ANNO_LINE_EX = 8;
    public static final int ANNO_NULL = 0;
    public static final int ANNO_POINTER = 1;
    public static final int ANNO_POINTER_EX = 9;
    public static final int ANNO_RECT = 6;
    public static final int ANNO_SELECTOR = 127;
    public static final int ANNO_TEXT = 4;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.pdu.PduBase
 * JD-Core Version:    0.6.0
 */