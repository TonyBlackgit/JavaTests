package basic;

import java.util.HashMap;
import java.util.Map;

public class ChemistryWord {

  Map<String, Long> result = new HashMap<>();
  public static void main(String[] args) {
    String str;
    if(args[0] == null){
      str = args[0];
    }else{
      str = "";
    }
    StringBuilder stringBuilder = new StringBuilder(str);
    doWork(stringBuilder);
  }
  private static void doWork(StringBuilder sb){

  }
}
