package com.withustudy.koudaizikao.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import com.bokecc.sdk.mobile.download.DownloadListener;
import com.bokecc.sdk.mobile.download.Downloader;
import com.bokecc.sdk.mobile.exception.DreamwinException;
import com.bokecc.sdk.mobile.exception.ErrorCode;
import com.withustudy.koudaizikao.entity.Video;
import com.withustudy.koudaizikao.g.h;
import java.io.File;

public class VideoDownLoadService extends Service
{
  public static final int a = -101;
  public static final String b = "com.withustudy.koudaizikao.downloadvideo";
  private b c;
  private Downloader d;
  private Video e;
  private File f;
  private int g;
  private a h;

  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent("com.withustudy.koudaizikao.downloadvideo");
    localIntent.putExtras(paramBundle);
    sendBroadcast(localIntent);
  }

  public IBinder onBind(Intent paramIntent)
  {
    return this.c;
  }

  public void onCreate()
  {
    super.onCreate();
    this.c = new b();
    this.h = new a();
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.g = 0;
    if (this.d != null)
    {
      this.d.setDownloadListener(this.h);
      this.d.start();
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }

  class a
    implements DownloadListener
  {
    a()
    {
    }

    public void handleCancel(String paramString)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("result", -101);
      localBundle.putString("videoId", VideoDownLoadService.a(VideoDownLoadService.this).getVideo_id());
      VideoDownLoadService.a(VideoDownLoadService.this, localBundle);
      VideoDownLoadService.this.stopSelf();
    }

    public void handleException(DreamwinException paramDreamwinException, int paramInt)
    {
      String str = paramDreamwinException.getMessage();
      if (str.equals(ErrorCode.INVALID_REQUEST))
        h.a(VideoDownLoadService.a(VideoDownLoadService.this).getVideo_id(), VideoDownLoadService.a(VideoDownLoadService.this).getVideo_name(), "invalid_request");
      while (true)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("result", -101);
        localBundle.putString("videoId", VideoDownLoadService.a(VideoDownLoadService.this).getVideo_id());
        VideoDownLoadService.a(VideoDownLoadService.this, localBundle);
        VideoDownLoadService.this.stopSelf();
        return;
        if (str.equals(ErrorCode.NETWORK_ERROR))
        {
          h.a(VideoDownLoadService.a(VideoDownLoadService.this).getVideo_id(), VideoDownLoadService.a(VideoDownLoadService.this).getVideo_name(), "network_error");
          continue;
        }
        if (str.equals(ErrorCode.PROCESS_FAIL))
        {
          h.a(VideoDownLoadService.a(VideoDownLoadService.this).getVideo_id(), VideoDownLoadService.a(VideoDownLoadService.this).getVideo_name(), "process_fail");
          continue;
        }
        h.a(VideoDownLoadService.a(VideoDownLoadService.this).getVideo_id(), VideoDownLoadService.a(VideoDownLoadService.this).getVideo_name(), "未知错误");
      }
    }

    public void handleProcess(long paramLong1, long paramLong2, String paramString)
    {
      int i = (int)(100.0D * (paramLong1 / paramLong2));
      if ((i < 100) && (i != 0) && (i % 10 == 0) && (i != VideoDownLoadService.b(VideoDownLoadService.this)))
      {
        VideoDownLoadService.a(VideoDownLoadService.this, i);
        h.a(VideoDownLoadService.a(VideoDownLoadService.this).getVideo_id(), VideoDownLoadService.a(VideoDownLoadService.this).getVideo_name(), "进度 " + i);
        Bundle localBundle = new Bundle();
        localBundle.putInt("result", i);
        localBundle.putString("videoId", VideoDownLoadService.a(VideoDownLoadService.this).getVideo_id());
        VideoDownLoadService.a(VideoDownLoadService.this, localBundle);
      }
    }

    public void handleStatus(String paramString, int paramInt)
    {
      switch (paramInt)
      {
      default:
        return;
      case 300:
        h.a(paramString, VideoDownLoadService.a(VideoDownLoadService.this).getVideo_name(), "pause");
        Bundle localBundle3 = new Bundle();
        localBundle3.putInt("result", 300);
        localBundle3.putString("videoId", VideoDownLoadService.a(VideoDownLoadService.this).getVideo_id());
        VideoDownLoadService.a(VideoDownLoadService.this, localBundle3);
        return;
      case 200:
        h.a(paramString, VideoDownLoadService.a(VideoDownLoadService.this).getVideo_name(), "download");
        Bundle localBundle2 = new Bundle();
        localBundle2.putInt("result", 200);
        localBundle2.putString("videoId", VideoDownLoadService.a(VideoDownLoadService.this).getVideo_id());
        VideoDownLoadService.a(VideoDownLoadService.this, localBundle2);
        return;
      case 400:
        h.a(paramString, VideoDownLoadService.a(VideoDownLoadService.this).getVideo_name(), "finish");
        Bundle localBundle1 = new Bundle();
        localBundle1.putInt("result", 400);
        localBundle1.putString("videoId", VideoDownLoadService.a(VideoDownLoadService.this).getVideo_id());
        localBundle1.putString("path", VideoDownLoadService.c(VideoDownLoadService.this).getAbsolutePath());
        VideoDownLoadService.a(VideoDownLoadService.this, localBundle1);
        VideoDownLoadService.this.stopSelf();
        return;
      case 100:
      }
      h.a(paramString, "wait");
    }
  }

  public class b extends Binder
  {
    public b()
    {
    }

    public Downloader a()
    {
      return VideoDownLoadService.d(VideoDownLoadService.this);
    }

    public void a(Downloader paramDownloader)
    {
      VideoDownLoadService.a(VideoDownLoadService.this, paramDownloader);
    }

    public void a(Video paramVideo)
    {
      VideoDownLoadService.a(VideoDownLoadService.this, paramVideo);
    }

    public void a(File paramFile)
    {
      VideoDownLoadService.a(VideoDownLoadService.this, paramFile);
    }

    public void b()
    {
      if (VideoDownLoadService.d(VideoDownLoadService.this) != null)
        VideoDownLoadService.d(VideoDownLoadService.this).pause();
    }

    public void c()
    {
      if (VideoDownLoadService.d(VideoDownLoadService.this) != null)
        VideoDownLoadService.d(VideoDownLoadService.this).resume();
    }

    public void d()
    {
      if (VideoDownLoadService.d(VideoDownLoadService.this) != null)
        VideoDownLoadService.d(VideoDownLoadService.this).cancel();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.service.VideoDownLoadService
 * JD-Core Version:    0.6.0
 */