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

public class t extends BaseAdapter
{
  private Context a;
  private List<Post> b;
  private Handler c;

  public t(Context paramContext, List<Post> paramList, Handler paramHandler)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramHandler;
  }

  private void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    paramImageView.setImageResource(2131034185);
    e.a(this.a).a((String)((Post)this.b.get(paramInt2)).getPost_files().get(paramInt1), paramImageView);
    paramImageView.setVisibility(0);
    paramImageView.setOnClickListener(new v(this, paramInt1, paramInt2));
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

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    a locala;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130903193, null);
      locala = new a();
      locala.a = ((ImageView)paramView.findViewById(2131297243));
      locala.b = ((TextView)paramView.findViewById(2131297244));
      locala.c = ((TextView)paramView.findViewById(2131297245));
      locala.d = ((TextView)paramView.findViewById(2131297246));
      locala.e = ((TextView)paramView.findViewById(2131297248));
      locala.f = ((ImageView)paramView.findViewById(2131297247));
      locala.g = ((TextView)paramView.findViewById(2131297249));
      locala.h = ((TableLayout)paramView.findViewById(2131297250));
      locala.i = new LinearLayout[3];
      locala.i[0] = ((LinearLayout)paramView.findViewById(2131297251));
      locala.i[1] = ((LinearLayout)paramView.findViewById(2131297255));
      locala.i[2] = ((LinearLayout)paramView.findViewById(2131297259));
      locala.j = new ImageView[9];
      locala.j[0] = ((ImageView)paramView.findViewById(2131297252));
      locala.j[1] = ((ImageView)paramView.findViewById(2131297253));
      locala.j[2] = ((ImageView)paramView.findViewById(2131297254));
      locala.j[3] = ((ImageView)paramView.findViewById(2131297256));
      locala.j[4] = ((ImageView)paramView.findViewById(2131297257));
      locala.j[5] = ((ImageView)paramView.findViewById(2131297258));
      locala.j[6] = ((ImageView)paramView.findViewById(2131297260));
      locala.j[7] = ((ImageView)paramView.findViewById(2131297261));
      locala.j[8] = ((ImageView)paramView.findViewById(2131297262));
      locala.k = ((TextView)paramView.findViewById(2131297263));
      locala.l = ((TextView)paramView.findViewById(2131297264));
      locala.m = ((TextView)paramView.findViewById(2131297265));
      paramView.setTag(locala);
      if (((Post)this.b.get(paramInt)).getNew_reply_num() == 0)
        break label805;
      locala.f.setVisibility(0);
      label433: if ((((Post)this.b.get(paramInt)).getUser_headimg() != null) && (!((Post)this.b.get(paramInt)).getUser_headimg().equals("")))
        e.a(this.a).a(((Post)this.b.get(paramInt)).getUser_headimg(), locala.a, 1000);
      locala.b.setText(((Post)this.b.get(paramInt)).getUser_name());
      locala.c.setText(b.b(this.a, ((Post)this.b.get(paramInt)).getTopic_time()));
      if (((Post)this.b.get(paramInt)).getTopic_level() != 1)
        break label817;
      locala.d.setVisibility(0);
      label594: locala.e.setText(((Post)this.b.get(paramInt)).getTopic_title());
      locala.g.setText(((Post)this.b.get(paramInt)).getTopic_sub_desc());
      if (((Post)this.b.get(paramInt)).getPost_img_count() == 0)
        break label923;
      a(locala.h, locala.i, ((Post)this.b.get(paramInt)).getPost_img_count(), 48);
      if (i < 9)
        break label830;
    }
    while (true)
    {
      locala.k.setText(((Post)this.b.get(paramInt)).getPost_area());
      locala.l.setText(String.valueOf(((Post)this.b.get(paramInt)).getTopic_praise()));
      locala.m.setText(String.valueOf(((Post)this.b.get(paramInt)).getTopic_replies()));
      paramView.setOnClickListener(new u(this, paramInt));
      return paramView;
      locala = (a)paramView.getTag();
      break;
      label805: locala.f.setVisibility(4);
      break label433;
      label817: locala.d.setVisibility(8);
      break label594;
      label830: if (i < ((Post)this.b.get(paramInt)).getPost_img_count())
        a(locala.j[i], i, paramInt);
      while (true)
      {
        i++;
        break;
        if (((Post)this.b.get(paramInt)).getPost_img_count() == 2)
        {
          locala.j[i].setVisibility(8);
          continue;
        }
        locala.j[i].setVisibility(4);
      }
      label923: locala.h.setVisibility(8);
      for (int j = 0; j < 9; j++)
      {
        if (j < 3)
          locala.i[j].setVisibility(8);
        locala.j[j].setVisibility(8);
      }
    }
  }

  class a
  {
    public ImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public ImageView f;
    public TextView g;
    public TableLayout h;
    public LinearLayout[] i;
    public ImageView[] j;
    public TextView k;
    public TextView l;
    public TextView m;

    a()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.t
 * JD-Core Version:    0.6.0
 */