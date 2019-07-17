package com.gensee.chat.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.io.InputStream;
import java.util.Vector;

public class GifHelper
{
  protected static final int MaxStackSize = 4096;
  public static final int STATUS_FORMAT_ERROR = 1;
  public static final int STATUS_OK = 0;
  public static final int STATUS_OPEN_ERROR = 2;
  protected int[] act;
  protected int bgColor;
  protected int bgIndex;
  protected byte[] block = new byte[256];
  protected int blockSize = 0;
  protected int delay = 0;
  protected int dispose = 0;
  protected int frameCount;
  protected int frameindex = 0;
  protected Vector<GifFrame> frames;
  protected int[] gct;
  protected boolean gctFlag;
  protected int gctSize;
  protected int height;
  protected int ih;
  protected Bitmap image;
  protected InputStream in;
  protected boolean interlace;
  protected int iw;
  protected int ix;
  protected int iy;
  protected int lastBgColor;
  protected int lastDispose = 0;
  protected Bitmap lastImage;
  protected int[] lct;
  protected boolean lctFlag;
  protected int lctSize;
  protected int loopCount = 1;
  protected int lrh;
  protected int lrw;
  protected int lrx;
  protected int lry;
  protected int pixelAspect;
  protected byte[] pixelStack;
  protected byte[] pixels;
  protected short[] prefix;
  protected int status;
  protected byte[] suffix;
  protected int transIndex;
  protected boolean transparency = false;
  protected int width;

  protected void decodeImageData()
  {
    int i = this.iw * this.ih;
    if ((this.pixels == null) || (this.pixels.length < i))
      this.pixels = new byte[i];
    if (this.prefix == null)
      this.prefix = new short[4096];
    if (this.suffix == null)
      this.suffix = new byte[4096];
    if (this.pixelStack == null)
      this.pixelStack = new byte[4097];
    int j = read();
    int k = 1 << j;
    int m = k + 1;
    int n = k + 2;
    int i1 = j + 1;
    int i2 = -1 + (1 << i1);
    int i3 = 0;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int i12;
    if (i3 >= k)
    {
      i4 = 0;
      i5 = 0;
      i6 = 0;
      i7 = 0;
      i8 = 0;
      i9 = 0;
      i10 = 0;
      i11 = -1;
      i12 = 0;
      label149: if (i8 < i)
        break label190;
    }
    int i30;
    label159: label190: label221: label252: int i24;
    int i25;
    int i26;
    label393: int i28;
    do
    {
      do
      {
        do
        {
          i30 = i4;
          if (i30 < i)
            break label636;
          return;
          this.prefix[i3] = 0;
          this.suffix[i3] = (byte)i3;
          i3++;
          break;
          if (i5 != 0)
            break label661;
          if (i10 >= i1)
            break label252;
          if (i9 != 0)
            break label221;
          i9 = readBlock();
        }
        while (i9 <= 0);
        i12 = 0;
        i7 += ((0xFF & this.block[i12]) << i10);
        i10 += 8;
        i12++;
        i9--;
        break label149;
        i24 = i7 & i2;
        i7 >>= i1;
        i10 -= i1;
      }
      while ((i24 > n) || (i24 == m));
      if (i24 == k)
      {
        i1 = j + 1;
        i2 = -1 + (1 << i1);
        n = k + 2;
        i11 = -1;
        break label149;
      }
      if (i11 == -1)
      {
        byte[] arrayOfByte5 = this.pixelStack;
        int i31 = i5 + 1;
        arrayOfByte5[i5] = this.suffix[i24];
        i5 = i31;
        i11 = i24;
        i6 = i24;
        break label149;
      }
      if (i24 != n)
        break label650;
      byte[] arrayOfByte4 = this.pixelStack;
      i25 = i5 + 1;
      arrayOfByte4[i5] = (byte)i6;
      i26 = i11;
      if (i26 > k)
        break label596;
      i28 = 0xFF & this.suffix[i26];
    }
    while (n >= 4096);
    byte[] arrayOfByte3 = this.pixelStack;
    int i29 = i25 + 1;
    arrayOfByte3[i25] = (byte)i28;
    this.prefix[n] = (short)i11;
    this.suffix[n] = (byte)i28;
    int i20 = n + 1;
    if (((i20 & i2) == 0) && (i20 < 4096))
    {
      i1++;
      i2 += i20;
    }
    int i18 = i7;
    int i19 = i24;
    int i13 = i2;
    int i14 = i28;
    int i15 = i10;
    int i16 = i1;
    int i17 = i29;
    while (true)
    {
      int i21 = i17 - 1;
      byte[] arrayOfByte1 = this.pixels;
      int i22 = i4 + 1;
      arrayOfByte1[i4] = this.pixelStack[i21];
      i8++;
      i4 = i22;
      i1 = i16;
      i10 = i15;
      i6 = i14;
      i2 = i13;
      int i23 = i19;
      i7 = i18;
      i5 = i21;
      n = i20;
      i11 = i23;
      break;
      label596: byte[] arrayOfByte2 = this.pixelStack;
      int i27 = i25 + 1;
      arrayOfByte2[i25] = this.suffix[i26];
      i26 = this.prefix[i26];
      i25 = i27;
      break label393;
      label636: this.pixels[i30] = 0;
      i30++;
      break label159;
      label650: i25 = i5;
      i26 = i24;
      break label393;
      label661: i13 = i2;
      i14 = i6;
      i15 = i10;
      i16 = i1;
      i17 = i5;
      i18 = i7;
      i19 = i11;
      i20 = n;
    }
  }

