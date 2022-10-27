package diff.medium.contest;

import java.util.ArrayList;
import java.util.List;

public class FindAllPossibleRecipesFromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {


        List<String> totalRecipes = new ArrayList<>();
        int itr =0;
        for (List<String> ingredientsList : ingredients){
            int count = 0;

           for (int i =0; i < supplies.length ;i++ ){
               if ( ingredientsList.contains(supplies[i])){
                   count++;
                   if (count == ingredientsList.size()){
                       totalRecipes.add(recipes[itr]);
                   }
               }
           }
            for (int j =0; j < totalRecipes.size();j++){
                if (ingredientsList.contains(totalRecipes.get(j))){
                    count++;
                    if (count == ingredientsList.size()){
                        totalRecipes.add(recipes[itr]);
                    }
                }
            }
           itr++;
        }
        List<String> possibleRecipes = new ArrayList<>();
        int itr2 =0;
        for (List<String> ingredientsList2 : ingredients  ){
            int count = 0;

            for (int i =0; i < supplies.length ;i++ ){
                if ( ingredientsList2.contains(supplies[i])){
                    count++;
                    if (count == ingredientsList2.size()){
                        possibleRecipes.add(recipes[itr2]);
                    }
                }
            }
            for (int j =0; j < totalRecipes.size();j++){
                if (ingredientsList2.contains(totalRecipes.get(j))){
                    count++;
                    if (count == ingredientsList2.size()){
                        possibleRecipes.add(recipes[itr2]);
                    }
                }
            }
            itr2++;
        }
        return possibleRecipes;
    }
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        List<String> subList1 = new ArrayList<>();
        List<String> subList2 = new ArrayList<>();
        List<String> subList3 = new ArrayList<>();
        List<String> subList4 = new ArrayList<>();
        List<String> subList5 = new ArrayList<>();
        List<String> subList6 = new ArrayList<>();
        List<String> subList7 = new ArrayList<>();
        subList1.add("d");
        subList2.add("hveml");
        subList2.add("f");
        subList2.add("cpivl");
        subList3.add("cpivl");
        subList3.add("zpmcz");
        subList3.add("h");
        subList3.add("e");
        subList3.add("fzjnm");
        subList3.add("ju");
        subList4.add("cpivl");
        subList4.add("hveml");
        subList4.add("zpmcz");
        subList4.add("ju");
        subList4.add("h");
        subList5.add("h");
        subList5.add("fzjnm");
        subList5.add("e");
        subList5.add("q");
        subList5.add("x");
        subList6.add("d");
        subList6.add("hveml");
        subList6.add("cpivl");
        subList6.add("q");
        subList6.add("zpmcz");
        subList6.add("ju");
        subList6.add("e");
        subList6.add("x");
        subList7.add("f");
        subList7.add("hveml");
        subList7.add("cpivl");

        list.add(subList1);
        list.add(subList2);
        list.add(subList3);
        list.add(subList4);
        list.add(subList5);
        list.add(subList6);
        list.add(subList7);

        String[] recipes = {"ju","fzjnm","x","e","zpmcz","h","q"};
        String[] supplies = {"f","hveml","cpivl","d"};

        FindAllPossibleRecipesFromGivenSupplies obj = new FindAllPossibleRecipesFromGivenSupplies();
        System.out.println(obj.findAllRecipes(recipes,list,supplies));



    }
}
