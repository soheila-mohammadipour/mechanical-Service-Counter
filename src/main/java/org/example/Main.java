package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

/*
1-max===>56 per day
2-date now ==> chek and welcome Massage
3-if(date < 8AM)==>dont Record info ,return
4-while(true)==> start program
5-menu ==> {     1-0==> exite programm
                 2-record info enter car (nomber,name,mobile)
                 3-show remain &enterd & exited
                 4-record info service
                 5-exite car
                 6-title Service
                 7- price-service

 */
public class Main {

    private  static int maxService=56;


    public static void main(String[] args)  {


        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.getHour() + ":" + dateTime.getMinute());
        if (dateTime.getHour() < 8) {
            System.out.println("Working day not Started yet");
            return;
        } else {
            System.out.println("welcome to Mechnic and today is :" + (dateTime.getDayOfWeek()));
        }




        while (true) {
            String[] numbers= new String[maxService];
            String[] names= new String[maxService];
            String[] mobiles= new String[maxService];
            Boolean[] exitedList= new Boolean[maxService];
            Long[][] invoicePrices=new Long[maxService][];
            String[][] invoiceTittle = new String[maxService][];
            int currentIndex =0;

            showMenu();
            int menu=getMenue();
            switch (menu){
                case 1:
                    print("Please enter car Number:");
                    numbers[currentIndex] =getInput();
                    print("Please enter car`s Driver name:");
                    names[currentIndex] =getInput();
                    print("Please enter Driver mobile:");
                    mobiles[currentIndex] =getInput();
                    exitedList[currentIndex] = false;
                    print("your Number for exite is:"+ currentIndex);
                    currentIndex++;

                    break;

                case 2:
                    int remain=maxService - currentIndex;
                    int exited=0,entered=0;
                    for (Boolean item:exitedList){

                        if (item==null) continue;
                        else if (item) exited++;
                        else entered++;

                    }
                    print("Remains :" + remain);
                    print("Exited :" + exited) ;
                    print("Entered :" + entered);
                    break;
                case 3:
                    print("Please enter service Number :");
                    Integer number =Integer.parseInt(getInput());
                    if (!chekedNumberValidity(number)){
                        print("Your Number is invalid");
                        break;
                    }
                    print("Number :" + numbers[number]);
                    print("Name :" + names[number]);
                    print("Mobile :" + mobiles[number]);
                    break;

                case 4:
                    print("Please enter servise Number :");
                    Integer serviceNumber =Integer.parseInt(getInput());
                    if (!chekedNumberValidity(serviceNumber)){
                        print("Your Number is invalid");
                        break;
                    }

                    print("Please enter invoice item count :");
                    Integer invoiceItemCount = Integer.parseInt(getInput());
                    Long totalprice=0l;
                    for (int index = 0;index <invoiceItemCount;index++){
                        print("[" + (index +1) + "Please enter invoice item title :");
                        invoiceTittle[serviceNumber][index]=getInput();
                        print("[" + (index +1) + "Please enter invoice item price :");
                        invoicePrices[serviceNumber][index]= Long.parseLong(getInput());
                        totalprice +=invoicePrices[serviceNumber][index];


                    }

                    exitedList[serviceNumber]=true;
                    print("Total Price :"+ totalprice);
                    break;

                case  0:
                    System.out.println("Have a nice Day");
                    return;

            }


        }






    }
    private static int getMenue() {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));

        try {
             return Integer.parseInt (bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private static void showMenu() {
        System.out.println("Please enter menu Number to continue : ");
        System.out.println("1-Please enter the Car Information :");
        System.out.println("2-Show remain & enterd & exited cars count :");
        System.out.println("3-Show details cars service");
        System.out.println("4-Exit a car");
        System.out.println("0-Exit Programm");
    }

    public static void print(String message){
        System.out.println(message);

    }
    private static String getInput() { BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));

        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static boolean chekedNumberValidity(Integer serviceNumber) {
        if (serviceNumber <0 || serviceNumber > maxService){
        return false;
    }else {
        return true;
    }









}
}