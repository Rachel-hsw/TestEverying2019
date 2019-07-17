package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.http.e;
import com.withustudy.koudaizikao.entity.req.Comment;
import com.withustudy.koudaizikao.entity.req.UserInfo;
import com.withustudy.koudaizikao.g.b;
import com.withustudy.koudaizikao.g.n;
import java.util.List;

public class i extends BaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  private Context c;
  private List<Comment> d;
  private a e;
  private Handler f;

  public i(Context paramContext, List<Comment> paramList, Handler paramHandler)
  {
    this.c = paramContext;
    this.d = paramList;
    this.e = new a();
    this.f = paramHandler;
  }

  public int getCount()
  {
    if (this.d == null)
      return 0;
    return this.d.size();
  }

  public Object getItem(int paramInt)
  {
    return null;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    c localc;
    Comment localComment;
    UserInfo localUserInfo;
    label229: String str4;
    if (paramView == null)
    {
      localc = new c();
      paramView = LayoutInflater.from(this.c).inflate(2130903199, null);
      localc.a = ((ImageView)paramView.findViewById(2131297287));
      localc.b = ((TextView)paramView.findViewById(2131297289));
      localc.c = ((TextView)paramView.findViewById(2131297290));
      localc.d = ((TextView)paramView.findViewById(2131297291));
      localc.e = ((TextView)paramView.findViewById(2131297292));
      localc.f = ((TextView)paramView.findViewById(2131297293));
      localc.g = ((TextView)paramView.findViewById(2131297294));
      localc.h = ((Button)paramView.findViewById(2131297295));
      paramView.setTag(localc);
      localComment = (Comment)this.d.get(paramInt);
      localUserInfo = localComment.getUserInfo();
      String str1 = localUserInfo.getNickname();
      localc.b.setText(str1);
      localc.a.setTag(Integer.valueOf(paramInt));
      String str2 = localUserInfo.getHeadPic();
      if ((str2 != null) && (!str2.equals("")))
        break label383;
      localc.a.setImageResource(2130837862);
      long l = localComment.getCommentTime();
      String str3 = b.b(this.c, l);
      localc.c.setText(str3);
      localc.d.setText(paramInt + 1 + "楼");
      localc.e.setText(Html.fromHtml(n.a(localComment.getContent(), "#343434")));
      str4 = localComment.getReplyFloorContent();
      if ((str4 != null) && (!str4.equals("")))
        break label407;
      localc.f.setVisibility(8);
    }
    while (true)
    {
      localc.h.setOnClickListener(new j(this, paramInt));
      localc.g.setText(localComment.getLocation());
      return paramView;
      localc = (c)paramView.getTag();
      break;
      label383: e.a(this.c).c(localUserInfo.getHeadPic(), localc.a, paramInt);
      break label229;
      label407: localc.f.setVisibility(0);
      String[] arrayOfString = str4.split(":");
      if ((arrayOfString == null) || (arrayOfString.length != 2))
        continue;
      String str5 = arrayOfString[0];
      String str6 = arrayOfString[1];
      Html.fromHtml(n.a(str5, "#D6D6D6"));
      localc.f.setText(Html.fromHtml(n.a(new StringBuilder(String.valueOf(str5)).append(":").toString(), "#D7D7D7") + n.a(str6, "#747474")));
    }
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
      case 2131297295:
      }
    }
  }

  public class b
  {
    public int a;
    public int b;
    public Comment c;

    public b()
    {
    }
  }

  class c
  {
    public ImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public Button h;

    c()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.i
 * JD-Core Version:    0.6.0
 */