  protected boolean err()
  {
    return this.status != 0;
  }

  public int getDelay(int paramInt)
  {
    this.delay = -1;
    if ((paramInt >= 0) && (paramInt < this.frameCount))
      this.delay = ((GifFrame)this.frames.elementAt(paramInt)).delay;
    return this.delay;
  }

  public Bitmap getFrame(int paramInt)
  {
    Bitmap localBitmap = null;
    if (paramInt >= 0)
    {
      int i = this.frameCount;
      localBitmap = null;
      if (paramInt < i)
        localBitmap = ((GifFrame)this.frames.elementAt(paramInt)).image;
    }
    return localBitmap;
  }

  public int getFrameCount()
  {
    return this.frameCount;
  }

  public int getFrameindex()
  {
    return this.frameindex;
  }

  public int getHeigh()
  {
    return this.height;
  }

  public Bitmap getImage()
  {
    return getFrame(0);
  }

  public int getLoopCount()
  {
    return this.loopCount;
  }

  public int getWidth()
  {
    return this.width;
  }

  public void init()
  {
    this.status = 0;
    this.frameCount = 0;
    this.frames = new Vector();
    this.gct = null;
    this.lct = null;
  }

  public Bitmap nextBitmap()
  {
    this.frameindex = (1 + this.frameindex);
    if (this.frameindex > -1 + this.frames.size())
      this.frameindex = 0;
    return ((GifFrame)this.frames.elementAt(this.frameindex)).image;
  }

  public int nextDelay()
  {
    return ((GifFrame)this.frames.elementAt(this.frameindex)).delay;
  }

  protected int read()
  {
    try
    {
      int i = this.in.read();
      return i;
    }
    catch (Exception localException)
    {
      this.status = 1;
    }
    return 0;
  }

