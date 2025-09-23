package Services;
/*
 * เก็บข้อมูลอาหารแต่ละจาน มีชื่อ ราคา
 */
public final class FoodMenu {
        private final String NameFood;
        private final double Price;
private void checkRep(){
    if (NameFood == null || NameFood.isBlank()){
       throw new RuntimeException("RI violated: NameFood"); 
    }
     if (Price<0){
       throw new RuntimeException("RI violated: Price"); 
    }
}
        public FoodMenu (String NameFood,double Price){
            this.NameFood = NameFood;
            this.Price = Price;
            checkRep();
        }

        public String getNameFood(){
            return NameFood;
        }
         public double getPrice(){
            return Price;
        }
        /***
         * เปรียบเทียบเมนู 2 อย่าง โดยใช้ชื่อ
         * @param ออบเจ็กต์ที่ต้องการเปรียบเทียบ
         * @return หากชื่อเหมือนกัน
         */
       @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof FoodMenu)) return false;
        FoodMenu other = (FoodMenu) obj;
        return this.NameFood.equalsIgnoreCase(other.NameFood);
        }
    }
