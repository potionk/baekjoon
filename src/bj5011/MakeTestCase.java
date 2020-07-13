package bj5011;

public class MakeTestCase {
    public static void main(String[] args) {
        for(int i=0; i<1000; i++){
            for(int j=0; j<1000; j++){
                int a=(int)(Math.random()*5);
                if(a==1)
                    System.out.print("#");
                else
                    System.out.print(".");
            }
            System.out.println();
        }
//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j < 100; j++) {
//
//                if ((i == 98 && j == 98) || (i == 98 && j == 99) || (i == 99 && j == 98))
//                    System.out.print("#");
//                else
//                    System.out.print(".");
//            }
//            System.out.println();
//        }

    }
}
