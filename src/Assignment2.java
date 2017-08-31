/*
Hieu Duong
CSC 201
Assignment 2
Problem 2.14:
(Health application: computing BMI) Body Mass Index (BMI) is a measure of
health on weight. It can be calculated by taking your weight in kilograms and
dividing by the square of your height in meters. Write a program that prompts the
user to enter a weight in pounds and height in inches and displays the BMI. Note
that one pound is 0.45359237 kilograms and one inch is 0.0254 meters.

08/30/2017
*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class Assignment2 {

    public static void main(String[] args)
    {
        System.out.println("This program will calculate the BMI base on the weight in kilograms and the height in meters.");

        //Call method GetWeighValue to get the Weight
        Double Weight = GetWeightValue();

        //Call method GetHeightValue to get the Height
        Double Height = GetHeightValue();

        //Pass the values to the CalculateBMI method and return the result
        CalculateBMI(Weight, Height);
    }

    public static Double GetWeightValue()
    {
        //Create keyboard object
        Scanner keyboard = new Scanner(System.in);

        //Prompt user to enter weight in pounds
        System.out.println("Please enter the weight in pounds: ");
        Double Weight;

        //Check the input value
        //If user enter a letter instead of a number, ask user to enter number only
        try {
            Weight = keyboard.nextDouble();
        }
        catch (Exception e){
            System.out.println("Value is not a number. Please enter number only!");
            Weight = GetWeightValue();
        }

        //Check if number is possitive or not
        //Only accept number that larger than 0
        if(Weight <= 0)
        {
            //Input is invalid, ask user to enter a positive value
            //This will repeat until user enter a valid value
            System.out.println("The weight value is invalid, please enter a different value!");
            Weight = GetWeightValue();
        }

        return  Weight;
    }

    public static Double GetHeightValue()
    {
        //Create keyboard object
        Scanner keyboard = new Scanner(System.in);

        //Prompt user to enter the height in inches
        System.out.println("Please enter the height in inches:");
        Double Height;

        //Check the input value
        //If user enter a letter instead of a number, ask user to enter number only
        try {
            Height = keyboard.nextDouble();
        }
        catch (Exception e){
            System.out.println("Value is not a number. Please enter number only!");
            Height = GetHeightValue();
        }

        //Check if number is possitive or not
        //Only accept number that larger than 0
        if(Height <= 0)
        {
            //Input is invalid, ask user to enter a positive value
            //This will repeat until user enter a valid value
            System.out.println("The height value is invalid, please enter a different value!");
            Height = GetHeightValue();
        }

        return  Height;
    }

    public static void CalculateBMI(Double Weight, Double Height)
    {
        //Convert the weight to kilogram from pounds
        Weight = Weight * 0.45359237;

        //Convert the height to meters
        Height = Height * 0.0254;

        //Calculate the BMI
        Double BMI = Weight/(Math.pow(Height,2));

        //Round double to 1 decimal place
        DecimalFormat df = new DecimalFormat("0.0");

        //Print out the result
        System.out.println("The Weight in kilograms is: "+df.format(Weight) +"kg");
        System.out.println("The Height in meters is: "+df.format(Height) +"m");
        System.out.println("The BMI is: "+df.format(BMI));
    }
}
