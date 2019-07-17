package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TextView;
import com.android.http.e;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Post;
import com.withustudy.koudaizikao.g.b;
import java.util.List;

public class ab extends BaseAdapter
{
  private static final int e = 0;
  private static final int f = 1;
  private Context a;
  private List<Post> b;
  private int c;
  private Handler d;

  public ab(Context paramContext, int paramInt, List<Post> paramList, Handler paramHandler)
  {
    this.a = paramContext;
    this.c = paramInt;
    this.b = paramList;
    this.d = paramHandler;
  }

  private void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    paramImageView.setImageResource(2131034185);
    e.a(this.a).a(((String)((Post)this.b.get(paramInt2)).getPost_files().get(paramInt1)).split(";")[0], paramImageView);
    paramImageView.setVisibility(0);
    paramImageView.setOnClickListener(new ad(this, paramInt1, paramInt2));
  }

  private void a(TableLayout paramTableLayout, LinearLayout[] paramArrayOfLinearLayout, int paramInt1, int paramInt2)
  {
    paramTableLayout.setVisibility(0);
    int i = f.a(this.a).y() - (int)(paramInt2 * f.a(this.a).z() / 160.0F);
    LinearLayout.LayoutParams localLayoutParams;
    if (paramInt1 <= 3)
    {
      paramArrayOfLinearLayout[0].setVisibility(0);
      paramArrayOfLinearLayout[1].setVisibility(8);
      paramArrayOfLinearLayout[2].setVisibility(8);
      localLayoutParams = new LinearLayout.LayoutParams(i, 30 + i / 3);
    }
    while (true)
    {
      localLayoutParams.setMargins(24, 0, 0, 0);
      paramTableLayout.setLayoutParams(localLayoutParams);
      return;
      if ((paramInt1 > 3) && (paramInt1 <= 6))
      {
        paramArrayOfLinearLayout[0].setVisibility(0);
        paramArrayOfLinearLayout[1].setVisibility(0);
        paramArrayOfLinearLayout[2].setVisibility(8);
        localLayoutParams = new LinearLayout.LayoutParams(i, 30 + 2 * (i / 3));
        continue;
      }
      paramArrayOfLinearLayout[0].setVisibility(0);
      paramArrayOfLinearLayout[1].setVisibility(0);
      paramArrayOfLinearLayout[2].setVisibility(0);
      localLayoutParams = new LinearLayout.LayoutParams(i, i + 35);
    }
  }

  public int getCount()
  {
    return this.b.size();
  }

  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.c)
      return 0;
    return 1;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = null;
    int i = 0;
    int j = getItemViewType(paramInt);
    Object localObject2;
    if (paramView == null)
      switch (j)
      {
      default:
        localObject2 = null;
      case 0:
      case 1:
      }
    while (true)
    {
      paramView.setOnClickListener(new ac(this, paramInt));
      switch (j)
      {
      default:
        return paramView;
        paramView = LayoutInflater.from(this.a).inflate(2130903192, null);
        a locala = new a();
        locala.a = ((TextView)paramView.findViewById(2131297242));
        paramView.setTag(locala);
        localObject2 = locala;
        localObject1 = null;
        continue;
        paramView = LayoutInflater.from(this.a).inflate(2130903193, null);
        b localb = new b();
        localb.a = ((ImageView)paramView.findViewById(2131297243));
        localb.b = ((TextView)paramView.findViewById(2131297244));
        localb.c = ((TextView)paramView.findViewById(2131297245));
        localb.d = ((TextView)paramView.findViewById(2131297246));
        localb.e = ((TextView)paramView.findViewById(2131297248));
        localb.f = ((TextView)paramView.findViewById(2131297249));
        localb.g = ((TableLayout)paramView.findViewById(2131297250));
        localb.h = new LinearLayout[3];
        localb.h[0] = ((LinearLayout)paramView.findViewById(2131297251));
        localb.h[1] = ((LinearLayout)paramView.findViewById(2131297255));
        localb.h[2] = ((LinearLayout)paramView.findViewById(2131297259));
        localb.i = new ImageView[9];
        localb.i[0] = ((ImageView)paramView.findViewById(2131297252));
        localb.i[1] = ((ImageView)paramView.findViewById(2131297253));
        localb.i[2] = ((ImageView)paramView.findViewById(2131297254));
        localb.i[3] = ((ImageView)paramView.findViewById(2131297256));
        localb.i[4] = ((ImageView)paramView.findViewById(2131297257));
        localb.i[5] = ((ImageView)paramView.findViewById(2131297258));
        localb.i[6] = ((ImageView)paramView.findViewById(2131297260));
        localb.i[7] = ((ImageView)paramView.findViewById(2131297261));
        localb.i[8] = ((ImageView)paramView.findViewById(2131297262));
        localb.j = ((TextView)paramView.findViewById(2131297263));
        localb.k = ((TextView)paramView.findViewById(2131297264));
        localb.l = ((TextView)paramView.findViewById(2131297265));
        paramView.setTag(localb);
        localObject1 = localb;
        localObject2 = null;
        continue;
        switch (j)
        {
        default:
          localObject2 = null;
          localObject1 = null;
          break;
        case 0:
          localObject2 = (a)paramView.getTag();
          localObject1 = null;
          break;
        case 1:
          localObject1 = (b)paramView.getTag();
          localObject2 = null;
        }
      case 0:
      case 1:
      }
    }
    ((a)localObject2).a.setText(((Post)this.b.get(paramInt)).getTopic_title());
    return paramView;
    ((b)localObject1).a.setTag(Integer.valueOf(paramInt));
    if ((((Post)this.b.get(paramInt)).getUser_headimg() != null) && (!((Post)this.b.get(paramInt)).getUser_headimg().equals("")))
    {
      e.a(this.a).c(((Post)this.b.get(paramInt)).getUser_headimg(), ((b)localObject1).a, paramInt);
      ((b)localObject1).b.setText(((Post)this.b.get(paramInt)).getUser_name());
      ((b)localObject1).c.setText(b.b(this.a, ((Post)this.b.get(paramInt)).getLast_modify_time()) + "回复");
      if (((Post)this.b.get(paramInt)).getTopic_level() != 1)
        break label1011;
      ((b)localObject1).d.setVisibility(0);
      label811: ((b)localObject1).e.setText(((Post)this.b.get(paramInt)).getTopic_title());
      ((b)localObject1).f.setText(((Post)this.b.get(paramInt)).getTopic_sub_desc());
      if (((Post)this.b.get(paramInt)).getPost_img_count() == 0)
        break label1117;
      a(((b)localObject1).g, ((b)localObject1).h, ((Post)this.b.get(paramInt)).getPost_img_count(), 48);
      if (i < 9)
        break label1024;
    }
    while (true)
    {
      ((b)localObject1).j.setText(((Post)this.b.get(paramInt)).getPost_area());
      ((b)localObject1).k.setText(String.valueOf(((Post)this.b.get(paramInt)).getTopic_praise()));
      ((b)localObject1).l.setText(String.valueOf(((Post)this.b.get(paramInt)).getTopic_replies()));
      return paramView;
      ((b)localObject1).a.setImageResource(2130837862);
      break;
      label1011: ((b)localObject1).d.setVisibility(8);
      break label811;
      label1024: if (i < ((Post)this.b.get(paramInt)).getPost_img_count())
        a(localObject1.i[i], i, paramInt);
      while (true)
      {
        i++;
        break;
        if (((Post)this.b.get(paramInt)).getPost_img_count() == 2)
        {
          localObject1.i[i].setVisibility(8);
          continue;
        }
        localObject1.i[i].setVisibility(4);
      }
      label1117: ((b)localObject1).g.setVisibility(8);
      for (int k = 0; k < 9; k++)
      {
        if (k < 3)
          localObject1.h[k].setVisibility(8);
        localObject1.i[k].setVisibility(8);
      }
    }
  }

  public int getViewTypeCount()
  {
    return 2;
  }

  class a
  {
    public TextView a;

    a()
    {
    }
  }

  class b
  {
    public ImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TableLayout g;
    public LinearLayout[] h;
    public ImageView[] i;
    public TextView j;
    public TextView k;
    public TextView l;

    b()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.ab
 * JD-Core Version:    0.6.0
 */