package b;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

final class t extends a
{
  t(Socket paramSocket)
  {
  }

  protected void a()
  {
    try
    {
      this.a.close();
      return;
    }
    catch (Exception localException)
    {
      q.a().log(Level.WARNING, "Failed to close timed out socket " + this.a, localException);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.t
 * JD-Core Version:    0.6.0
 */