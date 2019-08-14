package com.withustudy.koudaizikao.g;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class l
{
  private static l a;
  private a b;

  private l(Context paramContext, int paramInt)
  {
    this.b = new a(paramContext, paramInt);
  }

  public static l a(Context paramContext)
  {
    a = new l(paramContext, 2131231023);
    return a;
  }

  public void a()
  {
    this.b.setCancelable(true);
    this.b.show();
  }

  public void a(int paramInt)
  {
    this.b.setCancelable(true);
    this.b.show();
    this.b.a(paramInt);
  }

  public void a(String paramString)
  {
    this.b.setCancelable(true);
    this.b.show();
    this.b.a(paramString);
  }

  public void a(String paramString, boolean paramBoolean)
  {
    this.b.setCancelable(paramBoolean);
    this.b.show();
    this.b.a(paramString);
  }

  public void a(boolean paramBoolean)
  {
    this.b.setCancelable(paramBoolean);
    this.b.show();
  }

  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.b.setCancelable(paramBoolean);
    this.b.show();
    this.b.a(paramString);
    this.b.a(paramInt);
  }

  public void b()
  {
    try
    {
      if ((this.b != null) && (this.b.isShowing()))
        this.b.dismiss();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
  }

  private class a extends ProgressDialog
  {
    private ImageView b;
    private TextView c;
    private AnimationDrawable d;

    public a(Context arg2)
    {
      super();
    }

    public a(Context paramInt, int arg3)
    {
      super(i);
    }

    public void a(int paramInt)
    {
      this.c.setTextColor(paramInt);
    }

    public void a(String paramString)
    {
      this.c.setText(paramString);
    }

    public void dismiss()
    {
      super.dismiss();
      if (this.d.isRunning())
        this.d.stop();
    }

    protected void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      View localView = LayoutInflater.from(getContext()).inflate(2130903141, null);
      this.b = ((ImageView)localView.findViewById(2131296914));
      this.b.setImageResource(2130837572);
      this.d = ((AnimationDrawable)this.b.getDrawable());
      this.c = ((TextView)localView.findViewById(2131296915));
      setContentView(localView);
    }

    public void show()
    {
      super.show();
      if (this.d.isRunning())
        this.d.stop();
      this.d.start();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.g.l
 * JD-Core Version:    0.6.0
 */