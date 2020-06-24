package exception;

public class ThrowFinallyTest {

  public void throwBeforeFinally() throws GoodException {
    int a = 9;
    try {
      if (a > 0) {
        throw new GoodException("Variable a should be less than 0.");
      }
    } finally {
      System.out.println("In finally");
    }
  }

  public static class GoodException extends Exception {
    public GoodException() {
      super();
    }

    public GoodException(String desc) {
      super(desc);
    }

    public GoodException(String desc, Throwable cause) {
      super(desc, cause);
    }
  }

  public static void main(String[] args) {
    ThrowFinallyTest test = new ThrowFinallyTest();
    try {
      test.throwBeforeFinally();
    } catch (GoodException e) {
      System.out.println(e.toString());
    }
  }
}
