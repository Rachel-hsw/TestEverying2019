package com.gensee.holder.chat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.gensee.chat.gif.GifDrawalbe;
import com.gensee.chat.gif.SpanResource;
import com.gensee.rtmpresourcelib.R.drawable;
import com.gensee.rtmpresourcelib.R.string;
import com.gensee.view.MyTextViewEx;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExpressionResource
{
  private static Bitmap drawableToBitmap(Context paramContext, Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1);
    for (Bitmap.Config localConfig = Bitmap.Config.ARGB_8888; ; localConfig = Bitmap.Config.RGB_565)
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
  }

  private static String getString(Context paramContext, int paramInt)
  {
    return paramContext.getString(paramInt);
  }

  private static void initBrowMap(Context paramContext)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(18);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_nh_cn, R.drawable.brow_nh);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_zj_cn, R.drawable.brow_zj);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_gx_cn, R.drawable.brow_gx);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_sx_cn, R.drawable.brow_sx);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_fn_cn, R.drawable.brow_fn);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_wl_cn, R.drawable.brow_wl);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_lh_cn, R.drawable.brow_lh);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_yw_cn, R.drawable.brow_yw);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_bs_cn, R.drawable.brow_bs);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_xh_cn, R.drawable.brow_xh);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_dx_cn, R.drawable.brow_dx);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_lw_cn, R.drawable.brow_lw);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_tkl_cn, R.drawable.brow_tkl);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_tml_cn, R.drawable.brow_tml);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_zt_cn, R.drawable.brow_zt);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_fd_cn, R.drawable.brow_fd);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_gz_cn, R.drawable.brow_gz);
    putBrowValue(localLinkedHashMap, paramContext, R.string.brow_zdsk_cn, R.drawable.brow_zdsk);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_bz_cn, R.drawable.emotion_bz);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_fd_cn, R.drawable.emotion_fd);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_gg_cn, R.drawable.emotion_gg);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_gz_cn, R.drawable.emotion_gz);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_hx_cn, R.drawable.emotion_hx);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_jk_cn, R.drawable.emotion_jk);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_jy_cn, R.drawable.emotion_jy);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_kb_cn, R.drawable.emotion_kb);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_kl_cn, R.drawable.emotion_kl);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_ll_cn, R.drawable.emotion_ll);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_qd_cn, R.drawable.emotion_qd);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_qh_cn, R.drawable.emotion_qh);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_qq_cn, R.drawable.emotion_qq);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_rb_cn, R.drawable.emotion_rb);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_se_cn, R.drawable.emotion_se);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_tx_cn, R.drawable.emotion_tx);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_xu_cn, R.drawable.emotion_xu);
    putBrowValue(localLinkedHashMap, paramContext, R.string.emotion_yun_cn, R.drawable.emotion_yun);
    SpanResource.initBrowSource(localLinkedHashMap);
  }

  public static void initExpressionResource(Context paramContext)
  {
    new DisplayMetrics();
    GifDrawalbe.ration = paramContext.getResources().getDisplayMetrics().density;
    initTextTipList(paramContext);
    initTextMap(paramContext);
    initUIMap(paramContext);
    initBrowMap(paramContext);
    initSendRichMap(paramContext);
  }

  private static void initSendRichMap(Context paramContext)
  {
    HashMap localHashMap = new HashMap(18);
    localHashMap.put(getString(paramContext, R.string.brow_nh_cn), "emotion.smile.gif");
    localHashMap.put(getString(paramContext, R.string.brow_zj_cn), "emotion.goodbye.gif");
    localHashMap.put(getString(paramContext, R.string.brow_gx_cn), "emotion.laugh.gif");
    localHashMap.put(getString(paramContext, R.string.brow_sx_cn), "emotion.cry.gif");
    localHashMap.put(getString(paramContext, R.string.brow_fn_cn), "emotion.angerly.gif");
    localHashMap.put(getString(paramContext, R.string.brow_wl_cn), "emotion.nod.gif");
    localHashMap.put(getString(paramContext, R.string.brow_lh_cn), "emotion.lh.gif");
    localHashMap.put(getString(paramContext, R.string.brow_yw_cn), "emotion.question.gif");
    localHashMap.put(getString(paramContext, R.string.brow_bs_cn), "emotion.bs.gif");
    localHashMap.put(getString(paramContext, R.string.brow_xh_cn), "rose.up.png");
    localHashMap.put(getString(paramContext, R.string.brow_dx_cn), "rose.down.png");
    localHashMap.put(getString(paramContext, R.string.brow_lw_cn), "chat.gift.png");
    localHashMap.put(getString(paramContext, R.string.brow_tkl_cn), "feedback.quickly.png");
    localHashMap.put(getString(paramContext, R.string.brow_tml_cn), "feedback.slowly.png");
    localHashMap.put(getString(paramContext, R.string.brow_zt_cn), "feedback.agreed.png");
    localHashMap.put(getString(paramContext, R.string.brow_fd_cn), "feedback.against.gif");
    localHashMap.put(getString(paramContext, R.string.brow_gz_cn), "feedback.applaud.png");
    localHashMap.put(getString(paramContext, R.string.brow_zdsk_cn), "feedback.think.png");
    localHashMap.put(getString(paramContext, R.string.emotion_bz_cn), "emotion.bz.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_fd_cn), "emotion.fd.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_gg_cn), "emotion.gg.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_gz_cn), "emotion.gz.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_hx_cn), "emotion.hx.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_jk_cn), "emotion.jk.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_jy_cn), "emotion.jy.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_kb_cn), "emotion.kb.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_kl_cn), "emotion.kl.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_ll_cn), "emotion.ll.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_qd_cn), "emotion.qd.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_qh_cn), "emotion.qh.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_qq_cn), "emotion.qq.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_rb_cn), "emotion.rb.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_se_cn), "emotion.se.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_tx_cn), "emotion.tx.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_xu_cn), "emotion.xu.gif");
    localHashMap.put(getString(paramContext, R.string.emotion_yun_cn), "emotion.yun.gif");
    SpanResource.initSendRichMap(localHashMap);
  }

  private static void initTextMap(Context paramContext)
  {
    HashMap localHashMap = new HashMap(18);
    putTextValue(localHashMap, paramContext, R.string.brow_nh_cn, R.string.brow_nh_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_zj_cn, R.string.brow_zj_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_gx_cn, R.string.brow_gx_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_sx_cn, R.string.brow_sx_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_fn_cn, R.string.brow_fn_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_wl_cn, R.string.brow_wl_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_lh_cn, R.string.brow_lh_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_yw_cn, R.string.brow_yw_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_bs_cn, R.string.brow_bs_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_xh_cn, R.string.brow_xh_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_dx_cn, R.string.brow_dx_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_lw_cn, R.string.brow_lw_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_tkl_cn, R.string.brow_tkl_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_tml_cn, R.string.brow_tml_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_zt_cn, R.string.brow_zt_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_fd_cn, R.string.brow_fd_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_gz_cn, R.string.brow_gz_cn_text);
    putTextValue(localHashMap, paramContext, R.string.brow_zdsk_cn, R.string.brow_zdsk_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_bz_cn, R.string.emotion_bz_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_fd_cn, R.string.emotion_fd_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_gg_cn, R.string.emotion_gg_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_gz_cn, R.string.emotion_gz_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_hx_cn, R.string.emotion_hx_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_jk_cn, R.string.emotion_jk_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_jy_cn, R.string.emotion_jy_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_kb_cn, R.string.emotion_kb_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_kl_cn, R.string.emotion_kl_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_ll_cn, R.string.emotion_ll_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_qd_cn, R.string.emotion_qd_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_qh_cn, R.string.emotion_qh_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_qq_cn, R.string.emotion_qq_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_rb_cn, R.string.emotion_rb_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_se_cn, R.string.emotion_se_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_tx_cn, R.string.emotion_tx_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_xu_cn, R.string.emotion_xu_cn_text);
    putTextValue(localHashMap, paramContext, R.string.emotion_yun_cn, R.string.emotion_yun_cn_text);
    SpanResource.initTextMap(localHashMap);
  }

  private static void initTextTipList(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(getString(paramContext, R.string.brow_tkl_cn));
    localArrayList.add(getString(paramContext, R.string.brow_tml_cn));
    localArrayList.add(getString(paramContext, R.string.brow_zt_cn));
    localArrayList.add(getString(paramContext, R.string.brow_fd_cn));
    localArrayList.add(getString(paramContext, R.string.brow_gz_cn));
    localArrayList.add(getString(paramContext, R.string.brow_zdsk_cn));
    SpanResource.initTextTipList(localArrayList);
  }

  private static void initUIMap(Context paramContext)
  {
    long l1 = Calendar.getInstance().getTimeInMillis();
    LinkedHashMap localLinkedHashMap1 = new LinkedHashMap(18);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_nh_cn, R.drawable.brow_nh);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_zj_cn, R.drawable.brow_zj);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_gx_cn, R.drawable.brow_gx);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_sx_cn, R.drawable.brow_sx);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_fn_cn, R.drawable.brow_fn);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_wl_cn, R.drawable.brow_wl);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_lh_cn, R.drawable.brow_lh);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_yw_cn, R.drawable.brow_yw);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_bs_cn, R.drawable.brow_bs);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_xh_cn, R.drawable.brow_xh);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_dx_cn, R.drawable.brow_dx);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_lw_cn, R.drawable.brow_lw);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_tkl_cn, R.drawable.brow_tkl);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_tml_cn, R.drawable.brow_tml);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_zt_cn, R.drawable.brow_zt);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_fd_cn, R.drawable.brow_fd);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_gz_cn, R.drawable.brow_gz);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.brow_zdsk_cn, R.drawable.brow_zdsk);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_bz_cn, R.drawable.emotion_bz);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_fd_cn, R.drawable.emotion_fd);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_gg_cn, R.drawable.emotion_gg);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_gz_cn, R.drawable.emotion_gz);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_hx_cn, R.drawable.emotion_hx);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_jk_cn, R.drawable.emotion_jk);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_jy_cn, R.drawable.emotion_jy);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_kb_cn, R.drawable.emotion_kb);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_kl_cn, R.drawable.emotion_kl);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_ll_cn, R.drawable.emotion_ll);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_qd_cn, R.drawable.emotion_qd);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_qh_cn, R.drawable.emotion_qh);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_qq_cn, R.drawable.emotion_qq);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_rb_cn, R.drawable.emotion_rb);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_se_cn, R.drawable.emotion_se);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_tx_cn, R.drawable.emotion_tx);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_xu_cn, R.drawable.emotion_xu);
    putBrowValue(localLinkedHashMap1, paramContext, R.string.emotion_yun_cn, R.drawable.emotion_yun);
    LinkedHashMap localLinkedHashMap2 = new LinkedHashMap(18);
    Iterator localIterator = localLinkedHashMap1.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        long l2 = Calendar.getInstance().getTimeInMillis();
        Log.i("initUIMap", "initUIMap time long = " + (l2 - l1));
        SpanResource.initUiMap(localLinkedHashMap2);
        return;
      }
      String str = (String)localIterator.next();
      if (str.substring(1, -1 + str.length()).endsWith(".gif"))
      {
        GifDrawalbe localGifDrawalbe = new GifDrawalbe(paramContext, ((Integer)localLinkedHashMap1.get(str)).intValue());
        localGifDrawalbe.readFrames(false);
        MyTextViewEx.putGifDrawableCache(((Integer)localLinkedHashMap1.get(str)).intValue(), localGifDrawalbe);
        Drawable localDrawable = localGifDrawalbe.getFrame(0);
        localLinkedHashMap2.put(str, zoomDrawable(paramContext, localDrawable, (int)(localDrawable.getIntrinsicWidth() * GifDrawalbe.ration), (int)(localDrawable.getIntrinsicHeight() * GifDrawalbe.ration)));
        continue;
      }
      localLinkedHashMap2.put(str, paramContext.getResources().getDrawable(((Integer)localLinkedHashMap1.get(str)).intValue()));
    }
  }

  private static void putBrowValue(Map<String, Integer> paramMap, Context paramContext, int paramInt1, int paramInt2)
  {
    paramMap.put(getString(paramContext, paramInt1), Integer.valueOf(paramInt2));
  }

  private static void putTextValue(Map<String, String> paramMap, Context paramContext, int paramInt1, int paramInt2)
  {
    paramMap.put(getString(paramContext, paramInt1), getString(paramContext, paramInt2));
  }

  public static void setImageGetter(Html.ImageGetter paramImageGetter)
  {
    SpanResource.setExtraImageGetter(new ExpressionResource.1());
  }

  private static Drawable zoomDrawable(Context paramContext, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    Bitmap localBitmap1 = drawableToBitmap(paramContext, paramDrawable);
    Matrix localMatrix = new Matrix();
    localMatrix.postScale((float)GifDrawalbe.ration, (float)GifDrawalbe.ration);
    Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, 0, i, j, localMatrix, true);
    localBitmap2.getWidth();
    localBitmap2.getHeight();
    return new BitmapDrawable(paramContext.getResources(), localBitmap2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.holder.chat.ExpressionResource
 * JD-Core Version:    0.6.0
 */