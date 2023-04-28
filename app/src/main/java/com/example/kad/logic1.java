package com.example.kad;

public class logic1 {

    public int sum(int num1, int num2){
        return (num1+num2);
    }

    public boolean name_length(String email){
        if (email.length()<= 70 & email.length() > 0){
            return true;
        }
        return false;

    }
    public boolean string_alphabet(String name){
        return name.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
//        it was [a-zA-Z]+
    }

//    public first_last(String){
//        // ensures that there is two words, first and last name
//    }

    public boolean blacklist(String name){
        int count = 0;
        String[] blackList = {"John Smith", "Jane Doe", "Michael Johnson", "Emily Brown", "William Davis", "Olivia Taylor", "James Wilson", "Sophia Lee", "Benjamin Garcia", "Isabella Martinez", "Daniel Anderson", "Mia Thomas", "David Hernandez", "Ella Perez", "Joseph Green", "Ava Collins", "Matthew Baker", "Chloe Hall", "Andrew Rivera", "Natalie Ramirez"};
        for(int i =0; i<= blackList.length -1;i++){
            if (blackList[i] == name){
                count += 1;
            }
        }
        if (count == 0){
            return true;
        }
        else{
            return false;
        }
    }






    ///////////////////////////////////////////////////////////
//                             Email
    ///////////////////////////////////////////////////////////
    public boolean email_format(String email){
        return email.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
    }









    ///////////////////////////////////////////////////////////
//                             Student Number
    ///////////////////////////////////////////////////////////

    public static boolean student_num_len(int number){
        int length = (int) (Math.log10(number) + 1);
        if (length !=8){
            return false;
        }
        return true;
    }
    public static boolean student_num_year(int number){
        if (number >= 22000000){
            return true;
        }
        else {
            return false;
        }

    }
}
