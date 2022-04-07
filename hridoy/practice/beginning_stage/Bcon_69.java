public class Bcon_69 {
    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        for (String s1 : title.split(" ")) {
            if (s1.length() > 2) {
             sb.append(Character.toUpperCase(s1.charAt(0))).append(s1.substring(1,s1.length()).toLowerCase());
            }else {
                s1.toLowerCase();
            }
        }
        sb.append(" ");
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Bcon_69 obj = new Bcon_69();
        obj.capitalizeTitle("i love you ");
        System.out.println(obj.toString());

    }
}

