import java.util.*;
public class atm {

    static int notes[]={0,0,0,0};
    static int amt_val[]={2000,500,200,100};

    static String usname[]={"L","M","N","O","P"};
    static String password[]={"5","6","7","8","9"};
    static int ubal[]={10000,12000,14000,16000,18000};
    static List<String> l1= new ArrayList<>();
    static List<String> l2= new ArrayList<>();
    static List<String> l3= new ArrayList<>();
    static List<String> l4= new ArrayList<>();
    static List<String> l5= new ArrayList<>();
    static String us,ps,trans;

    static int total=0,user=0,amt,note,sum=0,tran=0,am;
    private static Scanner sc;

    static void main(){

        System.out.print("\033[H\033[2J");
        System.out.println("************ WELCOME TO ABC ATM ************");
        System.out.println();
        System.out.println("ENTER 1 IF YOU ARE A ADMIN");
        System.out.println("ENTER 2 IF YOU ARE A USER");
        System.out.println("ENTER 3 TO EXIT");
        System.out.println();
        System.out.println("PLEASE ENTER ANY OF THE ABOVE OPTIONS");
        
        int option=0;
        option=sc.nextInt();
        switch(option){
            case 1:
                adlogin();
                break;
            case 2:
                uslogin();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }

    }

    static void adlogin(){

        System.out.print("\033[H\033[2J");
        String username="uvw";
        String password="123";
        System.out.println("Please enter your username");
        String uname=sc.next();  
        System.out.println();
        System.out.println("Please enter your password");
        String upass=sc.next();

        if((username.equals(uname))&&(password.equals(upass))){
            adfunc();
            
        }
        else{
            System.out.println("PLEASE ENTER A VALID USERNAME AND PASSWORD");
            main();

        }
    }

    static void adfunc(){
        System.out.print("\033[H\033[2J");
        System.out.println("ENTER 1 TO ADD AMOUNT IN THE ATM ");
        System.out.println("ENTER 2 TO CHECK THE BALANCE OF THE ATM");
        System.out.println("ENTER 3 TO GO BACK");
        int admin_options=0;
        admin_options=sc.nextInt();
        switch(admin_options){
            case 1:
                add_amt();
                break;
            case 2:
                show_amt();
                break;
            case 3:
                main();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }

    }

    static void add_amt(){

        System.out.print("\033[H\033[2J");
        for(int i=0;i<4;i++){
            System.out.println("Enter number of "+amt_val[i]+ " notes "); 
            notes[i]=sc.nextInt();
            System.out.println();
        }
        for(int i=0;i<4;i++){
            total+=amt_val[i]*notes[i];
        }
        System.out.print("\033[H\033[2J");
        System.out.println("Amount has been added successfully");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER TO GO BACK ");
        try{
            System.in.read();
            adfunc();
        }
        catch(Exception e){

        }

    }

    static void show_amt(){
        System.out.print("\033[H\033[2J");
        for(int i=0;i<4;i++){
            System.out.println("Number of notes in "+amt_val[i]+" is " +notes[i]);
        }
        System.out.println("Total amount present in the atm "+total);
        System.out.println();
        System.out.println("PLEASE PRESS ENTER TO GO BACK ");
        try{
            System.in.read();
            adfunc();
        }
        catch(Exception e){

        }

    }

    static void uslogin(){
        System.out.print("\033[H\033[2J");               
        System.out.println("Enter your Username");           
        us=sc.next();
        System.out.println("Enter your Password");
        ps=sc.next();

        for(int i=0;i<usname.length;i++){
            if(usname[i].equals(us)){
                user=i;
            }
        }
        if((usname[user].equals(us)) && (ps.equals(password[user]))){
            usfunc(user);
        }
        else{
            System.out.println("INVALID USERNAME OR PASSWORD");
            System.out.println("PRESS ENTER TO GO BACK ");
            try {
                System.in.read();
                uslogin();
            } catch (Exception e) {
            }
        }

    }

