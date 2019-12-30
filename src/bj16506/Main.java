package bj16506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c=Integer.parseInt(br.readLine());
        for(int i=0; i<c; i++){
            String input[] = br.readLine().split(" ");
            StringBuffer sb=new StringBuffer();
            sb.append(opcode(input[0])); //opcode
            sb.append("0"); // unused bit
            sb.append(stringTo3bitBin(input[1]));
            sb.append(stringTo3bitBin(input[2]));
            if(sb.toString().charAt(4)=='0'){
                sb.append(stringTo3bitBin(input[3]));
                sb.append("0");
            } else {
                sb.append(stringTo4bitBin(input[3]));
            }
            System.out.println(sb.toString());
        }
    }
    public static String stringTo4bitBin(String input){
        int oprnd=Integer.parseInt(input);
        StringBuffer sb=new StringBuffer();
        if(oprnd<2){
            sb.append("000");
        } else if(oprnd<4){
            sb.append("00");
        } else if(oprnd<8){
            sb.append("0");
        }
        sb.append(Integer.toBinaryString(oprnd));
        return sb.toString();
    }
    public static String stringTo3bitBin(String input){
        int oprnd=Integer.parseInt(input);
        StringBuffer sb=new StringBuffer();
        if(oprnd<2){
            sb.append("00");
        } else if(oprnd<4){
            sb.append("0");
        }
        sb.append(Integer.toBinaryString(oprnd));
        return sb.toString();
    }
    public static String opcode(String input){
        StringBuffer sb=new StringBuffer();
        switch (input){
            case "ADD":
            case "ADDC":
                sb.append("0000");
                if(input.equals("ADD"))
                    sb.append("0");
                else
                    sb.append("1");
                break;
            case "SUB":
            case "SUBC":
                sb.append("0001");
                if(input.equals("SUB"))
                    sb.append("0");
                else
                    sb.append("1");
                break;
            case "MOV":
            case "MOVC":
                sb.append("0010");
                if(input.equals("MOV"))
                    sb.append("0");
                else
                    sb.append("1");
                break;
            case "AND":
            case "ANDC":
                sb.append("0011");
                if(input.equals("AND"))
                    sb.append("0");
                else
                    sb.append("1");
                break;
            case "OR":
            case "ORC":
                sb.append("0100");
                if(input.equals("OR"))
                    sb.append("0");
                else
                    sb.append("1");
                break;
            case "NOT":
                sb.append("01010");
                break;
            case "MULT":
            case "MULTC":
                sb.append("0110");
                if(input.equals("MULT"))
                    sb.append("0");
                else
                    sb.append("1");
                break;
            case "LSFTL":
            case "LSFTLC":
                sb.append("0111");
                if(input.equals("LSFTL"))
                    sb.append("0");
                else
                    sb.append("1");
                break;
            case "LSFTR":
            case "LSFTRC":
                sb.append("1000");
                if(input.equals("LSFTR"))
                    sb.append("0");
                else
                    sb.append("1");
                break;
            case "ASFTR":
            case "ASFTRC":
                sb.append("1001");
                if(input.equals("ASFTR"))
                    sb.append("0");
                else
                    sb.append("1");
                break;
            case "RL":
            case "RLC":
                sb.append("1010");
                if(input.equals("RL"))
                    sb.append("0");
                else
                    sb.append("1");
                break;
            case "RR":
            case "RRC":
                sb.append("1011");
                if(input.equals("RR"))
                    sb.append("0");
                else
                    sb.append("1");
                break;
            default:
                System.out.println("fault");
        }
        return sb.toString();
    }
}
