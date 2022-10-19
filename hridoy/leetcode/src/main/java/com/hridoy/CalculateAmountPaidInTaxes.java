package com.hridoy;

public class CalculateAmountPaidInTaxes {
    public double calculateTax(int[][] brackets, int income) {
        if(income == 0) return (double)0;
        double tax = 0;
        for(int i = 0; i < brackets.length; i++){
            double tempTax = 0;
            int incomeQualified = 0;

            if( i == 0 && income >= brackets[i][0]){
                tempTax = (double) (brackets[i][0]) * (brackets[i][1]) / 100;
                incomeQualified  += brackets[i][0];
            }else if( i > 0 && income >= brackets[i][0] - brackets[i - 1][0]){

                    tempTax = (double) (brackets[i][0] - brackets[i - 1][0]) * (brackets[i][1]) / 100;
                    incomeQualified += brackets[i][0] - brackets[i - 1][0];
            }else if(income > 0){
                tempTax = (double) (income * brackets[i][1]) / 100;
                incomeQualified += income;
            }
            income -= incomeQualified;
            tax += tempTax;
        }
        return tax;
    }
    public static void main(String[] args) {
        int [][] brackets = {{3,50},{7,10},{12,25}};
        int income = 10;


        CalculateAmountPaidInTaxes obj = new CalculateAmountPaidInTaxes();
        System.out.println(obj.calculateTax(brackets,income));

    }
}