  public int read(InputStream paramInputStream)
  {
    init();
    if (paramInputStream != null)
    {
      this.in = paramInputStream;
      readHeader();
      if (!err())
      {
        readContents();
        if (this.frameCount < 0)
          this.status = 1;
      }
    }
    try
    {
      while (true)
      {
        paramInputStream.close();
        return this.status;
        this.status = 2;
      }
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  protected int readBlock()
  {
    this.blockSize = read();
    int i = this.blockSize;
    int j = 0;
    if (i > 0);
    try
    {
      while (true)
      {
        int k = this.blockSize;
        if (j >= k);
        int m;
        do
        {
          if (j < this.blockSize)
            this.status = 1;
          return j;
          m = this.in.read(this.block, j, this.blockSize - j);
        }
        while (m == -1);
        j += m;
      }
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  protected int[] readColorTable(int paramInt)
  {
    int i = 0;
    int j = paramInt * 3;
    int[] arrayOfInt = null;
    byte[] arrayOfByte = new byte[j];
    while (true)
    {
      int m;
      try
      {
        int i6 = this.in.read(arrayOfByte);
        k = i6;
        if (k >= j)
          continue;
        this.status = 1;
        return arrayOfInt;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        int k = 0;
        continue;
        arrayOfInt = new int[256];
        m = 0;
      }
      while (i < paramInt)
      {
        int n = m + 1;
        int i1 = 0xFF & arrayOfByte[m];
        int i2 = n + 1;
        int i3 = 0xFF & arrayOfByte[n];
        m = i2 + 1;
        int i4 = 0xFF & arrayOfByte[i2];
        int i5 = i + 1;
        arrayOfInt[i] = (i4 | (0xFF000000 | i1 << 16 | i3 << 8));
        i = i5;
      }
    }
  }

  protected void readContents()
  {
    int i = 0;
    while (true)
    {
      if ((i != 0) || (err()))
        return;
      switch (read())
      {
      case 0:
      default:
        this.status = 1;
        break;
      case 44:
        readImage();
        break;
      case 33:
        switch (read())
        {
        default:
          skip();
          break;
        case 249:
          readGraphicControlExt();
          break;
        case 255:
          readBlock();
          String str = "";
          for (int j = 0; ; j++)
          {
            if (j >= 11)
            {
              if (!str.equals("NETSCAPE2.0"))
                break label184;
              readNetscapeExt();
              break;
            }
            str = str + (char)this.block[j];
          }
          skip();
        }
        break;
      case 59:
        label184: i = 1;
      }
    }
  }

  protected void readGraphicControlExt()
  {
    int i = 1;
    read();
    int j = read();
    this.dispose = ((j & 0x1C) >> 2);
    if (this.dispose == 0)
      this.dispose = i;
    if ((j & 0x1) != 0);
    while (true)
    {
      this.transparency = i;
      this.delay = (10 * readShort());
      this.transIndex = read();
      read();
      return;
      i = 0;
    }
  }

  protected void readHeader()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i >= 6)
    {
      if (localStringBuffer.toString().startsWith("GIF"))
        break label50;
      this.status = 1;
    }
    label50: 
    do
    {
      return;
      localStringBuffer.append((char)read());
      i++;
      break;
      readLSD();
    }
    while ((!this.gctFlag) || (err()));
    this.gct = readColorTable(this.gctSize);
    this.bgColor = this.gct[this.bgIndex];
  }

  protected void readImage()
  {
    this.ix = readShort();
    this.iy = readShort();
    this.iw = readShort();
    this.ih = readShort();
    int i = read();
    boolean bool1;
    boolean bool2;
    label61: label103: int j;
    if ((i & 0x80) != 0)
    {
      bool1 = true;
      this.lctFlag = bool1;
      if ((i & 0x40) == 0)
        break label167;
      bool2 = true;
      this.interlace = bool2;
      this.lctSize = (2 << (i & 0x7));
      if (!this.lctFlag)
        break label172;
      this.lct = readColorTable(this.lctSize);
      this.act = this.lct;
      boolean bool3 = this.transparency;
      j = 0;
      if (bool3)
      {
        int k = this.act[this.transIndex];
        this.act[this.transIndex] = 0;
        j = k;
      }
      if (this.act == null)
        this.status = 1;
      if (!err())
        break label199;
    }
    label167: label172: label199: 
    do
    {
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label61;
      this.act = this.gct;
      if (this.bgIndex != this.transIndex)
        break label103;
      this.bgColor = 0;
      break label103;
      decodeImageData();
      skip();
    }
    while (err());
    this.frameCount = (1 + this.frameCount);
    this.image = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_4444);
    setPixels();
    this.frames.addElement(new GifFrame(this.image, this.delay));
    if (this.transparency)
      this.act[this.transIndex] = j;
    resetFrame();
  }

  protected void readLSD()
  {
    this.width = readShort();
    this.height = readShort();
    int i = read();
    if ((i & 0x80) != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.gctFlag = bool;
      this.gctSize = (2 << (i & 0x7));
      this.bgIndex = read();
      this.pixelAspect = read();
      return;
    }
  }

  protected void readNetscapeExt()
  {
    do
    {
      readBlock();
      if (this.block[0] != 1)
        continue;
      this.loopCount = (0xFF & this.block[1] | (0xFF & this.block[2]) << 8);
    }
    while ((this.blockSize > 0) && (!err()));
  }

  protected int readShort()
  {
    return read() | read() << 8;
  }

  protected void resetFrame()
  {
    this.lastDispose = this.dispose;
    this.lrx = this.ix;
    this.lry = this.iy;
    this.lrw = this.iw;
    this.lrh = this.ih;
    this.lastImage = this.image;
    this.lastBgColor = this.bgColor;
    this.dispose = 0;
    this.transparency = false;
    this.delay = 0;
    this.lct = null;
  }

  public void setFrameindex(int paramInt)
  {
    this.frameindex = paramInt;
    if (paramInt > -1 + this.frames.size());
  }

  protected void setPixels()
  {
    int i = 0;
    int[] arrayOfInt = new int[this.width * this.height];
    if (this.lastDispose > 0)
    {
      if (this.lastDispose == 3)
      {
        int i16 = -2 + this.frameCount;
        if (i16 <= 0)
          break label155;
        this.lastImage = getFrame(i16 - 1);
      }
      if (this.lastImage != null)
      {
        this.lastImage.getPixels(arrayOfInt, 0, this.width, 0, 0, this.width, this.height);
        if (this.lastDispose == 2)
          if (this.transparency)
            break label454;
      }
    }
    label155: label454: for (int i12 = this.lastBgColor; ; i12 = 0)
    {
      int i13 = 0;
      int j;
      int k;
      int m;
      int i14;
      int i15;
      if (i13 >= this.lrh)
      {
        j = 8;
        k = 1;
        m = 0;
        if (i >= this.ih)
        {
          this.image = Bitmap.createBitmap(arrayOfInt, this.width, this.height, Bitmap.Config.ARGB_4444);
          return;
          this.lastImage = null;
          break;
        }
      }
      else
      {
        i14 = (i13 + this.lry) * this.width + this.lrx;
        i15 = i14 + this.lrw;
        while (true)
        {
          if (i14 >= i15)
          {
            i13++;
            break;
          }
          arrayOfInt[i14] = i12;
          i14++;
        }
      }
      int i11;
      if (this.interlace)
      {
        if (m >= this.ih)
          k++;
        switch (k)
        {
        default:
          int i10 = m + j;
          i11 = m;
          m = i10;
        case 2:
        case 3:
        case 4:
        }
      }
      for (int n = i11; ; n = i)
      {
        int i1 = n + this.iy;
        int i4;
        int i5;
        int i6;
        if (i1 < this.height)
        {
          int i2 = i1 * this.width;
          int i3 = i2 + this.ix;
          i4 = i3 + this.iw;
          if (i2 + this.width < i4)
            i4 = i2 + this.width;
          i5 = i * this.iw;
          i6 = i3;
        }
        while (true)
        {
          if (i6 >= i4)
          {
            i++;
            break;
            m = 4;
            break label264;
            m = 2;
            j = 4;
            break label264;
            m = 1;
            j = 2;
            break label264;
          }
          byte[] arrayOfByte = this.pixels;
          int i7 = i5 + 1;
          int i8 = 0xFF & arrayOfByte[i5];
          int i9 = this.act[i8];
          if (i9 != 0)
            arrayOfInt[i6] = i9;
          i6++;
          i5 = i7;
        }
      }
    }
  }

  protected void skip()
  {
    do
      readBlock();
    while ((this.blockSize > 0) && (!err()));
  }

  private class GifFrame
  {
    public int delay;
    public Bitmap image;

    public GifFrame(Bitmap paramInt, int arg3)
    {
      this.image = paramInt;
      int i;
      this.delay = i;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.chat.gif.GifHelper
 * JD-Core Version:    0.6.0
 */