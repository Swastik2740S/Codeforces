import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        sc.nextLine();
        int count= 0;

        while(testcases-- > 0){
            String s = sc.nextLine();
            switch (s) {
                case "Tetrahedron":
                    count+=4;
                    break;

                case "Cube" :
                    count+=6;
                    break;

                case "Octahedron" :
                    count+=8;
                    break;

                case "Dodecahedron" :
                    count+=12;
                    break;

                case "Icosahedron":
                    count+=20;
                    break;
            
                default:
                    break;
            }
        }

        System.out.println(count);
    }
}
