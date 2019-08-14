package com.withustudy.koudaizikao.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.http.e;
import com.withustudy.koudaizikao.activity.PostDetailActivity.b;

public class AddImageView extends RelativeLayout
{
  private Context a;
  private int b;
  private ImageView c;
  private ImageView d;
  private boolean e;
  private Handler f;
  private a g;

  public AddImageView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }

  public AddImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }

  public AddImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }

  @TargetApi(21)
  public AddImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.a = paramContext;
    a();
  }

  private void a()
  {
    this.g = new a();
    View localView = LayoutInflater.from(this.a).inflate(2130903134, null);
    this.c = ((ImageView)localView.findViewById(2131296879));
    this.d = ((ImageView)localView.findViewById(2131296880));
    this.c.setOnClickListener(this.g);
    this.d.setOnClickListener(this.g);
    this.e = false;
    addView(localView);
  }

  public void a(boolean paramBoolean)
  {
    this.c.setImageBitmap(null);
    this.c.setBackgroundResource(2130837678);
    this.e = false;
    if (paramBoolean)
      setVisibility(8);
    this.d.setVisibility(8);
  }

  public void setDeleteVisibility(int paramInt)
  {
    this.d.setVisibility(paramInt);
  }

  public void setImage(Bitmap paramBitmap)
  {
    this.e = true;
    this.c.setImageBitmap(paramBitmap);
  }

  public void setImage(String paramString)
  {
    this.e = true;
    e.a(this.a).b("file://" + paramString, this.c);
  }

  public void setIndex(int paramInt)
  {
    this.b = paramInt;
  }

  public void setmHandler(Handler paramHandler)
  {
    this.f = paramHandler;
  }

  class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      default:
        return;
      case 2131296879:
        if (AddImageView.a(AddImageView.this))
        {
          if ((AddImageView.b(AddImageView.this) instanceof PostDetailActivity.b));
          for (Message localMessage3 = AddImageView.b(AddImageView.this).obtainMessage(17, Integer.valueOf(AddImageView.c(AddImageView.this))); ; localMessage3 = AddImageView.b(AddImageView.this).obtainMessage(6, Integer.valueOf(AddImageView.c(AddImageView.this))))
          {
            AddImageView.b(AddImageView.this).sendMessage(localMessage3);
            return;
          }
        }
        if ((AddImageView.b(AddImageView.this) instanceof PostDetailActivity.b));
        for (Message localMessage2 = AddImageView.b(AddImageView.this).obtainMessage(6, Integer.valueOf(AddImageView.c(AddImageView.this))); ; localMessage2 = AddImageView.b(AddImageView.this).obtainMessage(3, Integer.valueOf(AddImageView.c(AddImageView.this))))
        {
          AddImageView.b(AddImageView.this).sendMessage(localMessage2);
          return;
        }
      case 2131296880:
      }
      if ((AddImageView.b(AddImageView.this) instanceof PostDetailActivity.b));
      for (Message localMessage1 = AddImageView.b(AddImageView.this).obtainMessage(5, Integer.valueOf(AddImageView.c(AddImageView.this))); ; localMessage1 = AddImageView.b(AddImageView.this).obtainMessage(2, Integer.valueOf(AddImageView.c(AddImageView.this))))
      {
        AddImageView.b(AddImageView.this).sendMessage(localMessage1);
        return;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.AddImageView
 * JD-Core Version:    0.6.0
 */