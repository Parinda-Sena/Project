package Services;
import java.util.ArrayList;
/*
 * รายการอาหารทั้งหมด
 */
public class AllFood {
    private ArrayList <FoodMenu> menu = new ArrayList<>();
    private void checkRep(){
        if(menu == null){
            throw new RuntimeException("RI violated: menu");
        }
    for (int i=0; i<menu.size();i++){
         for (int j=i+1; j<menu.size();j++){
            if(menu.get(i).equals(menu.get(j))){
               throw new RuntimeException("RI violated: menu"); 
            }
            }
        }
    }
    public AllFood(){
        checkRep();
    }
    // เพิ่มเมนู
    public void addFood(FoodMenu food){
        if (food!= null&&!menu.contains(food)){
            menu.add(food);
        }
        checkRep();
    }
    //ค้นหาเมนูจากชื่อ
    public FoodMenu findByName(String NameFood){
        for (FoodMenu m : menu){
            if (m.getNameFood().equalsIgnoreCase(NameFood)){
                return m; 
            }
        }
        return null;
    }
}
