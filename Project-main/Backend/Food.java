package Backend;

// อาหาร 1 อย่าง
public class Food {
    // foodname = ชื่ออาหาร
    // foodprice = ราคาของอาหาร
    // foodID = รหัสอาหาร
    private final String foodID;
    private final String foodname;
    private final double foodprice;
    
    public Food(String foodID,String foodname,double foodprice) {
        this.foodID = foodID;
        this.foodname = foodname;
        this.foodprice = foodprice;
        
    }
    
    /**
     * @return ชื่ออาหาร
     */
    public String getfoodName() {
        return foodname;
    }

    /* 
    * @return ราคาของอาหาร
    */
    public double getPrice() {
        return foodprice;
    }

    /**
     * @return รหัสอาหาร
     */
    public String getfoodID() {
        return foodID;
    }

    /**
     * เปรียบเทียบ Product สองชิ้นโดยใช้ productId
     * 
     * @param obj อ็อบเจกต์ที่ต้องการเปรียบเทียบ
     * @return true หาก productId เหมือนกัน
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Food fd = (Food) obj;
        return foodID.equals(fd.foodID);
    }

}
