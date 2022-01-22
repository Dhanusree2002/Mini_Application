import java.util.*;

class amazon1 {
    private static Scanner sc;
    public static void  main(String[] args) {
        
        clear();
        sc=new Scanner(System.in);
        main();
        
    } 

    static void main(){
        clear();
        System.out.println("************ WELCOME TO AMAZON ************");
        System.out.println();
        System.out.println("PLEASE ENTER 1 IF YOU ARE A ADMIN");
        System.out.println("PLEASE ENTER 2 IF YOU ARE A MERCHANT");
        System.out.println("PLEASE ENTER 3 IF YOU ARE A USER");
        System.out.println("ENTER 4 TO EXIT");
        System.out.println();
        System.out.println("PLEASE ENTER ANY OF THE ABOVE OPTIONS");

        int option=sc.nextInt();
        
        switch(option){
            case 1:
                Admin.adlogin();
                break;
            case 2:
                Merchant.mcland();
                break;
            case 3:
                User.usland();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("INVALID INPUT");
                break;

        }
    }
    static void clear(){
        System.out.println("\033[H\033[2J");
    }

}

class Admin{

    static Scanner sc=new Scanner(System.in);
    static List<String> mer_name = new ArrayList<>();
    static List<String> mer_pass = new ArrayList<>();
    static List<String> mer_sta = new ArrayList<>();
    static List<String> product = new ArrayList<>();
    static List<Integer> count = new ArrayList<>();
    static List<Integer> count1 = new ArrayList<>();
    static List<Integer> cost = new ArrayList<>();
    static int user=0;
    

