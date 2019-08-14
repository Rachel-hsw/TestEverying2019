package com.withustudy.koudaizikao.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.f;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.VideoBoughtDetailActivity;
import com.withustudy.koudaizikao.activity.VideoTapePlayActivity;
import com.withustudy.koudaizikao.b.ah;
import com.withustudy.koudaizikao.b.ah.a;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.custom.LoadingView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.entity.content.VideoAllContent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VideoMineFragment extends AbsBaseFragment
{
  public static c a;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 10;
  public static final int f = 11;
  private PullToRefreshListView g;
  private ah h;
  private List<VideoCourse> i;
  private LinearLayout j;
  private LoadingView k;
  private boolean l = false;
  private boolean m = false;
  private b n;
  private int o = 1;
  private final int p = 10;
  private RelativeLayout q;
  private PopupWindow r;

  private void d()
  {
    this.l = true;
    this.o = 1;
    a locala = c.b().ay();
    String[] arrayOfString = new String[5];
    arrayOfString[0] = this.E.s();
    arrayOfString[1] = String.valueOf(this.o);
    arrayOfString[2] = String.valueOf(10);
    arrayOfString[3] = this.E.i();
    arrayOfString[4] = "1";
    locala.a(this, arrayOfString, 10, this.y);
  }

  private void e()
  {
    this.m = true;
    this.o = (1 + this.o);
    a locala = c.b().ay();
    String[] arrayOfString = new String[5];
    arrayOfString[0] = this.E.s();
    arrayOfString[1] = String.valueOf(this.o);
    arrayOfString[2] = String.valueOf(10);
    arrayOfString[3] = this.E.i();
    arrayOfString[4] = "1";
    locala.a(this, arrayOfString, 11, this.y);
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903172, null);
  }

  public void a()
  {
    this.i = new ArrayList();
    this.n = new b();
    a = new c(this);
  }

  public void a(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = getActivity().getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    getActivity().getWindow().setAttributes(localLayoutParams);
  }

  public void a(View paramView)
  {
    this.k = ((LoadingView)paramView.findViewById(2131297122));
    this.g = ((PullToRefreshListView)paramView.findViewById(2131297120));
    this.j = ((LinearLayout)paramView.findViewById(2131297121));
    this.q = ((RelativeLayout)paramView.findViewById(2131297119));
  }

  public void b()
  {
    com.withustudy.koudaizikao.g.n.a(true, this.g, this.y);
    d();
  }

  public void c()
  {
    this.g.setOnItemClickListener(this.n);
    this.g.setOnRefreshListener(this.n);
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
    this.k.setVisibility(8);
    switch (paramInt)
    {
    default:
      return;
    case 10:
      this.l = false;
      this.g.f();
      return;
    case 11:
    }
    this.m = false;
    this.g.f();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.k.setVisibility(8);
    switch (paramInt)
    {
    default:
      return;
    case 10:
      this.l = false;
      if (paramString1 != null);
      while (true)
      {
        try
        {
          VideoAllContent localVideoAllContent2 = (VideoAllContent)c.a().fromJson(paramString1, VideoAllContent.class);
          if ((localVideoAllContent2 == null) || (!localVideoAllContent2.getResult().equals("true")))
            continue;
          a.sendMessage(a.obtainMessage(1, localVideoAllContent2.getCourse_list()));
          this.g.f();
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
          continue;
        }
        Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
      }
    case 11:
    }
    this.m = false;
    if (paramString1 != null);
    while (true)
    {
      try
      {
        VideoAllContent localVideoAllContent1 = (VideoAllContent)c.a().fromJson(paramString1, VideoAllContent.class);
        if ((localVideoAllContent1 == null) || (!localVideoAllContent1.getResult().equals("true")))
          continue;
        a.sendMessage(a.obtainMessage(2, localVideoAllContent1.getCourse_list()));
        this.g.f();
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
        continue;
      }
      Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
    }
  }

  class a
    implements ah.a
  {
    a()
    {
    }

    public void a(VideoCourse paramVideoCourse)
    {
      View localView = View.inflate(VideoMineFragment.d(VideoMineFragment.this), 2130903132, null);
      String str1 = paramVideoCourse.getService_click_text();
      Button localButton1 = (Button)localView.findViewById(2131296873);
      String str2 = paramVideoCourse.getService_tips_text();
      ((TextView)localView.findViewById(2131296875)).setText(str2);
      String str3 = paramVideoCourse.getService_copy_text();
      Button localButton2 = (Button)localView.findViewById(2131296876);
      localButton2.setText(str1);
      localButton2.setOnClickListener(new ab(this, str3));
      localButton1.setOnClickListener(new ac(this));
      VideoMineFragment.a(VideoMineFragment.this, new PopupWindow(localView, -2, -2, true));
      VideoMineFragment.g(VideoMineFragment.this).setTouchable(true);
      VideoMineFragment.g(VideoMineFragment.this).setBackgroundDrawable(VideoMineFragment.this.getResources().getDrawable(2130837618));
      VideoMineFragment.g(VideoMineFragment.this).setOnDismissListener(new ad(this));
      VideoMineFragment.g(VideoMineFragment.this).showAtLocation(VideoMineFragment.h(VideoMineFragment.this), 17, 0, 0);
      VideoMineFragment.this.a(0.6F);
    }
  }

  class b
    implements AdapterView.OnItemClickListener, PullToRefreshBase.f<ListView>
  {
    b()
    {
    }

    public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!VideoMineFragment.i(VideoMineFragment.this))
        VideoMineFragment.f(VideoMineFragment.this);
    }

    public void b(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!VideoMineFragment.j(VideoMineFragment.this))
        VideoMineFragment.k(VideoMineFragment.this);
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      Bundle localBundle = new Bundle();
      if (((VideoCourse)VideoMineFragment.b(VideoMineFragment.this).get(paramInt - 1)).getCategory() == 0)
      {
        localBundle.putSerializable("class", (Serializable)VideoMineFragment.b(VideoMineFragment.this).get(paramInt - 1));
        VideoMineFragment.a(VideoMineFragment.this, VideoBoughtDetailActivity.class, false, localBundle);
        return;
      }
      localBundle.putString("class", ((VideoCourse)VideoMineFragment.b(VideoMineFragment.this).get(paramInt - 1)).getCourse_id());
      VideoMineFragment.a(VideoMineFragment.this, VideoTapePlayActivity.class, false, localBundle);
    }
  }

  public class c extends com.withustudy.koudaizikao.base.n<VideoMineFragment>
  {
    int a;
    private String c;
    private int d;

    public c(VideoMineFragment arg2)
    {
      super();
    }

    protected void a(VideoMineFragment paramVideoMineFragment, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 4:
      default:
      case 5:
        int i;
        int j;
        do
        {
          return;
          i = ((ListView)VideoMineFragment.a(VideoMineFragment.this).getRefreshableView()).getFirstVisiblePosition();
          j = ((ListView)VideoMineFragment.a(VideoMineFragment.this).getRefreshableView()).getLastVisiblePosition();
        }
        while ((this.a < i) || (this.a > j));
        ((ProgressBar)((ListView)VideoMineFragment.a(VideoMineFragment.this).getRefreshableView()).getChildAt(this.a - i).findViewById(2131297351)).setProgress(this.d);
        return;
      case 1:
        VideoMineFragment.b(paramVideoMineFragment).clear();
        VideoMineFragment.b(paramVideoMineFragment).addAll((List)paramMessage.obj);
        if (VideoMineFragment.b(paramVideoMineFragment).size() == 0)
          VideoMineFragment.c(paramVideoMineFragment).setVisibility(0);
        while (true)
        {
          VideoMineFragment.a(VideoMineFragment.this, new ah(VideoMineFragment.d(paramVideoMineFragment), VideoMineFragment.b(paramVideoMineFragment), VideoMineFragment.a(VideoMineFragment.this)));
          VideoMineFragment.a locala = new VideoMineFragment.a(VideoMineFragment.this);
          VideoMineFragment.e(VideoMineFragment.this).a(locala);
          VideoMineFragment.a(paramVideoMineFragment).setAdapter(VideoMineFragment.e(VideoMineFragment.this));
          if (VideoMineFragment.b(paramVideoMineFragment).size() != 0)
            break;
          VideoMineFragment.c(paramVideoMineFragment).setVisibility(0);
          return;
          VideoMineFragment.c(paramVideoMineFragment).setVisibility(8);
        }
        VideoMineFragment.c(paramVideoMineFragment).setVisibility(8);
        return;
      case 2:
        VideoMineFragment.b(paramVideoMineFragment).addAll((List)paramMessage.obj);
        VideoMineFragment.e(paramVideoMineFragment).notifyDataSetChanged();
        return;
      case 3:
      }
      VideoMineFragment.f(paramVideoMineFragment);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.VideoMineFragment
 * JD-Core Version:    0.6.0
 */