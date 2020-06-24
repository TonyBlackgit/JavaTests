package basic;

public class DynamicBindTest {
  public static void main(String[] args) {
    People p = new People(){
      String speak(){
        return "lhd";
      }
    };
    p.brak();
  }
}

class People{
  public void brak(){
    System.out.println(speak());
  }
  // 当这个方法是private的时候，不存在override关系
  private String speak(){
    return "People";
  }
}
