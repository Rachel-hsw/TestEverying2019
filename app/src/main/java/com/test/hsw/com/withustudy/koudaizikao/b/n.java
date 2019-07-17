package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.http.e;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.InfoComment;
import com.withustudy.koudaizikao.g.b;
import java.util.List;

public class n extends BaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  private Context c;
  private List<InfoComment> d;
  private a e;
  private Handler f;

  public n(Context paramContext, List<InfoComment> paramList, Handler paramHandler)
  {
    this.c = paramContext;
    this.d = paramList;
    this.e = new a();
    this.f = paramHandler;
  }

  public int getCount()
  {
    if (this.d.size() == 0)
      return 0;
    return 1 + this.d.size();
  }

  public Object getItem(int paramInt)
  {
    if (paramInt != this.d.size())
      return this.d.get(paramInt);
    return null;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt != this.d.size())
      return 0;
    return 1;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    b localb;
    if (paramView == null)
      switch (i)
      {
      default:
        localb = null;
      case 0:
      case 1:
      }
    while (true)
      switch (i)
      {
      case 1:
      default:
        return paramView;
        localb = new b();
        paramView = LayoutInflater.from(this.c).inflate(2130903199, null);
        localb.a = ((ImageView)paramView.findViewById(2131297287));
        localb.b = ((TextView)paramView.findViewById(2131297289));
        localb.c = ((TextView)paramView.findViewById(2131297290));
        localb.d = ((TextView)paramView.findViewById(2131297291));
        localb.e = ((TextView)paramView.findViewById(2131297292));
        localb.f = ((TextView)paramView.findViewById(2131297293));
        localb.g = ((TextView)paramView.findViewById(2131297294));
        localb.h = ((Button)paramView.findViewById(2131297295));
        paramView.setTag(localb);
        continue;
        paramView = LayoutInflater.from(this.c).inflate(2130903200, null);
        paramView.setTag(paramView);
        localb = null;
        continue;
        switch (i)
        {
        default:
          localb = null;
          break;
        case 0:
          localb = (b)paramView.getTag();
          break;
        case 1:
          localb = null;
        }
      case 0:
      }
    localb.a.setTag(Integer.valueOf(paramInt));
    if ((((InfoComment)this.d.get(paramInt)).getProfileUrl() != null) && (!((InfoComment)this.d.get(paramInt)).getProfileUrl().equals("")))
    {
      e.a(this.c).c(((InfoComment)this.d.get(paramInt)).getProfileUrl(), localb.a, paramInt);
      localb.b.setText(((InfoComment)this.d.get(paramInt)).getNickname());
      localb.c.setText(b.b(this.c, Long.valueOf(((InfoComment)this.d.get(paramInt)).getCommentTime()).longValue()));
      localb.d.setText(((InfoComment)this.d.get(paramInt)).getFloorId() + "楼");
      localb.e.setText(((InfoComment)this.d.get(paramInt)).getContent());
      if ((((InfoComment)this.d.get(paramInt)).getParentId() == null) || (((InfoComment)this.d.get(paramInt)).getParentId().equals("0")))
        break label662;
      localb.f.setVisibility(0);
      localb.f.setText("回复 " + ((InfoComment)this.d.get(paramInt)).getReplyName() + ":  " + ((InfoComment)this.d.get(paramInt)).getReplyContent());
    }
    while (true)
    {
      localb.h.setTag(Integer.valueOf(paramInt));
      localb.h.setOnClickListener(this.e);
      localb.g.setText("");
      return paramView;
      localb.a.setImageResource(2130837862);
      break;
      label662: localb.f.setVisibility(8);
    }
  }

  public int getViewTypeCount()
  {
    return 2;
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
      case 2131297295:
      }
      if (f.a(n.a(n.this)).i().equals(""))
      {
        Toast.makeText(n.a(n.this), "请先登录", 0).show();
        return;
      }
      Message localMessage = n.b(n.this).obtainMessage(1, n.c(n.this).get(((Integer)paramView.getTag()).intValue()));
      n.b(n.this).sendMessage(localMessage);
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
    public TextView g;
    public Button h;

    b()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.n
 * JD-Core Version:    0.6.0
 */