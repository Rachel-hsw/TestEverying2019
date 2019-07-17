package com.gensee.swf;

public class SwfPlayer
{
  private long naitvePlayer;
  private long nativeSink;

  static
  {
    try
    {
      System.loadLibrary("stlport_shared");
      System.loadLibrary("uctinyxml");
      System.loadLibrary("ucjpeg");
      System.loadLibrary("SwfView");
      System.loadLibrary("android-swfplayer");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public native void callOnTimer();

  public native void closeFile();

  public native int createSwfPlayer(Object paramObject);

  public native void destorySwfPlayer();

  public native void displayZoomBegin(float paramFloat1, float paramFloat2);

  public native void displayZoomLoop(float paramFloat);

  public native void draw();

  public native void enableBitmapFont(boolean paramBoolean);

  public native boolean freeRender();

  public native int getDisplayMode();

  public native float getDisplayRate();

  public native int getFrameCount();

  public native int getOffsetMaxX();

  public native int getOffsetMaxY();

  public native int getOffsetMinX();

  public native int getOffsetMinY();

  public native int getOffsetX();

  public native int getOffsetY();

  public native void gotoAnimation(int paramInt, boolean paramBoolean);

  public native void gotoFrame(float paramFloat);

  public native boolean initRender();

  public native boolean isFileLoad();

  public native boolean openFile(String paramString1, String paramString2, int paramInt);

  public native boolean openFileData(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3);

  public native void setBkColor(int paramInt1, int paramInt2, int paramInt3);

  public native void setDisplayMode(int paramInt);

  public native void setOffset(int paramInt1, int paramInt2);

  public native void setViewPort(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.swf.SwfPlayer
 * JD-Core Version:    0.6.0
 */