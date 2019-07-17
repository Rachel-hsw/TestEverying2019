package com.bokecc.sdk.mobile.download;

class c
  implements Runnable
{
  c(Downloader paramDownloader)
  {
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/bokecc/sdk/mobile/download/c:a	Lcom/bokecc/sdk/mobile/download/Downloader;
    //   4: invokestatic 28	com/bokecc/sdk/mobile/download/Downloader:j	(Lcom/bokecc/sdk/mobile/download/Downloader;)Lcom/bokecc/sdk/mobile/download/OnProcessDefinitionListener;
    //   7: ifnonnull +64 -> 71
    //   10: new 18	com/bokecc/sdk/mobile/exception/DreamwinException
    //   13: dup
    //   14: getstatic 34	com/bokecc/sdk/mobile/exception/ErrorCode:PROCESS_FAIL	Lcom/bokecc/sdk/mobile/exception/ErrorCode;
    //   17: iconst_1
    //   18: anewarray 36	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: ldc 38
    //   25: aastore
    //   26: invokespecial 41	com/bokecc/sdk/mobile/exception/DreamwinException:<init>	(Lcom/bokecc/sdk/mobile/exception/ErrorCode;[Ljava/lang/String;)V
    //   29: athrow
    //   30: astore_3
    //   31: ldc 43
    //   33: new 45	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   40: aload_3
    //   41: invokevirtual 50	com/bokecc/sdk/mobile/exception/DreamwinException:getMessage	()Ljava/lang/String;
    //   44: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 56
    //   49: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 65	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   58: pop
    //   59: aload_0
    //   60: getfield 12	com/bokecc/sdk/mobile/download/c:a	Lcom/bokecc/sdk/mobile/download/Downloader;
    //   63: aload_3
    //   64: invokevirtual 69	com/bokecc/sdk/mobile/exception/DreamwinException:getErrorCode	()Lcom/bokecc/sdk/mobile/exception/ErrorCode;
    //   67: invokestatic 73	com/bokecc/sdk/mobile/download/Downloader:b	(Lcom/bokecc/sdk/mobile/download/Downloader;Lcom/bokecc/sdk/mobile/exception/ErrorCode;)V
    //   70: return
    //   71: aload_0
    //   72: getfield 12	com/bokecc/sdk/mobile/download/c:a	Lcom/bokecc/sdk/mobile/download/Downloader;
    //   75: aload_0
    //   76: getfield 12	com/bokecc/sdk/mobile/download/c:a	Lcom/bokecc/sdk/mobile/download/Downloader;
    //   79: invokestatic 76	com/bokecc/sdk/mobile/download/Downloader:b	(Lcom/bokecc/sdk/mobile/download/Downloader;)Ljava/lang/String;
    //   82: aload_0
    //   83: getfield 12	com/bokecc/sdk/mobile/download/c:a	Lcom/bokecc/sdk/mobile/download/Downloader;
    //   86: invokestatic 79	com/bokecc/sdk/mobile/download/Downloader:c	(Lcom/bokecc/sdk/mobile/download/Downloader;)Ljava/lang/String;
    //   89: aload_0
    //   90: getfield 12	com/bokecc/sdk/mobile/download/c:a	Lcom/bokecc/sdk/mobile/download/Downloader;
    //   93: invokestatic 82	com/bokecc/sdk/mobile/download/Downloader:d	(Lcom/bokecc/sdk/mobile/download/Downloader;)Ljava/lang/String;
    //   96: invokestatic 85	com/bokecc/sdk/mobile/download/Downloader:a	(Lcom/bokecc/sdk/mobile/download/Downloader;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 12	com/bokecc/sdk/mobile/download/c:a	Lcom/bokecc/sdk/mobile/download/Downloader;
    //   103: invokestatic 28	com/bokecc/sdk/mobile/download/Downloader:j	(Lcom/bokecc/sdk/mobile/download/Downloader;)Lcom/bokecc/sdk/mobile/download/OnProcessDefinitionListener;
    //   106: aload_0
    //   107: getfield 12	com/bokecc/sdk/mobile/download/c:a	Lcom/bokecc/sdk/mobile/download/Downloader;
    //   110: invokestatic 89	com/bokecc/sdk/mobile/download/Downloader:k	(Lcom/bokecc/sdk/mobile/download/Downloader;)Ljava/util/HashMap;
    //   113: invokeinterface 95 2 0
    //   118: return
    //   119: astore_1
    //   120: ldc 43
    //   122: new 45	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   129: aload_1
    //   130: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   133: ldc 56
    //   135: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 65	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   144: pop
    //   145: aload_0
    //   146: getfield 12	com/bokecc/sdk/mobile/download/c:a	Lcom/bokecc/sdk/mobile/download/Downloader;
    //   149: getstatic 101	com/bokecc/sdk/mobile/exception/ErrorCode:NETWORK_ERROR	Lcom/bokecc/sdk/mobile/exception/ErrorCode;
    //   152: invokestatic 73	com/bokecc/sdk/mobile/download/Downloader:b	(Lcom/bokecc/sdk/mobile/download/Downloader;Lcom/bokecc/sdk/mobile/exception/ErrorCode;)V
    //   155: return
    //   156: astore 4
    //   158: ldc 103
    //   160: new 45	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   167: aload 4
    //   169: invokevirtual 104	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   172: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc 106
    //   177: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 65	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   186: pop
    //   187: goto -128 -> 59
    //
    // Exception table:
    //   from	to	target	type
    //   0	30	30	com/bokecc/sdk/mobile/exception/DreamwinException
    //   71	118	30	com/bokecc/sdk/mobile/exception/DreamwinException
    //   0	30	119	org/json/JSONException
    //   71	118	119	org/json/JSONException
    //   31	59	156	java/lang/Exception
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.download.c
 * JD-Core Version:    0.6.0
 */