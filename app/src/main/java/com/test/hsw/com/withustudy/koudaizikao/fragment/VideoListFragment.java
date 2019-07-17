package com.withustudy.koudaizikao.fragment;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.bokecc.sdk.mobile.download.Downloader;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.VideoTapePlayActivity;
import com.withustudy.koudaizikao.activity.VideoTapePlayActivity.b;
import com.withustudy.koudaizikao.activity.dialog.DialogActivitySimpleChoice;
import com.withustudy.koudaizikao.b.am;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.base.n;
import com.withustudy.koudaizikao.custom.LoadingView;
import com.withustudy.koudaizikao.entity.Video;
import com.withustudy.koudaizikao.entity.VideoChapter;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.entity.content.VideoListTape;
import com.withustudy.koudaizikao.entity.local.VideoDownLoadStatus;
import com.withustudy.koudaizikao.entity.local.VideoWait;
import com.withustudy.koudaizikao.service.VideoDownLoadService;
import com.withustudy.koudaizikao.service.VideoDownLoadService.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import koudai.db.VideoInfroDao;
import koudai.db.i;

public class VideoListFragment extends AbsBaseFragment
{
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 3;
  public static final int g = 6;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  private b F;
  public boolean a = false;
  private ListView k;
  private am l;
  private List<VideoChapter> m;
  private List<VideoDownLoadStatus> n;
  private List<VideoWait> o;
  private LoadingView p;
  private VideoDownLoadService.b q = null;
  private d r;
  private VideoCourse s;
  private VideoListTape t;
  private double u;
  private c v;
  private a w;

  public VideoListFragment(VideoCourse paramVideoCourse)
  {
    this.s = paramVideoCourse;
  }

