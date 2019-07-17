package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.http.e;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Forum;
import com.withustudy.koudaizikao.entity.Post;
import com.withustudy.koudaizikao.g.b;
import java.util.List;

public class c extends BaseAdapter
{
  private static final int e = 0;
  private static final int f = 1;
  private Context a;
  private List<Forum> b;
  private List<Post> c;
  private int d;

  public c(Context paramContext, int paramInt)
  {
    this.a = paramContext;
    this.d = paramInt;
  }

  public List<Forum> a()
  {
    return this.b;
  }

  public void a(List<Forum> paramList)
  {
    this.b = paramList;
  }

  public List<Post> b()
  {
    return this.c;
  }

  public void b(List<Post> paramList)
  {
    this.c = paramList;
  }

  public int getCount()
  {
    if (this.d == 0)
      return this.c.size();
    return this.b.size();
  }

  public Object getItem(int paramInt)
  {
    if (this.d == 0)
      return this.c.get(paramInt);
    return this.b.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if (this.d == 0)
      return 0;
    return 1;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    int i = getItemViewType(paramInt);
    a locala;
    if (paramView == null)
      switch (i)
      {
      default:
        locala = null;
      case 0:
      case 1:
      }
    while (true)
      switch (i)
      {
      default:
        return paramView;
        locala = new a();
        paramView = LayoutInflater.from(this.a).inflate(2130903188, null);
        locala.a = ((TextView)paramView.findViewById(2131297188));
        locala.b = ((TextView)paramView.findViewById(2131297189));
        locala.c = ((TextView)paramView.findViewById(2131297190));
        locala.d = ((TextView)paramView.findViewById(2131297191));
        paramView.setTag(locala);
        localObject = null;
        continue;
        b localb = new b();
        paramView = LayoutInflater.from(this.a).inflate(2130903189, null);
        localb.a = ((ImageView)paramView.findViewById(2131297192));
        localb.b = ((TextView)paramView.findViewById(2131297193));
        localb.c = ((TextView)paramView.findViewById(2131297195));
        localb.d = ((TextView)paramView.findViewById(2131297194));
        localb.e = ((TextView)paramView.findViewById(2131297196));
        paramView.setTag(localb);
        localObject = localb;
        locala = null;
        continue;
        switch (i)
        {
        default:
          localObject = null;
          locala = null;
          break;
        case 0:
          locala = (a)paramView.getTag();
          localObject = null;
          break;
        case 1:
          localObject = (b)paramView.getTag();
          locala = null;
        }
      case 0:
      case 1:
      }
    locala.a.setText(String.valueOf(paramInt + 1));
    locala.b.setText(((Post)this.c.get(paramInt)).getTopic_title());
    locala.c.setText("来自：" + ((Post)this.c.get(paramInt)).getForum_name());
    locala.d.setText("浏览：" + ((Post)this.c.get(paramInt)).getTopic_views());
    return paramView;
    if ((((Forum)this.b.get(paramInt)).getForum_img() != null) && (!((Forum)this.b.get(paramInt)).getForum_img().equals("")))
    {
      e.a(this.a).a(((Forum)this.b.get(paramInt)).getForum_img(), ((b)localObject).a);
      ((b)localObject).b.setText(((Forum)this.b.get(paramInt)).getForum_name());
      ((b)localObject).c.setText(((Forum)this.b.get(paramInt)).getForum_desc());
      if (f.a(this.a).i().equals(""))
        break label711;
      ((b)localObject).d.setVisibility(0);
      if (((Forum)this.b.get(paramInt)).getForum_isfollow() != 1)
        break label688;
      ((b)localObject).d.setText(this.a.getResources().getString(2131165494));
    }
    while (true)
    {
      ((b)localObject).e.setText(b.b(this.a, ((Forum)this.b.get(paramInt)).getForum_last_post_date()));
      return paramView;
      ((b)localObject).a.setImageResource(2130837869);
      break;
      label688: ((b)localObject).d.setText(this.a.getResources().getString(2131165495));
      continue;
      label711: ((b)localObject).d.setVisibility(8);
    }
  }

  public int getViewTypeCount()
  {
    return 2;
  }

  class a
  {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;

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

    b()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.c
 * JD-Core Version:    0.6.0
 */