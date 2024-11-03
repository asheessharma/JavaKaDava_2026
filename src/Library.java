import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Publisher{
    public int publisherId;
    public String publisherName;
    public Publisher(int id , String name){
        publisherId = id;
        publisherName = name;
    }
}
class Magazine{
    public int magazineId;
    public String title;
    public String category;
    public double price;
    public Publisher publisher;
    public  Magazine(int id,String title, String category, double price, Publisher publisher){
        magazineId = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.publisher = publisher;
    }
}
public class Library {
    public  static List<Magazine> getMagazineByCategory(List<Magazine> list, String category){
        List<Magazine> ans = new ArrayList<>();
        for(Magazine temp: list){
            if(temp.category.equalsIgnoreCase(category)){
                ans.add(temp);
            }
        }
        return ans;
    }
    public static List<Magazine> applySubscriptionDiscount (List<Magazine>list , String category, double discount){
        List<Magazine> result = new ArrayList<>();
        for(Magazine mag : list){
            if(mag.category.equalsIgnoreCase(category)){
                mag.price = mag.price - (mag.price * discount / 100);
                result.add(mag);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfPublisher = sc.nextInt();
        List<Publisher> publishers = new ArrayList<>();
        List<Magazine> magazines= new ArrayList<>();
        for(int i = 0 ; i < numberOfPublisher ; i++){
            int publisherId = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            publishers.add(new Publisher(publisherId,name));
            int magazineId = sc.nextInt();
            sc.nextLine();
            String title = sc.nextLine();
            String category = sc.nextLine();
            double price = sc.nextDouble();
            sc.nextLine();
            magazines.add(new Magazine(magazineId,title,category,price,publishers.get(i)));
        }

        String categoryToSearch = sc.nextLine();
        List<Magazine> list = getMagazineByCategory(magazines,categoryToSearch);
        if(list.isEmpty()){
            System.out.println("No magazines found in the given category.");
        }else{
            for(Magazine temp : list){
                System.out.println(temp);
            }
        }
        String categoryForDiscount = sc.nextLine();
        double percentageDiscount = sc.nextDouble();
        List<Magazine> result = applySubscriptionDiscount(magazines,categoryForDiscount,percentageDiscount);
        if(result.isEmpty()){
            System.out.println("No magazines available in the specified category for discount.");
        }else{
            for(Magazine mags : result){
                System.out.println("Discounted "+ categoryForDiscount +" Magazines: " + mags.title);
            }
        }
        sc.close();

    }


}
