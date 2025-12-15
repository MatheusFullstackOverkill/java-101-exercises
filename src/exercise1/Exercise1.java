package exercise1;

import java.util.HashMap;

/*
    Tem-se um conjunto de dados contendo a altura e o sexo (masculino, feminino) de 10 pessoas.
    Fazer um algoritmo que calcule e escreva:

    A maior e a menor altura do grupo;
    Média de altura dos homens;
    O número de mulheres.
 */

public class Exercise1 {
    private static Person[] sortItemsByHeight(Person[] items) {
        Person[] sortedItems = items.clone();
        HashMap<Integer, Integer> relation = new HashMap<Integer, Integer>();

        for (int i = 0; i < items.length; i++) {
            relation.put(i, i);
        };

        for (int i = 0; i < items.length; i++) {
          Person person = items[i];

          for (int j = 0; j < items.length; j++) {
            Person person2 = items[j];
            
            if (person.getHeight() < person2.getHeight()) {
              int indexAinSortedArray = relation.get(i);
              int indexBinSortedArray = relation.get(j);
              
              if (indexAinSortedArray > indexBinSortedArray) continue;

              sortedItems[indexAinSortedArray] = person2;
              sortedItems[indexBinSortedArray] = person;

              relation.replace(i, indexBinSortedArray);
              relation.replace(j, indexAinSortedArray);
            };
          };
        };

        return sortedItems;
    }

    private static double getMenHeightMedia(Person[] persons) {
        double heightsMedia = 0;

        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getSex() == Sex.MALE) {
                heightsMedia += persons[i].getHeight();
            };
        };

        heightsMedia = heightsMedia / persons.length;

        return heightsMedia;
    }

    private static int getWomansTotal(Person[] persons) {
        int womansTotal = 0;

        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getSex() == Sex.FEMALE) {
                womansTotal += 1;
            };
        };

        return womansTotal;
    }

    public static void main() {
        System.out.println("Exercício 1");

        Person[] people = {
            new Person("Matheus", 1.81, Sex.MALE),
            new Person("Sophia", 1.50, Sex.FEMALE),
            new Person("Paulo", 1.80, Sex.MALE),
            new Person("Sofia", 1.65, Sex.FEMALE),
            new Person("Nosferatu", 2.0, Sex.MALE)
        };

        Person[] sortedPeopleByHeight = sortItemsByHeight(people);
        double menHeightMedia = getMenHeightMedia(sortedPeopleByHeight);
        int womansTotal = getWomansTotal(sortedPeopleByHeight);

        System.out.println("The heighest in the room!: " + sortedPeopleByHeight[0].getNameAndHeight());
        System.out.println("The lowest in the room!: " + sortedPeopleByHeight[sortedPeopleByHeight.length - 1].getNameAndHeight());
        System.out.println("The media of the Mens height: " + menHeightMedia);
        System.out.println("The total of woman: " + womansTotal);
    }
}