    static void adlogin(){
        amazon1.clear();

        System.out.println("********** WELCOME ADMIN **********");
        String username="uvw";
        String password="567";
        System.out.println("PLEASE ENTER YOUR USERNAME");
        String uname=sc.next();  
        System.out.println();
        System.out.println("PLEASE ENTER YOUR PASSWORD");
        String pass=sc.next();

        if((username.equals(uname))&&(password.equals(pass))){
            adfunc();
            
        }
        else{
            System.out.println("PLEASE ENTER A VALID USERNAME AND PASS WORD");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                amazon1.main();;
            }
            catch(Exception e){

            }
            
        }


    }

    static void adfunc(){
        amazon1.clear();
        System.out.println("PLEASE ENTER 1 TO ADD A MERCHANT ");
        System.out.println("PLEASE ENTER 2 TO SEE THE LIST OF MERCHANTS");
        System.out.println("PLEASE ENTER 3 APPROVE THE MERCHANTS");
        System.out.println("PLEASE ENTER 4 TO DELETE A MERCHANT");
        System.out.println("PLEASE ENTER 5 TO VIEW ALL PRODUCTS");
        System.out.println("PLEASE ENTER 6 TO ADD NEW PRODUCT");
        System.out.println("PLEASE ENTER 7 TO GO BACK");

        // admin_options=0;
        int admin_options=sc.nextInt();
        switch(admin_options){
            case 1:
                add_mc();
                break;
            case 2:
                show_mc();
                break;
            case 3:
                approve_mc();
                break;
            case 4:
                delete_mc();
                break;
            case 5:
                view_products();
                break;
            case 6:
                add_product();
                break;
            case 7:
                amazon1.main();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }

    static void add_mc(){

        amazon1.clear();
        System.out.println("ENTER THE USERNAME OF THE MERCHANT");
        String u=sc.next();
        System.out.println();
        System.out.println("ENTER THE PASSWORD FOR THE MERCHNAT");
        String p=sc.next();
        mer_name.add(u);
        mer_pass.add(p);
        mer_sta.add("pass");
        System.out.println();
        System.out.println("THE MERCHANT "+u+" HAS SUCCESSFULLY ADDED");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adfunc();
            }
            catch(Exception e){

            }

        
    }

    static void show_mc(){

        amazon1.clear();
        System.out.println("******* THE MERCHANTS ARE AS FOLLOWS *******");
        if(mer_name.size()>0){
            for(int i=0;i<mer_name.size();i++){
                System.out.println(mer_name.get(i));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adfunc();
            }
            catch(Exception e){

            }
        }
        else{
            System.out.println("THERE ARE NO SUCH MERCHANTS ");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adfunc();
            }
            catch(Exception e){

            }

        }

    }

    static void approve_mc(){

        amazon1.clear();

        for(int i=0;i<mer_sta.size();i++){
            if(mer_sta.get(i).equals("fail")){
                System.out.println("DO YOU WANT TO APPROVE THE MERCHNANT "+mer_name.get(i)+" .IF YES TYPE 1");
                int app=sc.nextInt();
                if(app==1){
                    mer_sta.set(i,"pass");
                    System.out.println("THE MERCHANT "+mer_name.get(i)+" HAS BEEN APPROVED");
                    System.out.println();
                }
                else{
                    System.out.println();
                    System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
                    try{
                        System.in.read();
                        adfunc();
                    }
                    catch(Exception e){

                    }

                }
            }
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            adfunc();
        }
        catch(Exception e){

        }

    }

    
    static void delete_mc(){ 

        amazon1.clear();
        System.out.println("ENTER THE MERCHANT USERNAME THAT HAS TO BE DELETED ");
        String u=sc.next();
        boolean flag=false;
        for (int i=0;i<mer_name.size();i++){
            if(mer_name.get(i).equals(u)){
                flag=true;
                user=i;

            }
        }
    
        if(flag){
            mer_name.remove(user);
            mer_pass.remove(user);
            System.out.println();
            System.out.println("THE MERCHANT IS SUCCESSFULLY REMOVED");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adfunc();
            }
            catch(Exception e){

            }

        }
        else{
            System.out.println("THE MERCHANT IS NOT FOUND PLEASE ENTER VALID MERCHANT");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adfunc();
            }
            catch(Exception e){

            }
        }
    }

    static void view_products(){

        amazon1.clear();
        if(product.size()>0){
            System.out.println("THE PRODUCTS AVAILABLE ARE LISTED AS FOLLOWS");
            System.out.println();
            System.out.println("PRODUCT"+"\t"+"QUANTITY"+"  "+"COST");
            System.out.println();
            for(int i=0;i<product.size();i++){
                System.out.println(product.get(i)+"\t"+count.get(i)+"\t"+cost.get(i));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adfunc();
            }
            catch(Exception e){

            }

        }
        else{

            System.out.println("THERE IS NO SUCH PRODUCTS AVAILABLE ");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adfunc();
            }
            catch(Exception e){

            }
            

        }
    }

    static void add_product(){

        amazon1.clear();
        System.out.println("ENTER THE NAME OF THE PRODUCT TO BE ADDED");
        String pro=sc.next();
        System.out.println();
        System.out.println("ENTER THE NUMBER OF PRODUCTS TO BE ADDED");
        int num_pro=sc.nextInt();
        System.out.println();
        System.out.println("ENTER THE COST OF THE PRODUCT ");
        int cos_pro=sc.nextInt();
        System.out.println();
        product.add(pro);
        count.add(num_pro);
        count1.add(num_pro);
        cost.add(cos_pro);
        System.out.println();
        System.out.println("THE PRODUCT "+pro+" HAS BEEN SUCCESSFULLY ADDED");
        System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adfunc();
            }
            catch(Exception e){

            }
    }



}

class Merchant{
    
    static Scanner sc=new Scanner(System.in);

    static void mcland(){

        amazon1.clear();
        System.out.println("********** WELCOME MERCHANT **********");
        System.out.println();
        System.out.println("PLEASE ENTER 1 REGISTER ");
        System.out.println("PLEASE ENTER 2 TO LOGIN ");
        System.out.println("PLEASE ENTER 3 TO GO BACK ");
        int log=sc.nextInt();

        switch(log){
            case 1:
                merchant_reg();
                break;
            case 2:
                merchant_login();
                break;
            case 3:
                amazon1.main();
                break;
            default:
                System.out.println("Invalid Input");
                break;

        }

    }

