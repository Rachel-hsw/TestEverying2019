package com.squareup.wire;

import java.io.IOException;

public enum WireType
{
  public static final int FIXED_32_SIZE = 4;
  public static final int FIXED_64_SIZE = 8;
  public static final int TAG_TYPE_BITS = 3;
  private static final int a = 7;
  private final int b;

  static
  {
    FIXED64 = new WireType("FIXED64", 1, 1);
    LENGTH_DELIMITED = new WireType("LENGTH_DELIMITED", 2, 2);
    START_GROUP = new WireType("START_GROUP", 3, 3);
    END_GROUP = new WireType("END_GROUP", 4, 4);
    FIXED32 = new WireType("FIXED32", 5, 5);
    WireType[] arrayOfWireType = new WireType[6];
    arrayOfWireType[0] = VARINT;
    arrayOfWireType[1] = FIXED64;
    arrayOfWireType[2] = LENGTH_DELIMITED;
    arrayOfWireType[3] = START_GROUP;
    arrayOfWireType[4] = END_GROUP;
    arrayOfWireType[5] = FIXED32;
    c = arrayOfWireType;
  }

  private WireType(int paramInt)
  {
    this.b = paramInt;
  }

  public static WireType valueOf(int paramInt)
    throws IOException
  {
    switch (paramInt & 0x7)
    {
    default:
      throw new IOException("No WireType for type " + (paramInt & 0x7));
    case 0:
      return VARINT;
    case 1:
      return FIXED64;
    case 2:
      return LENGTH_DELIMITED;
    case 3:
      return START_GROUP;
    case 4:
      return END_GROUP;
    case 5:
    }
    return FIXED32;
  }

  public int value()
  {
    return this.b;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.wire.WireType
 * JD-Core Version:    0.6.0
 */