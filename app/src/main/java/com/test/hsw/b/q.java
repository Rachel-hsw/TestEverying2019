package b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Logger;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class q
{
  private static final Logger a = Logger.getLogger(q.class.getName());

  public static aa a(OutputStream paramOutputStream)
  {
    return a(paramOutputStream, new ac());
  }

  private static aa a(OutputStream paramOutputStream, ac paramac)
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException("out == null");
    if (paramac == null)
      throw new IllegalArgumentException("timeout == null");
    return new r(paramac, paramOutputStream);
  }

  public static aa a(Socket paramSocket)
    throws IOException
  {
    if (paramSocket == null)
      throw new IllegalArgumentException("socket == null");
    a locala = c(paramSocket);
    return locala.a(a(paramSocket.getOutputStream(), locala));
  }

  public static ab a(File paramFile)
    throws FileNotFoundException
  {
    if (paramFile == null)
      throw new IllegalArgumentException("file == null");
    return a(new FileInputStream(paramFile));
  }

  public static ab a(InputStream paramInputStream)
  {
    return a(paramInputStream, new ac());
  }

  private static ab a(InputStream paramInputStream, ac paramac)
  {
    if (paramInputStream == null)
      throw new IllegalArgumentException("in == null");
    if (paramac == null)
      throw new IllegalArgumentException("timeout == null");
    return new s(paramac, paramInputStream);
  }

  @IgnoreJRERequirement
  public static ab a(Path paramPath, OpenOption[] paramArrayOfOpenOption)
    throws IOException
  {
    if (paramPath == null)
      throw new IllegalArgumentException("path == null");
    return a(Files.newInputStream(paramPath, paramArrayOfOpenOption));
  }

  public static h a(aa paramaa)
  {
    if (paramaa == null)
      throw new IllegalArgumentException("sink == null");
    return new u(paramaa);
  }

  public static i a(ab paramab)
  {
    if (paramab == null)
      throw new IllegalArgumentException("source == null");
    return new w(paramab);
  }

  public static aa b(File paramFile)
    throws FileNotFoundException
  {
    if (paramFile == null)
      throw new IllegalArgumentException("file == null");
    return a(new FileOutputStream(paramFile));
  }

  @IgnoreJRERequirement
  public static aa b(Path paramPath, OpenOption[] paramArrayOfOpenOption)
    throws IOException
  {
    if (paramPath == null)
      throw new IllegalArgumentException("path == null");
    return a(Files.newOutputStream(paramPath, paramArrayOfOpenOption));
  }

  public static ab b(Socket paramSocket)
    throws IOException
  {
    if (paramSocket == null)
      throw new IllegalArgumentException("socket == null");
    a locala = c(paramSocket);
    return locala.a(a(paramSocket.getInputStream(), locala));
  }

  private static a c(Socket paramSocket)
  {
    return new t(paramSocket);
  }

  public static aa c(File paramFile)
    throws FileNotFoundException
  {
    if (paramFile == null)
      throw new IllegalArgumentException("file == null");
    return a(new FileOutputStream(paramFile, true));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.q
 * JD-Core Version:    0.6.0
 */