    static void merchant_reg(){

        amazon1.clear();

        System.out.println("ENTER YOUR USERNAME");
        String u_reg=sc.next();
        System.out.println();
        System.out.println("ENTER YOUR PASSWORD");
        String u_pass=sc.next();
        Admin.mer_name.add(u_reg);
        Admin.mer_pass.add(u_pass);
        Admin.mer_sta.add("fail");
        System.out.println();
        System.out.println("MERCHNANT HAS BEEN ADDED AND WAITING FOR APPROVAL");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try {
            System.in.read();
            mcland();
        } catch (Exception e) {
        }


    }



    static void merchant_login(){
        
        amazon1.clear();
        int us=0;
        System.out.println("ENTER YOUR USERNAME");           
        String u=sc.next();
        System.out.println("ENTER YOUR PASSWORD");
        String p=sc.next();

        for(int i=0;i<Admin.mer_name.size();i++){
            if(Admin.mer_name.get(i).equals(u)){
                us=i;
            }
        }
        if((Admin.mer_name.get(us).equals(u)) && (p.equals(Admin.mer_pass.get(us))) && (Admin.mer_sta.get(us).equals("pass"))){
            merchant_func();
        }
        else{
            System.out.println("INVALID USERNAME OR PASSWORD OR NOT APPROVED");
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                mcland();
            } catch (Exception e) {
            }
        }

    }

    static void merchant_func(){

        amazon1.clear();
        System.out.println("PLEASE ENTER 1 TO ADD A PRODUCTS ");
        System.out.println("PLEASE ENTER 2 TO UPDATE PRODUCT");
        System.out.println("PLEASE ENTER 3 TO VIEW MOST SOLD PRODUCT");
        System.out.println("PLEASE ENTER 4 TO VIEW SALES REPORT");
        System.out.println("PLEASE ENTER 5 TO VIEW ALL PRODUCTS");
        System.out.println("PLEASE ENTER 6 TO GO BACK");

        
        int merchant_options=sc.nextInt();
        switch(merchant_options){
            case 1:
                add_products();
                break;
            case 2:
                update_products();
                break;
            
            case 3:
                most_sold();
                break;
            case 4:
                sales_report();
                break;
            case 5:
                view_all();
                break;
            case 6:
                mcland();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }


    }
    
    static void add_products(){

        amazon1.clear();
        System.out.println("ENTER THE NAME OF THE PRODUCT TO BE ADDED");
        String pro=sc.next();
        System.out.println();
        System.out.println("ENTER THE NUMBER OF PRODUCTS TO BE ADDED");
        int num_pro=sc.nextInt();
        System.out.println();
        System.out.println("ENTER THE COST OF THE PRODUCT ");
        int cos_pro=sc.nextInt();
        System.out.println();
        Admin.product.add(pro);
        Admin.count.add(num_pro);
        Admin.count1.add(num_pro);
        Admin.cost.add(cos_pro);
        System.out.println();
        System.out.println("THE PRODUCT "+pro+" HAS BEEN SUCCESSFULLY ADDED");
        System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                merchant_func();
            }
            catch(Exception e){

            }
    }

    static void update_products(){

        int ind=0;
        amazon1.clear();
        System.out.println("ENTER THE NAME OF THE PRODUCT TO BE UPDATED");
        String pro=sc.next();
        System.out.println();
        boolean flag=false;
        for(int i=0;i<Admin.product.size();i++){
            if(Admin.product.get(i).equals(pro)){
                flag=true;
                ind=i;
            }
        }
        if(flag){
            System.out.println("ENTER THE NUMBER OF ITEMS THAT NEEDS TO BE UPDATED");
            int items=sc.nextInt();
            System.out.println();
            System.out.println("ENTER THE COST OF AN ITEM THAT NEEDS TO BE UPDATED");
            int ct=sc.nextInt();
            Admin.count.set(ind,items);
            Admin.cost.set(ind,ct);
            System.out.println("THE ITEM "+pro+" HAS BEEN SUCCESSFULLY UPDATED");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                merchant_func();
            }
            catch(Exception e){

            }

        }
        else{
            System.out.println("THE PRODUCT IS NOT AVAILABLE");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                merchant_func();
            }
            catch(Exception e){

            }

        }


    }

    static void most_sold(){

        amazon1.clear();
        int max=0;
        int n=0;
        for(int i=0;i<Admin.count.size();i++){
            if((Admin.count1.get(i)-Admin.count.get(i))>max){
                max=Admin.count1.get(i)-Admin.count.get(i);
                n=i;
            }
        }
        System.out.println("THE PRODUCT WITH MOST SALES ");
        System.out.println();
        System.out.println(Admin.product.get(n)+" "+max+" SOLD");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            merchant_func();
        }
        catch(Exception e){

        }


    }

    static void sales_report(){

        amazon1.clear();
        System.out.println("SALES REPORT");
        System.out.println();
        for(int i=0;i<User.report.size();i++){
            System.out.println(User.report.get(i));
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            merchant_func();
        }
        catch(Exception e){

        }


    }
    
    static void view_all(){

        amazon1.clear();
        if(Admin.product.size()>0){
            System.out.println("THE PRODUCTS AVAILABLE ARE");
            System.out.println();
            System.out.println("PRODUCT"+"\t"+"QUANTITY"+"  "+"COST");
            System.out.println();
            for(int i=0;i<Admin.product.size();i++){
                System.out.println(Admin.product.get(i)+"\t"+Admin.count.get(i)+"\t"+Admin.cost.get(i));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                merchant_func();;
            }
            catch(Exception e){

            }

        }
        else{

            System.out.println("THERE ARE NO SUCH PRODUCTS AVAILABLE ");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                merchant_func();
            }
            catch(Exception e){

            }
            

        }

    }

}