  private VideoDownLoadStatus a(String paramString)
  {
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.n.size())
        return null;
      if (((VideoDownLoadStatus)this.n.get(i1)).getVideoId().equals(paramString))
        return (VideoDownLoadStatus)this.n.get(i1);
    }
  }

  private void a(Video paramVideo)
  {
    File localFile = this.C.b(com.withustudy.koudaizikao.g.f.d + paramVideo.getVideo_id() + ".mp4");
    Downloader localDownloader = new Downloader(localFile, paramVideo.getVideo_id(), "362F26D4FF4ED1EC", "5PnpvX2oiXGNUe8POZQlolPJfe1zm80Q");
    this.q.a(localDownloader);
    this.q.a(localFile);
    this.q.a(paramVideo);
    this.y.startService(new Intent(this.z, VideoDownLoadService.class));
    VideoDownLoadStatus localVideoDownLoadStatus = new VideoDownLoadStatus();
    localVideoDownLoadStatus.setVideoId(paramVideo.getVideo_id());
    localVideoDownLoadStatus.setProgress(0);
    localVideoDownLoadStatus.setStatus(100);
    this.n.add(localVideoDownLoadStatus);
  }

  private int b(String paramString)
  {
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.n.size())
        i1 = -1;
      do
        return i1;
      while (((VideoDownLoadStatus)this.n.get(i1)).getVideoId().equals(paramString));
    }
  }

  private boolean b(Video paramVideo)
  {
    if (this.o.size() == 0);
    while (true)
    {
      return false;
      for (int i1 = 0; i1 < this.o.size(); i1++)
        if (((VideoWait)this.o.get(i1)).getmVideo().getVideo_id().equals(paramVideo.getVideo_id()))
          return true;
    }
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903171, null);
  }

  public void a()
  {
    this.r = new d();
    this.v = new c(this);
    this.w = new a();
    this.F = new b();
    this.n = new ArrayList();
    this.o = new ArrayList();
  }

  public void a(View paramView)
  {
    this.k = ((ListView)paramView.findViewById(2131297117));
    this.p = ((LoadingView)paramView.findViewById(2131297118));
  }

  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    if (this.l != null)
      this.l.a(paramBoolean);
  }

  public void b()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.withustudy.koudaizikao.downloadvideo");
    this.y.registerReceiver(this.F, localIntentFilter);
    this.y.bindService(new Intent(this.z, VideoDownLoadService.class), this.r, 1);
    this.k.setSelector(2131034189);
    com.withustudy.koudaizikao.a.a locala = c.b().az();
    String[] arrayOfString = new String[3];
    arrayOfString[0] = this.E.i();
    arrayOfString[1] = this.s.getCourse_id();
    arrayOfString[2] = String.valueOf(this.s.getCategory());
    locala.a(this, arrayOfString, 10, this.y);
  }

  public void c()
  {
    this.k.setOnItemClickListener(this.w);
  }

  public double d()
  {
    return this.u;
  }

  public void e()
  {
    this.v.sendEmptyMessage(8);
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.r != null)
      this.y.unbindService(this.r);
    this.y.unregisterReceiver(this.F);
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    this.p.setVisibility(8);
    switch (paramInt)
    {
    case 10:
    }
  }

  public void onResume()
  {
    super.onResume();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.p.setVisibility(8);
    switch (paramInt)
    {
    default:
    case 10:
    }
    while (true)
    {
      return;
      if (paramString1 == null)
        break;
      try
      {
        this.t = ((VideoListTape)c.a().fromJson(paramString1, VideoListTape.class));
        if ((this.t == null) || (!this.t.getResult().equals("true")))
          continue;
        String[] arrayOfString = this.t.getAspect_ratio().split(":");
        this.u = (Double.valueOf(arrayOfString[0]).doubleValue() / Double.valueOf(arrayOfString[1]).doubleValue());
        this.m = new ArrayList();
        this.m.addAll(this.t.getCourse_dir());
        this.v.sendEmptyMessage(1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
        return;
      }
    }
    Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
  }

  class a
    implements AdapterView.OnItemClickListener
  {
    a()
    {
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
    }
  }

  class b extends BroadcastReceiver
  {
    b()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      Bundle localBundle;
      if (paramIntent != null)
        localBundle = paramIntent.getExtras();
      switch (localBundle.getInt("result"))
      {
      default:
        if (VideoListFragment.b(VideoListFragment.this, localBundle.getString("videoId")) != -1)
          ((VideoDownLoadStatus)VideoListFragment.d(VideoListFragment.this).get(VideoListFragment.b(VideoListFragment.this, localBundle.getString("videoId")))).setProgress(localBundle.getInt("result"));
        VideoListFragment.b(VideoListFragment.this).sendEmptyMessage(8);
        return;
      case 400:
        i locali = new i();
        locali.a(localBundle.getString("videoId"));
        locali.b(localBundle.getString("path"));
        com.withustudy.koudaizikao.e.a.a(VideoListFragment.f(VideoListFragment.this)).e().c(locali);
        VideoDownLoadStatus localVideoDownLoadStatus2 = VideoListFragment.a(VideoListFragment.this, localBundle.getString("videoId"));
        if (localVideoDownLoadStatus2 != null)
          VideoListFragment.d(VideoListFragment.this).remove(localVideoDownLoadStatus2);
        if (VideoListFragment.e(VideoListFragment.this).size() != 0);
        for (int j = 0; ; j++)
        {
          if (j >= VideoListFragment.e(VideoListFragment.this).size());
          while (true)
          {
            VideoListFragment.b(VideoListFragment.this).sendEmptyMessage(8);
            return;
            if (((VideoWait)VideoListFragment.e(VideoListFragment.this).get(j)).getIsPause() != 0)
              break;
            Video localVideo2 = ((VideoWait)VideoListFragment.e(VideoListFragment.this).get(j)).getmVideo();
            VideoListFragment.a(VideoListFragment.this, localVideo2);
            VideoListFragment.e(VideoListFragment.this).remove(j);
          }
        }
      case 200:
        if (VideoListFragment.b(VideoListFragment.this, localBundle.getString("videoId")) != -1)
          ((VideoDownLoadStatus)VideoListFragment.d(VideoListFragment.this).get(VideoListFragment.b(VideoListFragment.this, localBundle.getString("videoId")))).setStatus(200);
        VideoListFragment.b(VideoListFragment.this).sendEmptyMessage(8);
        return;
      case 300:
        if (VideoListFragment.b(VideoListFragment.this, localBundle.getString("videoId")) != -1)
          ((VideoDownLoadStatus)VideoListFragment.d(VideoListFragment.this).get(VideoListFragment.b(VideoListFragment.this, localBundle.getString("videoId")))).setStatus(300);
        VideoListFragment.b(VideoListFragment.this).sendEmptyMessage(8);
        return;
      case -101:
      }
      VideoDownLoadStatus localVideoDownLoadStatus1 = VideoListFragment.a(VideoListFragment.this, localBundle.getString("videoId"));
      if (localVideoDownLoadStatus1 != null)
        VideoListFragment.d(VideoListFragment.this).remove(localVideoDownLoadStatus1);
      if (VideoListFragment.e(VideoListFragment.this).size() != 0);
      for (int i = 0; ; i++)
      {
        if (i >= VideoListFragment.e(VideoListFragment.this).size());
        while (true)
        {
          VideoListFragment.b(VideoListFragment.this).sendEmptyMessage(8);
          return;
          if (((VideoWait)VideoListFragment.e(VideoListFragment.this).get(i)).getIsPause() != 0)
            break;
          Video localVideo1 = ((VideoWait)VideoListFragment.e(VideoListFragment.this).get(i)).getmVideo();
          VideoListFragment.a(VideoListFragment.this, localVideo1);
          VideoListFragment.e(VideoListFragment.this).remove(i);
        }
      }
    }
  }

  public static class c extends n<VideoListFragment>
  {
    public c(VideoListFragment paramVideoListFragment)
    {
      super();
    }

    protected void a(VideoListFragment paramVideoListFragment, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 7:
      default:
      case 1:
      case 2:
      case 6:
      case 9:
      case 4:
      case 5:
      case 3:
      case 8:
      }
      label347: 
      do
      {
        do
        {
          do
          {
            Video localVideo1;
            do
            {
              do
              {
                while (true)
                {
                  return;
                  String str = VideoListFragment.a(paramVideoListFragment).getLast_watch_vid();
                  VideoListFragment.a(paramVideoListFragment, new am(VideoListFragment.b(paramVideoListFragment), VideoListFragment.c(paramVideoListFragment), VideoListFragment.d(paramVideoListFragment), VideoListFragment.e(paramVideoListFragment), VideoListFragment.f(paramVideoListFragment), VideoListFragment.g(paramVideoListFragment), str));
                  VideoListFragment.h(paramVideoListFragment).a(paramVideoListFragment.a);
                  VideoListFragment.i(paramVideoListFragment).setAdapter(VideoListFragment.h(paramVideoListFragment));
                  if ((str != null) && (!str.equals("")))
                  {
                    if (VideoListFragment.h(paramVideoListFragment).a(str) == null)
                      continue;
                    VideoTapePlayActivity.a.sendMessage(VideoTapePlayActivity.a.obtainMessage(2, VideoListFragment.h(paramVideoListFragment).a(str)));
                    return;
                  }
                  if (VideoListFragment.h(paramVideoListFragment).b() == null)
                    continue;
                  VideoTapePlayActivity.a.sendMessage(VideoTapePlayActivity.a.obtainMessage(2, VideoListFragment.h(paramVideoListFragment).b()));
                  return;
                  Toast.makeText(VideoListFragment.f(paramVideoListFragment), (String)paramMessage.obj, 0).show();
                  return;
                  Video localVideo2 = (Video)paramMessage.obj;
                  for (int i = 0; ; i++)
                  {
                    if (i >= VideoListFragment.e(paramVideoListFragment).size())
                      break label347;
                    if (!localVideo2.getVideo_id().equals(((VideoWait)VideoListFragment.e(paramVideoListFragment).get(i)).getmVideo().getVideo_id()))
                      continue;
                    ((VideoWait)VideoListFragment.e(paramVideoListFragment).get(i)).setIsPause(paramMessage.arg1);
                    if ((paramMessage.arg1 != 0) || (VideoListFragment.d(paramVideoListFragment).size() != 0))
                      break;
                    VideoListFragment.a(paramVideoListFragment, localVideo2);
                    VideoListFragment.e(paramVideoListFragment).remove(i);
                    return;
                  }
                }
                Bundle localBundle = new Bundle();
                localBundle.putString("content", "是否接受在非WIFI环境下下载");
                VideoListFragment.a(paramVideoListFragment, DialogActivitySimpleChoice.class, 51, localBundle);
                return;
              }
              while (VideoListFragment.j(paramVideoListFragment) == null);
              localVideo1 = (Video)paramMessage.obj;
              if (VideoListFragment.d(paramVideoListFragment).size() != 0)
                continue;
              Toast.makeText(VideoListFragment.f(paramVideoListFragment), "开始下载", 0).show();
              VideoListFragment.a(paramVideoListFragment, localVideo1);
              return;
            }
            while (VideoListFragment.b(paramVideoListFragment, localVideo1));
            Toast.makeText(VideoListFragment.f(paramVideoListFragment), "排队下载", 0).show();
            VideoWait localVideoWait = new VideoWait();
            localVideoWait.setIsPause(0);
            localVideoWait.setmVideo(localVideo1);
            VideoListFragment.e(paramVideoListFragment).add(localVideoWait);
            VideoListFragment.b(paramVideoListFragment).sendEmptyMessage(8);
            return;
          }
          while (VideoListFragment.j(paramVideoListFragment) == null);
          VideoListFragment.j(paramVideoListFragment).b();
          return;
        }
        while (VideoListFragment.j(paramVideoListFragment) == null);
        VideoListFragment.j(paramVideoListFragment).c();
        return;
      }
      while (VideoListFragment.h(paramVideoListFragment) == null);
      VideoListFragment.h(paramVideoListFragment).a(VideoListFragment.d(paramVideoListFragment));
      VideoListFragment.h(paramVideoListFragment).b(VideoListFragment.e(paramVideoListFragment));
      VideoListFragment.h(paramVideoListFragment).notifyDataSetChanged();
    }
  }

  class d
    implements ServiceConnection
  {
    d()
    {
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      VideoListFragment.a(VideoListFragment.this, (VideoDownLoadService.b)paramIBinder);
    }

    public void onServiceDisconnected(ComponentName paramComponentName)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.VideoListFragment
 * JD-Core Version:    0.6.0
 */