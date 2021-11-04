public class ConsignmentGenerator{
    public static void main(String []args){
        
        //assign test numbers here
        
        String carrierName="FreightmateCourierCo", accNum="ABC123";
        Integer digits=10, cIndex= 19604, rangeStart=19000, rangeEnd=20000;

        System.out.println(createNumber(carrierName, accNum, digits,cIndex,rangeStart,rangeEnd));
    }

    public static String createNumber(String carrierName, String accNum, Integer digits, Integer cIndex, Integer rangeStart, Integer rangeEnd){
        //Changing the Carrier name to a prefix
        if(carrierName.equals("FreightmateCourierCo")){
            carrierName= "FMCC";
        }else{
            return "Only available carrier is FreightmateCourierCo. Please try again later."
        }
        
        //numbers three and seven will store the sum of alternate numbers in the consignment index to generate the checksum
        int three=0, seven= 0;
        
        //increment the consignment index as the one provided was used in the previous number
        cIndex+=1;
        
        
        //create a duplicate of consignment index to fetch alternate digits
        int newCIndex= cIndex;
        
        
        //removes the digit in the unit place and adds it to the three variable.
        //dividing the number by 10 basically shifts the digits to the right.
        //next digit will e added to the seven variable
        //repeat till all digits of the number are used.
        while(newCIndex>0) {
        	three+=newCIndex%10;
        	newCIndex= newCIndex/10;
        	seven+=newCIndex%10;
        	newCIndex= newCIndex/10;
        }
        

        
        //convert checksum to string to find the length, then raise 10 to it's power
        //this gives the closest larger base10 number
        //subtracting the variables three and seven from this base10 number will give checksum
        int checksum= (int) Math.pow(10, String.valueOf(checksum).length()) - three -seven;
        
        
        //a new string to store formatted consignment index
        String newIndex= "";
        
        //total length of the consignment index w=is given in digits.
        //String.format allows prepending 0s to the cIndex
        //Also a check for the index being within range is placed here.
        if(cIndex> rangeStart && cIndex <= rangeEnd){
            newIndex= String.format("%0" + digits+ "d", cIndex);
        }else{
            return "Consignment Index out of range."
        }
        
        return carrierName+ accNum+ newIndex+ checksum;
    }
}