public class ImplementTest {
    public static void main(String[] args) {                      //接口
       /* Income[] income = new Income[]{new Income(500), new Salary(500)};
        System.out.println(totalTax(income));
    }
    
    public static double totalTax(Income[] income) {
        double total = 0;
        for(Income income1:income){
            total+=income1.getTax();
        }
        return total;
    }*/
        Income income = new Salary(500);
        System.out.println(income.getTax());
        int i = 4;
        Person p=new Person();
    }
}


interface Income {
    //protected double income;
    
    double getincome();
    
    default double getTax() {
        return getincome() * 0.2;
    }
}

class Salary implements Income {
    
    private double income;
    
    public Salary(double income) {
        this.income = income;
    }
    
    public double getincome() {
        return this.income;
    }
}