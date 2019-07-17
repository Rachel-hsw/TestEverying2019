package com.withustudy.koudaizikao.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.f;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.umeng.a.g;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.MainActivity;
import com.withustudy.koudaizikao.activity.VideoBoughtDetailActivity;
import com.withustudy.koudaizikao.activity.VideoSaleDetailActivity;
import com.withustudy.koudaizikao.activity.VideoTapePlayActivity;
import com.withustudy.koudaizikao.b.af;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.custom.LoadingView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.New_course_ids;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.entity.content.VideoAllContent;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ViedeoChongCiFragment extends AbsBaseFragment
{
  public static final int a = 10;
  public static final int b = 9;
  public static final int c = 11;
  public static final int d = 12;
  private static List<New_course_ids> q;
  List<New_course_ids> e = new ArrayList();
  private PullToRefreshListView f;
  private LoadingView g;
  private a h;
  private List<VideoCourse> i;
  private af j;
  private boolean k = false;
  private boolean l = false;
  private int m = 1;
  private final int n = 20;
  private Handler o = new ae(this);
  private View p;

  private void a(MainActivity paramMainActivity)
  {
    VideoMainFragment localVideoMainFragment = (VideoMainFragment)getParentFragment();
    if ((this.e != null) && (this.e.size() > 0))
    {
      Iterator localIterator = this.e.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return;
        String str = ((New_course_ids)localIterator.next()).getCourse_id();
        Boolean localBoolean = (Boolean)paramMainActivity.newCourseIsClick.get(str);
        if ((localBoolean != null) && (!localBoolean.booleanValue()))
        {
          localVideoMainFragment.a.setVisibility(0);
          return;
        }
        localVideoMainFragment.a.setVisibility(8);
      }
    }
    localVideoMainFragment.a.setVisibility(8);
  }

  private void d()
  {
    this.k = true;
    this.m = 1;
    a locala = c.b().s();
    String[] arrayOfString = new String[4];
    arrayOfString[0] = this.E.i();
    arrayOfString[1] = this.E.s();
    arrayOfString[2] = String.valueOf(this.m);
    arrayOfString[3] = String.valueOf(20);
    locala.a(this, arrayOfString, 10, this.y);
  }

  private void e()
  {
    this.l = true;
    this.m = (1 + this.m);
    a locala = c.b().s();
    String[] arrayOfString = new String[4];
    arrayOfString[0] = this.E.i();
    arrayOfString[1] = this.E.s();
    arrayOfString[2] = String.valueOf(this.m);
    arrayOfString[3] = String.valueOf(20);
    locala.a(this, arrayOfString, 11, this.y);
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903170, null);
  }

  public void a()
  {
    this.i = new ArrayList();
    this.h = new a();
  }

  public void a(View paramView)
  {
    this.f = ((PullToRefreshListView)paramView.findViewById(2131297115));
    this.g = ((LoadingView)paramView.findViewById(2131297116));
  }

  public void a(List<New_course_ids> paramList)
  {
    q = paramList;
    this.e.clear();
    if (paramList == null);
    while (true)
    {
      return;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        New_course_ids localNew_course_ids = (New_course_ids)localIterator.next();
        if (localNew_course_ids.getIs_chuanjiang() != 1)
          continue;
        this.e.add(localNew_course_ids);
      }
    }
  }

  public void b()
  {
    n.a(true, this.f, this.y);
    d();
  }

  public void c()
  {
    this.f.setOnItemClickListener(this.h);
    this.f.setOnRefreshListener(this.h);
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    this.g.setVisibility(8);
    switch (paramInt)
    {
    default:
      return;
    case 10:
      this.k = false;
      this.f.f();
      return;
    case 11:
    }
    this.l = false;
    this.f.f();
  }

  public void onResume()
  {
    super.onResume();
    if (this.j != null)
    {
      this.j.a(this.e);
      this.j.notifyDataSetChanged();
    }
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.g.setVisibility(8);
    switch (paramInt)
    {
    default:
      return;
    case 10:
      this.k = false;
      if (paramString1 != null);
      while (true)
      {
        try
        {
          VideoAllContent localVideoAllContent2 = (VideoAllContent)c.a().fromJson(paramString1, VideoAllContent.class);
          if ((localVideoAllContent2 == null) || (!localVideoAllContent2.getResult().equals("true")) || (localVideoAllContent2.getCourse_list() == null))
            continue;
          this.o.sendMessage(this.o.obtainMessage(10, localVideoAllContent2.getCourse_list()));
          this.f.f();
          return;
          this.o.sendEmptyMessage(9);
          continue;
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
    this.l = false;
    if (paramString1 != null);
    while (true)
    {
      try
      {
        VideoAllContent localVideoAllContent1 = (VideoAllContent)c.a().fromJson(paramString1, VideoAllContent.class);
        if ((localVideoAllContent1 == null) || (!localVideoAllContent1.getResult().equals("true")) || (localVideoAllContent1.getCourse_list() == null))
          continue;
        this.o.sendMessage(this.o.obtainMessage(11, localVideoAllContent1.getCourse_list()));
        this.f.f();
        return;
        this.o.sendEmptyMessage(12);
        continue;
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
    implements AdapterView.OnItemClickListener, PullToRefreshBase.f<ListView>
  {
    a()
    {
    }

    public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!ViedeoChongCiFragment.e(ViedeoChongCiFragment.this))
        ViedeoChongCiFragment.f(ViedeoChongCiFragment.this);
    }

    public void b(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!ViedeoChongCiFragment.g(ViedeoChongCiFragment.this))
        ViedeoChongCiFragment.h(ViedeoChongCiFragment.this);
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      Bundle localBundle = new Bundle();
      VideoCourse localVideoCourse = (VideoCourse)ViedeoChongCiFragment.a(ViedeoChongCiFragment.this).get(paramInt - 1);
      if (localVideoCourse.getBuy_status() == 0)
      {
        g.b(ViedeoChongCiFragment.b(ViedeoChongCiFragment.this), "course_all_buy");
        localBundle.putString("class", localVideoCourse.getCourse_id());
        ViedeoChongCiFragment.a(ViedeoChongCiFragment.this, VideoSaleDetailActivity.class, false, localBundle);
      }
      while (true)
      {
        MainActivity localMainActivity = (MainActivity)ViedeoChongCiFragment.this.getActivity();
        String str = localVideoCourse.getCourse_id();
        localMainActivity.newCourseIsClick.put(str, Boolean.valueOf(true));
        ViedeoChongCiFragment.a(ViedeoChongCiFragment.this, localMainActivity);
        return;
        if (localVideoCourse.getCategory() == 0)
        {
          localBundle.putSerializable("class", localVideoCourse);
          ViedeoChongCiFragment.a(ViedeoChongCiFragment.this, VideoBoughtDetailActivity.class, false, localBundle);
          continue;
        }
        localBundle.putSerializable("class", localVideoCourse.getCourse_id());
        ViedeoChongCiFragment.a(ViedeoChongCiFragment.this, VideoTapePlayActivity.class, false, localBundle);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.ViedeoChongCiFragment
 * JD-Core Version:    0.6.0
 */