package com.gensee.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class VoteProgressBar extends ProgressBar
{
  private Paint paint;
  private String text;

  public VoteProgressBar(Context paramContext)
  {
    super(paramContext);
    initText();
  }

  public VoteProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initText();
  }

  public VoteProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initText();
  }

  private void initText()
  {
    this.paint = new Paint();
    this.paint.setColor(-1);
  }

  private void setText(int paramInt)
  {
    int i = getMax();
    int j = 0;
    if (i > 0)
      j = (int)(100.0F * (1.0F * paramInt / getMax()));
    this.text = (String.valueOf(j) + "%");
  }

  protected void onDraw(Canvas paramCanvas)
  {
    monitorenter;
    try
    {
      super.onDraw(paramCanvas);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void setProgress(int paramInt)
  {
    monitorenter;
    try
    {
      setText(paramInt);
      super.setProgress(paramInt);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.VoteProgressBar
 * JD-Core Version:    0.6.0
 */