public class Con_1935_maximumNumberOf_words {
    public int numbersOfWordsYouCanType(String text, String brokenLetters) {
        String str[] = text.split(" ");
        int count = 0;
        for (String a : str) {
            for (Character b : brokenLetters.toCharArray()) {
                if (a.indexOf(b) != -1) {
                    count++;
                    break;
                }

            }


        }
        return str.length - count;
    }


    public static void main(String[] args) {
        String text = "hello world  vgfyty";
        String brokenLetters = "";
        Con_1935_maximumNumberOf_words c = new Con_1935_maximumNumberOf_words();
        int x = c.numbersOfWordsYouCanType(text, brokenLetters);
        System.out.println(x);

    }
}