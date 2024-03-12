public class SOPeditor {

    private String sop;
    private static String[] splitSOP;
    private static int tabSize = 0;
    public static char[] tabHeader;

    public SOPeditor(String s){
        s = s.toLowerCase();
        s = s.replaceAll("\\s", "");
        sop = s;
        spliter(sop);
        tableSize(s);
    }

    private static void spliter(String s){
        splitSOP = s.split("[+]");

        // System.out.println(splitSOP.length);
        int count = 0;
        for(String a: splitSOP){
            for(int i=0; i<a.length()-1; i++){
                char[] aa = a.toCharArray();
                if(aa[i+1] == '\''){
                    aa[i] = Character.toUpperCase(aa[i]);
                }
                a = new String(aa);
            }
            a = a.replaceAll("\'", "");
            splitSOP[count] = a;
            count++;
        }

        int max=0;
        for(String sop: splitSOP){
            if(sop.length()>max)
                max = sop.length();
        }
    }

    private void tableSize(String s){
        for(char a='a'; a<='z'; a++){
            for(char c: s.toCharArray()){
                if(c == a){
                    tabSize++;
                    break;
                }
            }
        }

        tabHeader = new char[tabSize];
        int i = 0;
        for(char cc = 'a'; cc <= 'z'; cc++){
            for(char c: s.toCharArray()){
                if(cc == c){
                    tabHeader[i] = Character.toUpperCase(cc);
                    i++;
                    break;
                }
            }
        }

        tableMaker.tabHeader = tabHeader;

        new tableMaker(tabSize);
    }

    public static void calculator(int[] arr){
        int flag = 0;
        for(String s: splitSOP){
            int tracker = 1;
            for(char c: s.toCharArray()){
                tracker *= check(c, arr);
            }

            if(tracker == 1){
                flag = 1;
                break;
            }
        }
        
        if(flag == 1)
            System.out.print("1");
        else
            System.out.print("0");
    }

    private static int check(char c, int[] arr){
        for(int i=0; i<tabHeader.length; i++){
            if(tabHeader[i] == Character.toUpperCase(c) && c>='a' && c<='z'){
                return arr[i];
            }else if(tabHeader[i] == Character.toUpperCase(c) && c>='A' && c<='Z'){
                return (arr[i]+1)%2;
            }
        }
        return 0;
    }
}