class User{

    static List<String> user_name = new ArrayList<>();
    static List<String> user_pass = new ArrayList<>();
    static List<String> cart = new ArrayList<>();
    static List<String> history = new ArrayList<>();
    static List<String> report = new ArrayList<>();

    
    static Scanner sc=new Scanner(System.in);

    static void usland(){

        amazon1.clear();
        System.out.println("********** WELCOME USER **********");
        System.out.println();
        System.out.println("PLEASE ENTER 1 TO REGISTER ");
        System.out.println("PLEASE ENTER 2 TO LOGIN ");
        System.out.println("PLEASE ENTER 3 TO GO BACK ");
        int log=sc.nextInt();


        switch(log){
            case 1:
                user_reg();
                break;
            case 2:
                user_login();
                break;
            case 3:
                amazon1.main();
                break;
            default:
                System.out.println("Invalid Input");
                break;

        }

    }

    static void user_reg(){

        amazon1.clear();

        System.out.println("ENTER YOUR USERNAME");
        String u_reg=sc.next();
        System.out.println();
        System.out.println("ENTER YOUR PASSWORD");
        String u_pass=sc.next();
        user_name.add(u_reg);
        user_pass.add(u_pass);
        System.out.println();
        System.out.println("REGISTRATION HAS BEEN SUCCESSFULLY COMPLETED AND NOW YOU CAN LOGIN ");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try {
            System.in.read();
            usland();
        } catch (Exception e) {
        }
    }

