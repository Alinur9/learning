import org.junit.jupiter.api.Test;

import java.util.List;

class MostPopVdoTest {

    @Test
    void name() {
        String[] creators = {"alice", "bob", "alice", "chris"};
        String[] ids = {"one", "two", "three", "four"};
        int[] views = {5, 10, 5, 4};

        List<List<String>> answer = List.of(List.of("alice", "one"), List.of("bob", "two"));
        evaluate(creators, ids, views,  answer);
    }



    @Test
    void case3() {

        String[] creators = {"a"};
        String[] ids = {"a"};
        int[] views = {0};


        List<List<String>> answer = List.of(List.of("a","a"));

        for (int i = 0; i < 200000;i++) {
            evaluate(creators, ids, views,  answer);
        }
    }



    @Test
    void case2() {

        String[] creators = {"alice","alice","alice"};
        String[] ids = {"a","b","c"};
        int[] views = {1,2,2};


        List<List<String>> answer = List.of(List.of("alice","b"));

        for (int i = 0; i < 200000;i++) {
            evaluate(creators, ids, views,  answer);
        }
    }

    private void evaluate(String[] creators, String[] ids, int[] views, List<List<String>> answer){

        MostPopVdo mostPopVdo = new MostPopVdo();
        List<List<String>> result = mostPopVdo.mostPopularCreator(creators, ids, views);

        System.out.println("Expected: " + answer);
        System.out.println("Result: " + result);

        assert result != null;
        assert result.size() == answer.size();



        for (List<String> ans : answer) {
            boolean matched = false;

            for (List<String> res : result) {
                if (res.size() != ans.size()) break;

                if (res.get(0).equals(ans.get(0)) && res.get(1).equals(ans.get(1)))
                    matched = true;

            }



            if(!matched){
                System.out.printf("Error: \nExpected: %s\t%s\n", ans.get(0), ans.get(1));

            }

            assert matched;
        }


    }
}