package com.squareup.a.a.b;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

class m extends Inflater
{
  m(k paramk)
  {
  }

  public int inflate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataFormatException
  {
    int i = super.inflate(paramArrayOfByte, paramInt1, paramInt2);
    if ((i == 0) && (needsDictionary()))
    {
      setDictionary(r.m);
      i = super.inflate(paramArrayOfByte, paramInt1, paramInt2);
    }
    return i;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.b.m
 * JD-Core Version:    0.6.0
 */