    static void user_login(){

        amazon1.clear();
        int us=0;
        System.out.println("ENTER YOUR USERNAME");           
        String u=sc.next();
        System.out.println("ENTER YOUR PASSWORD");
        String p=sc.next();

        for(int i=0;i<user_name.size();i++){
            if(user_name.get(i).equals(u)){
                us=i;
            }
        }
        if((user_name.get(us).equals(u)) && (p.equals(user_pass.get(us)))){
            user_func(us);
            
        }
        else{
            System.out.println("INVALID USERNAME OR PASSWORD");
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                usland();
            } catch (Exception e) {
            }
        }

    }

    static void user_func(int i){

        amazon1.clear();
        System.out.println("PLEASE ENTER 1 TO VIEW AVAILABLE PRODUCTS ");
        System.out.println("PLEASE ENTER 2 TO ADD PRODUCT TO CART");
        System.out.println("PLEASE ENTER 3 TO VIEW CART");
        System.out.println("PLEASE ENTER 4 TO VIEW PURCHASE HISTORY");
        System.out.println("PLEASE ENTER 5 TO BUY ITEMS");
        System.out.println("PLEASE ENTER 6 TO GO BACK");

        
        int user_options=sc.nextInt();
        switch(user_options){
            case 1:
                view_products(i);
                break;
            case 2:
                cart(i);
                break;
            case 3:
                view_cart(i);
                break;
            case 4:
                history(i);
                break;
            case 5:
                buy_items(i);
                break;
            case 6:
                usland();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }


    }

    static void view_products(int j){

        amazon1.clear();
        if(Admin.product.size()>0){
            System.out.println("THE PRODUCTS CURRENTLY AVAILABLE ARE");
            for(int i=0;i<Admin.product.size();i++){
                System.out.println(Admin.product.get(i)+"\t Cost : "+Admin.cost.get(i));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                user_func(j);
            }
            catch(Exception e){

            }

        }
        else{

            System.out.println("THERE IS NO SUCH PRODUCTS AVAILABLE ");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                user_func(j);
            }
            catch(Exception e){

            }
            

        }

    }

    static void cart(int i){

        amazon1.clear();
        System.out.println("ENTER THE PRODUCT TO BE ADDED IN CART");
        String pr=sc.next();
        System.out.println();
        boolean f=false;
        for(int j=0;j<Admin.product.size();j++){
            if(Admin.product.get(j).equals(pr)){
                f=true;
                cart.add(i,pr+"\t");
                System.out.println();
                System.out.println("THE PRODUCT HAS BEEN SUCCESSFULLY ADDED TO THE CART");
            }
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER TO GO PREVIOUS MENU ");
        try{
            System.in.read();
            user_func(i);
        }
        catch(Exception e){

        }
    }

    static void view_cart(int i){
            amazon1.clear();
            System.out.println("THE PRODUCTS IN THE CART ARE ");
            for(int j=0;j<cart.size();j++){
                System.out.println(cart.get(j));

            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                user_func(i);
            }
            catch(Exception e){

            }
        
    }
    static void history(int i){

        amazon1.clear();
        System.out.println("THE PURCHASED HISTORY");
        System.out.println();
        for(int j=0;j<history.size();j++){
            System.out.println(history.get(i));
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            user_func(i);
        }
        catch(Exception e){

        }

    }

    static void buy_items(int i){

        amazon1.clear();
        int x=0;
        System.out.println("ENTER THE NAME OF THE ITEM TO BE PURCHASED");
        String pr=sc.next();
        System.out.println();
        boolean f=false;
        for(int j=0;j<Admin.product.size();j++){
            if(Admin.product.get(j).equals(pr)){
                f=true;
                x=j;
            }
        }
        if(f){
            System.out.println("ENTER THE QUANTITY TO BE PURCHASED");
            int c=sc.nextInt();
            boolean f1=false;
            if(c<=Admin.count.get(x)){
                int tot=c*Admin.cost.get(x);
                System.out.println("THE TOTAL AMOUNT IS "+tot);
                System.out.println();
                System.out.println("DO YOU WANT TO BUY (y or n) ");
                String ans=sc.next();
                if(ans.equals("y")){
                    amazon1.clear();
                    System.out.println("THE ITEMS HAS BEEN SUCCESSFULLY PURCHASED ");
                    history.add("THE ITEM "+pr+" OF QUANTITY "+c+" PURCHASED FOR "+tot+" RUPEES");
                    report.add("THE ITEM "+pr+" OF QUANTITY "+c+" PURCHASED");
                    System.out.println();
                    int y=Admin.count.get(x);
                    y-=c;
                    Admin.count.set(x,y);
                    System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
                    try{
                        System.in.read();
                        user_func(i);
                    }
                    catch(Exception e){

                    }
                
                }
                else{
                    user_func(i);
                }
            }
            else{
                amazon1.clear();
                System.out.println("THE PRODUCT IS NOT AVAILABE");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
                try{
                    System.in.read();
                    user_func(i);
                }
                catch(Exception e){

                }
            }
        }
        else{
            amazon1.clear();
            System.out.println("THE PRODUCT IS NOT AVAILABE");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                user_func(i);
            }
            catch(Exception e){

            }

        }
        
    }

}