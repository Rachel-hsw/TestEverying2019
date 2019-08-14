package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.withustudy.koudaizikao.entity.Video;
import com.withustudy.koudaizikao.entity.VideoChapter;
import com.withustudy.koudaizikao.entity.VideoSection;
import com.withustudy.koudaizikao.entity.local.VideoTapeLevel;
import com.withustudy.koudaizikao.g.p;
import java.util.List;

public class ao extends BaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private Context e;
  private List<VideoTapeLevel> f;
  private List<VideoTapeLevel> g;
  private a h;

  public ao(List<VideoChapter> paramList, Context paramContext)
  {
    this.e = paramContext;
    this.h = new a();
    this.f = p.a(paramList);
    this.g = p.b(this.f);
  }

  public int getCount()
  {
    return this.g.size();
  }

  public Object getItem(int paramInt)
  {
    return this.g.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if (((VideoTapeLevel)this.g.get(paramInt)).getLevel().length == 1)
      return 0;
    if (((VideoTapeLevel)this.g.get(paramInt)).getLevel().length == 3)
      return 3;
    if ((((VideoTapeLevel)this.g.get(paramInt)).getData() instanceof VideoSection))
      return 1;
    return 2;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = null;
    int i = getItemViewType(paramInt);
    d locald;
    Object localObject2;
    Object localObject3;
    if (paramView == null)
      switch (i)
      {
      default:
        locald = null;
        localObject2 = null;
        localObject3 = null;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    while (true)
      switch (i)
      {
      default:
        return paramView;
        paramView = LayoutInflater.from(this.e).inflate(2130903219, null);
        b localb = new b();
        localb.a = ((LinearLayout)paramView.findViewById(2131297377));
        localb.b = ((TextView)paramView.findViewById(2131297378));
        localb.c = ((Button)paramView.findViewById(2131297379));
        paramView.setTag(localb);
        localObject3 = localb;
        localObject1 = null;
        locald = null;
        localObject2 = null;
        continue;
        paramView = LayoutInflater.from(this.e).inflate(2130903220, null);
        c localc = new c();
        localc.a = ((LinearLayout)paramView.findViewById(2131297380));
        localc.b = ((TextView)paramView.findViewById(2131297381));
        localc.c = ((Button)paramView.findViewById(2131297382));
        paramView.setTag(localc);
        localObject2 = localc;
        localObject1 = null;
        locald = null;
        localObject3 = null;
        continue;
        paramView = LayoutInflater.from(this.e).inflate(2130903221, null);
        locald = new d();
        locald.a = ((TextView)paramView.findViewById(2131297383));
        locald.b = ((TextView)paramView.findViewById(2131297384));
        paramView.setTag(locald);
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        continue;
        paramView = LayoutInflater.from(this.e).inflate(2130903222, null);
        e locale = new e();
        locale.a = ((TextView)paramView.findViewById(2131297385));
        locale.b = ((TextView)paramView.findViewById(2131297386));
        paramView.setTag(locale);
        localObject1 = locale;
        locald = null;
        localObject2 = null;
        localObject3 = null;
        continue;
        switch (i)
        {
        default:
          localObject1 = null;
          locald = null;
          localObject2 = null;
          localObject3 = null;
          break;
        case 0:
          localObject3 = (b)paramView.getTag();
          localObject1 = null;
          locald = null;
          localObject2 = null;
          break;
        case 1:
          localObject2 = (c)paramView.getTag();
          localObject1 = null;
          locald = null;
          localObject3 = null;
          break;
        case 2:
          locald = (d)paramView.getTag();
          localObject1 = null;
          localObject2 = null;
          localObject3 = null;
          break;
        case 3:
          localObject1 = (e)paramView.getTag();
          locald = null;
          localObject2 = null;
          localObject3 = null;
        }
      case 0:
      case 1:
      case 2:
      case 3:
      }
    VideoChapter localVideoChapter = (VideoChapter)((VideoTapeLevel)this.g.get(paramInt)).getData();
    ((b)localObject3).b.setText(localVideoChapter.getChapter_name());
    if (((VideoTapeLevel)this.g.get(paramInt)).getCover() == 1)
    {
      LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(16, 30);
      ((b)localObject3).c.setLayoutParams(localLayoutParams3);
      ((b)localObject3).c.setBackgroundResource(2130837901);
    }
    while (true)
    {
      ((b)localObject3).a.setTag(Integer.valueOf(paramInt));
      ((b)localObject3).a.setOnClickListener(this.h);
      return paramView;
      LinearLayout.LayoutParams localLayoutParams4 = new LinearLayout.LayoutParams(30, 16);
      ((b)localObject3).c.setLayoutParams(localLayoutParams4);
      ((b)localObject3).c.setBackgroundResource(2130837902);
    }
    VideoSection localVideoSection = (VideoSection)((VideoTapeLevel)this.g.get(paramInt)).getData();
    ((c)localObject2).b.setText(localVideoSection.getSection_name());
    if (((VideoTapeLevel)this.g.get(paramInt)).getCover() == 1)
    {
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(16, 30);
      ((c)localObject2).c.setLayoutParams(localLayoutParams1);
      ((c)localObject2).c.setBackgroundResource(2130837901);
    }
    while (true)
    {
      ((c)localObject2).a.setTag(Integer.valueOf(paramInt));
      ((c)localObject2).a.setOnClickListener(this.h);
      return paramView;
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(30, 16);
      ((c)localObject2).c.setLayoutParams(localLayoutParams2);
      ((c)localObject2).c.setBackgroundResource(2130837902);
    }
    Video localVideo2 = (Video)((VideoTapeLevel)this.g.get(paramInt)).getData();
    locald.a.setText(localVideo2.getVideo_name());
    locald.b.setText(p.a(localVideo2.getDuration()));
    return paramView;
    Video localVideo1 = (Video)((VideoTapeLevel)this.g.get(paramInt)).getData();
    ((e)localObject1).a.setText(localVideo1.getVideo_name());
    ((e)localObject1).b.setText(p.a(localVideo1.getDuration()));
    return (View)(View)(View)paramView;
  }

  public int getViewTypeCount()
  {
    return 4;
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
      case 2131297378:
      case 2131297379:
      default:
        return;
      case 2131297377:
        VideoChapter localVideoChapter1 = (VideoChapter)((VideoTapeLevel)ao.a(ao.this).get(((Integer)paramView.getTag()).intValue())).getData();
        int j = 0;
        if (j >= ao.b(ao.this).size())
        {
          ao.a(ao.this).clear();
          ao.a(ao.this).addAll(p.b(ao.b(ao.this)));
          ao.this.notifyDataSetChanged();
          return;
        }
        Object localObject2 = ((VideoTapeLevel)ao.b(ao.this).get(j)).getData();
        if ((localObject2 instanceof VideoChapter))
        {
          VideoChapter localVideoChapter2 = (VideoChapter)localObject2;
          if (localVideoChapter1.getChapter_name().equals(localVideoChapter2.getChapter_name()))
          {
            if (((VideoTapeLevel)ao.b(ao.this).get(j)).getCover() != 1)
              break label237;
            ((VideoTapeLevel)ao.b(ao.this).get(j)).setCover(2);
          }
        }
        while (true)
        {
          j++;
          break;
          label237: ((VideoTapeLevel)ao.b(ao.this).get(j)).setCover(1);
        }
      case 2131297380:
      }
      VideoSection localVideoSection1 = (VideoSection)((VideoTapeLevel)ao.a(ao.this).get(((Integer)paramView.getTag()).intValue())).getData();
      int i = 0;
      if (i >= ao.b(ao.this).size())
      {
        ao.a(ao.this).clear();
        ao.a(ao.this).addAll(p.b(ao.b(ao.this)));
        ao.this.notifyDataSetChanged();
        return;
      }
      Object localObject1 = ((VideoTapeLevel)ao.b(ao.this).get(i)).getData();
      if ((localObject1 instanceof VideoSection))
      {
        VideoSection localVideoSection2 = (VideoSection)localObject1;
        if (localVideoSection1.getSection_name().equals(localVideoSection2.getSection_name()))
        {
          if (((VideoTapeLevel)ao.b(ao.this).get(i)).getCover() != 1)
            break label454;
          ((VideoTapeLevel)ao.b(ao.this).get(i)).setCover(2);
        }
      }
      while (true)
      {
        i++;
        break;
        label454: ((VideoTapeLevel)ao.b(ao.this).get(i)).setCover(1);
      }
    }
  }

  class b
  {
    public LinearLayout a;
    public TextView b;
    public Button c;

    b()
    {
    }
  }

  class c
  {
    public LinearLayout a;
    public TextView b;
    public Button c;

    c()
    {
    }
  }

  class d
  {
    public TextView a;
    public TextView b;

    d()
    {
    }
  }

  class e
  {
    public TextView a;
    public TextView b;

    e()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.ao
 * JD-Core Version:    0.6.0
 */