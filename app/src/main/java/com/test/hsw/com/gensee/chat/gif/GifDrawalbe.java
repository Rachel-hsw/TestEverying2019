package com.gensee.chat.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GifDrawalbe extends AnimationDrawable
{
  private static final int READ_FRAME = 1000;
  public static double ration = 1.333333333333333D;
  private AtomicBoolean bParsing = new AtomicBoolean(false);
  private Context context;
  private Handler handler = new Handler(new GifDrawalbe.1(this));
  GifHelper helper;
  private int resId;
  private List<UpdateUIListen> updateUIListenList;

  public GifDrawalbe(Context paramContext, int paramInt)
  {
    this.resId = paramInt;
    this.context = paramContext;
    this.bParsing.set(false);
    this.updateUIListenList = new ArrayList();
    setOneShot(false);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramContext.getResources(), paramInt, localOptions);
    setBounds(0, 0, (int)(localOptions.outWidth * ration), (int)(localOptions.outHeight * ration));
    invalidateSelf();
  }

  private void parseFrame()
  {
    int i = 1;
    monitorenter;
    while (true)
    {
      GifHelper localGifHelper;
      try
      {
        if (this.bParsing.get())
          continue;
        localGifHelper = new GifHelper();
        localGifHelper.read(this.context.getResources().openRawResource(this.resId));
        if (localGifHelper.getFrameCount() > 0)
          continue;
        this.bParsing.set(false);
        return;
        addFrame(new BitmapDrawable(this.context.getResources(), localGifHelper.getImage()), localGifHelper.getDelay(0));
        if (i >= localGifHelper.getFrameCount())
        {
          this.bParsing.set(true);
          return;
        }
      }
      finally
      {
        monitorexit;
      }
      addFrame(new BitmapDrawable(null, localGifHelper.nextBitmap()), localGifHelper.getDelay(i));
      i++;
    }
  }

  public void addListen(UpdateUIListen paramUpdateUIListen)
  {
    monitorenter;
    try
    {
      if (!this.updateUIListenList.contains(paramUpdateUIListen))
        this.updateUIListenList.add(paramUpdateUIListen);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean isParsing()
  {
    return this.bParsing.get();
  }

  public void readFrames(boolean paramBoolean)
  {
    if (!this.bParsing.get())
      parseFrame();
    if (paramBoolean)
      start();
  }

  public void removeListen(UpdateUIListen paramUpdateUIListen)
  {
    monitorenter;
    try
    {
      this.updateUIListenList.remove(paramUpdateUIListen);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void run()
  {
    super.run();
    invalidateSelf();
    monitorenter;
    try
    {
      Iterator localIterator = this.updateUIListenList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return;
        ((UpdateUIListen)localIterator.next()).updateUI();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    monitorenter;
    try
    {
      if (this.updateUIListenList.size() <= 0)
      {
        stop();
        return;
      }
      monitorexit;
      this.handler.postAtTime(paramRunnable, paramLong);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static abstract interface UpdateUIListen
  {
    public abstract void updateUI();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.chat.gif.GifDrawalbe
 * JD-Core Version:    0.6.0
 */