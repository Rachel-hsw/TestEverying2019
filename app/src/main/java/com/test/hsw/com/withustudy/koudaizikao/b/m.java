package com.withustudy.koudaizikao.b;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import com.withustudy.koudaizikao.entity.LocalImage;
import java.util.List;

class m
  implements View.OnClickListener
{
  m(l paraml, int paramInt, ImageView paramImageView1, ImageView paramImageView2)
  {
  }

  public void onClick(View paramView)
  {
    if (((LocalImage)l.a(this.a).get(this.b)).isChoose())
    {
      this.c.setImageResource(2130837868);
      this.d.setVisibility(8);
      ((LocalImage)l.a(this.a).get(this.b)).setChoose(false);
      l.b(this.a).sendMessage(l.b(this.a).obtainMessage(6, ((LocalImage)l.a(this.a).get(this.b)).getPath()));
      l locall2 = this.a;
      l.a(locall2, -1 + l.c(locall2));
      return;
    }
    if (l.c(this.a) == 9)
    {
      Toast.makeText(l.d(this.a), "已经达到上限了哦~", 0).show();
      return;
    }
    this.c.setImageResource(2130837867);
    this.d.setVisibility(0);
    ((LocalImage)l.a(this.a).get(this.b)).setChoose(true);
    l.b(this.a).sendMessage(l.b(this.a).obtainMessage(5, ((LocalImage)l.a(this.a).get(this.b)).getPath()));
    l locall1 = this.a;
    l.a(locall1, 1 + l.c(locall1));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.m
 * JD-Core Version:    0.6.0
 */