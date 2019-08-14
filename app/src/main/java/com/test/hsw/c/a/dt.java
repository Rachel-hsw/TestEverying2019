package c.a;

import java.util.BitSet;

public final class dt extends dh
{
  public dt(eb parameb)
  {
    super(parameb);
  }

  public static BitSet a(byte[] paramArrayOfByte)
  {
    BitSet localBitSet = new BitSet();
    for (int i = 0; i < 8 * paramArrayOfByte.length; i++)
    {
      if ((paramArrayOfByte[(-1 + (paramArrayOfByte.length - i / 8))] & 1 << i % 8) <= 0)
        continue;
      localBitSet.set(i);
    }
    return localBitSet;
  }

  public static byte[] b(BitSet paramBitSet, int paramInt)
  {
    byte[] arrayOfByte = new byte[(int)Math.ceil(paramInt / 8.0D)];
    for (int i = 0; i < paramBitSet.length(); i++)
    {
      if (!paramBitSet.get(i))
        continue;
      int j = -1 + (arrayOfByte.length - i / 8);
      arrayOfByte[j] = (byte)(arrayOfByte[j] | 1 << i % 8);
    }
    return arrayOfByte;
  }

  public Class<? extends dv> D()
  {
    return dy.class;
  }

  public void a(BitSet paramBitSet, int paramInt)
    throws cs
  {
    byte[] arrayOfByte = b(paramBitSet, paramInt);
    int i = arrayOfByte.length;
    for (int j = 0; j < i; j++)
      a(arrayOfByte[j]);
  }

  public BitSet b(int paramInt)
    throws cs
  {
    int i = (int)Math.ceil(paramInt / 8.0D);
    byte[] arrayOfByte = new byte[i];
    for (int j = 0; j < i; j++)
      arrayOfByte[j] = u();
    return a(arrayOfByte);
  }

  public static class a
    implements dp
  {
    public dn a(eb parameb)
    {
      return new dt(parameb);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.dt
 * JD-Core Version:    0.6.0
 */