    static void usfunc(int user){

        System.out.print("\033[H\033[2J");
        System.out.println("ENTER 1 TO WITHDRAW AMOUNT");
        System.out.println("ENTER 2 TO CHECK BALANCE");
        System.out.println("ENTER 3 TO DEPOSIT AMOUNT");
        System.out.println("ENTER 4 TO CHANGE THE PIN ");
        System.out.println("ENTER 5 TO TRANSFER AMOUNT ");
        System.out.println("ENTER 6 TO MINI STATEMENT ");
        System.out.println("ENTER 7 TO GO BACK");
        int ch1 = sc.nextInt();
        switch (ch1) {
            case 1:
                withdraw_amount(user);
                break;
            case 2:
                show_balance(user);
                break;
            case 3:
                deposit(user);
                break;
            case 4:
                pin_change(user);
                break;
            case 5:
                transfer(user);
                break;
            case 6:
                mini(user);
                break;
            case 7:
                main();
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    static void withdraw_amount(int i){

        int rem=0,rem1=0,rem2=0,rem3=0;
        System.out.print("\033[H\033[2J");
        System.out.println("Enter amount to be withdrawn ");
        amt=sc.nextInt();

        if((amt<=total)){
            if(amt<ubal[i])
                if(amt%100==0){
                    int temp=amt;

                    if(temp>=2000){
                        rem=temp/2000;
                        temp=temp%2000;
                    }
                    if(temp>=500){
                        rem1=temp/500;
                        temp=temp%500;
                    }
                    if(temp>=200){
                        rem2=temp/200;
                        temp=temp%200;
                    }
                    if(temp>=100){
                        rem3=temp/100;
                    }
                    if((rem<=notes[0]) &&  (rem1<=notes[1]) && (rem2<=notes[2]) && (rem3<=notes[3])){
                        notes[0]=notes[0]-rem;
                        notes[1]=notes[1]-rem1;
                        notes[2]=notes[2]-rem2;
                        notes[3]=notes[3]-rem3;
                        ubal[i]-=amt;
                        total-=amt;
                        System.out.println("Amount has been withdrawn successfully");
                        System.out.println();
                        if(i==0){
                            l1.add("Withdrawn"+"\t"+amt);
                        }
                        if(i==1){
                            l2.add("Withdrawn"+"\t"+amt);
                        }
                        if(i==2){
                            l3.add("Widthdrawn"+"\t"+amt);
                        }
                        if(i==3){
                            l4.add("Withdrawn"+"\t"+amt);
                        }
                        if(i==4){
                            l5.add("Widthdrawn"+"\t"+amt);
                        }
                        System.out.println("PRESS ENTER TO GO BACK ");
                        try {
                            System.in.read();
                            usfunc(i);
                        } catch (Exception e) {
                        }
                    }
                    else{
                        System.out.println("NOTES ARE NOT AVAILABLE");
                        System.out.println();
                        System.out.println("PRESS ENTER TO GO BACK ");
                        try {
                            System.in.read();
                            usfunc(i);
                        } catch (Exception e) {
                        }
                    }
                }
                else{
                    System.out.println("Enter amount in 100's ");
                    System.out.println();
                    System.out.println("PRESS ENTER TO GO BACK ");
                    try {
                        System.in.read();
                        usfunc(i);
                    } catch (Exception e) {
                    }
                }
            else{
                System.out.println("Your account has insufficients funds for withdrawal");
                System.out.println();
                System.out.println("PRESS ENTER TO GO BACK ");
                try {
                    System.in.read();
                    usfunc(i);
                } catch (Exception e) {
                }
                    }
                }
        else{
            System.out.println("Due to insufficient funds the ATM cannot dispense");
            System.out.println();
            System.out.println("PRESS ENTER TO GO BACK ");
            try {
                System.in.read();
                usfunc(i);
            } catch (Exception e) {
            }
        }


    }

    static void show_balance(int i){

        System.out.print("\033[H\033[2J");
        System.out.println("Your account balance is " + ubal[i]);
        System.out.println();
        System.out.println("PRESS ENTER TO GO BACK ");
        try {
            System.in.read();
            usfunc(i);
        } catch (Exception e) {
        }
    }

    static void deposit(int i){

        System.out.print("\033[H\033[2J");
        for(int j=0;j<4;j++){
            System.out.println("Enter number of "+amt_val[j]+ " notes ");
            note=sc.nextInt();
            System.out.println();
            notes[j]+=note;
            sum+=note*amt_val[j];

        }
        total+=sum;
        ubal[i]+=sum;
        if(i==0){
            l1.add("Deposited"+"\t"+sum);
        }
        if(i==1){
            l2.add("Deposited"+"\t"+sum);
        }
        if(i==2){
            l3.add("Deposited"+"\t"+sum);
        }
        if(i==3){
            l4.add("Deposited"+"\t"+sum);
        }
        if(i==4){
            l5.add("Deposited"+"\t"+sum);
        }
        System.out.print("\033[H\033[2J");
        System.out.println("Amount has been added successfully");
        System.out.println();
        System.out.println("PRESS ENTER TO GO BACK ");
        try{
            System.in.read();
            usfunc(i);
        }
        catch(Exception e){

        }


    }

    static void pin_change(int i){

        System.out.print("\033[H\033[2J");
        System.out.println("Enter old Password");
        String oldpass=sc.next();

        if(oldpass.equals(password[i])){
            System.out.print("\033[H\033[2J");
            System.out.println("Enter new Password");
            String newpass=sc.next();
            System.out.println();
            System.out.println("Confirm Password");
            String confirmpass=sc.next();
            if(confirmpass.equals(newpass)){
                password[i]=newpass;
                System.out.println("PASSWORD CHANGED SUCCESSFULLY");
            }
            else{
                System.out.println("PASSWORD DOESN'T MATCH");
            }
        
        }
        else{
            System.out.println("ENTER CORRECT PASSWORD");
    
            System.out.println();
            System.out.println("PRESS ENTER TO GO BACK ");
            try {
                System.in.read();
                usfunc(i);
            } catch (Exception e) {
            }
        }
        System.out.println("PRESS ENTER TO GO BACK ");
            try {
                System.in.read();
                usfunc(i);
            } catch (Exception e) {
            }

    }

    static void transfer(int i){

        System.out.print("\033[H\033[2J");
        System.out.println("Enter the username for the amount to be transferred ");
        trans=sc.next();
        boolean flag=false;
        for(int j=0;j<usname.length;j++){
            if(trans.equals(usname[j])){
                flag=true;
                tran=j;
            }
        }
        System.out.println("Enter amount to be transferred to user "+trans);
        am=sc.nextInt();
        if(flag){
            ubal[tran]+=am;
            ubal[i]-=am;
            System.out.println("The amount "+am+" has been successfully transferred to "+trans);
            if(i==0){
                l1.add("Transferred"+"\t"+am);
            }
            if(i==1){
                l2.add("Transferred"+"\t"+am);
            }
            if(i==2){
                l3.add("Transferred"+"\t"+am);
            }
            if(i==3){
                l4.add("Transferred"+"\t"+am);
            }
            if(i==4){
                l5.add("Transferred"+"\t"+am);
            }
            System.out.println();
            System.out.println("PRESS ENTER TO GO BACK ");
            try {
                System.in.read();
                usfunc(i);
            } catch (Exception e) {
            }

        }
        else{
            System.out.println("PLEASE ENTER VALID USERNAME");
            System.out.println();
            System.out.println("PRESS ENTER TO GO BACK ");
            try {
                System.in.read();
                usfunc(i);
            } catch (Exception e){
            }
        }



    }

    static void mini(int i){
        System.out.print("\033[H\033[2J");

        if((i==0)&&(l1.size()>=6)){
            for(int j=0;j<l1.size();j++){
                System.out.println(l1.get(j));
            }
            System.out.println();
            System.out.println("PRESS ENTER TO GO BACK ");
            try {
                System.in.read();
                usfunc(i);
            } catch (Exception e) {
            }
        }
        else{
            System.out.println("NEED MINIMUN 6 ACTIONS TO SHOW MINI STATEMENT");
            System.out.println();
            System.out.println("PRESS ENTER TO GO BACK ");
            try {
                System.in.read();
                usfunc(i);
            } catch (Exception e) {
            }
        }


        if((i==1)&&(l1.size()>=6)){
            for(int j=0;j<l1.size();j++){
                System.out.println(l2.get(j));
            }
            System.out.println();
            System.out.println("PRESS ENTER TO GO BACK ");
            try {
                System.in.read();
                usfunc(i);
            } catch (Exception e) {
            }
        }
        else{
            System.out.println("NEED MINIMUN 6 ACTIONS TO SHOW MINI STATEMENT");
            System.out.println();
            System.out.println("PRESS ENTER TO GO BACK ");
            try {
                System.in.read();
                usfunc(i);
            } catch (Exception e) {
            }
        }


        if((i==2)&&(l1.size()>=6)){
            for(int j=0;j<l1.size();j++){
                System.out.println(l3.get(j));
            }
            System.out.println();
            System.out.println("PRESS ENTER TO GO BACK ");
            try {
                System.in.read();
                usfunc(i);
            } catch (Exception e) {
            }
        }
        else{
            System.out.println("NEED MINIMUN 6 ACTIONS TO SHOW MINI STATEMENT");
            System.out.println();
            System.out.println("PRESS ENTER TO GO BACK ");
            try {
                System.in.read();
                usfunc(i);
            } catch (Exception e) {
            }
        }
        

        if((i==3)&&(l1.size()>=6)){
            for(int j=0;j<l1.size();j++){
                System.out.println(l4.get(j));
            }
            System.out.println();
            System.out.println("PRESS ENTER TO GO BACK ");
            try {
                System.in.read();
                usfunc(i);
            } catch (Exception e) {
            }
        }
        else{
            System.out.println("NEED MINIMUN 6 ACTIONS TO SHOW MINI STATEMENT");
            System.out.println();
            System.out.println("PRESS ENTER TO GO BACK ");
            try {
                System.in.read();
                usfunc(i);
            } catch (Exception e) {
            }
        }


        if((i==4)&&(l1.size()>=6)){
            for(int j=0;j<l5.size();j++){
                System.out.println(l5.get(j));
            }
            System.out.println();
            System.out.println("PRESS ENTER TO GO BACK ");
            try {
                System.in.read();
                usfunc(i);
            } catch (Exception e) {
            }
        }
        else{
            System.out.println("NEED MINIMUN 6 ACTIONS TO SHOW MINI STATEMENT");
            System.out.println();
            System.out.println("PRESS ENTER TO GO BACK ");
            try {
                System.in.read();
                usfunc(i);
            } catch (Exception e) {
            }
        }

    }
    

    public static void main(String args[]){
        sc=new Scanner(System.in);
        main();

    }
}
